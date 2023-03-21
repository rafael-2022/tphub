package com.dieboldnixdorf.frentecaixa.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.dieboldnixdorf.frentecaixa.domain.VendaSetorHoraMessageType;

/**
 * The Interface VendasSetorHoraService.
 */
public interface VendasSetorHoraService {

	/**
	 * Find vendas setor hora.
	 *
	 * @param criteria the criteria
	 * @param pageable the pageable
	 * @return the list
	 */
	List<VendaSetorHoraMessageType> findVendasSetorHora(final VendasSetorHoraSearchCriteria criteria, final Pageable pageable);

}
