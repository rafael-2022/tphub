package com.dieboldnixdorf.frentecaixa.service;

import java.util.Date;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.dieboldnixdorf.frentecaixa.domain.DevRecebimento;

/**
 * The Interface DadosDevolucaoRepository.
 */
interface VendaAssistidaDevolucaoRepository extends Repository<DevRecebimento, String> {
	
	/**
	 * Find all.
	 *
	 * @param pageable the pageable
	 * @return the page
	 */
	Page<DevRecebimento> findAll(final Pageable pageable);
	
	/**
	 * Find by codigo loja and data extracao.
	 *
	 * @param codigoLoja the codigo loja
	 * @param dataExtracao the data extracao
	 * @param pageable the pageable
	 * @return the page
	 */
	@Query(value = "select tipodev, numdocto as numdocto, numpreorder, numpdv,codoper,codvend,tiposerv,"
			+ " codprod, codserv, codforn,qtde,vlrunit,vlrtot,qtdeformpagto,catformpagto,"
			+ " formpagto,vlrformpagto , sequencia "
			+ " from public.fnc_devrecebimento(:dataExtracao, :codigoLoja) "
			+ " order by numdocto /*{#pageable}*/ ",
			
			countQuery = "select count(*) from (select tipodev, numdocto as numdocto, numpreorder, numpdv,codoper,codvend,tiposerv,codprod, "  
					+ " codserv,  codforn,qtde,vlrunit,vlrtot,qtdeformpagto,catformpagto,formpagto,vlrformpagto,sequencia "
					+ " from public.fnc_devrecebimento(:dataExtracao, :codigoLoja)) as qtd ",
            nativeQuery=true
    )
	
	@Cacheable("byVendaAssistidaDevolucao")
	Page<DevRecebimento> findByCodigoLojaAndDataExtracao(final @Param("codigoLoja") Integer codigoLoja, 
			final @Param("dataExtracao") String dataExtracao, final Pageable pageable);

}
