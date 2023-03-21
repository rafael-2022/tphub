package com.dieboldnixdorf.frentecaixa.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.dieboldnixdorf.frentecaixa.domain.DescontoPK;
import com.dieboldnixdorf.frentecaixa.domain.Ejuserstruct1;

/**
 * The Interface DescontosRebaixaPrecoRepository.
 */
interface DescontosRebaixaPrecoRepository extends Repository<Ejuserstruct1, DescontoPK> {
	
	/**
	 * Find all.
	 *
	 * @param pageable the pageable
	 * @return the page
	 */
	Page<Ejuserstruct1> findAll(final Pageable pageable);
	
	/**
	 * Find by codigo loja and data extracao.
	 *
	 * @param codigoLoja the codigo loja
	 * @param dataExtracao the data extracao
	 * @param pageable the pageable
	 * @return the page
	 */
	@Query(value = "SELECT hostid, termnmbr, transnmbr, cshrnmbr, sznumber1, ulfield1, ulfield2, lfield1, "
			+ " datahora, szuserext, sznumber2, linenmbr from public.fnc_descontorebaixapreco(:dataExtracao, :codigoLoja) "
		+ " ORDER BY datahora /*{#pageable}*/ ",
		countQuery = "SELECT count(*) from (SELECT hostid, termnmbr, transnmbr, cshrnmbr, sznumber1, ulfield1, "
				+ " ulfield2, lfield1, datahora, szuserext, sznumber2, linenmbr from public.fnc_descontorebaixapreco(:dataExtracao, :codigoLoja)) as qtd ",
        nativeQuery=true
    )
	@Cacheable("byDescontosRebaixaPreco")
	Page<Ejuserstruct1> findByCodigoLojaAndDataExtracao(final @Param("codigoLoja") Integer codigoLoja, final @Param("dataExtracao") String dataExtracao, final Pageable pageable);

}
