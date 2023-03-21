package com.dieboldnixdorf.frentecaixa.service;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.dieboldnixdorf.frentecaixa.domain.Ejcombustivel;
import com.dieboldnixdorf.frentecaixa.domain.RegCombustivelPK;

/**
 * The Interface FormaPagamentoTransacoesPdvRepository.
 */
interface CombustivelTransacoesPdvRepository extends Repository<Ejcombustivel, RegCombustivelPK> {
	
	/**
	 * Find all.
	 *
	 * @param pageable the pageable
	 * @return the page
	 */
	Page<Ejcombustivel> findAll(final Pageable pageable);
	

	@Query(value = "SELECT rectype,codrmsproduto,qtdevendida,valorencerranteinicial,valorencerrantefinal,idabastecimento,numerobicoabastecimento,numerobombaabastecimento,numerotanqueabastecimento,datahora_sod,datahora_eod, 0 as pk, seq  from public.fnc_vendaonlinetab_regcomb(:date, :codigoLoja, :termnmbr, :transnmbr, :danfe, 0) ", 
        nativeQuery=true)
	@Cacheable("byCombustivel")
	List<Ejcombustivel> findCombustivelByCodigoLojaAndDataExtracao(final @Param("codigoLoja") Integer codigoLoja,  final @Param("transnmbr") Integer transnmbr, 
			final @Param("termnmbr") Integer termnmbr, final @Param("date") String date, final @Param("danfe") String danfe);

}
