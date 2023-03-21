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
 * The Class Ejitem.
 */
@Entity
@Table
public class Ejitem {

	/** The movimentacao PK. */
	@EmbeddedId
	private MovimentacaoPK movimentacaoPK;

	/** The merchfmly - termnmbr. */
	@Basic
	@Column(name="merchfmly", length=21)
	private String merchfmly;
	
	/** The deptnmbr. */
	@Basic
	@Column(name="deptnmbr", columnDefinition="bpchar", length=20)
	private String deptnmbr;

	/** The pludesc. */
	@Basic
	@Column(name="pludesc", columnDefinition="bpchar", length=21)
	private String pludesc;

	/** The qty 1. */
	@Basic
	@Column(name="qty1", columnDefinition="int8")
	private Long qty1;

	/** The price 1. */
	@Basic
	@Column(name="price1", columnDefinition="int8")
	private Long price1;

	/** The tporet. */
	@Basic
	@Column(name="print1text", columnDefinition="bpchar", length=20)
	private String print1text;
	
	/** The descrret. */
	@Basic
	@Column(name="print2text", columnDefinition="bpchar", length=20)
	private String print2text;
	
	/** The cshrnmbr. */
	@Basic
	@Column(name="cshrnmbr", columnDefinition="int8")
	private Long cshrnmbr;
	
	/** The fiscalizador. */
	private Long fiscalizador;
	
	/** The datahora. */
	@Temporal(TemporalType.TIMESTAMP)
	private Date datahora;
        
        
        /** The matricula. */
	@Basic
	@Column(name="matricula", length=10)
	private String matricula;
	
	/**
	 * Instantiates a new ejitem.
	 */
	public Ejitem() {
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
	public void setDeptnmbr(String deptnmbr) {
		this.deptnmbr = deptnmbr;
	}

	/**
	 * Gets the pludesc.
	 *
	 * @return the pludesc
	 */
	public String getPludesc() {
		return pludesc;
	}

	/**
	 * Sets the pludesc.
	 *
	 * @param pludesc the new pludesc
	 */
	public void setPludesc(String pludesc) {
		this.pludesc = pludesc;
	}

	/**
	 * Gets the qty 1.
	 *
	 * @return the qty 1
	 */
	public Long getQty1() {
		return qty1;
	}

	/**
	 * Sets the qty 1.
	 *
	 * @param qty1 the new qty 1
	 */
	public void setQty1(Long qty1) {
		this.qty1 = qty1;
	}

	/**
	 * Gets the price 1.
	 *
	 * @return the price 1
	 */
	public Long getPrice1() {
		return price1;
	}

	/**
	 * Sets the price 1.
	 *
	 * @param price1 the new price 1
	 */
	public void setPrice1(Long price1) {
		this.price1 = price1;
	}

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
	public void setPrint1text(String print1text) {
		this.print1text = print1text;
	}

	/**
	 * Gets the prints the 2 text.
	 *
	 * @return the prints the 2 text
	 */
	public String getPrint2text() {
		return print2text;
	}

	/**
	 * Sets the prints the 2 text.
	 *
	 * @param print2text the new prints the 2 text
	 */
	public void setPrint2text(String print2text) {
		this.print2text = print2text;
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
	public void setCshrnmbr(Long cshrnmbr) {
		this.cshrnmbr = cshrnmbr;
	}

	/**
	 * Gets the merchfmly.
	 *
	 * @return the merchfmly
	 */
	public String getMerchfmly() {
		return merchfmly;
	}

	/**
	 * Sets the merchfmly.
	 *
	 * @param merchfmly the new merchfmly
	 */
	public void setMerchfmly(String merchfmly) {
		this.merchfmly = merchfmly;
	}

	/**
	 * Gets the fiscalizador.
	 *
	 * @return the fiscalizador
	 */
	public Long getFiscalizador() {
		return fiscalizador;
	}

	/**
	 * Sets the fiscalizador.
	 *
	 * @param fiscalizador the new fiscalizador
	 */
	public void setFiscalizador(final Long fiscalizador) {
		this.fiscalizador = fiscalizador;
	}

	/**
	 * Gets the datahora.
	 *
	 * @return the datahora
	 */
	public Date getDatahora() {
		return datahora;
	}

	/**
	 * Sets the datahora.
	 *
	 * @param datahora the new datahora
	 */
	public void setDatahora(final Date datahora) {
		this.datahora = datahora;
	}
        /**
	 * Gets the matricula.
	 *
	 * @return the matricula
	 */
	public String getMatricula() {
		return matricula;
	}

	/**
	 * Sets the matricula.
	 *
	 * @param matricula the new matricula
	 */
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
}