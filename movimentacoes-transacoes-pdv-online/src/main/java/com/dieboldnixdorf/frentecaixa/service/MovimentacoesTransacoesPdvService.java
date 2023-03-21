package com.dieboldnixdorf.frentecaixa.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.dieboldnixdorf.frentecaixa.domain.TransacoesPDVMessageType;

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

}
