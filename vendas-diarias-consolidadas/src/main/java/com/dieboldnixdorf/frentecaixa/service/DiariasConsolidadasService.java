package com.dieboldnixdorf.frentecaixa.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.dieboldnixdorf.frentecaixa.domain.DiariasConsolidadasMessageType;

/**
 * The Interface DiariasConsolidadasService.
 */
public interface DiariasConsolidadasService {

	/**
	 * Find diarias consolidadas.
	 *
	 * @param criteria the criteria
	 * @param pageable the pageable
	 * @return the list
	 */
	List<DiariasConsolidadasMessageType> findDiariasConsolidadas(final DiariasConsolidadasSearchCriteria criteria, final Pageable pageable);

}
