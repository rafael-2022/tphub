package com.dieboldnixdorf.frentecaixa.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * The Class Ejitem.
 */
@Entity
@Table
public class Ejitem {
	
	/** The fiscal PK. */
	@EmbeddedId
	private FiscalPK fiscalPK;

	/** The mrpprice1. */
	@Basic
	@Column(name="mrpprice1", columnDefinition="int8")
	private Long mrpprice1;

	/** The amtsold. */
	@Basic
	@Column(name="amtsold", columnDefinition="int8")
	private Long amtsold;
	
	/**
	 * Instantiates a new ejitem.
	 */
	public Ejitem() {
	}

	/**
	 * Gets the fiscal PK.
	 *
	 * @return the fiscal PK
	 */
	public FiscalPK getFiscalPK() {
		return fiscalPK;
	}

	/**
	 * Sets the fiscal PK.
	 *
	 * @param fiscalPK the new fiscal PK
	 */
	public void setFiscalPK(final FiscalPK fiscalPK) {
		this.fiscalPK = fiscalPK;
	}

	/**
	 * Gets the mrpprice 1.
	 *
	 * @return the mrpprice 1
	 */
	public Long getMrpprice1() {
		return mrpprice1;
	}

	/**
	 * Sets the mrpprice 1.
	 *
	 * @param mrpprice1 the new mrpprice 1
	 */
	public void setMrpprice1(final Long mrpprice1) {
		this.mrpprice1 = mrpprice1;
	}

	/**
	 * Gets the amtsold.
	 *
	 * @return the amtsold
	 */
	public Long getAmtsold() {
		return amtsold;
	}

	/**
	 * Sets the amtsold.
	 *
	 * @param amtsold the new amtsold
	 */
	public void setAmtsold(final Long amtsold) {
		this.amtsold = amtsold;
	}
}