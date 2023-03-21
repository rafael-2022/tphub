package com.dieboldnixdorf.frentecaixa.web;

import java.time.LocalDateTime;
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
import org.springframework.web.bind.annotation.RestController;

import com.dieboldnixdorf.frentecaixa.domain.DnErrorResponse;
import com.dieboldnixdorf.frentecaixa.domain.SQLState42P01Exception;
import com.dieboldnixdorf.frentecaixa.domain.TransacoesPDVMessageType;
import com.dieboldnixdorf.frentecaixa.service.MovimentacoesTransacoesPdvSearchCriteria;
import com.dieboldnixdorf.frentecaixa.service.MovimentacoesTransacoesPdvService;

/**
 * The Class MovimentacoesTransacoesPdvWebController.
 */
@RestController
@ExposesResourceFor(TransacoesPDVMessageType.class)
public class MovimentacoesTransacoesPdvWebController {
	
	/** The max page size. */
	@Value("#{'${spring.data.rest.maxPageSize}'}")
	private Integer maxPageSize;

	/** The movimentacoes transacoes pdv service. */
	@Autowired
	private MovimentacoesTransacoesPdvService movimentacoesTransacoesPdvService;

	/** The entity links. */
	private final EntityLinks entityLinks;
	
	/**
	 * Instantiates a new movimentacoes transacoes pdv web controller.
	 *
	 * @param entityLinks the entity links
	 */
	public MovimentacoesTransacoesPdvWebController(final EntityLinks entityLinks) {
		this.entityLinks = entityLinks;
	}
	
	/**
	 * Consulta transacoes PDV online.
	 *
	 * @param codigoLoja the codigo loja
	 * @param dataHoraInicial the data hora inicial
	 * @param dataHoraFinal the data hora final
	 * @param paginaInicial the pagina inicial
	 * @param paginaFinal the pagina final
	 * @return the http entity
	 * @throws SQLState42P01Exception the SQLState42P01 exception
	 */
	@GetMapping(path="/movimentacoes/transacoesPDVOnline/{codigoLoja}/{dataHoraInicial}/{dataHoraFinal}/{paginaInicial}/{paginaFinal}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Transactional
	HttpEntity<List<TransacoesPDVMessageType>> consultaTransacoesPDVOnline(final @PathVariable("codigoLoja") String codigoLoja, 
			final @PathVariable("dataHoraInicial") @DateTimeFormat(iso=ISO.DATE_TIME) LocalDateTime dataHoraInicial, final @PathVariable("dataHoraFinal") @DateTimeFormat(iso=ISO.DATE_TIME) LocalDateTime dataHoraFinal,
			final @PathVariable("paginaInicial") Integer paginaInicial, final @PathVariable("paginaFinal") Integer paginaFinal) throws SQLState42P01Exception {
		final MovimentacoesTransacoesPdvSearchCriteria criteria = new MovimentacoesTransacoesPdvSearchCriteria(codigoLoja, dataHoraInicial, dataHoraFinal,
				paginaInicial, paginaFinal);
		final List<TransacoesPDVMessageType> messages = new ArrayList<TransacoesPDVMessageType>();
		try {
			final List<TransacoesPDVMessageType> pageRequest = this.movimentacoesTransacoesPdvService.findTransacoesPDV(criteria, new PageRequest(paginaInicial, maxPageSize));
			if (!CollectionUtils.isEmpty(pageRequest)) {
				final Integer totalPage = pageRequest.get(0).getCabecalho().getTotalPaginas().intValue();  
				if (paginaFinal.compareTo(totalPage) >= 0) {
					throw new IllegalArgumentException("Resource retrieved is out of bound : " + paginaFinal);
				}
				if (paginaInicial.compareTo(paginaFinal) == 0) {
					messages.addAll(this.movimentacoesTransacoesPdvService.findTransacoesPDV(criteria, new PageRequest(paginaInicial, maxPageSize)));
				} else {
					final Integer endExclusive = paginaFinal + 1;
					IntStream.range(paginaInicial, endExclusive).forEach(
							nbr -> {
									messages.addAll(this.movimentacoesTransacoesPdvService.findTransacoesPDV(criteria, new PageRequest(nbr, maxPageSize)));
							});
				}
			}
		} catch (final Exception ex) {
			if (ex instanceof InvalidDataAccessResourceUsageException) {
				throw new SQLState42P01Exception("Invalid data access resource usage:  Invalid Transaction State");
			}
			throw new RuntimeException(ex);
		}
		//final Resources<TransacoesPDVMessageType> resources = new Resources<TransacoesPDVMessageType>(messages);
		//resources.add(this.entityLinks.linkToCollectionResource(TransacoesPDVMessageType.class));
		return new ResponseEntity<List<TransacoesPDVMessageType>>(messages, HttpStatus.OK);
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
		error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error.setError("412 Precondition failed");
		error.setMessage(ex.getMessage());
		return new ResponseEntity<DnErrorResponse>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}