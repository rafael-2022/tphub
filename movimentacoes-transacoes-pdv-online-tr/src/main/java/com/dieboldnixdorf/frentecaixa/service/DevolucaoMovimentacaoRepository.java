package com.dieboldnixdorf.frentecaixa.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.dieboldnixdorf.frentecaixa.domain.DevolucaoMovimentacao;
import com.dieboldnixdorf.frentecaixa.domain.DevolucaoMovimentacaoPK;

/**
 * The Interface DevolucaoMovimentacaoRepository.
 */
interface DevolucaoMovimentacaoRepository extends Repository<DevolucaoMovimentacao, DevolucaoMovimentacaoPK> {
	
	
	
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
