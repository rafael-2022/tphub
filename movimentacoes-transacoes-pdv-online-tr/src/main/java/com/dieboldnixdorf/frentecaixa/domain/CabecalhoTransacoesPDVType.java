//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.03.07 at 10:35:36 PM BRT 
//


package com.dieboldnixdorf.frentecaixa.domain;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * <p>Java class for CabecalhoTransacoesPDVType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CabecalhoTransacoesPDVType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codigoTransacaoInterno"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int"&gt;
 *               &lt;enumeration value="10"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="clienteCPF" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="11"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="numeroCartaoCarrefour" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="21"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="recepcionistaDRT" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long"&gt;
 *               &lt;maxExclusive value="99999999999"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="idPDVPeriferico" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int"&gt;
 *               &lt;enumeration value="0"/&gt;
 *               &lt;enumeration value="1"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="CPFClienteCarrefour" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="11"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="telefoneCliente" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;minLength value="0"/&gt;
 *               &lt;maxLength value="1"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
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
@XmlType(name = "CabecalhoTransacoesPDVType", propOrder = {
    "codigoTransacaoInterno",
    "PK",
    "clienteCPF",
    "numeroCartaoCarrefour",
    "recepcionistaDRT",
    "idPDVPeriferico",
    "cpfClienteCarrefour",
    "telefoneCliente",
    "horaMinutoEvento"
})
@JsonPropertyOrder({ 
    "codigoTransacaoInterno",
    "PK",
    "clienteCPF",
    "numeroCartaoCarrefour",
    "recepcionistaDRT",
    "idPDVPeriferico",
    "cpfClienteCarrefour",
    "telefoneCliente",
    "horaMinutoEvento"
})
public class CabecalhoTransacoesPDVType
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    protected int codigoTransacaoInterno;
    protected Long pk;
    protected String clienteCPF;
    protected String numeroCartaoCarrefour;
    protected Long recepcionistaDRT;
    protected Integer idPDVPeriferico;
    @XmlElement(name = "cpfClienteCarrefour")
    protected String cpfClienteCarrefour;
    protected String telefoneCliente;
    @XmlElement(required = true)
    protected String horaMinutoEvento;

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
     * Gets / sets the value of pk
     */
    @JsonProperty("PK")
    public Long getPk() {
        return pk;
    } 

    public void setPk(Long value) {
        this.pk = value;
    }

    /**
     * Gets the value of the clienteCPF property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClienteCPF() {
        return clienteCPF;
    }

    /**
     * Sets the value of the clienteCPF property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClienteCPF(String value) {
        this.clienteCPF = value;
    }

    /**
     * Gets the value of the numeroCartaoCarrefour property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroCartaoCarrefour() {
        return numeroCartaoCarrefour;
    }

    /**
     * Sets the value of the numeroCartaoCarrefour property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroCartaoCarrefour(String value) {
        this.numeroCartaoCarrefour = value;
    }

    /**
     * Gets the value of the recepcionistaDRT property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getRecepcionistaDRT() {
        return recepcionistaDRT;
    }

    /**
     * Sets the value of the recepcionistaDRT property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setRecepcionistaDRT(Long value) {
        this.recepcionistaDRT = value;
    }

    /**
     * Gets the value of the idPDVPeriferico property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdPDVPeriferico() {
        return idPDVPeriferico;
    }

    /**
     * Sets the value of the idPDVPeriferico property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdPDVPeriferico(Integer value) {
        this.idPDVPeriferico = value;
    }

    /**
     * Gets the value of the cpfClienteCarrefour property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCpfClienteCarrefour() {
        return cpfClienteCarrefour;
    }

    /**
     * Sets the value of the cpfClienteCarrefour property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCpfClienteCarrefour(String value) {
        this.cpfClienteCarrefour = value;
    }

    /**
     * Gets the value of the telefoneCliente property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTelefoneCliente() {
        return telefoneCliente;
    }

    /**
     * Sets the value of the telefoneCliente property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTelefoneCliente(String value) {
        this.telefoneCliente = value;
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

}