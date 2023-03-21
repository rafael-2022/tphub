package com.dieboldnixdorf.frentecaixa.service;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.dieboldnixdorf.frentecaixa.domain.EjitemD;

/**
 * The Interface DadosClientesLojaDRepository.
 */
interface DadosClientesLojaDRepository extends Repository<EjitemD, String> {
	
	/**
	 * Find by codigo loja and data extracao.
	 *
	 * @param codigoLoja the codigo loja
	 * @param dataExtracao the data extracao
	 * @param pageable the pageable
	 * @return the page
	 */
	@Query(value = "SELECT storenmbr, date, print1text, deptnmbr, amtsold, qtysold, mrpprice1, mrpprice2 from public.fnc_dadosclientes_d(:dataExtracao, :codigoLoja, :codigoSetor) "
			+ " ORDER BY deptnmbr ",
		countQuery = "SELECT count(*) from (SELECT storenmbr, date, print1text, deptnmbr, amtsold, "
				+ " qtysold, mrpprice1, mrpprice2 from public.fnc_dadosclientes_d(:dataExtracao, :codigoLoja, :codigoSetor)) as qtd ", 
        nativeQuery=true
    )
	@Cacheable("dadosClientesLojaD")
	List<EjitemD> findByCodigoLojaAndDataExtracao(final @Param("codigoLoja") Integer codigoLoja, final @Param("dataExtracao") String dataExtracao, final @Param("codigoSetor") String codigoSetor);

}