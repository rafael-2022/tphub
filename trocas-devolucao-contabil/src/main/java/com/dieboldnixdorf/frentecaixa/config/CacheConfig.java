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
	 * By devolucao contabil.
	 *
	 * @return the cache
	 */
	@Bean
	public Cache byDevolucaoContabil() {
		return new GuavaCache("byDevolucaoContabil", CacheBuilder.newBuilder().expireAfterWrite(1, TimeUnit.MINUTES).build());
	}

	/**
	 * By devolucao contabil controle.
	 *
	 * @return the cache
	 */
	@Bean
	public Cache byDevolucaoContabilControle() {
		return new GuavaCache("byDevolucaoContabilControle", CacheBuilder.newBuilder().expireAfterWrite(1, TimeUnit.MINUTES).build());
	}

}
