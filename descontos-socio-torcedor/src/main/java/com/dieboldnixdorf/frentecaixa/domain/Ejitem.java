package com.dieboldnixdorf.frentecaixa.domain;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The Class Ejitem.
 */
@Entity
@Table
public class Ejitem {

	/** The contabil PK. */
	@EmbeddedId
	private ContabilPK contabilPK;
	
	/** The amtmkdn. */
	@Basic
	@Column(name="amtsold", columnDefinition="int8")
	private Long amtsold;

	/** The storenmbr. */
	@Basic
	@Column(name="storenmbr", columnDefinition="int4")
	private Integer storenmbr;

	/** The datahora. */
	@Temporal(TemporalType.TIMESTAMP)
	private Date datahora;

	/** The sznumber 2. */
	@Basic
	@Column(name="print2text", columnDefinition="bpchar", length=21)
	private String print2text;

	/** The qtymkdn. */
	@Basic
	@Column(name="qtysold", columnDefinition="int8")
	private Long qtysold;

	/** The cshrnmbr. */
	@Basic
	@Column(name="cshrnmbr", columnDefinition="int2")
	private Short cshrnmbr;

	/**
	 * Instantiates a new ejitem.
	 */
	public Ejitem() {
	}

	/**
	 * Gets the contabil PK.
	 *
	 * @return the contabil PK
	 */
	public ContabilPK getContabilPK() {
		return contabilPK;
	}

	/**
	 * Sets the contabil PK.
	 *
	 * @param contabilPK the new contabil PK
	 */
	public void setContabilPK(final ContabilPK contabilPK) {
		this.contabilPK = contabilPK;
	}

	/**
	 * Gets the prints the 2 text.
	 *
	 * @return the prints the 2 text
	 */
	public String getPrint2text() {
		return print2text;
	}

	/**
	 * Sets the prints the 2 text.
	 *
	 * @param print2text the new prints the 2 text
	 */
	public void setPrint2text(final String print2text) {
		this.print2text = print2text;
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
	 * Gets the cshrnmbr.
	 *
	 * @return the cshrnmbr
	 */
	public Short getCshrnmbr() {
		return cshrnmbr;
	}

	/**
	 * Sets the cshrnmbr.
	 *
	 * @param cshrnmbr the new cshrnmbr
	 */
	public void setCshrnmbr(final Short cshrnmbr) {
		this.cshrnmbr = cshrnmbr;
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
	 * Gets the datahora.
	 *
	 * @return the datahora
	 */
	public Date getDatahora() {
		return datahora;
	}

	/**
	 * Sets the datahora.
	 *
	 * @param datahora the new datahora
	 */
	public void setDatahora(final Date datahora) {
		this.datahora = datahora;
	}

}