package com.dieboldnixdorf.frentecaixa.domain;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;



@Embeddable
public class DevolucaoCapaPK implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4659965555258085681L;

	@Basic
	@Column(name="transacaolojaorigem", columnDefinition="int4", insertable = false, updatable = false)
	private Integer transacaolojaorigem;

	@Override
	public String toString() {
		return "DevolucaoCapaPK [transacaolojaorigem=" + transacaolojaorigem + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((transacaolojaorigem == null) ? 0 : transacaolojaorigem.hashCode());
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
		DevolucaoCapaPK other = (DevolucaoCapaPK) obj;
		if (transacaolojaorigem == null) {
			if (other.transacaolojaorigem != null)
				return false;
		} else if (!transacaolojaorigem.equals(other.transacaolojaorigem))
			return false;
		return true;
	}

	
}
