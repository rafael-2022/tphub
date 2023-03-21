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
 * The Class DevolucaoMovimentacao.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table
public class DevolucaoMovimentacao {
	
	@EmbeddedId
	private DevolucaoMovimentacaoPK devolucaoMovimentacaoPK;
	
	@Basic
	@Column(name="storenmbr", columnDefinition="int4", insertable = false, updatable = false)
	private Integer storenmbr;
	
	@Basic
	@Column(name="matricula", columnDefinition="bpchar", length=20, insertable = false, updatable = false)
	private String matricula;
	
	@Basic
	@Column(name="bdate", columnDefinition="int8")
	private Long bdate;

	@Basic
	@Column(name="bdatepdv", columnDefinition="int8")
	private Long bdatepdv;


}
