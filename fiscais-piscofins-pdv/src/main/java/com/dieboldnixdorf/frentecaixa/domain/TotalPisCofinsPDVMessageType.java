//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.03.13 at 05:37:11 PM BRT 
//


package com.dieboldnixdorf.frentecaixa.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.dieboldnixdorf.frentecaixa.domain.CabecalhoType;
import com.dieboldnixdorf.frentecaixa.domain.TotalPisCofinsPDVPayloadType;


/**
 * <p>Java class for TotalPisCofinsPDVMessageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TotalPisCofinsPDVMessageType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="cabecalho" type="{http://www.dieboldnixdorf.com/frentecaixa/TipoCabecalho}CabecalhoType"/&gt;
 *         &lt;element name="pisconfinsECF" type="{http://www.dieboldnixdorf.com/frentecaixa/TotalPisCofinsPDVPayload}TotalPisCofinsPDVPayloadType" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TotalPisCofinsPDVMessageType", propOrder = {
    "cabecalho",
    "pisconfinsECF"
})
public class TotalPisCofinsPDVMessageType
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(required = true)
    protected CabecalhoType cabecalho;
    @XmlElement(required = true)
    protected List<TotalPisCofinsPDVPayloadType> pisconfinsECF;

    /**
     * Gets the value of the cabecalho property.
     * 
     * @return
     *     possible object is
     *     {@link CabecalhoType }
     *     
     */
    public CabecalhoType getCabecalho() {
        return cabecalho;
    }

    /**
     * Sets the value of the cabecalho property.
     * 
     * @param value
     *     allowed object is
     *     {@link CabecalhoType }
     *     
     */
    public void setCabecalho(CabecalhoType value) {
        this.cabecalho = value;
    }

    /**
     * Gets the value of the pisconfinsECF property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the pisconfinsECF property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPisconfinsECF().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TotalPisCofinsPDVPayloadType }
     * 
     * 
     */
    public List<TotalPisCofinsPDVPayloadType> getPisconfinsECF() {
        if (pisconfinsECF == null) {
            pisconfinsECF = new ArrayList<TotalPisCofinsPDVPayloadType>();
        }
        return this.pisconfinsECF;
    }

}
