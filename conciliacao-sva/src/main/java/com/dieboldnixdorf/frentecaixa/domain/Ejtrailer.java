package com.dieboldnixdorf.frentecaixa.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * The Class Ejtrailer.
 */
@Entity
@Table
public class Ejtrailer {
	
	/** The reg50 PK. */
	@EmbeddedId
	private Reg50PK reg50PK;

	/** The rectype - Codigo Transacao Interno. */
	@Basic
	@Column(name="rectype", columnDefinition="int2")
	private Short rectype;

	/** The totalrounding - Troco. */
	@Basic
	@Column(name="totalrounding", columnDefinition="int4")
	private Integer totalrounding;

	/** The totalvat -  Valor Total Transacao Tributado. */
	@Basic
	@Column(name="totalvat", columnDefinition="int8")
	private Long totalvat;

	/** The totalaos - Valor Total Transacao N Tributado. */
	@Basic
	@Column(name="totalaos", columnDefinition="int8")
	private Long totalaos;

	/**
	 * Instantiates a new ejheader.
	 */
	public Ejtrailer() {
	}

	/**
	 * Gets the reg 50 PK.
	 *
	 * @return the reg 50 PK
	 */
	public Reg50PK getReg50PK() {
		return reg50PK;
	}

	/**
	 * Sets the reg 50 PK.
	 *
	 * @param reg50pk the new reg 50 PK
	 */
	public void setReg50PK(final Reg50PK reg50pk) {
		reg50PK = reg50pk;
	}

	/**
	 * Gets the rectype.
	 *
	 * @return the rectype
	 */
	public Short getRectype() {
		return rectype;
	}

	/**
	 * Sets the rectype.
	 *
	 * @param rectype the new rectype
	 */
	public void setRectype(final Short rectype) {
		this.rectype = rectype;
	}

	/**
	 * Gets the totalrounding.
	 *
	 * @return the totalrounding
	 */
	public Integer getTotalrounding() {
		return totalrounding;
	}

	/**
	 * Sets the totalrounding.
	 *
	 * @param totalrounding the new totalrounding
	 */
	public void setTotalrounding(final Integer totalrounding) {
		this.totalrounding = totalrounding;
	}

	/**
	 * Gets the totalvat.
	 *
	 * @return the totalvat
	 */
	public Long getTotalvat() {
		return totalvat;
	}

	/**
	 * Sets the totalvat.
	 *
	 * @param totalvat the new totalvat
	 */
	public void setTotalvat(final Long totalvat) {
		this.totalvat = totalvat;
	}

	/**
	 * Gets the totalaos.
	 *
	 * @return the totalaos
	 */
	public Long getTotalaos() {
		return totalaos;
	}

	/**
	 * Sets the totalaos.
	 *
	 * @param totalaos the new totalaos
	 */
	public void setTotalaos(final Long totalaos) {
		this.totalaos = totalaos;
	}

}