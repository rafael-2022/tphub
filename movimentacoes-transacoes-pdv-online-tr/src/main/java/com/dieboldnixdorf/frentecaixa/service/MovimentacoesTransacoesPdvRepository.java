package com.dieboldnixdorf.frentecaixa.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.dieboldnixdorf.frentecaixa.domain.DevolucaoMovimentacao;
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
	 * Find local venda by codigo loja and data extracao and data hora.
	 *
	 * @param codigoLoja the codigo loja
	 * @param dataExtracao the data extracao
	 * @param dataHoraInicial the data hora inicial
	 * @param dataHoraFinal the data hora final
	 * @param pageable the pageable
	 * @return the page
	 */
	@Query(value = "SELECT ostorenmbr, datahora_sod, datahora_eod, termnmbr, transnmbr, mngrovnmbr, drwrnmbr, loyaltycardid, loyaltycardid as loyaltycardid2, odataproc, seq as pk from public.fnc_vendaonlinetab_movto(:dataExtracao, :codigoLoja, :dataHoraInicial, :dataHoraFinal)"
			+ " ORDER BY datahora_sod, loyaltycardid /*{#pageable}*/  ",
        nativeQuery=true
	)
	Page<Ejheader> findLocalVendaByCodigoLojaAndDataExtracaoAndDataHora(final @Param("codigoLoja") Integer codigoLoja, 
																		final @Param("dataExtracao") String dataExtracao, 
																		final @Param("dataHoraInicial") Timestamp dataHoraInicial,
																		final @Param("dataHoraFinal") Timestamp dataHoraFinal, 
																		final Pageable pageable);
	
	
	@Query(value = "SELECT ostorenmbr, datahora_sod, datahora_eod, termnmbr, transnmbr, mngrovnmbr, drwrnmbr, loyaltycardid, loyaltycardid as loyaltycardid2, odataproc, seq as pk from public.fnc_vendaonlinetab_repro(:dataExtracao, :codigoLoja, :pdv, :transacao, :danfe, :tipo)"
			+ " ORDER BY datahora_sod, loyaltycardid /*{#pageable}*/  ",
        nativeQuery=true
	)
	Page<Ejheader> findLocalVendaByReprocessamento(final @Param("dataExtracao") String dataExtracao,
												   final @Param("codigoLoja") Integer codigoLoja,
												   final @Param("pdv") Integer pdv,
												   final @Param("transacao") Integer transacao,
												   final @Param("danfe") String danfe,
												   final @Param("tipo") Integer tipo,
												   final Pageable pageable);
	
	@Query(value = "SELECT storenmbr,matricula,bdate,bdatepdv from public.fnc_devonline_repro(:dataExtracao, :codigoLoja, :pdv, :danfe, :tipo)"
			+ " ORDER BY storenmbr,matricula  ",
        nativeQuery=true
	)
	List<DevolucaoMovimentacao> findLocalDevolucaoByReprocessamento(final @Param("dataExtracao") String dataExtracao,
												   final @Param("codigoLoja") Integer codigoLoja,
												   final @Param("pdv") Integer pdv,
												   final @Param("danfe") String danfe,
												   final @Param("tipo") Integer tipo);
	
	
	
}
