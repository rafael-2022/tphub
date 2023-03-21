package com.dieboldnixdorf.frentecaixa.service;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.dieboldnixdorf.frentecaixa.domain.EjitemS;

/**
 * The Interface DadosClientesLojaSRepository.
 */
interface DadosClientesLojaSRepository extends Repository<EjitemS, String> {
	
	/**
	 * Find by codigo loja and data extracao.
	 *
	 * @param codigoLoja the codigo loja
	 * @param dataExtracao the data extracao
	 * @param pageable the pageable
	 * @return the page
	 */
	@Query(value = "SELECT storenmbr, date, print1text, amtsold, qtysold, mrpprice1, mrpprice2 from public.fnc_dadosclientes_s(:dataExtracao, :codigoLoja) "
			+ " ORDER BY print1text ",
		countQuery = "SELECT count(*) from (SELECT storenmbr, date, print1text, amtsold, "
				+ " qtysold, mrpprice1, mrpprice2 from public.fnc_dadosclientes_s(:dataExtracao, :codigoLoja)) as qtd ", 
        nativeQuery=true
    )
	@Cacheable("dadosClientesLojaS")
	List<EjitemS> findByCodigoLojaAndDataExtracao(final @Param("codigoLoja") Integer codigoLoja, final @Param("dataExtracao") String dataExtracao);

	/**
	 * Find nome setor by deptlink.
	 *
	 * @param deptlink the deptlink
	 * @return the string
	 */
	@Query(value = "SELECT * from public.fnc_dadosclientes_nm_setor(:deptlink, :codigoLoja) ",
            nativeQuery=true
    )
	@Cacheable("byNomeSetorByDeptLink")
	String findNomeSetorByDeptLink(final @Param("deptlink") String deptlink, final @Param("codigoLoja") Integer codigoLoja);
	
}
