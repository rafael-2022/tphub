package com.dieboldnixdorf.frentecaixa.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * The Class Ejuserstruct1.
 */
@Entity
@Table
public class Ejuserstruct1 {
	
	/** The fiscal PK. */
	@EmbeddedId
	private FiscalPK fiscalPK;

	/** The storenmbr. */
	@Basic
	@Column(name="storenmbr", columnDefinition="int4")
	private Integer storenmbr;
	
	/** The date. */
	@Basic
	@Column(name="date", length=16)
	private String date;
	
	/** The lfield1 (Contador Reducoes). */
	@Basic
	@Column(name="lfield1", columnDefinition="int4")
	private Integer lfield1;

	/** The ulfield 1 (ValorTotalCancelados). */
	@Basic
	@Column(name="ulfield1", columnDefinition="int8")
	private Long ulfield1;
	
	/** The ulfield 2 (ContadorReinicioOperacao). */
	@Basic
	@Column(name="ulfield2", columnDefinition="int8")
	private Long ulfield2;

	/** The sznumber1 (TotalizadorGeralInicial). */
	@Basic
	@Column(name="sznumber1", length=2)
	private String sznumber1;
	
	/** The sznumber2 (TotalizadorGeralFInal). */
	@Basic
	@Column(name="sznumber2", length=2)
	private String sznumber2;
	
	/**
	 * Instantiates a new ejuserstruct 1.
	 */
	public Ejuserstruct1() {
	}


	/**
	 * Gets the fiscal PK.
	 *
	 * @return the fiscal PK
	 */
	public FiscalPK getFiscalPK() {
		return fiscalPK;
	}


	/**
	 * Sets the fiscal PK.
	 *
	 * @param fiscalPK the new fiscal PK
	 */
	public void setFiscalPK(final FiscalPK fiscalPK) {
		this.fiscalPK = fiscalPK;
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
}