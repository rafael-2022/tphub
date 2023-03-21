package com.dieboldnixdorf.frentecaixa.web;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.data.domain.PageRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Metered;
import com.codahale.metrics.annotation.Timed;
import com.dieboldnixdorf.frentecaixa.domain.DnErrorResponse;
import com.dieboldnixdorf.frentecaixa.domain.SQLState42P01Exception;
import com.dieboldnixdorf.frentecaixa.domain.VendaAssistidaDevolucaoMessageType;
import com.dieboldnixdorf.frentecaixa.service.HibernateInterceptor;
import com.dieboldnixdorf.frentecaixa.service.VendaAssistidaDevolucaoSearchCriteria;
import com.dieboldnixdorf.frentecaixa.service.VendaAssistidaDevolucaoService;
import com.ryantenney.metrics.annotation.Counted;

/**
 * The Class DadosDevolucaoWebController.
 */
@RestController
@RequestMapping("/")
@ExposesResourceFor(VendaAssistidaDevolucaoMessageType.class)
public class VendaAssistidaDevolucaoWebController {

	/** The max page size. */
	@Value("#{'${spring.data.rest.maxPageSize}'}")
	private Integer maxPageSize;

	/** The dados devolucao service. */
	@Autowired
	private VendaAssistidaDevolucaoService vendaAssistidaDevolucaoService;

	/** The entity links. */
	private final EntityLinks entityLinks;
	
	/** The hibernate interceptor. */
	@Autowired
	private HibernateInterceptor hibernateInterceptor;
	
	/**
	 * Instantiates a new dados devolucao web controller.
	 *
	 * @param entityLinks the entity links
	 */
	public VendaAssistidaDevolucaoWebController(final EntityLinks entityLinks) {
		this.entityLinks = entityLinks;
	}
	
	/**
	 * Consulta troca devolucao.
	 *
	 * @param codigoLoja the codigo loja
	 * @param dataExtracao the data extracao
	 * @param paginaInicial the pagina inicial
	 * @param paginaFinal the pagina final
	 * @return the http entity
	 */
	@Timed(name = "trocasDevolucaoViewTimer", absolute=true)
	@Metered(name = "trocasDevolucaoViewMeter", absolute=true)
	@Counted(name = "trocasDevolucaoViewCount", monotonic=true)
	@GetMapping(path="/{codigoLoja}/{dataExtracao}/{paginaInicial}/{paginaFinal}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Transactional(readOnly = true)
	HttpEntity<List<VendaAssistidaDevolucaoMessageType>> consultaTrocaDevolucao(final @PathVariable("codigoLoja") String codigoLoja, 
			final @PathVariable("dataExtracao") @DateTimeFormat(iso=ISO.DATE) LocalDate dataExtracao,
			final @PathVariable("paginaInicial") Integer paginaInicial, final @PathVariable("paginaFinal") Integer paginaFinal) throws SQLState42P01Exception {
		
		final VendaAssistidaDevolucaoSearchCriteria criteria = new VendaAssistidaDevolucaoSearchCriteria(codigoLoja, dataExtracao, paginaInicial, paginaFinal);
		final List<VendaAssistidaDevolucaoMessageType> messages = new ArrayList<VendaAssistidaDevolucaoMessageType>();
		
		try {
			final List<VendaAssistidaDevolucaoMessageType> pageRequest = this.vendaAssistidaDevolucaoService.findDadosDevolucao(criteria, new PageRequest(paginaInicial, maxPageSize));

			if (!CollectionUtils.isEmpty(pageRequest)) {
				final Integer totalPage = pageRequest.get(0).getCabecalho().getTotalPaginas().intValue();  
				if (paginaFinal.compareTo(totalPage) >= 0) {
					throw new IllegalArgumentException("Resource retrieved is out of bound : " + paginaFinal);
				}
			
				if (paginaInicial.compareTo(paginaFinal) == 0) {
					messages.addAll(this.vendaAssistidaDevolucaoService.findDadosDevolucao(criteria, new PageRequest(paginaInicial, maxPageSize)));
				} else {
					final Integer endExclusive = paginaFinal + 1;
					IntStream.range(paginaInicial, endExclusive).forEach(
							nbr -> {
									messages.addAll(this.vendaAssistidaDevolucaoService.findDadosDevolucao(criteria, new PageRequest(nbr, maxPageSize)));
							});
				}
			}
		} catch (final Exception ex) {
			if (ex instanceof InvalidDataAccessResourceUsageException) {
				ex.printStackTrace();
				throw new SQLState42P01Exception("Relation (Database schema)  " + hibernateInterceptor.getStoreIpTPLinux()  +" does not exist");
			}
			throw new RuntimeException(ex);
		}
		//final Resources<VendaAssisistidaDevolucaoMessageType> resources = new Resources<VendaAssisistidaDevolucaoMessageType>(messages);
		//resources.add(this.entityLinks.linkToCollectionResource(VendaAssisistidaDevolucaoMessageType.class));
		return new ResponseEntity<List<VendaAssistidaDevolucaoMessageType>>(messages, HttpStatus.OK);
	}

	/**
	 * Exception handler.
	 *
	 * @param ex the ex
	 * @return the response entity
	 */
	@ExceptionHandler(SQLState42P01Exception.class)
	public ResponseEntity<DnErrorResponse> exceptionHandler(final Exception ex) {
		final DnErrorResponse error = new DnErrorResponse();
		error.setStatus(HttpStatus.PRECONDITION_FAILED.value());
		error.setError("412 Precondition failed");
		error.setMessage(ex.getMessage());
		return new ResponseEntity<DnErrorResponse>(error, HttpStatus.OK);
	}
	
}