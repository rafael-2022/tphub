//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.02.11 at 03:35:05 PM BRST 
//


package com.dieboldnixdorf.frentecaixa.domain;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.dieboldnixdorf.frentecaixa.domain.TipoProdutoType;


/**
 * <p>Java class for TipoProdutosDescontosType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TipoProdutosDescontosType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="produtoAmbev" type="{http://www.dieboldnixdorf.com/frentecaixa/TipoProduto}TipoProdutoType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TipoProdutosDescontosType", propOrder = {
    "produtoAmbev"
})
public class TipoProdutosDescontosType
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(required = true)
    protected TipoProdutoType produtoAmbev;

    /**
     * Gets the value of the produtoAmbev property.
     * 
     * @return
     *     possible object is
     *     {@link TipoProdutoType }
     *     
     */
    public TipoProdutoType getProdutoAmbev() {
        return produtoAmbev;
    }

    /**
     * Sets the value of the produtoAmbev property.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoProdutoType }
     *     
     */
    public void setProdutoAmbev(TipoProdutoType value) {
        this.produtoAmbev = value;
    }

}