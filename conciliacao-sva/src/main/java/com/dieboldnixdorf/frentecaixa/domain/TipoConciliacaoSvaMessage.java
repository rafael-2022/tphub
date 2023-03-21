//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementa��o de Refer�ncia (JAXB) de Bind XML, v2.2.8-b130911.1802 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modifica��es neste arquivo ser�o perdidas ap�s a recompila��o do esquema de origem. 
// Gerado em: 2018.08.24 �s 10:54:54 AM BRT 
//


package com.dieboldnixdorf.frentecaixa.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.dieboldnixdorf.frentecaixa.domain.TipoCabecalho;
import com.dieboldnixdorf.frentecaixa.domain.TipoConciliacaoSvaPayload;
import java.util.List;


/**
 * <p>Classe Java de TipoConciliacaoSvaMessage complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TipoConciliacaoSvaMessage">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cabecalho" type="{http://www.dieboldnixdorf.com/frentecaixa/TipoCabecalho}TipoCabecalho"/>
 *         &lt;element name="detalhe" type="{http://www.dieboldnixdorf.com/frentecaixa/TipoConciliacaoSvaPayload}TipoConciliacaoSvaPayload"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TipoConciliacaoSvaMessage", propOrder = {
    "cabecalho",
    "detalhe"
})
public class TipoConciliacaoSvaMessage {

    @XmlElement(required = true)
    protected TipoCabecalho cabecalho;
    @XmlElement(required = true)
    protected List<TipoConciliacaoSvaPayload> detalhe;

    /**
     * Obt�m o valor da propriedade cabecalho.
     * 
     * @return
     *     possible object is
     *     {@link TipoCabecalho }
     *     
     */
    public TipoCabecalho getCabecalho() {
        return cabecalho;
    }

    /**
     * Define o valor da propriedade cabecalho.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoCabecalho }
     *     
     */
    public void setCabecalho(TipoCabecalho value) {
        this.cabecalho = value;
    }

    /**
     * Obt�m o valor da propriedade detalhe.
     * 
     * @return
     *     possible object is
     *     {@link TipoConciliacaoSvaPayload }
     *     
     */
    public List<TipoConciliacaoSvaPayload> getDetalhe() {
        return detalhe;
    }

    /**
     * Define o valor da propriedade detalhe.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoConciliacaoSvaPayload }
     *     
     */
    public void setDetalhe(List<TipoConciliacaoSvaPayload> value) {
        this.detalhe = value;
    }

}
