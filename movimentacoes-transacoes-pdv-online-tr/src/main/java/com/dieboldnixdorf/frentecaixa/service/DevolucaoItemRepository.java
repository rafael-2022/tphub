package com.dieboldnixdorf.frentecaixa.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.dieboldnixdorf.frentecaixa.domain.DevolucaoItem;
import com.dieboldnixdorf.frentecaixa.domain.DevolucaoItemPK;


interface DevolucaoItemRepository extends Repository<DevolucaoItem, String> {
	

	Page<DevolucaoItem> findAll(final Pageable pageable);
	

	@Query(value = "SELECT contadorregistrointerno, codigormsproduto, eanproduto, codigosetor, devolucaocomcupom, valoraliquotafiscal, valortotalitemimpostodebitado, numeromatricula, valortotalitembasecalcpis, valortotalitempis, valortotalitembasecalccofins, valortotalitemcofins, tiposervico, codigoservico, codigofornecedor, quantidadeitensdevolvidos, valorunitariodevolvidos, valortotaldevolvido, horaminutoevento, status, 0 as pk from public.fnc_devonline_item(:codigoLoja, :matricula, :dateStart, :dateEnd)", 
        nativeQuery=true)
	List<DevolucaoItem> findItemByCodigoLojaAndMatriculaAndDataExtracao(final @Param("codigoLoja") Integer codigoLoja,  
																		final @Param("matricula") String matricula, 
																		final @Param("dateStart") Long date, 
																		final @Param("dateEnd") Long danfe);

}
