package com.dieboldnixdorf.frentecaixa.domain;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * The Class DescontoPK.
 */
@Embeddable
public class DescontoPK implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4121116848555573320L;

	/** The linenmbr. */
	@Basic
	@Column(name="linenmbr", columnDefinition="int4")
	private Integer linenmbr;

	/** The termnmbr. */
	@Basic
	@Column(name="termnmbr", columnDefinition="int2")
	private Short termnmbr;

	/** The transnmbr. */
	@Basic
	@Column(name="transnmbr", columnDefinition="int4")
	private Integer transnmbr;

	/**
	 * Gets the linenmbr.
	 *
	 * @return the linenmbr
	 */
	public Integer getLinenmbr() {
		return linenmbr;
	}

	/**
	 * Sets the linenmbr.
	 *
	 * @param linenmbr the new linenmbr
	 */
	public void setLinenmbr(final Integer linenmbr) {
		this.linenmbr = linenmbr;
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
				.append(linenmbr)
				.append(termnmbr)
				.append(transnmbr)
				.toHashCode();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(final Object obj) {
		if(obj instanceof DescontoPK){
	        final DescontoPK other = (DescontoPK) obj;
	        return new EqualsBuilder()
		        .append(linenmbr, other.linenmbr)
	            .append(termnmbr, other.termnmbr)
	            .append(transnmbr, other.transnmbr)
	            .isEquals();
	    } else{
	        return false;
	    }
	}

}