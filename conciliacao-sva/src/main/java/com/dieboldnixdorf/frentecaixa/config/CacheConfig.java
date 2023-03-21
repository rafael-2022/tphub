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
	 * By item transacoes pdv.
	 *
	 * @return the cache
	 */
	@Bean
	public Cache byItemTransacoesPdv() {
		return new GuavaCache("byItemTransacoesPdv", CacheBuilder.newBuilder().expireAfterWrite(1, TimeUnit.MINUTES).build());
	}

	/**
	 * By cabecalho transacao.
	 *
	 * @return the cache
	 */
	@Bean
	public Cache byCabecalhoTransacao() {
		return new GuavaCache("byCabecalhoTransacao", CacheBuilder.newBuilder().expireAfterWrite(1, TimeUnit.MINUTES).build());
	}

	/**
	 * By forma pagamento.
	 *
	 * @return the cache
	 */
	@Bean
	public Cache byFormaPagamento() {
		return new GuavaCache("byFormaPagamento", CacheBuilder.newBuilder().expireAfterWrite(1, TimeUnit.MINUTES).build());
	}

	/**
	 * By rodape transacao.
	 *
	 * @return the cache
	 */
	@Bean
	public Cache byRodapeTransacao() {
		return new GuavaCache("byRodapeTransacao", CacheBuilder.newBuilder().expireAfterWrite(1, TimeUnit.MINUTES).build());
	}

	/**
	 * By local venda.
	 *
	 * @return the cache
	 */
	@Bean
	public Cache byLocalVenda() {
		return new GuavaCache("byLocalVenda", CacheBuilder.newBuilder().expireAfterWrite(1, TimeUnit.MINUTES).build());
	}
}
