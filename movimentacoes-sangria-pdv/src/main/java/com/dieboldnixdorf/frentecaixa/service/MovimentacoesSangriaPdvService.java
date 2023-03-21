package com.dieboldnixdorf.frentecaixa.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.dieboldnixdorf.frentecaixa.domain.SangriaPDVMessageType;

/**
 * The Interface MovimentacoesSangriaPdvService.
 */
public interface MovimentacoesSangriaPdvService {

	/**
	 * Find movimentacoes sangria pdv.
	 *
	 * @param criteria the criteria
	 * @param pageable the pageable
	 * @return the list
	 */
	List<SangriaPDVMessageType> findMovimentacoesSangriaPdv(final MovimentacoesSangriaPdvSearchCriteria criteria, final Pageable pageable);

}
