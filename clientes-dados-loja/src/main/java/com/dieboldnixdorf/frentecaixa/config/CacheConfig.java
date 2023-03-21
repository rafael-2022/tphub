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
	 * Dados clientes loja D.
	 *
	 * @return the cache
	 */
	@Bean
	public Cache dadosClientesLojaD() {
		return new GuavaCache("dadosClientesLojaD", CacheBuilder.newBuilder().expireAfterWrite(1, TimeUnit.MINUTES).build());
	}

	/**
	 * Dados clientes loja L.
	 *
	 * @return the cache
	 */
	@Bean
	public Cache dadosClientesLojaL() {
		return new GuavaCache("dadosClientesLojaL", CacheBuilder.newBuilder().expireAfterWrite(1, TimeUnit.MINUTES).build());
	}

	/**
	 * Dados clientes loja S.
	 *
	 * @return the cache
	 */
	@Bean
	public Cache dadosClientesLojaS() {
		return new GuavaCache("dadosClientesLojaS", CacheBuilder.newBuilder().expireAfterWrite(1, TimeUnit.MINUTES).build());
	}

	/**
	 * By nome setor by dept link.
	 *
	 * @return the cache
	 */
	@Bean
	public Cache byNomeSetorByDeptLink() {
		return new GuavaCache("byNomeSetorByDeptLink", CacheBuilder.newBuilder().expireAfterWrite(1, TimeUnit.MINUTES).build());
	}

	/**
	 * By cliente total.
	 *
	 * @return the cache
	 */
	@Bean
	public Cache byClienteTotal() {
		return new GuavaCache("byClienteTotal", CacheBuilder.newBuilder().expireAfterWrite(1, TimeUnit.MINUTES).build());
	}
	
	/**
	 * By clientes perifericos.
	 *
	 * @return the cache
	 */
	@Bean
	public Cache byClientesPerifericos() {
		return new GuavaCache("byClientesPerifericos", CacheBuilder.newBuilder().expireAfterWrite(1, TimeUnit.MINUTES).build());
	}	
}