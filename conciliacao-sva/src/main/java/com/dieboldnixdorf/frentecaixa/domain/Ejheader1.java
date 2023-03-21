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
 * The Class Ejheader.
 */
@Entity
@Table
public class Ejheader1 {
	
	/** The reg10 PK. */
	@EmbeddedId
	private Reg10PK reg10PK;
	
	/** The storenmbr. */
	@Basic
	@Column(name="storenmbr", columnDefinition="int4")
	private Integer storenmbr;

	/** The mngrovnmbr. */
	@Basic
	@Column(name="mngrovnmbr", columnDefinition="int8")
	private Long mngrovnmbr;

	/** The datahora. */
	@Temporal(TemporalType.TIMESTAMP)
	private Date datahora;

	/** The rectype. */
	@Basic
	@Column(name="rectype", columnDefinition="int2")
	private Short rectype;

	/** The sznumber2 - ClienteCPF. */
	@Basic
	@Column(name="print1text", columnDefinition="bpchar", length=20)
	private String print1text;

	/** The Cartao Carrefour. */
	@Basic
	@Column(name="loyaltycardid", columnDefinition="bpchar", length=31)
	private String loyaltycardid;

	/** The cshrnmbr. */
	@Basic
	@Column(name="cshrnmbr", columnDefinition="int8")
	private Long cshrnmbr;

	/** The print2text - localizacao. */
	@Basic
	@Column(name="print2text", columnDefinition="bpchar", length=20)
	private String print2text;

	/** The disc_empxnmbr - CPFClienteCarrefour. */
	@Basic
	@Column(name="disc_empxnmbr", columnDefinition="bpchar", length=20)
	private String disc_empxnmbr;

	/** The disc_custnmbr - TelefoneCliente. */
	@Basic
	@Column(name="disc_custnmbr", columnDefinition="bpchar", length=20)
	private String disc_custnmbr;

	/**
	 * Instantiates a new ejheader.
	 */
	public Ejheader1() {
	}

	/**
	 * Gets the reg 10 PK.
	 *
	 * @return the reg 10 PK
	 */
	public Reg10PK getReg10PK() {
		return reg10PK;
	}

	/**
	 * Sets the reg 10 PK.
	 *
	 * @param reg10pk the new reg 10 PK
	 */
	public void setReg10PK(final Reg10PK reg10pk) {
		reg10PK = reg10pk;
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
	 * Gets the mngrovnmbr.
	 *
	 * @return the mngrovnmbr
	 */
	public Long getMngrovnmbr() {
		return mngrovnmbr;
	}

	/**
	 * Sets the mngrovnmbr.
	 *
	 * @param mngrovnmbr the new mngrovnmbr
	 */
	public void setMngrovnmbr(final Long mngrovnmbr) {
		this.mngrovnmbr = mngrovnmbr;
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
	 * Gets the loyaltycardid.
	 *
	 * @return the loyaltycardid
	 */
	public String getLoyaltycardid() {
		return loyaltycardid;
	}

	/**
	 * Sets the loyaltycardid.
	 *
	 * @param loyaltycardid the new loyaltycardid
	 */
	public void setLoyaltycardid(final String loyaltycardid) {
		this.loyaltycardid = loyaltycardid;
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
	 * Gets the disc empxnmbr.
	 *
	 * @return the disc empxnmbr
	 */
	public String getDisc_empxnmbr() {
		return disc_empxnmbr;
	}

	/**
	 * Sets the disc empxnmbr.
	 *
	 * @param disc_empxnmbr the new disc empxnmbr
	 */
	public void setDisc_empxnmbr(final String disc_empxnmbr) {
		this.disc_empxnmbr = disc_empxnmbr;
	}

	/**
	 * Gets the disc custnmbr.
	 *
	 * @return the disc custnmbr
	 */
	public String getDisc_custnmbr() {
		return disc_custnmbr;
	}

	/**
	 * Sets the disc custnmbr.
	 *
	 * @param disc_custnmbr the new disc custnmbr
	 */
	public void setDisc_custnmbr(final String disc_custnmbr) {
		this.disc_custnmbr = disc_custnmbr;
	}
}