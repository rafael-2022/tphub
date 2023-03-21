package com.dieboldnixdorf.frentecaixa.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.dieboldnixdorf.frentecaixa.domain.ContabilPK;
import com.dieboldnixdorf.frentecaixa.domain.Ejuserstruct1;

/**
 * The Interface DescontosTefPromocaoRepository.
 */
interface DescontosTefPromocaoRepository extends Repository<Ejuserstruct1, ContabilPK> {
	
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
	@Query(value = "SELECT datahora, termnmbr, transnmbr, cshrnmbr, sznumber1, szuserext, ulfield2, sznumber2, storenmbr from public.fnc_descontoomnia(:dataExtracao, :codigoLoja) "
			+ " ORDER BY datahora /*{#pageable}*/ ",
			countQuery = "SELECT count(*) from (SELECT datahora, termnmbr, transnmbr, cshrnmbr, sznumber1, "
					+ " szuserext, ulfield2, sznumber2, storenmbr from public.fnc_descontoomnia(:dataExtracao, :codigoLoja) ) as qtd ",
            nativeQuery=true
    )
	@Cacheable("byDescontosTefPromocao")
	Page<Ejuserstruct1> findByCodigoLojaAndDataExtracao(final @Param("codigoLoja") Integer codigoLoja, final @Param("dataExtracao") String dataExtracao, final Pageable pageable);

}
