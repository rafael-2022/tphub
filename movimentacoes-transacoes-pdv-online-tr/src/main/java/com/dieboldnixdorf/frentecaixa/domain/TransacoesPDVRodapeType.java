//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.03.07 at 10:35:36 PM BRT 
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
 * <p>Java class for TransacoesPDVRodapeType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TransacoesPDVRodapeType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codigoTransacaoInterno"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int"&gt;
 *               &lt;enumeration value="50"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="valorTransacaoTotalTributado" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="valorTransacaoTotalNaoTributado" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="valorTrocoTotal" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="horaMinutoEvento"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="4"/&gt;
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
@XmlType(name = "TransacoesPDVRodapeType", propOrder = {
    "codigoTransacaoInterno",
    "PK",
    "valorTransacaoTotalTributado",
    "valorTransacaoTotalNaoTributado",
    "valorTrocoTotal",
    "valorTrocoDigital",
    "valorTrocoDoacao",
    "horaMinutoEvento"
})
@JsonPropertyOrder({ 
    "codigoTransacaoInterno",
    "PK",
    "valorTransacaoTotalTributado",
    "valorTransacaoTotalNaoTributado",
    "valorTrocoTotal",
    "valorTrocoDigital",
    "valorTrocoDoacao",
    "horaMinutoEvento"
})
public class TransacoesPDVRodapeType
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    protected int codigoTransacaoInterno;
    @XmlElement(required = true)
    @JsonProperty("valorTransacaoTotalTributado")
    @JsonSerialize(using = BigDecimal8Serializer.class)
    protected BigDecimal valorTransacaoTotalTributado;
    @XmlElement(required = true)
    @JsonProperty("valorTransacaoTotalNaoTributado")
    @JsonSerialize(using = BigDecimal8Serializer.class)
    protected BigDecimal valorTransacaoTotalNaoTributado;
    @JsonProperty("valorTrocoTotal")
    @JsonSerialize(using = BigDecimal8Serializer.class)
    protected BigDecimal valorTrocoTotal;
    
    @JsonProperty("valorTrocoDigital")
    @JsonSerialize(using = BigDecimal8Serializer.class)
    protected BigDecimal valorTrocoDigital;
    
    @JsonProperty("valorTrocoDoacao")
    @JsonSerialize(using = BigDecimal8Serializer.class)
    protected BigDecimal valorTrocoDoacao;
    
    @XmlElement(required = true)
    protected String horaMinutoEvento;
    protected Long pk;

    
    public BigDecimal getValorTrocoDigital() {
		return valorTrocoDigital;
	}

	public void setValorTrocoDigital(BigDecimal valorTrocoDigital) {
		this.valorTrocoDigital = valorTrocoDigital;
	}

	public BigDecimal getValorTrocoDoacao() {
		return valorTrocoDoacao;
	}

	public void setValorTrocoDoacao(BigDecimal valorTrocoDoacao) {
		this.valorTrocoDoacao = valorTrocoDoacao;
	}

	/**
     * Gets the value of the codigoTransacaoInterno property.
     * 
     */
    public int getCodigoTransacaoInterno() {
        return codigoTransacaoInterno;
    }

    /**
     * Sets the value of the codigoTransacaoInterno property.
     * 
     */
    public void setCodigoTransacaoInterno(int value) {
        this.codigoTransacaoInterno = value;
    }

    /**
     * Gets the value of the valorTransacaoTotalTributado property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getValorTransacaoTotalTributado() {
        return valorTransacaoTotalTributado;
    }

    /**
     * Sets the value of the valorTransacaoTotalTributado property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setValorTransacaoTotalTributado(BigDecimal value) {
        this.valorTransacaoTotalTributado = value;
    }

    /**
     * Gets the value of the valorTransacaoTotalNaoTributado property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getValorTransacaoTotalNaoTributado() {
        return valorTransacaoTotalNaoTributado;
    }

    /**
     * Sets the value of the valorTransacaoTotalNaoTributado property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setValorTransacaoTotalNaoTributado(BigDecimal value) {
        this.valorTransacaoTotalNaoTributado = value;
    }

    /**
     * Gets the value of the valorTrocoTotal property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getValorTrocoTotal() {
        return valorTrocoTotal;
    }

    /**
     * Sets the value of the valorTrocoTotal property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setValorTrocoTotal(BigDecimal value) {
        this.valorTrocoTotal = value;
    }

    /**
     * Gets the value of the horaMinutoEvento property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHoraMinutoEvento() {
        return horaMinutoEvento;
    }

    /**
     * Sets the value of the horaMinutoEvento property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHoraMinutoEvento(String value) {
        this.horaMinutoEvento = value;
    }

    /**
     * Gets / sets the PK value
     */ 
    @JsonProperty("PK")
    public Long getPk() {
        return pk;
    }
    public void setPk(Long value) {
        this.pk = value;
    }

}