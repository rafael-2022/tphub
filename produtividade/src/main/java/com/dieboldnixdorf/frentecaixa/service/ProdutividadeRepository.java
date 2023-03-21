package com.dieboldnixdorf.frentecaixa.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.dieboldnixdorf.frentecaixa.domain.Produtividade;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

/**
 * The Interface DadosDevolucaoRepository.
 */
interface ProdutividadeRepository extends Repository<Produtividade, String> {

    /**
     * Find all.
     *
     * @param pageable the pageable
     * @return the page
     */
    Page<Produtividade> findAll(final Pageable pageable);

    /**
     * Find by codigo loja and data extracao.
     *
     * @param codigoLoja the codigo loja
     * @param dataExtracao the data extracao
     * @param pageable the pageable
     * @return the page
     */
    @Query(value = "select * "
            + " from public.fnc_produtividade(:dataExtracao, :codigoLoja) "
            + " order by operador /*{#pageable}*/ ",
            countQuery = "select count(*) from (select * "
            + " from public.fnc_produtividade(:dataExtracao, :codigoLoja)) as qtd ",
            nativeQuery = true
    )

    @Cacheable("byProdutividade")
    Page<Produtividade> findByCodigoLojaAndDataExtracao(final @Param("codigoLoja") Integer codigoLoja,
            final @Param("dataExtracao") String dataExtracao, final Pageable pageable);
 
}
