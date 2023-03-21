package com.dieboldnixdorf.frentecaixa.service;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.dieboldnixdorf.frentecaixa.domain.Ejmedia;
import com.dieboldnixdorf.frentecaixa.domain.Reg40PK;

/**
 * The Interface FormaPagamentoTransacoesPdvRepository.
 */
interface FormaPagamentoTransacoesPdvRepository extends Repository<Ejmedia, Reg40PK> {
	
	/**
	 * Find all.
	 *
	 * @param pageable the pageable
	 * @return the page
	 */
	Page<Ejmedia> findAll(final Pageable pageable);
	
	/**
	 * Find forma pagamento by codigo loja and data extracao.
	 *
	 * @param codigoLoja the codigo loja
	 * @param transnmbr the transnmbr
	 * @param termnmbr the termnmbr
	 * @param date the date
	 * @param danfe the fiscal authorization code
	 * @return the list
	 */
	@Query(value = "SELECT rectype, omediaamnt, linenmbr, mdesc, discountgrpident, userlong, datahora_sod, datahora_eod, transnmbr, termnmbr, ordem, :danfe as loyaltycardid, bandeiracartao, codigoautorizacao, doc, tipovenda, numerocartao, qtdeparcelas, 0 as pk  from public.fnc_vendaonline_reg40(:date, :codigoLoja, :termnmbr, :transnmbr, :danfe, 0) ", 
        nativeQuery=true)
	@Cacheable("byFormaPagamento")
	List<Ejmedia> findFormaPagamentoByCodigoLojaAndDataExtracao(final @Param("codigoLoja") Integer codigoLoja,  final @Param("transnmbr") Integer transnmbr, 
			final @Param("termnmbr") Integer termnmbr, final @Param("date") String date, final @Param("danfe") String danfe);

}
