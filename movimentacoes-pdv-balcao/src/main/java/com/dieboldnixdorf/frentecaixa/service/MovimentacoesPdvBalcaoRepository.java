package com.dieboldnixdorf.frentecaixa.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.dieboldnixdorf.frentecaixa.domain.Ejitem;
import com.dieboldnixdorf.frentecaixa.domain.MovimentacaoPK;

/**
 * The Interface MovimentacoesPdvBalcaoRepository.
 */
interface MovimentacoesPdvBalcaoRepository extends Repository<Ejitem, MovimentacaoPK> {
	
	/**
	 * Find all.
	 *
	 * @param pageable the pageable
	 * @return the page
	 */
	Page<Ejitem> findAll(final Pageable pageable);

	@Query(value = "SELECT merchfmly, datahora, transnmbr, deptnmbr, plunmbr, pludesc, "
			+ " qty1, price1, print1text, print2text, fiscalizador, cshrnmbr, matricula, sequencia "
			+ " from public.fnc_portalprevencao(:dataExtracao, :codigoLoja) "
	    + " ORDER BY plunmbr,transnmbr /*{#pageable}*/ ",
	    countQuery = "SELECT count(*) from (SELECT merchfmly, datahora, transnmbr, deptnmbr, plunmbr, pludesc, "
	    		+ " qty1, price1, print1text, print2text, fiscalizador, cshrnmbr, matricula, sequencia "
	    		+ " from public.fnc_portalprevencao(:dataExtracao, :codigoLoja)) as qtd ",
        nativeQuery=true
    )
	@Cacheable("byMovimentacoesPdvBalcao")
	Page<Ejitem> findMovimentacoesPdvBalcao(final @Param("codigoLoja") Integer codigoLoja, final @Param("dataExtracao") String dataExtracao, final Pageable pageable);


}
