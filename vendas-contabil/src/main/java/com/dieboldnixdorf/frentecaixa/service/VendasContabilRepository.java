package com.dieboldnixdorf.frentecaixa.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.dieboldnixdorf.frentecaixa.domain.ContabilPK;
import com.dieboldnixdorf.frentecaixa.domain.Ejmedia;

/**
 * The Interface VendasContabilRepository.
 */
interface VendasContabilRepository extends Repository<Ejmedia, ContabilPK> {
	
	/**
	 * Find all.
	 *
	 * @param pageable the pageable
	 * @return the page
	 */
	Page<Ejmedia> findAll(final Pageable pageable);
	
	/**
	 * Find by codigo loja and data extracao.
	 *
	 * @param codigoLoja the codigo loja
	 * @param dataExtracao the data extracao
	 * @param pageable the pageable
	 * @return the page
	 */
	@Query(value = "SELECT termnmbr, cshrnmbr, mdesc, mediaamnt from public.fnc_vendacontabil(:dataExtracao, :codigoLoja) "
			+ " ORDER BY termnmbr,cshrnmbr,mdesc /*{#pageable}*/ ",
			countQuery = "SELECT count(*) from (SELECT termnmbr, cshrnmbr, mdesc, mediaamnt from public.fnc_vendacontabil(:dataExtracao, :codigoLoja)) as qtd ",
            nativeQuery=true
    )
	@Cacheable("byVendasContabil")
	Page<Ejmedia> findByCodigoLojaAndDataExtracao(final @Param("codigoLoja") Integer codigoLoja, final @Param("dataExtracao") String dataExtracao, final Pageable pageable);

}
