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


/**
 * <p>Classe Java de TipoStatus complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TipoStatus">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="identTerminal">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="8"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="status">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="1"/>
 *               &lt;enumeration value="2"/>
 *               &lt;enumeration value="3"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="codLojaRMS">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
 *               &lt;maxExclusive value="99999999"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="cpfCliente">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
 *               &lt;maxExclusive value="99999999999999"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="codVendedor">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
 *               &lt;maxExclusive value="999999999999999"/>
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
@XmlType(name = "TipoStatus", propOrder = {
    "identTerminal",
    "status",
    "codLojaRMS",
    "cpfCliente",
    "codVendedor"
})
public class TipoStatus {

    @XmlElement(required = true)
    protected String identTerminal;
    @XmlElement(required = true)
    protected String status;
    protected long codLojaRMS;
    protected long cpfCliente;
    protected long codVendedor;

    /**
     * Obt�m o valor da propriedade identTerminal.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentTerminal() {
        return identTerminal;
    }

    /**
     * Define o valor da propriedade identTerminal.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentTerminal(String value) {
        this.identTerminal = value;
    }

    /**
     * Obt�m o valor da propriedade status.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Define o valor da propriedade status.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Obt�m o valor da propriedade codLojaRMS.
     * 
     */
    public long getCodLojaRMS() {
        return codLojaRMS;
    }

    /**
     * Define o valor da propriedade codLojaRMS.
     * 
     */
    public void setCodLojaRMS(long value) {
        this.codLojaRMS = value;
    }

    /**
     * Obt�m o valor da propriedade cpfCliente.
     * 
     */
    public long getCpfCliente() {
        return cpfCliente;
    }

    /**
     * Define o valor da propriedade cpfCliente.
     * 
     */
    public void setCpfCliente(long value) {
        this.cpfCliente = value;
    }

    /**
     * Obt�m o valor da propriedade codVendedor.
     * 
     */
    public long getCodVendedor() {
        return codVendedor;
    }

    /**
     * Define o valor da propriedade codVendedor.
     * 
     */
    public void setCodVendedor(long value) {
        this.codVendedor = value;
    }

}
