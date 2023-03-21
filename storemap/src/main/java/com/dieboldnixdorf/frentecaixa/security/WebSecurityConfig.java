package com.dieboldnixdorf.frentecaixa.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
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
        .antMatchers("/").permitAll()
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
                .withUser("nohup")
                .password("e53ae256943bc12b36e9da0ad67337d291016a3898614e5de1c26e0a53cfe8e9")
                .roles("ADMIN");
    }

}
