package com.dieboldnixdorf.frentecaixa.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.dieboldnixdorf.frentecaixa.domain.ProdutividadeMessageType;

/**
 * The Interface DadosDevolucaoService.
 */
public interface ProdutividadeService {

	/**
	 * Find dados devolucao.
	 *
	 * @param criteria the criteria
	 * @param pageable the pageable
	 * @return the list
	 */
	List<ProdutividadeMessageType> findDadosDevolucao(final ProdutividadeSearchCriteria criteria, final Pageable pageable);

}
