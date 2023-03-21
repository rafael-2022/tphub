package com.dieboldnixdorf.frentecaixa.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.dieboldnixdorf.frentecaixa.domain.TransacoesECFMessageType;

/**
 * The Interface TrasacoesECFService.
 */
public interface TransacoesECFService {

	/**
	 * Find transacoes ECF.
	 *
	 * @param criteria the criteria
	 * @param pageable the pageable
	 * @return the list
	 */
	List<TransacoesECFMessageType> findTransacoesECF(final TransacoesECFSearchCriteria criteria, final Pageable pageable);

}
