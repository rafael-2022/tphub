package com.dieboldnixdorf.frentecaixa.domain;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


/**
 * The Class DevolucaoCapa.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table
public class DevolucaoCapa {
	
	@EmbeddedId
	private DevolucaoCapaPK devolucaoCapaPK;
	
	@Basic
	@Column(name="codigoloja", columnDefinition="bpchar", length=4)
	private String codigoloja;
	
	@Basic
	@Column(name="cnpjemissor", columnDefinition="bpchar", length=20)
	private String cnpjemissor;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date datadevolucao;
	
	@Basic
	@Column(name="numerodocumentofiscal", columnDefinition="bpchar", length=10)
	private String numerodocumentofiscal;

	@Basic
	@Column(name="seriedocumentofiscal", columnDefinition="bpchar", length=5)
	private String seriedocumentofiscal;
	
	@Basic
	@Column(name="numeroDANFE", columnDefinition="bpchar", length=50)
	private String numeroDANFE;
	
	@Basic
	@Column(name="transacaoloja", columnDefinition="bpchar", length=10, insertable = false, updatable = false)
	private String transacaoloja;
	
	@Basic
	@Column(name="codigoterminalvenda", columnDefinition="bpchar", length=10)
	private String codigoterminalvenda;
	
	@Basic
	@Column(name="clientecpf_nf", columnDefinition="bpchar", length=20)
	private String clientecpf_nf;
	
	@Basic
	@Column(name="clientecpf_meucarrefour", columnDefinition="bpchar", length=20)
	private String clientecpf_meucarrefour;
	
	@Basic
	@Column(name="numpreorder", columnDefinition="bpchar", length=20)
	private String numpreorder;
	
	@Basic
	@Column(name="codvendedor", columnDefinition="bpchar", length=20)
	private String codvendedor;
	
	@Basic
	@Column(name="recepcionistadrt", columnDefinition="bpchar", length=20)
	private String recepcionistadrt;
	
	@Basic
	@Column(name="codigoeventodevolucao", columnDefinition="bpchar", length=20)
	private String codigoeventodevolucao;
	
	@Basic
	@Column(name="tipoevento", columnDefinition="bpchar", length=5)
	private String tipoevento;
	
	@Basic
	@Column(name="operacaovenda", columnDefinition="bpchar", length=5)
	private String operacaovenda;
	
	@Basic
	@Column(name="clientecpf_nforigem", columnDefinition="bpchar", length=20)
	private String clientecpf_nforigem;
	
	@Basic
	@Column(name="clientecpf_meucarrefourorigem", columnDefinition="bpchar", length=50)
	private String clientecpf_meucarrefourorigem;
	
	@Basic
	@Column(name="numerodanfeorigem", columnDefinition="bpchar", length=20)
	private String numerodanfeorigem;
	
	@Basic
	@Column(name="pdvresgate", columnDefinition="bpchar", length=15)
	private String pdvresgate;
	
	@Basic
	@Column(name="transacaoresgate", columnDefinition="bpchar", length=15)
	private String transacaoresgate;
	
	@Basic
	@Column(name="datahoraresgate", columnDefinition="bpchar", length=20)
	private String datahoraresgate;
	
	@Basic
	@Column(name="operadorresgate", columnDefinition="bpchar", length=50)
	private String operadorresgate;

	@Basic
	@Column(name="valorresgate", columnDefinition="bpchar", length=15)
	private String valorresgate;

}
