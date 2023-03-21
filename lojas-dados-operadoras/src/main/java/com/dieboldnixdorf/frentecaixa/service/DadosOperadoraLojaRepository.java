package com.dieboldnixdorf.frentecaixa.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.dieboldnixdorf.frentecaixa.domain.Employee;

/**
 * The Interface DescontosTefPromocaoRepository.
 */
interface DadosOperadoraLojaRepository extends Repository<Employee, Long> {
	
	/**
	 * Find all.
	 *
	 * @param pageable the pageable
	 * @return the page
	 */
	Page<Employee> findAll(final Pageable pageable);
	
	/**
	 * Find by codigo loja and data extracao.
	 *
	 * @param codigoLoja the codigo loja
	 * @param dataExtracao the data extracao
	 * @param pageable the pageable
	 * @return the page
	 */
	@Query(value = "SELECT empnmbr, empname, empprofile from public.fnc_listaoperadores(:codigoLoja) "
			+ " ORDER BY empnmbr /*{#pageable}*/ ",
            nativeQuery=true
    )
	@Cacheable("byDadosOperadoraLoja")
	Page<Employee> findByCodigoLojaAndDataExtracao(final @Param("codigoLoja") Integer codigoLoja, final Pageable pageable);
	
}
