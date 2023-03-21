package com.dieboldnixdorf.frentecaixa.service;

import java.io.Serializable;

import org.springframework.util.Assert;

/**
 * The Class StoreMapSearchCriteria.
 */
public class StoreMapSearchCriteria implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The codigo loja. */
	private String codigoLoja;
	
	/**
	 * Instantiates a new store map search criteria.
	 */
	public StoreMapSearchCriteria() {
	}

	public StoreMapSearchCriteria(final String codigoLoja) {
		Assert.notNull(codigoLoja, "Código da Loja não deve ser nulo");
		this.codigoLoja = codigoLoja;
	}

	/**
	 * Gets the codigo loja.
	 *
	 * @return the codigo loja
	 */
	public String getCodigoLoja() {
		return codigoLoja;
	}

	/**
	 * Sets the codigo loja.
	 *
	 * @param codigoLoja the new codigo loja
	 */
	public void setCodigoLoja(final String codigoLoja) {
		this.codigoLoja = codigoLoja;
	}
}