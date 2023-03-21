package com.dieboldnixdorf.frentecaixa.security.rfc7519;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;


/**
 * The Class AuthenticatedUser.
 */
public class AuthenticatedUser implements Authentication {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7124226241597233571L;
	
	/** The name. */
	private String name;
    
    /** The authenticated. */
    private boolean authenticated = true;

    /**
     * Instantiates a new authenticated user.
     *
     * @param name the name
     */
    AuthenticatedUser(final String name){
        this.name = name;
    }

	/**
	 * {@inheritDoc}
	 */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

	/**
	 * {@inheritDoc}
	 */
    @Override
    public Object getCredentials() {
        return null;
    }

	/**
	 * {@inheritDoc}
	 */
    @Override
    public Object getDetails() {
        return null;
    }

	/**
	 * {@inheritDoc}
	 */
    @Override
    public Object getPrincipal() {
        return null;
    }

	/**
	 * {@inheritDoc}
	 */
    @Override
    public boolean isAuthenticated() {
        return this.authenticated;
    }

	/**
	 * {@inheritDoc}
	 */
    @Override
    public void setAuthenticated(final boolean b) throws IllegalArgumentException {
        this.authenticated = b;
    }

	/**
	 * {@inheritDoc}
	 */
    @Override
    public String getName() {
        return this.name;
    }
}
