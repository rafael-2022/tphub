package com.dieboldnixdorf.frentecaixa.service;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.dieboldnixdorf.frentecaixa.domain.Ejitem;
import com.dieboldnixdorf.frentecaixa.domain.Reg20PK;

/**
 * The Interface ItemTransacoesPdvRepository.
 */
interface ItemTransacoesPdvRepository extends Repository<Ejitem, Reg20PK> {
	
	/**
	 * Find all.
	 *
	 * @param pageable the pageable
	 * @return the page
	 */
	Page<Ejitem> findAll(final Pageable pageable);
	
	/**
	 * Find item transacao by codigo loja and data extracao.
	 *
	 * @param codigoLoja the codigo loja
	 * @param transnmbr the transnmbr
	 * @param termnmbr the termnmbr
	 * @param date the date
	 * @param danfe the fiscal authorization code
	 * @return the list
	 */
	@Query(value = "SELECT termnmbr, storenmbr, transnmbr, datahora_sod, datahora_eod, rectype, entrynmbr, seq, plunmbr, print1text, qty1, price1, pludesc, sumamtdisc, amtsold, deptnmbr, "
			+ " mrpprice1, mrpprice2, :danfe as loyaltycardid, imei, 0 as pk  from public.fnc_vendaonline_reg20(:date, :codigoLoja, :termnmbr, :transnmbr, :danfe, 0) "
			+ " ORDER BY datahora_sod ", 
			countQuery = "SELECT count(*) from (SELECT termnmbr, storenmbr, transnmbr, datahora_sod, datahora_eod, rectype, entrynmbr, seq, plunmbr, print1text, qty1, price1, pludesc, sumamtdisc, amtsold, deptnmbr, "
			+ " mrpprice1, mrpprice2 from public.fnc_vendaonline_reg20(:date, :codigoLoja, :termnmbr, :transnmbr, :danfe)) as qtd ", 
        nativeQuery=true)
	@Cacheable("byItemTransacoesPdv")
	List<Ejitem> findItemTransacaoByCodigoLojaAndDataExtracao(final @Param("codigoLoja") Integer codigoLoja, 
			final @Param("transnmbr") Integer transnmbr, final @Param("termnmbr") Integer termnmbr, final @Param("date") String date, final @Param("danfe") String danfe);

}
