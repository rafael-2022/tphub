package com.dieboldnixdorf.frentecaixa.service;

import java.util.Date;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.dieboldnixdorf.frentecaixa.domain.ContabilPK;
import com.dieboldnixdorf.frentecaixa.domain.Ejitem;

/**
 * The Interface DevolucaoContabilRepository.
 */
interface DevolucaoContabilRepository extends Repository<Ejitem, ContabilPK> {
	
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
	@Query(value = "SELECT vendornmbr, entrynmbr, clerknmbr, sumamtdisc, cshrnmbr, mngrovnmbr, print1text, "
			+ " couponfmly, pludesc, mrpprice5, productgrpnmbr, mrpprice1, mrpprice2, mrpprice3, mrpprice4 from public.fnc_devolucaovenda(:dataExtracao, :codigoLoja) "
			+ " ORDER BY vendornmbr,clerknmbr,couponfmly /*{#pageable}*/ ",
			countQuery = "SELECT count(*) from (SELECT vendornmbr, entrynmbr, clerknmbr, sumamtdisc, cshrnmbr, "
					+ " mngrovnmbr, print1text, couponfmly, pludesc, mrpprice5, productgrpnmbr, mrpprice1, "
					+ " mrpprice2, mrpprice3, mrpprice4 from public.fnc_devolucaovenda(:dataExtracao, :codigoLoja)) as qtd ",
            nativeQuery=true
    )
	@Cacheable("byDevolucaoContabil")
	Page<Ejitem> findByCodigoLojaAndDataExtracao(final @Param("codigoLoja") Integer codigoLoja, final @Param("dataExtracao") Date dataExtracao, final Pageable pageable);

}
