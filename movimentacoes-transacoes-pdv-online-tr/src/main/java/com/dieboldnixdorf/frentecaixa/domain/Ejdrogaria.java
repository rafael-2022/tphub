package com.dieboldnixdorf.frentecaixa.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * The Class Ejdrogaria.
 */
@Entity
@Table
public class Ejdrogaria {

	@EmbeddedId
	private RegDrogariaPK regDrogariaPK;
	
	@Basic
	@Column(name="rectype", columnDefinition="int2")
	private Short rectype;
	
	@Basic
	@Column(name="codigopbm", columnDefinition="int8")
	private Long codigoPBM;
        
	@Basic
	@Column(name="valorpbm", columnDefinition="int8")
	private Long ValorPBM;
	
	@Basic
	@Column(name="numeroprevendapbm", columnDefinition="int8")
	private Long numeroPreVendaPBM;
	
	@Basic
	@Column(name="codigoautorizacaopbm", columnDefinition="int8")
	private Long codigoAutorizacaoPBM;
	
	@Basic
	@Column(name="numeropedidopbm", columnDefinition="int8")
	private Long numeroPedidoPBM;
	
	@Basic 
	@Column(name="pk",columnDefinition="int8")
	private Long pk;
	
	@Column(name="codrmsproduto", columnDefinition="int8")
	private Long codRMSProduto;
        
	@Basic
	@Column(name="qtdevendida", columnDefinition="int8")
	private Long qtdeVendida;

	/**
	 * Instantiates a new Ejservico.
	 */
	public Ejdrogaria() {
	}
	


	public Long getCodRMSProduto() {
		return codRMSProduto;
	}



	public void setCodRMSProduto(Long codRMSProduto) {
		this.codRMSProduto = codRMSProduto;
	}



	public Long getQtdeVendida() {
		return qtdeVendida;
	}

	public void setQtdeVendida(Long qtdeVendida) {
		this.qtdeVendida = qtdeVendida;
	}




	public Short getRectype() {
		return rectype;
	}



	public void setRectype(Short rectype) {
		this.rectype = rectype;
	}



	public RegDrogariaPK getRegDrogariaPK() {
		return regDrogariaPK;
	}

	public void setRegDrogariaPK(RegDrogariaPK regDrogariaPK) {
		this.regDrogariaPK = regDrogariaPK;
	}

	public Long getCodigoPBM() {
		return codigoPBM;
	}

	public void setCodigoPBM(Long codigoPBM) {
		this.codigoPBM = codigoPBM;
	}

	public Long getValorPBM() {
		return ValorPBM;
	}

	public void setValorPBM(Long valorPBM) {
		ValorPBM = valorPBM;
	}

	public Long getNumeroPreVendaPBM() {
		return numeroPreVendaPBM;
	}

	public void setNumeroPreVendaPBM(Long numeroPreVendaPBM) {
		this.numeroPreVendaPBM = numeroPreVendaPBM;
	}

	public Long getCodigoAutorizacaoPBM() {
		return codigoAutorizacaoPBM;
	}

	public void setCodigoAutorizacaoPBM(Long codigoAutorizacaoPBM) {
		this.codigoAutorizacaoPBM = codigoAutorizacaoPBM;
	}

	public Long getNumeroPedidoPBM() {
		return numeroPedidoPBM;
	}

	public void setNumeroPedidoPBM(Long numeroPedidoPBM) {
		this.numeroPedidoPBM = numeroPedidoPBM;
	}

	public Long getPk() {
		return pk;
	}

	public void setPk(Long pk) {
		this.pk = pk;
	}

	@Override
	public String toString() {
		return "Ejdrogaria [regDrogariaPK=" + regDrogariaPK + ", codigoPBM=" + codigoPBM + ", ValorPBM=" + ValorPBM
				+ ", numeroPreVendaPBM=" + numeroPreVendaPBM + ", codigoAutorizacaoPBM=" + codigoAutorizacaoPBM
				+ ", numeroPedidoPBM=" + numeroPedidoPBM + ", pk=" + pk + "]";
	}

	
	
}
