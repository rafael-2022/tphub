package com.dieboldnixdorf.frentecaixa.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
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
import com.dieboldnixdorf.frentecaixa.domain.Ejitem;
import com.dieboldnixdorf.frentecaixa.domain.OperacoesPDVBalcaoMessageType;
import com.dieboldnixdorf.frentecaixa.domain.OperacoesPDVBalcaoPayloadType;
import com.dieboldnixdorf.frentecaixa.domain.StoremapDto;

/**
 * The Class MovimentacoesPdvBalcaoServiceImpl.
 */
@Component("movimentacoesPdvBalcaoService")
@Transactional (readOnly=true)
class MovimentacoesPdvBalcaoServiceImpl implements MovimentacoesPdvBalcaoService {

	/** The repository. */
	private final MovimentacoesPdvBalcaoRepository repository;

	/** The work list app. */
	@Autowired
	private WorklistApp workListApp;

	/** The work list. */
	@Autowired
	private WorklistService workList;

	/**
	 * Instantiates a new movimentacoes pdv balcao service impl.
	 *
	 * @param repository the repository
	 */
	public MovimentacoesPdvBalcaoServiceImpl(final MovimentacoesPdvBalcaoRepository repository) {
		this.repository = repository;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<OperacoesPDVBalcaoMessageType> findMovimentacoesPdvBalcao(final MovimentacoesPdvBalcaoSearchCriteria criteria, final Pageable pageable) {
		final List<OperacoesPDVBalcaoMessageType> messages = new ArrayList<OperacoesPDVBalcaoMessageType>();
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
				cabecalho.setTotalRegistrosPorPagina(Long.valueOf(pageable.getPageSize()));
				final Page<Ejitem> movimentacoes = this.repository.findMovimentacoesPdvBalcao(Integer.valueOf(criteria.getCodigoLoja()), criteria.getDataExtracao(criteria.getDataExtracao()), pageable);
				cabecalho.setTotalPaginas(Long.valueOf(movimentacoes.getTotalPages()));
				cabecalho.setTotalRegistros(movimentacoes.getTotalElements());
				final OperacoesPDVBalcaoMessageType message = new OperacoesPDVBalcaoMessageType();
				message.setCabecalho(cabecalho);
				movimentacoes.forEach(new Consumer<Ejitem>() {
					@Override
					public void accept(final Ejitem item) {
						final OperacoesPDVBalcaoPayloadType payload = new OperacoesPDVBalcaoPayloadType();
						final Matcher matcherCodeStoreGold = Pattern.compile("[a-zA-Z0-9]{1,3}").matcher(dto.getCodeStoreGold().replaceAll("\\s+", ""));
						matcherCodeStoreGold.find();
						payload.setSiglaLoja(matcherCodeStoreGold.group());
						if (StringUtils.isEmpty(item.getMerchfmly())) {
							//payload.setNumeroPDV(Long.valueOf(0));
							payload.setNumeroPDVBalcao("");
						} else {
							final String termnmbr = item.getMerchfmly().replaceAll("\\s+", "");
							if ("BC001".equalsIgnoreCase(termnmbr)) {
								payload.setNumeroPDVBalcao(termnmbr);
								//payload.setNumeroPDV(Long.valueOf(0));
                                                                
							} else {
								//payload.setNumeroPDV(Long.valueOf(termnmbr));
								payload.setNumeroPDVBalcao(termnmbr);
							}
						}
						final Calendar dataMovimentacao  = Calendar.getInstance();
						dataMovimentacao.setTime(item.getDatahora());
						payload.setDataMovimentacao(dataMovimentacao);
						final LocalDateTime localtDateAndTime = LocalDateTime.now();
						final ZonedDateTime currentDateTime  = ZonedDateTime.of(localtDateAndTime, ZoneId.systemDefault());
						final Calendar dataAtual = Calendar.getInstance();
						dataAtual.set(Calendar.DAY_OF_MONTH, currentDateTime.getDayOfMonth());
						dataAtual.set(Calendar.MONTH, currentDateTime.getMonth().getValue());
						dataAtual.set(Calendar.YEAR, currentDateTime.getYear());
						dataAtual.set(Calendar.HOUR_OF_DAY, currentDateTime.getHour());
						dataAtual.set(Calendar.MINUTE, currentDateTime.getMinute());
						dataAtual.set(Calendar.SECOND, currentDateTime.getSecond());
					    payload.setDataAtual(dataAtual);
					    if (StringUtils.isEmpty(item.getMerchfmly())) {
					    	payload.setDrt("");
					    } else {
					    	final String termnmbr = item.getMerchfmly().replaceAll("\\s+", "");
					    	if (!"BC001".equalsIgnoreCase(termnmbr)) {
								final Matcher matcher = Pattern.compile("\\d{1,11}").matcher(String.valueOf(item.getCshrnmbr()));
								matcher.find();
								final Long drt = Long.valueOf(matcher.group());
								payload.setDrt(String.valueOf(drt));
					    	} else {
					    		payload.setDrt("");
					    	}
					    }
						if (ObjectUtils.isEmpty(item.getFiscalizador())) {
							payload.setDrtFiscalizador(Long.valueOf(0));
						} else {
							final Matcher matcher = Pattern.compile("\\d{1,11}").matcher(String.valueOf(item.getFiscalizador()));
							matcher.find();
							final Long drt = Long.valueOf(matcher.group());
							payload.setDrtFiscalizador(drt);
						}
						if (ObjectUtils.isEmpty(item.getMovimentacaoPK().getTransnmbr())) {
							//payload.setNumeroTransacao(Long.valueOf(0));
							payload.setNumeroTransacao("");
						} else {
							final String termnmbr = item.getMerchfmly().replaceAll("\\s+", "");
							if ("BC001".equalsIgnoreCase(termnmbr) || "BC01".equalsIgnoreCase(termnmbr)  ) {
								payload.setNumeroTransacao(item.getMatricula());
							//	payload.setNumeroTransacao(Long.valueOf(0));
                                                                
							} else {
							//	payload.setNumeroTransacao(Long.valueOf(item.getMovimentacaoPK().getTransnmbr()));
								payload.setNumeroTransacao(String.valueOf(item.getMovimentacaoPK().getTransnmbr()));
							}
						}
						if (StringUtils.isEmpty(item.getDeptnmbr())) {
							payload.setDepartamento(0);					
						} else {
							final Matcher matcher = Pattern.compile("\\d{1,3}").matcher(String.valueOf(item.getDeptnmbr().replaceAll("\\s+", "")));
							matcher.find();
							payload.setDepartamento(Integer.valueOf(matcher.group()));
						}
						if (ObjectUtils.isEmpty(item.getMovimentacaoPK().getPlunmbr())) {
							payload.setProduto(Long.valueOf(0));				
						} else {
							final Matcher matcher = Pattern.compile("\\d{1,13}").matcher(String.valueOf(item.getMovimentacaoPK().getPlunmbr().replaceAll("\\s+", "")));
							matcher.find();
							payload.setProduto(Long.valueOf(matcher.group()));
						}
						if (StringUtils.isEmpty(item.getPludesc())) {
							payload.setDescricaoProduto("");			
						} else {
							final Matcher matcher = Pattern.compile("[a-zA-Z0-9\\s+\\p{IsLatin}+]{1,20}").matcher(item.getPludesc());
							matcher.find();
							payload.setDescricaoProduto(matcher.group());
						}
						if (ObjectUtils.isEmpty(item.getQty1())) {
							payload.setQuantidadeProduto(BigDecimal.ZERO);
						} else {
							payload.setQuantidadeProduto(BigDecimal.valueOf(item.getQty1()));
						}
						if (ObjectUtils.isEmpty(item.getPrice1())) {
							payload.setValor(BigDecimal.ZERO);
						} else {
							payload.setValor(BigDecimal.valueOf(item.getPrice1()));
						}
						if (StringUtils.isEmpty(item.getPrint1text())) {
							payload.setTipoRetorno("");			
						} else {
							final Matcher matcher = Pattern.compile("[a-zA-Z]{1,4}").matcher(item.getPrint1text().replaceAll("\\s+", ""));
							matcher.find();
							final Map<String, String> mapaTipoRetorno = new HashMap<String, String>();
							mapaTipoRetorno.put("CP", "CP");
							mapaTipoRetorno.put("DV", "DV");
							mapaTipoRetorno.put("CANC", "CANC");
							mapaTipoRetorno.put("TC", "TC");
							mapaTipoRetorno.put("NA", "NA");
                                                        //mapaTipoRetorno.put("AN", "AN");
							mapaTipoRetorno.put("BG", "BG");
							mapaTipoRetorno.put("RD", "RD");
							mapaTipoRetorno.put("CPC", "CPC");
							mapaTipoRetorno.put("DIV", "DIV");
							if (mapaTipoRetorno.get(matcher.group()) == null) {
								payload.setTipoRetorno("");
							} else {
								payload.setTipoRetorno(mapaTipoRetorno.get(matcher.group()));
							}
						}
						if (StringUtils.isEmpty(item.getPrint2text())) {
							payload.setDescritivoRetorno("");			
						} else {
							final Matcher matcher = Pattern.compile("[a-zA-Z0-9\\s+\\p{IsLatin}+]{1,20}").matcher(item.getPrint2text());
							matcher.find();
							payload.setDescritivoRetorno(matcher.group());
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