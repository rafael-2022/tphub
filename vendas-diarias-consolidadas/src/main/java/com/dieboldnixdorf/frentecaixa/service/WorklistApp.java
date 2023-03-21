package com.dieboldnixdorf.frentecaixa.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * The Class WorklistApp.
 */
@Component
public class WorklistApp {
	
	@Value("#{'${storemap.url}'}")
	private String storemapUrl;

	/**
	 * Perform authorized.
	 *
	 * @return the response entity
	 */
	public ResponseEntity<String> performAuthorized() {
		final RestTemplate restTemplate = this.getRestTemplate();
		final String requestAuthJson = "{\"username\":\"nohup\",\"password\":\"e53ae256943bc12b36e9da0ad67337d291016a3898614e5de1c26e0a53cfe8e9\"}";
		final HttpHeaders authHeaders = new HttpHeaders();
		authHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		final HttpEntity<String> authEntity = new HttpEntity<String>(requestAuthJson, authHeaders);
		return restTemplate.postForEntity(storemapUrl.concat("/storemap/login"), authEntity, String.class);
	}
	
	/**
	 * Gets the rest template.
	 *
	 * @return the rest template
	 */
	public RestTemplate getRestTemplate() {
		final List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
		messageConverters.add(new FormHttpMessageConverter());
		messageConverters.add(new StringHttpMessageConverter());
		messageConverters.add(customJackson2HttpMessageConverter());
		return new RestTemplate(messageConverters);
	}

	/**
	 * Custom jackson 2 http message converter.
	 *
	 * @return the mapping jackson 2 http message converter
	 */
	private MappingJackson2HttpMessageConverter customJackson2HttpMessageConverter() {
		final MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
		final ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		jsonConverter.setObjectMapper(objectMapper);
		return jsonConverter;
	}

}
