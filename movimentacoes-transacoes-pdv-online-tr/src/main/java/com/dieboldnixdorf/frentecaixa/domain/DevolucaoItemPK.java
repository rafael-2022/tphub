package com.dieboldnixdorf.frentecaixa.domain;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;



@Embeddable
public class DevolucaoItemPK implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4659965555258085681L;

	@Basic
	@Column(name="contadorregistrointerno", columnDefinition="int4", insertable = false, updatable = false)
	private Integer contadorregistrointerno;
	
	@Basic
	@Column(name="numeromatricula", columnDefinition="bpchar", length=10, insertable = false, updatable = false)
	private String numeromatricula;
	
	@Basic
	@Column(name="codigormsproduto", columnDefinition="bpchar", length=10, insertable = false, updatable = false)
	private String codigormsproduto;
	

	public Integer getContadorregistrointerno() {
		return contadorregistrointerno;
	}

	public void setContadorregistrointerno(Integer contadorregistrointerno) {
		this.contadorregistrointerno = contadorregistrointerno;
	}
	
	

	public String getNumeromatricula() {
		return numeromatricula;
	}

	public void setNumeromatricula(String numeromatricula) {
		this.numeromatricula = numeromatricula;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contadorregistrointerno == null) ? 0 : contadorregistrointerno.hashCode());
		result = prime * result + ((numeromatricula == null) ? 0 : numeromatricula.hashCode());
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
		DevolucaoItemPK other = (DevolucaoItemPK) obj;
		if (contadorregistrointerno == null) {
			if (other.contadorregistrointerno != null)
				return false;
		} else if (!contadorregistrointerno.equals(other.contadorregistrointerno))
			return false;
		if (numeromatricula == null) {
			if (other.numeromatricula != null)
				return false;
		} else if (!numeromatricula.equals(other.numeromatricula))
			return false;
		return true;
	}


	
}
