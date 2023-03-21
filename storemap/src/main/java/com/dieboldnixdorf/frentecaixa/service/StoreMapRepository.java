package com.dieboldnixdorf.frentecaixa.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.dieboldnixdorf.frentecaixa.domain.Storemap;

/**
 * The Interface StoreMapRepository.
 */
interface StoreMapRepository extends Repository<Storemap, String> {
	
	/**
	 * Find by codigo loja.
	 *
	 * @param codigoLoja the codigo loja
	 * @return the storemap
	 */
	@Query(value = "SELECT storemap.\"id_store_tpadmin\", "
			+ " storemap.\"id_store_gold\", storemap.\"store_ip_tplinux\", "
			+ " storemap.\"code_store_gold\" "
			+ " from storemap "
			+ " where cast(storemap.\"id_store_gold\" as int)  = :codigoLoja ",
            nativeQuery=true
    )
	@Cacheable("byCodigoLoja")
	Storemap findByCodigoLoja(final @Param("codigoLoja") Integer codigoLoja);

	/**
	 * Find by loja.
	 *
	 * @param loja the loja
	 * @return the storemap
	 */
	@Query(value = "SELECT storemap.\"id_store_tpadmin\", "
			+ " storemap.\"id_store_gold\", storemap.\"store_ip_tplinux\", "
			+ " storemap.\"code_store_gold\" "
			+ " from storemap "
			+ " where UPPER(TRIM(storemap.\"store_ip_tplinux\"))  = UPPER(TRIM(:loja)) ",
            nativeQuery=true
    )
	@Cacheable("byLoja")
	Storemap findByLoja(final @Param("loja") String loja);

}
