package com.dieboldnixdorf.frentecaixa.service;

import java.math.BigDecimal;
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
import com.dieboldnixdorf.frentecaixa.domain.DiariasConsolidadasMessageType;
import com.dieboldnixdorf.frentecaixa.domain.DiariasConsolidadasPayloadType;
import com.dieboldnixdorf.frentecaixa.domain.Ejitem;
import com.dieboldnixdorf.frentecaixa.domain.StoremapDto;

/**
 * The Class DiariasConsolidadasServiceImpl.
 */
@Component("diariasConsolidadasService")
@Transactional (readOnly=true)
class DiariasConsolidadasServiceImpl implements DiariasConsolidadasService {

	/** The repository. */
	private final DiariasConsolidadasRepository repository;

	/** The work list app. */
	@Autowired
	private WorklistApp workListApp;

	/** The work list. */
	@Autowired
	private WorklistService workList;
	
	/**
	 * Instantiates a new diarias consolidadas service impl.
	 *
	 * @param repository the repository
	 */
	public DiariasConsolidadasServiceImpl(final DiariasConsolidadasRepository repository) {
		this.repository = repository;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<DiariasConsolidadasMessageType> findDiariasConsolidadas(final DiariasConsolidadasSearchCriteria criteria, final Pageable pageable) {
		final List<DiariasConsolidadasMessageType> messages = new ArrayList<DiariasConsolidadasMessageType>();
		final ResponseEntity<String> response = workListApp.performAuthorized();
		if (response.getStatusCode() == HttpStatus.OK) {
			final StoremapDto dto = workList.getStoreMap(response, criteria.getCodigoLoja()).getBody();
			if (!ObjectUtils.isEmpty(dto)
					&& !StringUtils.isEmpty(dto.getStoreIpTPLinux())) {
				final Calendar dataEsquemaVendas  = Calendar.getInstance();
				dataEsquemaVendas.setTime(criteria.getDataExtracao());
				final CodigoLojaType codigoLoja = new CodigoLojaType();
				codigoLoja.setCodigoLoja(criteria.getCodigoLoja());
				final DataExtracaoType dataExtrtacao = new DataExtracaoType();
				final GregorianCalendar gregorianCalendar = new GregorianCalendar();
				gregorianCalendar.setTime(criteria.getDataExtracao());
				try {
					final XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
					dataExtrtacao.setDataExtracao(xmlGregorianCalendar);
				} catch (final DatatypeConfigurationException dtcex) {
					dtcex.printStackTrace();
				}		
				final CabecalhoType cabecalho = new CabecalhoType();
				cabecalho.setCodigoLoja(codigoLoja);
				cabecalho.setDataExtracao(dataExtrtacao);
				System.out.println("INICIO EXECUCAO >> fnc_vendaconsolidada");
				final Page<Ejitem> diarias = this.repository.findByCodigoLojaAndDataExtracao(Integer.valueOf(criteria.getCodigoLoja()), criteria.getDataExtracao(criteria.getDataExtracao()), pageable);
				System.out.println("FIM EXECUCAO >> fnc_vendaconsolidada >> " + diarias.getSize());
				
				cabecalho.setTotalPaginas(Long.valueOf(diarias.getTotalPages()));
				cabecalho.setTotalRegistros(diarias.getTotalElements());
				cabecalho.setTotalRegistrosPorPagina(Long.valueOf(pageable.getPageSize()));
				final DiariasConsolidadasMessageType message = new DiariasConsolidadasMessageType();
				message.setCabecalho(cabecalho);
				
				System.out.println("INICIO EXECUCAO >> LACO");
				diarias.forEach(new Consumer<Ejitem>() {
					@Override
					public void accept(final Ejitem item) {
						if (item.getAmtsold().intValue() != 0) {
							final DiariasConsolidadasPayloadType payload = new DiariasConsolidadasPayloadType();
							if (StringUtils.isEmpty(item.getVdaPK().getPlunmbr())) {
								payload.setCodigoCarrefourProduto(Long.valueOf(0));
							} else {
								final Matcher matcher = Pattern.compile("\\d{1,13}").matcher(item.getVdaPK().getPlunmbr().replaceAll("\\s+", ""));
								matcher.find();
								payload.setCodigoCarrefourProduto(Long.valueOf(matcher.group()));
							}
							if (ObjectUtils.isEmpty(item.getVdaPK().getTermnmbr())) {
								payload.setNumeroPDV(Long.valueOf(0));
							} else {
								payload.setNumeroPDV(Long.valueOf(item.getVdaPK().getTermnmbr()));
							}
							if (ObjectUtils.isEmpty(item.getQtysold())) {
								payload.setQuantidadeTotalVendida(BigDecimal.ZERO);
							} else {
								payload.setQuantidadeTotalVendida(BigDecimal.valueOf(item.getQtysold()));
							}
							if (ObjectUtils.isEmpty(item.getAmtsold())) {
								payload.setValorTotalVendido(BigDecimal.ZERO);
							} else {
								payload.setValorTotalVendido(BigDecimal.valueOf(item.getAmtsold()));
							}
							if (ObjectUtils.isEmpty(item.getQtymkdn())) {
								payload.setQuantidadeTotalVendidaDesconto(BigDecimal.ZERO);
							} else {
								payload.setQuantidadeTotalVendidaDesconto(BigDecimal.valueOf(item.getQtymkdn()));
							}
							if (ObjectUtils.isEmpty(item.getAmtmkdn())) {
								payload.setValorTotalVendidoDesconto(BigDecimal.ZERO);
							} else {
								payload.setValorTotalVendidoDesconto(BigDecimal.valueOf(item.getAmtmkdn()));
							}
							final Matcher matcherCodeStoreGold = Pattern.compile("[a-zA-Z0-9]{1,3}").matcher(dto.getCodeStoreGold().replaceAll("\\s+", ""));
							matcherCodeStoreGold.find();
							payload.setSiglaLoja(matcherCodeStoreGold.group());
							message.getPayload().add(payload);
						}
					}
				});
				
				System.out.println("FIM EXECUCAO >> LACO");
				if (!CollectionUtils.isEmpty(message.getPayload())) {
					messages.add(message);
				}
			}
		}
		return messages;
	}

}
