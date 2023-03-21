package com.dieboldnixdorf.frentecaixa.web;

import java.time.LocalDate;
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
import com.dieboldnixdorf.frentecaixa.domain.TipoConciliacaoSvaMessage;
import com.dieboldnixdorf.frentecaixa.service.MovimentacoesTransacoesPdvSearchCriteria;
import com.dieboldnixdorf.frentecaixa.service.ConciliacaoSvaService;

/**
 * The Class MovimentacoesTransacoesPdvWebController.
 */
@RestController
@ExposesResourceFor(TipoConciliacaoSvaMessage.class)
public class ConciliacaoSvaWebController {

    /**
     * The max page size.
     */
    @Value("#{'${spring.data.rest.maxPageSize}'}")
    private Integer maxPageSize;

    /**
     * The movimentacoes transacoes pdv service.
     */
    @Autowired
    private ConciliacaoSvaService movimentacoesTransacoesPdvService;

    /**
     * The entity links.
     */
    private final EntityLinks entityLinks;

    /**
     * Instantiates a new movimentacoes transacoes pdv web controller.
     *
     * @param entityLinks the entity links
     */
    public ConciliacaoSvaWebController(final EntityLinks entityLinks) {
        this.entityLinks = entityLinks;
    }

    /**
     * Consulta transacoes PDV.
     *
     * @param codigoLoja the codigo loja
     * @param dataExtracao the data extracao
     * @param paginaInicial the pagina inicial
     * @param paginaFinal the pagina final
     * @return the http entity
     * @throws SQLState42P01Exception the SQLState42P01 exception
     */
    @GetMapping(path = "/movimentacoes/conciliacaoSva/{codigoLoja}/{dataExtracao}/{paginaInicial}/{paginaFinal}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Transactional(readOnly = true)
    HttpEntity<TipoConciliacaoSvaMessage> consultaTransacoesPDV(final @PathVariable("codigoLoja") String codigoLoja,
            final @PathVariable("dataExtracao") @DateTimeFormat(iso = ISO.DATE) LocalDate dataExtracao,
            final @PathVariable("paginaInicial") Integer paginaInicial, final @PathVariable("paginaFinal") Integer paginaFinal) throws SQLState42P01Exception {
        final MovimentacoesTransacoesPdvSearchCriteria criteria = new MovimentacoesTransacoesPdvSearchCriteria(codigoLoja, dataExtracao, paginaInicial, paginaFinal);
        final TipoConciliacaoSvaMessage message = new TipoConciliacaoSvaMessage();
        try {
            message.setCabecalho(this.movimentacoesTransacoesPdvService.getCabecalho(criteria, new PageRequest(paginaInicial, maxPageSize)));
            message.setDetalhe(this.movimentacoesTransacoesPdvService.findTransacoesPDV(criteria, new PageRequest(paginaInicial, maxPageSize)));

            if (!CollectionUtils.isEmpty(message.getDetalhe())) {
                final Integer totalPage = Long.valueOf(message.getCabecalho().getTotalPaginas()).intValue();
                if (paginaFinal.compareTo(totalPage) >= 0) {
                    throw new IllegalArgumentException("Resource retrieved is out of bound : " + paginaFinal);
                }
                if (paginaInicial.compareTo(paginaFinal) == 0) {
                    message.getDetalhe().clear();
                    message.getDetalhe().addAll(this.movimentacoesTransacoesPdvService.findTransacoesPDV(criteria, new PageRequest(paginaInicial, maxPageSize)));
                } else {
                    final Integer endExclusive = paginaFinal + 1;
                    IntStream.range(paginaInicial, endExclusive).forEach(
                            nbr -> {
                                // System.out.println(">>>002");
                                message.getDetalhe().addAll(this.movimentacoesTransacoesPdvService.findTransacoesPDV(criteria, new PageRequest(nbr, maxPageSize)));
                            });
                }
            }
        } catch (final Exception ex) {
            if (ex instanceof InvalidDataAccessResourceUsageException) {
                throw new SQLState42P01Exception("Invalid data access resource usage:  Invalid Transaction State");
            }
            throw new RuntimeException(ex);
        }
        //final Resources<TipoConciliacaoSvaMessage> resources = new Resources<TipoConciliacaoSvaMessage>(messages);
        //resources.add(this.entityLinks.linkToCollectionResource(TipoConciliacaoSvaMessage.class));
        return new ResponseEntity<TipoConciliacaoSvaMessage>(message, HttpStatus.OK);
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
