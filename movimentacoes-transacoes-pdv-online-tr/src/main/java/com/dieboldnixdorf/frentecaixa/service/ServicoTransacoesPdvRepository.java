package com.dieboldnixdorf.frentecaixa.service;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.dieboldnixdorf.frentecaixa.domain.Ejmedia;
import com.dieboldnixdorf.frentecaixa.domain.Ejservico;
import com.dieboldnixdorf.frentecaixa.domain.RegServicoPK;

/**
 * The Interface ServicoTransacoesPdvRepository.
 */
interface ServicoTransacoesPdvRepository extends Repository<Ejservico, RegServicoPK> {
	
	/**
	 * Find all.
	 *
	 * @param pageable the pageable
	 * @return the page
	 */
	Page<Ejservico> findAll(final Pageable pageable);
	

	@Query(value = "SELECT rectype,descricaoservico,valorservico,numerocartaopresente,numerocelularrecarga,nomeoperadoratelefonia,codigoServico,datahora_sod,datahora_eod,codigofornecedor,tiposervico, 0 as pk,seq  from public.fnc_vendaonlinetab_regserv(:date, :codigoLoja, :termnmbr, :transnmbr, :danfe, 0) ", 
        nativeQuery=true)
	@Cacheable("byServico")
	List<Ejservico> findServicoByCodigoLojaAndDataExtracao(final @Param("codigoLoja") Integer codigoLoja,  final @Param("transnmbr") Integer transnmbr, 
			final @Param("termnmbr") Integer termnmbr, final @Param("date") String date, final @Param("danfe") String danfe);

}
