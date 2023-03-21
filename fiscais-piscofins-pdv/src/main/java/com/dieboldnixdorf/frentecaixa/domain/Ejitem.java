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
	
	/** The vda PK. */
	@EmbeddedId
	private FiscalPK fiscalPK;

	/** The date. */
	@Basic
	@Column(name="date", length=16)
	private String date;

	/** The mrpprice4. */
	@Basic
	@Column(name="mrpprice4", columnDefinition="int8")
	private Long mrpprice4;

	/** The mrpprice5. */
	@Basic
	@Column(name="mrpprice5", columnDefinition="int8")
	private Long mrpprice5;
	
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
	 * Gets the date.
	 *
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Sets the date.
	 *
	 * @param date the new date
	 */
	public void setDate(final String date) {
		this.date = date;
	}

	/**
	 * Gets the mrpprice 4.
	 *
	 * @return the mrpprice 4
	 */
	public Long getMrpprice4() {
		return mrpprice4;
	}

	/**
	 * Sets the mrpprice 4.
	 *
	 * @param mrpprice4 the new mrpprice 4
	 */
	public void setMrpprice4(final Long mrpprice4) {
		this.mrpprice4 = mrpprice4;
	}

	/**
	 * Gets the mrpprice 5.
	 *
	 * @return the mrpprice 5
	 */
	public Long getMrpprice5() {
		return mrpprice5;
	}

	/**
	 * Sets the mrpprice 5.
	 *
	 * @param mrpprice5 the new mrpprice 5
	 */
	public void setMrpprice5(final Long mrpprice5) {
		this.mrpprice5 = mrpprice5;
	}

}