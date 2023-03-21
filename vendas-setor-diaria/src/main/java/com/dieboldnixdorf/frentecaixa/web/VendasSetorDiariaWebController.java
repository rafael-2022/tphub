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
import org.springframework.hateoas.Resources;
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
import com.dieboldnixdorf.frentecaixa.domain.VendaSetorDiariaMessageType;
import com.dieboldnixdorf.frentecaixa.service.HibernateInterceptor;
import com.dieboldnixdorf.frentecaixa.service.VendasSetorDiariaSearchCriteria;
import com.dieboldnixdorf.frentecaixa.service.VendasSetorDiariaService;
import com.ryantenney.metrics.annotation.Counted;

/**
 * The Class VendasSetorDiariaWebController.
 */
@RestController
@RequestMapping("/vendas/vendaSetorDiaria")
@ExposesResourceFor(VendaSetorDiariaMessageType.class)
public class VendasSetorDiariaWebController {
	
	/** The max page size. */
	@Value("#{'${spring.data.rest.maxPageSize}'}")
	private Integer maxPageSize;

	/** The vendas setor diaria service. */
	@Autowired
	private VendasSetorDiariaService vendasSetorDiariaService;

	/** The entity links. */
	private final EntityLinks entityLinks;
	
	/** The hibernate interceptor. */
	@Autowired
	private HibernateInterceptor hibernateInterceptor;
	
	/**
	 * Instantiates a new vendas setor diaria web controller.
	 *
	 * @param entityLinks the entity links
	 */
	public VendasSetorDiariaWebController(final EntityLinks entityLinks) {
		this.entityLinks = entityLinks;
	}
	
	/**
	 * Consulta venda setor diaria.
	 *
	 * @param codigoLoja the codigo loja
	 * @param dataExtracao the data extracao
	 * @param paginaInicial the pagina inicial
	 * @param paginaFinal the pagina final
	 * @return the http entity
	 */
	@Timed(name = "vendaSetorDiariaViewTimer", absolute=true)
	@Metered(name = "vendaSetorDiariaViewMeter", absolute=true)
	@Counted(name = "vendaSetorDiariaViewCount", monotonic=true)
	@GetMapping(path="/{codigoLoja}/{dataExtracao}/{paginaInicial}/{paginaFinal}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Transactional(readOnly = true)
	HttpEntity<List<VendaSetorDiariaMessageType>> consultaVendaSetorDiaria(final @PathVariable("codigoLoja") String codigoLoja, 
			final @PathVariable("dataExtracao") @DateTimeFormat(iso=ISO.DATE) LocalDate dataExtracao,
			final @PathVariable("paginaInicial") Integer paginaInicial, final @PathVariable("paginaFinal") Integer paginaFinal) throws SQLState42P01Exception {
		final VendasSetorDiariaSearchCriteria criteria = new VendasSetorDiariaSearchCriteria(codigoLoja, dataExtracao, paginaInicial, paginaFinal);
		final List<VendaSetorDiariaMessageType> messages = new ArrayList<VendaSetorDiariaMessageType>();
		try {
			final List<VendaSetorDiariaMessageType> pageRequest = this.vendasSetorDiariaService.findVendasSetorDiaria(criteria, new PageRequest(paginaInicial, maxPageSize));
			if (!CollectionUtils.isEmpty(pageRequest)) {
				final Integer totalPage = pageRequest.get(0).getCabecalho().getTotalPaginas().intValue();  
				if (paginaFinal.compareTo(totalPage) >= 0) {
					throw new IllegalArgumentException("Resource retrieved is out of bound : " + paginaFinal);
				}
				if (paginaInicial.compareTo(paginaFinal) == 0) {
					messages.addAll(this.vendasSetorDiariaService.findVendasSetorDiaria(criteria, new PageRequest(paginaInicial, maxPageSize)));
				} else {
					final Integer endExclusive = paginaFinal + 1;
					IntStream.range(paginaInicial, endExclusive).forEach(
							nbr -> {
									messages.addAll(this.vendasSetorDiariaService.findVendasSetorDiaria(criteria, new PageRequest(nbr, maxPageSize)));
							});
				}
			}
		} catch (final Exception ex) {
			if (ex instanceof InvalidDataAccessResourceUsageException) {
				throw new SQLState42P01Exception("Relation (Database schema)  " + hibernateInterceptor.getEsquemaVendas() + " does not exist");
			}
			throw new RuntimeException(ex);
		}
		//final Resources<VendaSetorDiariaMessageType> resources = new Resources<VendaSetorDiariaMessageType>(messages);
		//resources.add(this.entityLinks.linkToCollectionResource(VendaSetorDiariaMessageType.class));
		return new ResponseEntity<List<VendaSetorDiariaMessageType>>(messages, HttpStatus.OK);
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