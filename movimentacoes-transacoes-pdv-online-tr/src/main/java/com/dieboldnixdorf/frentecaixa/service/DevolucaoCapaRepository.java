package com.dieboldnixdorf.frentecaixa.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.dieboldnixdorf.frentecaixa.domain.DevolucaoCapa;
import com.dieboldnixdorf.frentecaixa.domain.DevolucaoCapaPK;



interface DevolucaoCapaRepository extends Repository<DevolucaoCapa, DevolucaoCapaPK> {
	

	Page<DevolucaoCapa> findAll(final Pageable pageable);
	

	@Query(value = "SELECT codigoloja, cnpjemissor, datadevolucao, numerodocumentofiscal, seriedocumentofiscal, numerodanfe, transacaoloja, codigoterminalvenda, clientecpf_nf, clientecpf_meucarrefour, recepcionistadrt, codigoeventodevolucao, tipoevento, datavendaorigem, numerodocumentofiscalorigem, seriedocumentofiscalorigem, codigoterminalvendaorigem, transacaolojaorigem, numerodanfeorigem, clientecpf_nforigem, clientecpf_meucarrefourorigem, numpreorder, codvendedor, operacaovenda,clientecpf_nforigem,clientecpf_meucarrefourorigem,numerodanfeorigem, pdvresgate, transacaoresgate, datahoraresgate, operadorresgate, valorresgate,  0 as pk from public.fnc_devonline_capa(:codigoLoja, :matricula, :dateStart, :dateEnd)", 
        nativeQuery=true)
	List<DevolucaoCapa> findCapaByCodigoLojaAndMatriculaAndDataExtracao(final @Param("codigoLoja") Integer codigoLoja,  
																		final @Param("matricula") String matricula, 
																		final @Param("dateStart") Long date, 
																		final @Param("dateEnd") Long danfe);

}
