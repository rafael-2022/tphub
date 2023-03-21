package com.dieboldnixdorf.frentecaixa.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.dieboldnixdorf.frentecaixa.domain.Ejtrailer;

/**
 * The Interface VendasContabilControleRepository.
 */
interface VendasContabilControleRepository extends Repository<Ejtrailer, String> {
	
	/**
	 * Find all.
	 *
	 * @param pageable the pageable
	 * @return the page
	 */
	Page<Ejtrailer> findAll(final Pageable pageable);
	
	/**
	 * Find by codigo loja and data extracao.
	 *
	 * @param codigoLoja the codigo loja
	 * @param dataExtracao the data extracao
	 * @return the ejtrailer
	 */
	@Query(value = "SELECT date, totalvat, totalaos, totalmanualdisc, totalpoints, totalmkdn, seq from public.fnc_vendacontabil_ctrl(:dataExtracao, :codigoLoja) ",
            nativeQuery=true
    )
	@Cacheable("byVendasContabilControle")
	Ejtrailer findByCodigoLojaAndDataExtracao(final @Param("codigoLoja") Integer codigoLoja, final @Param("dataExtracao") String dataExtracao);

}
