package com.dieboldnixdorf.frentecaixa.domain;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * The Class ContabilPK.
 */
@Embeddable
public class ContabilPK implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4121116848555573320L;

	/** The vendornmbr (Id serial). */
	@Column(name="vendornmbr", columnDefinition="int8")
	private Long vendornmbr;

	/** The deptnmbr (codigoSetor - devbalcao). */
	@Basic
	@Column(name="clerknmbr", columnDefinition="int8")
	private Long clerknmbr;

	/** The couponfmly (tipoAliquota). */
	@Basic
	@Column(name="couponfmly", length=3)
	private String couponfmly;

	/**
	 * Gets the vendornmbr.
	 *
	 * @return the vendornmbr
	 */
	public Long getVendornmbr() {
		return vendornmbr;
	}

	/**
	 * Sets the vendornmbr.
	 *
	 * @param vendornmbr the new vendornmbr
	 */
	public void setVendornmbr(final Long vendornmbr) {
		this.vendornmbr = vendornmbr;
	}

	/**
	 * Gets the clerknmbr.
	 *
	 * @return the clerknmbr
	 */
	public Long getClerknmbr() {
		return clerknmbr;
	}

	/**
	 * Sets the clerknmbr.
	 *
	 * @param clerknmbr the new clerknmbr
	 */
	public void setClerknmbr(final Long clerknmbr) {
		this.clerknmbr = clerknmbr;
	}

	/**
	 * Gets the couponfmly.
	 *
	 * @return the couponfmly
	 */
	public String getCouponfmly() {
		return couponfmly;
	}

	/**
	 * Sets the couponfmly.
	 *
	 * @param couponfmly the new couponfmly
	 */
	public void setCouponfmly(final String couponfmly) {
		this.couponfmly = couponfmly;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(vendornmbr)
				.append(clerknmbr)
				.append(couponfmly)
				.toHashCode();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(final Object obj) {
		if(obj instanceof ContabilPK){
	        final ContabilPK other = (ContabilPK) obj;
	        return new EqualsBuilder()
	            .append(vendornmbr, other.vendornmbr)
	            .append(clerknmbr, other.clerknmbr)
	            .append(couponfmly, other.couponfmly)
	            .isEquals();
	    } else{
	        return false;
	    }
	}

}