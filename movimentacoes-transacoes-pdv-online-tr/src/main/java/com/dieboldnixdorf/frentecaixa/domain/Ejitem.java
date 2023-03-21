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
	
	
	@Basic
	@Column(name="valortotaltefpromocao", columnDefinition="int8")
	private Long valorTotalTEFPromocao;
	
	@Basic
	@Column(name="valortotalitemicms", columnDefinition="int8")
	private Long valorTotalItemICMS;
	
	@Basic
	@Column(name="valortotalitembasecalcpis", columnDefinition="int8")
	private Long valorTotalItemBaseCalcPIS;
	
	@Basic
	@Column(name="valortotalitembasecalccofins", columnDefinition="int8")
	private Long valorTotalItemBaseCalcCOFINS;
	
	@Basic
	@Column(name="valortotalitempis", columnDefinition="int8")
	private Long valorTotalItemPIS;
	
	@Basic
	@Column(name="valortotalitemcofins", columnDefinition="int8")
	private Long valorTotalItemCOFINS;
	
	@Basic
	@Column(name="valorpercentualaliquotafiscal", columnDefinition="int8")
	private Long valorPercentualAliquotaFiscal;
	
	@Basic
	@Column(name="aliquotafcp", columnDefinition="int8")
	private Long aliquotaFCP;
	
	@Basic
	@Column(name="valorfcp", columnDefinition="int8")
	private Long valorFCP;
	
	@Basic
	@Column(name="valorbasecalcstretido", columnDefinition="int8")
	private Long valorBaseCalcSTRetido;
	
	@Basic
	@Column(name="aliquotaconsumidorfinal", columnDefinition="int8")
	private Long aliquotaConsumidorFinal;
	
	@Basic
	@Column(name="valorstretido", columnDefinition="int8")
	private Long valorSTRetido;
	
	@Basic
	@Column(name="valorbasecalcfcpstretido", columnDefinition="int8")
	private Long valorBaseCalcFCPSTRetido;
	
	@Basic
	@Column(name="percfcpstretido", columnDefinition="int8")
	private Long percFCPSTRetido;
	
	@Basic
	@Column(name="percredbasecalcefet", columnDefinition="int8")
	private Long percRedBaseCalcEfet;
	
	@Basic
	@Column(name="valorbasecalcefet", columnDefinition="int8")
	private Long valorBaseCalcEfet;
	
	@Basic
	@Column(name="aliquotaicmsefet", columnDefinition="int8")
	private Long aliquotaICMSEfet;
	
	@Basic
	@Column(name="valoricmsefet", columnDefinition="int8")
	private Long valorICMSEfet;
	
	@Basic
	@Column(name="aliquotaiss", columnDefinition="int8")
	private Long aliquotaISS;
	
	@Basic
	@Column(name="aliquotaipi", columnDefinition="int8")
	private Long aliquotaIPI;
	
	@Basic
	@Column(name="aliquotaimpostomunicipal", columnDefinition="int8")
	private Long aliquotaImpostoMunicipal;
	
	@Basic
	@Column(name="aliquotaimpostoestadual", columnDefinition="int8")
	private Long aliquotaImpostoEstadual;
	
	@Basic
	@Column(name="aliquotaimpostofederal", columnDefinition="int8")
	private Long aliquotaImpostoFederal;
	
	@Basic
	@Column(name="valoriss", columnDefinition="int8")
	private Long valorISS;
	
	@Basic
	@Column(name="valoripi", columnDefinition="int8")
	private Long valorIPI;
	
	@Basic
	@Column(name="valorimpostomunicipal", columnDefinition="int8")
	private Long valorImpostoMunicipal;
	
	@Basic
	@Column(name="valorimpostoestadual", columnDefinition="int8")
	private Long valorImpostoEstadual;
	
	@Basic
	@Column(name="valorimpostofederal", columnDefinition="int8")
	private Long valorImpostoFederal;
	
	@Basic
	@Column(name="codigocsticms", columnDefinition="int8")
	private Long codigoCSTICMS;
	
	@Basic
	@Column(name="aliquotaicmsdeson", columnDefinition="int8")
	private Long aliquotaICMSDeson;
	
	@Basic
	@Column(name="valorredbasecalcdeson", columnDefinition="int8")
	private Long valorREDBaseCalcDeson;
	
	@Basic
	@Column(name="motivodeson", columnDefinition="int8")
	private Long motivoDeson;
	
	@Basic
	@Column(name="valoricmsdeson", columnDefinition="int8")
	private Long valorICMSDeson;
	

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

	@Basic
	@Column(name="aliquotapis", columnDefinition="int8")
	private Long aliquotaPIS;
	
	@Basic
	@Column(name="aliquotacofins", columnDefinition="int8")
	private Long aliquotaCOFINS;
	
	public Long getValorTotalTEFPromocao() {
		return valorTotalTEFPromocao;
	}

	public void setValorTotalTEFPromocao(Long valorTotalTEFPromocao) {
		this.valorTotalTEFPromocao = valorTotalTEFPromocao;
	}

	public Long getValorTotalItemICMS() {
		return valorTotalItemICMS;
	}

	public void setValorTotalItemICMS(Long valorTotalItemICMS) {
		this.valorTotalItemICMS = valorTotalItemICMS;
	}

	public Long getValorTotalItemBaseCalcPIS() {
		return valorTotalItemBaseCalcPIS;
	}

	public void setValorTotalItemBaseCalcPIS(Long valorTotalItemBaseCalcPIS) {
		this.valorTotalItemBaseCalcPIS = valorTotalItemBaseCalcPIS;
	}

	public Long getValorTotalItemBaseCalcCOFINS() {
		return valorTotalItemBaseCalcCOFINS;
	}

	public void setValorTotalItemBaseCalcCOFINS(Long valorTotalItemBaseCalcCOFINS) {
		this.valorTotalItemBaseCalcCOFINS = valorTotalItemBaseCalcCOFINS;
	}

	public Long getValorTotalItemPIS() {
		return valorTotalItemPIS;
	}

	public void setValorTotalItemPIS(Long valorTotalItemPIS) {
		this.valorTotalItemPIS = valorTotalItemPIS;
	}

	public Long getValorTotalItemCOFINS() {
		return valorTotalItemCOFINS;
	}

	public void setValorTotalItemCOFINS(Long valorTotalItemCOFINS) {
		this.valorTotalItemCOFINS = valorTotalItemCOFINS;
	}

	public Long getValorPercentualAliquotaFiscal() {
		return valorPercentualAliquotaFiscal;
	}

	public void setValorPercentualAliquotaFiscal(Long valorPercentualAliquotaFiscal) {
		this.valorPercentualAliquotaFiscal = valorPercentualAliquotaFiscal;
	}

	public Long getAliquotaFCP() {
		return aliquotaFCP;
	}

	public void setAliquotaFCP(Long aliquotaFCP) {
		this.aliquotaFCP = aliquotaFCP;
	}

	public Long getValorFCP() {
		return valorFCP;
	}

	public void setValorFCP(Long valorFCP) {
		this.valorFCP = valorFCP;
	}

	public Long getValorBaseCalcSTRetido() {
		return valorBaseCalcSTRetido;
	}

	public void setValorBaseCalcSTRetido(Long valorBaseCalcSTRetido) {
		this.valorBaseCalcSTRetido = valorBaseCalcSTRetido;
	}

	public Long getAliquotaConsumidorFinal() {
		return aliquotaConsumidorFinal;
	}

	public void setAliquotaConsumidorFinal(Long aliquotaConsumidorFinal) {
		this.aliquotaConsumidorFinal = aliquotaConsumidorFinal;
	}

	public Long getValorSTRetido() {
		return valorSTRetido;
	}

	public void setValorSTRetido(Long valorSTRetido) {
		this.valorSTRetido = valorSTRetido;
	}

	public Long getValorBaseCalcFCPSTRetido() {
		return valorBaseCalcFCPSTRetido;
	}

	public void setValorBaseCalcFCPSTRetido(Long valorBaseCalcFCPSTRetido) {
		this.valorBaseCalcFCPSTRetido = valorBaseCalcFCPSTRetido;
	}

	public Long getPercFCPSTRetido() {
		return percFCPSTRetido;
	}

	public void setPercFCPSTRetido(Long percFCPSTRetido) {
		this.percFCPSTRetido = percFCPSTRetido;
	}

	public Long getPercRedBaseCalcEfet() {
		return percRedBaseCalcEfet;
	}

	public void setPercRedBaseCalcEfet(Long percRedBaseCalcEfet) {
		this.percRedBaseCalcEfet = percRedBaseCalcEfet;
	}

	public Long getValorBaseCalcEfet() {
		return valorBaseCalcEfet;
	}

	public void setValorBaseCalcEfet(Long valorBaseCalcEfet) {
		this.valorBaseCalcEfet = valorBaseCalcEfet;
	}

	public Long getAliquotaICMSEfet() {
		return aliquotaICMSEfet;
	}

	public void setAliquotaICMSEfet(Long aliquotaICMSEfet) {
		this.aliquotaICMSEfet = aliquotaICMSEfet;
	}

	public Long getValorICMSEfet() {
		return valorICMSEfet;
	}

	public void setValorICMSEfet(Long valorICMSEfet) {
		this.valorICMSEfet = valorICMSEfet;
	}

	public Long getAliquotaISS() {
		return aliquotaISS;
	}

	public void setAliquotaISS(Long aliquotaISS) {
		this.aliquotaISS = aliquotaISS;
	}

	public Long getAliquotaIPI() {
		return aliquotaIPI;
	}

	public void setAliquotaIPI(Long aliquotaIPI) {
		this.aliquotaIPI = aliquotaIPI;
	}

	public Long getAliquotaImpostoMunicipal() {
		return aliquotaImpostoMunicipal;
	}

	public void setAliquotaImpostoMunicipal(Long aliquotaImpostoMunicipal) {
		this.aliquotaImpostoMunicipal = aliquotaImpostoMunicipal;
	}

	public Long getAliquotaImpostoEstadual() {
		return aliquotaImpostoEstadual;
	}

	public void setAliquotaImpostoEstadual(Long aliquotaImpostoEstadual) {
		this.aliquotaImpostoEstadual = aliquotaImpostoEstadual;
	}

	public Long getAliquotaImpostoFederal() {
		return aliquotaImpostoFederal;
	}

	public void setAliquotaImpostoFederal(Long aliquotaImpostoFederal) {
		this.aliquotaImpostoFederal = aliquotaImpostoFederal;
	}

	public Long getValorISS() {
		return valorISS;
	}

	public void setValorISS(Long valorISS) {
		this.valorISS = valorISS;
	}

	public Long getValorIPI() {
		return valorIPI;
	}

	public void setValorIPI(Long valorIPI) {
		this.valorIPI = valorIPI;
	}

	public Long getValorImpostoMunicipal() {
		return valorImpostoMunicipal;
	}

	public void setValorImpostoMunicipal(Long valorImpostoMunicipal) {
		this.valorImpostoMunicipal = valorImpostoMunicipal;
	}

	public Long getValorImpostoEstadual() {
		return valorImpostoEstadual;
	}

	public void setValorImpostoEstadual(Long valorImpostoEstadual) {
		this.valorImpostoEstadual = valorImpostoEstadual;
	}

	public Long getValorImpostoFederal() {
		return valorImpostoFederal;
	}

	public void setValorImpostoFederal(Long valorImpostoFederal) {
		this.valorImpostoFederal = valorImpostoFederal;
	}

	public Long getCodigoCSTICMS() {
		return codigoCSTICMS;
	}

	public void setCodigoCSTICMS(Long codigoCSTICMS) {
		this.codigoCSTICMS = codigoCSTICMS;
	}

	public Long getAliquotaICMSDeson() {
		return aliquotaICMSDeson;
	}

	public void setAliquotaICMSDeson(Long aliquotaICMSDeson) {
		this.aliquotaICMSDeson = aliquotaICMSDeson;
	}

	public Long getValorREDBaseCalcDeson() {
		return valorREDBaseCalcDeson;
	}

	public void setValorREDBaseCalcDeson(Long valorREDBaseCalcDeson) {
		this.valorREDBaseCalcDeson = valorREDBaseCalcDeson;
	}

	public Long getMotivoDeson() {
		return motivoDeson;
	}

	public void setMotivoDeson(Long motivoDeson) {
		this.motivoDeson = motivoDeson;
	}

	public Long getValorICMSDeson() {
		return valorICMSDeson;
	}

	public void setValorICMSDeson(Long valorICMSDeson) {
		this.valorICMSDeson = valorICMSDeson;
	}
	
	

	public Long getAliquotaPIS() {
		return aliquotaPIS;
	}

	public void setAliquotaPIS(Long aliquotaPIS) {
		this.aliquotaPIS = aliquotaPIS;
	}



	public Long getAliquotaCOFINS() {
		return aliquotaCOFINS;
	}

	public void setAliquotaCOFINS(Long aliquotaCOFINS) {
		this.aliquotaCOFINS = aliquotaCOFINS;
	}

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

	@Override
	public String toString() {
		return "Ejitem [reg20PK=" + reg20PK + ", storenmbr=" + storenmbr + ", rectype=" + rectype + ", entrynmbr="
				+ entrynmbr + ", print1text=" + print1text + ", qty1=" + qty1 + ", price1=" + price1 + ", pludesc="
				+ pludesc + ", sumamtdisc=" + sumamtdisc + ", amtsold=" + amtsold + ", deptnmbr=" + deptnmbr
				+ ", valorTotalTEFPromocao=" + valorTotalTEFPromocao + ", valorTotalItemICMS=" + valorTotalItemICMS
				+ ", valorTotalItemBaseCalcPIS=" + valorTotalItemBaseCalcPIS + ", valorTotalItemBaseCalcCOFINS="
				+ valorTotalItemBaseCalcCOFINS + ", valorTotalItemPIS=" + valorTotalItemPIS + ", valorTotalItemCOFINS="
				+ valorTotalItemCOFINS + ", valorPercentualAliquotaFiscal=" + valorPercentualAliquotaFiscal
				+ ", aliquotaFCP=" + aliquotaFCP + ", valorFCP=" + valorFCP + ", valorBaseCalcSTRetido="
				+ valorBaseCalcSTRetido + ", aliquotaConsumidorFinal=" + aliquotaConsumidorFinal + ", valorSTRetido="
				+ valorSTRetido + ", valorBaseCalcFCPSTRetido=" + valorBaseCalcFCPSTRetido + ", percFCPSTRetido="
				+ percFCPSTRetido + ", percRedBaseCalcEfet=" + percRedBaseCalcEfet + ", valorBaseCalcEfet="
				+ valorBaseCalcEfet + ", aliquotaICMSEfet=" + aliquotaICMSEfet + ", valorICMSEfet=" + valorICMSEfet
				+ ", aliquotaISS=" + aliquotaISS + ", aliquotaIPI=" + aliquotaIPI + ", aliquotaImpostoMunicipal="
				+ aliquotaImpostoMunicipal + ", aliquotaImpostoEstadual=" + aliquotaImpostoEstadual
				+ ", aliquotaImpostoFederal=" + aliquotaImpostoFederal + ", valorISS=" + valorISS + ", valorIPI="
				+ valorIPI + ", valorImpostoMunicipal=" + valorImpostoMunicipal + ", valorImpostoEstadual="
				+ valorImpostoEstadual + ", valorImpostoFederal=" + valorImpostoFederal + ", codigoCSTICMS="
				+ codigoCSTICMS + ", aliquotaICMSDeson=" + aliquotaICMSDeson + ", valorREDBaseCalcDeson="
				+ valorREDBaseCalcDeson + ", motivoDeson=" + motivoDeson + ", valorICMSDeson=" + valorICMSDeson
				+ ", mrpprice1=" + mrpprice1 + ", mrpprice2=" + mrpprice2 + ", imeiProduto=" + imeiProduto + ", pk="
				+ pk + ", aliquotaPIS=" + aliquotaPIS + ", aliquotaCOFINS=" + aliquotaCOFINS + "]";
	}
	
	

}
