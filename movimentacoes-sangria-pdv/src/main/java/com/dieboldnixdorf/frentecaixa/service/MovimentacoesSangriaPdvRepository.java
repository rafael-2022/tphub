package com.dieboldnixdorf.frentecaixa.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.dieboldnixdorf.frentecaixa.domain.Ejuserstruct1;

/**
 * The Interface MovimentacoesSangriaPdvRepository.
 */
interface MovimentacoesSangriaPdvRepository extends Repository<Ejuserstruct1, Integer> {
	
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
	@Query(value = "SELECT transnmbr, storenmbr, datahora, termnmbr, cshrnmbr, sznumber1, sznumber2, lfield2, "
			+ " ulfield1, functype, szuserext from public.fnc_sangria(:dataExtracao, :codigoLoja) "
			+ " ORDER BY datahora /*{#pageable}*/ ",
			countQuery = "SELECT count(*) from (SELECT transnmbr, storenmbr, datahora, termnmbr, cshrnmbr, "
					+ " sznumber1, sznumber2, lfield2, ulfield1, functype, szuserext from public.fnc_sangria(:dataExtracao, :codigoLoja)) as qtd",
            nativeQuery=true
    )
	@Cacheable("byMovimentacoesSangriaPdv")
	Page<Ejuserstruct1> findByCodigoLojaAndDataExtracao(final @Param("codigoLoja") Integer codigoLoja, final @Param("dataExtracao") String dataExtracao, final Pageable pageable);

}
