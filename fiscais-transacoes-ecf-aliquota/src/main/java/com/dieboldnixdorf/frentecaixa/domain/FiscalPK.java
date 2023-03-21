package com.dieboldnixdorf.frentecaixa.domain;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * The Class FiscalPK.
 */
@Embeddable
public class FiscalPK implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5189103833989414805L;

	/** The couponfmly. */
	@Basic
	@Column(name="couponfmly", length=3)
	private String couponfmly;
	
	/** The termnmbr. */
	@Basic
	@Column(name="termnmbr", columnDefinition="int2")
	private Short termnmbr;

	/** The print1text (cust_acc.taxnmbr). */
	@Basic
	@Column(name="print1text", length=20)
	private String print1text;


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
	 * Gets the prints the 1 text.
	 *
	 * @return the prints the 1 text
	 */
	public String getPrint1text() {
		return print1text;
	}

	/**
	 * Sets the prints the 1 text.
	 *
	 * @param print1text the new prints the 1 text
	 */
	public void setPrint1text(final String print1text) {
		this.print1text = print1text;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(couponfmly)
				.append(termnmbr)
				.append(print1text)
				.toHashCode();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(final Object obj) {
		if(obj instanceof FiscalPK){
	        final FiscalPK other = (FiscalPK) obj;
	        return new EqualsBuilder()
	            .append(couponfmly, other.couponfmly)
	            .append(termnmbr, other.termnmbr)
	            .append(print1text, other.print1text)
	            .isEquals();
	    } else{
	        return false;
	    }
	}

}