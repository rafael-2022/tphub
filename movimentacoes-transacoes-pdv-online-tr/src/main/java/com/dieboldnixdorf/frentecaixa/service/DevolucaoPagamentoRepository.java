package com.dieboldnixdorf.frentecaixa.service;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.dieboldnixdorf.frentecaixa.domain.DevolucaoPagamento;
import com.dieboldnixdorf.frentecaixa.domain.DevolucaoPagamentoPK;


interface DevolucaoPagamentoRepository extends Repository<DevolucaoPagamento, DevolucaoPagamentoPK> {
	

	Page<DevolucaoPagamento> findAll(final Pageable pageable);
	

	@Query(value = "SELECT contadorregistrointerno, codigormsproduto, eanproduto, quantidadeformaspgto, categoriaformapgto, valorformapgto, horaminutoevento, 0 as pk from public.fnc_devonline_pgto(:codigoLoja, :matricula, :dateStart, :dateEnd)", 
        nativeQuery=true)
	List<DevolucaoPagamento> findPagamentoByCodigoLojaAndMatriculaAndDataExtracao(final @Param("codigoLoja") Integer codigoLoja,  
																					final @Param("matricula") String matricula, 
																					final @Param("dateStart") Long date, 
																					final @Param("dateEnd") Long danfe);

}
