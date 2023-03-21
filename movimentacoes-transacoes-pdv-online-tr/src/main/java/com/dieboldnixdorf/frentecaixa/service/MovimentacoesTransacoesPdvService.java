package com.dieboldnixdorf.frentecaixa.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.dieboldnixdorf.frentecaixa.domain.TransacoesPDVMessageType;
import com.dieboldnixdorf.frentecaixa.payloads.DevolucaoReprocessamentoResponse;

/**
 * The Interface MovimentacoesTransacoesPdvService.
 */
public interface MovimentacoesTransacoesPdvService {

	/**
	 * Find transacoes PDV.
	 *
	 * @param criteria the criteria
	 * @param pageable the pageable
	 * @return the list
	 */
	List<TransacoesPDVMessageType> findTransacoesPDV(final MovimentacoesTransacoesPdvSearchCriteria criteria, final Pageable pageable);
	
	List<TransacoesPDVMessageType> findReprocessamento(final MovimentacoesTransacoesPdvSearchCriteria criteria, final Pageable pageable);
	
	List<DevolucaoReprocessamentoResponse> findDevolucaoReprocessamento(final MovimentacoesTransacoesPdvSearchCriteria criteria, final Pageable pageable);

}
