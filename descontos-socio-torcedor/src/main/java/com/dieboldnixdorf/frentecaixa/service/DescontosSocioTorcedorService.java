package com.dieboldnixdorf.frentecaixa.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.dieboldnixdorf.frentecaixa.domain.SocioTorcedorMessageType;

/**
 * The Interface DescontosSocioTorcedorService.
 */
public interface DescontosSocioTorcedorService {

	/**
	 * Find descontos socio torcedor.
	 *
	 * @param criteria the criteria
	 * @param pageable the pageable
	 * @return the list
	 */
	List<SocioTorcedorMessageType> findDescontosSocioTorcedor(final DescontosSocioTorcedorSearchCriteria criteria, final Pageable pageable);

}
