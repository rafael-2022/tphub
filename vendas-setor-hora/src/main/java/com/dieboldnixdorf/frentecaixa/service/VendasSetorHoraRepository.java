package com.dieboldnixdorf.frentecaixa.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.dieboldnixdorf.frentecaixa.domain.Ejitem;
import com.dieboldnixdorf.frentecaixa.domain.VendaPK;

/**
 * The Interface VendasSetorHoraRepository.
 */
interface VendasSetorHoraRepository extends Repository<Ejitem, VendaPK> {
	
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
	 * @param hora the hora
	 * @param pageable the pageable
	 * @return the page
	 */
	@Query(value = "SELECT storenmbr, date, deptnmbr, amtsold, qtysold from public.fnc_vendasetor(:dataExtracao, :codigoLoja, :hora) "
		+ " ORDER BY deptnmbr,storenmbr,date /*{#pageable}*/ ",
		countQuery = "SELECT count(*) from (SELECT storenmbr, date, deptnmbr, amtsold, "
				+ " qtysold from public.fnc_vendasetor(:dataExtracao, :codigoLoja, :hora)) as qtd",
        nativeQuery=true
    )
	@Cacheable("byVendasSetorHora")
	Page<Ejitem> findByCodigoLojaAndDataExtracao(final @Param("codigoLoja") Integer codigoLoja, final @Param("dataExtracao") String dataExtracao, final @Param("hora") String hora, final Pageable pageable);
	
	/**
	 * Find quantidade cliente by setor nmbr and date and dept nmbr.
	 *
	 * @param storenmbr the storenmbr
	 * @param date the date
	 * @param deptnmbr the deptnmbr
	 * @param hora the hora
	 * @return the long
	 */
	@Query(value = "SELECT * from public.fnc_vendasetor_qtd_cliente_setor(:date, :storenmbr, :hora, :deptnmbr)",
            nativeQuery=true
    )
	@Cacheable("byQuantidadeClienteSetor")
	Long findQuantidadeClienteBySetorNmbrAndDateAndDeptNmbr(final @Param("storenmbr") Integer storenmbr, final @Param("date") String date, final @Param("deptnmbr") String deptnmbr, final @Param("hora") String hora);

	/**
	 * Find quantidade clientes perifericos by setor nmbr and date and dept nmbr.
	 *
	 * @param storenmbr the storenmbr
	 * @param date the date
	 * @param deptnmbr the deptnmbr
	 * @param hora the hora
	 * @return the long
	 */
	@Query(value = "SELECT * from public.fnc_vendasetor_qtd_cliente_perifericos_setor(:date, :storenmbr, :hora, :deptnmbr) ",
            nativeQuery=true
    )
	@Cacheable("byQuantidadeClientesPerifericosSetor")
	Long findQuantidadeClientesPerifericosBySetorNmbrAndDateAndDeptNmbr(final @Param("storenmbr") Integer storenmbr, final @Param("date") String date, final @Param("deptnmbr") String deptnmbr, final @Param("hora") String hora);

	/**
	 * Find quantidade cliente by store nmbr and date and dept nmbr.
	 *
	 * @param storenmbr the storenmbr
	 * @param date the date
	 * @return the long
	 */
	@Query(value = "SELECT * from public.fnc_vendasetor_qtd_cliente(:date, :storenmbr, :hora) ",  
            nativeQuery=true
    )
	@Cacheable("byQuantidadeClienteLoja")
	Long findQuantidadeClienteByStoreNmbrAndDate(final @Param("storenmbr") Integer storenmbr, final @Param("date") String date, final @Param("hora") String hora);

	/**
	 * Find quantidade cliente perifericos by store nmbr and date and dept nmbr.
	 *
	 * @param storenmbr the storenmbr
	 * @param date the date
	 * @return the long
	 */
	@Query(value = "SELECT * from public.fnc_vendasetor_qtd_cliente_perifericos(:date, :storenmbr, :hora) ",
            nativeQuery=true
    )
	@Cacheable("byQuantidadeClientesPerifericosLoja")
	Long findQuantidadeClientePerifericosByStoreNmbrAndDate(final @Param("storenmbr") Integer storenmbr, final @Param("date") String date, final @Param("hora") String hora);
	
}
