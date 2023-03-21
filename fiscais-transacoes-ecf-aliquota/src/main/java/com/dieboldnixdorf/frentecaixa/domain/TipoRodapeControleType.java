//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.05.03 at 07:16:10 PM BRT 
//


package com.dieboldnixdorf.frentecaixa.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;


/**
 * <p>Java class for TipoRodapeControleType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TipoRodapeControleType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="nomeArquivoInterface"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="8"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="dataMovimento" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="numeroRegistrosArquivo"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int"&gt;
 *               &lt;maxExclusive value="9999"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="valorContabilTotal" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="baseCalculoTotal" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="impostoDebitadoTotal" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="numeroClientesTotal"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long"&gt;
 *               &lt;maxExclusive value="9999999999"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="numeroMapaResumo"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int"&gt;
 *               &lt;maxExclusive value="999999"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TipoRodapeControleType", propOrder = {
    "nomeArquivoInterface",
    "dataMovimento",
    "numeroRegistrosArquivo",
    "valorContabilTotal",
    "baseCalculoTotal",
    "impostoDebitadoTotal",
    "numeroClientesTotal",
    "numeroMapaResumo"
})
@JsonPropertyOrder({ 
    "nomeArquivoInterface",
    "dataMovimento",
    "numeroRegistrosArquivo",
    "valorContabilTotal",
    "baseCalculoTotal",
    "impostoDebitadoTotal",
    "numeroClientesTotal",
    "numeroMapaResumo"
})
public class TipoRodapeControleType
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(required = true)
    protected String nomeArquivoInterface;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    @JsonProperty("dataMovimento")
    @JsonSerialize(using = DataControleSerializer.class)
    protected Calendar dataMovimento;
    protected int numeroRegistrosArquivo;
    @XmlElement(required = true)
    @JsonProperty("valorContabilTotal")
    @JsonSerialize(using = BigDecimalSerializer.class)
    protected BigDecimal valorContabilTotal;
    @XmlElement(required = true)
    @JsonProperty("baseCalculoTotal")
    @JsonSerialize(using = BigDecimalSerializer.class)
    protected BigDecimal baseCalculoTotal;
    @XmlElement(required = true)
    @JsonProperty("impostoDebitadoTotal")
    @JsonSerialize(using = BigDecimalSerializer.class)
    protected BigDecimal impostoDebitadoTotal;
    protected long numeroClientesTotal;
    protected int numeroMapaResumo;

    /**
     * Gets the value of the nomeArquivoInterface property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomeArquivoInterface() {
        return nomeArquivoInterface;
    }

    /**
     * Sets the value of the nomeArquivoInterface property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomeArquivoInterface(String value) {
        this.nomeArquivoInterface = value;
    }

    /**
     * Gets the value of the dataMovimento property.
     * 
     * @return
     *     possible object is
     *     {@link Calendar }
     *     
     */
    public Calendar getDataMovimento() {
        return dataMovimento;
    }

    /**
     * Sets the value of the dataMovimento property.
     * 
     * @param value
     *     allowed object is
     *     {@link Calendar }
     *     
     */
    public void setDataMovimento(Calendar value) {
        this.dataMovimento = value;
    }

    /**
     * Gets the value of the numeroRegistrosArquivo property.
     * 
     */
    public int getNumeroRegistrosArquivo() {
        return numeroRegistrosArquivo;
    }

    /**
     * Sets the value of the numeroRegistrosArquivo property.
     * 
     */
    public void setNumeroRegistrosArquivo(int value) {
        this.numeroRegistrosArquivo = value;
    }

    /**
     * Gets the value of the valorContabilTotal property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getValorContabilTotal() {
        return valorContabilTotal;
    }

    /**
     * Sets the value of the valorContabilTotal property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setValorContabilTotal(BigDecimal value) {
        this.valorContabilTotal = value;
    }

    /**
     * Gets the value of the baseCalculoTotal property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getBaseCalculoTotal() {
        return baseCalculoTotal;
    }

    /**
     * Sets the value of the baseCalculoTotal property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setBaseCalculoTotal(BigDecimal value) {
        this.baseCalculoTotal = value;
    }

    /**
     * Gets the value of the impostoDebitadoTotal property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getImpostoDebitadoTotal() {
        return impostoDebitadoTotal;
    }

    /**
     * Sets the value of the impostoDebitadoTotal property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setImpostoDebitadoTotal(BigDecimal value) {
        this.impostoDebitadoTotal = value;
    }

    /**
     * Gets the value of the numeroClientesTotal property.
     * 
     */
    public long getNumeroClientesTotal() {
        return numeroClientesTotal;
    }

    /**
     * Sets the value of the numeroClientesTotal property.
     * 
     */
    public void setNumeroClientesTotal(long value) {
        this.numeroClientesTotal = value;
    }

    /**
     * Gets the value of the numeroMapaResumo property.
     * 
     */
    public int getNumeroMapaResumo() {
        return numeroMapaResumo;
    }

    /**
     * Sets the value of the numeroMapaResumo property.
     * 
     */
    public void setNumeroMapaResumo(int value) {
        this.numeroMapaResumo = value;
    }

}
