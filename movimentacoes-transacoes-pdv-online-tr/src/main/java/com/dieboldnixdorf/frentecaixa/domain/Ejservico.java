package com.dieboldnixdorf.frentecaixa.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * The Class Ejservico.
 */
@Entity
@Table
public class Ejservico {

	@EmbeddedId
	private RegServicoPK regServicoPK;
	
	@Basic
	@Column(name="rectype", columnDefinition="int2")
	private Short rectype;
	
	@Basic
	@Column(name="descricaoservico", columnDefinition="bpchar", length=20)
	private String descricaoServico;
	
	@Basic
	@Column(name="valorservico", columnDefinition="int8")
	private Long valorServico;
        
	@Basic
	@Column(name="numerocartaopresente", columnDefinition="bpchar", length=10)
	private String numeroCartaoPresente;
	
	@Basic
	@Column(name="numerocelularrecarga", columnDefinition="int8")
	private String numeroCelularRecarga;
	
	@Basic
	@Column(name="nomeoperadoratelefonia ", columnDefinition="bpchar", length=20)
	private String nomeOperadoraTelefonia ;
	
	@Basic
	@Column(name="codigoservico", columnDefinition="int8")
	private Long codigoServico;
	
	@Basic
	@Column(name="codigofornecedor", columnDefinition="int4")
	private Integer codigofornecedor;
	
	@Basic
	@Column(name="tiposervico", columnDefinition="int4")
	private Integer tiposervico;
	
	@Basic 
	@Column(name="pk",columnDefinition="int8")
	private Long pk;

	/**
	 * Instantiates a new Ejservico.
	 */
	public Ejservico() {
	}

	
	
	public Short getRectype() {
		return rectype;
	}



	public void setRectype(Short rectype) {
		this.rectype = rectype;
	}



	public RegServicoPK getRegServicoPK() {
		return regServicoPK;
	}

	public void setRegServicoPK(RegServicoPK regServicoPK) {
		this.regServicoPK = regServicoPK;
	}

	public String getDescricaoServico() {
		return descricaoServico;
	}

	public void setDescricaoServico(String descricaoServico) {
		this.descricaoServico = descricaoServico;
	}

	public Long getValorServico() {
		return valorServico;
	}

	public void setValorServico(Long valorServico) {
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

	public Long getPk() {
		return pk;
	}

	public void setPk(Long pk) {
		this.pk = pk;
	}



	public Integer getCodigofornecedor() {
		return codigofornecedor;
	}



	public void setCodigofornecedor(Integer codigofornecedor) {
		this.codigofornecedor = codigofornecedor;
	}



	public Integer getTiposervico() {
		return tiposervico;
	}



	public void setTiposervico(Integer tiposervico) {
		this.tiposervico = tiposervico;
	}



	@Override
	public String toString() {
		return "Ejservico [regServicoPK=" + regServicoPK + ", rectype=" + rectype + ", descricaoServico="
				+ descricaoServico + ", valorServico=" + valorServico + ", numeroCartaoPresente=" + numeroCartaoPresente
				+ ", numeroCelularRecarga=" + numeroCelularRecarga + ", nomeOperadoraTelefonia="
				+ nomeOperadoraTelefonia + ", codigoServico=" + codigoServico + ", codigofornecedor=" + codigofornecedor
				+ ", tiposervico=" + tiposervico + ", pk=" + pk + "]";
	}



	
	
	
}
