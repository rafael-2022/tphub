package com.dieboldnixdorf.frentecaixa.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Class Ejtrailer.
 */
@Entity
@Table
public class Ejtrailer {
	
	/** The date (Data_Movimentacao). */
	@Id
	@Column(name="loja", length=30)
	private String loja;

	/** The totalvat (Numero_Registros_Arquivo). */
	@Basic
	@Column(name="totalvat", columnDefinition="int4")
	private Integer totalvat;

	/** The totalaos (Valor_Contabil_Total). */
	@Basic
	@Column(name="totalaos", columnDefinition="int8")
	private Long totalaos;

	/** The totalmanualdisc (Base_Calculo_Total). */
	@Basic
	@Column(name="totalmanualdisc", columnDefinition="int8")
	private Long totalmanualdisc;

	/** The totalpoints (Imposto_Debitado_Total). */
	@Basic
	@Column(name="totalpoints", columnDefinition="int8")
	private Long totalpoints;

	/** The totalmkdn (Numero_Clientes_Total). */
	@Basic
	@Column(name="totalmkdn", columnDefinition="int8")
	private Long totalmkdn;

	/** The seq (Numero_Mapa_Resumo). */
	@Basic
	@Column(name="seq", columnDefinition="int4")
	private Integer seq;

	/**
	 * Instantiates a new ejtrailer.
	 */
	public Ejtrailer() {
	}

	/**
	 * Instantiates a new ejtrailer.
	 *
	 * @param date the date
	 */
	public Ejtrailer(final String loja) {
		this.loja = loja;
	}

	/**
	 * Gets the totalvat.
	 *
	 * @return the totalvat
	 */
	public Integer getTotalvat() {
		return totalvat;
	}

	/**
	 * Sets the totalvat.
	 *
	 * @param totalvat the new totalvat
	 */
	public void setTotalvat(final Integer totalvat) {
		this.totalvat = totalvat;
	}

	/**
	 * Gets the totalaos.
	 *
	 * @return the totalaos
	 */
	public Long getTotalaos() {
		return totalaos;
	}

	/**
	 * Sets the totalaos.
	 *
	 * @param totalaos the new totalaos
	 */
	public void setTotalaos(final Long totalaos) {
		this.totalaos = totalaos;
	}

	/**
	 * Gets the totalmanualdisc.
	 *
	 * @return the totalmanualdisc
	 */
	public Long getTotalmanualdisc() {
		return totalmanualdisc;
	}

	/**
	 * Sets the totalmanualdisc.
	 *
	 * @param totalmanualdisc the new totalmanualdisc
	 */
	public void setTotalmanualdisc(final Long totalmanualdisc) {
		this.totalmanualdisc = totalmanualdisc;
	}

	/**
	 * Gets the totalpoints.
	 *
	 * @return the totalpoints
	 */
	public Long getTotalpoints() {
		return totalpoints;
	}

	/**
	 * Sets the totalpoints.
	 *
	 * @param totalpoints the new totalpoints
	 */
	public void setTotalpoints(final Long totalpoints) {
		this.totalpoints = totalpoints;
	}

	/**
	 * Gets the totalmkdn.
	 *
	 * @return the totalmkdn
	 */
	public Long getTotalmkdn() {
		return totalmkdn;
	}

	/**
	 * Sets the totalmkdn.
	 *
	 * @param totalmkdn the new totalmkdn
	 */
	public void setTotalmkdn(final Long totalmkdn) {
		this.totalmkdn = totalmkdn;
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

}