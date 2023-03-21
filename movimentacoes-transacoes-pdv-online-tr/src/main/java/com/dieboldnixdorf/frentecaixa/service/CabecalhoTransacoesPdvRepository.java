package com.dieboldnixdorf.frentecaixa.service;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.dieboldnixdorf.frentecaixa.domain.Ejheader1;
import com.dieboldnixdorf.frentecaixa.domain.Reg10PK;

/**
 * The Interface CabecalhoTransacoesPdvRepository.
 */
interface CabecalhoTransacoesPdvRepository extends Repository<Ejheader1, Reg10PK> {
	
	/**
	 * Find all.
	 *
	 * @param pageable the pageable
	 * @return the page
	 */
	Page<Ejheader1> findAll(final Pageable pageable);
	
	/**
	 * Find cabecalho transacao by codigo loja and data extracao.
	 *
	 * @param codigoLoja the codigo loja
	 * @param transnmbr the transnmbr
	 * @param termnmbr the termnmbr
	 * @param date the date
	 * @param danfe the fiscal authorization code
	 * @return the list
	 */
	@Query(value = "SELECT storenmbr, mngrovnmbr, transnmbr, termnmbr, datahora, rectype, print1text, loyaltycardid, cshrnmbr, print2text, disc_empxnmbr, disc_custnmbr, :danfe as loyaltycardid2, drtoperador, naturezaoperacao, tipoemissao, codigopreorder, tiposaida, codigoparceiro, nomeparceiro, barcodepedido, siglaloja, nomeoperador, perfiloperador, tipopdv, 0 as pk from public.fnc_vendaonlinetab_reg10(:date, :codigoLoja, :termnmbr, :transnmbr, :danfe, 0)", 
        nativeQuery=true)
	@Cacheable("byCabecalhoTransacao")
	List<Ejheader1> findCabecalhoTransacaoByCodigoLojaAndDataExtracao(final @Param("codigoLoja") Integer codigoLoja, final @Param("transnmbr") Integer transnmbr, 
			final @Param("termnmbr") Integer termnmbr, final @Param("date") String date, final @Param("danfe") String danfe);

}
