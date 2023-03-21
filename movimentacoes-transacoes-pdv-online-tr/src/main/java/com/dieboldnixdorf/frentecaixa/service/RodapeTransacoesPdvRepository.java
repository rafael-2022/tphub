package com.dieboldnixdorf.frentecaixa.service;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.dieboldnixdorf.frentecaixa.domain.Ejtrailer;
import com.dieboldnixdorf.frentecaixa.domain.Reg50PK;

/**
 * The Interface RodapeTransacoesPdvRepository.
 */
interface RodapeTransacoesPdvRepository extends Repository<Ejtrailer, Reg50PK> {
	
	/**
	 * Find all.
	 *
	 * @param pageable the pageable
	 * @return the page
	 */
	Page<Ejtrailer> findAll(final Pageable pageable);
	
	/**
	 * Find rodape transacao by codigo loja and data extracao.
	 *
	 * @param codigoLoja the codigo loja
	 * @param transnmbr the transnmbr
	 * @param termnmbr the termnmbr
	 * @param date the date
	 * @param danfe the fiscal authorization code
	 * @return the list
	 */
	@Query(value = " SELECT transnmbr, termnmbr, rectype, totalvat, totalaos, totalrounding, datahora_sod, datahora_eod, :danfe as loyaltycardid, 0 as pk, valortrocodigital, valortrocodoacao  from public.fnc_vendaonlinetab_reg50(:date, :codigoLoja, :termnmbr, :transnmbr, :danfe, 0) ", 
        nativeQuery=true)
	@Cacheable("byRodapeTransacao")
	List<Ejtrailer> findRodapeTransacaoByCodigoLojaAndDataExtracao(final @Param("codigoLoja") Integer codigoLoja, final @Param("transnmbr") Integer transnmbr, 
			final @Param("termnmbr") Integer termnmbr, final @Param("date") String date, final @Param ("danfe") String danfe);

}
