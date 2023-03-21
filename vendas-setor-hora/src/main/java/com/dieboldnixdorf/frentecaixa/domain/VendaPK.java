package com.dieboldnixdorf.frentecaixa.domain;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * The Class VendaPK.
 */
@Embeddable
public class VendaPK implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8817453612561820971L;

	/** The deptnmbr. */
	@Basic
	@Column(name="deptnmbr", length=20)
	private String deptnmbr;

	/** The storenmbr. */
	@Basic
	@Column(name="storenmbr", columnDefinition="int4")
	private Integer storenmbr;

	/** The date. */
	@Basic
	@Column(name="date", length=16)
	private String date;

	/**
	 * Gets the deptnmbr.
	 *
	 * @return the deptnmbr
	 */
	public String getDeptnmbr() {
		return deptnmbr;
	}

	/**
	 * Sets the deptnmbr.
	 *
	 * @param deptnmbr the new deptnmbr
	 */
	public void setDeptnmbr(final String deptnmbr) {
		this.deptnmbr = deptnmbr;
	}

	/**
	 * Gets the storenmbr.
	 *
	 * @return the storenmbr
	 */
	public Integer getStorenmbr() {
		return storenmbr;
	}

	/**
	 * Sets the storenmbr.
	 *
	 * @param storenmbr the new storenmbr
	 */
	public void setStorenmbr(final Integer storenmbr) {
		this.storenmbr = storenmbr;
	}

	/**
	 * Gets the date.
	 *
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Sets the date.
	 *
	 * @param date the new date
	 */
	public void setDate(final String date) {
		this.date = date;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(deptnmbr)
				.append(storenmbr)
				.append(date)
				.toHashCode();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(final Object obj) {
		if(obj instanceof VendaPK){
	        final VendaPK other = (VendaPK) obj;
	        return new EqualsBuilder()
	            .append(deptnmbr, other.deptnmbr)
	            .append(storenmbr, other.storenmbr)
	            .append(date, other.date)
	            .isEquals();
	    } else{
	        return false;
	    }
	}

}