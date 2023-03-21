package com.dieboldnixdorf.frentecaixa.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.dieboldnixdorf.frentecaixa.domain.ClienteLojaMessageType;

/**
 * The Interface DadosClientesLojaService.
 */
public interface DadosClientesLojaService {

	/**
	 * Find dados clientes loja.
	 *
	 * @param criteria the criteria
	 * @param pageable the pageable
	 * @return the list
	 */
	List<ClienteLojaMessageType> findDadosClientesLoja(final DadosClientesLojaSearchCriteria criteria, final Pageable pageable);

}
