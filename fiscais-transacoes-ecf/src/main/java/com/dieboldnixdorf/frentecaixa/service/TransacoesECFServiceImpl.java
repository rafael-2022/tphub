package com.dieboldnixdorf.frentecaixa.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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
import com.dieboldnixdorf.frentecaixa.domain.Ejtrailer;
import com.dieboldnixdorf.frentecaixa.domain.Ejuserstruct1;
import com.dieboldnixdorf.frentecaixa.domain.TipoRodapeControleType;
import com.dieboldnixdorf.frentecaixa.domain.TransacoesECFMessageType;
import com.dieboldnixdorf.frentecaixa.domain.TransacoesECFPayloadType;

/**
 * The Class TransacoesECFServiceImpl.
 */
@Component("transacoesECFService")
@Transactional (readOnly=true)
class TransacoesECFServiceImpl implements TransacoesECFService {

	/** The repository. */
	private final TransacoesECFRepository repository;

	/** The controle repository. */
	private final TransacoesECFControleRepository controleRepository;

	/**
	 * Instantiates a new transacoes ECF service impl.
	 *
	 * @param repository the repository
	 */
	public TransacoesECFServiceImpl(final TransacoesECFRepository repository, final TransacoesECFControleRepository controleRepository) {
		this.repository = repository;
		this.controleRepository = controleRepository;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<TransacoesECFMessageType> findTransacoesECF(final TransacoesECFSearchCriteria criteria, final Pageable pageable) {
		final List<TransacoesECFMessageType> messages = new ArrayList<TransacoesECFMessageType>();
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
		final Page<Ejuserstruct1> transacoes = this.repository.findByCodigoLojaAndDataExtracao(Integer.valueOf(criteria.getCodigoLoja()), criteria.getDataExtracao(criteria.getDataExtracao(criteria.getDataExtracao())), pageable);
		cabecalho.setTotalPaginas(Long.valueOf(transacoes.getTotalPages()));
		cabecalho.setTotalRegistros(transacoes.getTotalElements());
		cabecalho.setTotalRegistrosPorPagina(Long.valueOf(pageable.getPageSize()));
		final TransacoesECFMessageType message = new TransacoesECFMessageType();
		message.setCabecalho(cabecalho);
		if (!ObjectUtils.isEmpty(transacoes)) {
			transacoes.forEach(new Consumer<Ejuserstruct1>() {
				@Override
				public void accept(final Ejuserstruct1 item) {
					final TransacoesECFPayloadType payload = new TransacoesECFPayloadType();
					if (ObjectUtils.isEmpty(item.getFiscalPK().getTermnmbr())) {
						payload.setNumeroECF(0);
					} else {
						final Matcher matcher = Pattern.compile("\\d{1,3}").matcher(String.valueOf(item.getFiscalPK().getTermnmbr()));
						matcher.find();
						payload.setNumeroECF(Integer.valueOf(matcher.group()));
					}
					if (ObjectUtils.isEmpty(item.getLfield1())) {
						payload.setContadorReducoes(0);
					} else {
						final Matcher matcher = Pattern.compile("\\d{1,6}").matcher(String.valueOf(item.getLfield1()));
						matcher.find();
						payload.setContadorReducoes(Integer.valueOf(matcher.group()));
					}
					if (ObjectUtils.isEmpty(item.getUlfield1())) {
						payload.setValorTotalCancelados(BigDecimal.ZERO);
					} else {
						final String ulfield1 = item.getUlfield1().toString().replaceAll("\\W", "");
						if (StringUtils.isEmpty(ulfield1)) {
							payload.setValorTotalCancelados(BigDecimal.ZERO);
						} else {
							payload.setValorTotalCancelados(new BigDecimal(ulfield1));
						}
					}
					if (ObjectUtils.isEmpty(item.getUlfield2())) {
						payload.setContadorReinicioOperacao(0);
					} else {
						final Matcher matcher = Pattern.compile("\\d{1,3}").matcher(String.valueOf(item.getUlfield2()));
						matcher.find();
						payload.setContadorReinicioOperacao(Integer.valueOf(matcher.group()));
					}
					if (StringUtils.isEmpty(item.getSznumber1())) {
						payload.setGtInicial(BigDecimal.ZERO);
					} else {
						final String sznumber1 = item.getSznumber1().replaceAll("\\W", "");
						if (StringUtils.isEmpty(sznumber1)) {
							payload.setGtInicial(BigDecimal.ZERO);
						} else {
							payload.setGtInicial(new BigDecimal(sznumber1));
						}
					}
					if (StringUtils.isEmpty(item.getSznumber2())) {
						payload.setGtFinal(BigDecimal.ZERO);
					} else {
						final String sznumber2 = item.getSznumber2().replaceAll("\\W", "");
						if (StringUtils.isEmpty(sznumber2)) {
							payload.setGtFinal(BigDecimal.ZERO);
						} else {
							payload.setGtFinal(new BigDecimal(sznumber2));
						}
					}
					if (ObjectUtils.isEmpty(item.getStorenmbr()) 
							&& ObjectUtils.isEmpty(item.getFiscalPK().getTermnmbr())
							&& StringUtils.isEmpty(item.getDate())) {
						payload.setNumeroOperacaoInicial(0);
					} else {
						final Matcher matcher = Pattern.compile("\\d{1,6}").matcher(String.valueOf("0"));
						matcher.find();
						payload.setNumeroOperacaoInicial(Integer.valueOf(matcher.group()));
					}
					if (ObjectUtils.isEmpty(item.getStorenmbr()) 
							&& ObjectUtils.isEmpty(item.getFiscalPK().getTermnmbr())
							&& StringUtils.isEmpty(item.getDate())) {
						payload.setNumeroOperacaoFinal(0);
					} else {
						final Matcher matcher = Pattern.compile("\\d{1,6}").matcher(String.valueOf("0"));
						matcher.find();
						payload.setNumeroOperacaoFinal(Integer.valueOf(matcher.group()));
					}
					if (ObjectUtils.isEmpty(item.getStorenmbr()) 
							&& ObjectUtils.isEmpty(item.getFiscalPK().getTermnmbr())
							&& StringUtils.isEmpty(item.getDate())) {
						payload.setMovimentoTotalBrutoDia(BigDecimal.ZERO);
					} else {
						final Long movimentoTotalBrutoDia = repository.findMovimentoTotalBrutoDiaByStoreNmbrAndDateAndTermNmbr(item.getStorenmbr(), item.getDate(), item.getFiscalPK().getTermnmbr());
						if (ObjectUtils.isEmpty(movimentoTotalBrutoDia)) {
							payload.setMovimentoTotalBrutoDia(BigDecimal.ZERO);
						} else {
							payload.setMovimentoTotalBrutoDia(BigDecimal.valueOf(movimentoTotalBrutoDia));
						}
					}
					if (ObjectUtils.isEmpty(item.getStorenmbr()) 
							&& ObjectUtils.isEmpty(item.getFiscalPK().getTermnmbr())
							&& StringUtils.isEmpty(item.getDate())) {
						payload.setValorTotalDescontos(BigDecimal.ZERO);
					} else {
						final Long valorTotalDescontos = repository.findValorTotalDescontosByStoreNmbrAndDateAndTermNmbr(item.getStorenmbr(), item.getDate(), item.getFiscalPK().getTermnmbr());
						if (ObjectUtils.isEmpty(valorTotalDescontos)) {
							payload.setValorTotalDescontos(BigDecimal.ZERO);
						} else {
							payload.setValorTotalDescontos(BigDecimal.valueOf(valorTotalDescontos));
						}
					}
					if (ObjectUtils.isEmpty(item.getStorenmbr()) 
							&& ObjectUtils.isEmpty(item.getFiscalPK().getTermnmbr())
							&& StringUtils.isEmpty(item.getDate())) {
						payload.setValorContabil(BigDecimal.ZERO);
					} else {
						final Long valorContabil = repository.findValorContabilByStoreNmbrAndDateAndTermNmbr(item.getStorenmbr(), item.getDate(), item.getFiscalPK().getTermnmbr());
						if (ObjectUtils.isEmpty(valorContabil)) {
							payload.setValorContabil(BigDecimal.ZERO);
						} else {
							payload.setValorContabil(BigDecimal.valueOf(valorContabil));
						}
					}
					if (ObjectUtils.isEmpty(item.getStorenmbr()) 
							&& ObjectUtils.isEmpty(item.getFiscalPK().getTermnmbr())
							&& StringUtils.isEmpty(item.getDate())) {
						payload.setQuantidadeClientes(Long.valueOf(0));
					} else {
						final Long quantidadeClientes = repository.findQuantidadeClientesByStoreNmbrAndDateAndTermNmbr(item.getStorenmbr(), item.getDate(), item.getFiscalPK().getTermnmbr());
						final Matcher matcher = Pattern.compile("\\d{1,10}").matcher(String.valueOf(quantidadeClientes));
						matcher.find();
						payload.setQuantidadeClientes(Long.valueOf(matcher.group()));
					}
					if (ObjectUtils.isEmpty(item.getStorenmbr()) 
							&& ObjectUtils.isEmpty(item.getFiscalPK().getTermnmbr())
							&& StringUtils.isEmpty(item.getDate())) {
						payload.setAcumuladorIsento(BigDecimal.ZERO);
					} else {
						final Long acumuladorIsento = repository.findAcumuladorIsentoByStoreNmbrAndDateAndTermNmbr(item.getStorenmbr(), item.getDate(), item.getFiscalPK().getTermnmbr());
						if (ObjectUtils.isEmpty(acumuladorIsento)) {
							payload.setAcumuladorIsento(BigDecimal.ZERO);
						} else {
							payload.setAcumuladorIsento(BigDecimal.valueOf(acumuladorIsento));
						}
					}
					if (ObjectUtils.isEmpty(item.getStorenmbr()) 
							&& ObjectUtils.isEmpty(item.getFiscalPK().getTermnmbr())
							&& StringUtils.isEmpty(item.getDate())) {
						payload.setAcumuladorNaoTributado(BigDecimal.ZERO);
					} else {
						final Long acumuladorNaoTributado = repository.findAcumuladorNaoTributadoByStoreNmbrAndDateAndTermNmbr(item.getStorenmbr(), item.getDate(), item.getFiscalPK().getTermnmbr());
						if (ObjectUtils.isEmpty(acumuladorNaoTributado)) {
							payload.setAcumuladorNaoTributado(BigDecimal.ZERO);
						} else {
							payload.setAcumuladorNaoTributado(BigDecimal.valueOf(acumuladorNaoTributado));
						}
					}
					if (ObjectUtils.isEmpty(item.getStorenmbr()) 
							&& ObjectUtils.isEmpty(item.getFiscalPK().getTermnmbr())
							&& StringUtils.isEmpty(item.getDate())) {
						payload.setAcumuladorSubstituicaoTributaria(BigDecimal.ZERO);
					} else {
						final Long acumuladorSubstituicaoTributaria = repository.findAcumuladorSubstituicaoTributariaByStoreNmbrAndDateAndTermNmbr(item.getStorenmbr(), item.getDate(), item.getFiscalPK().getTermnmbr());
						if (ObjectUtils.isEmpty(acumuladorSubstituicaoTributaria)) {
							payload.setAcumuladorSubstituicaoTributaria(BigDecimal.ZERO);
						} else {
							payload.setAcumuladorSubstituicaoTributaria(BigDecimal.valueOf(acumuladorSubstituicaoTributaria));
						}
					}
					final String indicadorECFPerifico = repository.findLocalizacaoByStoreNmbrAndTermNmbr(item.getStorenmbr(), item.getFiscalPK().getTermnmbr());
					if (StringUtils.isEmpty(indicadorECFPerifico)) {
						payload.setIndicadorECFPeriferico("");
					} else {
						final Matcher matcher = Pattern.compile("[a-zA-Z\\s+]{1}").matcher(indicadorECFPerifico);
						matcher.find();
						final Map<String, String> mapaIndicadorECFPerifico = new HashMap<String, String>();
						mapaIndicadorECFPerifico.put("N", "N");
						mapaIndicadorECFPerifico.put("S", "S");
						if (mapaIndicadorECFPerifico.get(matcher.group().toUpperCase()) == null) {
							payload.setIndicadorECFPeriferico("");
						} else {
							payload.setIndicadorECFPeriferico(mapaIndicadorECFPerifico.get(matcher.group().toUpperCase()));
						}
					}
					message.getMovimentosFiscais().add(payload);
				}
			});
		}
		if (!CollectionUtils.isEmpty(message.getMovimentosFiscais())) {
			final Ejtrailer item = this.controleRepository.findByCodigoLojaAndDataExtracao(Integer.valueOf(criteria.getCodigoLoja()), criteria.getDataExtracao(criteria.getDataExtracao(criteria.getDataExtracao())));
			final TipoRodapeControleType rodapeControle = new TipoRodapeControleType();
			if (!ObjectUtils.isEmpty(item)) {
				final Calendar dataEsquemaVendas  = Calendar.getInstance();
				dataEsquemaVendas.setTime(criteria.getDataHoraExtracao(criteria.getDataExtracao()));
				final Calendar dataMovimentacao  = Calendar.getInstance();
				dataMovimentacao.setTime(criteria.getDataExtracao(criteria.getDataExtracao()));
				final DateTimeFormatter rodapeFormatter = DateTimeFormatter.ofPattern("ddMMyy");
				final LocalDateTime rodapeLocalDateTime = LocalDateTime.of(dataEsquemaVendas.get(Calendar.YEAR),dataEsquemaVendas.get(Calendar.MONTH) + 1, dataEsquemaVendas.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
				rodapeControle.setNomeArquivoInterface("HM".concat(rodapeLocalDateTime.format(rodapeFormatter)));
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
		}
		if (!CollectionUtils.isEmpty(message.getMovimentosFiscais())) {
			messages.add(message);
		}
		return messages;
	}

}
