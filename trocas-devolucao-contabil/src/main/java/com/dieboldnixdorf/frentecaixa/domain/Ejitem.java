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
	
	/** The contabil PK. */
	@EmbeddedId
	private ContabilPK contabilPK;

	/** The doctnmbr (numeroDocumento - devbalcao). */
	@Column(name="productgrpnmbr", columnDefinition="int8")
	private Long productgrpnmbr;

	/** The tpdev (tipoDevolucao - devbalcao). */
	@Basic
	@Column(name="entrynmbr", length=2)
	private String entrynmbr;

	/** The termnmbr (numeroEFC - devbalcao). */
	@Basic
	@Column(name="sumamtdisc", columnDefinition="int8")
	private Long sumamtdisc;

	/** The amtdev (valorDevolucao - devbalcao). */
	@Basic
	@Column(name="mngrovnmbr", columnDefinition="int8")
	private Long mngrovnmbr;

	/** The taxnmbr (valorAliquota - cust_acc). */
	@Basic
	@Column(name="pludesc", length=20)
	private String pludesc;

	/** The cshrnmbr (codigoOperadora - devbalcao). */
	@Basic
	@Column(name="cshrnmbr", columnDefinition="int8")
	private Long cshrnmbr;

	/** The Base Calculo PIS. */
	@Basic
	@Column(name="mrpprice1", columnDefinition="int8")
	private Long mrpprice1;

	/** The Base Calculo COFINS. */
	@Basic
	@Column(name="mrpprice2", columnDefinition="int8")
	private Long mrpprice2;

	/** The Valor Calculo PIS. */
	@Basic
	@Column(name="mrpprice3", columnDefinition="int8")
	private Long mrpprice3;

	/** The Valor Calculo COFINS. */
	@Basic
	@Column(name="mrpprice4", columnDefinition="int8")
	private Long mrpprice4;

	/** The Valor Imposto. */
	@Basic
	@Column(name="mrpprice5", columnDefinition="int8")
	private Long mrpprice5;

	/** The flagCupom (devbalcao). */
	@Basic
	@Column(name="print1text", length=1)
	private String print1text;

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
	 * Gets the sumamtdisc.
	 *
	 * @return the sumamtdisc
	 */
	public Long getSumamtdisc() {
		return sumamtdisc;
	}

	/**
	 * Sets the sumamtdisc.
	 *
	 * @param sumamtdisc the new sumamtdisc
	 */
	public void setSumamtdisc(final Long sumamtdisc) {
		this.sumamtdisc = sumamtdisc;
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
	 * Gets the pludesc.
	 *
	 * @return the pludesc
	 */
	public String getPludesc() {
		return pludesc;
	}

	/**
	 * Sets the pludesc.
	 *
	 * @param pludesc the new pludesc
	 */
	public void setPludesc(final String pludesc) {
		this.pludesc = pludesc;
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
	 * Gets the mrpprice 3.
	 *
	 * @return the mrpprice 3
	 */
	public Long getMrpprice3() {
		return mrpprice3;
	}

	/**
	 * Sets the mrpprice 3.
	 *
	 * @param mrpprice3 the new mrpprice 3
	 */
	public void setMrpprice3(final Long mrpprice3) {
		this.mrpprice3 = mrpprice3;
	}

	/**
	 * Gets the mrpprice 4.
	 *
	 * @return the mrpprice 4
	 */
	public Long getMrpprice4() {
		return mrpprice4;
	}

	/**
	 * Sets the mrpprice 4.
	 *
	 * @param mrpprice4 the new mrpprice 4
	 */
	public void setMrpprice4(final Long mrpprice4) {
		this.mrpprice4 = mrpprice4;
	}

	/**
	 * Gets the mrpprice 5.
	 *
	 * @return the mrpprice 5
	 */
	public Long getMrpprice5() {
		return mrpprice5;
	}

	/**
	 * Sets the mrpprice 5.
	 *
	 * @param mrpprice5 the new mrpprice 5
	 */
	public void setMrpprice5(final Long mrpprice5) {
		this.mrpprice5 = mrpprice5;
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
	 * Gets the productgrpnmbr.
	 *
	 * @return the productgrpnmbr
	 */
	public Long getProductgrpnmbr() {
		return productgrpnmbr;
	}

	/**
	 * Sets the productgrpnmbr.
	 *
	 * @param productgrpnmbr the new productgrpnmbr
	 */
	public void setProductgrpnmbr(final Long productgrpnmbr) {
		this.productgrpnmbr = productgrpnmbr;
	}

	/**
	 * Gets the entrynmbr.
	 *
	 * @return the entrynmbr
	 */
	public String getEntrynmbr() {
		return entrynmbr;
	}

	/**
	 * Sets the entrynmbr.
	 *
	 * @param entrynmbr the new entrynmbr
	 */
	public void setEntrynmbr(final String entrynmbr) {
		this.entrynmbr = entrynmbr;
	}

}