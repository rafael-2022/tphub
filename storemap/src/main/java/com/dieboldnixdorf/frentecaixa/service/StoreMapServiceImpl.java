package com.dieboldnixdorf.frentecaixa.service;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import com.dieboldnixdorf.frentecaixa.domain.Storemap;
import com.dieboldnixdorf.frentecaixa.domain.StoremapDto;

/**
 * The Class StoreMapServiceImpl.
 */
@Component("storeMapService")
@Transactional (readOnly=true)
class StoreMapServiceImpl implements StoreMapService {

	/** The repository. */
	private final StoreMapRepository repository;

	/**
	 * Instantiates a new store map service impl.
	 *
	 * @param repository the repository
	 */
	public StoreMapServiceImpl(final StoreMapRepository repository) {
		this.repository = repository;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public StoremapDto findStoreMapByCodigoLoja(final StoreMapSearchCriteria criteria) {
		final Storemap storemap = repository.findByCodigoLoja(Integer.valueOf(criteria.getCodigoLoja()));
		return preencherStoremapDto(storemap);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public StoremapDto findStoreMapByLoja(final String loja) {
		final Storemap storemap = repository.findByLoja(loja);
		return preencherStoremapDto(storemap);
	}

	/**
	 * Preencher storemap dto.
	 *
	 * @param storemap the storemap
	 * @return the storemap dto
	 */
	protected StoremapDto preencherStoremapDto(final Storemap storemap) {
		final StoremapDto dto = new StoremapDto();
		if (!ObjectUtils.isEmpty(storemap)) {
			if (StringUtils.isEmpty(storemap.getCode_store_gold())) {
				dto.setCodeStoreGold("");
			} else {
				dto.setCodeStoreGold(storemap.getCode_store_gold().trim());
			}
			if (StringUtils.isEmpty(storemap.getId_store_gold())) {
				dto.setIdStoreGold(0);
			} else {
				dto.setIdStoreGold(Integer.valueOf(storemap.getId_store_gold().trim()));
			}
			if (StringUtils.isEmpty(storemap.getStore_ip_tplinux())) {
				dto.setStoreIpTPLinux("");
			} else {
				dto.setStoreIpTPLinux(storemap.getStore_ip_tplinux().trim());
			}
		}
		return dto;
	}

}
