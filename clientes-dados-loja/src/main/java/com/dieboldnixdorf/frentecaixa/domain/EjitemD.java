package com.dieboldnixdorf.frentecaixa.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Class EjitemD.
 */
@Entity
@Table
public class EjitemD {
	
	/** The deptnmbr. */
	@Id
	@Column(name="deptnmbr", length=20)
	private String deptnmbr;

	/** The date. */
	@Basic
	@Column(name="date", length=16)
	private String date;

	/** The print1text - deptdesc. */
	@Basic
	@Column(name="print1text", length=20)
	private String print1text;

	/** The amtsold - valorVendaLiquidaDepartamento. */
	@Basic
	@Column(name="amtsold", columnDefinition="int8")
	private Long amtsold;

	/** The qtysold - quantidadeUnidadesDepartamento. */
	@Basic
	@Column(name="qtysold", columnDefinition="int8")
	private Long qtysold;

	/** The mrpprice1 - quantidadeClientesDepartamento. */
	@Basic
	@Column(name="mrpprice1", columnDefinition="int8")
	private Long mrpprice1;

	/** The mrpprice2 - quantidadeClientesPerifericosDepartamento. */
	@Basic
	@Column(name="mrpprice2", columnDefinition="int8")
	private Long mrpprice2;

	/** The storenmbr. */
	@Basic
	@Column(name="storenmbr", columnDefinition="int4")
	private Integer storenmbr;

	/**
	 * Instantiates a new ejitem.
	 */
	public EjitemD() {
	}

	/**
	 * Instantiates a new ejitem.
	 *
	 * @param print1text the print1text
	 */
	public EjitemD(final String print1text) {
		this.print1text = print1text;
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
	 * Gets the prints the 1 text.
	 *
	 * @return the prints the 1 text
	 */
	public String getPrint1text() {
		return print1text;
	}

	/**
	 * Sets the prints the 1 text.
	 *
	 * @param print1text the new prints the 1 text
	 */
	public void setPrint1text(final String print1text) {
		this.print1text = print1text;
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

	/**
	 * Gets the qtysold.
	 *
	 * @return the qtysold
	 */
	public Long getQtysold() {
		return qtysold;
	}

	/**
	 * Sets the qtysold.
	 *
	 * @param qtysold the new qtysold
	 */
	public void setQtysold(final Long qtysold) {
		this.qtysold = qtysold;
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
}