package com.dieboldnixdorf.frentecaixa.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.dieboldnixdorf.frentecaixa.domain.VendaAssistidaDevolucaoMessageType;

/**
 * The Interface DadosDevolucaoService.
 */
public interface VendaAssistidaDevolucaoService {

	/**
	 * Find dados devolucao.
	 *
	 * @param criteria the criteria
	 * @param pageable the pageable
	 * @return the list
	 */
	List<VendaAssistidaDevolucaoMessageType> findDadosDevolucao(final VendaAssistidaDevolucaoSearchCriteria criteria, final Pageable pageable);

}
