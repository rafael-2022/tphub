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
	private static final long serialVersionUID = 138358215181315656L;

	/** The termnmbr. */
	@Basic
	@Column(name="termnmbr", columnDefinition="int2")
	private Short termnmbr;

	/** The cshrnmbr. */
	@Basic
	@Column(name="cshrnmbr", columnDefinition="int8")
	private Long cshrnmbr;

	/** The mdesc. */
	@Basic
	@Column(name="mdesc", length=21)
	private String mdesc;

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
	 * Gets the cshrnmbr.
	 *
	 * @return the cshrnmbr
	 */
	public Long getCshrnmbr() {
		return cshrnmbr;
	}

	/**
	 * Sets the cshrnmbr.
	 *
	 * @param cshrnmbr the new cshrnmbr
	 */
	public void setCshrnmbr(final Long cshrnmbr) {
		this.cshrnmbr = cshrnmbr;
	}

	/**
	 * Gets the mdesc.
	 *
	 * @return the mdesc
	 */
	public String getMdesc() {
		return mdesc;
	}

	/**
	 * Sets the mdesc.
	 *
	 * @param mdesc the new mdesc
	 */
	public void setMdesc(final String mdesc) {
		this.mdesc = mdesc;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(termnmbr)
				.append(cshrnmbr)
				.append(mdesc)
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
	            .append(termnmbr, other.termnmbr)
	            .append(cshrnmbr, other.cshrnmbr)
	            .append(mdesc, other.mdesc)
	            .isEquals();
	    } else{
	        return false;
	    }
	}	
}