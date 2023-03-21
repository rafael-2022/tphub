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
 * The Class Reg20PK.
 */
@Embeddable
public class Reg20PK implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4659965555258085681L;

	/** The plunmbr - codigoRMSProduto. */
	@Basic
	@Column(name="plunmbr", length=21)
	private String plunmbr;

	/** The seq - Contador Registros. */
	@Basic
	@Column(name="seq", columnDefinition="int4")
	private Integer seq;

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
	
	/** The datahora sod. */
	@Temporal(TemporalType.TIMESTAMP)
	private Date datahora_sod;

	/** The datahora eod. */
	@Temporal(TemporalType.TIMESTAMP)
	private Date datahora_eod;
	
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
	 * Gets the seq.
	 *
	 * @return the seq
	 */
	public Integer getSeq() {
		return seq;
	}

	/**
	 * Sets the seq.
	 *
	 * @param seq the new seq
	 */
	public void setSeq(final Integer seq) {
		this.seq = seq;
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
				.append(plunmbr)
				.append(seq)
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
		if(obj instanceof Reg20PK){
	        final Reg20PK other = (Reg20PK) obj;
	        return new EqualsBuilder()
	            .append(plunmbr, other.plunmbr)
	            .append(seq, other.seq)
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
