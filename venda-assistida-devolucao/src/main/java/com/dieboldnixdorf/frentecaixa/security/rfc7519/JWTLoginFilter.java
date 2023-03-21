package com.dieboldnixdorf.frentecaixa.security.rfc7519;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * The Class JWTLoginFilter.
 */
public class JWTLoginFilter extends AbstractAuthenticationProcessingFilter{

    /** The token authentication service. */
    private TokenAuthenticationService tokenAuthenticationService = new TokenAuthenticationService();

    /**
     * Instantiates a new JWT login filter.
     *
     * @param url the url
     * @param authManager the auth manager
     */
    public JWTLoginFilter(final String url, final AuthenticationManager authManager) {
        super(new AntPathRequestMatcher(url));
        setAuthenticationManager(authManager);
    }

	/**
	 * {@inheritDoc}
	 */
    @Override
    public Authentication attemptAuthentication(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse)
            throws AuthenticationException, IOException, ServletException {
    	final AccountCredentials credentials = new ObjectMapper().readValue(httpServletRequest.getInputStream(),AccountCredentials.class);
    	final UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(credentials.getUsername(), credentials.getPassword());
        return getAuthenticationManager().authenticate(token);
    }

	/**
	 * {@inheritDoc}
	 */
    @Override
    protected void successfulAuthentication(final HttpServletRequest request, final HttpServletResponse response, final FilterChain chain, final Authentication auth)
            throws IOException, ServletException {
        tokenAuthenticationService.addAuthentication(response, auth.getName());
    }
}
