package com.dieboldnixdorf.frentecaixa.service;

import java.util.Date;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.dieboldnixdorf.frentecaixa.domain.Ejmedia;

/**
 * The Interface DadosDevolucaoRepository.
 */
interface DadosDevolucaoRepository extends Repository<Ejmedia, String> {
	
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
	@Query(value = "SELECT cshrnmbr, hostid, mediaamnt, mdesc, altcurrtend, eftdata1, eftdata2, eftdata3, eftdata4 from public.fnc_trocadevolucao(:dataExtracao, :codigoLoja) "
			+ " ORDER BY cshrnmbr /*{#pageable}*/ ",
			countQuery = "SELECT count(*) from (SELECT cshrnmbr, hostid, mediaamnt, mdesc, altcurrtend, eftdata1, "
					+ " eftdata2, eftdata3, eftdata4 from public.fnc_trocadevolucao(:dataExtracao, :codigoLoja)) as qtd ",
            nativeQuery=true
    )
	@Cacheable("byDadosDevolucao")
	Page<Ejmedia> findByCodigoLojaAndDataExtracao(final @Param("codigoLoja") Integer codigoLoja, final @Param("dataExtracao") Date dataExtracao, final Pageable pageable);

}
