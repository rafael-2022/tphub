package com.dieboldnixdorf.frentecaixa.domain;

import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * The Class StoremapDto.
 */
@JsonRootName("Storemap")
public class StoremapDto {
	
	/** The idStoreGold. */
	private Integer idStoreGold;
	
	/** The storeIpTPLinux. */
	private String storeIpTPLinux;

	/** The codeStoreGold. */
	private String codeStoreGold;

	/**
	 * Gets the id store gold.
	 *
	 * @return the id store gold
	 */
	public Integer getIdStoreGold() {
		return idStoreGold;
	}

	/**
	 * Sets the id store gold.
	 *
	 * @param idStoreGold the new id store gold
	 */
	public void setIdStoreGold(final Integer idStoreGold) {
		this.idStoreGold = idStoreGold;
	}

	/**
	 * Gets the store ip TP linux.
	 *
	 * @return the store ip TP linux
	 */
	public String getStoreIpTPLinux() {
		return storeIpTPLinux;
	}

	/**
	 * Sets the store ip TP linux.
	 *
	 * @param storeIpTPLinux the new store ip TP linux
	 */
	public void setStoreIpTPLinux(final String storeIpTPLinux) {
		this.storeIpTPLinux = storeIpTPLinux;
	}

	/**
	 * Gets the code store gold.
	 *
	 * @return the code store gold
	 */
	public String getCodeStoreGold() {
		return codeStoreGold;
	}

	/**
	 * Sets the code store gold.
	 *
	 * @param codeStoreGold the new code store gold
	 */
	public void setCodeStoreGold(final String codeStoreGold) {
		this.codeStoreGold = codeStoreGold;
	}
}