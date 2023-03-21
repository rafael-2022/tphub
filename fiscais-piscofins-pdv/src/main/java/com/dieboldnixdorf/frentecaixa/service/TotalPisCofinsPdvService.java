package com.dieboldnixdorf.frentecaixa.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.dieboldnixdorf.frentecaixa.domain.TotalPisCofinsPDVMessageType;

/**
 * The Interface TotalPisCofinsPdvService.
 */
public interface TotalPisCofinsPdvService {

	/**
	 * Find total Pis/Cofins PDV.
	 *
	 * @param criteria the criteria
	 * @param pageable the pageable
	 * @return the list
	 */
	List<TotalPisCofinsPDVMessageType> findTotalPisCofinsPdv(final TotalPisCofinsPdvSearchCriteria criteria, final Pageable pageable);

}
