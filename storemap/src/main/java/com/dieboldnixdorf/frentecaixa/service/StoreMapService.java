package com.dieboldnixdorf.frentecaixa.service;

import com.dieboldnixdorf.frentecaixa.domain.StoremapDto;

/**
 * The Interface StoreMapService.
 */
public interface StoreMapService {

	/**
	 * Find store map by codigo loja.
	 *
	 * @param criteria the criteria
	 * @return the storemap dto
	 */
	StoremapDto findStoreMapByCodigoLoja(final StoreMapSearchCriteria criteria);

	/**
	 * Find store map by loja.
	 *
	 * @param loja the loja
	 * @return the storemap dto
	 */
	StoremapDto findStoreMapByLoja(final String loja);

}
