//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.03.14 at 10:40:05 PM BRT 
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
 * <p>Java class for TipoDepartamentoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TipoDepartamentoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="departamento" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="codigoDepartamento"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int"&gt;
 *               &lt;maxExclusive value="999"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="valorVendaLiquidaDepartamento" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="quantidadeUnidadesDepartamento" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="quantidadeClientesDepartamento" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="quantidadeClientesPerifericosDepartamento" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TipoDepartamentoType", propOrder = {
    "departamento",
    "codigoDepartamento",
    "valorVendaLiquidaDepartamento",
    "quantidadeUnidadesDepartamento",
    "quantidadeClientesDepartamento",
    "quantidadeClientesPerifericosDepartamento"
})
@JsonPropertyOrder({ 
    "departamento",
    "codigoDepartamento",
    "valorVendaLiquidaDepartamento",
    "quantidadeUnidadesDepartamento",
    "quantidadeClientesDepartamento",
    "quantidadeClientesPerifericosDepartamento"
})
public class TipoDepartamentoType
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(required = true)
    protected String departamento;
    protected int codigoDepartamento;
    @XmlElement(required = true)
    @JsonProperty("valorVendaLiquidaDepartamento")
    @JsonSerialize(using = ValorVendaLiquidaDepartamentoSerializer.class)
    protected BigDecimal valorVendaLiquidaDepartamento;
    @XmlElement(required = true)
    @JsonProperty("quantidadeUnidadesDepartamento")
    @JsonSerialize(using = BigDecimal17Serializer.class)
    protected BigDecimal quantidadeUnidadesDepartamento;
    @XmlElement(required = true)
    protected Long quantidadeClientesDepartamento;
    @XmlElement(required = true)
    protected Long quantidadeClientesPerifericosDepartamento;

    /**
     * Gets the value of the departamento property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepartamento() {
        return departamento;
    }

    /**
     * Sets the value of the departamento property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDepartamento(String value) {
        this.departamento = value;
    }

    /**
     * Gets the value of the codigoDepartamento property.
     * 
     */
    public int getCodigoDepartamento() {
        return codigoDepartamento;
    }

    /**
     * Sets the value of the codigoDepartamento property.
     * 
     */
    public void setCodigoDepartamento(int value) {
        this.codigoDepartamento = value;
    }

    /**
     * Gets the value of the valorVendaLiquidaDepartamento property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getValorVendaLiquidaDepartamento() {
        return valorVendaLiquidaDepartamento;
    }

    /**
     * Sets the value of the valorVendaLiquidaDepartamento property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setValorVendaLiquidaDepartamento(BigDecimal value) {
        this.valorVendaLiquidaDepartamento = value;
    }

    /**
     * Gets the value of the quantidadeUnidadesDepartamento property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getQuantidadeUnidadesDepartamento() {
        return quantidadeUnidadesDepartamento;
    }

    /**
     * Sets the value of the quantidadeUnidadesDepartamento property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setQuantidadeUnidadesDepartamento(BigDecimal value) {
        this.quantidadeUnidadesDepartamento = value;
    }

    /**
     * Gets the value of the quantidadeClientesDepartamento property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getQuantidadeClientesDepartamento() {
        return quantidadeClientesDepartamento;
    }

    /**
     * Sets the value of the quantidadeClientesDepartamento property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setQuantidadeClientesDepartamento(Long value) {
        this.quantidadeClientesDepartamento = value;
    }

    /**
     * Gets the value of the quantidadeClientesPerifericosDepartamento property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getQuantidadeClientesPerifericosDepartamento() {
        return quantidadeClientesPerifericosDepartamento;
    }

    /**
     * Sets the value of the quantidadeClientesPerifericosDepartamento property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setQuantidadeClientesPerifericosDepartamento(Long value) {
        this.quantidadeClientesPerifericosDepartamento = value;
    }

}
