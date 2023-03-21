package com.dieboldnixdorf.frentecaixa.service;

import java.math.BigDecimal;
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
import com.dieboldnixdorf.frentecaixa.domain.Ejmedia;
import com.dieboldnixdorf.frentecaixa.domain.Ejtrailer;
import com.dieboldnixdorf.frentecaixa.domain.TipoRodapeControleType;
import com.dieboldnixdorf.frentecaixa.domain.VendaContabilMessageType;
import com.dieboldnixdorf.frentecaixa.domain.VendaContabilPayloadType;

/**
 * The Class VendasContabilServiceImpl.
 */
@Component("vendasContabilService")
@Transactional (readOnly=true)
class VendasContabilServiceImpl implements VendasContabilService {

	/** The repository. */
	private final VendasContabilRepository repository;

	/** The controle repository. */
	private final VendasContabilControleRepository controleRepository;

	/**
	 * Instantiates a new vendas contabil service impl.
	 *
	 * @param repository the repository
	 */
	public VendasContabilServiceImpl(final VendasContabilRepository repository, final VendasContabilControleRepository controleRepository) {
		this.repository = repository;
		this.controleRepository = controleRepository;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<VendaContabilMessageType> findVendasContabil(final VendasContabilSearchCriteria criteria, final Pageable pageable) {
		final List<VendaContabilMessageType> messages = new ArrayList<VendaContabilMessageType>();
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
		final Page<Ejmedia> vendas = this.repository.findByCodigoLojaAndDataExtracao(Integer.valueOf(criteria.getCodigoLoja()), criteria.getDataExtracao(criteria.getDataExtracao(criteria.getDataExtracao())), pageable);
		cabecalho.setTotalPaginas(Long.valueOf(vendas.getTotalPages()));
		cabecalho.setTotalRegistros(vendas.getTotalElements());
		cabecalho.setTotalRegistrosPorPagina(Long.valueOf(pageable.getPageSize()));
		final VendaContabilMessageType message = new VendaContabilMessageType();
		message.setCabecalho(cabecalho);
		vendas.forEach(new Consumer<Ejmedia>() {
			@Override
			public void accept(final Ejmedia item) {
				if (!ObjectUtils.isEmpty(item)) {
					final VendaContabilPayloadType payload = new VendaContabilPayloadType();
					if (ObjectUtils.isEmpty(item.getContabilPK()) || ObjectUtils.isEmpty(item.getContabilPK().getTermnmbr())) {
						payload.setNumeroECF(0);
					} else {
						final Matcher matcher = Pattern.compile("\\d{1,3}").matcher(String.valueOf(item.getContabilPK().getTermnmbr()));
						matcher.find();
						payload.setNumeroECF(Integer.valueOf(matcher.group()));
					}
					if (ObjectUtils.isEmpty(item.getContabilPK().getCshrnmbr())) {
						payload.setCodigoOperadora(Long.valueOf(0));
					} else {
						final Matcher matcher = Pattern.compile("\\d{1,10}").matcher(String.valueOf(item.getContabilPK().getCshrnmbr()));
						matcher.find();
						payload.setCodigoOperadora(Long.valueOf(matcher.group()));
					}
					if (ObjectUtils.isEmpty(item.getContabilPK().getMdesc())) {
						payload.setTipoRecebimento(" ");
					} else {
						final Matcher matcher = Pattern.compile("[a-zA-Z0-9\\s+]{1,2}").matcher(String.valueOf(item.getContabilPK().getMdesc()));
						matcher.find();
						payload.setTipoRecebimento(String.valueOf(matcher.group()));
					}
					if (ObjectUtils.isEmpty(item.getMediaamnt())) {
						payload.setValorContabil(BigDecimal.ZERO);
					} else {
						final String mediaamnt = item.getMediaamnt().toString().replaceAll("\\W", "");
						if (StringUtils.isEmpty(mediaamnt)) {
							payload.setValorContabil(BigDecimal.ZERO);
						} else {
							payload.setValorContabil(new BigDecimal(mediaamnt));
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
				rodapeControle.setNomeArquivoInterface("RM".concat(rodapeLocalDateTime.format(rodapeFormatter)));
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
