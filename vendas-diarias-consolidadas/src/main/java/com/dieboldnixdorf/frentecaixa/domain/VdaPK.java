package com.dieboldnixdorf.frentecaixa.domain;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * The Class VdaPK.
 */
@Embeddable
public class VdaPK implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1427122196455520442L;

	/** The plunmbr. */
	@Column(name="plunmbr", length=20)	
	private String plunmbr;
	
	/** The termnmbr. */
	@Basic
	@Column(name="termnmbr", columnDefinition="int2")
	private Short termnmbr;

	/**
	 * Gets the plunmbr.
	 *
	 * @return the plunmbr
	 */
	public String getPlunmbr() {
		return plunmbr;
	}

	/**
	 * Sets the plunmbr.
	 *
	 * @param plunmbr the new plunmbr
	 */
	public void setPlunmbr(final String plunmbr) {
		this.plunmbr = plunmbr;
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
				.append(plunmbr)
				.append(termnmbr)
				.toHashCode();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(final Object obj) {
		if(obj instanceof VdaPK){
	        final VdaPK other = (VdaPK) obj;
	        return new EqualsBuilder()
	            .append(plunmbr, other.plunmbr)
	            .append(termnmbr, other.termnmbr)
	            .isEquals();
	    } else{
	        return false;
	    }
	}

}