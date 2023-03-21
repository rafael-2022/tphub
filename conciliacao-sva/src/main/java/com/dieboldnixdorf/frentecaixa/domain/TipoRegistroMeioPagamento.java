//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementa��o de Refer�ncia (JAXB) de Bind XML, v2.2.8-b130911.1802 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modifica��es neste arquivo ser�o perdidas ap�s a recompila��o do esquema de origem. 
// Gerado em: 2018.08.24 �s 10:54:54 AM BRT 
//


package com.dieboldnixdorf.frentecaixa.domain;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.dieboldnixdorf.frentecaixa.domain.TipoRegistroMeioPagamentoDetalhe;


/**
 * <p>Classe Java de TipoRegistroMeioPagamento complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TipoRegistroMeioPagamento">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codRegistro">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;maxInclusive value="99"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="tipoRegistroMeioPagamentoDetalhe" type="{http://www.dieboldnixdorf.com/frentecaixa/TipoRegistroMeioPagamentoDetalhe}TipoRegistroMeioPagamentoDetalhe" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TipoRegistroMeioPagamento", propOrder = {
    "codRegistro",
    "tipoRegistroMeioPagamentoDetalhe"
})
public class TipoRegistroMeioPagamento {

    protected int codRegistro;
    @XmlElement(required = true)
    protected List<TipoRegistroMeioPagamentoDetalhe> tipoRegistroMeioPagamentoDetalhe;

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
     * Gets the value of the tipoRegistroMeioPagamentoDetalhe property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tipoRegistroMeioPagamentoDetalhe property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTipoRegistroMeioPagamentoDetalhe().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TipoRegistroMeioPagamentoDetalhe }
     * 
     * 
     */
    public List<TipoRegistroMeioPagamentoDetalhe> getTipoRegistroMeioPagamentoDetalhe() {
        if (tipoRegistroMeioPagamentoDetalhe == null) {
            tipoRegistroMeioPagamentoDetalhe = new ArrayList<TipoRegistroMeioPagamentoDetalhe>();
        }
        return this.tipoRegistroMeioPagamentoDetalhe;
    }
    
    
    public void setTipoRegistroMeioPagamentoDetalhe( List<TipoRegistroMeioPagamentoDetalhe> tipoRegistroMeioPagamentoDetalhe){
       this.tipoRegistroMeioPagamentoDetalhe = tipoRegistroMeioPagamentoDetalhe;
    }

}
