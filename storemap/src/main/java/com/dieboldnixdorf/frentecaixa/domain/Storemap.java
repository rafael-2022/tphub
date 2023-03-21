package com.dieboldnixdorf.frentecaixa.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Class Storemap.
 */
@Entity
@Table(schema="public", name="storemap")
public class Storemap {
	
	/** The id_store_tpadmin. */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_store_tpadmin", columnDefinition="int4")
	private Integer id_store_tpadmin;

	/** The id_store_gold. */
	@Basic
	@Column(name="id_store_gold", length=4)
	private String id_store_gold;
	
	/** The store_ip_tplinux. */
	@Basic
	@Column(name="store_ip_tplinux", length=20)
	private String store_ip_tplinux;

	/** The code_store_gold. */
	@Basic
	@Column(name="code_store_gold", length=10)
	private String code_store_gold;

	/**
	 * Instantiates a new storemap.
	 */
	public Storemap() {
	}

	/**
	 * Instantiates a new storemap.
	 *
	 * @param id_store_tpadmin the id_store_tpadmin
	 */
	public Storemap(final Integer id_store_tpadmin) {
		this.id_store_tpadmin = id_store_tpadmin;
	}

	/**
	 * Gets the id store tpadmin.
	 *
	 * @return the id store tpadmin
	 */
	public Integer getId_store_tpadmin() {
		return id_store_tpadmin;
	}

	/**
	 * Sets the id store tpadmin.
	 *
	 * @param id_store_tpadmin the new id store tpadmin
	 */
	public void setId_store_tpadmin(final Integer id_store_tpadmin) {
		this.id_store_tpadmin = id_store_tpadmin;
	}

	/**
	 * Gets the id store gold.
	 *
	 * @return the id store gold
	 */
	public String getId_store_gold() {
		return id_store_gold;
	}

	/**
	 * Sets the id store gold.
	 *
	 * @param id_store_gold the new id store gold
	 */
	public void setId_store_gold(final String id_store_gold) {
		this.id_store_gold = id_store_gold;
	}

	/**
	 * Gets the store ip tplinux.
	 *
	 * @return the store ip tplinux
	 */
	public String getStore_ip_tplinux() {
		return store_ip_tplinux;
	}

	/**
	 * Sets the store ip tplinux.
	 *
	 * @param store_ip_tplinux the new store ip tplinux
	 */
	public void setStore_ip_tplinux(final String store_ip_tplinux) {
		this.store_ip_tplinux = store_ip_tplinux;
	}

	/**
	 * Gets the code store gold.
	 *
	 * @return the code store gold
	 */
	public String getCode_store_gold() {
		return code_store_gold;
	}

	/**
	 * Sets the code store gold.
	 *
	 * @param code_store_gold the new code store gold
	 */
	public void setCode_store_gold(final String code_store_gold) {
		this.code_store_gold = code_store_gold;
	}
}