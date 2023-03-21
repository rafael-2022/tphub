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
import com.dieboldnixdorf.frentecaixa.domain.Ejuserstruct1;
import com.dieboldnixdorf.frentecaixa.domain.SangriaPDVMessageType;
import com.dieboldnixdorf.frentecaixa.domain.SangriaPDVPayloadType;
import com.dieboldnixdorf.frentecaixa.domain.StoremapDto;
import com.dieboldnixdorf.frentecaixa.domain.TipoFormaPagamentoType;
import com.dieboldnixdorf.frentecaixa.domain.TipoFormasPagamentosType;

/**
 * The Class MovimentacoesSangriaPdvServiceImpl.
 */
@Component("movimentacoesSangriaPdvService")
@Transactional (readOnly=true)
class MovimentacoesSangriaPdvServiceImpl implements MovimentacoesSangriaPdvService {

	/** The repository. */
	private final MovimentacoesSangriaPdvRepository repository;

	/** The work list app. */
	@Autowired
	private WorklistApp workListApp;

	/** The work list. */
	@Autowired
	private WorklistService workList;

	/**
	 * Instantiates a new movimentacoes sangria pdv service impl.
	 *
	 * @param repository the repository
	 */
	public MovimentacoesSangriaPdvServiceImpl(final MovimentacoesSangriaPdvRepository repository) {
		this.repository = repository;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<SangriaPDVMessageType> findMovimentacoesSangriaPdv(final MovimentacoesSangriaPdvSearchCriteria criteria, final Pageable pageable) {
		final List<SangriaPDVMessageType> messages = new ArrayList<SangriaPDVMessageType>();
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
				final Page<Ejuserstruct1> movimentacoes = this.repository.findByCodigoLojaAndDataExtracao(Integer.valueOf(criteria.getCodigoLoja()), criteria.getDataExtracao(criteria.getDataExtracao(criteria.getDataExtracao())), pageable);
				cabecalho.setTotalPaginas(Long.valueOf(movimentacoes.getTotalPages()));
				cabecalho.setTotalRegistros(movimentacoes.getTotalElements());
				cabecalho.setTotalRegistrosPorPagina(Long.valueOf(pageable.getPageSize()));
				final SangriaPDVMessageType message = new SangriaPDVMessageType();
				message.setCabecalho(cabecalho);
				movimentacoes.forEach(new Consumer<Ejuserstruct1>() {
					@Override
					public void accept(final Ejuserstruct1 item) {
						final SangriaPDVPayloadType payload = new SangriaPDVPayloadType();
						if (ObjectUtils.isEmpty(item.getTermnmbr())) {
							payload.setNumeroPDV(Long.valueOf(0));
						} else {
							final Matcher matcher = Pattern.compile("\\d{1,3}").matcher(String.valueOf(item.getTermnmbr()));
							matcher.find();
							payload.setNumeroPDV(Long.valueOf(matcher.group()));
						}
						if (ObjectUtils.isEmpty(item.getCshrnmbr())) {
							payload.setDrt(Long.valueOf(0));
						} else {
							final Matcher matcher = Pattern.compile("\\d{1,11}").matcher(String.valueOf(item.getCshrnmbr()));
							matcher.find();
							payload.setDrt(Long.valueOf(matcher.group()));
						}
						final Calendar dataSangria  = Calendar.getInstance();
						dataSangria.setTime(item.getDatahora());
						payload.setDataSangria(dataSangria);
						final Matcher matcherCodeStoreGold = Pattern.compile("[a-zA-Z0-9]{1,3}").matcher(dto.getCodeStoreGold().replaceAll("\\s+", ""));
						matcherCodeStoreGold.find();
						payload.setSiglaLoja(matcherCodeStoreGold.group());
						final TipoFormaPagamentoType tipoFormaPagamento = new TipoFormaPagamentoType();
						if (StringUtils.isEmpty(item.getSznumber2())) {
							tipoFormaPagamento.setFormaPagto("");
						} else {
							tipoFormaPagamento.setFormaPagto(item.getSznumber2());
						}
						if (ObjectUtils.isEmpty(item.getLfield2())) {
							tipoFormaPagamento.setNumeroFormaPagto(0);
						} else {
							final Matcher matcher = Pattern.compile("\\d{1,2}").matcher(String.valueOf(item.getLfield2()));
							matcher.find();
							tipoFormaPagamento.setNumeroFormaPagto(Integer.valueOf(matcher.group()));
						}
						if (ObjectUtils.isEmpty(item.getUlfield1())) {
							tipoFormaPagamento.setValorSangria(BigDecimal.ZERO);
						} else {
							final String valorSangria = item.getUlfield1().toString().replaceAll("\\W", "");
							if (StringUtils.isEmpty(valorSangria)) {
								tipoFormaPagamento.setValorSangria(BigDecimal.ZERO);
							} else {
								tipoFormaPagamento.setValorSangria(new BigDecimal(valorSangria));
							}
						}
						if (ObjectUtils.isEmpty(item.getFunctype())) {
							tipoFormaPagamento.setTipoMoeda(0);
						} else {
							final Matcher matcher = Pattern.compile("\\d{1}").matcher(String.valueOf(item.getFunctype()).replaceAll("\\s+", ""));
							matcher.find();
							final Map<Integer, Integer> mapaTipoMoeda = new HashMap<Integer, Integer>();
							mapaTipoMoeda.put(0,0);
							mapaTipoMoeda.put(1,1);
							mapaTipoMoeda.put(2,2);
							if (mapaTipoMoeda.get(Integer.valueOf(matcher.group())) == null) {
								tipoFormaPagamento.setTipoMoeda(0);
							} else {
								tipoFormaPagamento.setTipoMoeda(mapaTipoMoeda.get(Integer.valueOf(matcher.group())));
							}
						}
						if (StringUtils.isEmpty(item.getSzuserext())) {
							tipoFormaPagamento.setNumeroBanana("");
						} else {
							if (tipoFormaPagamento.getTipoMoeda() == 2) {
								final String numeroBanana = item.getSzuserext().replaceAll("\\W", "");
								if (StringUtils.isEmpty(numeroBanana)) {
									tipoFormaPagamento.setNumeroBanana("");
								} else {
									tipoFormaPagamento.setNumeroBanana(numeroBanana);
								}
							} else {
								tipoFormaPagamento.setNumeroBanana("");
							}
						}
						final TipoFormasPagamentosType formasPagamentos = new TipoFormasPagamentosType();
						formasPagamentos.setFormasPagamentos(tipoFormaPagamento);
						payload.getFormasPagamentos().add(formasPagamentos);
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
