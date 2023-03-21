package com.dieboldnixdorf.frentecaixa.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Class Ejitem.
 */
@Entity
@Table
public class Ejitem {
	
	/** The deptnmbr. */
	@Id
	@Column(name="deptnmbr", length=20)
	private String deptnmbr;

	/** The storenmbr. */
	@Basic
	@Column(name="storenmbr", columnDefinition="int4")
	private Integer storenmbr;

	/** The date. */
	@Basic
	@Column(name="date", length=16)
	private String date;

	/** The Valor Calculo COFINS. */
	@Basic
	@Column(name="mrpprice5", columnDefinition="int8")
	private Long mrpprice5;

	/** The Valor Calculo PIS. */
	@Basic
	@Column(name="mrpprice4", columnDefinition="int8")
	private Long mrpprice4;

	/** The Valor Contabil. */
	@Basic
	@Column(name="mrpprice1", columnDefinition="int8")
	private Long mrpprice1;

	/** The Valor ICMS. */
	@Basic
	@Column(name="mrpprice2", columnDefinition="int8")
	private Long mrpprice2;

	/** The Base Calculo PIS. */
	@Basic
	@Column(name="mrpprice3", columnDefinition="int8")
	private Long mrpprice3;

	/** The Base Calculo COFINS. */
	@Basic
	@Column(name="sumamtdisc", columnDefinition="int8")
	private Long sumamtdisc;

	/**
	 * Instantiates a new ejitem.
	 */
	public Ejitem() {
	}

	/**
	 * Instantiates a new ejitem.
	 *
	 * @param deptnmbr the deptnmbr
	 */
	public Ejitem(String deptnmbr) {
		this.deptnmbr = deptnmbr;
	}

	/**
	 * Gets the deptnmbr.
	 *
	 * @return the deptnmbr
	 */
	public String getDeptnmbr() {
		return deptnmbr;
	}

	/**
	 * Sets the deptnmbr.
	 *
	 * @param deptnmbr the new deptnmbr
	 */
	public void setDeptnmbr(final String deptnmbr) {
		this.deptnmbr = deptnmbr;
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
	 * Gets the mrpprice 2.
	 *
	 * @return the mrpprice 2
	 */
	public Long getMrpprice2() {
		return mrpprice2;
	}

	/**
	 * Sets the mrpprice 2.
	 *
	 * @param mrpprice2 the new mrpprice 2
	 */
	public void setMrpprice2(final Long mrpprice2) {
		this.mrpprice2 = mrpprice2;
	}

	/**
	 * Gets the mrpprice 3.
	 *
	 * @return the mrpprice 3
	 */
	public Long getMrpprice3() {
		return mrpprice3;
	}

	/**
	 * Sets the mrpprice 3.
	 *
	 * @param mrpprice3 the new mrpprice 3
	 */
	public void setMrpprice3(final Long mrpprice3) {
		this.mrpprice3 = mrpprice3;
	}

	/**
	 * Gets the sumamtdisc.
	 *
	 * @return the sumamtdisc
	 */
	public Long getSumamtdisc() {
		return sumamtdisc;
	}

	/**
	 * Sets the sumamtdisc.
	 *
	 * @param sumamtdisc the new sumamtdisc
	 */
	public void setSumamtdisc(final Long sumamtdisc) {
		this.sumamtdisc = sumamtdisc;
	}

}