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
import com.dieboldnixdorf.frentecaixa.domain.DevolucaoContabilMessageType;
import com.dieboldnixdorf.frentecaixa.domain.DevolucaoContabilPayloadType;
import com.dieboldnixdorf.frentecaixa.domain.Ejitem;
import com.dieboldnixdorf.frentecaixa.domain.Ejtrailer;
import com.dieboldnixdorf.frentecaixa.domain.TipoRodapeControleType;

/**
 * The Class DevolucaoContabilServiceImpl.
 */
@Component("devolucaoContabilService")
@Transactional (readOnly=true)
class DevolucaoContabilServiceImpl implements DevolucaoContabilService {

	/** The repository. */
	private final DevolucaoContabilRepository repository;

	/** The controle repository. */
	private final DevolucaoContabilControleRepository controleRepository;

	/**
	 * Instantiates a new devolucao contabil service impl.
	 *
	 * @param repository the repository
	 */
	public DevolucaoContabilServiceImpl(final DevolucaoContabilRepository repository, final DevolucaoContabilControleRepository controleRepository) {
		this.repository = repository;
		this.controleRepository = controleRepository;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<DevolucaoContabilMessageType> findDevolucaoContabil(final DevolucaoContabilSearchCriteria criteria, final Pageable pageable) {
		final List<DevolucaoContabilMessageType> messages = new ArrayList<DevolucaoContabilMessageType>();
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
		final Page<Ejitem> devolucoes = this.repository.findByCodigoLojaAndDataExtracao(Integer.valueOf(criteria.getCodigoLoja()), criteria.getDataExtracao(criteria.getDataExtracao()), pageable);
		cabecalho.setTotalPaginas(Long.valueOf(devolucoes.getTotalPages()));
		cabecalho.setTotalRegistros(devolucoes.getTotalElements());
		cabecalho.setTotalRegistrosPorPagina(Long.valueOf(pageable.getPageSize()));
		final DevolucaoContabilMessageType message = new DevolucaoContabilMessageType();
		message.setCabecalho(cabecalho);
		devolucoes.forEach(new Consumer<Ejitem>() {
			@Override
			public void accept(final Ejitem item) {
				if (!ObjectUtils.isEmpty(item)) {
					final DevolucaoContabilPayloadType payload = new DevolucaoContabilPayloadType();
					if (StringUtils.isEmpty(item.getEntrynmbr())) {
						payload.setTipoDevolucao("");
					} else {
						final Matcher matcher = Pattern.compile("[a-zA-Z0-9\\s+]{1,2}").matcher(item.getEntrynmbr().replaceAll("\\s+", ""));
						matcher.find();
						final Map<String, String> mapaTipoDevolucao = new HashMap<String, String>();
						mapaTipoDevolucao.put("AN", "AN");
						mapaTipoDevolucao.put("CP", "CP");
						mapaTipoDevolucao.put("RD", "RD");
						mapaTipoDevolucao.put("TC", "TC");
						if (mapaTipoDevolucao.get(matcher.group().toUpperCase()) == null) {
							payload.setTipoDevolucao("");
						} else {
							payload.setTipoDevolucao(mapaTipoDevolucao.get(matcher.group().toUpperCase()));
						}
					}
					if (ObjectUtils.isEmpty(item.getContabilPK().getClerknmbr())) {
						payload.setCodigoSetor(0);
					} else {
						final Matcher matcher = Pattern.compile("\\d{1,2}").matcher(String.valueOf(item.getContabilPK().getClerknmbr()));
						matcher.find();
						payload.setCodigoSetor(Integer.valueOf(matcher.group()));
					}
					if (ObjectUtils.isEmpty(item.getSumamtdisc())) {
						payload.setNumeroECF(0);
					} else {
						final Matcher matcher = Pattern.compile("\\d{1,3}").matcher(String.valueOf(item.getSumamtdisc()));
						matcher.find();
						payload.setNumeroECF(Integer.valueOf(matcher.group()));
					}
					if (ObjectUtils.isEmpty(item.getCshrnmbr())) {
						payload.setCodigoOperadora(Long.valueOf(0));
					} else {
						final Matcher matcher = Pattern.compile("\\d{1,10}").matcher(String.valueOf(item.getCshrnmbr()));
						matcher.find();
						payload.setCodigoOperadora(Long.valueOf(matcher.group()));
					}
					if (ObjectUtils.isEmpty(item.getMngrovnmbr())) {
						payload.setValorDevolucao(BigDecimal.ZERO);
					} else {
						final String mngrovnmbr = item.getMngrovnmbr().toString().replaceAll("\\W", "");
						if (StringUtils.isEmpty(mngrovnmbr)) {
							payload.setValorDevolucao(BigDecimal.ZERO);
						} else {
							payload.setValorDevolucao(new BigDecimal(mngrovnmbr));
						}
					}
					if (StringUtils.isEmpty(item.getPrint1text())) {
						payload.setFlagCupom("");
					} else {
						final Matcher matcher = Pattern.compile("[a-zA-Z\\s+]{3}").matcher(String.valueOf(item.getPrint1text().replaceAll("\\s+", "")));
						matcher.find();
						final Map<String, String> mapaFlagCupom = new HashMap<String, String>();
						mapaFlagCupom.put("SEM", "N");
						mapaFlagCupom.put("COM", "S");
						if (mapaFlagCupom.get(matcher.group().toUpperCase()) == null) {
							payload.setFlagCupom("");
						} else {
							payload.setFlagCupom(mapaFlagCupom.get(matcher.group().toUpperCase()));
						}
					}
					if (StringUtils.isEmpty(item.getContabilPK().getCouponfmly())) {
						payload.setTipoAliquota("");
					} else {
						final Matcher matcher = Pattern.compile("[a-zA-Z\\s+]{1,2}").matcher(String.valueOf(item.getContabilPK().getCouponfmly().replaceAll("\\s+", "")));
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
					if (StringUtils.isEmpty(item.getPludesc())) {
						payload.setValorAliquota(BigDecimal.ZERO);
					} else {
						final String valorAliquota = item.getPludesc().trim().toString().replaceAll("\\W", "");
						if (StringUtils.isEmpty(valorAliquota)) {
							payload.setValorAliquota(BigDecimal.ZERO);
						} else {
							payload.setValorAliquota(new BigDecimal(valorAliquota));
						}
					}
					if (ObjectUtils.isEmpty(item.getMrpprice5())) {
						payload.setValorImposto(BigDecimal.ZERO);
					} else {
						final String valorImposto = item.getMrpprice5().toString().replaceAll("\\W", "");
						if (StringUtils.isEmpty(valorImposto)) {
							payload.setValorImposto(BigDecimal.ZERO);
						} else {
							payload.setValorImposto(new BigDecimal(valorImposto));
						}
					}
					if (ObjectUtils.isEmpty(item.getProductgrpnmbr())) {
						payload.setNumeroDocumento(0);
					} else {
						final Matcher matcher = Pattern.compile("\\d{1,6}").matcher(String.valueOf(item.getProductgrpnmbr()));
						matcher.find();
						payload.setNumeroDocumento(Integer.valueOf(matcher.group()));
					}
					if (ObjectUtils.isEmpty(item.getMrpprice1())) {
						payload.setValorBaseCalculoPIS(BigDecimal.ZERO);
					} else {
						final String mrpprice1 = item.getMrpprice1().toString().replaceAll("\\W", "");
						if (StringUtils.isEmpty(mrpprice1)) {
							payload.setValorBaseCalculoPIS(BigDecimal.ZERO);
						} else {
							payload.setValorBaseCalculoPIS(new BigDecimal(mrpprice1));
						}
					}
					if (ObjectUtils.isEmpty(item.getMrpprice3())) {
						payload.setValorPIS(BigDecimal.ZERO);
					} else {
						final String mrpprice3 = item.getMrpprice3().toString().replaceAll("\\W", "");
						if (StringUtils.isEmpty(mrpprice3)) {
							payload.setValorPIS(BigDecimal.ZERO);
						} else {
							payload.setValorPIS(new BigDecimal(mrpprice3));
						}
					}
					if (ObjectUtils.isEmpty(item.getMrpprice2())) {
						payload.setValorBaseCalculoCOFINS(BigDecimal.ZERO);
					} else {
						final String mrpprice2 = item.getMrpprice2().toString().replaceAll("\\W", "");
						if (StringUtils.isEmpty(mrpprice2)) {
							payload.setValorBaseCalculoCOFINS(BigDecimal.ZERO);
						} else {
							payload.setValorBaseCalculoCOFINS(new BigDecimal(mrpprice2));
						}
					}
					if (ObjectUtils.isEmpty(item.getMrpprice4())) {
						payload.setValorCOFINS(BigDecimal.ZERO);
					} else {
						final String mrpprice4 = item.getMrpprice4().toString().replaceAll("\\W", "");
						if (StringUtils.isEmpty(mrpprice4)) {
							payload.setValorCOFINS(BigDecimal.ZERO);
						} else {
							payload.setValorCOFINS(new BigDecimal(mrpprice4));
						}
					}
					message.getPayload().add(payload);
				}
			}
		});
		if (!CollectionUtils.isEmpty(message.getPayload())) {
			final Ejtrailer item = this.controleRepository.findByCodigoLojaAndDataExtracao(Integer.valueOf(criteria.getCodigoLoja()), criteria.getDataExtracao(criteria.getDataExtracao()));
			final TipoRodapeControleType rodapeControle = new TipoRodapeControleType();
			if (!ObjectUtils.isEmpty(item)) {
				final Calendar dataEsquemaVendas  = Calendar.getInstance();
				dataEsquemaVendas.setTime(criteria.getDataHoraExtracao(criteria.getDataExtracao()));
				final Calendar dataMovimentacao  = Calendar.getInstance();
				dataMovimentacao.setTime(criteria.getDataExtracao(criteria.getDataExtracao()));
				final DateTimeFormatter rodapeFormatter = DateTimeFormatter.ofPattern("ddMMyy");
				final LocalDateTime rodapeLocalDateTime = LocalDateTime.of(dataEsquemaVendas.get(Calendar.YEAR),dataEsquemaVendas.get(Calendar.MONTH) + 1, dataEsquemaVendas.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
				rodapeControle.setNomeArquivoInterface("DD".concat(rodapeLocalDateTime.format(rodapeFormatter)));
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
