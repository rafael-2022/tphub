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

	/** The skunmbr. */
	@Column(name="print1text", length=20)
	private String print1text;

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
				.append(print1text)
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
		if(obj instanceof ContabilPK){
	        final ContabilPK other = (ContabilPK) obj;
	        return new EqualsBuilder()
		        .append(print1text, other.print1text)
		        .append(linenmbr, other.linenmbr)
	            .append(termnmbr, other.termnmbr)
	            .append(transnmbr, other.transnmbr)
	            .isEquals();
	    } else{
	        return false;
	    }
	}

}