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


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TipoServicoTransacaoType", propOrder = {
    "codigoTransacaoInterno",
    "contadorRegistroInterno",
    "PK",
    "descricaoServico",
    "valorServico",
    "numeroCartaoPresente",
    "numeroCelularRecarga",
    "nomeOperadoraTelefonia",
    "codigoServico",
    "codigoFornecedor",
    "tipoServico",
    "horaMinutoEvento"
})
@JsonPropertyOrder({ 
    "codigoTransacaoInterno",
    "contadorRegistroInterno",
    "PK",
    "descricaoServico",
    "valorServico",
    "numeroCartaoPresente",
    "numeroCelularRecarga",
    "nomeOperadoraTelefonia",
    "codigoServico",
    "codigoFornecedor",
    "tipoServico",
    "horaMinutoEvento"
})
public class TipoServicoTransacaoType
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    
    
    protected String descricaoServico;
    
    @JsonProperty("valorServico")
    @JsonSerialize(using = BigDecimal8Serializer.class)
    protected BigDecimal valorServico;
    
    protected String numeroCartaoPresente;
    protected String numeroCelularRecarga;
    protected String nomeOperadoraTelefonia;
    protected Long codigoServico;
    
    protected Integer codigoFornecedor;
    protected Integer tipoServico;
    
    @XmlElement(required = true)
    protected String horaMinutoEvento;
    protected Long pk;
    protected int codigoTransacaoInterno;
    
    protected int contadorRegistroInterno;
    
    
    
	public int getContadorRegistroInterno() {
		return contadorRegistroInterno;
	}
	public void setContadorRegistroInterno(int contadorRegistroInterno) {
		this.contadorRegistroInterno = contadorRegistroInterno;
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
	public String getDescricaoServico() {
		return descricaoServico;
	}
	public void setDescricaoServico(String descricaoServico) {
		this.descricaoServico = descricaoServico;
	}
	public BigDecimal getValorServico() {
		return valorServico;
	}
	public void setValorServico(BigDecimal valorServico) {
		this.valorServico = valorServico;
	}
	public String getNumeroCartaoPresente() {
		return numeroCartaoPresente;
	}
	public void setNumeroCartaoPresente(String numeroCartaoPresente) {
		this.numeroCartaoPresente = numeroCartaoPresente;
	}
	public String getNumeroCelularRecarga() {
		return numeroCelularRecarga;
	}
	public void setNumeroCelularRecarga(String numeroCelularRecarga) {
		this.numeroCelularRecarga = numeroCelularRecarga;
	}
	public String getNomeOperadoraTelefonia() {
		return nomeOperadoraTelefonia;
	}
	public void setNomeOperadoraTelefonia(String nomeOperadoraTelefonia) {
		this.nomeOperadoraTelefonia = nomeOperadoraTelefonia;
	}
	public Long getCodigoServico() {
		return codigoServico;
	}
	public void setCodigoServico(Long codigoServico) {
		this.codigoServico = codigoServico;
	}
	public String getHoraMinutoEvento() {
		return horaMinutoEvento;
	}
	public void setHoraMinutoEvento(String horaMinutoEvento) {
		this.horaMinutoEvento = horaMinutoEvento;
	}
	public int getCodigoTransacaoInterno() {
		return codigoTransacaoInterno;
	}
	public void setCodigoTransacaoInterno(int codigoTransacaoInterno) {
		this.codigoTransacaoInterno = codigoTransacaoInterno;
	}
	public Integer getCodigoFornecedor() {
		return codigoFornecedor;
	}
	public void setCodigoFornecedor(Integer codigoFornecedor) {
		this.codigoFornecedor = codigoFornecedor;
	}
	public Integer getTipoServico() {
		return tipoServico;
	}
	public void setTipoServico(Integer tipoServico) {
		this.tipoServico = tipoServico;
	}
	
	@Override
	public String toString() {
		return "TipoServicoTransacaoType [descricaoServico=" + descricaoServico + ", valorServico=" + valorServico
				+ ", numeroCartaoPresente=" + numeroCartaoPresente + ", numeroCelularRecarga=" + numeroCelularRecarga
				+ ", nomeOperadoraTelefonia=" + nomeOperadoraTelefonia + ", codigoServico=" + codigoServico
				+ ", codigoFornecedor=" + codigoFornecedor + ", tipoServico=" + tipoServico + ", horaMinutoEvento="
				+ horaMinutoEvento + ", pk=" + pk + ", codigoTransacaoInterno=" + codigoTransacaoInterno
				+ ", contadorRegistroInterno=" + contadorRegistroInterno + "]";
	}

}
