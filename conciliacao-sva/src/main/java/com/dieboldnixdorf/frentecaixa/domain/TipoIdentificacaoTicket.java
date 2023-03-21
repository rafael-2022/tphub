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
 * <p>Classe Java de TipoIdentificacaoTicket complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TipoIdentificacaoTicket">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codRegistro">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;maxExclusive value="99"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="cupomFiscal" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="tipoItem">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;maxExclusive value="99"/>
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
@XmlType(name = "TransacaoIdentificacaoTicket", propOrder = {
    "codRegistro",
    "cupomFiscal",
    "tipoItem"
})
public class TipoIdentificacaoTicket {

    protected int codRegistro;
    protected long cupomFiscal;
    protected int tipoItem;

    /**
     * Obt�m o valor da propriedade codRegistro.
     * 
     */
    public int getCodRegistro() {
        return codRegistro;
    }

    /**
     * Define o valor da propriedade codRegistro.
     * 
     */
    public void setCodRegistro(int value) {
        this.codRegistro = value;
    }

    /**
     * Obt�m o valor da propriedade cupomFiscal.
     * 
     */
    public long getCupomFiscal() {
        return cupomFiscal;
    }

    /**
     * Define o valor da propriedade cupomFiscal.
     * 
     */
    public void setCupomFiscal(long value) {
        this.cupomFiscal = value;
    }

    /**
     * Obt�m o valor da propriedade tipoItem.
     * 
     */
    public int getTipoItem() {
        return tipoItem;
    }

    /**
     * Define o valor da propriedade tipoItem.
     * 
     */
    public void setTipoItem(int value) {
        this.tipoItem = value;
    }

}
