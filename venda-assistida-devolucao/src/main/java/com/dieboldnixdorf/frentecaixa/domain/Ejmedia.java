package com.dieboldnixdorf.frentecaixa.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Class Ejmedia.
 */
@Entity
@Table
public class Ejmedia {

	@Id
	@Column(name="cshrnmbr", columnDefinition="int8")
	private Long cshrnmbr;

	/** The codrms (codigoProdutoEAN). */
	@Column(name="hostid", length=20)
	private String hostid;

	/** The mediaamnt (valorProduto). */
	@Basic
	@Column(name="mediaamnt", columnDefinition="int8")
	private Long mediaamnt;

	/** The mdesc (codigoOperacao). */
	@Basic
	@Column(name="mdesc", length=21)
	private String mdesc;

	/** The qty (quantidadeProduto). */
	@Basic
	@Column(name="altcurrtend", columnDefinition="int8")
	private Long altcurrtend;

	/** The razaoper (razaoOperacao). */
	@Basic
	@Column(name="eftdata1", columnDefinition="bpchar", length=2)
	private String eftdata1;

	/** The cindic (trocaComCuponFiscal). */
	@Basic
	@Column(name="eftdata2", columnDefinition="bpchar", length=1)
	private String eftdata2;

	/** The couponfmly (numeroCuponFiscal). */
	@Basic
	@Column(name="eftdata3", columnDefinition="bpchar", length=9)
	private String eftdata3;

	/** The figfisc (figuraFiscal). */
	@Basic
	@Column(name="eftdata4", columnDefinition="bpchar", length=2)
	private String eftdata4;

	/**
	 * Instantiates a new ejmedia.
	 */
	public Ejmedia() {
	}

	/**
	 * Instantiates a new ejmedia.
	 *
	 * @param cshrnmbr the cshrnmbr
	 */
	public Ejmedia(final Long cshrnmbr) {
		this.cshrnmbr = cshrnmbr;
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
	 * Gets the hostid.
	 *
	 * @return the hostid
	 */
	public String getHostid() {
		return hostid;
	}

	/**
	 * Sets the hostid.
	 *
	 * @param hostid the new hostid
	 */
	public void setHostid(final String hostid) {
		this.hostid = hostid;
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
	 * Gets the altcurrtend.
	 *
	 * @return the altcurrtend
	 */
	public Long getAltcurrtend() {
		return altcurrtend;
	}

	/**
	 * Sets the altcurrtend.
	 *
	 * @param altcurrtend the new altcurrtend
	 */
	public void setAltcurrtend(final Long altcurrtend) {
		this.altcurrtend = altcurrtend;
	}

	/**
	 * Gets the eftdata 1.
	 *
	 * @return the eftdata 1
	 */
	public String getEftdata1() {
		return eftdata1;
	}

	/**
	 * Sets the eftdata 1.
	 *
	 * @param eftdata1 the new eftdata 1
	 */
	public void setEftdata1(final String eftdata1) {
		this.eftdata1 = eftdata1;
	}

	/**
	 * Gets the eftdata 2.
	 *
	 * @return the eftdata 2
	 */
	public String getEftdata2() {
		return eftdata2;
	}

	/**
	 * Sets the eftdata 2.
	 *
	 * @param eftdata2 the new eftdata 2
	 */
	public void setEftdata2(final String eftdata2) {
		this.eftdata2 = eftdata2;
	}

	/**
	 * Gets the eftdata 3.
	 *
	 * @return the eftdata 3
	 */
	public String getEftdata3() {
		return eftdata3;
	}

	/**
	 * Sets the eftdata 3.
	 *
	 * @param eftdata3 the new eftdata 3
	 */
	public void setEftdata3(final String eftdata3) {
		this.eftdata3 = eftdata3;
	}

	/**
	 * Gets the eftdata 4.
	 *
	 * @return the eftdata 4
	 */
	public String getEftdata4() {
		return eftdata4;
	}

	/**
	 * Sets the eftdata 4.
	 *
	 * @param eftdata4 the new eftdata 4
	 */
	public void setEftdata4(final String eftdata4) {
		this.eftdata4 = eftdata4;
	}
}