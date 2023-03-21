//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementa��o de Refer�ncia (JAXB) de Bind XML, v2.2.8-b130911.1802 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modifica��es neste arquivo ser�o perdidas ap�s a recompila��o do esquema de origem. 
// Gerado em: 2018.08.24 �s 10:54:54 AM BRT 
//


package com.dieboldnixdorf.frentecaixa.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de TipoRecuperacaoPedido complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TipoRecuperacaoPedido">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="transacao">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;maxExclusive value="99"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="nsuPedido">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
 *               &lt;maxExclusive value="999999999999"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="numPedido">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
 *               &lt;maxExclusive value="9999999999999"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TipoRecuperacaoPedido", propOrder = {
    "transacao",
    "nsuPedido",
    "numPedido"
})
public class TipoRecuperacaoPedido {

    protected int transacao;
    protected long nsuPedido;
    protected long numPedido;

    /**
     * Obt�m o valor da propriedade transacao.
     * 
     */
    public int getTransacao() {
        return transacao;
    }

    /**
     * Define o valor da propriedade transacao.
     * 
     */
    public void setTransacao(int value) {
        this.transacao = value;
    }

    /**
     * Obt�m o valor da propriedade nsuPedido.
     * 
     */
    public long getNsuPedido() {
        return nsuPedido;
    }

    /**
     * Define o valor da propriedade nsuPedido.
     * 
     */
    public void setNsuPedido(long value) {
        this.nsuPedido = value;
    }

    /**
     * Obt�m o valor da propriedade numPedido.
     * 
     */
    public long getNumPedido() {
        return numPedido;
    }

    /**
     * Define o valor da propriedade numPedido.
     * 
     */
    public void setNumPedido(long value) {
        this.numPedido = value;
    }

}
