package com.dieboldnixdorf.frentecaixa.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.dieboldnixdorf.frentecaixa.domain.Ejitem;

/**
 * The Interface DescontosTefPromocaoRepository.
 */
interface VendasSetorDiariaRepository extends Repository<Ejitem, String> {
	
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
	 * @param pageable the pageable
	 * @return the page
	 */
	@Query(value = "SELECT storenmbr, date, deptnmbr, mrpprice1, mrpprice2, mrpprice3, "
			+ " sumamtdisc, mrpprice4, mrpprice5 from public.fnc_vendaporsetor(:dataExtracao, :codigoLoja) "
			+ " ORDER BY deptnmbr /*{#pageable}*/ ",
			countQuery = "SELECT count(*) from (SELECT storenmbr, date, deptnmbr, mrpprice1, mrpprice2, "
					+ " mrpprice3, sumamtdisc, mrpprice4, mrpprice5 from public.fnc_vendaporsetor(:dataExtracao, :codigoLoja)) as qtd",
            nativeQuery=true
    )
	@Cacheable("byVendasSetorDiaria")
	Page<Ejitem> findByCodigoLojaAndDataExtracao(final @Param("codigoLoja") Integer codigoLoja, final @Param("dataExtracao") String dataExtracao, final Pageable pageable);

}
