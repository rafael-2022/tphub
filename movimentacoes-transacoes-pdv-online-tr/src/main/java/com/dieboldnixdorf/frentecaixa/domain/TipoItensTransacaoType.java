//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.03.07 at 10:35:36 PM BRT 
//


package com.dieboldnixdorf.frentecaixa.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.dieboldnixdorf.frentecaixa.domain.TransacoesPDVPayloadType;


/**
 * <p>Java class for TipoItensTransacaoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TipoItensTransacaoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="itemTransacao" type="{http://www.dieboldnixdorf.com/frentecaixa/TransacoesPDVPayload}TransacoesPDVPayloadType" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TipoItensTransacaoType", propOrder = {
    "itemTransacao"
})
public class TipoItensTransacaoType
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(required = true)
    protected List<TransacoesPDVPayloadType> itemTransacao;

    /**
     * Gets the value of the itemTransacao property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the itemTransacao property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItemTransacao().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TransacoesPDVPayloadType }
     * 
     * 
     */
    public List<TransacoesPDVPayloadType> getItemTransacao() {
        if (itemTransacao == null) {
            itemTransacao = new ArrayList<TransacoesPDVPayloadType>();
        }
        return this.itemTransacao;
    }

}
