package com.dieboldnixdorf.frentecaixa.service;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import com.dieboldnixdorf.frentecaixa.domain.CabecalhoType;
import com.dieboldnixdorf.frentecaixa.domain.CodigoLojaType;
import com.dieboldnixdorf.frentecaixa.domain.DataExtracaoType;
import com.dieboldnixdorf.frentecaixa.domain.Ejuserstruct1;
import com.dieboldnixdorf.frentecaixa.domain.StoremapDto;
import com.dieboldnixdorf.frentecaixa.domain.TEFPromocaoMessageType;
import com.dieboldnixdorf.frentecaixa.domain.TEFPromocaoPayloadType;

/**
 * The Class DescontosTefPromocaoServiceImpl.
 */
@Component("descontosTefPromocaoService")
@Transactional (readOnly=true)
class DescontosTefPromocaoServiceImpl implements DescontosTefPromocaoService {

	/** The repository. */
	private final DescontosTefPromocaoRepository repository;

	/** The work list app. */
	@Autowired
	private WorklistApp workListApp;

	/** The work list. */
	@Autowired
	private WorklistService workList;
	
	/**
	 * Instantiates a new descontos tef promocao service impl.
	 *
	 * @param repository the repository
	 */
	public DescontosTefPromocaoServiceImpl(final DescontosTefPromocaoRepository repository) {
		this.repository = repository;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<TEFPromocaoMessageType> findDescontosTefPromocao(final DescontosTefPromocaoSearchCriteria criteria, final Pageable pageable) {
		final List<TEFPromocaoMessageType> messages = new ArrayList<TEFPromocaoMessageType>();
		final ResponseEntity<String> response = workListApp.performAuthorized();
		if (response.getStatusCode() == HttpStatus.OK) {
			final StoremapDto dto = workList.getStoreMap(response, criteria.getCodigoLoja()).getBody();
			if (!ObjectUtils.isEmpty(dto)
					&& !StringUtils.isEmpty(dto.getStoreIpTPLinux())) {
				final Calendar dataEsquemaVendas  = Calendar.getInstance();
				dataEsquemaVendas.setTime(criteria.getDataHoraExtracao(criteria.getDataExtracao()));
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
				final DateTimeFormatter criteriaFormatter = new DateTimeFormatterBuilder().appendPattern("dd/MM/yy").parseStrict().toFormatter();
				final String dataExstracao = criteria.getDataExtracao().format(criteriaFormatter);
				final Page<Ejuserstruct1> descontos = this.repository.findByCodigoLojaAndDataExtracao(Integer.valueOf(criteria.getCodigoLoja()), dataExstracao, pageable);
				cabecalho.setTotalPaginas(Long.valueOf(descontos.getTotalPages()));
				cabecalho.setTotalRegistros(descontos.getTotalElements());
				cabecalho.setTotalRegistrosPorPagina(Long.valueOf(pageable.getPageSize()));
				final TEFPromocaoMessageType message = new TEFPromocaoMessageType();
				message.setCabecalho(cabecalho);
				descontos.forEach(new Consumer<Ejuserstruct1>() {
					@Override
					public void accept(final Ejuserstruct1 item) {
						final TEFPromocaoPayloadType payload = new TEFPromocaoPayloadType();
						final Matcher matcherCodeStoreGold = Pattern.compile("[a-zA-Z0-9]{1,3}").matcher(dto.getCodeStoreGold().replaceAll("\\s+", ""));
						matcherCodeStoreGold.find();
						payload.setSiglaLoja(matcherCodeStoreGold.group());
						final Calendar dataMovimentacao  = Calendar.getInstance();
						dataMovimentacao.setTime(item.getDatahora());
						payload.setDataMovimento(dataMovimentacao);
						if (ObjectUtils.isEmpty(item.getContabilPK().getTermnmbr())) {
							payload.setNumeroPDV(0);
						} else {
							final Matcher matcher = Pattern.compile("\\d{1,3}").matcher(String.valueOf(item.getContabilPK().getTermnmbr()));
							matcher.find();
							payload.setNumeroPDV(Integer.valueOf(matcher.group()));
						}
						if (ObjectUtils.isEmpty(item.getContabilPK().getTransnmbr())) {
							payload.setNumeroTransacao(0);
						} else {
							final Matcher matcher = Pattern.compile("\\d{1,10}").matcher(String.valueOf(item.getContabilPK().getTransnmbr()));
							matcher.find();
							payload.setNumeroTransacao(Long.valueOf(matcher.group()));
						}
						if (ObjectUtils.isEmpty(item.getCshrnmbr())) {
							payload.setRecepcionistaDRT(Long.valueOf(0));
						} else {
							final Matcher matcher = Pattern.compile("\\d{1,11}").matcher(String.valueOf(item.getCshrnmbr()));
							matcher.find();
							payload.setRecepcionistaDRT(Long.valueOf(matcher.group()));
						}
						if (StringUtils.isEmpty(item.getContabilPK().getSznumber1())) {
							payload.setNumeroSetor(0);
						} else {
							final Matcher matcher = Pattern.compile("\\d{1,3}").matcher(item.getContabilPK().getSznumber1().replaceAll("\\s+", ""));
							matcher.find();
							payload.setNumeroSetor(Integer.valueOf(matcher.group()));
						}
						if (StringUtils.isEmpty(item.getSzuserext())) {
							payload.setNomeSetor("");
						} else {
							final Matcher matcher = Pattern.compile("[a-zA-Z0-9\\.\\-\\s+\\p{IsLatin}+]{1,20}").matcher(item.getSzuserext());
							matcher.find();
							payload.setNomeSetor(matcher.group());
						}
						if (ObjectUtils.isEmpty(item.getUlfield2())) {
							payload.setValorTotalTEFPromocaoSetor(BigDecimal.ZERO);
						} else {
							final String ulfield2 = item.getUlfield2().toString().replaceAll("\\W", "");
							if (StringUtils.isEmpty(ulfield2)) {
								payload.setValorTotalTEFPromocaoSetor(BigDecimal.ZERO);
							} else {
								payload.setValorTotalTEFPromocaoSetor(new BigDecimal(ulfield2));
							}
						}
						if (StringUtils.isEmpty(item.getSznumber2())) {
							payload.setTipoDesconto("");
						} else {
							payload.setTipoDesconto(item.getSznumber2());
						}
						message.getPayload().add(payload);
					}
				});
				if (!CollectionUtils.isEmpty(message.getPayload())) {
					messages.add(message);
				}
			}
		}
		return messages;
	}

}
