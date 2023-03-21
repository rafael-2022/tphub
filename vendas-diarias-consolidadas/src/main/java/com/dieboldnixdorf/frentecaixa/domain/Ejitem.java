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
	private VdaPK vdaPK;

	/** The amtmkdn. */
	@Basic
	@Column(name="amtmkdn", columnDefinition="int8")
	private Long amtmkdn;

	/** The amtsold. */
	@Basic
	@Column(name="amtsold", columnDefinition="int8")
	private Long amtsold;

	/** The qtymkdn. */
	@Basic
	@Column(name="qtymkdn", columnDefinition="int8")
	private Long qtymkdn;

	/** The qtysold. */
	@Basic
	@Column(name="qtysold", columnDefinition="int8")
	private Long qtysold;

	/**
	 * Instantiates a new ejitem.
	 */
	public Ejitem() {
	}

	/**
	 * Gets the vda PK.
	 *
	 * @return the vda PK
	 */
	public VdaPK getVdaPK() {
		return vdaPK;
	}

	/**
	 * Sets the vda PK.
	 *
	 * @param vdaPK the new vda PK
	 */
	public void setVdaPK(final VdaPK vdaPK) {
		this.vdaPK = vdaPK;
	}

	/**
	 * Gets the amtmkdn.
	 *
	 * @return the amtmkdn
	 */
	public Long getAmtmkdn() {
		return amtmkdn;
	}

	/**
	 * Sets the amtmkdn.
	 *
	 * @param amtmkdn the new amtmkdn
	 */
	public void setAmtmkdn(final Long amtmkdn) {
		this.amtmkdn = amtmkdn;
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
	 * Gets the qtymkdn.
	 *
	 * @return the qtymkdn
	 */
	public Long getQtymkdn() {
		return qtymkdn;
	}

	/**
	 * Sets the qtymkdn.
	 *
	 * @param qtymkdn the new qtymkdn
	 */
	public void setQtymkdn(final Long qtymkdn) {
		this.qtymkdn = qtymkdn;
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

}