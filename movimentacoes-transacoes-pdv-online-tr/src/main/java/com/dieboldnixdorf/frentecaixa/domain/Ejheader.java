package com.dieboldnixdorf.frentecaixa.domain;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The Class Ejheader.
 */
@Entity
@Table
public class Ejheader {
	
	/** The movimentacao PK. */
	@EmbeddedId
	private MovimentacaoPK movimentacaoPK;
	
	/** The storenmbr. */
	private Integer ostorenmbr;

	/** The drwrnmbr - serieDocumentoFiscal. */
	@Basic
	@Column(name="drwrnmbr", columnDefinition="int8")
	private Integer drwrnmbr;
	
	/** The loyaltycardid - numeroDANFE. */
	@Basic
	@Column(name="loyaltycardid", columnDefinition="bpchar", length=44)
	private String loyaltycardid;	
	
	/** The mngrovnmbr - numeroDocumentoFiscal. */
	@Basic
	@Column(name="mngrovnmbr", columnDefinition="int8")
	private Long mngrovnmbr;

	@Basic
	@Column(name="pk", columnDefinition="int8")
	private Long pk;
	
	/** The dataproc. */
	@Temporal(TemporalType.TIMESTAMP)
	private Date odataproc;

	/**
	 * Instantiates a new ejheader.
	 */
	public Ejheader() {
	}

	/**
	 * Gets the movimentacao PK.
	 *
	 * @return the movimentacao PK
	 */
	public MovimentacaoPK getMovimentacaoPK() {
		return movimentacaoPK;
	}

	/**
	 * Sets the movimentacao PK.
	 *
	 * @param movimentacaoPK the new movimentacao PK
	 */
	public void setMovimentacaoPK(final MovimentacaoPK movimentacaoPK) {
		this.movimentacaoPK = movimentacaoPK;
	}

	/**
	 * Gets the ostorenmbr.
	 *
	 * @return the ostorenmbr
	 */
	public Integer getOstorenmbr() {
		return ostorenmbr;
	}

	/**
	 * Sets the ostorenmbr.
	 *
	 * @param ostorenmbr the new ostorenmbr
	 */
	public void setOstorenmbr(final Integer ostorenmbr) {
		this.ostorenmbr = ostorenmbr;
	}

	/**
	 * Gets the drwrnmbr.
	 *
	 * @return the drwrnmbr
	 */
	public Integer getDrwrnmbr() {
		return drwrnmbr;
	}

	/**
	 * Sets the drwrnmbr.
	 *
	 * @param drwrnmbr the new drwrnmbr
	 */
	public void setDrwrnmbr(final Integer drwrnmbr) {
		this.drwrnmbr = drwrnmbr;
	}

	/**
	 * Gets the loyaltycardid.
	 *
	 * @return the loyaltycardid
	 */
	public String getLoyaltycardid() {
		return loyaltycardid;
	}

	/**
	 * Sets the loyaltycardid.
	 *
	 * @param loyaltycardid the new loyaltycardid
	 */
	public void setLoyaltycardid(final String loyaltycardid) {
		this.loyaltycardid = loyaltycardid;
	}

	/**
	 * Gets the mngrovnmbr.
	 *
	 * @return the mngrovnmbr
	 */
	public Long getMngrovnmbr() {
		return mngrovnmbr;
	}

	/**
	 * Sets the mngrovnmbr.
	 *
	 * @param mngrovnmbr the new mngrovnmbr
	 */
	public void setMngrovnmbr(final Long mngrovnmbr) {
		this.mngrovnmbr = mngrovnmbr;
	}

	/**
	* Gets / sets the pk
	*/
	public Long getPk() {
		return pk;
	}
	public void setPk(Long value) {
		this.pk = value;
	}

	/**
	 * Gets the odataproc.
	 *
	 * @return the odataproc
	 */
	public Date getOdataproc() {
		return odataproc;
	}

	/**
	 * Sets the odataproc.
	 *
	 * @param odataproc the new odataproc
	 */
	public void setOdataproc(final Date odataproc) {
		this.odataproc = odataproc;
	}

	@Override
	public String toString() {
		return "Ejheader [movimentacaoPK=" + movimentacaoPK + ", ostorenmbr=" + ostorenmbr + ", drwrnmbr=" + drwrnmbr
				+ ", loyaltycardid=" + loyaltycardid + ", mngrovnmbr=" + mngrovnmbr + ", pk=" + pk + ", odataproc="
				+ odataproc + "]";
	}
	
	

}
