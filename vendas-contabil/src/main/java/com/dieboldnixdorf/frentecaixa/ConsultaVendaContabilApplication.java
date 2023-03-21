package com.dieboldnixdorf.frentecaixa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * The Class ConsultaVendaContabilApplication.
 */
@SpringBootApplication
@EnableJpaRepositories(basePackages = {
		  "com.dieboldnixdorf.frentecaixa.service"
		  })
@EnableAutoConfiguration
@ConfigurationProperties 
public class ConsultaVendaContabilApplication extends SpringBootServletInitializer {

	/**
	 * {@inheritDoc}
	 */
	@Override
    protected SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
		setRegisterErrorPageFilter(false);
        return application.sources(ConsultaVendaContabilApplication.class);
    }

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws Exception the exception
	 */
	public static void main(final String[] args) throws Exception {
		SpringApplication.run(ConsultaVendaContabilApplication.class, args);
	}

}
