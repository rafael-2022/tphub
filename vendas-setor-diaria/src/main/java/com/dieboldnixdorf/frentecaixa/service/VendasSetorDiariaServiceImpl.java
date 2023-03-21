package com.dieboldnixdorf.frentecaixa.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
import com.dieboldnixdorf.frentecaixa.domain.Ejtrailer;
import com.dieboldnixdorf.frentecaixa.domain.TipoRodapeControleType;
import com.dieboldnixdorf.frentecaixa.domain.VendaSetorDiariaMessageType;
import com.dieboldnixdorf.frentecaixa.domain.VendaSetorDiariaPayloadType;

/**
 * The Class VendasSetorDiariaServiceImpl.
 */
@Component("vendasSetorDiariaService")
@Transactional (readOnly=true)
class VendasSetorDiariaServiceImpl implements VendasSetorDiariaService {

	/** The repository. */
	private final VendasSetorDiariaRepository repository;

	/** The controle repository. */
	private final VendasSetorDiariaControleRepository controleRepository;
	
	/**
	 * Instantiates a new vendas setor diaria service impl.
	 *
	 * @param repository the repository
	 */
	public VendasSetorDiariaServiceImpl(final VendasSetorDiariaRepository repository, final VendasSetorDiariaControleRepository controleRepository) {
		this.repository = repository;
		this.controleRepository = controleRepository;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<VendaSetorDiariaMessageType> findVendasSetorDiaria(final VendasSetorDiariaSearchCriteria criteria, final Pageable pageable) {
		final List<VendaSetorDiariaMessageType> messages = new ArrayList<VendaSetorDiariaMessageType>();
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
		final Page<Ejitem> vendas = this.repository.findByCodigoLojaAndDataExtracao(Integer.valueOf(criteria.getCodigoLoja()), criteria.getDataExtracao(criteria.getDataExtracao(criteria.getDataExtracao())), pageable);
		cabecalho.setTotalPaginas(Long.valueOf(vendas.getTotalPages()));
		cabecalho.setTotalRegistros(vendas.getTotalElements());
		cabecalho.setTotalRegistrosPorPagina(Long.valueOf(pageable.getPageSize()));
		final VendaSetorDiariaMessageType message = new VendaSetorDiariaMessageType();
		message.setCabecalho(cabecalho);
		vendas.forEach(new Consumer<Ejitem>() {
			@Override
			public void accept(final Ejitem item) {
				if (item.getMrpprice1().intValue() != 0) {
					final VendaSetorDiariaPayloadType payload = new VendaSetorDiariaPayloadType();
					if (StringUtils.isEmpty(item.getDate())) {
						payload.setDataMovimentoVendasSetor(null);
					} else {
						final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
						final LocalDate localDate = LocalDate.parse(item.getDate(), formatter);
						final Calendar dataMovimentacao  = Calendar.getInstance();
						dataMovimentacao.setTime(criteria.getDataExtracao(localDate));
						payload.setDataMovimentoVendasSetor(dataMovimentacao);
					}
					if (StringUtils.isEmpty(item.getDeptnmbr())) {
						payload.setCodigoSecao(0);
					} else {
						final String deptnmbr = item.getDeptnmbr().trim().replaceAll("\\W", "");
						final Matcher matcher = Pattern.compile("\\d{1,2}").matcher(deptnmbr);
						matcher.find();
						payload.setCodigoSecao(Integer.valueOf(matcher.group()));
					}
					if (ObjectUtils.isEmpty(item.getMrpprice1())) {
						payload.setValorContabil(BigDecimal.ZERO);
					} else {
						final String valorContabil = item.getMrpprice1().toString().replaceAll("\\W", "");
						if (StringUtils.isEmpty(valorContabil)) {
							payload.setValorContabil(BigDecimal.ZERO);
						} else {
							payload.setValorContabil(new BigDecimal(valorContabil));
						}
					}
					if (ObjectUtils.isEmpty(item.getMrpprice2())) {
						payload.setValorICMS(BigDecimal.ZERO);
					} else {
						final String valorICMS = item.getMrpprice2().toString().replaceAll("\\W", "");
						if (StringUtils.isEmpty(valorICMS)) {
							payload.setValorICMS(BigDecimal.ZERO);
						} else {
							payload.setValorICMS(new BigDecimal(valorICMS));
						}
					}
					if (ObjectUtils.isEmpty(item.getMrpprice3())) {
						payload.setValorBaseCalculoPIS(BigDecimal.ZERO);
					} else {
						final String  baseCalculoPIS = item.getMrpprice3().toString().replaceAll("\\W", "");
						if (StringUtils.isEmpty(baseCalculoPIS)) {
							payload.setValorBaseCalculoPIS(BigDecimal.ZERO);
						} else {
							payload.setValorBaseCalculoPIS(new BigDecimal(baseCalculoPIS));
						}
					}
					if (ObjectUtils.isEmpty(item.getMrpprice4())) {
						payload.setValorPIS(BigDecimal.ZERO);
					} else {
						final String  valorCalculoPIS = item.getMrpprice4().toString().replaceAll("\\W", "");
						if (StringUtils.isEmpty(valorCalculoPIS)) {
							payload.setValorPIS(BigDecimal.ZERO);
						} else {
							payload.setValorPIS(new BigDecimal(valorCalculoPIS));
						}
					}
					if (ObjectUtils.isEmpty(item.getMrpprice5())) {
						payload.setValorCOFINS(BigDecimal.ZERO);
					} else {
						final String  valorCalculoCOFINS = item.getMrpprice5().toString().replaceAll("\\W", "");
						if (StringUtils.isEmpty(valorCalculoCOFINS)) {
							payload.setValorCOFINS(BigDecimal.ZERO);
						} else {
							payload.setValorCOFINS(new BigDecimal(valorCalculoCOFINS));
						}
					}
					if (ObjectUtils.isEmpty(item.getSumamtdisc())) {
						payload.setValorBaseCalculoCOFINS(BigDecimal.ZERO);
					} else {
						final String  baseCalculoCOFINS = item.getSumamtdisc().toString().replaceAll("\\W", "");
						if (StringUtils.isEmpty(baseCalculoCOFINS)) {
							payload.setValorBaseCalculoCOFINS(BigDecimal.ZERO);
						} else {
							payload.setValorBaseCalculoCOFINS(new BigDecimal(baseCalculoCOFINS));
						}
					}
					message.getPayload().add(payload);
				}
			}
		});
		if (!CollectionUtils.isEmpty(message.getPayload())) {
			final Ejtrailer item = this.controleRepository.findByCodigoLojaAndDataExtracao(Integer.valueOf(criteria.getCodigoLoja()), criteria.getDataExtracao(criteria.getDataExtracao(criteria.getDataExtracao())));
			final TipoRodapeControleType rodapeControle = new TipoRodapeControleType();
			if (!ObjectUtils.isEmpty(item)) {
				final Calendar dataEsquemaVendas  = Calendar.getInstance();
				dataEsquemaVendas.setTime(criteria.getDataHoraExtracao(criteria.getDataExtracao()));
				final Calendar dataMovimentacao  = Calendar.getInstance();
				dataMovimentacao.setTime(criteria.getDataExtracao(criteria.getDataExtracao()));
				final DateTimeFormatter rodapeFormatter = DateTimeFormatter.ofPattern("ddMMyy");
				final LocalDateTime rodapeLocalDateTime = LocalDateTime.of(dataEsquemaVendas.get(Calendar.YEAR),dataEsquemaVendas.get(Calendar.MONTH) + 1, dataEsquemaVendas.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
				rodapeControle.setNomeArquivoInterface("SM".concat(rodapeLocalDateTime.format(rodapeFormatter)));
				rodapeControle.setDataMovimento(dataMovimentacao);
				if (ObjectUtils.isEmpty(item.getTotalvat())) {
					rodapeControle.setNumeroRegistrosArquivo(0);
				} else {
					final Matcher matcher = Pattern.compile("\\d{1,4}").matcher(String.valueOf(item.getTotalvat()).replaceAll("\\s+", ""));
					matcher.find();
					rodapeControle.setNumeroRegistrosArquivo(Integer.valueOf(matcher.group()));
				}
				if (ObjectUtils.isEmpty(item.getTotalaos())) {
					rodapeControle.setValorContabilTotal(BigDecimal.ZERO);
				} else {
					final String valorContabilTotal = item.getTotalaos().toString().replaceAll("\\W", "");
					if (StringUtils.isEmpty(valorContabilTotal)) {
						rodapeControle.setValorContabilTotal(BigDecimal.ZERO);
					} else {
						rodapeControle.setValorContabilTotal(new BigDecimal(valorContabilTotal));
					}
				}
				if (ObjectUtils.isEmpty(item.getTotalmanualdisc())) {
					rodapeControle.setBaseCalculoTotal(BigDecimal.ZERO);
				} else {
					final String baseCalculoTotal = item.getTotalmanualdisc().toString().replaceAll("\\W", "");
					if (StringUtils.isEmpty(baseCalculoTotal)) {
						rodapeControle.setBaseCalculoTotal(BigDecimal.ZERO);
					} else {
						rodapeControle.setBaseCalculoTotal(new BigDecimal(baseCalculoTotal));
					}
				}
				if (ObjectUtils.isEmpty(item.getTotalpoints())) {
					rodapeControle.setImpostoDebitadoTotal(BigDecimal.ZERO);
				} else {
					final String impostoDebitadoTotal = item.getTotalpoints().toString().replaceAll("\\W", "");
					if (StringUtils.isEmpty(impostoDebitadoTotal)) {
						rodapeControle.setImpostoDebitadoTotal(BigDecimal.ZERO);
					} else {
						rodapeControle.setImpostoDebitadoTotal(new BigDecimal(impostoDebitadoTotal));
					}
				}
				if (ObjectUtils.isEmpty(item.getTotalmkdn())) {
					rodapeControle.setNumeroClientesTotal(Long.valueOf(0));
				} else {
					final Matcher matcher = Pattern.compile("\\d{1,10}").matcher(String.valueOf(item.getTotalmkdn()));
					matcher.find();
					rodapeControle.setNumeroClientesTotal(Long.valueOf(matcher.group()));
				}
				if (ObjectUtils.isEmpty(item.getSeq())) {
					rodapeControle.setNumeroMapaResumo(0);
				} else {
					final Matcher matcher = Pattern.compile("\\d{1,6}").matcher(String.valueOf(item.getSeq()).replaceAll("\\s+", ""));
					matcher.find();
					rodapeControle.setNumeroMapaResumo(Integer.valueOf(matcher.group()));
				}
			} else {
				rodapeControle.setNomeArquivoInterface("");
				rodapeControle.setDataMovimento(Calendar.getInstance());
				rodapeControle.setNumeroRegistrosArquivo(0);
				rodapeControle.setValorContabilTotal(BigDecimal.ZERO);
				rodapeControle.setBaseCalculoTotal(BigDecimal.ZERO);
				rodapeControle.setImpostoDebitadoTotal(BigDecimal.ZERO);
				rodapeControle.setNumeroClientesTotal(Long.valueOf(0));
				rodapeControle.setNumeroMapaResumo(0);
			}
			message.setRodapeControle(rodapeControle);
			messages.add(message);
		}
		return messages;
	}

}