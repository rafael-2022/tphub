package com.dieboldnixdorf.frentecaixa.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.dieboldnixdorf.frentecaixa.domain.StoremapDto;

/**
 * The Class WorklistService.
 */
@Component
public class WorklistService {
	
	@Value("#{'${storemap.url}'}")
	private String storemapUrl;

	/**
	 * Gets the store map.
	 *
	 * @param response the response
	 * @param codigoLoja the codigo loja
	 * @return the store map
	 */
	public ResponseEntity<StoremapDto> getStoreMap(final ResponseEntity<String> response, final String codigoLoja) {
		final WorklistApp workList = new WorklistApp();
		final String mac = response.getHeaders().get("MAC").get(0);
		final HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.set("MAC", mac);
		final Map<String, String> params = new HashMap<String, String>();
		params.put("codigoLoja", codigoLoja);
		final HttpEntity<String> entity = new HttpEntity<String>(headers);
		return workList.getRestTemplate().exchange(storemapUrl.concat("/storemap/store/{codigoLoja}"), HttpMethod.GET, entity, StoremapDto.class, params);
	}
	
}
