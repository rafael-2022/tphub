package com.dieboldnixdorf.frentecaixa.security.rfc7519;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


/**
 * The Class TokenAuthenticationService.
 */
public class TokenAuthenticationService {

    /** The Constant EXPIRATIONTIME. */
    //public static final long EXPIRATIONTIME = 1000 * 60 * 60 * 24 * 1; // 1 day
	public static final long EXPIRATIONTIME = 1000 * 60 * 60; // 60 minutes
    
    /** The Constant SECRET_KEY. */
    public static final String SECRET_KEY = "d5eb5e9adfa63d4c0ff3c828c0f2ec64";
    
    /** The Constant HEADER_RESOURCE. */
    public static final String HEADER_RESOURCE = "MAC";
    
    /**
     * Adds the authentication.
     *
     * @param response the response
     * @param username the username
     */
    public void addAuthentication(final HttpServletResponse response, final String username) {
    	final String jwt = Jwts.builder()
                    .setSubject(username)
                    .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
                    .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                    .compact();
        response.addHeader(HEADER_RESOURCE, jwt);
    }

    /**
     * Gets the authentication.
     *
     * @param request the request
     * @return the authentication
     */
    public Authentication getAuthentication(final HttpServletRequest request) {
    	final String token = request.getHeader(HEADER_RESOURCE);
        if(token != null) {
        	final String username = Jwts.parser()
                        .setSigningKey(SECRET_KEY)
                        .parseClaimsJws(token)
                        .getBody()
                        .getSubject();
            if(username != null) {
                return new AuthenticatedUser(username);
            }
        }
        return null;
    }
}
