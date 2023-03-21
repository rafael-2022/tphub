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
	 * By transacoes ECF.
	 *
	 * @return the cache
	 */
	@Bean
	public Cache byTransacoesECF() {
		return new GuavaCache("byTransacoesECF", CacheBuilder.newBuilder().expireAfterWrite(1, TimeUnit.MINUTES).build());
	}

	/**
	 * By transacoes ECF controle.
	 *
	 * @return the cache
	 */
	@Bean
	public Cache byTransacoesECFControle() {
		return new GuavaCache("byTransacoesECFControle", CacheBuilder.newBuilder().expireAfterWrite(1, TimeUnit.MINUTES).build());
	}

	/**
	 * By localizacao.
	 *
	 * @return the cache
	 */
	@Bean
	public Cache byLocalizacao() {
		return new GuavaCache("byLocalizacao", CacheBuilder.newBuilder().expireAfterWrite(1, TimeUnit.MINUTES).build());
	}

	/**
	 * By numero operacao inicial.
	 *
	 * @return the cache
	 */
	@Bean
	public Cache byNumeroOperacaoInicial() {
		return new GuavaCache("byNumeroOperacaoInicial", CacheBuilder.newBuilder().expireAfterWrite(1, TimeUnit.MINUTES).build());
	}

	/**
	 * By numero operacao final.
	 *
	 * @return the cache
	 */
	@Bean
	public Cache byNumeroOperacaoFinal() {
		return new GuavaCache("byNumeroOperacaoFinal", CacheBuilder.newBuilder().expireAfterWrite(1, TimeUnit.MINUTES).build());
	}

	/**
	 * By movimento total bruto dia.
	 *
	 * @return the cache
	 */
	@Bean
	public Cache byMovimentoTotalBrutoDia() {
		return new GuavaCache("byMovimentoTotalBrutoDia", CacheBuilder.newBuilder().expireAfterWrite(1, TimeUnit.MINUTES).build());
	}

	/**
	 * By valor total descontos.
	 *
	 * @return the cache
	 */
	@Bean
	public Cache byValorTotalDescontos() {
		return new GuavaCache("byValorTotalDescontos", CacheBuilder.newBuilder().expireAfterWrite(1, TimeUnit.MINUTES).build());
	}

	/**
	 * By valor contabil.
	 *
	 * @return the cache
	 */
	@Bean
	public Cache byValorContabil() {
		return new GuavaCache("byValorContabil", CacheBuilder.newBuilder().expireAfterWrite(1, TimeUnit.MINUTES).build());
	}

	/**
	 * By quantidade clientes.
	 *
	 * @return the cache
	 */
	@Bean
	public Cache byQuantidadeClientes() {
		return new GuavaCache("byQuantidadeClientes", CacheBuilder.newBuilder().expireAfterWrite(1, TimeUnit.MINUTES).build());
	}

	/**
	 * By acumulador isento.
	 *
	 * @return the cache
	 */
	@Bean
	public Cache byAcumuladorIsento() {
		return new GuavaCache("byAcumuladorIsento", CacheBuilder.newBuilder().expireAfterWrite(1, TimeUnit.MINUTES).build());
	}
	
	/**
	 * By acumulador nao tributado.
	 *
	 * @return the cache
	 */
	@Bean
	public Cache byAcumuladorNaoTributado() {
		return new GuavaCache("byAcumuladorNaoTributado", CacheBuilder.newBuilder().expireAfterWrite(1, TimeUnit.MINUTES).build());
	}

	/**
	 * By acumulador substituicao tributaria.
	 *
	 * @return the cache
	 */
	@Bean
	public Cache byAcumuladorSubstituicaoTributaria() {
		return new GuavaCache("byAcumuladorSubstituicaoTributaria", CacheBuilder.newBuilder().expireAfterWrite(1, TimeUnit.MINUTES).build());
	}
}
