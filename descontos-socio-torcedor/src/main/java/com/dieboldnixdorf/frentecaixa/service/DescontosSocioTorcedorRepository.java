package com.dieboldnixdorf.frentecaixa.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.dieboldnixdorf.frentecaixa.domain.ContabilPK;
import com.dieboldnixdorf.frentecaixa.domain.Ejitem;

/**
 * The Interface DescontosSocioTorcedorRepository.
 */
interface DescontosSocioTorcedorRepository extends Repository<Ejitem, ContabilPK> {
	
	/**
	 * Find all.
	 *
	 * @param pageable the pageable
	 * @return the page
	 */
	Page<Ejitem> findAll(final Pageable pageable);
	
	/**
	 * Find by codigo loja and data extracao.
	 *
	 * @param codigoLoja the codigo loja
	 * @param dataExtracao the data extracao
	 * @param pageable the pageable
	 * @return the page
	 */
	@Query(value = "SELECT print1text, termnmbr, transnmbr, amtsold, qtysold, cshrnmbr, print2text, storenmbr, datahora, linenmbr from public.fnc_descontosociotorcedor(:dataExtracao, :codigoLoja) "
			+ " ORDER BY datahora /*{#pageable}*/ ",
		countQuery = "SELECT count(*) from (SELECT print1text, termnmbr, transnmbr, amtsold, qtysold, cshrnmbr, print2text, "
				+ " storenmbr, datahora, linenmbr from public.fnc_descontosociotorcedor(:dataExtracao, :codigoLoja)) as qtd ",
        nativeQuery=true
    )
	@Cacheable("byDescontosSocioTorcedor")
	Page<Ejitem> findByCodigoLojaAndDataExtracao(final @Param("codigoLoja") Integer codigoLoja, final @Param("dataExtracao") String dataExtracao, final Pageable pageable);

}
