package com.dieboldnixdorf.frentecaixa.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import com.dieboldnixdorf.frentecaixa.domain.Ejuserstruct1;
import com.dieboldnixdorf.frentecaixa.domain.RebaixaPrecoMessageType;
import com.dieboldnixdorf.frentecaixa.domain.RebaixaPrecoPayloadType;

/**
 * The Class DescontosRebaixaPrecoServiceImpl.
 */
@Component("descontosRebaixaPrecoService")
@Transactional (readOnly=true)
class DescontosRebaixaPrecoServiceImpl implements DescontosRebaixaPrecoService {

	/** The repository. */
	private final DescontosRebaixaPrecoRepository repository;

	/**
	 * Instantiates a new descontos rebaixa preco service impl.
	 *
	 * @param repository the repository
	 */
	public DescontosRebaixaPrecoServiceImpl(final DescontosRebaixaPrecoRepository repository) {
		this.repository = repository;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<RebaixaPrecoMessageType> findDescontosRebaixaPreco(final DescontosRebaixaPrecoSearchCriteria criteria, final Pageable pageable) {
		final List<RebaixaPrecoMessageType> messages = new ArrayList<RebaixaPrecoMessageType>();
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
		final Page<Ejuserstruct1> descontos = this.repository.findByCodigoLojaAndDataExtracao(Integer.valueOf(criteria.getCodigoLoja()), criteria.getDataExtracao(criteria.getDataExtracao()), pageable);
		cabecalho.setTotalPaginas(Long.valueOf(descontos.getTotalPages()));
		cabecalho.setTotalRegistros(descontos.getTotalElements());
		cabecalho.setTotalRegistrosPorPagina(Long.valueOf(pageable.getPageSize()));
		final RebaixaPrecoMessageType message = new RebaixaPrecoMessageType();
		message.setCabecalho(cabecalho);
		descontos.forEach(new Consumer<Ejuserstruct1>() {
			@Override
			public void accept(final Ejuserstruct1 item) {
				final RebaixaPrecoPayloadType payload = new RebaixaPrecoPayloadType();
				if (ObjectUtils.isEmpty(item.getDescontoPK().getTermnmbr())) {
					payload.setNumeroPDV(0);
				} else {
					final Matcher matcher = Pattern.compile("\\d{1,3}").matcher(String.valueOf(item.getDescontoPK().getTermnmbr()));
					matcher.find();
					payload.setNumeroPDV(Integer.valueOf(matcher.group()));
				}
				if (ObjectUtils.isEmpty(item.getDescontoPK().getTransnmbr())) {
					payload.setNumeroTransacao(Long.valueOf(0));
				} else {
					final Matcher matcher = Pattern.compile("\\d{1,10}").matcher(String.valueOf(item.getDescontoPK().getTransnmbr()));
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
				if (StringUtils.isEmpty(item.getSznumber1())) {
					payload.setCodigoProduto(Long.valueOf(0));
				} else {
					final Matcher matcher = Pattern.compile("\\d{1,13}").matcher(item.getSznumber1().replaceAll("\\s+",""));
					matcher.find();
					payload.setCodigoProduto(Long.valueOf(matcher.group()));
				}
				if (ObjectUtils.isEmpty(item.getUlfield1())) {
					payload.setValorOriginal(BigDecimal.ZERO);
				} else {
					payload.setValorOriginal(BigDecimal.valueOf(item.getUlfield1()));
				}
				if (ObjectUtils.isEmpty(item.getUlfield2())) {
					payload.setValorFinal(BigDecimal.ZERO);
				} else {
					payload.setValorFinal(BigDecimal.valueOf(item.getUlfield2()));
				}
				if (ObjectUtils.isEmpty(item.getLfield1())) {
					payload.setQuantidadeItens(BigDecimal.ZERO);
				} else {
					payload.setQuantidadeItens(BigDecimal.valueOf(item.getLfield1()));
				}
				if (StringUtils.isEmpty(item.getSzuserext())) {
					payload.setStatus("");
				} else {
					final Matcher matcher = Pattern.compile("[a-zA-Z]{1}").matcher(item.getSzuserext().replaceAll("\\s+", ""));
					matcher.find();
					final Map<String, String> mapaStatus = new HashMap<String, String>();
					mapaStatus.put("R", "R");
					mapaStatus.put("V", "V");
					mapaStatus.put("B", "B");
					if (mapaStatus.get(matcher.group().toUpperCase()) == null) {
						payload.setStatus("");
					} else {
						payload.setStatus(mapaStatus.get(matcher.group().toUpperCase()));
					}
				}
				if (!StringUtils.isEmpty(item.getSznumber2())) {
					final Matcher matcher = Pattern.compile("(000000)$").matcher(item.getSznumber2().replaceAll("\\s+", ""));
					if (!matcher.find()) {
						final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyy");
						final LocalDate localDate = LocalDate.parse(item.getSznumber2(), formatter);
						final Calendar dataMovimentacao  = Calendar.getInstance();
						dataMovimentacao.setTime(criteria.toDataValidade(localDate));
						payload.setDataValidade(dataMovimentacao);
					}
				}
				message.getRebaixaPreco().add(payload);
			}
		});
		if (!CollectionUtils.isEmpty(message.getRebaixaPreco())) {
			messages.add(message);
		}
		return messages;
	}
}
