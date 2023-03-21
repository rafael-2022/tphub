package com.dieboldnixdorf.frentecaixa.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.dieboldnixdorf.frentecaixa.domain.OperadoraLojaMessageType;

/**
 * The Interface DadosOperadoraLojaService.
 */
public interface DadosOperadoraLojaService {

	/**
	 * Find dados operadora loja.
	 *
	 * @param criteria the criteria
	 * @param pageable the pageable
	 * @return the list
	 */
	List<OperadoraLojaMessageType> findDadosOperadoraLoja(final DadosOperadoraLojaSearchCriteria criteria, final Pageable pageable);

}
