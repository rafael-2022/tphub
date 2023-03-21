package com.dieboldnixdorf.frentecaixa.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.dieboldnixdorf.frentecaixa.domain.Ejitem;
import com.dieboldnixdorf.frentecaixa.domain.FiscalPK;

/**
 * The Interface TotalPisCofinsPdvRepository.
 */
interface TotalPisCofinsPdvRepository extends Repository<Ejitem, FiscalPK> {
	
	/**
	 * Find all.
	 *
	 * @param pageable the pageable
	 * @return the page
	 */
	Page<Ejitem> findAll(final Pageable pageable);
	
	/**
	 * Find by codigo loja and data extracao.
	 *
	 * @param codigoLoja the codigo loja
	 * @param dataExtracao the data extracao
	 * @param pageable the pageable
	 * @return the page
	 */
	@Query(value = "SELECT storenmbr, date, termnmbr, mrpprice4, mrpprice5 from public.fnc_valortotalpiscofins(:dataExtracao, :codigoLoja) "  
		+ " ORDER BY storenmbr,termnmbr /*{#pageable}*/ ",
		countQuery = "SELECT count(*) from (SELECT storenmbr, date, termnmbr, mrpprice4, "
				+ " mrpprice5 from public.fnc_valortotalpiscofins(:dataExtracao, :codigoLoja)) as qtd ", 
        nativeQuery=true
    )
	@Cacheable("byTotalPisCofinsPdv")
	Page<Ejitem> findByCodigoLojaAndDataExtracao(final @Param("codigoLoja") Integer codigoLoja, final @Param("dataExtracao") String dataExtracao, final Pageable pageable);

}
