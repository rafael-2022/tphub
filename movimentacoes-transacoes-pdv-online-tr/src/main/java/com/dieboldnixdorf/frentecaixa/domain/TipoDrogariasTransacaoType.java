//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.02.11 at 03:35:05 PM BRST 
//


package com.dieboldnixdorf.frentecaixa.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TipoDrogariasTransacaoType", propOrder = {
    "drogaria"
})
public class TipoDrogariasTransacaoType
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(required = true)
    protected List<TipoDrogariaTransacaoType> drogaria;
    
	public List<TipoDrogariaTransacaoType> getDrogaria() {
        if (drogaria == null) {
        	drogaria = new ArrayList<TipoDrogariaTransacaoType>();
        }
		return drogaria;
	}
	
	public void setDrogaria(List<TipoDrogariaTransacaoType> drogaria) {
		this.drogaria = drogaria;
	}
	
	@Override
	public String toString() {
		return "TipoDrogariasTransacaoType [drogaria=" + drogaria + "]";
	}

}
