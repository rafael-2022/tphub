//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.02.11 at 03:35:05 PM BRST 
//


package com.dieboldnixdorf.frentecaixa.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;


/**
 * <p>Java class for TrocaDevolucaoPayloadType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TrocaDevolucaoPayloadType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codigoProdutoEAN"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long"&gt;
 *               &lt;maxExclusive value="9999999999999"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="valorProduto" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="codigoOperacao"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;enumeration value="TC "/&gt;
 *               &lt;enumeration value="RD"/&gt;
 *               &lt;enumeration value="CP"/&gt;
 *               &lt;enumeration value="AN"/&gt;
 *               &lt;enumeration value="DO"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="quantidadeProduto" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="razaoOperacao"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int"&gt;
 *               &lt;maxExclusive value="99"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="trocaComCuponFiscal"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;enumeration value="S"/&gt;
 *               &lt;enumeration value="N"/&gt;
 *               &lt;length value="1"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="numeroCuponFiscal" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="9"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="figuraFiscal" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="2"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VendaAssistidaDevolucaoPayloadType", propOrder = {
	"tipoDev",
	"numDocto",
	"numPreOrder",
	"numPDV",
	"codOper",
	"codVend",
	"tipoServ",
	"codProd",
	"codServ",
	"codFornc",
	"qtde",
	"vlrUnit",
	"vlrTot",
	"qtdeFormPagto",
	"catFormPagto",
	"formPagto",
	"vlrFormPagto"
})
@JsonPropertyOrder({ 
	"tipoDev",
	"numDocto",
	"numPreOrder",
	"numPDV",
	"codOper",
	"codVend",
	"tipoServ",
	"codProd",
	"codServ",
	"codFornc",
	"qtde",
	"vlrUnit",
	"vlrTot",
	"qtdeFormPagto",
	"catFormPagto",
	"formPagto",
	"vlrFormPagto"
})
public class VendaAssistidaDevolucaoPayloadType
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    protected String tipoDev;
    protected Long numDocto;
    protected Long numPreOrder;
    protected Integer numPDV;
    protected Long codOper;
    protected Long codVend;
    protected Integer tipoServ;
    protected Long codProd;
    protected Long codServ;
    protected Long codFornc;
    protected Integer qtde;
    @JsonSerialize(using = BigDecimal10Serializer.class)
    protected BigDecimal vlrUnit;
    @JsonSerialize(using = BigDecimal10Serializer.class)
    protected BigDecimal vlrTot;
    protected Integer qtdeFormPagto;
    protected String catFormPagto;
    protected String formPagto;
    @JsonSerialize(using = BigDecimal10Serializer.class)
    protected BigDecimal vlrFormPagto;
	/**
	 * @return the tipoDev
	 */
	public String getTipoDev() {
		return tipoDev;
	}
	/**
	 * @param tipoDev the tipoDev to set
	 */
	public void setTipoDev(String tipoDev) {
		this.tipoDev = tipoDev;
	}
	/**
	 * @return the numDocto
	 */
	public Long getNumDocto() {
		return numDocto;
	}
	/**
	 * @param numDocto the numDocto to set
	 */
	public void setNumDocto(Long numDocto) {
		this.numDocto = numDocto;
	}
	/**
	 * @return the numPreOrder
	 */
	public Long getNumPreOrder() {
		return numPreOrder;
	}
	/**
	 * @param numPreOrder the numPreOrder to set
	 */
	public void setNumPreOrder(Long numPreOrder) {
		this.numPreOrder = numPreOrder;
	}
	/**
	 * @return the numPDV
	 */
	public Integer getNumPDV() {
		return numPDV;
	}
	/**
	 * @param numPDV the numPDV to set
	 */
	public void setNumPDV(Integer numPDV) {
		this.numPDV = numPDV;
	}
	/**
	 * @return the codOper
	 */
	public Long getCodOper() {
		return codOper;
	}
	/**
	 * @param codOper the codOper to set
	 */
	public void setCodOper(Long codOper) {
		this.codOper = codOper;
	}
	/**
	 * @return the codVend
	 */
	public Long getCodVend() {
		return codVend;
	}
	/**
	 * @param codVend the codVend to set
	 */
	public void setCodVend(Long codVend) {
		this.codVend = codVend;
	}
	/**
	 * @return the tipoServ
	 */
	public Integer getTipoServ() {
		return tipoServ;
	}
	/**
	 * @param tipoServ the tipoServ to set
	 */
	public void setTipoServ(Integer tipoServ) {
		this.tipoServ = tipoServ;
	}
	/**
	 * @return the codProd
	 */
	public Long getCodProd() {
		return codProd;
	}
	/**
	 * @param codProd the codProd to set
	 */
	public void setCodProd(Long codProd) {
		this.codProd = codProd;
	}
	/**
	 * @return the codServ
	 */
	public Long getCodServ() {
		return codServ;
	}
	/**
	 * @param codServ the codServ to set
	 */
	public void setCodServ(Long codServ) {
		this.codServ = codServ;
	}
	/**
	 * @return the codFornc
	 */
	public Long getCodFornc() {
		return codFornc;
	}
	/**
	 * @param codFornc the codFornc to set
	 */
	public void setCodFornc(Long codFornc) {
		this.codFornc = codFornc;
	}
	/**
	 * @return the qtde
	 */
	public Integer getQtde() {
		return qtde;
	}
	/**
	 * @param qtde the qtde to set
	 */
	public void setQtde(Integer qtde) {
		this.qtde = qtde;
	}
	/**
	 * @return the vlrUnit
	 */
	public BigDecimal getVlrUnit() {
		return vlrUnit;
	}
	/**
	 * @param vlrUnit the vlrUnit to set
	 */
	public void setVlrUnit(BigDecimal vlrUnit) {
		this.vlrUnit = vlrUnit;
	}
	/**
	 * @return the vlrTot
	 */
	public BigDecimal getVlrTot() {
		return vlrTot;
	}
	/**
	 * @param vlrTot the vlrTot to set
	 */
	public void setVlrTot(BigDecimal vlrTot) {
		this.vlrTot = vlrTot;
	}
	/**
	 * @return the qtdeFormPagto
	 */
	public Integer getQtdeFormPagto() {
		return qtdeFormPagto;
	}
	/**
	 * @param qtdeFormPagto the qtdeFormPagto to set
	 */
	public void setQtdeFormPagto(Integer qtdeFormPagto) {
		this.qtdeFormPagto = qtdeFormPagto;
	}
	/**
	 * @return the catFormPagto
	 */
	public String getCatFormPagto() {
		return catFormPagto;
	}
	/**
	 * @param catFormPagto the catFormPagto to set
	 */
	public void setCatFormPagto(String catFormPagto) {
		this.catFormPagto = catFormPagto;
	}
	/**
	 * @return the formPagto
	 */
	public String getFormPagto() {
		return formPagto;
	}
	/**
	 * @param formPagto the formPagto to set
	 */
	public void setFormPagto(String formPagto) {
		this.formPagto = formPagto;
	}
	/**
	 * @return the vlrFormPagto
	 */
	public BigDecimal getVlrFormPagto() {
		return vlrFormPagto;
	}
	/**
	 * @param vlrFormPagto the vlrFormPagto to set
	 */
	public void setVlrFormPagto(BigDecimal vlrFormPagto) {
		this.vlrFormPagto = vlrFormPagto;
	}
    
    
    
    
}
