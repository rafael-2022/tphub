package com.dieboldnixdorf.frentecaixa.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.dieboldnixdorf.frentecaixa.domain.DevolucaoContabilMessageType;

/**
 * The Interface DevolucaoContabilService.
 */
public interface DevolucaoContabilService {

	/**
	 * Find devolucao contabil.
	 *
	 * @param criteria the criteria
	 * @param pageable the pageable
	 * @return the list
	 */
	List<DevolucaoContabilMessageType> findDevolucaoContabil(final DevolucaoContabilSearchCriteria criteria, final Pageable pageable);

}
