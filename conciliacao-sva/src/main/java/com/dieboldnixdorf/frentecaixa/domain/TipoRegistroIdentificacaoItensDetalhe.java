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
 * <p>Classe Java de TipoRegistroIdentificacaoItensDetalhe complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TipoRegistroIdentificacaoItensDetalhe">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tipoItem">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;maxExclusive value="99"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="codProdutoPLU">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
 *               &lt;maxExclusive value="99999999999999"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="codProdutoGarantiaRMS">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
 *               &lt;maxExclusive value="999999999"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="quantidade">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;maxExclusive value="999"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="valorUnitario" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="valorTotal" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="valorDesconto" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="tipoServico">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;maxInclusive value="255"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="codFornecedor">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;maxExclusive value="999"/>
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
@XmlType(name = "TipoRegistroIdentificacaoItensDetalhe", propOrder = {
    "tipoItem",
    "codProdutoPLU",
    "codProdutoGarantiaRMS",
    "quantidade",
    "valorUnitario",
    "valorTotal",
    "valorDesconto",
    "tipoServico",
    "codFornecedor"
})
public class TipoRegistroIdentificacaoItensDetalhe {

    protected int tipoItem;
    protected long codProdutoPLU;
    protected long codProdutoGarantiaRMS;
    protected int quantidade;
    @XmlElement(required = true)
    protected BigDecimal valorUnitario;
    @XmlElement(required = true)
    protected BigDecimal valorTotal;
    @XmlElement(required = true)
    protected BigDecimal valorDesconto;
    protected int tipoServico;
    protected int codFornecedor;

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

    /**
     * Obt�m o valor da propriedade codProdutoPLU.
     * 
     */
    public long getCodProdutoPLU() {
        return codProdutoPLU;
    }

    /**
     * Define o valor da propriedade codProdutoPLU.
     * 
     */
    public void setCodProdutoPLU(long value) {
        this.codProdutoPLU = value;
    }

    /**
     * Obt�m o valor da propriedade codProdutoGarantiaRMS.
     * 
     */
    public long getCodProdutoGarantiaRMS() {
        return codProdutoGarantiaRMS;
    }

    /**
     * Define o valor da propriedade codProdutoGarantiaRMS.
     * 
     */
    public void setCodProdutoGarantiaRMS(long value) {
        this.codProdutoGarantiaRMS = value;
    }

    /**
     * Obt�m o valor da propriedade quantidade.
     * 
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * Define o valor da propriedade quantidade.
     * 
     */
    public void setQuantidade(int value) {
        this.quantidade = value;
    }

    /**
     * Obt�m o valor da propriedade valorUnitario.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    /**
     * Define o valor da propriedade valorUnitario.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setValorUnitario(BigDecimal value) {
        this.valorUnitario = value;
    }

    /**
     * Obt�m o valor da propriedade valorTotal.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    /**
     * Define o valor da propriedade valorTotal.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setValorTotal(BigDecimal value) {
        this.valorTotal = value;
    }

    /**
     * Obt�m o valor da propriedade valorDesconto.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getValorDesconto() {
        return valorDesconto;
    }

    /**
     * Define o valor da propriedade valorDesconto.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setValorDesconto(BigDecimal value) {
        this.valorDesconto = value;
    }

    /**
     * Obt�m o valor da propriedade tipoServico.
     * 
     */
    public int getTipoServico() {
        return tipoServico;
    }

    /**
     * Define o valor da propriedade tipoServico.
     * 
     */
    public void setTipoServico(int value) {
        this.tipoServico = value;
    }

    /**
     * Obt�m o valor da propriedade codFornecedor.
     * 
     */
    public int getCodFornecedor() {
        return codFornecedor;
    }

    /**
     * Define o valor da propriedade codFornecedor.
     * 
     */
    public void setCodFornecedor(int value) {
        this.codFornecedor = value;
    }

}
