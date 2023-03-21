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
	 * By vendas setor hora.
	 *
	 * @return the cache
	 */
	@Bean
	public Cache byVendasSetorHora() {
		return new GuavaCache("byVendasSetorHora", CacheBuilder.newBuilder().expireAfterWrite(1, TimeUnit.MINUTES).build());
	}


	/**
	 * By quantidade cliente setor.
	 *
	 * @return the cache
	 */
	@Bean
	public Cache byQuantidadeClienteSetor() {
		return new GuavaCache("byQuantidadeClienteSetor", CacheBuilder.newBuilder().expireAfterWrite(1, TimeUnit.MINUTES).build());
	}


	/**
	 * By quantidade clientes perifericos setor.
	 *
	 * @return the cache
	 */
	@Bean
	public Cache byQuantidadeClientesPerifericosSetor() {
		return new GuavaCache("byQuantidadeClientesPerifericosSetor", CacheBuilder.newBuilder().expireAfterWrite(1, TimeUnit.MINUTES).build());
	}

	/**
	 * By quantidade cliente loja.
	 *
	 * @return the cache
	 */
	@Bean
	public Cache byQuantidadeClienteLoja() {
		return new GuavaCache("byQuantidadeClienteLoja", CacheBuilder.newBuilder().expireAfterWrite(1, TimeUnit.MINUTES).build());
	}

	/**
	 * By quantidade clientes perifericos loja.
	 *
	 * @return the cache
	 */
	@Bean
	public Cache byQuantidadeClientesPerifericosLoja() {
		return new GuavaCache("byQuantidadeClientesPerifericosLoja", CacheBuilder.newBuilder().expireAfterWrite(1, TimeUnit.MINUTES).build());
	}

}