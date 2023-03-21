package com.dieboldnixdorf.frentecaixa.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.dieboldnixdorf.frentecaixa.domain.EjitemL;

/**
 * The Interface DadosClientesLojaLRepository.
 */
interface DadosClientesLojaLRepository extends Repository<EjitemL, Integer> {
	
	/**
	 * Find all.
	 *
	 * @param pageable the pageable
	 * @return the page
	 */
	Page<EjitemL> findAll(final Pageable pageable);
	
	/**
	 * Find by codigo loja and data extracao.
	 *
	 * @param codigoLoja the codigo loja
	 * @param dataExtracao the data extracao
	 * @param pageable the pageable
	 * @return the page
	 */
	@Query(value = "SELECT storenmbr, date from public.fnc_dadosclientes_l(:dataExtracao, :codigoLoja) "
			+ " ORDER BY storenmbr /*{#pageable}*/ ",
			countQuery = "SELECT count(*) from (SELECT storenmbr, date from public.fnc_dadosclientes_l(:dataExtracao, :codigoLoja)) as qtd ", 
	        nativeQuery=true
	    )
	@Cacheable("dadosClientesLojaL")
	Page<EjitemL> findByCodigoLojaAndDataExtracao(final @Param("codigoLoja") Integer codigoLoja, final @Param("dataExtracao") String dataExtracao, final Pageable pageable);

	/**
	 * Find cliente total by storenmbr and date.
	 *
	 * @param storenmbr the storenmbr
	 * @param date the date
	 * @return the long
	 */
	@Query(value = "SELECT * from public.fnc_dadosclientes_qtd_cliente_total(:date, :storenmbr) ",  
            nativeQuery=true
    )
	@Cacheable("byClienteTotal")
	Long findClienteTotalByStoreNmbrAndDate(final @Param("storenmbr") Integer storenmbr, final @Param("date") String date);

	/**
	 * Find clientes perifericos by storenmbr and date.
	 *
	 * @param storenmbr the storenmbr
	 * @param date the date
	 * @return the long
	 */
	@Query(value = "SELECT * from public.fnc_dadosclientes_qtd_cliente_perifericos(:date, :storenmbr) ",
            nativeQuery=true
    )
	@Cacheable("byClientesPerifericos")
	Long findClientesPerifericosByStoreNmbrAndDate(final @Param("storenmbr") Integer storenmbr, final @Param("date") String date);

}
