package com.dieboldnixdorf.frentecaixa.domain;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The Class Ejuserstruct1.
 */
@Entity
@Table
public class Ejuserstruct1 {
	
	/** The transnmbr. */
	@Id
	@Column(name="transnmbr", columnDefinition="int4")
	private Integer transnmbr;

	/** The termnmbr. */
	@Basic
	@Column(name="termnmbr", columnDefinition="int2")
	private Short termnmbr;

	/** The storenmbr (numeroPDV). */
	@Basic
	@Column(name="storenmbr", columnDefinition="int4")
	private Integer storenmbr;

	/** The cshrnmbr (drt). */
	@Basic
	@Column(name="cshrnmbr", columnDefinition="int8")
	private Long cshrnmbr;

	/** The datahora. */
	@Temporal(TemporalType.TIMESTAMP)
	private Date datahora;

	/** The ulfield 1 (ValorSangria). */
	@Basic
	@Column(name="ulfield1", columnDefinition="int8")
	private Long ulfield1;

	/** The sznumber1 (CodigoBarrasBanana). */
	@Basic
	@Column(name="sznumber1", length=21)
	private String sznumber1;
	
	/** The sznumber2 (Descricao FormaPagto). */
	@Basic
	@Column(name="sznumber2", length=21)
	private String sznumber2;

	/** The lfield2 (NumeroFormaPagto). */
	@Basic
	@Column(name="lfield2", columnDefinition="int4")
	private Integer lfield2;

	/** The functype (tipoMoeda). */
	@Basic
	@Column(name="functype", columnDefinition="int2")
	private Short functype;

	/** The szuserext (numeroBanana). */
	@Basic
	@Column(name="szuserext", length=3)
	private String szuserext;

	/**
	 * Instantiates a new ejuserstruct 1.
	 */
	public Ejuserstruct1() {
	}

	/**
	 * Instantiates a new ejuserstruct 1.
	 *
	 * @param transnmbr the transnmbr
	 */
	public Ejuserstruct1(final Integer transnmbr) {
		this.transnmbr = transnmbr;
	}

	/**
	 * Gets the transnmbr.
	 *
	 * @return the transnmbr
	 */
	public Integer getTransnmbr() {
		return transnmbr;
	}

	/**
	 * Sets the transnmbr.
	 *
	 * @param transnmbr the new transnmbr
	 */
	public void setTransnmbr(final Integer transnmbr) {
		this.transnmbr = transnmbr;
	}

	/**
	 * Gets the termnmbr.
	 *
	 * @return the termnmbr
	 */
	public Short getTermnmbr() {
		return termnmbr;
	}

	/**
	 * Sets the termnmbr.
	 *
	 * @param termnmbr the new termnmbr
	 */
	public void setTermnmbr(final Short termnmbr) {
		this.termnmbr = termnmbr;
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
	 * Gets the lfield 2.
	 *
	 * @return the lfield 2
	 */
	public Integer getLfield2() {
		return lfield2;
	}

	/**
	 * Sets the lfield 2.
	 *
	 * @param lfield2 the new lfield 2
	 */
	public void setLfield2(final Integer lfield2) {
		this.lfield2 = lfield2;
	}

	/**
	 * Gets the functype.
	 *
	 * @return the functype
	 */
	public Short getFunctype() {
		return functype;
	}

	/**
	 * Sets the functype.
	 *
	 * @param functype the new functype
	 */
	public void setFunctype(final Short functype) {
		this.functype = functype;
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