package com.dieboldnixdorf.frentecaixa.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * The Class Ejmedia.
 */
@Entity
@Table
public class Ejmedia {
	
	/** The contabil PK. */
	@EmbeddedId
	private ContabilPK contabilPK;

	/** The mediaamnt. */
	@Basic
	@Column(name="mediaamnt", columnDefinition="int8")
	private Long mediaamnt;
	
	/**
	 * Instantiates a new ejmedia.
	 */
	public Ejmedia() {
	}

	/**
	 * Gets the contabil PK.
	 *
	 * @return the contabil PK
	 */
	public ContabilPK getContabilPK() {
		return contabilPK;
	}

	/**
	 * Sets the contabil PK.
	 *
	 * @param contabilPK the new contabil PK
	 */
	public void setContabilPK(final ContabilPK contabilPK) {
		this.contabilPK = contabilPK;
	}

	/**
	 * Gets the mediaamnt.
	 *
	 * @return the mediaamnt
	 */
	public Long getMediaamnt() {
		return mediaamnt;
	}

	/**
	 * Sets the mediaamnt.
	 *
	 * @param mediaamnt the new mediaamnt
	 */
	public void setMediaamnt(final Long mediaamnt) {
		this.mediaamnt = mediaamnt;
	}
}