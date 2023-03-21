package com.dieboldnixdorf.frentecaixa.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import com.dieboldnixdorf.frentecaixa.domain.CabecalhoType;
import com.dieboldnixdorf.frentecaixa.domain.CodigoLojaType;
import com.dieboldnixdorf.frentecaixa.domain.DataExtracaoType;
import com.dieboldnixdorf.frentecaixa.domain.Ejitem;
import com.dieboldnixdorf.frentecaixa.domain.TotalPisCofinsPDVMessageType;
import com.dieboldnixdorf.frentecaixa.domain.TotalPisCofinsPDVPayloadType;

/**
 * The Class TotalPisCofinsPdvServiceImpl.
 */
@Component("totalPisCofinsPdvService")
@Transactional (readOnly=true)
class TotalPisCofinsPdvServiceImpl implements TotalPisCofinsPdvService {

	/** The repository. */
	private final TotalPisCofinsPdvRepository repository;

	/**
	 * Instantiates a new total Pis/Cofins PDV service impl.
	 *
	 * @param repository the repository
	 */
	public TotalPisCofinsPdvServiceImpl(final TotalPisCofinsPdvRepository repository) {
		this.repository = repository;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<TotalPisCofinsPDVMessageType> findTotalPisCofinsPdv(final TotalPisCofinsPdvSearchCriteria criteria, final Pageable pageable) {
		final List<TotalPisCofinsPDVMessageType> messages = new ArrayList<TotalPisCofinsPDVMessageType>();
		final CodigoLojaType codigoLoja = new CodigoLojaType();
		codigoLoja.setCodigoLoja(criteria.getCodigoLoja());
		final DataExtracaoType dataExtrtacao = new DataExtracaoType();
		final GregorianCalendar gregorianCalendar = new GregorianCalendar();
		gregorianCalendar.setTime(criteria.getDataHoraExtracao(criteria.getDataExtracao()));
		try {
			final XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
			dataExtrtacao.setDataExtracao(xmlGregorianCalendar);
		} catch (final DatatypeConfigurationException dtcex) {
			dtcex.printStackTrace();
		}		
		final CabecalhoType cabecalho = new CabecalhoType();
		cabecalho.setCodigoLoja(codigoLoja);
		cabecalho.setDataExtracao(dataExtrtacao);
		final Page<Ejitem> aliquotas = this.repository.findByCodigoLojaAndDataExtracao(Integer.valueOf(criteria.getCodigoLoja()), criteria.getDataExtracao(criteria.getDataExtracao(criteria.getDataExtracao())), pageable);
		cabecalho.setTotalPaginas(Long.valueOf(aliquotas.getTotalPages()));
		cabecalho.setTotalRegistros(aliquotas.getTotalElements());
		cabecalho.setTotalRegistrosPorPagina(Long.valueOf(pageable.getPageSize()));
		final TotalPisCofinsPDVMessageType message = new TotalPisCofinsPDVMessageType();
		message.setCabecalho(cabecalho);
		aliquotas.forEach(new Consumer<Ejitem>() {
			@Override
			public void accept(final Ejitem item) {
				
				final TotalPisCofinsPDVPayloadType payload = new TotalPisCofinsPDVPayloadType();
				if (ObjectUtils.isEmpty(item.getFiscalPK().getTermnmbr())) {
					payload.setNumeroECF(0);
				} else {
					final Matcher matcher = Pattern.compile("\\d{1,3}").matcher(String.valueOf(item.getFiscalPK().getTermnmbr()));
					matcher.find();
					payload.setNumeroECF(Integer.valueOf(matcher.group()));
				}
				if (ObjectUtils.isEmpty(item.getMrpprice4())) {
					payload.setValorTotalPIS(BigDecimal.ZERO);
				} else {
					final String valorTotalPIS = item.getMrpprice4().toString().replaceAll("\\W", "");
					if (StringUtils.isEmpty(valorTotalPIS)) {
						payload.setValorTotalPIS(BigDecimal.ZERO);
					} else {
						payload.setValorTotalPIS(new BigDecimal(valorTotalPIS));
					}
				}
				if (ObjectUtils.isEmpty(item.getMrpprice5())) {
					payload.setValorTotalCOFINS(BigDecimal.ZERO);
				} else {
					final String valorTotalCOFINS = item.getMrpprice5().toString().replaceAll("\\W", "");
					if (StringUtils.isEmpty(valorTotalCOFINS)) {
						payload.setValorTotalCOFINS(BigDecimal.ZERO);
					} else {
						payload.setValorTotalCOFINS(new BigDecimal(valorTotalCOFINS));
					}
				}
				message.getPisconfinsECF().add(payload);
			}
		});
		if (!CollectionUtils.isEmpty(message.getPisconfinsECF())) {
			messages.add(message);
		}
		return messages;
	}

}
