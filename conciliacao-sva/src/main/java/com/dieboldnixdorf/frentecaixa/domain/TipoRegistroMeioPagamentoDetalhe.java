//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementa��o de Refer�ncia (JAXB) de Bind XML, v2.2.8-b130911.1802 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modifica��es neste arquivo ser�o perdidas ap�s a recompila��o do esquema de origem. 
// Gerado em: 2018.08.24 �s 10:54:54 AM BRT 
//


package com.dieboldnixdorf.frentecaixa.domain;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de TipoRegistroMeioPagamentoDetalhe complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TipoRegistroMeioPagamentoDetalhe">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="meiosPagto">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;maxExclusive value="9999"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="planoPagto">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="6"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="numParcelas">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;maxInclusive value="99"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="valorPago" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TipoRegistroMeioPagamentoDetalhe", propOrder = {
    "meiosPagto",
    "planoPagto",
    "numParcelas",
    "valorPago"
})
public class TipoRegistroMeioPagamentoDetalhe {

    protected int meiosPagto;
    @XmlElement(required = true)
    protected String planoPagto;
    protected int numParcelas;
    @XmlElement(required = true)
    protected BigDecimal valorPago;

    /**
     * Obt�m o valor da propriedade meiosPagto.
     * 
     */
    public int getMeiosPagto() {
        return meiosPagto;
    }

    /**
     * Define o valor da propriedade meiosPagto.
     * 
     */
    public void setMeiosPagto(int value) {
        this.meiosPagto = value;
    }

    /**
     * Obt�m o valor da propriedade planoPagto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlanoPagto() {
        return planoPagto;
    }

    /**
     * Define o valor da propriedade planoPagto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlanoPagto(String value) {
        this.planoPagto = value;
    }

    /**
     * Obt�m o valor da propriedade numParcelas.
     * 
     */
    public int getNumParcelas() {
        return numParcelas;
    }

    /**
     * Define o valor da propriedade numParcelas.
     * 
     */
    public void setNumParcelas(int value) {
        this.numParcelas = value;
    }

    /**
     * Obt�m o valor da propriedade valorPago.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getValorPago() {
        return valorPago;
    }

    /**
     * Define o valor da propriedade valorPago.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setValorPago(BigDecimal value) {
        this.valorPago = value;
    }

}
