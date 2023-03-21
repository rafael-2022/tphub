package com.dieboldnixdorf.frentecaixa.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.dieboldnixdorf.frentecaixa.domain.OperacoesPDVBalcaoMessageType;

/**
 * The Interface MovimentacoesPdvBalcaoService.
 */
public interface MovimentacoesPdvBalcaoService {

	/**
	 * Find movimentacoes pdv balcao.
	 *
	 * @param criteria the criteria
	 * @param pageable the pageable
	 * @return the list
	 */
	List<OperacoesPDVBalcaoMessageType> findMovimentacoesPdvBalcao(final MovimentacoesPdvBalcaoSearchCriteria criteria, final Pageable pageable);

}
