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
import com.dieboldnixdorf.frentecaixa.domain.CodigoLojaType;
import com.dieboldnixdorf.frentecaixa.domain.DataExtracaoType;


/**
 * <p>Classe Java de TipoCabecalho complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TipoCabecalho">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codigoLoja" type="{http://www.dieboldnixdorf.com/frentecaixa/TipoCodigoLoja}CodigoLojaType"/>
 *         &lt;element name="dataExtracao" type="{http://www.dieboldnixdorf.com/frentecaixa/TipoDataExtracao}DataExtracaoType"/>
 *         &lt;element name="totalRegistros" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="totalPaginas" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="totalRegistrosPorPagina" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TipoCabecalho", propOrder = {
    "codigoLoja",
    "dataExtracao",
    "totalRegistros",
    "totalPaginas",
    "totalRegistrosPorPagina"
})
public class TipoCabecalho {

    @XmlElement(required = true)
    protected CodigoLojaType codigoLoja;
    @XmlElement(required = true)
    protected DataExtracaoType dataExtracao;
    protected long totalRegistros;
    protected long totalPaginas;
    protected long totalRegistrosPorPagina;

    /**
     * Obt�m o valor da propriedade codigoLoja.
     * 
     * @return
     *     possible object is
     *     {@link CodigoLojaType }
     *     
     */
    public CodigoLojaType getCodigoLoja() {
        return codigoLoja;
    }

    /**
     * Define o valor da propriedade codigoLoja.
     * 
     * @param value
     *     allowed object is
     *     {@link CodigoLojaType }
     *     
     */
    public void setCodigoLoja(CodigoLojaType value) {
        this.codigoLoja = value;
    }

    /**
     * Obt�m o valor da propriedade dataExtracao.
     * 
     * @return
     *     possible object is
     *     {@link DataExtracaoType }
     *     
     */
    public DataExtracaoType getDataExtracao() {
        return dataExtracao;
    }

    /**
     * Define o valor da propriedade dataExtracao.
     * 
     * @param value
     *     allowed object is
     *     {@link DataExtracaoType }
     *     
     */
    public void setDataExtracao(DataExtracaoType value) {
        this.dataExtracao = value;
    }

    /**
     * Obt�m o valor da propriedade totalRegistros.
     * 
     */
    public long getTotalRegistros() {
        return totalRegistros;
    }

    /**
     * Define o valor da propriedade totalRegistros.
     * 
     */
    public void setTotalRegistros(long value) {
        this.totalRegistros = value;
    }

    /**
     * Obt�m o valor da propriedade totalPaginas.
     * 
     */
    public long getTotalPaginas() {
        return totalPaginas;
    }

    /**
     * Define o valor da propriedade totalPaginas.
     * 
     */
    public void setTotalPaginas(long value) {
        this.totalPaginas = value;
    }

    /**
     * Obt�m o valor da propriedade totalRegistrosPorPagina.
     * 
     */
    public long getTotalRegistrosPorPagina() {
        return totalRegistrosPorPagina;
    }

    /**
     * Define o valor da propriedade totalRegistrosPorPagina.
     * 
     */
    public void setTotalRegistrosPorPagina(long value) {
        this.totalRegistrosPorPagina = value;
    }

}
