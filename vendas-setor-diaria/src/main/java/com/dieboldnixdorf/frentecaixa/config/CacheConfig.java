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
	 * By vendas setor diaria.
	 *
	 * @return the cache
	 */
	@Bean
	public Cache byVendasSetorDiaria() {
		return new GuavaCache("byVendasSetorDiaria", CacheBuilder.newBuilder().expireAfterWrite(1, TimeUnit.MINUTES).build());
	}

	/**
	 * By vendas setor diaria controle.
	 *
	 * @return the cache
	 */
	@Bean
	public Cache byVendasSetorDiariaControle() {
		return new GuavaCache("byVendasSetorDiariaControle", CacheBuilder.newBuilder().expireAfterWrite(1, TimeUnit.MINUTES).build());
	}
}
