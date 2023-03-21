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

	/** The sznumber1 - deptnmbr. */
	@Column(name="sznumber1", length=21)
	private String sznumber1;

	/** The termnmbr. */
	@Basic
	@Column(name="termnmbr", columnDefinition="int2")
	private Short termnmbr;

	/** The transnmbr. */
	@Basic
	@Column(name="transnmbr", columnDefinition="int4")
	private Integer transnmbr;

	/**
	 * Gets the sznumber 1.
	 *
	 * @return the sznumber 1
	 */
	public String getSznumber1() {
		return sznumber1;
	}

	/**
	 * Sets the sznumber 1.
	 *
	 * @param sznumber1 the new sznumber 1
	 */
	public void setSznumber1(final String sznumber1) {
		this.sznumber1 = sznumber1;
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
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(sznumber1)
				.append(termnmbr)
				.append(transnmbr)
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
	            .append(sznumber1, other.sznumber1)
	            .append(termnmbr, other.termnmbr)
	            .append(transnmbr, other.transnmbr)
	            .isEquals();
	    } else{
	        return false;
	    }
	}

}