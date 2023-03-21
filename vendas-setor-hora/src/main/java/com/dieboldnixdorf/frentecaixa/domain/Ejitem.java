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
	
	/** The venda PK. */
	@EmbeddedId
	private VendaPK vendaPK;
	
	/** The amtsold. */
	@Basic
	@Column(name="amtsold", columnDefinition="int8")
	private Long amtsold;

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
	 * Gets the venda PK.
	 *
	 * @return the venda PK
	 */
	public VendaPK getVendaPK() {
		return vendaPK;
	}

	/**
	 * Sets the venda PK.
	 *
	 * @param vendaPK the new venda PK
	 */
	public void setVendaPK(final VendaPK vendaPK) {
		this.vendaPK = vendaPK;
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
}