package com.dieboldnixdorf.frentecaixa.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.dieboldnixdorf.frentecaixa.domain.TrocaDevolucaoMessageType;

/**
 * The Interface DadosDevolucaoService.
 */
public interface DadosDevolucaoService {

	/**
	 * Find dados devolucao.
	 *
	 * @param criteria the criteria
	 * @param pageable the pageable
	 * @return the list
	 */
	List<TrocaDevolucaoMessageType> findDadosDevolucao(final DadosDevolucaoSearchCriteria criteria, final Pageable pageable);

}
