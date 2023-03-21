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

	/** The desconto PK. */
	@EmbeddedId
	private DescontoPK descontoPK;
	
	/** The sznumber 1. */
	@Basic
	@Column(name="sznumber1", length=21)
	private String sznumber1;

	/** The cshrnmbr. */
	@Basic
	@Column(name="cshrnmbr", columnDefinition="int8")
	private Long cshrnmbr;

	/** The hostid. */
	@Basic
	@Column(name="hostid", length=20)
	private String hostid;

	/** The ulfield 1. */
	@Basic
	@Column(name="ulfield1", columnDefinition="int8")
	private Long ulfield1;

	/** The ulfield 2. */
	@Basic
	@Column(name="ulfield2", columnDefinition="int8")
	private Long ulfield2;

	/** The lfield 1. */
	@Basic
	@Column(name="lfield1", columnDefinition="int4")
	private Integer lfield1;

	/** The status. */
	@Basic
	@Column(name="szuserext", length=21)
	private String szuserext;
	
	/** The sznumber 2. */
	@Basic
	@Column(name="sznumber2", length=21)
	private String sznumber2;

	/** The datahora. */
	@Temporal(TemporalType.TIMESTAMP)
	private Date datahora;
	
	/**
	 * Instantiates a new ejuserstruct 1.
	 */
	public Ejuserstruct1() {
	}

	/**
	 * Gets the desconto PK.
	 *
	 * @return the desconto PK
	 */
	public DescontoPK getDescontoPK() {
		return descontoPK;
	}

	/**
	 * Sets the desconto PK.
	 *
	 * @param descontoPK the new desconto PK
	 */
	public void setDescontoPK(final DescontoPK descontoPK) {
		this.descontoPK = descontoPK;
	}

	/**
	 * Gets the hostid.
	 *
	 * @return the hostid
	 */
	public String getHostid() {
		return hostid;
	}

	/**
	 * Sets the hostid.
	 *
	 * @param hostid the new hostid
	 */
	public void setHostid(final String hostid) {
		this.hostid = hostid;
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
	 * Gets the sznumber 1.
	 *
	 * @return the sznumber 1
	 */
	public String getSznumber1() {
		return sznumber1;
	}

	/**
	 * Sets the sznumber 1.
	 *
	 * @param sznumber1 the new sznumber 1
	 */
	public void setSznumber1(final String sznumber1) {
		this.sznumber1 = sznumber1;
	}

	/**
	 * Gets the ulfield 1.
	 *
	 * @return the ulfield 1
	 */
	public Long getUlfield1() {
		return ulfield1;
	}

	/**
	 * Sets the ulfield 1.
	 *
	 * @param ulfield1 the new ulfield 1
	 */
	public void setUlfield1(final Long ulfield1) {
		this.ulfield1 = ulfield1;
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
	 * Gets the lfield 1.
	 *
	 * @return the lfield 1
	 */
	public Integer getLfield1() {
		return lfield1;
	}

	/**
	 * Sets the lfield 1.
	 *
	 * @param lfield1 the new lfield 1
	 */
	public void setLfield1(final Integer lfield1) {
		this.lfield1 = lfield1;
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