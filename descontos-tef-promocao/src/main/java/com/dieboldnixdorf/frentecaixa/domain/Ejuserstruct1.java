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
 * The Class Ejuserstruct1.
 */
@Entity
@Table
public class Ejuserstruct1 {
	
	/** The contabil PK. */
	@EmbeddedId
	private ContabilPK contabilPK;

	/** The cshrnmbr. */
	@Basic
	@Column(name="cshrnmbr", columnDefinition="int8")
	private Long cshrnmbr;

	/** The datahora. */
	@Temporal(TemporalType.TIMESTAMP)
	private Date datahora;

	/** The ulfield 2. */
	@Basic
	@Column(name="ulfield2", columnDefinition="int8")
	private Long ulfield2;

	/** The storenmbr. */
	@Basic
	@Column(name="storenmbr", columnDefinition="int4")
	private Integer storenmbr;

	/** The sznumber2. */
	@Basic
	@Column(name="sznumber2", length=2)
	private String sznumber2;
	
	/** The szuserext. */
	@Basic
	@Column(name="szuserext", length=21)
	private String szuserext;
	
	/**
	 * Instantiates a new ejuserstruct 1.
	 */
	public Ejuserstruct1() {
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
	 * Gets the cshrnmbr.
	 *
	 * @return the cshrnmbr
	 */
	public Long getCshrnmbr() {
		return cshrnmbr;
	}

	/**
	 * Sets the cshrnmbr.
	 *
	 * @param cshrnmbr the new cshrnmbr
	 */
	public void setCshrnmbr(final Long cshrnmbr) {
		this.cshrnmbr = cshrnmbr;
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

	/**
	 * Gets the ulfield 2.
	 *
	 * @return the ulfield 2
	 */
	public Long getUlfield2() {
		return ulfield2;
	}

	/**
	 * Sets the ulfield 2.
	 *
	 * @param ulfield2 the new ulfield 2
	 */
	public void setUlfield2(final Long ulfield2) {
		this.ulfield2 = ulfield2;
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
	 * Gets the sznumber 2.
	 *
	 * @return the sznumber 2
	 */
	public String getSznumber2() {
		return sznumber2;
	}

	/**
	 * Sets the sznumber 2.
	 *
	 * @param sznumber2 the new sznumber 2
	 */
	public void setSznumber2(final String sznumber2) {
		this.sznumber2 = sznumber2;
	}

	/**
	 * Gets the szuserext.
	 *
	 * @return the szuserext
	 */
	public String getSzuserext() {
		return szuserext;
	}

	/**
	 * Sets the szuserext.
	 *
	 * @param szuserext the new szuserext
	 */
	public void setSzuserext(final String szuserext) {
		this.szuserext = szuserext;
	}

}