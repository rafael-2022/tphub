package com.dieboldnixdorf.frentecaixa.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.dieboldnixdorf.frentecaixa.domain.VendaContabilMessageType;

/**
 * The Interface VendasContabilService.
 */
public interface VendasContabilService {

	/**
	 * Find vendas contabil.
	 *
	 * @param criteria the criteria
	 * @param pageable the pageable
	 * @return the list
	 */
	List<VendaContabilMessageType> findVendasContabil(final VendasContabilSearchCriteria criteria, final Pageable pageable);

}
