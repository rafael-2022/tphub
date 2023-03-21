package com.dieboldnixdorf.frentecaixa.service;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.dieboldnixdorf.frentecaixa.domain.Ejdrogaria;
import com.dieboldnixdorf.frentecaixa.domain.RegDrogariaPK;

/**
 * The Interface DrogariaTransacoesPdvRepository.
 */
interface DrogariaTransacoesPdvRepository extends Repository<Ejdrogaria, RegDrogariaPK> {
	
	/**
	 * Find all.
	 *
	 * @param pageable the pageable
	 * @return the page
	 */
	Page<Ejdrogaria> findAll(final Pageable pageable);
	

	@Query(value = "SELECT rectype,codrmsproduto,qtdevendida,codigopbm,valorpbm,numeroprevendapbm,codigoautorizacaopbm,numeropedidopbm,datahora_sod,datahora_eod, 0 as pk,seq  from public.fnc_vendaonlinetab_regdrog(:date, :codigoLoja, :termnmbr, :transnmbr, :danfe, 0) ", 
        nativeQuery=true)
	@Cacheable("byDrogaria")
	List<Ejdrogaria> findDrogariaByCodigoLojaAndDataExtracao(final @Param("codigoLoja") Integer codigoLoja,  final @Param("transnmbr") Integer transnmbr, 
			final @Param("termnmbr") Integer termnmbr, final @Param("date") String date, final @Param("danfe") String danfe);

}
