package com.dieboldnixdorf.frentecaixa.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * The Class Ejcombustivel.
 */
@Entity
@Table
public class Ejcombustivel {

	@EmbeddedId
	private RegCombustivelPK regCombustivelPK;
	
	@Basic
	@Column(name="rectype", columnDefinition="int2")
	private Short rectype;
	
	@Basic
	@Column(name="codrmsproduto", columnDefinition="int8")
	private Long codRMSProduto;
        
	@Basic
	@Column(name="qtdevendida", columnDefinition="int8")
	private Long qtdeVendida;
	
	@Basic
	@Column(name="valorencerranteinicial", columnDefinition="bpchar", length=40)
	private String valorencerranteinicial;
	
	@Basic
	@Column(name="valorencerrantefinal", columnDefinition="bpchar", length=40)
	private String valorencerrantefinal;
	
	@Basic
	@Column(name="idabastecimento", columnDefinition="int8")
	private Long IDAbastecimento;
	
	@Basic
	@Column(name="numerobicoabastecimento", columnDefinition="int4")
	private int numerobicoabastecimento;
	
	@Basic
	@Column(name="numerobombaabastecimento", columnDefinition="int4")
	private int numerobombaabastecimento;
	
	@Basic
	@Column(name="numerotanqueabastecimento", columnDefinition="int4")
	private int numerotanqueabastecimento;
	
	@Basic 
	@Column(name="pk",columnDefinition="int8")
	private Long pk;
	
	

	public Short getRectype() {
		return rectype;
	}



	public void setRectype(Short rectype) {
		this.rectype = rectype;
	}



	/**
	 * Instantiates a new Ejcombustivel.
	 */
	public Ejcombustivel() {
	}

	
	
	public RegCombustivelPK getRegCombustivelPK() {
		return regCombustivelPK;
	}

	public void setRegCombustivelPK(RegCombustivelPK regCombustivelPK) {
		this.regCombustivelPK = regCombustivelPK;
	}

	public Long getQtdeVendida() {
		return qtdeVendida;
	}

	public void setQtdeVendida(Long qtdeVendida) {
		this.qtdeVendida = qtdeVendida;
	}

	public String getValorencerranteinicial() {
		return valorencerranteinicial;
	}

	public void setValorencerranteinicial(String valorencerranteinicial) {
		this.valorencerranteinicial = valorencerranteinicial;
	}

	public String getValorencerrantefinal() {
		return valorencerrantefinal;
	}

	public void setValorencerrantefinal(String valorencerrantefinal) {
		this.valorencerrantefinal = valorencerrantefinal;
	}

	public int getNumerobicoabastecimento() {
		return numerobicoabastecimento;
	}

	public void setNumerobicoabastecimento(int numerobicoabastecimento) {
		this.numerobicoabastecimento = numerobicoabastecimento;
	}

	public int getNumerobombaabastecimento() {
		return numerobombaabastecimento;
	}

	public void setNumerobombaabastecimento(int numerobombaabastecimento) {
		this.numerobombaabastecimento = numerobombaabastecimento;
	}

	public int getNumerotanqueabastecimento() {
		return numerotanqueabastecimento;
	}

	public void setNumerotanqueabastecimento(int numerotanqueabastecimento) {
		this.numerotanqueabastecimento = numerotanqueabastecimento;
	}

	public Long getPk() {
		return pk;
	}

	public void setPk(Long pk) {
		this.pk = pk;
	}

	public Long getCodRMSProduto() {
		return codRMSProduto;
	}

	public void setCodRMSProduto(Long codRMSProduto) {
		this.codRMSProduto = codRMSProduto;
	}

	public Long getIDAbastecimento() {
		return IDAbastecimento;
	}

	public void setIDAbastecimento(Long iDAbastecimento) {
		IDAbastecimento = iDAbastecimento;
	}

	@Override
	public String toString() {
		return "Ejcombustivel [regCombustivelPK=" + regCombustivelPK + ", codRMSProduto=" + codRMSProduto
				+ ", qtdeVendida=" + qtdeVendida + ", valorencerranteinicial=" + valorencerranteinicial
				+ ", valorencerrantefinal=" + valorencerrantefinal + ", IDAbastecimento=" + IDAbastecimento
				+ ", numerobicoabastecimento=" + numerobicoabastecimento + ", numerobombaabastecimento="
				+ numerobombaabastecimento + ", numerotanqueabastecimento=" + numerotanqueabastecimento + ", pk=" + pk
				+ "]";
	}

}
