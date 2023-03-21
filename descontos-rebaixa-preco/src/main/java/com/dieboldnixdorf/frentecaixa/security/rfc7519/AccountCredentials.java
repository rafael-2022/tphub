package com.dieboldnixdorf.frentecaixa.security.rfc7519;

/**
 * The Class AccountCredentials.
 */
public class AccountCredentials {

    /** The username. */
    private String username;
    
    /** The password. */
    private String password;

    /**
     * Gets the username.
     *
     * @return the username
     */
    public String getUsername() { 
    	return username; 
    }
    
    /**
     * Gets the password.
     *
     * @return the password
     */
    public String getPassword() { 
    	return password; 
    }

    /**
     * Sets the username.
     *
     * @param username the new username
     */
    public void setUsername(final String username) { 
    	this.username = username; 
    }
    
    /**
     * Sets the password.
     *
     * @param password the new password
     */
    public void setPassword(final String password) { 
    	this.password = password; 
    }
}
