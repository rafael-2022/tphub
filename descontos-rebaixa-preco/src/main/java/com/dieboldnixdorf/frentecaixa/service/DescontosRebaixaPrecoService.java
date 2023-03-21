package com.dieboldnixdorf.frentecaixa.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.dieboldnixdorf.frentecaixa.domain.RebaixaPrecoMessageType;


/**
 * The Interface DescontosRebaixaPrecoService.
 */
public interface DescontosRebaixaPrecoService {

	/**
	 * Find descontos rebaixa preco.
	 *
	 * @param criteria the criteria
	 * @param pageable the pageable
	 * @return the list
	 */
	List<RebaixaPrecoMessageType> findDescontosRebaixaPreco(final DescontosRebaixaPrecoSearchCriteria criteria, final Pageable pageable);

}
