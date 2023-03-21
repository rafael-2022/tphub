package com.dieboldnixdorf.frentecaixa.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.dieboldnixdorf.frentecaixa.domain.Ejitem;
import com.dieboldnixdorf.frentecaixa.domain.VdaPK;

/**
 * The Interface DiariasConsolidadasRepository.
 */
interface DiariasConsolidadasRepository extends Repository<Ejitem, VdaPK> {
	
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
	@Query(value = "SELECT plunmbr, termnmbr, amtsold, amtmkdn, qtysold, qtymkdn from public.fnc_vendaconsolidada(:dataExtracao, :codigoLoja) "
			+ " ORDER BY plunmbr,termnmbr /*{#pageable}*/ ",
			countQuery = "SELECT count(*) from (SELECT plunmbr, termnmbr, amtsold, amtmkdn, qtysold, "
					+ " qtymkdn from public.fnc_vendaconsolidada(:dataExtracao, :codigoLoja)) as qtd",
            nativeQuery=true
    )
	@Cacheable("byDiariasConsolidadas")
	Page<Ejitem> findByCodigoLojaAndDataExtracao(final @Param("codigoLoja") Integer codigoLoja, final @Param("dataExtracao") String dataExtracao, final Pageable pageable);

}
