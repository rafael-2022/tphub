package com.dieboldnixdorf.frentecaixa.domain;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;



@Embeddable
public class DevolucaoPagamentoPK implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4659965555258085681L;

	@Basic
	@Column(name="contadorregistrointerno", columnDefinition="int4", insertable = false, updatable = false)
	private Integer contadorregistrointerno;
	
	@Basic
	@Column(name="eanproduto", columnDefinition="bpchar", length=15, insertable = false, updatable = false)
	private String eanproduto;
	
	@Basic
	@Column(name="quantidadeformaspgto", columnDefinition="bpchar", length=5, insertable = false, updatable = false)
	private String quantidadeformaspgto;
	
	@Basic
	@Column(name="categoriaformapgto", columnDefinition="bpchar", length=5, insertable = false, updatable = false)
	private String categoriaformapgto;
	
	@Basic
	@Column(name="horaminutoevento", columnDefinition="bpchar", length=10, insertable = false, updatable = false)
	private String horaminutoevento;

	public Integer getContadorregistrointerno() {
		return contadorregistrointerno;
	}

	public void setContadorregistrointerno(Integer contadorregistrointerno) {
		this.contadorregistrointerno = contadorregistrointerno;
	}

	public String getEanproduto() {
		return eanproduto;
	}

	public void setEanproduto(String eanproduto) {
		this.eanproduto = eanproduto;
	}

	public String getQuantidadeformaspgto() {
		return quantidadeformaspgto;
	}

	public void setQuantidadeformaspgto(String quantidadeformaspgto) {
		this.quantidadeformaspgto = quantidadeformaspgto;
	}

	public String getCategoriaformapgto() {
		return categoriaformapgto;
	}

	public void setCategoriaformapgto(String categoriaformapgto) {
		this.categoriaformapgto = categoriaformapgto;
	}

	public String getHoraminutoevento() {
		return horaminutoevento;
	}

	public void setHoraminutoevento(String horaminutoevento) {
		this.horaminutoevento = horaminutoevento;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoriaformapgto == null) ? 0 : categoriaformapgto.hashCode());
		result = prime * result + ((contadorregistrointerno == null) ? 0 : contadorregistrointerno.hashCode());
		result = prime * result + ((eanproduto == null) ? 0 : eanproduto.hashCode());
		result = prime * result + ((horaminutoevento == null) ? 0 : horaminutoevento.hashCode());
		result = prime * result + ((quantidadeformaspgto == null) ? 0 : quantidadeformaspgto.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DevolucaoPagamentoPK other = (DevolucaoPagamentoPK) obj;
		if (categoriaformapgto == null) {
			if (other.categoriaformapgto != null)
				return false;
		} else if (!categoriaformapgto.equals(other.categoriaformapgto))
			return false;
		if (contadorregistrointerno == null) {
			if (other.contadorregistrointerno != null)
				return false;
		} else if (!contadorregistrointerno.equals(other.contadorregistrointerno))
			return false;
		if (eanproduto == null) {
			if (other.eanproduto != null)
				return false;
		} else if (!eanproduto.equals(other.eanproduto))
			return false;
		if (horaminutoevento == null) {
			if (other.horaminutoevento != null)
				return false;
		} else if (!horaminutoevento.equals(other.horaminutoevento))
			return false;
		if (quantidadeformaspgto == null) {
			if (other.quantidadeformaspgto != null)
				return false;
		} else if (!quantidadeformaspgto.equals(other.quantidadeformaspgto))
			return false;
		return true;
	}

	
	
}
