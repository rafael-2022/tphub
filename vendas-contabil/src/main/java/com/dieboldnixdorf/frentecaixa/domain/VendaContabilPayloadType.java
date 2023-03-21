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
 * <p>Java class for VendaContabilPayloadType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VendaContabilPayloadType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="numeroECF"&gt;
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
 *         &lt;element name="tipoRecebimento"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="2"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="valorContabil" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VendaContabilPayloadType", propOrder = {
    "numeroECF",
    "codigoOperadora",
    "tipoRecebimento",
    "valorContabil"
})
@JsonPropertyOrder({ 
    "numeroECF",
    "codigoOperadora",
    "tipoRecebimento",
    "valorContabil"
})
public class VendaContabilPayloadType
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    protected int numeroECF;
    protected long codigoOperadora;
    @XmlElement(required = true)
    protected String tipoRecebimento;
    @XmlElement(required = true)
    @JsonProperty("valorContabil")
    @JsonSerialize(using = BigDecimalSerializer.class)
    protected BigDecimal valorContabil;

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
     * Gets the value of the tipoRecebimento property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoRecebimento() {
        return tipoRecebimento;
    }

    /**
     * Sets the value of the tipoRecebimento property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoRecebimento(String value) {
        this.tipoRecebimento = value;
    }

    /**
     * Gets the value of the valorContabil property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getValorContabil() {
        return valorContabil;
    }

    /**
     * Sets the value of the valorContabil property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setValorContabil(BigDecimal value) {
        this.valorContabil = value;
    }

}
