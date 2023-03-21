package com.dieboldnixdorf.frentecaixa.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.dieboldnixdorf.frentecaixa.domain.Ejheader;
import com.dieboldnixdorf.frentecaixa.domain.MovimentacaoPK;

/**
 * The Interface MovimentacoesTransacoesPdvRepository.
 */
interface MovimentacoesTransacoesPdvRepository extends Repository<Ejheader, MovimentacaoPK> {
	
	/**
	 * Find all.
	 *
	 * @param pageable the pageable
	 * @return the page
	 */
	Page<Ejheader> findAll(final Pageable pageable);
	
	/**
	 * Find local venda by codigo loja and data extracao.
	 *
	 * @param codigoLoja the codigo loja
	 * @param dataExtracao the data extracao
	 * @param pageable the pageable
	 * @return the page
	 */
	//@Query(value = "SELECT ostorenmbr, datahora_sod, datahora_eod, termnmbr, transnmbr, mngrovnmbr from public.fnc_bufferticket_movto(:dataExtracao, :codigoLoja)"
	//	+ " ORDER BY datahora_sod /*{#pageable}*/ ",
        //nativeQuery=true
        @Query(value = "select  storenmbr as ostorenmbr, termnmbr, transnmbr, datahora_sod ,datahora_eod, transsva , nsupedido , numpedido , tiporeg , cupomfiscal as mngrovnmbr, tipoitem ,idterm, status, codloja , codcliente , codvend,sequencia from fnc_SVA_Movto(:dataExtracao, :codigoLoja)"
		+ " ORDER BY datahora_sod /*{#pageable}*/ ",
        nativeQuery=true
    )
	@Cacheable("byLocalVenda")
	Page<Ejheader> findLocalVendaByCodigoLojaAndDataExtracao(final @Param("codigoLoja") Integer codigoLoja, final @Param("dataExtracao") String dataExtracao, final Pageable pageable);
	
}
