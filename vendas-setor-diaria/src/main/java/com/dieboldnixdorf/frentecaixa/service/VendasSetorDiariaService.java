package com.dieboldnixdorf.frentecaixa.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.dieboldnixdorf.frentecaixa.domain.VendaSetorDiariaMessageType;

/**
 * The Interface VendasSetorDiariaService.
 */
public interface VendasSetorDiariaService {

	/**
	 * Find vendas setor diaria.
	 *
	 * @param criteria the criteria
	 * @param pageable the pageable
	 * @return the list
	 */
	List<VendaSetorDiariaMessageType> findVendasSetorDiaria(final VendasSetorDiariaSearchCriteria criteria, final Pageable pageable);

}
