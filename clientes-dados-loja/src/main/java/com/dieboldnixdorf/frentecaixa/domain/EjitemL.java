package com.dieboldnixdorf.frentecaixa.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Class EjitemL.
 */
@Entity
@Table
public class EjitemL {
	
	/** The storenmbr. */
	@Id
	@Column(name="storenmbr", columnDefinition="int4")
	private Integer storenmbr;

	/** The date. */
	@Basic
	@Column(name="date", length=16)
	private String date;

	/**
	 * Instantiates a new ejitem.
	 */
	public EjitemL() {
	}

	/**
	 * Instantiates a new ejitem.
	 *
	 * @param storenmbr the storenmbr
	 */
	public EjitemL(final Integer storenmbr) {
		this.storenmbr = storenmbr;
	}

	/**
	 * Gets the storenmbr.
	 *
	 * @return the storenmbr
	 */
	public Integer getStorenmbr() {
		return storenmbr;
	}

	/**
	 * Sets the storenmbr.
	 *
	 * @param storenmbr the new storenmbr
	 */
	public void setStorenmbr(final Integer storenmbr) {
		this.storenmbr = storenmbr;
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
}