package com.dieboldnixdorf.frentecaixa.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.dieboldnixdorf.frentecaixa.domain.TEFPromocaoMessageType;

/**
 * The Interface DescontosTefPromocaoService.
 */
public interface DescontosTefPromocaoService {

	/**
	 * Find descontos tef promocao.
	 *
	 * @param criteria the criteria
	 * @param pageable the pageable
	 * @return the list
	 */
	List<TEFPromocaoMessageType> findDescontosTefPromocao(final DescontosTefPromocaoSearchCriteria criteria, final Pageable pageable);

}
