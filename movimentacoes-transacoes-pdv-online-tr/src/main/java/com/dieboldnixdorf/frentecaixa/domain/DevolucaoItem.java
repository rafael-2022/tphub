package com.dieboldnixdorf.frentecaixa.domain;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


/**
 * The Class DevolucaoItem.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table
public class DevolucaoItem {
	
	@EmbeddedId
	private DevolucaoItemPK devolucaoItemPK;
	
	@Basic
	@Column(name="contadorregistrointerno", columnDefinition="bpchar", insertable = false, updatable = false)
	private String contadorregistrointerno;
	
	@Basic
	@Column(name="codigormsproduto", columnDefinition="bpchar", length=10, insertable = false, updatable = false)
	private String codigormsproduto;
	
	@Basic
	@Column(name="numeromatricula", columnDefinition="bpchar", length=10, insertable = false, updatable = false)
	private String numeromatricula;

	@Basic
	@Column(name="eanproduto", columnDefinition="bpchar", length=15)
	private String eanproduto;
	
	@Basic
	@Column(name="codigosetor", columnDefinition="bpchar", length=5)
	private String codigosetor;
	
	@Basic
	@Column(name="devolucaocomcupom", columnDefinition="bpchar", length=5)
	private String devolucaocomcupom;
	
	@Basic
	@Column(name="valoraliquotafiscal", columnDefinition="int8")
	private Long valoraliquotafiscal;
	
	@Basic
	@Column(name="valortotalitembasecalcpis", columnDefinition="int8")
	private Long valortotalitembasecalcpis;
	
	@Basic
	@Column(name="valortotalitempis", columnDefinition="int8")
	private Long valortotalitempis;
	
	@Basic
	@Column(name="valortotalitembasecalccofins", columnDefinition="int8")
	private Long valortotalitembasecalccofins;
	
	@Basic
	@Column(name="valortotalitemcofins", columnDefinition="int8")
	private Long valortotalitemcofins;
	
	@Basic
	@Column(name="tiposervico", columnDefinition="bpchar", length=5)
	private String tiposervico;
	
	@Basic
	@Column(name="codigoservico", columnDefinition="bpchar", length=10)
	private String codigoservico;
	
	@Basic
	@Column(name="codigofornecedor", columnDefinition="bpchar", length=15)
	private String codigofornecedor;
	
	@Basic
	@Column(name="quantidadeitensdevolvidos", columnDefinition="bpchar")
	private String quantidadeitensdevolvidos;
	
	@Basic
	@Column(name="valorunitariodevolvidos", columnDefinition="int8")
	private Long valorunitariodevolvidos;
	
	@Basic
	@Column(name="valortotaldevolvido", columnDefinition="int8")
	private Long valortotaldevolvido;
	
	@Basic
	@Column(name="valortotalitemimpostodebitado", columnDefinition="int8")
	private Long valortotalitemimpostodebitado;
	
	@Basic
	@Column(name="horaminutoevento", columnDefinition="bpchar", length=10)
	private String horaminutoevento;
	
	@Basic
	@Column(name="status", columnDefinition="bpchar", length=5)
	private String status;

	
}
