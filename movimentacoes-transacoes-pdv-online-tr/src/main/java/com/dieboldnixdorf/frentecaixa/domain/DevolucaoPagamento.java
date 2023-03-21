package com.dieboldnixdorf.frentecaixa.domain;


import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


/**
 * The Class DevolucaoPagamento.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table
public class DevolucaoPagamento {
	
	@EmbeddedId
	private DevolucaoPagamentoPK devolucaoPagamentoPK;
	
	@Basic
	@Column(name="contadorregistrointerno", columnDefinition="bpchar", length=5, insertable = false, updatable = false)
	private String contadorregistrointerno;
	
	@Basic
	@Column(name="codigormsproduto", columnDefinition="bpchar", length=10, insertable = false, updatable = false)
	private String codigormsproduto;

	@Basic
	@Column(name="eanproduto", columnDefinition="bpchar", length=15, insertable = false, updatable = false)
	private String eanproduto;
	
	@Basic
	@Column(name="quantidadeformaspgto", columnDefinition="bpchar", length=5, insertable = false, updatable = false)
	private String quantidadeformaspgto;
	
	@Basic
	@Column(name="categoriaformapgto", columnDefinition="bpchar", length=5, insertable = false, updatable = false)
	private String categoriaformapgto;
	
	@Basic
	@Column(name="valorformapgto", columnDefinition="int8")
	private Long valorformapgto;
	
	@Basic
	@Column(name="horaminutoevento", columnDefinition="bpchar", length=10, insertable = false, updatable = false)
	private String horaminutoevento;

}
