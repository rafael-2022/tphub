package com.dieboldnixdorf.frentecaixa.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import com.dieboldnixdorf.frentecaixa.domain.Ejmedia;
import com.dieboldnixdorf.frentecaixa.domain.StoremapDto;
import com.dieboldnixdorf.frentecaixa.domain.TrocaDevolucaoMessageType;
import com.dieboldnixdorf.frentecaixa.domain.TrocaDevolucaoPayloadType;

/**
 * The Class DadosDevolucaoServiceImpl.
 */
@Component("dadosDevolucaoService")
@Transactional (readOnly=true)
class DadosDevolucaoServiceImpl implements DadosDevolucaoService {

	/** The repository. */
	private final DadosDevolucaoRepository repository;

	/** The work list app. */
	@Autowired
	private WorklistApp workListApp;

	/** The work list. */
	@Autowired
	private WorklistService workList;
	
	/**
	 * Instantiates a new dados devolucao service impl.
	 *
	 * @param repository the repository
	 */
	public DadosDevolucaoServiceImpl(final DadosDevolucaoRepository repository) {
		this.repository = repository;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<TrocaDevolucaoMessageType> findDadosDevolucao(final DadosDevolucaoSearchCriteria criteria, final Pageable pageable) {
		final List<TrocaDevolucaoMessageType> messages = new ArrayList<TrocaDevolucaoMessageType>();
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
				final Page<Ejmedia> devolucoes = this.repository.findByCodigoLojaAndDataExtracao(Integer.valueOf(criteria.getCodigoLoja()), criteria.getDataExtracao(), pageable);
				cabecalho.setTotalPaginas(Long.valueOf(devolucoes.getTotalPages()));
				cabecalho.setTotalRegistros(devolucoes.getTotalElements());
				cabecalho.setTotalRegistrosPorPagina(Long.valueOf(pageable.getPageSize()));
				final TrocaDevolucaoMessageType message = new TrocaDevolucaoMessageType();
				message.setCabecalho(cabecalho);
				devolucoes.forEach(new Consumer<Ejmedia>() {
					@Override
					public void accept(final Ejmedia media) {
						final TrocaDevolucaoPayloadType payload = new TrocaDevolucaoPayloadType();
						if (StringUtils.isEmpty(media.getHostid())) {
							payload.setCodigoProdutoEAN(Long.valueOf(0));
						} else {
							final Matcher matcher = Pattern.compile("\\d{1,13}").matcher(media.getHostid().replaceAll("\\s+", ""));
							matcher.find();
							payload.setCodigoProdutoEAN(Long.valueOf(matcher.group()));
						}
						if (ObjectUtils.isEmpty(media.getMediaamnt())) {
							payload.setValorProduto(BigDecimal.ZERO);					
						} else {
							payload.setValorProduto(BigDecimal.valueOf(media.getMediaamnt()));
						}
						if (StringUtils.isEmpty(media.getMdesc())) {
							payload.setCodigoOperacao("");
						} else {
							final Matcher matcher = Pattern.compile("[a-zA-Z\\s+]{1,2}").matcher(media.getMdesc().replaceAll("\\s+", ""));
							matcher.find();
							final Map<String, String> mapaCodigoOperacao = new HashMap<String, String>();
							mapaCodigoOperacao.put("TC", "TC");
							mapaCodigoOperacao.put("RD", "RD");
							mapaCodigoOperacao.put("CP", "CP");
							mapaCodigoOperacao.put("AN", "AN");
							mapaCodigoOperacao.put("DO", "DO");
							if (mapaCodigoOperacao.get(matcher.group().toUpperCase()) == null) {
								payload.setCodigoOperacao("");
							} else {
								payload.setCodigoOperacao(mapaCodigoOperacao.get(matcher.group().toUpperCase()));
							}
						}
						if (ObjectUtils.isEmpty(media.getAltcurrtend())) {
							payload.setQuantidadeProduto(BigDecimal.ZERO);
						} else {
							payload.setQuantidadeProduto(BigDecimal.valueOf(media.getAltcurrtend()));
						}
						if (StringUtils.isEmpty(media.getEftdata1())) {
							payload.setRazaoOperacao(0);					
						} else {
							final Matcher matcher = Pattern.compile("\\d{1,2}").matcher(media.getEftdata1().replaceAll("\\s+", ""));
							matcher.find();
							final Map<String, String> mapaRazaoOperacao = new HashMap<String, String>();
							mapaRazaoOperacao.put("1","1");
							mapaRazaoOperacao.put("01","01");
							mapaRazaoOperacao.put("2","2");
							mapaRazaoOperacao.put("02","02");
							mapaRazaoOperacao.put("4","4");
							mapaRazaoOperacao.put("04","04");
							mapaRazaoOperacao.put("5","5");
							mapaRazaoOperacao.put("05","05");
							mapaRazaoOperacao.put("6","6");
							mapaRazaoOperacao.put("06","06");
							mapaRazaoOperacao.put("10","10");
							if (mapaRazaoOperacao.get(matcher.group()) == null) {
								payload.setRazaoOperacao(0);
							} else {
								payload.setRazaoOperacao(Integer.valueOf(mapaRazaoOperacao.get(matcher.group())));
							}
						}
						if (StringUtils.isEmpty(media.getEftdata2())) {
							payload.setTrocaComCupomFiscal("");
						} else {
							final Matcher matcher = Pattern.compile("[a-zA-Z\\s+]{3}").matcher(media.getEftdata2().replaceAll("\\s+", ""));
							matcher.find();
							final Map<String, String> mapaTrocaComCupomFiscal = new HashMap<String, String>();
							mapaTrocaComCupomFiscal.put("SEM", "N");
							mapaTrocaComCupomFiscal.put("COM", "S");
							if (mapaTrocaComCupomFiscal.get(matcher.group().toUpperCase()) == null) {
								payload.setTrocaComCupomFiscal("");
							} else {
								payload.setTrocaComCupomFiscal(mapaTrocaComCupomFiscal.get(matcher.group().toUpperCase()));
							}
						}
						if (StringUtils.isEmpty(media.getEftdata3())) {
							payload.setNumeroCupomFiscal(Long.valueOf(0));
						} else {
							if (!StringUtils.isEmpty(payload.getCodigoOperacao()) 
									&& payload.getCodigoOperacao().trim().equalsIgnoreCase("DO")) {
								final Matcher matcher = Pattern.compile("\\d{1,9}").matcher(media.getEftdata3().replaceAll("\\s+", ""));
								matcher.find();
								payload.setNumeroCupomFiscal(Long.valueOf(matcher.group()));
							} else {
								payload.setNumeroCupomFiscal(Long.valueOf(0));
							}
						}
						if (StringUtils.isEmpty(media.getEftdata4())) {
							payload.setFiguraFiscal("");
						} else {
							if (!StringUtils.isEmpty(payload.getCodigoOperacao()) 
									&& payload.getCodigoOperacao().trim().equalsIgnoreCase("DO")) {
								final Matcher matcher = Pattern.compile("[a-zA-Z\\s+]{1,2}").matcher(media.getEftdata4().replaceAll("\\s+", ""));
								matcher.find();
								payload.setFiguraFiscal(matcher.group());
							} else {
								payload.setFiguraFiscal("");
							}
						}
						final Matcher matcherCodeStoreGold = Pattern.compile("[a-zA-Z0-9]{1,3}").matcher(dto.getCodeStoreGold().replaceAll("\\s+", ""));
						matcherCodeStoreGold.find();
						payload.setSiglaLoja(matcherCodeStoreGold.group());
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
