package com.dieboldnixdorf.frentecaixa.domain;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * The Class Reg10PK.
 */
@Embeddable
public class Reg10PK implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4659965555258085681L;

	/** The transnmbr. */
	@Basic
	@Column(name="transnmbr", columnDefinition="int4")
	private Integer transnmbr;

	/** The termnmbr. */
	@Basic
	@Column(name="termnmbr", columnDefinition="int2")
	private Short termnmbr;
	
	/**
	 * Gets the transnmbr.
	 *
	 * @return the transnmbr
	 */
	public Integer getTransnmbr() {
		return transnmbr;
	}

	/**
	 * Sets the transnmbr.
	 *
	 * @param transnmbr the new transnmbr
	 */
	public void setTransnmbr(final Integer transnmbr) {
		this.transnmbr = transnmbr;
	}

	/**
	 * Gets the termnmbr.
	 *
	 * @return the termnmbr
	 */
	public Short getTermnmbr() {
		return termnmbr;
	}

	/**
	 * Sets the termnmbr.
	 *
	 * @param termnmbr the new termnmbr
	 */
	public void setTermnmbr(final Short termnmbr) {
		this.termnmbr = termnmbr;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(transnmbr)
				.append(termnmbr)
				.toHashCode();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(final Object obj) {
		if(obj instanceof Reg10PK){
	        final Reg10PK other = (Reg10PK) obj;
	        return new EqualsBuilder()
	            .append(transnmbr, other.transnmbr)
	            .append(termnmbr, other.termnmbr)
	            .isEquals();
	    } else{
	        return false;
	    }
	}
}