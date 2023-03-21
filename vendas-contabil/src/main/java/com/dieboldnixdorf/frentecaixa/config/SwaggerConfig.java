package com.dieboldnixdorf.frentecaixa.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * The Class SwaggerConfig.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	/**
	 * Api.
	 *
	 * @return the docket
	 */
	@Bean
	public Docket api() {
		//Adding JWT token
        final ParameterBuilder aParameterBuilder = new ParameterBuilder();
        aParameterBuilder.name("MAC")
        				.modelRef(new ModelRef("string"))
        				.parameterType("header")
        				.required(true)
        				.build();
        final List<Parameter> tokenParameter = new ArrayList<Parameter>();
        tokenParameter.add(aParameterBuilder.build());
	    return new Docket(DocumentationType.SWAGGER_2)
	        .select()
	        .apis(RequestHandlerSelectors.any())
	        .paths(PathSelectors.any())
	        .build()
	        .globalOperationParameters(tokenParameter);
	}
}
