package com.dieboldnixdorf.frentecaixa.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.dieboldnixdorf.frentecaixa.security.rfc7519.JWTAuthenticationFilter;
import com.dieboldnixdorf.frentecaixa.security.rfc7519.JWTLoginFilter;


/**
 * The Class WebSecurityConfig.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	/**
	 * {@inheritDoc}
	 */
    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.headers().cacheControl();
        http.csrf().disable() 
        .authorizeRequests()
        .antMatchers("/", 
    			"/v2/api-docs", 
    			"/health", 
    			"/configuration/ui", 
    			"/swagger-resources", 
    			"/configuration/security", 
    			"/swagger-ui.html", 
    			"/webjars/**","/swagger-resources/configuration/ui","/swagge‌​r-ui.html").permitAll()
        .antMatchers(HttpMethod.POST,"/login").permitAll()
        .anyRequest().authenticated()
        .and()
        .addFilterBefore(new JWTLoginFilter("/login", authenticationManager()), UsernamePasswordAuthenticationFilter.class)
        .addFilterBefore(new JWTAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

	/**
	 * {@inheritDoc}
	 */
    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication()
                .withUser("carrefour55")
                .password("1c5f7cf09d7ae531b0e80518b5eda6de")
                .roles("ADMIN");
    }

	/**
	 * {@inheritDoc}
	 */
    @Override
    public void configure(final WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/v2/api-docs", "/configuration/ui", "/swagger-resources", "/configuration/security", "/swagger-ui.html", "/webjars/**");
    }

}
