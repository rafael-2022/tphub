package com.dieboldnixdorf.frentecaixa.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

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

import com.dieboldnixdorf.frentecaixa.domain.CabecalhoTransacoesPDVType;
import com.dieboldnixdorf.frentecaixa.domain.CabecalhoType;
import com.dieboldnixdorf.frentecaixa.domain.CodigoLojaType;
import com.dieboldnixdorf.frentecaixa.domain.DataExtracaoType;
import com.dieboldnixdorf.frentecaixa.domain.Ejheader;
import com.dieboldnixdorf.frentecaixa.domain.Ejheader1;
import com.dieboldnixdorf.frentecaixa.domain.Ejitem;
import com.dieboldnixdorf.frentecaixa.domain.Ejmedia;
import com.dieboldnixdorf.frentecaixa.domain.Ejtrailer;
import com.dieboldnixdorf.frentecaixa.domain.TipoItensTransacaoType;
import com.dieboldnixdorf.frentecaixa.domain.TipoLocalVendaType;
import com.dieboldnixdorf.frentecaixa.domain.TipoPagamentoTransacaoType;
import com.dieboldnixdorf.frentecaixa.domain.TipoPagamentosTransacaoType;
import com.dieboldnixdorf.frentecaixa.domain.TransacoesPDVMessageType;
import com.dieboldnixdorf.frentecaixa.domain.TransacoesPDVPayloadType;
import com.dieboldnixdorf.frentecaixa.domain.TransacoesPDVRodapeType;

/**
 * The Class MovimentacoesTransacoesPdvServiceImpl.
 */
@Component("movimentacoesTransacoesPdvService")
@Transactional
class MovimentacoesTransacoesPdvServiceImpl implements MovimentacoesTransacoesPdvService {

	/** The repository. */
	private final MovimentacoesTransacoesPdvRepository repository;
	
	/** The cabecalho repository. */
	private final CabecalhoTransacoesPdvRepository cabecalhoRepository;
	
	/** The item repository. */
	private final ItemTransacoesPdvRepository itemRepository;
	
	/** The forma pagamento repository. */
	private final FormaPagamentoTransacoesPdvRepository formaPagamentoRepository;

	/** The rodape repository. */
	private final RodapeTransacoesPdvRepository rodapeRepository;
	
	/**
	 * Instantiates a new movimentacoes transacoes pdv service impl.
	 *
	 * @param repository the repository
	 * @param cabecalhoRepository the cabecalho repository
	 * @param itemRepository the item repository
	 * @param formaPagamentoRepository the forma pagamento repository
	 * @param rodapeRepository the rodape repository
	 */
	public MovimentacoesTransacoesPdvServiceImpl(final MovimentacoesTransacoesPdvRepository repository, final CabecalhoTransacoesPdvRepository cabecalhoRepository, 
			final ItemTransacoesPdvRepository itemRepository, final FormaPagamentoTransacoesPdvRepository formaPagamentoRepository, final RodapeTransacoesPdvRepository rodapeRepository) {
		this.repository = repository;
		this.cabecalhoRepository = cabecalhoRepository;
		this.itemRepository = itemRepository;
		this.formaPagamentoRepository = formaPagamentoRepository;
		this.rodapeRepository = rodapeRepository;
	}

 	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<TransacoesPDVMessageType> findTransacoesPDV(final MovimentacoesTransacoesPdvSearchCriteria criteria, final Pageable pageable) {
		final List<TransacoesPDVMessageType> messages = new ArrayList<TransacoesPDVMessageType>();
		final CodigoLojaType codigoLoja = new CodigoLojaType();
		codigoLoja.setCodigoLoja(criteria.getCodigoLoja());
		final Page<Ejheader> transacoes = this.repository.findLocalVendaByCodigoLojaAndDataExtracaoAndDataHora(Integer.valueOf(criteria.getCodigoLoja()), 
					criteria.getDataExtracao(criteria.getDataExtracao(criteria.getDataHoraInicial().toLocalDate())),
					criteria.getTimestamp(criteria.getDataHoraInicial()), criteria.getTimestamp(criteria.getDataHoraFinal()), pageable);
		final CabecalhoType cabecalho = new CabecalhoType();
		cabecalho.setCodigoLoja(codigoLoja);
		cabecalho.setTotalPaginas(Long.valueOf(transacoes.getTotalPages()));
		cabecalho.setTotalRegistros(transacoes.getTotalElements());
		cabecalho.setTotalRegistrosPorPagina(Long.valueOf(pageable.getPageSize()));
		final TransacoesPDVMessageType message = new TransacoesPDVMessageType();
		final DataExtracaoType dataExtrtacao = new DataExtracaoType();
		final GregorianCalendar gregorianCalendar = new GregorianCalendar();
		if (!CollectionUtils.isEmpty(transacoes.getContent())) {
			final long count = transacoes.getContent().stream().count();
			final Stream<Ejheader> stream = transacoes.getContent().stream();
			gregorianCalendar.setTime(stream.skip(count - 1).findFirst().get().getOdataproc());
		}
		try {
			final XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
			dataExtrtacao.setDataExtracao(xmlGregorianCalendar);
		} catch (final DatatypeConfigurationException dtcex) {
			dtcex.printStackTrace();
		}		
		cabecalho.setDataExtracao(dataExtrtacao);
		message.setCabecalho(cabecalho);
    
		transacoes.forEach(new Consumer<Ejheader>() {
			@Override
			public void accept(final Ejheader header) { 
				final TipoLocalVendaType localVenda = new TipoLocalVendaType();
				localVenda.setPk(header.getPk().intValue());
			        if (ObjectUtils.isEmpty(header.getLoyaltycardid())) {
			          localVenda.setNumeroDANFE("");
			        } else {
			          localVenda.setNumeroDANFE(header.getLoyaltycardid());
			        }
				if (ObjectUtils.isEmpty(header.getOstorenmbr())) {
					localVenda.setCodigoLoja(0);
				} else {
					final Matcher matcher = Pattern.compile("\\d{1,4}").matcher(String.valueOf(header.getOstorenmbr()));
					matcher.find();
					localVenda.setCodigoLoja(Integer.valueOf(matcher.group()));
				}
				if (ObjectUtils.isEmpty(header.getMngrovnmbr())) {
					localVenda.setNumeroDocumentoFiscal(Long.valueOf(0));
				} else {
					final Matcher matcher = Pattern.compile("\\d{1,9}").matcher(String.valueOf(header.getMngrovnmbr()));
					matcher.find();
					localVenda.setNumeroDocumentoFiscal(Long.valueOf(matcher.group()));
				}
				if (ObjectUtils.isEmpty(header.getDrwrnmbr())) {
					localVenda.setSerieDocumentoFiscal(0);
				} else {
					final Matcher matcher = Pattern.compile("\\d{1,9}").matcher(String.valueOf(header.getDrwrnmbr()));
					matcher.find();
					localVenda.setSerieDocumentoFiscal(Integer.valueOf(matcher.group()));
				}
				if (StringUtils.isEmpty(header.getLoyaltycardid())) {
					localVenda.setNumeroDANFE("");
				} else {
					//final Matcher matcher = Pattern.compile("[a-zA-Z0-9]{1,44}").matcher(header.getLoyaltycardid().replaceAll("\\s+",""));
					//matcher.find();
					localVenda.setNumeroDANFE(header.getLoyaltycardid());
				}
				if (ObjectUtils.isEmpty(header.getMovimentacaoPK().getTransnmbr())) {
					localVenda.setTransacaoLoja(0);
				} else {
					final Matcher matcher = Pattern.compile("\\d{1,5}").matcher(String.valueOf(header.getMovimentacaoPK().getTransnmbr()));
					matcher.find();
					localVenda.setTransacaoLoja(Integer.valueOf(matcher.group()));
				}
				if (ObjectUtils.isEmpty(header.getMovimentacaoPK().getTermnmbr())) {
					localVenda.setCodigoTerminalVenda(0);
				} else {
					final Matcher matcher = Pattern.compile("\\d{1,3}").matcher(String.valueOf(header.getMovimentacaoPK().getTermnmbr()).replaceAll("\\s+", ""));
					matcher.find();
					localVenda.setCodigoTerminalVenda(Integer.valueOf(matcher.group()));
				}
				final Calendar dataVenda  = Calendar.getInstance();
				dataVenda.setTime(header.getMovimentacaoPK().getDatahora_eod());
				localVenda.setDataVenda(dataVenda);
				addCabecalhoTransacao(localVenda, criteria);
				addItemTransacao(localVenda, criteria);
				addFormaPagamento(localVenda, criteria);
				addRodapeTransacao(localVenda, criteria);
				message.getDadosLocalVenda().add(localVenda);
			}
		});
		if (!CollectionUtils.isEmpty(message.getDadosLocalVenda())) {
			messages.add(message);
			/*System.out.println("Total itens = " +  message.getDadosLocalVenda().stream().map(TipoLocalVendaType::getDadosItensTransacao) 
            				.filter(Objects::nonNull) 
            				.mapToInt(List::size) 
            				.count());	*/		
		}
		return messages;
	}
	
	/**
	 * Adds the cabecalho transacao.
	 *
	 * @param localVenda the local venda
	 * @param criteria the criteria
	 */
	protected void addCabecalhoTransacao(final TipoLocalVendaType localVenda, final MovimentacoesTransacoesPdvSearchCriteria criteria) {
		final DateTimeFormatter formatter = new DateTimeFormatterBuilder().appendPattern("dd/MM/yy").parseStrict().toFormatter();
		final LocalDateTime localDateTime =LocalDateTime.of(localVenda.getDataVenda().get(Calendar.YEAR),
				localVenda.getDataVenda().get(Calendar.MONTH) + 1, localVenda.getDataVenda().get(Calendar.DAY_OF_MONTH), 0, 0, 0);
		final String dataVenda = localDateTime.format(formatter);
		final List<Ejheader1> cabecalhos = cabecalhoRepository.findCabecalhoTransacaoByCodigoLojaAndDataExtracao(Integer.valueOf(criteria.getCodigoLoja()), 
				localVenda.getTransacaoLoja(), localVenda.getCodigoTerminalVenda(), dataVenda, localVenda.getNumeroDANFE());
		cabecalhos.forEach(new Consumer<Ejheader1>() {
			@Override
			public void accept(final Ejheader1 header1) {
				final CabecalhoTransacoesPDVType cabecalho = new CabecalhoTransacoesPDVType();
				localVenda.setDrtOperador(header1.getDrtOperador().intValue());
                                localVenda.setNaturezaOperacao(header1.getNaturezaOperacao());
                                localVenda.setTipoEmissao(header1.getTipoEmissao());
                                localVenda.setCodigoPreOrder(header1.getCodigoPreOrder());
                                localVenda.setTipoSaida(header1.getTipoSaida().intValue());
                                localVenda.setCodigoParceiro(header1.getCodigoparceiro().intValue());
                                localVenda.setNomeParceiro(header1.getNomeparceiro());
                                localVenda.setBarcodePedido(header1.getBarcodepedido());
                                
                                localVenda.setTipoPdv(header1.getTipoPdv().intValue());
				cabecalho.setPk(Long.valueOf(localVenda.getPk()));
				if (ObjectUtils.isEmpty(header1.getRectype())) {
					cabecalho.setCodigoTransacaoInterno(0);
				} else {
					final Matcher matcher = Pattern.compile("\\d{1,2}").matcher(String.valueOf(header1.getRectype()).replaceAll("\\s+", ""));
					matcher.find();
					cabecalho.setCodigoTransacaoInterno(Integer.valueOf(matcher.group()));
				}
				if (StringUtils.isEmpty(header1.getPrint1text())) {
					cabecalho.setClienteCPF("");
				} else {
					final String cpfCliente = header1.getPrint1text().trim().replaceAll("\\D+","").replaceAll("\\s+","");
					final Matcher matcher = Pattern.compile("\\d{1,14}").matcher(cpfCliente);
					matcher.find();
					cabecalho.setClienteCPF(matcher.group());
				}
				if (StringUtils.isEmpty(header1.getLoyaltycardid())) {
					cabecalho.setNumeroCartaoCarrefour("");
				} else {
					final Matcher matcher = Pattern.compile("[a-zA-Z0-9\\s+\\*\\_]{1,21}").matcher(header1.getLoyaltycardid().replaceAll("\\s+", ""));
					matcher.find();
					//final String numeroCartao = matcher.group();
					cabecalho.setNumeroCartaoCarrefour(matcher.group());
					/*Boolean ehVISA = Boolean.FALSE;
					if (numeroCartao.startsWith("4")) { // Cartao VISA, aplicar mascara
						if(Pattern.matches("(^[\\d+]{16}$)|(^[\\d+]{13}$)", numeroCartao)) {
							ehVISA = Boolean.TRUE;
							cabecalho.setNumeroCartaoCarrefour(numeroCartao.replaceFirst("^(\\d{1,3})(.+?)", "****").replaceFirst("(^.+)\\d{3}", "$1***"));
						}
					}
					if (!ehVISA) {
						cabecalho.setNumeroCartaoCarrefour(numeroCartao);
					}*/
				}
				if (ObjectUtils.isEmpty(header1.getCshrnmbr())) {
					cabecalho.setRecepcionistaDRT(Long.valueOf(0));
				} else {
					final Matcher matcher = Pattern.compile("\\d{1,11}").matcher(String.valueOf(header1.getCshrnmbr()));
					matcher.find();
					cabecalho.setRecepcionistaDRT(Long.valueOf(matcher.group()));
				}
				if (StringUtils.isEmpty(header1.getPrint2text())) {
					cabecalho.setIdPDVPeriferico(0);
				} else {
					final Matcher matcher = Pattern.compile("[0-9\\s+]{1}").matcher(String.valueOf(header1.getPrint2text().replaceAll("\\s+", "")));
					matcher.find();
					final Map<Integer, Integer> mapaIdPDVPeriferico = new HashMap<Integer, Integer>();
					mapaIdPDVPeriferico.put(1, 1);
					mapaIdPDVPeriferico.put(0, 0);
					if (mapaIdPDVPeriferico.get(Integer.valueOf(matcher.group())) == null) {
						cabecalho.setIdPDVPeriferico(0);
					} else {
						cabecalho.setIdPDVPeriferico(mapaIdPDVPeriferico.get(Integer.valueOf(matcher.group())));
					}
				}
				if (StringUtils.isEmpty(header1.getDisc_empxnmbr())) {
					cabecalho.setCpfClienteCarrefour("");
				} else {
					final String cpfClienteCarrefour = header1.getDisc_empxnmbr().replaceAll("\\D+","").replaceAll("\\s+","");
					final Matcher matcher = Pattern.compile("\\d{1,14}").matcher(cpfClienteCarrefour);
					matcher.find();
					cabecalho.setCpfClienteCarrefour(matcher.group());
				}
				if (StringUtils.isEmpty(header1.getDisc_custnmbr())) {
					cabecalho.setTelefoneCliente("");
				} else {
					final String telefoneCliente = header1.getDisc_custnmbr().replaceAll("\\D+","").replaceAll("\\s+","");
					final Matcher matcher = Pattern.compile("\\d{1,12}").matcher(telefoneCliente);
					matcher.find();
					cabecalho.setTelefoneCliente(matcher.group());
				}
				final ZonedDateTime zone = header1.getDatahora().toInstant().atZone(ZoneId.systemDefault());
				final Matcher matcher = Pattern.compile("\\d{1,4}").matcher(String.format("%02d",zone.getHour()).concat(String.format("%02d",zone.getMinute())));
				matcher.find();
				cabecalho.setHoraMinutoEvento(matcher.group());
				localVenda.getDadosCabecalhoTransacao().add(cabecalho);
			}
		});
	}

	/**
	 * Adds the item transacao.
	 *
	 * @param localVenda the local venda
	 * @param criteria the criteria
	 */
	protected void addItemTransacao(final TipoLocalVendaType localVenda, final MovimentacoesTransacoesPdvSearchCriteria criteria) {
		final DateTimeFormatter formatter = new DateTimeFormatterBuilder().appendPattern("dd/MM/yy").parseStrict().toFormatter();
		final LocalDateTime localDateTime =LocalDateTime.of(localVenda.getDataVenda().get(Calendar.YEAR),
				localVenda.getDataVenda().get(Calendar.MONTH) + 1, localVenda.getDataVenda().get(Calendar.DAY_OF_MONTH), 0, 0, 0);
		final String dataVenda = localDateTime.format(formatter);
		final List<Ejitem> items = itemRepository.findItemTransacaoByCodigoLojaAndDataExtracao(Integer.valueOf(criteria.getCodigoLoja()),  
				localVenda.getTransacaoLoja(), localVenda.getCodigoTerminalVenda(), dataVenda, localVenda.getNumeroDANFE());
		final TipoItensTransacaoType tipoItens = new TipoItensTransacaoType();
		//final AtomicInteger cont = new AtomicInteger();
		//final StringBuilder content = new StringBuilder();
		//content.setLength(0);
		//content.append("TransacaoLoja = " + localVenda.getTransacaoLoja());
		//content.append("\nCodigoTerminalVenda = " + localVenda.getCodigoTerminalVenda());
		//content.append("\nDataVenda = " + dataVenda);
		items.forEach(new Consumer<Ejitem>() {
			@Override
			public void accept(final Ejitem item) {
				//content.append("\nContador = " + cont.getAndIncrement());
				//content.append("\nValor Total Item Tributado = " + item.getMrpprice1());
				final TransacoesPDVPayloadType payload = new TransacoesPDVPayloadType();
				if (ObjectUtils.isEmpty(item.getRectype())) {
					payload.setCodigoTransacaoInterno(0);
				} else {
					final Matcher matcher = Pattern.compile("\\d{1,2}").matcher(String.valueOf(item.getRectype()).replaceAll("\\s+", ""));
					matcher.find();
					payload.setCodigoTransacaoInterno(Integer.valueOf(matcher.group()));
				}
				payload.setPk(Long.valueOf(localVenda.getPk()));
				payload.setImeiProduto(item.getImeiProduto());
				if (StringUtils.isEmpty(item.getEntrynmbr())) {
					payload.setTipoCupomFiscal("");
				} else {
					final Matcher matcher = Pattern.compile("\\d{1,2}").matcher(item.getEntrynmbr().replaceAll("\\s+", ""));
					matcher.find();
					final Map<String, String> mapaTipoCupomFiscal = new HashMap<String, String>();
					mapaTipoCupomFiscal.put("01", "01");
					mapaTipoCupomFiscal.put("02", "02");
					if (mapaTipoCupomFiscal.get(matcher.group()) == null) {
						payload.setTipoCupomFiscal("");
					} else {
						payload.setTipoCupomFiscal(mapaTipoCupomFiscal.get(matcher.group()));
					}
				}
				if (ObjectUtils.isEmpty(item.getReg20PK().getSeq())) {
					payload.setContadorRegistroInterno(0);
				} else {
					payload.setContadorRegistroInterno(item.getReg20PK().getSeq());
				}
				if (StringUtils.isEmpty(item.getReg20PK().getPlunmbr())) {
					payload.setCodigoRMSProduto(Long.valueOf(0));
				} else {
					payload.setCodigoRMSProduto(Long.valueOf(item.getReg20PK().getPlunmbr().replaceAll("\\s+", "")));
				}
				if (StringUtils.isEmpty(item.getPrint1text())) {
					payload.setEanProduto(Long.valueOf(0));
				} else {
					payload.setEanProduto(Long.valueOf(item.getPrint1text().replaceAll("\\s+", "")));
				}
				if (ObjectUtils.isEmpty(item.getMrpprice1())) {
					payload.setValorTotalItemTributado(BigDecimal.ZERO);
				} else {
					final String valorTotalItemTributado = item.getMrpprice1().toString().replaceAll("\\W", "");
					if (StringUtils.isEmpty(valorTotalItemTributado)) {
						payload.setValorTotalItemTributado(BigDecimal.ZERO);
					} else {
						payload.setValorTotalItemTributado(new BigDecimal(valorTotalItemTributado));
					}
				}
				if (ObjectUtils.isEmpty(item.getMrpprice2())) {
					payload.setValorTotalItemSemTributacao(BigDecimal.ZERO);
				} else {
					final String valorTotalItemSemTributacao = item.getMrpprice2().toString().replaceAll("\\W", "");
					if (StringUtils.isEmpty(valorTotalItemSemTributacao)) {
						payload.setValorTotalItemSemTributacao(BigDecimal.ZERO);
					} else {
						payload.setValorTotalItemSemTributacao(new BigDecimal(valorTotalItemSemTributacao));
					}
				}
				if (ObjectUtils.isEmpty(item.getQty1())) {
					payload.setQuantidadeItensVendidos(BigDecimal.ZERO);
				} else {
					final String quantidadeItensVendidos = item.getQty1().toString().replaceAll("\\W", "");
					if (StringUtils.isEmpty(quantidadeItensVendidos)) {
						payload.setQuantidadeItensVendidos(BigDecimal.ZERO);
					} else {
						payload.setQuantidadeItensVendidos(new BigDecimal(quantidadeItensVendidos));
					}
				}
				if (ObjectUtils.isEmpty(item.getPrice1())) {
					payload.setPrecoUnitarioLiquidoItem(BigDecimal.ZERO);
				} else {
					final String precoUnitarioLiquido = item.getPrice1().toString().replaceAll("\\W", "");
					if (StringUtils.isEmpty(precoUnitarioLiquido)) {
						payload.setPrecoUnitarioLiquidoItem(BigDecimal.ZERO);
					} else {
						payload.setPrecoUnitarioLiquidoItem(new BigDecimal(precoUnitarioLiquido));
					}
				}
				if (StringUtils.isEmpty(item.getPludesc())) {
					payload.setTipoDesconto("");
				} else {
					/*final Matcher matcher = Pattern.compile("\\d{1,2}").matcher(String.valueOf(item.getPludesc().replaceAll("\\s+", "")));
					matcher.find();
					final Map<String, String> mapaTipoDesconto = new HashMap<String, String>();
					mapaTipoDesconto.put("00", "00");
					mapaTipoDesconto.put("01", "01");
					mapaTipoDesconto.put("02", "02");
					mapaTipoDesconto.put("03", "03");
					mapaTipoDesconto.put("04", "04");
					mapaTipoDesconto.put("05", "05");
					mapaTipoDesconto.put("06", "06");
					mapaTipoDesconto.put("07", "07");
					mapaTipoDesconto.put("99", "99");
					if (mapaTipoDesconto.get(matcher.group()) == null) {
						payload.setTipoDesconto("");
					} else {
						payload.setTipoDesconto(mapaTipoDesconto.get(matcher.group()));
					}*/
                                        payload.setTipoDesconto(item.getPludesc());
				}
				if (ObjectUtils.isEmpty(item.getSumamtdisc())) {
					payload.setValorTotalDesconto(BigDecimal.ZERO);
				} else {
					final String valorTotalDesconto = item.getSumamtdisc().toString().replaceAll("\\W", "");
					if (StringUtils.isEmpty(valorTotalDesconto)) {
						payload.setValorTotalDesconto(BigDecimal.ZERO);
					} else {
						payload.setValorTotalDesconto(new BigDecimal(valorTotalDesconto));
					}
				}
				if (ObjectUtils.isEmpty(item.getAmtsold())) {
					payload.setPrecoUnitarioBrutoItem(BigDecimal.ZERO);
				} else {
					final String precoUnitarioBruto = item.getAmtsold().toString().replaceAll("\\W", "");
					if (StringUtils.isEmpty(precoUnitarioBruto)) {
						payload.setPrecoUnitarioBrutoItem(BigDecimal.ZERO);
					} else {
						payload.setPrecoUnitarioBrutoItem(new BigDecimal(precoUnitarioBruto));
					}
				}
				if (StringUtils.isEmpty(item.getDeptnmbr())) {
					payload.setCodigoSetorItem(0);
				} else {
					final Matcher matcher = Pattern.compile("\\d{1,3}").matcher(item.getDeptnmbr().replaceAll("\\s+", ""));
					matcher.find();
					payload.setCodigoSetorItem(Integer.valueOf(matcher.group()));
				}
				final ZonedDateTime zone = item.getReg20PK().getDatahora_eod().toInstant().atZone(ZoneId.systemDefault());
				final Matcher matcher = Pattern.compile("\\d{1,4}").matcher(String.format("%02d",zone.getHour()).concat(String.format("%02d",zone.getMinute())));
				matcher.find();
				payload.setHoraMinutoEvento(matcher.group());
				tipoItens.getItemTransacao().add(payload);
			}
		});
		/*try {
			Files.write(Paths.get("/home/albergue/Documents/out/"+localVenda.getTransacaoLoja()+".txt"), content.toString().getBytes());
		} catch (IOException e) {
			System.out.println("NAO CRIOU O ARQUIVO");
		}*/
		if (!CollectionUtils.isEmpty(tipoItens.getItemTransacao())) {
			localVenda.getDadosItensTransacao().add(tipoItens);
		}
	}
	
	/**
	 * Adds the forma pagamento.
	 *
	 * @param localVenda the local venda
	 * @param criteria the criteria
	 */
	protected void addFormaPagamento(final TipoLocalVendaType localVenda, final MovimentacoesTransacoesPdvSearchCriteria criteria) {
		final DateTimeFormatter formatter = new DateTimeFormatterBuilder().appendPattern("dd/MM/yy").parseStrict().toFormatter();
		final LocalDateTime localDateTime =LocalDateTime.of(localVenda.getDataVenda().get(Calendar.YEAR),
				localVenda.getDataVenda().get(Calendar.MONTH) + 1, localVenda.getDataVenda().get(Calendar.DAY_OF_MONTH), 0, 0, 0);
		final String dataVenda = localDateTime.format(formatter);
		final List<Ejmedia> formasPagamento = formaPagamentoRepository.findFormaPagamentoByCodigoLojaAndDataExtracao(Integer.valueOf(criteria.getCodigoLoja()), 
				localVenda.getTransacaoLoja(), localVenda.getCodigoTerminalVenda(), dataVenda, localVenda.getNumeroDANFE());
		final TipoPagamentosTransacaoType pagamentos = new TipoPagamentosTransacaoType();
		formasPagamento.forEach(new Consumer<Ejmedia>() {
			@Override
			public void accept(final Ejmedia media) {
				final TipoPagamentoTransacaoType tipoPagamento = new TipoPagamentoTransacaoType();
				if (ObjectUtils.isEmpty(media.getRectype())) {
					tipoPagamento.setCodigoTransacaoInterno(0);
				} else {
					final Matcher matcher = Pattern.compile("\\d{1,2}").matcher(String.valueOf(media.getRectype()).replaceAll("\\s+", ""));
					matcher.find();
					tipoPagamento.setCodigoTransacaoInterno(Integer.valueOf(matcher.group()));
				}
				tipoPagamento.setPk(Long.valueOf(localVenda.getPk()));
				tipoPagamento.setBandeiraCartao(media.getBandeiraCartao());
				tipoPagamento.setCodigoAutorizacao(media.getCodigoAutorizacao());
				tipoPagamento.setDoc(media.getDoc());
				tipoPagamento.setTipoVenda(media.getTipoVenda());
				tipoPagamento.setNumeroCartao(media.getNumeroCartao());
				tipoPagamento.setQtdeParcelas(media.getQtdeParcelas());
                                if(ObjectUtils.isEmpty(media.getOrdem())) {
                                    tipoPagamento.setSequenciaPagamento(0);
                                }else {
                                    tipoPagamento.setSequenciaPagamento(media.getOrdem());
                                }
				if (ObjectUtils.isEmpty(media.getOmediaamnt())) {
					tipoPagamento.setValorTotalPagamento(BigDecimal.ZERO);
				} else {
					final String valorTotalPagamento = media.getOmediaamnt().toString().replaceAll("\\W", "");
					if (StringUtils.isEmpty(valorTotalPagamento)) {
						tipoPagamento.setValorTotalPagamento(BigDecimal.ZERO);
					} else {
						tipoPagamento.setValorTotalPagamento(new BigDecimal(valorTotalPagamento));
					}
				}
				if (ObjectUtils.isEmpty(media.getReg40PK().getLinenmbr())) {
					tipoPagamento.setNumeroFormaPagamento(0);
				} else {
					final Matcher matcher = Pattern.compile("\\d{1,2}").matcher(String.valueOf(media.getReg40PK().getLinenmbr()));
					matcher.find();
					tipoPagamento.setNumeroFormaPagamento(Integer.valueOf(matcher.group()));
				}
				if (StringUtils.isEmpty(media.getMdesc())) {
					tipoPagamento.setNumeroCartaoCarrefour("");
				} else {
					final Matcher matcher = Pattern.compile("[a-zA-Z0-9\\s+\\*\\_]{1,21}").matcher(media.getMdesc().replaceAll("\\s+", ""));
					matcher.find();
					//final String numeroCartao = matcher.group();
					tipoPagamento.setNumeroCartaoCarrefour(matcher.group());
					/*Boolean ehVISA = Boolean.FALSE;
					if (numeroCartao.startsWith("4")) { // Cartao VISA, aplicar mascara
						if(Pattern.matches("(^[\\d+]{16}$)|(^[\\d+]{13}$)", numeroCartao)) {
							ehVISA = Boolean.TRUE;
							tipoPagamento.setNumeroCartaoCarrefour(numeroCartao.replaceFirst("^(\\d{1,3})(.+?)", "****").replaceFirst("(^.+)\\d{3}", "$1***"));
						}
					}
					if (!ehVISA) {
						tipoPagamento.setNumeroCartaoCarrefour(numeroCartao);
					}*/
				}
				if (StringUtils.isEmpty(media.getDiscountgrpident())) {
					tipoPagamento.setNomeFormaPagamento("");
				} else {
					final Matcher matcher = Pattern.compile("[a-zA-Z0-9\\s+\\p{IsLatin}+]{1,21}").matcher(media.getDiscountgrpident());
					matcher.find();
					tipoPagamento.setNomeFormaPagamento(matcher.group());
				}
				if (ObjectUtils.isEmpty(media.getUserlong())) {
					tipoPagamento.setInformacaoAdicional(0);
				} else {
					final Matcher matcher = Pattern.compile("\\d{1,3}").matcher(String.valueOf(media.getUserlong()));
					matcher.find();
					tipoPagamento.setInformacaoAdicional(Integer.valueOf(matcher.group()));
				}
				final ZonedDateTime zone = media.getReg40PK().getDatahora_eod().toInstant().atZone(ZoneId.systemDefault());
				final Matcher matcher = Pattern.compile("\\d{1,4}").matcher(String.format("%02d",zone.getHour()).concat(String.format("%02d",zone.getMinute())));
				matcher.find();
				tipoPagamento.setHoraMinutoEvento(matcher.group());
				pagamentos.getPagamento().add(tipoPagamento);
			}
		});
		if (!CollectionUtils.isEmpty(pagamentos.getPagamento())) {
			localVenda.getDadosPagamentosTransacao().add(pagamentos);
		}
	}

	/**
	 * Adds the rodape transacao.
	 *
	 * @param localVenda the local venda
	 * @param criteria the criteria
	 */
	protected void addRodapeTransacao(final TipoLocalVendaType localVenda, final MovimentacoesTransacoesPdvSearchCriteria criteria) {
		final DateTimeFormatter formatter = new DateTimeFormatterBuilder().appendPattern("dd/MM/yy").parseStrict().toFormatter();
		final LocalDateTime localDateTime =LocalDateTime.of(localVenda.getDataVenda().get(Calendar.YEAR),
				localVenda.getDataVenda().get(Calendar.MONTH) + 1, localVenda.getDataVenda().get(Calendar.DAY_OF_MONTH), 0, 0, 0);
		final String dataVenda = localDateTime.format(formatter);
		final List<Ejtrailer> itemsRodape = rodapeRepository.findRodapeTransacaoByCodigoLojaAndDataExtracao(Integer.valueOf(criteria.getCodigoLoja()), 
				localVenda.getTransacaoLoja(), localVenda.getCodigoTerminalVenda(), dataVenda, localVenda.getNumeroDANFE());
		itemsRodape.forEach(new Consumer<Ejtrailer>() {
			@Override
			public void accept(final Ejtrailer trailer) {
				final TransacoesPDVRodapeType rodape = new TransacoesPDVRodapeType();
				if (ObjectUtils.isEmpty(trailer.getRectype())) {
					rodape.setCodigoTransacaoInterno(0);
				} else {
					final Matcher matcher = Pattern.compile("\\d{1,2}").matcher(String.valueOf(trailer.getRectype()).replaceAll("\\s+", ""));
					matcher.find();
					rodape.setCodigoTransacaoInterno(Integer.valueOf(matcher.group()));
				}
				rodape.setPk(Long.valueOf(localVenda.getPk()));
				if (ObjectUtils.isEmpty(trailer.getTotalvat())) {
					rodape.setValorTransacaoTotalTributado(BigDecimal.ZERO);
				} else {
					final String valorTransacaoTotalTributado = trailer.getTotalvat().toString().replaceAll("\\W", "");
					if (StringUtils.isEmpty(valorTransacaoTotalTributado)) {
						rodape.setValorTransacaoTotalTributado(BigDecimal.ZERO);
					} else {
						rodape.setValorTransacaoTotalTributado(new BigDecimal(valorTransacaoTotalTributado));
					}
				}
				if (ObjectUtils.isEmpty(trailer.getTotalaos())) {
					rodape.setValorTransacaoTotalNaoTributado(BigDecimal.ZERO);
				} else {
					final String valorTransacaoTotalNaoTributado = trailer.getTotalaos().toString().replaceAll("\\W", "");
					if (StringUtils.isEmpty(valorTransacaoTotalNaoTributado)) {
						rodape.setValorTransacaoTotalNaoTributado(BigDecimal.ZERO);
					} else {
						rodape.setValorTransacaoTotalNaoTributado(new BigDecimal(valorTransacaoTotalNaoTributado));
					}
				}
				if (ObjectUtils.isEmpty(trailer.getTotalrounding())) {
					rodape.setValorTrocoTotal(BigDecimal.ZERO);
				} else {
					final String valorTrocoTotal = trailer.getTotalrounding().toString().replaceAll("\\W", "");
					if (StringUtils.isEmpty(valorTrocoTotal)) {
						rodape.setValorTrocoTotal(BigDecimal.ZERO);
					} else {
						rodape.setValorTrocoTotal(new BigDecimal(valorTrocoTotal));
					}
				}
				final ZonedDateTime zone = trailer.getReg50PK().getDatahora_eod().toInstant().atZone(ZoneId.systemDefault());
				final Matcher matcher = Pattern.compile("\\d{1,4}").matcher(String.format("%02d",zone.getHour()).concat(String.format("%02d",zone.getMinute())));
				matcher.find();
				rodape.setHoraMinutoEvento(matcher.group());
				localVenda.getDadosRodapeTransacao().add(rodape);
			}
		});
	}
	
}
