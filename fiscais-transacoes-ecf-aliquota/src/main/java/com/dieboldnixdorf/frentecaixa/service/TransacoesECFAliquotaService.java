package com.dieboldnixdorf.frentecaixa.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.dieboldnixdorf.frentecaixa.domain.TransacoesECFAliquotaMessageType;

/**
 * The Interface TransacoesECFAliquotaService.
 */
public interface TransacoesECFAliquotaService {

	/**
	 * Find transacoes ECF aliquota.
	 *
	 * @param criteria the criteria
	 * @param pageable the pageable
	 * @return the list
	 */
	List<TransacoesECFAliquotaMessageType> findTransacoesECFAliquota(final TransacoesECFAliquotaSearchCriteria criteria, final Pageable pageable);

}
