package com.dieboldnixdorf.frentecaixa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Metered;
import com.codahale.metrics.annotation.Timed;
import com.dieboldnixdorf.frentecaixa.domain.StoremapDto;
import com.dieboldnixdorf.frentecaixa.service.StoreMapSearchCriteria;
import com.dieboldnixdorf.frentecaixa.service.StoreMapService;
import com.ryantenney.metrics.annotation.Counted;

/**
 * The Class StoreMapWebController.
 */
@RestController
@RequestMapping("/store")
@ExposesResourceFor(StoremapDto.class)
public class StoreMapWebController {
	
	/** The store map service. */
	@Autowired
	private StoreMapService storeMapService;

	/**
	 * Gets the storemap by codigo loja.
	 *
	 * @param codigoLoja the codigo loja
	 * @return the storemap by codigo loja
	 */
	@Timed(name = "storeViewTimer", absolute=true)
	@Metered(name = "storeViewMeter", absolute=true)
	@Counted(name = "storeViewCount", monotonic=true)
	@GetMapping(path="/{codigoLoja}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Transactional(readOnly = true)
	HttpEntity<StoremapDto> getStoreMapByCodigoLoja(final @PathVariable("codigoLoja") String codigoLoja) {
		final StoreMapSearchCriteria criteria = new StoreMapSearchCriteria(codigoLoja);
		final StoremapDto dto = this.storeMapService.findStoreMapByCodigoLoja(criteria);
		return new ResponseEntity<StoremapDto>(dto, HttpStatus.OK);
	}

	/**
	 * Gets the storemap by loja.
	 *
	 * @param loja the loja
	 * @return the storemap by loja
	 */
	@Timed(name = "storeBdatesViewTimer", absolute=true)
	@Metered(name = "storeBdatesViewMeter", absolute=true)
	@Counted(name = "storeBdatesViewCount", monotonic=true)
	@GetMapping(path="/bdates/{loja}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Transactional(readOnly = true)
	HttpEntity<StoremapDto> getStoreMapByLoja(final @PathVariable("loja") String loja) {
		final StoremapDto dto = this.storeMapService.findStoreMapByLoja(loja);
		return new ResponseEntity<StoremapDto>(dto, HttpStatus.OK);
	}

}
