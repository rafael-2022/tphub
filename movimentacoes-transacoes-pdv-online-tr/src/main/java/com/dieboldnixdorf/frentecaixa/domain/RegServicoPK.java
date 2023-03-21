package com.dieboldnixdorf.frentecaixa.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * The Class Reg40PK.
 */
@Embeddable
public class RegServicoPK implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5705307029581603805L;

	/** The datahora sod. */
	@Temporal(TemporalType.TIMESTAMP)
	private Date datahora_sod;

	/** The datahora eod. */
	@Temporal(TemporalType.TIMESTAMP)
	private Date datahora_eod;

	@Basic
	@Column(name="seq", columnDefinition="int4")
	private Integer seq;
	
	
	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	/**
	 * Gets the datahora sod.
	 *
	 * @return the datahora sod
	 */
	public Date getDatahora_sod() {
		return datahora_sod;
	}

	/**
	 * Sets the datahora sod.
	 *
	 * @param datahora_sod the new datahora sod
	 */
	public void setDatahora_sod(final Date datahora_sod) {
		this.datahora_sod = datahora_sod;
	}

	/**
	 * Gets the datahora eod.
	 *
	 * @return the datahora eod
	 */
	public Date getDatahora_eod() {
		return datahora_eod;
	}

	/**
	 * Sets the datahora eod.
	 *
	 * @param datahora_eod the new datahora eod
	 */
	public void setDatahora_eod(final Date datahora_eod) {
		this.datahora_eod = datahora_eod;
	}

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(datahora_sod)
				.append(datahora_eod)
				.append(seq)
				.toHashCode();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(final Object obj) {
		if(obj instanceof RegServicoPK){
	        final RegServicoPK other = (RegServicoPK) obj;
	        return new EqualsBuilder()
	            .append(datahora_sod, other.datahora_sod)
	            .append(datahora_eod, other.datahora_eod)
	            .append(seq, other.seq)
	            .isEquals();
	    } else{
	        return false;
	    }
	}
	
}
