package com.dieboldnixdorf.frentecaixa.service;

import org.hibernate.EmptyInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

/**
 * The Class HibernateInterceptor.
 */
@Component
@SessionScope
public class HibernateInterceptor extends EmptyInterceptor {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7482738900702969045L;
	
	/** The store ip TP linux. */
	private String storeIpTPLinux;
	
	/** The esquema vendas. */
	private String esquemaVendas;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String onPrepareStatement(final String sql) {
    	String prepedStatement = super.onPrepareStatement(sql);
        prepedStatement = prepedStatement.replaceAll("@ejopbalcao", getEsquemaVendas().concat(".").concat("ejopbalcao"));
        //prepedStatement = prepedStatement.replaceAll("@operacoes", getStoreIpTPLinux().concat(".").concat("operacoes"));
        //prepedStatement = prepedStatement.replaceAll("@sku", getStoreIpTPLinux().concat(".").concat("sku"));
        return prepedStatement;
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
	 * Gets the esquema vendas.
	 *
	 * @return the esquema vendas
	 */
	public String getEsquemaVendas() {
		return esquemaVendas;
	}

	/**
	 * Sets the esquema vendas.
	 *
	 * @param esquemaVendas the new esquema vendas
	 */
	public void setEsquemaVendas(final String esquemaVendas) {
		this.esquemaVendas = esquemaVendas;
	}

}
