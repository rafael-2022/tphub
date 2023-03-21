package com.dieboldnixdorf.frentecaixa.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import com.dieboldnixdorf.frentecaixa.domain.CabecalhoTransacoesPDVType;
import com.dieboldnixdorf.frentecaixa.domain.CabecalhoType;
import com.dieboldnixdorf.frentecaixa.domain.CodigoLojaType;
import com.dieboldnixdorf.frentecaixa.domain.DataExtracaoType;
import com.dieboldnixdorf.frentecaixa.domain.DevolucaoCapa;
import com.dieboldnixdorf.frentecaixa.domain.DevolucaoItem;
import com.dieboldnixdorf.frentecaixa.domain.DevolucaoMovimentacao;
import com.dieboldnixdorf.frentecaixa.domain.DevolucaoPagamento;
import com.dieboldnixdorf.frentecaixa.domain.Ejcombustivel;
import com.dieboldnixdorf.frentecaixa.domain.Ejdrogaria;
import com.dieboldnixdorf.frentecaixa.domain.Ejheader;
import com.dieboldnixdorf.frentecaixa.domain.Ejheader1;
import com.dieboldnixdorf.frentecaixa.domain.Ejitem;
import com.dieboldnixdorf.frentecaixa.domain.Ejmedia;
import com.dieboldnixdorf.frentecaixa.domain.Ejservico;
import com.dieboldnixdorf.frentecaixa.domain.Ejtrailer;
import com.dieboldnixdorf.frentecaixa.domain.TipoCombustiveisTransacaoType;
import com.dieboldnixdorf.frentecaixa.domain.TipoCombustivelTransacaoType;
import com.dieboldnixdorf.frentecaixa.domain.TipoDrogariaTransacaoType;
import com.dieboldnixdorf.frentecaixa.domain.TipoDrogariasTransacaoType;
import com.dieboldnixdorf.frentecaixa.domain.TipoItensTransacaoType;
import com.dieboldnixdorf.frentecaixa.domain.TipoLocalVendaType;
import com.dieboldnixdorf.frentecaixa.domain.TipoPagamentoTransacaoType;
import com.dieboldnixdorf.frentecaixa.domain.TipoPagamentosTransacaoType;
import com.dieboldnixdorf.frentecaixa.domain.TipoServicoTransacaoType;
import com.dieboldnixdorf.frentecaixa.domain.TipoServicosTransacaoType;
import com.dieboldnixdorf.frentecaixa.domain.TransacoesPDVMessageType;
import com.dieboldnixdorf.frentecaixa.domain.TransacoesPDVPayloadType;
import com.dieboldnixdorf.frentecaixa.domain.TransacoesPDVRodapeType;
import com.dieboldnixdorf.frentecaixa.payloads.DevolucaoReprocessamentoResponse;
import com.dieboldnixdorf.frentecaixa.payloads.Itens;
import com.dieboldnixdorf.frentecaixa.payloads.Origem;
import com.dieboldnixdorf.frentecaixa.payloads.Pagamentos;

/**
 * The Class MovimentacoesTransacoesPdvServiceImpl.
 */
@Component("movimentacoesTransacoesPdvService")
@Transactional
class MovimentacoesTransacoesPdvServiceImpl implements MovimentacoesTransacoesPdvService {

	/** The repository. */
	private final MovimentacoesTransacoesPdvRepository repository;
	
	private final DevolucaoMovimentacaoRepository repositoryDevolucao;
	
	/** The cabecalho repository. */
	private final CabecalhoTransacoesPdvRepository cabecalhoRepository;
	
	/** The item repository. */
	private final ItemTransacoesPdvRepository itemRepository;
	
	/** The forma pagamento repository. */
	private final FormaPagamentoTransacoesPdvRepository formaPagamentoRepository;

	/** The rodape repository. */
	private final RodapeTransacoesPdvRepository rodapeRepository;
	
	private final CombustivelTransacoesPdvRepository combustivelTransacoesPdvRepository;
	
	private final ServicoTransacoesPdvRepository servicoTransacoesPdvRepository;
	
	private final DrogariaTransacoesPdvRepository drogariaTransacoesPdvRepository;
	
	private final DevolucaoCapaRepository devolucaoCapaRepository;
	
	private final DevolucaoItemRepository devolucaoItemRepository;
	
	private final DevolucaoPagamentoRepository devolucaoPagamentoRepository;
	
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
			final ItemTransacoesPdvRepository itemRepository, final FormaPagamentoTransacoesPdvRepository formaPagamentoRepository, final RodapeTransacoesPdvRepository rodapeRepository, 
			final CombustivelTransacoesPdvRepository combustivelTransacoesPdvRepository,
			final ServicoTransacoesPdvRepository servicoTransacoesPdvRepository,
			final DrogariaTransacoesPdvRepository drogariaTransacoesPdvRepository,
			final DevolucaoMovimentacaoRepository repositoryDevolucao,
			final DevolucaoCapaRepository devolucaoCapaRepository,
			final DevolucaoItemRepository devolucaoItemRepository,
			final DevolucaoPagamentoRepository devolucaoPagamentoRepository) {
		this.repository = repository;
		this.repositoryDevolucao = repositoryDevolucao;
		this.cabecalhoRepository = cabecalhoRepository;
		this.itemRepository = itemRepository;
		this.formaPagamentoRepository = formaPagamentoRepository;
		this.combustivelTransacoesPdvRepository = combustivelTransacoesPdvRepository;
		this.servicoTransacoesPdvRepository = servicoTransacoesPdvRepository;
		this.drogariaTransacoesPdvRepository = drogariaTransacoesPdvRepository;
		this.rodapeRepository = rodapeRepository;
		this.devolucaoCapaRepository = devolucaoCapaRepository;
		this.devolucaoItemRepository = devolucaoItemRepository;
		this.devolucaoPagamentoRepository = devolucaoPagamentoRepository;
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
				
				addServico(localVenda, criteria);
				addCombustivel(localVenda, criteria);
				addDrogaria(localVenda, criteria);
				
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
	
	@Override
	public List<TransacoesPDVMessageType> findReprocessamento(final MovimentacoesTransacoesPdvSearchCriteria criteria, final Pageable pageable) {
		
		final List<TransacoesPDVMessageType> messages = new ArrayList<TransacoesPDVMessageType>();
		final CodigoLojaType codigoLoja = new CodigoLojaType();
		codigoLoja.setCodigoLoja(criteria.getCodigoLoja());

		
		final Page<Ejheader> transacoes = 
				this.repository.findLocalVendaByReprocessamento(
											criteria.getDataExtracao(criteria.getDataExtracao(criteria.getDataHoraInicial().toLocalDate())),					
											Integer.valueOf(criteria.getCodigoLoja()),
											criteria.getPdv(),
											criteria.getTransacao(),
											criteria.getDanfe(),
											criteria.getTipo(),
											pageable);
		

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
				
				addServico(localVenda, criteria);
				addCombustivel(localVenda, criteria);
				addDrogaria(localVenda, criteria);
				
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
	
	@Override
	public List<DevolucaoReprocessamentoResponse> findDevolucaoReprocessamento(
			MovimentacoesTransacoesPdvSearchCriteria criteria, Pageable pageable) {
		
		List<DevolucaoReprocessamentoResponse> responses = new ArrayList<DevolucaoReprocessamentoResponse>();

		final List<DevolucaoMovimentacao> transacoes = 
				this.repositoryDevolucao.findLocalDevolucaoByReprocessamento(
											criteria.getDataExtracao(criteria.getDataExtracao(criteria.getDataHoraInicial().toLocalDate())),					
											Integer.valueOf(criteria.getCodigoLoja()),
											criteria.getPdv(),
											criteria.getDanfe(),
											criteria.getTipo());
		
		
		for (DevolucaoMovimentacao movimentacao: transacoes) {
			final List<DevolucaoCapa> capas = devolucaoCapaRepository.findCapaByCodigoLojaAndMatriculaAndDataExtracao(movimentacao.getStorenmbr(), 
																														movimentacao.getMatricula(), 
																														movimentacao.getBdate(), 
																														movimentacao.getBdatepdv());

			if (Objects.nonNull(capas) && capas.size() > 0) {
				DevolucaoCapa capa = capas.get(0);
				
				List<DevolucaoItem> items = devolucaoItemRepository.findItemByCodigoLojaAndMatriculaAndDataExtracao(movimentacao.getStorenmbr(), 
																															movimentacao.getMatricula(), 
																															movimentacao.getBdate(), 
																															movimentacao.getBdatepdv());


				List<Itens> resultItems = new ArrayList<Itens>();
				
				if (Objects.nonNull(items) && items.size() > 0) {
					for (DevolucaoItem item: items) {
						Itens itens = Itens.builder()
								.contadorRegistroInterno(item.getContadorregistrointerno())
								.codigoRMSproduto(item.getCodigormsproduto())
								.eanProduto(item.getEanproduto())
								.codigoSetor(item.getCodigosetor())
								.devolucaoComCupom(item.getDevolucaocomcupom())
								.valorTotalItemIMPOSTODEBITADO(getValor(item.getValortotalitemimpostodebitado()))
								.numeroMatricula(item.getNumeromatricula())
								.valorTotalItemBASECALCPIS(getValor(item.getValortotalitembasecalcpis()))
								.valorTotalItemPIS(getValor(item.getValortotalitempis()))
								.valorTotalItemBASECALCCOFINS(getValor(item.getValortotalitembasecalccofins()))
								.valorTotalItemCOFINS(getValor(item.getValortotalitemcofins()))
								.TipoServico(item.getTiposervico())
								.codigoServico(item.getCodigoservico())
								.codigoFornecedor(item.getCodigofornecedor())
								.quantidadeItensDevolvidos(item.getQuantidadeitensdevolvidos())
								.valorUnitarioDevolvidos(getValor(item.getValorunitariodevolvidos()))
								.valorTotalDevolvido(getValor(item.getValortotaldevolvido()))
								.horaMinutoEvento(item.getHoraminutoevento())
								.status(item.getStatus())
								.build();
						
						resultItems.add(itens);
					}
				}

				
				
				
				DevolucaoReprocessamentoResponse response = DevolucaoReprocessamentoResponse.builder()
		    			.codigoLoja(capa.getCodigoloja())
						.CNPJEmissor(capa.getCnpjemissor())
						.dataDevolucao(capa.getDatadevolucao().toString())
						.numeroDocumentoFiscal(capa.getNumerodocumentofiscal())
						.serieDocumentoFiscal(capa.getSeriedocumentofiscal())
						.numeroDANFE(capa.getNumeroDANFE())
						.transacaoLoja(capa.getTransacaoloja())
						.codigoTerminalVenda(capa.getCodigoterminalvenda())
						.ClienteCPF_NF(capa.getClientecpf_nf())
						.ClienteCPF_MeuCARREFOUR(capa.getClientecpf_meucarrefour())
						.numeroPreOrder(capa.getNumpreorder())
						.codigoVendedor(capa.getCodvendedor())
						.recepcionistaDRT(capa.getRecepcionistadrt())
						.codigoEventoDevolucao(capa.getCodigoeventodevolucao())
						.tipoEvento(capa.getTipoevento())
						.operacaoVenda(capa.getOperacaovenda())
						.origem(getOrigem(capa))
						.pdvresgate(capa.getPdvresgate())
						.transacaoresgate(capa.getTransacaoresgate())
						.datahoraresgate(capa.getDatahoraresgate())
						.operadorresgate(capa.getOperadorresgate())
						.valorresgate(capa.getValorresgate())
						.itens(resultItems)
						.pagamentos(getPagamentos(movimentacao))
						.build();
				
				responses.add(response);
			}
		}

		return responses;
	}
	
	private Origem getOrigem(DevolucaoCapa capa) {
		
		String clienteCpf = " ";
		if (Objects.nonNull(capa.getClientecpf_nforigem()) &&
				!capa.getClientecpf_nforigem().equals("")) {
			clienteCpf = capa.getClientecpf_nforigem();
		}
		String clienteCpfCarrefour = " ";
		if (Objects.nonNull(capa.getClientecpf_meucarrefourorigem()) &&
				!capa.getClientecpf_meucarrefourorigem().equals("")) {
			clienteCpfCarrefour = capa.getClientecpf_meucarrefourorigem();
		}
		
		Origem origem = Origem.builder()
				.codigoLoja(capa.getCodigoloja())
				.CNPJEmissor(capa.getCnpjemissor())
				.dataVenda(capa.getDatadevolucao().toString())
				.numeroDocumentoFiscal(capa.getNumerodocumentofiscal())
				.serieDocumentoFiscal(capa.getSeriedocumentofiscal())
				.codigoTerminalVenda(capa.getCodigoterminalvenda())
				.transacaoLoja(capa.getTransacaoloja())
				.numeroDANFE(capa.getNumerodanfeorigem())
				.ClienteCPF_NF(clienteCpf)
				.ClienteCPF_MeuCARREFOUR(clienteCpfCarrefour)
				.numeroPreOrder(capa.getNumpreorder())
				.codigoVendedor(capa.getCodvendedor())
				.build();
		
		return origem;
	}
	
	private List<Itens> getItems(DevolucaoMovimentacao movimentacao) {

		List<DevolucaoItem> items = devolucaoItemRepository.findItemByCodigoLojaAndMatriculaAndDataExtracao(movimentacao.getStorenmbr(), 
																													movimentacao.getMatricula(), 
																													movimentacao.getBdate(), 
																													movimentacao.getBdatepdv());




		List<Itens> result = new ArrayList<Itens>();
		
		if (Objects.nonNull(items) && items.size() > 0) {
			for (DevolucaoItem item: items) {
				Itens itens = Itens.builder()
						.contadorRegistroInterno(item.getContadorregistrointerno())
						.codigoRMSproduto(item.getCodigormsproduto())
						.eanProduto(item.getEanproduto())
						.codigoSetor(item.getCodigosetor())
						.devolucaoComCupom(item.getDevolucaocomcupom())
						.valorTotalItemIMPOSTODEBITADO(getValor(item.getValortotalitemimpostodebitado()))
						.numeroMatricula(item.getNumeromatricula())
						.valorTotalItemBASECALCPIS(getValor(item.getValortotalitembasecalcpis()))
						.valorTotalItemPIS(getValor(item.getValortotalitempis()))
						.valorTotalItemBASECALCCOFINS(getValor(item.getValortotalitembasecalccofins()))
						.valorTotalItemCOFINS(getValor(item.getValortotalitemcofins()))
						.TipoServico(item.getTiposervico())
						.codigoServico(item.getCodigoservico())
						.codigoFornecedor(item.getCodigofornecedor())
						.quantidadeItensDevolvidos(item.getQuantidadeitensdevolvidos())
						.valorUnitarioDevolvidos(getValor(item.getValorunitariodevolvidos()))
						.valorTotalDevolvido(getValor(item.getValortotaldevolvido()))
						.horaMinutoEvento(item.getHoraminutoevento())
						.build();
				
				result.add(itens);
			}
		}
		
		return result;
	}
	
	private List<Pagamentos> getPagamentos(DevolucaoMovimentacao movimentacao) {
		
		final List<DevolucaoPagamento> pagamentos = devolucaoPagamentoRepository.findPagamentoByCodigoLojaAndMatriculaAndDataExtracao(movimentacao.getStorenmbr(), 
																																		movimentacao.getMatricula(), 
																																		movimentacao.getBdate(), 
																																		movimentacao.getBdatepdv());



		List<Pagamentos> result = new ArrayList<Pagamentos>();
		
		if (Objects.nonNull(pagamentos) && pagamentos.size() > 0) {
			for (DevolucaoPagamento pagamento: pagamentos) {
				Pagamentos pagto = Pagamentos.builder()
						.contadorRegistroInterno(pagamento.getContadorregistrointerno())
						.codigoRMSProduto(pagamento.getCodigormsproduto())
						.eanProduto(pagamento.getEanproduto())
						.quantidadeFormasPgto(pagamento.getQuantidadeformaspgto())
						.categoriaFormaPgto(pagamento.getCategoriaformapgto())
						.valorFormaPgto(getValor(pagamento.getValorformapgto()))
						.horaMinutoEvento(pagamento.getHoraminutoevento())
						.build();
				
				result.add(pagto);
			}
		}
		
		return result;
	}
	
	private BigDecimal getValor(Long valor) {
		
		if (ObjectUtils.isEmpty(valor)) {
			return BigDecimal.ZERO;
		} else {
			final String strValor = valor.toString().replaceAll("\\W", "");
			if (StringUtils.isEmpty(strValor)) {
				return BigDecimal.ZERO;
			} else {
				return new BigDecimal(strValor);
			}
		}
		
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
				
				localVenda.setSiglaLoja(header1.getSiglaLoja());
				localVenda.setNomeOperador(header1.getNomeOperador());
				localVenda.setPerfilOperador(header1.getPerfilOperador().intValue());
				
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
				
				
				//Implementação novos campos
				
				if (ObjectUtils.isEmpty(item.getValorTotalTEFPromocao())) {
					payload.setValorTotalTEFPromocao(BigDecimal.ZERO);
				} else {
					final String valorTotalTEFPromocao = item.getValorTotalTEFPromocao().toString().replaceAll("\\W", "");
					if (StringUtils.isEmpty(valorTotalTEFPromocao)) {
						payload.setValorTotalTEFPromocao(BigDecimal.ZERO);
					} else {
						payload.setValorTotalTEFPromocao(new BigDecimal(valorTotalTEFPromocao));
					}
				}
				
				if (ObjectUtils.isEmpty(item.getValorTotalItemICMS())) {
					payload.setValorTotalItemICMS(BigDecimal.ZERO);
				} else {
					final String valorTotalItemICMS = item.getValorTotalItemICMS().toString().replaceAll("\\W", "");
					if (StringUtils.isEmpty(valorTotalItemICMS)) {
						payload.setValorTotalItemICMS(BigDecimal.ZERO);
					} else {
						payload.setValorTotalItemICMS(new BigDecimal(valorTotalItemICMS));
					}
				}
				
				if (ObjectUtils.isEmpty(item.getValorTotalItemBaseCalcPIS())) {
					payload.setValorTotalItemBaseCalcPIS(BigDecimal.ZERO);
				} else {
					final String valorTotalItemBaseCalcPIS = item.getValorTotalItemBaseCalcPIS().toString().replaceAll("\\W", "");
					if (StringUtils.isEmpty(valorTotalItemBaseCalcPIS)) {
						payload.setValorTotalItemBaseCalcPIS(BigDecimal.ZERO);
					} else {
						payload.setValorTotalItemBaseCalcPIS(new BigDecimal(valorTotalItemBaseCalcPIS));
					}
				}
				
				if (ObjectUtils.isEmpty(item.getValorTotalItemBaseCalcCOFINS())) {
					payload.setValorTotalItemBaseCalcCOFINS(BigDecimal.ZERO);
				} else {
					final String valorTotalItemBaseCalcCOFINS = item.getValorTotalItemBaseCalcCOFINS().toString().replaceAll("\\W", "");
					if (StringUtils.isEmpty(valorTotalItemBaseCalcCOFINS)) {
						payload.setValorTotalItemBaseCalcCOFINS(BigDecimal.ZERO);
					} else {
						payload.setValorTotalItemBaseCalcCOFINS(new BigDecimal(valorTotalItemBaseCalcCOFINS));
					}
				}
				
				if (ObjectUtils.isEmpty(item.getValorTotalItemBaseCalcPIS())) {
					payload.setValorTotalItemBaseCalcPIS(BigDecimal.ZERO);
				} else {
					final String valorTotalItemPIS = item.getValorTotalItemBaseCalcPIS().toString().replaceAll("\\W", "");
					if (StringUtils.isEmpty(valorTotalItemPIS)) {
						payload.setValorTotalItemBaseCalcPIS(BigDecimal.ZERO);
					} else {
						payload.setValorTotalItemBaseCalcPIS(new BigDecimal(valorTotalItemPIS));
					}
				}
				
				if (ObjectUtils.isEmpty(item.getValorTotalItemBaseCalcCOFINS())) {
					payload.setValorTotalItemBaseCalcCOFINS(BigDecimal.ZERO);
				} else {
					final String valorTotalItemCOFINS = item.getValorTotalItemBaseCalcCOFINS().toString().replaceAll("\\W", "");
					if (StringUtils.isEmpty(valorTotalItemCOFINS)) {
						payload.setValorTotalItemBaseCalcCOFINS(BigDecimal.ZERO);
					} else {
						payload.setValorTotalItemBaseCalcCOFINS(new BigDecimal(valorTotalItemCOFINS));
					}
				}
				
				if (ObjectUtils.isEmpty(item.getValorPercentualAliquotaFiscal())) {
					payload.setValorPercentualAliquotaFiscal(BigDecimal.ZERO);
				} else {
					final String valorPercentualAliquotaFiscal = item.getValorPercentualAliquotaFiscal().toString().replaceAll("\\W", "");
					if (StringUtils.isEmpty(valorPercentualAliquotaFiscal)) {
						payload.setValorPercentualAliquotaFiscal(BigDecimal.ZERO);
					} else {
						payload.setValorPercentualAliquotaFiscal(new BigDecimal(valorPercentualAliquotaFiscal));
					}
				}
				
				if (ObjectUtils.isEmpty(item.getAliquotaFCP())) {
					payload.setAliquotaFCP(BigDecimal.ZERO);
				} else {
					final String aliquotaFCP = item.getAliquotaFCP().toString().replaceAll("\\W", "");
					if (StringUtils.isEmpty(aliquotaFCP)) {
						payload.setAliquotaFCP(BigDecimal.ZERO);
					} else {
						payload.setAliquotaFCP(new BigDecimal(aliquotaFCP));
					}
				}
				
				if (ObjectUtils.isEmpty(item.getValorFCP())) {
					payload.setValorFCP(BigDecimal.ZERO);
				} else {
					final String valorFCP = item.getValorFCP().toString().replaceAll("\\W", "");
					if (StringUtils.isEmpty(valorFCP)) {
						payload.setValorFCP(BigDecimal.ZERO);
					} else {
						payload.setValorFCP(new BigDecimal(valorFCP));
					}
				}
				
				if (ObjectUtils.isEmpty(item.getValorBaseCalcSTRetido())) {
					payload.setValorBaseCalcSTRetido(BigDecimal.ZERO);
				} else {
					final String valorBaseCalcSTRetido = item.getValorBaseCalcSTRetido().toString().replaceAll("\\W", "");
					if (StringUtils.isEmpty(valorBaseCalcSTRetido)) {
						payload.setValorBaseCalcSTRetido(BigDecimal.ZERO);
					} else {
						payload.setValorBaseCalcSTRetido(new BigDecimal(valorBaseCalcSTRetido));
					}
				}
				
				if (ObjectUtils.isEmpty(item.getAliquotaConsumidorFinal())) {
					payload.setAliquotaConsumidorFinal(BigDecimal.ZERO);
				} else {
					final String aliquotaConsumidorFinal = item.getAliquotaConsumidorFinal().toString().replaceAll("\\W", "");
					if (StringUtils.isEmpty(aliquotaConsumidorFinal)) {
						payload.setAliquotaConsumidorFinal(BigDecimal.ZERO);
					} else {
						payload.setAliquotaConsumidorFinal(new BigDecimal(aliquotaConsumidorFinal));
					}
				}
				
				if (ObjectUtils.isEmpty(item.getValorBaseCalcFCPSTRetido())) {
					payload.setValorBaseCalcFCPSTRetido(BigDecimal.ZERO);
				} else {
					final String valorSTRetido = item.getValorBaseCalcFCPSTRetido().toString().replaceAll("\\W", "");
					if (StringUtils.isEmpty(valorSTRetido)) {
						payload.setValorBaseCalcFCPSTRetido(BigDecimal.ZERO);
					} else {
						payload.setValorBaseCalcFCPSTRetido(new BigDecimal(valorSTRetido));
					}
				}
				
				if (ObjectUtils.isEmpty(item.getPercFCPSTRetido())) {
					payload.setPercFCPSTRetido(BigDecimal.ZERO);
				} else {
					final String percFCPSTRetido = item.getPercFCPSTRetido().toString().replaceAll("\\W", "");
					if (StringUtils.isEmpty(percFCPSTRetido)) {
						payload.setPercFCPSTRetido(BigDecimal.ZERO);
					} else {
						payload.setPercFCPSTRetido(new BigDecimal(percFCPSTRetido));
					}
				}
				
				//valorSTRetido
				if (ObjectUtils.isEmpty(item.getValorSTRetido())) {
					payload.setValorSTRetido(BigDecimal.ZERO);
				} else {
					final String valorSTRetido = item.getValorSTRetido().toString().replaceAll("\\W", "");
					if (StringUtils.isEmpty(valorSTRetido)) {
						payload.setValorSTRetido(BigDecimal.ZERO);
					} else {
						payload.setValorSTRetido(new BigDecimal(valorSTRetido));
					}
				}
				
				//valorTotalItemPIS
				if (ObjectUtils.isEmpty(item.getValorTotalItemPIS())) {
					payload.setValorTotalItemPIS(BigDecimal.ZERO);
				} else {
					final String valorTotalItemPis = item.getValorTotalItemPIS().toString().replaceAll("\\W", "");
					if (StringUtils.isEmpty(valorTotalItemPis)) {
						payload.setValorTotalItemPIS(BigDecimal.ZERO);
					} else {
						payload.setValorTotalItemPIS(new BigDecimal(valorTotalItemPis));
					}
				}
				
				//valorTotalItemCOFINS
				if (ObjectUtils.isEmpty(item.getValorTotalItemCOFINS())) {
					payload.setValorTotalItemCOFINS(BigDecimal.ZERO);
				} else {
					final String valorTotalItemConfins = item.getValorTotalItemCOFINS().toString().replaceAll("\\W", "");
					if (StringUtils.isEmpty(valorTotalItemConfins)) {
						payload.setValorTotalItemCOFINS(BigDecimal.ZERO);
					} else {
						payload.setValorTotalItemCOFINS(new BigDecimal(valorTotalItemConfins));
					}
				}
				
				
				if (ObjectUtils.isEmpty(item.getPercRedBaseCalcEfet())) {
					payload.setPercRedBaseCalcEfet(BigDecimal.ZERO);
				} else {
					final String percRedBaseCalcEfet = item.getPercRedBaseCalcEfet().toString().replaceAll("\\W", "");
					if (StringUtils.isEmpty(percRedBaseCalcEfet)) {
						payload.setPercRedBaseCalcEfet(BigDecimal.ZERO);
					} else {
						payload.setPercRedBaseCalcEfet(new BigDecimal(percRedBaseCalcEfet));
					}
				}
				
				if (ObjectUtils.isEmpty(item.getValorBaseCalcEfet())) {
					payload.setValorBaseCalcEfet(BigDecimal.ZERO);
				} else {
					final String valorBaseCalcEfet = item.getValorBaseCalcEfet().toString().replaceAll("\\W", "");
					if (StringUtils.isEmpty(valorBaseCalcEfet)) {
						payload.setValorBaseCalcEfet(BigDecimal.ZERO);
					} else {
						payload.setValorBaseCalcEfet(new BigDecimal(valorBaseCalcEfet));
					}
				}
				
				if (ObjectUtils.isEmpty(item.getAliquotaICMSEfet())) {
					payload.setAliquotaICMSEfet(BigDecimal.ZERO);
				} else {
					final String aliquotaICMSEfet = item.getAliquotaICMSEfet().toString().replaceAll("\\W", "");
					if (StringUtils.isEmpty(aliquotaICMSEfet)) {
						payload.setAliquotaICMSEfet(BigDecimal.ZERO);
					} else {
						payload.setAliquotaICMSEfet(new BigDecimal(aliquotaICMSEfet));
					}
				}
				
				if (ObjectUtils.isEmpty(item.getValorICMSEfet())) {
					payload.setValorICMSEfet(BigDecimal.ZERO);
				} else {
					final String valorICMSEfet = item.getValorICMSEfet().toString().replaceAll("\\W", "");
					if (StringUtils.isEmpty(valorICMSEfet)) {
						payload.setValorICMSEfet(BigDecimal.ZERO);
					} else {
						payload.setValorICMSEfet(new BigDecimal(valorICMSEfet));
					}
				}
				
				if (ObjectUtils.isEmpty(item.getAliquotaISS())) {
					payload.setAliquotaISS(BigDecimal.ZERO);
				} else {
					final String aliquotaISS = item.getAliquotaISS().toString().replaceAll("\\W", "");
					if (StringUtils.isEmpty(aliquotaISS)) {
						payload.setAliquotaISS(BigDecimal.ZERO);
					} else {
						payload.setAliquotaISS(new BigDecimal(aliquotaISS));
					}
				}
				
				if (ObjectUtils.isEmpty(item.getAliquotaIPI())) {
					payload.setAliquotaIPI(BigDecimal.ZERO);
				} else {
					final String aliquotaIPI = item.getAliquotaIPI().toString().replaceAll("\\W", "");
					if (StringUtils.isEmpty(aliquotaIPI)) {
						payload.setAliquotaIPI(BigDecimal.ZERO);
					} else {
						payload.setAliquotaIPI(new BigDecimal(aliquotaIPI));
					}
				}
				
				if (ObjectUtils.isEmpty(item.getAliquotaImpostoMunicipal())) {
					payload.setAliquotaImpostoMunicipal(BigDecimal.ZERO);
				} else {
					final String aliquotaImpostoMunicipal = item.getAliquotaImpostoMunicipal().toString().replaceAll("\\W", "");
					if (StringUtils.isEmpty(aliquotaImpostoMunicipal)) {
						payload.setAliquotaImpostoMunicipal(BigDecimal.ZERO);
					} else {
						payload.setAliquotaImpostoMunicipal(new BigDecimal(aliquotaImpostoMunicipal));
					}
				}
				
				if (ObjectUtils.isEmpty(item.getAliquotaImpostoEstadual())) {
					payload.setAliquotaImpostoEstadual(BigDecimal.ZERO);
				} else {
					final String aliquotaImpostoEstadual = item.getAliquotaImpostoEstadual().toString().replaceAll("\\W", "");
					if (StringUtils.isEmpty(aliquotaImpostoEstadual)) {
						payload.setAliquotaImpostoEstadual(BigDecimal.ZERO);
					} else {
						payload.setAliquotaImpostoEstadual(new BigDecimal(aliquotaImpostoEstadual));
					}
				}
				
				if (ObjectUtils.isEmpty(item.getAliquotaImpostoFederal())) {
					payload.setAliquotaImpostoFederal(BigDecimal.ZERO);
				} else {
					final String aliquotaImpostoFederal = item.getAliquotaImpostoFederal().toString().replaceAll("\\W", "");
					if (StringUtils.isEmpty(aliquotaImpostoFederal)) {
						payload.setAliquotaImpostoFederal(BigDecimal.ZERO);
					} else {
						payload.setAliquotaImpostoFederal(new BigDecimal(aliquotaImpostoFederal));
					}
				}
				
				if (ObjectUtils.isEmpty(item.getValorISS())) {
					payload.setValorISS(BigDecimal.ZERO);
				} else {
					final String valorISS = item.getValorISS().toString().replaceAll("\\W", "");
					if (StringUtils.isEmpty(valorISS)) {
						payload.setValorISS(BigDecimal.ZERO);
					} else {
						payload.setValorISS(new BigDecimal(valorISS));
					}
				}
				
				if (ObjectUtils.isEmpty(item.getValorIPI())) {
					payload.setValorIPI(BigDecimal.ZERO);
				} else {
					final String valorIPI = item.getValorIPI().toString().replaceAll("\\W", "");
					if (StringUtils.isEmpty(valorIPI)) {
						payload.setValorIPI(BigDecimal.ZERO);
					} else {
						payload.setValorIPI(new BigDecimal(valorIPI));
					}
				}
				
				if (ObjectUtils.isEmpty(item.getValorImpostoMunicipal())) {
					payload.setValorImpostoMunicipal(BigDecimal.ZERO);
				} else {
					final String valorImpostoMunicipal = item.getValorImpostoMunicipal().toString().replaceAll("\\W", "");
					if (StringUtils.isEmpty(valorImpostoMunicipal)) {
						payload.setValorImpostoMunicipal(BigDecimal.ZERO);
					} else {
						payload.setValorImpostoMunicipal(new BigDecimal(valorImpostoMunicipal));
					}
				}
				
				if (ObjectUtils.isEmpty(item.getValorImpostoEstadual())) {
					payload.setValorImpostoEstadual(BigDecimal.ZERO);
				} else {
					final String valorImpostoEstadual = item.getValorImpostoEstadual().toString().replaceAll("\\W", "");
					if (StringUtils.isEmpty(valorImpostoEstadual)) {
						payload.setValorImpostoEstadual(BigDecimal.ZERO);
					} else {
						payload.setValorImpostoEstadual(new BigDecimal(valorImpostoEstadual));
					}
				}
				
				if (ObjectUtils.isEmpty(item.getValorImpostoFederal())) {
					payload.setValorImpostoFederal(BigDecimal.ZERO);
				} else {
					final String valorImpostoFederal = item.getValorImpostoFederal().toString().replaceAll("\\W", "");
					if (StringUtils.isEmpty(valorImpostoFederal)) {
						payload.setValorImpostoFederal(BigDecimal.ZERO);
					} else {
						payload.setValorImpostoFederal(new BigDecimal(valorImpostoFederal));
					}
				}
				
				if (ObjectUtils.isEmpty(item.getCodigoCSTICMS())) {
					payload.setCodigoCSTICMS(BigDecimal.ZERO);
				} else {
					final String codigoCSTICMS = item.getCodigoCSTICMS().toString().replaceAll("\\W", "");
					if (StringUtils.isEmpty(codigoCSTICMS)) {
						payload.setCodigoCSTICMS(BigDecimal.ZERO);
					} else {
						payload.setCodigoCSTICMS(new BigDecimal(codigoCSTICMS));
					}
				}
				
				if (ObjectUtils.isEmpty(item.getAliquotaICMSDeson())) {
					payload.setAliquotaICMSDeson(BigDecimal.ZERO);
				} else {
					final String aliquotaICMSDeson = item.getAliquotaICMSDeson().toString().replaceAll("\\W", "");
					if (StringUtils.isEmpty(aliquotaICMSDeson)) {
						payload.setAliquotaICMSDeson(BigDecimal.ZERO);
					} else {
						payload.setAliquotaICMSDeson(new BigDecimal(aliquotaICMSDeson));
					}
				}
				
				if (ObjectUtils.isEmpty(item.getValorREDBaseCalcDeson())) {
					payload.setValorREDBaseCalcDeson(BigDecimal.ZERO);
				} else {
					final String valorREDBaseCalcDeson = item.getValorREDBaseCalcDeson().toString().replaceAll("\\W", "");
					if (StringUtils.isEmpty(valorREDBaseCalcDeson)) {
						payload.setValorREDBaseCalcDeson(BigDecimal.ZERO);
					} else {
						payload.setValorREDBaseCalcDeson(new BigDecimal(valorREDBaseCalcDeson));
					}
				}
				
				if (ObjectUtils.isEmpty(item.getMotivoDeson())) {
					payload.setMotivoDeson(BigDecimal.ZERO);
				} else {
					final String motivoDeson = item.getMotivoDeson().toString().replaceAll("\\W", "");
					if (StringUtils.isEmpty(motivoDeson)) {
						payload.setMotivoDeson(BigDecimal.ZERO);
					} else {
						payload.setMotivoDeson(new BigDecimal(motivoDeson));
					}
				}
				
				if (ObjectUtils.isEmpty(item.getValorICMSDeson())) {
					payload.setValorICMSDeson(BigDecimal.ZERO);
				} else {
					final String valorICMSDeson = item.getValorICMSDeson().toString().replaceAll("\\W", "");
					if (StringUtils.isEmpty(valorICMSDeson)) {
						payload.setValorICMSDeson(BigDecimal.ZERO);
					} else {
						payload.setValorICMSDeson(new BigDecimal(valorICMSDeson));
					}
				}
				
				
				
				if (ObjectUtils.isEmpty(item.getAliquotaPIS())) {
					payload.setAliquotaPIS(BigDecimal.ZERO);
				} else {
					final String aliquotaPIS = item.getAliquotaPIS().toString().replaceAll("\\W", "");
					if (StringUtils.isEmpty(aliquotaPIS)) {
						payload.setAliquotaPIS(BigDecimal.ZERO);
					} else {
						payload.setAliquotaPIS(new BigDecimal(aliquotaPIS));
					}
				}
				
				if (ObjectUtils.isEmpty(item.getAliquotaCOFINS())) {
					payload.setAliquotaCOFINS(BigDecimal.ZERO);
				} else {
					final String aliquotaCOFINS = item.getAliquotaCOFINS().toString().replaceAll("\\W", "");
					if (StringUtils.isEmpty(aliquotaCOFINS)) {
						payload.setAliquotaCOFINS(BigDecimal.ZERO);
					} else {
						payload.setAliquotaCOFINS(new BigDecimal(aliquotaCOFINS));
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
				tipoPagamento.setNumeroMatricula(media.getNumeroMatricula());
				tipoPagamento.setCodigoNsuSitef(media.getCodigoNsuSitef());
				
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
	
	protected void addCombustivel(final TipoLocalVendaType localVenda, final MovimentacoesTransacoesPdvSearchCriteria criteria) {
		
		final DateTimeFormatter formatter = new DateTimeFormatterBuilder().appendPattern("dd/MM/yy").parseStrict().toFormatter();
		final LocalDateTime localDateTime =LocalDateTime.of(localVenda.getDataVenda().get(Calendar.YEAR),
				localVenda.getDataVenda().get(Calendar.MONTH) + 1, localVenda.getDataVenda().get(Calendar.DAY_OF_MONTH), 0, 0, 0);
		final String dataVenda = localDateTime.format(formatter);
		
		final List<Ejcombustivel> combustivelDetalhe = combustivelTransacoesPdvRepository.findCombustivelByCodigoLojaAndDataExtracao(Integer.valueOf(criteria.getCodigoLoja()), 
				localVenda.getTransacaoLoja(), localVenda.getCodigoTerminalVenda(), dataVenda, localVenda.getNumeroDANFE());
		

		final TipoCombustiveisTransacaoType combustiveis = new TipoCombustiveisTransacaoType();
	
		combustivelDetalhe.forEach(new Consumer<Ejcombustivel>() {
			@Override
			public void accept(final Ejcombustivel combustivel) {
	
				final TipoCombustivelTransacaoType tipoCombustivel = new TipoCombustivelTransacaoType();
				
				if (ObjectUtils.isEmpty(combustivel.getRectype())) {
					tipoCombustivel.setCodigoTransacaoInterno(0);
				} else {
					final Matcher matcher = Pattern.compile("\\d{1,2}").matcher(String.valueOf(combustivel.getRectype()).replaceAll("\\s+", ""));
					matcher.find();
					tipoCombustivel.setCodigoTransacaoInterno(Integer.valueOf(matcher.group()));
				}
				
				if (ObjectUtils.isEmpty(combustivel.getRegCombustivelPK().getSeq())) {
					tipoCombustivel.setContadorRegistroInterno(0);
				} else {
					tipoCombustivel.setContadorRegistroInterno(combustivel.getRegCombustivelPK().getSeq());
				}

				tipoCombustivel.setPk(Long.valueOf(localVenda.getPk()));
				
				tipoCombustivel.setCodRMSProduto(combustivel.getCodRMSProduto());
				tipoCombustivel.setIDAbastecimento(combustivel.getIDAbastecimento());
				tipoCombustivel.setNumeroBicoAbastecimento(combustivel.getNumerobicoabastecimento());
				tipoCombustivel.setNumeroBombaAbastecimento(combustivel.getNumerobombaabastecimento());
				tipoCombustivel.setNumeroTanqueAbastecimento(combustivel.getNumerotanqueabastecimento());
				tipoCombustivel.setValorEncerranteInicial(combustivel.getValorencerranteinicial());
				tipoCombustivel.setValorEncerranteFinal(combustivel.getValorencerrantefinal());
				
				if (ObjectUtils.isEmpty(combustivel.getQtdeVendida())) {
					tipoCombustivel.setQtdeVendida(BigDecimal.ZERO);
				} else {
					final String qtdeVendida = combustivel.getQtdeVendida().toString().replaceAll("\\W", "");
					if (StringUtils.isEmpty(qtdeVendida)) {
						tipoCombustivel.setQtdeVendida(BigDecimal.ZERO);
					} else {
						tipoCombustivel.setQtdeVendida(new BigDecimal(qtdeVendida));
					}
				}
				
				final ZonedDateTime zone = combustivel.getRegCombustivelPK().getDatahora_eod().toInstant().atZone(ZoneId.systemDefault());
				final Matcher matcher = Pattern.compile("\\d{1,4}").matcher(String.format("%02d",zone.getHour()).concat(String.format("%02d",zone.getMinute())));
				matcher.find();
				tipoCombustivel.setHoraMinutoEvento(matcher.group());
				
				combustiveis.getCombustivel().add(tipoCombustivel);
			}
		});
		if (!CollectionUtils.isEmpty(combustiveis.getCombustivel())) {
			localVenda.getDadosCombustivelTransacao().add(combustiveis);
		}	
	}
	
	protected void addDrogaria(final TipoLocalVendaType localVenda, final MovimentacoesTransacoesPdvSearchCriteria criteria) {
		
		final DateTimeFormatter formatter = new DateTimeFormatterBuilder().appendPattern("dd/MM/yy").parseStrict().toFormatter();
		final LocalDateTime localDateTime =LocalDateTime.of(localVenda.getDataVenda().get(Calendar.YEAR),
				localVenda.getDataVenda().get(Calendar.MONTH) + 1, localVenda.getDataVenda().get(Calendar.DAY_OF_MONTH), 0, 0, 0);
		final String dataVenda = localDateTime.format(formatter);
		
		final List<Ejdrogaria> drogariaDetalhe = drogariaTransacoesPdvRepository.findDrogariaByCodigoLojaAndDataExtracao(Integer.valueOf(criteria.getCodigoLoja()), 
				localVenda.getTransacaoLoja(), localVenda.getCodigoTerminalVenda(), dataVenda, localVenda.getNumeroDANFE());
		
		

		final TipoDrogariasTransacaoType drogarias = new TipoDrogariasTransacaoType();
	
		drogariaDetalhe.forEach(new Consumer<Ejdrogaria>() {
			@Override
			public void accept(final Ejdrogaria drogaria) {
				
				final TipoDrogariaTransacaoType tipoDrogaria = new TipoDrogariaTransacaoType();
				
				if (ObjectUtils.isEmpty(drogaria.getRegDrogariaPK().getSeq())) {
					tipoDrogaria.setContadorRegistroInterno(0);
				} else {
					tipoDrogaria.setContadorRegistroInterno(drogaria.getRegDrogariaPK().getSeq());
				}
				
				if (ObjectUtils.isEmpty(drogaria.getRectype())) {
					tipoDrogaria.setCodigoTransacaoInterno(0);
				} else {
					final Matcher matcher = Pattern.compile("\\d{1,2}").matcher(String.valueOf(drogaria.getRectype()).replaceAll("\\s+", ""));
					matcher.find();
					tipoDrogaria.setCodigoTransacaoInterno(Integer.valueOf(matcher.group()));
				}
				
				tipoDrogaria.setPk(Long.valueOf(localVenda.getPk()));
				
				tipoDrogaria.setCodigoRMSProduto(drogaria.getCodRMSProduto());
				
				tipoDrogaria.setCodigoPBM(drogaria.getCodigoPBM());
				tipoDrogaria.setNumeroPreVendaPBM(drogaria.getNumeroPreVendaPBM());
				tipoDrogaria.setCodigoAutorizacaoPBM(drogaria.getCodigoAutorizacaoPBM());
				tipoDrogaria.setNumeroPedidoPBM(drogaria.getNumeroPedidoPBM());
				
				if (ObjectUtils.isEmpty(drogaria.getValorPBM())) {
					tipoDrogaria.setValorPBM(BigDecimal.ZERO);
				} else {
					final String valorPBM = drogaria.getValorPBM().toString().replaceAll("\\W", "");
					if (StringUtils.isEmpty(valorPBM)) {
						tipoDrogaria.setValorPBM(BigDecimal.ZERO);
					} else {
						tipoDrogaria.setValorPBM(new BigDecimal(valorPBM));
					}
				}
				
				if (ObjectUtils.isEmpty(drogaria.getQtdeVendida())) {
					tipoDrogaria.setQtdeVendida(BigDecimal.ZERO);
				} else {
					final String qtdeVencida = drogaria.getQtdeVendida().toString().replaceAll("\\W", "");
					if (StringUtils.isEmpty(qtdeVencida)) {
						tipoDrogaria.setQtdeVendida(BigDecimal.ZERO);
					} else {
						tipoDrogaria.setQtdeVendida(new BigDecimal(qtdeVencida));
					}
				}
				
				final ZonedDateTime zone = drogaria.getRegDrogariaPK().getDatahora_eod().toInstant().atZone(ZoneId.systemDefault());
				final Matcher matcher = Pattern.compile("\\d{1,4}").matcher(String.format("%02d",zone.getHour()).concat(String.format("%02d",zone.getMinute())));
				matcher.find();
				tipoDrogaria.setHoraMinutoEvento(matcher.group());
				
				drogarias.getDrogaria().add(tipoDrogaria);
			}
		});
		if (!CollectionUtils.isEmpty(drogarias.getDrogaria())) {
			localVenda.getDadosDrogariaTransacao().add(drogarias);
		}	
	}

	protected void addServico(final TipoLocalVendaType localVenda, final MovimentacoesTransacoesPdvSearchCriteria criteria) {
		
		final DateTimeFormatter formatter = new DateTimeFormatterBuilder().appendPattern("dd/MM/yy").parseStrict().toFormatter();
		final LocalDateTime localDateTime =LocalDateTime.of(localVenda.getDataVenda().get(Calendar.YEAR),
				localVenda.getDataVenda().get(Calendar.MONTH) + 1, localVenda.getDataVenda().get(Calendar.DAY_OF_MONTH), 0, 0, 0);
		final String dataVenda = localDateTime.format(formatter);
		
		final List<Ejservico> servicoDetalhe = servicoTransacoesPdvRepository.findServicoByCodigoLojaAndDataExtracao(Integer.valueOf(criteria.getCodigoLoja()), 
				localVenda.getTransacaoLoja(), localVenda.getCodigoTerminalVenda(), dataVenda, localVenda.getNumeroDANFE());
		
		
		final TipoServicosTransacaoType servicos = new TipoServicosTransacaoType();
	
		servicoDetalhe.forEach(new Consumer<Ejservico>() {
			@Override
			public void accept(final Ejservico servico) {
				
				final TipoServicoTransacaoType tipoServico = new TipoServicoTransacaoType();
				
				if (ObjectUtils.isEmpty(servico.getRectype())) {
					tipoServico.setCodigoTransacaoInterno(0);
				} else {
					final Matcher matcher = Pattern.compile("\\d{1,2}").matcher(String.valueOf(servico.getRectype()).replaceAll("\\s+", ""));
					matcher.find();
					tipoServico.setCodigoTransacaoInterno(Integer.valueOf(matcher.group()));
				}
				
				if (ObjectUtils.isEmpty(servico.getRegServicoPK().getSeq())) {
					tipoServico.setContadorRegistroInterno(0);
				} else {
					tipoServico.setContadorRegistroInterno(servico.getRegServicoPK().getSeq());
				}
				
				tipoServico.setPk(Long.valueOf(localVenda.getPk()));
				
				tipoServico.setDescricaoServico(servico.getDescricaoServico());
				
				tipoServico.setNumeroCartaoPresente(servico.getNumeroCartaoPresente());
				tipoServico.setNumeroCelularRecarga(servico.getNumeroCelularRecarga());
				tipoServico.setNomeOperadoraTelefonia(servico.getNomeOperadoraTelefonia());
				tipoServico.setCodigoServico(servico.getCodigoServico());
				
				tipoServico.setCodigoFornecedor(servico.getCodigofornecedor());
				tipoServico.setTipoServico(servico.getTiposervico());
		
				if (ObjectUtils.isEmpty(servico.getValorServico())) {
					tipoServico.setValorServico(BigDecimal.ZERO);
				} else {
					final String valorServico = servico.getValorServico().toString().replaceAll("\\W", "");
					if (StringUtils.isEmpty(valorServico)) {
						tipoServico.setValorServico(BigDecimal.ZERO);
					} else {
						tipoServico.setValorServico(new BigDecimal(valorServico));
					}
				}
				
				final ZonedDateTime zone = servico.getRegServicoPK().getDatahora_eod().toInstant().atZone(ZoneId.systemDefault());
				final Matcher matcher = Pattern.compile("\\d{1,4}").matcher(String.format("%02d",zone.getHour()).concat(String.format("%02d",zone.getMinute())));
				matcher.find();
				tipoServico.setHoraMinutoEvento(matcher.group());
				
				servicos.getServico().add(tipoServico);
			}
		});
		if (!CollectionUtils.isEmpty(servicos.getServico())) {
			localVenda.getDadosServicoTransacao().add(servicos);
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
				
				if (ObjectUtils.isEmpty(trailer.getValorTrocoDigital())) {
					rodape.setValorTrocoTotal(BigDecimal.ZERO);
				} else {
					final String valorTrocoDigital = trailer.getValorTrocoDigital().toString().replaceAll("\\W", "");
					if (StringUtils.isEmpty(valorTrocoDigital)) {
						rodape.setValorTrocoDigital(BigDecimal.ZERO);
					} else {
						rodape.setValorTrocoDigital(new BigDecimal(valorTrocoDigital));
					}
				}
				
				if (ObjectUtils.isEmpty(trailer.getValorTrocoDoacao())) {
					rodape.setValorTrocoDoacao(BigDecimal.ZERO);
				} else {
					final String valorTrocoDoacao = trailer.getValorTrocoDoacao().toString().replaceAll("\\W", "");
					if (StringUtils.isEmpty(valorTrocoDoacao)) {
						rodape.setValorTrocoDoacao(BigDecimal.ZERO);
					} else {
						rodape.setValorTrocoDoacao(new BigDecimal(valorTrocoDoacao));
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
