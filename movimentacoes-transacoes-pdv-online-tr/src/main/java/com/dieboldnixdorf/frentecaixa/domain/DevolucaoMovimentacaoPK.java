package com.dieboldnixdorf.frentecaixa.domain;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The Class DevolucaoMovimentacaoPK.
 */
@Embeddable
public class DevolucaoMovimentacaoPK implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4659965555258085681L;

	@Basic
	@Column(name="storenmbr", columnDefinition="int8", insertable = false, updatable = false)
	private Integer storenmbr;
	
	@Basic
	@Column(name="matricula", columnDefinition="bpchar", insertable = false, updatable = false)
	private String matricula;

}
