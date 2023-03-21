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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;


/**
 * <p>Java class for TipoPagamentoTransacaoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TipoPagamentoTransacaoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codigoTransacaoInterno"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int"&gt;
 *               &lt;enumeration value="40"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="valorTotalPagamento" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="numeroFormaPagamento"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int"&gt;
 *               &lt;maxExclusive value="99"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="numeroCartaoCarrefour" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="21"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="nomeFormaPagamento"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="21"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="informacaoAdicional" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int"&gt;
 *               &lt;maxExclusive value="999"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="horaMinutoEvento"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="4"/&gt;
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
@XmlType(name = "TipoPagamentoTransacaoType", propOrder = {
    "codigoTransacaoInterno",
    "PK",
    "valorTotalPagamento",
    "numeroFormaPagamento",
    "sequenciaPagamento",
    "numeroCartaoCarrefour",
    "nomeFormaPagamento",
    "bandeiraCartao",
    "codigoAutorizacao",
    "DOC",
    "tipoVenda",
    "numeroCartao",
    "qtdeParcelas",
    "informacaoAdicional",
    "numeroMatricula",
    "codigoNsuSitef",
    "horaMinutoEvento"
})
@JsonPropertyOrder({ 
    "codigoTransacaoInterno",
    "PK",
    "valorTotalPagamento",
    "numeroFormaPagamento",
    "sequenciaPagamento",
    "numeroCartaoCarrefour",
    "nomeFormaPagamento",
    "bandeiraCartao",
    "codigoAutorizacao",
    "DOC",
    "tipoVenda",
    "numeroCartao",
    "qtdeParcelas",
    "informacaoAdicional",
    "numeroMatricula",
    "codigoNsuSitef",
    "horaMinutoEvento"
})
public class TipoPagamentoTransacaoType
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    protected int codigoTransacaoInterno;
    @XmlElement(required = true)
    @JsonProperty("valorTotalPagamento")
    @JsonSerialize(using = BigDecimal8Serializer.class)
    protected BigDecimal valorTotalPagamento;
    protected int numeroFormaPagamento;
    protected int sequenciaPagamento;
    protected String numeroCartaoCarrefour;
    @XmlElement(required = true)
    protected String nomeFormaPagamento;
    protected Integer informacaoAdicional;
    @XmlElement(required = true)
    protected String horaMinutoEvento;
    protected Long pk;
    protected String bandeiraCartao;
    protected String codigoAutorizacao;
    protected Long doc;
    protected String tipoVenda;
    protected String numeroCartao;
    protected int qtdeParcelas;
    protected String numeroMatricula;
    protected Long codigoNsuSitef;

    
    public String getNumeroMatricula() {
		return numeroMatricula;
	}

	public void setNumeroMatricula(String numeroMatricula) {
		this.numeroMatricula = numeroMatricula;
	}

	/**
     * Gets the value of the codigoTransacaoInterno property.
     * 
     */
    public int getCodigoTransacaoInterno() {
        return codigoTransacaoInterno;
    }

    /**
     * Sets the value of the codigoTransacaoInterno property.
     * 
     */
    public void setCodigoTransacaoInterno(int value) {
        this.codigoTransacaoInterno = value;
    }

    /**
     * Gets the value of the valorTotalPagamento property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getValorTotalPagamento() {
        return valorTotalPagamento;
    }

    /**
     * Sets the value of the valorTotalPagamento property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setValorTotalPagamento(BigDecimal value) {
        this.valorTotalPagamento = value;
    }

    /**
     * Gets the value of the numeroFormaPagamento property.
     * 
     */
    public int getNumeroFormaPagamento() {
        return numeroFormaPagamento;
    }

    /**
     * Sets the value of the numeroFormaPagamento property.
     * 
     */
    public void setNumeroFormaPagamento(int value) {
        this.numeroFormaPagamento = value;
    }
    
    /**
     * Gets the value of the sequenciaPagamento property.
     * 
     * @return 
     */
    public int getSequenciaPagamento() {
        return sequenciaPagamento;
    }
    
    /**
     * Sets the value of the sequenciaPagamento property.
     * 
     * @param value
     */
    public void setSequenciaPagamento(int value) {
        this.sequenciaPagamento = value;
    }

    /**
     * Gets the value of the numeroCartaoCarrefour property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroCartaoCarrefour() {
        return numeroCartaoCarrefour;
    }

    /**
     * Sets the value of the numeroCartaoCarrefour property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroCartaoCarrefour(String value) {
        this.numeroCartaoCarrefour = value;
    }

    /**
     * Gets the value of the nomeFormaPagamento property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomeFormaPagamento() {
        return nomeFormaPagamento;
    }

    /**
     * Sets the value of the nomeFormaPagamento property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomeFormaPagamento(String value) {
        this.nomeFormaPagamento = value;
    }

    /**
     * Gets the value of the informacaoAdicional property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getInformacaoAdicional() {
        return informacaoAdicional;
    }

    /**
     * Sets the value of the informacaoAdicional property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setInformacaoAdicional(Integer value) {
        this.informacaoAdicional = value;
    }

    /**
     * Gets the value of the horaMinutoEvento property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHoraMinutoEvento() {
        return horaMinutoEvento;
    }

    /**
     * Sets the value of the horaMinutoEvento property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHoraMinutoEvento(String value) {
        this.horaMinutoEvento = value;
    }

	/**        
	 * Gets / sets the bandeiraCartao value
	 */
	@JsonProperty("bandeiraCartao")
	public String getBandeiraCartao() {
		return bandeiraCartao;
	}
	public void setBandeiraCartao(String value) {
		this.bandeiraCartao = value;
	}

	/**        
	 * Gets / sets the codigoAutorizacao value
	 */
	@JsonProperty("codigoAutorizacao")
	public String getCodigoAutorizacao() {
		return codigoAutorizacao;
	}
	public void setCodigoAutorizacao(String value) {
		this.codigoAutorizacao = value;
	}

	/**        
	 * Gets / sets the doc value
	 */
	@JsonProperty("DOC")
	public Long getDoc() {
		return doc;
	}
	public void setDoc(Long value) {
		this.doc = value;
	}

	/**        
	 * Gets / sets the tipoVenda value
	 */
	@JsonProperty("tipoVenda")
	public String getTipoVenda() {
		return tipoVenda;
	}
	public void setTipoVenda(String value) {
		this.tipoVenda = value;
	}

	/**        
	 * Gets / sets the numeroCartao value
	 */
	@JsonProperty("numeroCartao")
	public String getNumeroCartao() {
		return numeroCartao;
	}
	public void setNumeroCartao(String value) {
		this.numeroCartao = value;
	}

	/**        
	 * Gets / sets the qtdeParcelas value
	 */
	@JsonProperty("qtdeParcelas")
	public int getQtdeParcelas() {
		return qtdeParcelas;
	}
	public void setQtdeParcelas(int value) {
		this.qtdeParcelas = value;
	}

	/**        
	 * Gets / sets the PK value
	 */
	@JsonProperty("PK")
	public Long getPk() {
		return pk;
	}
	public void setPk(Long value) {
		this.pk = value;
	}

	public Long getCodigoNsuSitef() {
		return codigoNsuSitef;
	}

	public void setCodigoNsuSitef(Long codigoNsuSitef) {
		this.codigoNsuSitef = codigoNsuSitef;
	}

	


}
