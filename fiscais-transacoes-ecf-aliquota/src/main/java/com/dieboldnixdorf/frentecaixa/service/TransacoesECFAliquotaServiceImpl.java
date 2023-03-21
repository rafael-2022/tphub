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
import com.dieboldnixdorf.frentecaixa.domain.Ejitem;
import com.dieboldnixdorf.frentecaixa.domain.Ejtrailer;
import com.dieboldnixdorf.frentecaixa.domain.TipoRodapeControleType;
import com.dieboldnixdorf.frentecaixa.domain.TransacoesECFAliquotaMessageType;
import com.dieboldnixdorf.frentecaixa.domain.TransacoesECFAliquotaPayloadType;

/**
 * The Class TransacoesECFAliquotaServiceImpl.
 */
@Component("transacoesECFAliquotaService")
@Transactional (readOnly=true)
class TransacoesECFAliquotaServiceImpl implements TransacoesECFAliquotaService {

	/** The repository. */
	private final TransacoesECFAliquotaRepository repository;

	/** The controle repository. */
	private final TransacoesECFAliquotaControleRepository controleRepository;
	
	/**
	 * Instantiates a new transacoes ECF aliquota service impl.
	 *
	 * @param repository the repository
	 */
	public TransacoesECFAliquotaServiceImpl(final TransacoesECFAliquotaRepository repository, final TransacoesECFAliquotaControleRepository controleRepository) {
		this.repository = repository;
		this.controleRepository = controleRepository;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<TransacoesECFAliquotaMessageType> findTransacoesECFAliquota(final TransacoesECFAliquotaSearchCriteria criteria, final Pageable pageable) {
		final List<TransacoesECFAliquotaMessageType> messages = new ArrayList<TransacoesECFAliquotaMessageType>();
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
		final Page<Ejitem> transacoes = this.repository.findByCodigoLojaAndDataExtracao(Integer.valueOf(criteria.getCodigoLoja()), criteria.getDataExtracao(criteria.getDataExtracao(criteria.getDataExtracao())), pageable);
		cabecalho.setTotalPaginas(Long.valueOf(transacoes.getTotalPages()));
		cabecalho.setTotalRegistros(transacoes.getTotalElements());
		cabecalho.setTotalRegistrosPorPagina(Long.valueOf(pageable.getPageSize()));
		final TransacoesECFAliquotaMessageType message = new TransacoesECFAliquotaMessageType();
		message.setCabecalho(cabecalho);
		transacoes.forEach(new Consumer<Ejitem>() {
			@Override
			public void accept(final Ejitem item) {
				if (!ObjectUtils.isEmpty(item)) {
					final TransacoesECFAliquotaPayloadType payload = new TransacoesECFAliquotaPayloadType();
					if (ObjectUtils.isEmpty(item.getFiscalPK().getTermnmbr())) {
						payload.setNumeroECF(0);
					} else {
						final Matcher matcher = Pattern.compile("\\d{1,3}").matcher(String.valueOf(item.getFiscalPK().getTermnmbr()));
						matcher.find();
						payload.setNumeroECF(Integer.valueOf(matcher.group()));
					}
					if (ObjectUtils.isEmpty(item.getAmtsold())) {
						payload.setBaseCalculo(BigDecimal.ZERO);
					} else {
						final String amtsold = item.getAmtsold().toString().replaceAll("\\W", "");
						if (StringUtils.isEmpty(amtsold)) {
							payload.setBaseCalculo(BigDecimal.ZERO);
						} else {
							payload.setBaseCalculo(new BigDecimal(amtsold));
						}
					}
					if (StringUtils.isEmpty(item.getFiscalPK().getCouponfmly())) {
						payload.setTipoAliquota("");
					} else {
						final Matcher matcher = Pattern.compile("[a-zA-Z\\s+]{1,2}").matcher(String.valueOf(item.getFiscalPK().getCouponfmly().replaceAll("\\s+", "")));
						matcher.find();
						final Map<String, String> mapaTipoAliquota = new HashMap<String, String>();
						mapaTipoAliquota.put("IS", "IS");
						mapaTipoAliquota.put("NT", "NT");
						mapaTipoAliquota.put("ST", "ST");
						mapaTipoAliquota.put("BR", "BR");
						mapaTipoAliquota.put("CB", "CB");
						mapaTipoAliquota.put("PI", "PI");
						mapaTipoAliquota.put("DZ", "DZ");
						mapaTipoAliquota.put("NO", "NO");
						mapaTipoAliquota.put("SU", "SU");
						if (mapaTipoAliquota.get(matcher.group().toUpperCase()) == null) {
							payload.setTipoAliquota("");
						} else {
							payload.setTipoAliquota(mapaTipoAliquota.get(matcher.group().toUpperCase()));
						}
					}
					if (StringUtils.isEmpty(item.getFiscalPK().getPrint1text())) {
						payload.setValorAliquota(BigDecimal.ZERO);
					} else {
						final String taxnmbr = item.getFiscalPK().getPrint1text().replaceAll("\\W", "");
						if (StringUtils.isEmpty(taxnmbr)) {
							payload.setValorAliquota(BigDecimal.ZERO);
						} else {
							payload.setValorAliquota(new BigDecimal(taxnmbr));
						}
					}
					if (ObjectUtils.isEmpty(item.getMrpprice1())) {
						payload.setImpostoDebitado(BigDecimal.ZERO);
					} else {
						final String impostoDebitado = item.getMrpprice1().toString().replaceAll("\\W", "");
						if (StringUtils.isEmpty(impostoDebitado)) {
							payload.setImpostoDebitado(BigDecimal.ZERO);
						} else {
							payload.setImpostoDebitado(new BigDecimal(impostoDebitado));
						}
					}
					message.getMovimentosFiscaisECF().add(payload);
				}
			}
		});
		if (!CollectionUtils.isEmpty(message.getMovimentosFiscaisECF())) {
			final Ejtrailer item = this.controleRepository.findByCodigoLojaAndDataExtracao(Integer.valueOf(criteria.getCodigoLoja()), criteria.getDataExtracao(criteria.getDataExtracao(criteria.getDataExtracao())));
			final TipoRodapeControleType rodapeControle = new TipoRodapeControleType();
			if (!ObjectUtils.isEmpty(item)) {
				final Calendar dataEsquemaVendas  = Calendar.getInstance();
				dataEsquemaVendas.setTime(criteria.getDataHoraExtracao(criteria.getDataExtracao()));
				final Calendar dataMovimentacao  = Calendar.getInstance();
				dataMovimentacao.setTime(criteria.getDataExtracao(criteria.getDataExtracao()));
				final DateTimeFormatter rodapeFormatter = DateTimeFormatter.ofPattern("ddMMyy");
				final LocalDateTime rodapeLocalDateTime = LocalDateTime.of(dataEsquemaVendas.get(Calendar.YEAR),dataEsquemaVendas.get(Calendar.MONTH) + 1, dataEsquemaVendas.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
				rodapeControle.setNomeArquivoInterface("DM".concat(rodapeLocalDateTime.format(rodapeFormatter)));
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