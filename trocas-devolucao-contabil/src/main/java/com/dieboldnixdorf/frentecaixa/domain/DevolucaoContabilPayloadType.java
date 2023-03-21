//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.02.11 at 03:35:05 PM BRST 
//


package com.dieboldnixdorf.frentecaixa.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;


/**
 * <p>Java class for DevolucaoContabilPayloadType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DevolucaoContabilPayloadType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="tipoDevolucao"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;length value="2"/&gt;
 *               &lt;enumeration value="AN"/&gt;
 *               &lt;enumeration value="CP"/&gt;
 *               &lt;enumeration value="RD"/&gt;
 *               &lt;enumeration value="TC"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="codigoSetor"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int"&gt;
 *               &lt;maxExclusive value="99"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="numeroEFC"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int"&gt;
 *               &lt;maxExclusive value="999"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="codigoOperadora"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long"&gt;
 *               &lt;maxExclusive value="9999999999"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="valorDevolucao" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="flagCupom"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;enumeration value="N"/&gt;
 *               &lt;enumeration value="S"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="tipoAliquota"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;enumeration value="IS"/&gt;
 *               &lt;enumeration value="NT"/&gt;
 *               &lt;enumeration value="ST"/&gt;
 *               &lt;enumeration value="BR"/&gt;
 *               &lt;enumeration value="CB"/&gt;
 *               &lt;enumeration value="PI"/&gt;
 *               &lt;enumeration value="DZ"/&gt;
 *               &lt;enumeration value="NO"/&gt;
 *               &lt;enumeration value="SU"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="valorAliquota" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="valorImposto" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="numeroDocumento"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int"&gt;
 *               &lt;maxExclusive value="999999"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="valorBaseCalculoPIS" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="valorPIS" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="valorBaseCalculoCOFINS" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="valorCOFINS" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DevolucaoContabilPayloadType", propOrder = {
    "tipoDevolucao",
    "codigoSetor",
    "numeroECF",
    "codigoOperadora",
    "valorDevolucao",
    "flagCupom",
    "tipoAliquota",
    "valorAliquota",
    "valorImposto",
    "numeroDocumento",
    "valorBaseCalculoPIS",
    "valorPIS",
    "valorBaseCalculoCOFINS",
    "valorCOFINS"
})
@JsonPropertyOrder({ 
    "tipoDevolucao",
    "codigoSetor",
    "numeroECF",
    "codigoOperadora",
    "valorDevolucao",
    "flagCupom",
    "tipoAliquota",
    "valorAliquota",
    "valorImposto",
    "numeroDocumento",
    "valorBaseCalculoPIS",
    "valorPIS",
    "valorBaseCalculoCOFINS",
    "valorCOFINS"
})
public class DevolucaoContabilPayloadType
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(required = true)
    protected String tipoDevolucao;
    protected int codigoSetor;
    protected int numeroECF;
    protected long codigoOperadora;
    @XmlElement(required = true)
    @JsonProperty("valorDevolucao")
    @JsonSerialize(using = BigDecimalSerializer.class)
    protected BigDecimal valorDevolucao;
    @XmlElement(required = true)
    protected String flagCupom;
    @XmlElement(required = true)
    protected String tipoAliquota;
    @JsonProperty("valorAliquota")
    @JsonSerialize(using = BigDecimalSerializer.class)
    protected BigDecimal valorAliquota;
    @XmlElement(required = true)
    @JsonProperty("valorImposto")
    @JsonSerialize(using = BigDecimalSerializer.class)
    protected BigDecimal valorImposto;
    protected int numeroDocumento;
    @XmlElement(required = true)
    @JsonProperty("valorBaseCalculoPIS")
    @JsonSerialize(using = BigDecimalSerializer.class)
    protected BigDecimal valorBaseCalculoPIS;
    @XmlElement(required = true)
    @JsonProperty("valorPIS")
    @JsonSerialize(using = BigDecimalSerializer.class)
    protected BigDecimal valorPIS;
    @XmlElement(required = true)
    @JsonProperty("valorBaseCalculoCOFINS")
    @JsonSerialize(using = BigDecimalSerializer.class)
    protected BigDecimal valorBaseCalculoCOFINS;
    @XmlElement(required = true)
    @JsonProperty("valorCOFINS")
    @JsonSerialize(using = BigDecimalSerializer.class)
    protected BigDecimal valorCOFINS;

    /**
     * Gets the value of the tipoDevolucao property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoDevolucao() {
        return tipoDevolucao;
    }

    /**
     * Sets the value of the tipoDevolucao property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoDevolucao(String value) {
        this.tipoDevolucao = value;
    }

    /**
     * Gets the value of the codigoSetor property.
     * 
     */
    public int getCodigoSetor() {
        return codigoSetor;
    }

    /**
     * Sets the value of the codigoSetor property.
     * 
     */
    public void setCodigoSetor(int value) {
        this.codigoSetor = value;
    }

    /**
     * Gets the value of the numeroECF property.
     * 
     */
    public int getNumeroECF() {
        return numeroECF;
    }

    /**
     * Sets the value of the numeroECF property.
     * 
     */
    public void setNumeroECF(int value) {
        this.numeroECF = value;
    }

    /**
     * Gets the value of the codigoOperadora property.
     * 
     */
    public long getCodigoOperadora() {
        return codigoOperadora;
    }

    /**
     * Sets the value of the codigoOperadora property.
     * 
     */
    public void setCodigoOperadora(long value) {
        this.codigoOperadora = value;
    }

    /**
     * Gets the value of the valorDevolucao property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getValorDevolucao() {
        return valorDevolucao;
    }

    /**
     * Sets the value of the valorDevolucao property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setValorDevolucao(BigDecimal value) {
        this.valorDevolucao = value;
    }

    /**
     * Gets the value of the flagCupom property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlagCupom() {
        return flagCupom;
    }

    /**
     * Sets the value of the flagCupom property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlagCupom(String value) {
        this.flagCupom = value;
    }

    /**
     * Gets the value of the tipoAliquota property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoAliquota() {
        return tipoAliquota;
    }

    /**
     * Sets the value of the tipoAliquota property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoAliquota(String value) {
        this.tipoAliquota = value;
    }

    /**
     * Gets the value of the valorAliquota property.
     * 
     */
    public BigDecimal getValorAliquota() {
        return valorAliquota;
    }

    /**
     * Sets the value of the valorAliquota property.
     * 
     */
    public void setValorAliquota(BigDecimal value) {
        this.valorAliquota = value;
    }

    /**
     * Gets the value of the valorImposto property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getValorImposto() {
        return valorImposto;
    }

    /**
     * Sets the value of the valorImposto property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setValorImposto(BigDecimal value) {
        this.valorImposto = value;
    }

    /**
     * Gets the value of the numeroDocumento property.
     * 
     */
    public int getNumeroDocumento() {
        return numeroDocumento;
    }

    /**
     * Sets the value of the numeroDocumento property.
     * 
     */
    public void setNumeroDocumento(int value) {
        this.numeroDocumento = value;
    }

    /**
     * Gets the value of the valorBaseCalculoPIS property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getValorBaseCalculoPIS() {
        return valorBaseCalculoPIS;
    }

    /**
     * Sets the value of the valorBaseCalculoPIS property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setValorBaseCalculoPIS(BigDecimal value) {
        this.valorBaseCalculoPIS = value;
    }

    /**
     * Gets the value of the valorPIS property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getValorPIS() {
        return valorPIS;
    }

    /**
     * Sets the value of the valorPIS property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setValorPIS(BigDecimal value) {
        this.valorPIS = value;
    }

    /**
     * Gets the value of the valorBaseCalculoCOFINS property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getValorBaseCalculoCOFINS() {
        return valorBaseCalculoCOFINS;
    }

    /**
     * Sets the value of the valorBaseCalculoCOFINS property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setValorBaseCalculoCOFINS(BigDecimal value) {
        this.valorBaseCalculoCOFINS = value;
    }

    /**
     * Gets the value of the valorCOFINS property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getValorCOFINS() {
        return valorCOFINS;
    }

    /**
     * Sets the value of the valorCOFINS property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setValorCOFINS(BigDecimal value) {
        this.valorCOFINS = value;
    }

}
