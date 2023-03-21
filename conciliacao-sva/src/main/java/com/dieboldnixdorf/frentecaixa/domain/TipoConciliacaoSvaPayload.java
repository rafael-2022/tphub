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
import com.dieboldnixdorf.frentecaixa.domain.TipoIdentificacaoTicket;
import com.dieboldnixdorf.frentecaixa.domain.TipoRecuperacaoPedido;
import com.dieboldnixdorf.frentecaixa.domain.TipoRegistroIdentificacaoItens;
import com.dieboldnixdorf.frentecaixa.domain.TipoRegistroMeioPagamento;
import com.dieboldnixdorf.frentecaixa.domain.TipoStatus;


/**
 * <p>Classe Java de TipoConciliacaoSvaPayload complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TipoConciliacaoSvaPayload">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="R10" type="{http://www.dieboldnixdorf.com/frentecaixa/TipoRecuperacaoPedido}TipoRecuperacaoPedido"/>
 *         &lt;element name="R01" type="{http://www.dieboldnixdorf.com/frentecaixa/TipoIdentificacaoTicket}TipoIdentificacaoTicket"/>
 *         &lt;element name="registroMeioPagamento" type="{http://www.dieboldnixdorf.com/frentecaixa/TipoRegistroMeioPagamento}TipoRegistroMeioPagamento"/>
 *         &lt;element name="registroIdentificacaoItens" type="{http://www.dieboldnixdorf.com/frentecaixa/TipoRegistroIdentificacaoItens}TipoRegistroIdentificacaoItens"/>
 *         &lt;element name="status" type="{http://www.dieboldnixdorf.com/frentecaixa/TipoStatus}TipoStatus"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TipoConciliacaoSvaPayload", propOrder = {
    "transacaoRecuperacaoPedido",
    "transacaoIdentificacaoTicket",
    "registroMeioPagamento",
    "registroIdentificacaoItens",
    "status"
})
public class TipoConciliacaoSvaPayload {

    @XmlElement(name = "TransacaoRecuperacaoPedido", required = true)
    protected TipoRecuperacaoPedido transacaoRecuperacaoPedido;
    @XmlElement(name = "TransacaoIdentificacaoTicket", required = true)
    protected TipoIdentificacaoTicket transacaoIdentificacaoTicket;
    @XmlElement(required = true)
    protected TipoRegistroMeioPagamento registroMeioPagamento;
    @XmlElement(required = true)
    protected TipoRegistroIdentificacaoItens registroIdentificacaoItens;
    @XmlElement(required = true)
    protected TipoStatus status;

    /**
     * Obt�m o valor da propriedade r10.
     * 
     * @return
     *     possible object is
     *     {@link TipoRecuperacaoPedido }
     *     
     */
    public TipoRecuperacaoPedido getTransacaoRecuperacaoPedido() {
        return transacaoRecuperacaoPedido;
    }

    /**
     * Define o valor da propriedade r10.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoRecuperacaoPedido }
     *     
     */
    public void setTransacaoRecuperacaoPedido(TipoRecuperacaoPedido value) {
        this.transacaoRecuperacaoPedido = value;
    }

    /**
     * Obt�m o valor da propriedade r01.
     * 
     * @return
     *     possible object is
     *     {@link TipoIdentificacaoTicket }
     *     
     */
    public TipoIdentificacaoTicket getTransacaoIdentificacaoTicket() {
        return transacaoIdentificacaoTicket;
    }

    /**
     * Define o valor da propriedade r01.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoIdentificacaoTicket }
     *     
     */
    public void setTransacaoIdentificacaoTicket(TipoIdentificacaoTicket value) {
        this.transacaoIdentificacaoTicket = value;
    }

    /**
     * Obt�m o valor da propriedade registroMeioPagamento.
     * 
     * @return
     *     possible object is
     *     {@link TipoRegistroMeioPagamento }
     *     
     */
    public TipoRegistroMeioPagamento getRegistroMeioPagamento() {
        return registroMeioPagamento;
    }

    /**
     * Define o valor da propriedade registroMeioPagamento.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoRegistroMeioPagamento }
     *     
     */
    public void setRegistroMeioPagamento(TipoRegistroMeioPagamento value) {
        this.registroMeioPagamento = value;
    }

    /**
     * Obt�m o valor da propriedade registroIdentificacaoItens.
     * 
     * @return
     *     possible object is
     *     {@link TipoRegistroIdentificacaoItens }
     *     
     */
    public TipoRegistroIdentificacaoItens getRegistroIdentificacaoItens() {
        return registroIdentificacaoItens;
    }

    /**
     * Define o valor da propriedade registroIdentificacaoItens.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoRegistroIdentificacaoItens }
     *     
     */
    public void setRegistroIdentificacaoItens(TipoRegistroIdentificacaoItens value) {
        this.registroIdentificacaoItens = value;
    }

    /**
     * Obt�m o valor da propriedade status.
     * 
     * @return
     *     possible object is
     *     {@link TipoStatus }
     *     
     */
    public TipoStatus getStatus() {
        return status;
    }

    /**
     * Define o valor da propriedade status.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoStatus }
     *     
     */
    public void setStatus(TipoStatus value) {
        this.status = value;
    }

}
