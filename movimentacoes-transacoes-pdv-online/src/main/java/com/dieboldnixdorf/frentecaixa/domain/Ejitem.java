package com.dieboldnixdorf.frentecaixa.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class Ejitem.
 */
@Entity
@Table
public class Ejitem {
	
	/** The reg20 PK. */
	@EmbeddedId
	private Reg20PK reg20PK;

	/** The storenmbr. */
	@Basic
	@Column(name="storenmbr", columnDefinition="int4")
	private Integer storenmbr;

	/** The rectype. */
	@Basic
	@Column(name="rectype", columnDefinition="int2")
	private Short rectype;

	/** The entrynmbr - Tipo Cupom Fiscal Cupom Padrao. */
	@Basic
	@Column(name="entrynmbr", columnDefinition="bpchar", length=20)
	private String entrynmbr;

	/** The print1text - EANProduto. */
	@Basic
	@Column(name="print1text", columnDefinition="bpchar", length=20)
	private String print1text;

	/** The qty1 - quantidadeItensVendidos. */
	@Basic
	@Column(name="qty1", columnDefinition="int8")
	private Long qty1;

	/** The price1 - precoUnitarioLiquidoItem. */
	@Basic
	@Column(name="price1", columnDefinition="int8")
	private Long price1;

	/** The pludesc - tipoDesconto. */
	@Basic
	@Column(name="pludesc", columnDefinition="bpchar", length=20)
	private String pludesc;

	/** The sumamtdisc - valorTotalDesconto. */
	@Basic
	@Column(name="sumamtdisc", columnDefinition="int8")
	private Long sumamtdisc;

	/** The amtsold - precoUnitarioBrutoItem. */
	@Basic
	@Column(name="amtsold", columnDefinition="int8")
	private Long amtsold;

	/** The deptnmbr - codigoSetorItem. */
	@Basic
	@Column(name="deptnmbr", columnDefinition="bpchar", length=20)
	private String deptnmbr;

	/** The mrpprice 1 - Valor Total Item Tributado. */
	@Basic
	@Column(name="mrpprice1", columnDefinition="int8")
	private Long mrpprice1;

	/** The mrpprice 2 - Valor Total Item Sem Tributacao. */
	@Basic
	@Column(name="mrpprice2", columnDefinition="int8")
	private Long mrpprice2;

	@Basic
	@Column(name="imei", columnDefinition="bpchar", length=64)
	private String imeiProduto;

	@Basic
	@Column(name="pk", columnDefinition="int8")
	private Long pk;

	/**
	 * Instantiates a new ejitem.
	 */
	public Ejitem() {
	}

	/**
	 * Gets the reg 20 PK.
	 *
	 * @return the reg 20 PK
	 */
	public Reg20PK getReg20PK() {
		return reg20PK;
	}

	/**
	 * Sets the reg 20 PK.
	 *
	 * @param reg20pk the new reg 20 PK
	 */
	public void setReg20PK(final Reg20PK reg20pk) {
		reg20PK = reg20pk;
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
	 * Gets the qty 1.
	 *
	 * @return the qty 1
	 */
	public Long getQty1() {
		return qty1;
	}

	/**
	 * Sets the qty 1.
	 *
	 * @param qty1 the new qty 1
	 */
	public void setQty1(final Long qty1) {
		this.qty1 = qty1;
	}

	/**
	 * Gets the price 1.
	 *
	 * @return the price 1
	 */
	public Long getPrice1() {
		return price1;
	}

	/**
	 * Sets the price 1.
	 *
	 * @param price1 the new price 1
	 */
	public void setPrice1(final Long price1) {
		this.price1 = price1;
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
	 * Gets the deptnmbr.
	 *
	 * @return the deptnmbr
	 */
	public String getDeptnmbr() {
		return deptnmbr;
	}

	/**
	 * Sets the deptnmbr.
	 *
	 * @param deptnmbr the new deptnmbr
	 */
	public void setDeptnmbr(final String deptnmbr) {
		this.deptnmbr = deptnmbr;
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
	 * Gets / set the imeiProduto
	 */
	public String getImeiProduto() {
		return imeiProduto;
	}
	public void setImeiProduto(String value) {
		this.imeiProduto = value;
	}

	/**
	 * Gets / set the PK
	 */
	public Long getPk() {
		return pk;
	}
	public void setPk(Long value) {
		this.pk = value;
	}

}
