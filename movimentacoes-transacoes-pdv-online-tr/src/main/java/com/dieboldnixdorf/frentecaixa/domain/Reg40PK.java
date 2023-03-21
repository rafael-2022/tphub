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
public class Reg40PK implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5705307029581603805L;

	/** The datahora sod. */
	@Temporal(TemporalType.TIMESTAMP)
	private Date datahora_sod;

	/** The datahora eod. */
	@Temporal(TemporalType.TIMESTAMP)
	private Date datahora_eod;

	/** The linenmbr - numeroFormaPagamento. */
	@Basic
	@Column(name="linenmbr", columnDefinition="int4")
	private Integer linenmbr;

	/** The transnmbr. */
	@Basic
	@Column(name="transnmbr", columnDefinition="int4")
	private Integer transnmbr;

	/** The termnmbr. */
	@Basic
	@Column(name="termnmbr", columnDefinition="int2")
	private Short termnmbr;

  /** The loyaltycardid.*/
  @Basic
  @Column(name="loyaltycardid", columnDefinition="character varying")
  private String loyaltycardid;
	
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
   * Gets the loyaltycardid
   *
   * @return the loyaltycardid
   */
  public String getLoyaltycardid() {
    return loyaltycardid;
  }

  /**
   * Sets the loyaltycardid
   *
   * @param loyaltycardid then new loyaltycardid
   */
  public void setLoyaltycardid(String loyaltycardid){
    this.loyaltycardid = loyaltycardid;
  }
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(linenmbr)
				.append(transnmbr)
				.append(termnmbr)
        .append(loyaltycardid.getBytes())
				.append(datahora_sod)
				.append(datahora_eod)
				.toHashCode();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(final Object obj) {
		if(obj instanceof Reg40PK){
	        final Reg40PK other = (Reg40PK) obj;
	        return new EqualsBuilder()
	            .append(linenmbr, other.linenmbr)
	            .append(transnmbr, other.transnmbr)
	            .append(termnmbr, other.termnmbr)
              .append(loyaltycardid.getBytes(), other.loyaltycardid.getBytes()) 
	            .append(datahora_sod, other.datahora_sod)
	            .append(datahora_eod, other.datahora_eod)
	            .isEquals();
	    } else{
	        return false;
	    }
	}
	
}
