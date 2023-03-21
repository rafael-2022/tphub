package com.dieboldnixdorf.frentecaixa.service;

import com.dieboldnixdorf.frentecaixa.domain.TipoCabecalho;
import com.dieboldnixdorf.frentecaixa.domain.TipoConciliacaoSvaPayload;
import java.util.List;

import org.springframework.data.domain.Pageable;


/**
 * The Interface MovimentacoesTransacoesPdvService.
 */
public interface ConciliacaoSvaService {

	/**
	 * Find transacoes PDV.
	 *
	 * @param criteria the criteria
	 * @param pageable the pageable
	 * @return the list
	 */
	List<TipoConciliacaoSvaPayload> findTransacoesPDV(final MovimentacoesTransacoesPdvSearchCriteria criteria, final Pageable pageable);

        TipoCabecalho getCabecalho(final MovimentacoesTransacoesPdvSearchCriteria criteria, final Pageable pageable);
}
