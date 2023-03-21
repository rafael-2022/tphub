package com.dieboldnixdorf.frentecaixa.config;

import java.util.concurrent.TimeUnit;

import org.springframework.cache.Cache;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.guava.GuavaCache;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.cache.CacheBuilder;

/**
 * The Class CacheConfig.
 */
@Configuration
@EnableCaching
public class CacheConfig {

	/**
	 * By transacoes ECF aliquota.
	 *
	 * @return the cache
	 */
	@Bean
	public Cache byTransacoesECFAliquota() {
		return new GuavaCache("byTransacoesECFAliquota", CacheBuilder.newBuilder().expireAfterWrite(1, TimeUnit.MINUTES).build());
	}

	/**
	 * By transacoes ECF aliquota controle.
	 *
	 * @return the cache
	 */
	@Bean
	public Cache byTransacoesECFAliquotaControle() {
		return new GuavaCache("byTransacoesECFAliquotaControle", CacheBuilder.newBuilder().expireAfterWrite(1, TimeUnit.MINUTES).build());
	}

}
