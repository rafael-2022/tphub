package com.dieboldnixdorf.frentecaixa.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.dieboldnixdorf.frentecaixa.domain.Ejuserstruct1;
import com.dieboldnixdorf.frentecaixa.domain.FiscalPK;

/**
 * The Interface TransacoesECFRepository.
 */
interface TransacoesECFRepository extends Repository<Ejuserstruct1, FiscalPK> {
	
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
	@Query(value = "SELECT storenmbr, date, termnmbr, lfield1, ulfield1, sznumber1, sznumber2, ulfield2 from public.fnc_movtofiscalecf(:dataExtracao, :codigoLoja) "
		+ " ORDER BY termnmbr /*{#pageable}*/ ",
		countQuery = "SELECT count(*) from (SELECT storenmbr, date, termnmbr, lfield1, ulfield1, "
				+ " sznumber1, sznumber2, ulfield2 from public.fnc_movtofiscalecf(:dataExtracao, :codigoLoja)) as qtd ",
        nativeQuery=true
    )
	@Cacheable("byTransacoesECF")
	Page<Ejuserstruct1> findByCodigoLojaAndDataExtracao(final @Param("codigoLoja") Integer codigoLoja, final @Param("dataExtracao") String dataExtracao, final Pageable pageable);


	/**
	 * Find localizacao by store storenmbr and termnmbr.
	 *
	 * @param storenmbr the storenmbr
	 * @param termnmbr the termnmbr
	 * @return the string
	 */
	@Query(value = "SELECT * from public.fnc_movtofiscalecf_localizacao(:termnmbr, :storenmbr) ",
            nativeQuery=true
    )
	@Cacheable("byLocalizacao")
	String findLocalizacaoByStoreNmbrAndTermNmbr(final @Param("storenmbr") Integer storenmbr, final @Param("termnmbr") Short termnmbr);

	/**
	 * Find movimento total bruto dia by storenmbr and date and termnmbr.
	 *
	 * @param storenmbr the storenmbr
	 * @param date the date
	 * @param termnmbr the termnmbr
	 * @return the long
	 */
	@Query(value = "SELECT * from public.fnc_movtofiscalecf_total_bruto_dia(:date, :storenmbr, :termnmbr ) ",
            nativeQuery=true
    )
	@Cacheable("byMovimentoTotalBrutoDia")
	Long findMovimentoTotalBrutoDiaByStoreNmbrAndDateAndTermNmbr(final @Param("storenmbr") Integer storenmbr, final @Param("date") String date, final @Param("termnmbr") Short termnmbr);

	/**
	 * Find valor total descontos by storenmbr and date and termnmbr.
	 *
	 * @param storenmbr the storenmbr
	 * @param date the date
	 * @param termnmbr the termnmbr
	 * @return the long
	 */
	@Query(value = "SELECT * from public.fnc_MovtoFiscalECF_Valor_Total_Descontos(:date, :storenmbr, :termnmbr ) ",
            nativeQuery=true
    )
	@Cacheable("byValorTotalDescontos")
	Long findValorTotalDescontosByStoreNmbrAndDateAndTermNmbr(final @Param("storenmbr") Integer storenmbr, final @Param("date") String date, final @Param("termnmbr") Short termnmbr);

	/**
	 * Find valor contabil by storenmbr and date and termnmbr.
	 *
	 * @param storenmbr the storenmbr
	 * @param date the date
	 * @param termnmbr the termnmbr
	 * @return the long
	 */
	@Query(value = "SELECT * from public.fnc_MovtoFiscalECF_Valor_Contabil(:date, :storenmbr, :termnmbr) ",
            nativeQuery=true
    )
	@Cacheable("byValorContabil")
	Long findValorContabilByStoreNmbrAndDateAndTermNmbr(final @Param("storenmbr") Integer storenmbr, final @Param("date") String date, final @Param("termnmbr") Short termnmbr);

	/**
	 * Find quantidade clientes by storenmbr and date and termnmbr.
	 *
	 * @param storenmbr the storenmbr
	 * @param date the date
	 * @param termnmbr the termnmbr
	 * @return the long
	 */
	@Query(value = "SELECT * from public.fnc_MovtoFiscalECF_Qtd_Cliente(:date, :storenmbr, :termnmbr) " ,
            nativeQuery=true
    )
	@Cacheable("byQuantidadeClientes")
	Long findQuantidadeClientesByStoreNmbrAndDateAndTermNmbr(final @Param("storenmbr") Integer storenmbr, final @Param("date") String date, final @Param("termnmbr") Short termnmbr);

	/**
	 * Find acumulador isento by storenmbr and date and termnmbr.
	 *
	 * @param storenmbr the storenmbr
	 * @param date the date
	 * @param termnmbr the termnmbr
	 * @return the long
	 */
	@Query(value = "SELECT * from public.fnc_movtofiscalecf_acumulador_isento(:date, :storenmbr, :termnmbr) ",
            nativeQuery=true
    )
	@Cacheable("byAcumuladorIsento")
	Long findAcumuladorIsentoByStoreNmbrAndDateAndTermNmbr(final @Param("storenmbr") Integer storenmbr, final @Param("date") String date, final @Param("termnmbr") Short termnmbr);

	/**
	 * Find acumulador nao tributado by storenmbr and date and termnmbr.
	 *
	 * @param storenmbr the storenmbr
	 * @param date the date
	 * @param termnmbr the termnmbr
	 * @return the long
	 */
	@Query(value = "SELECT * from public.fnc_movtofiscalecf_acumulador_nao_tributado(:date, :storenmbr, :termnmbr) ",
            nativeQuery=true
    )
	@Cacheable("byAcumuladorNaoTributado")
	Long findAcumuladorNaoTributadoByStoreNmbrAndDateAndTermNmbr(final @Param("storenmbr") Integer storenmbr, final @Param("date") String date, final @Param("termnmbr") Short termnmbr);

	/**
	 * Find acumulador substituicao tributaria by storenmbr and date and termnmbr.
	 *
	 * @param storenmbr the storenmbr
	 * @param date the date
	 * @param termnmbr the termnmbr
	 * @return the long
	 */
	@Query(value = "SELECT * from public.fnc_movtofiscalecf_acumulador_substituicao_tributaria(:date, :storenmbr, :termnmbr) ",
            nativeQuery=true
    )
	@Cacheable("byAcumuladorSubstituicaoTributaria")
	Long findAcumuladorSubstituicaoTributariaByStoreNmbrAndDateAndTermNmbr(final @Param("storenmbr") Integer storenmbr, final @Param("date") String date, final @Param("termnmbr") Short termnmbr);

}
