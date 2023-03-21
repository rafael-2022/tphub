package com.dieboldnixdorf.frentecaixa.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.function.Consumer;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.dieboldnixdorf.frentecaixa.domain.TipoCabecalho;
import com.dieboldnixdorf.frentecaixa.domain.CodigoLojaType;
import com.dieboldnixdorf.frentecaixa.domain.DataExtracaoType;
import com.dieboldnixdorf.frentecaixa.domain.Ejheader;
import com.dieboldnixdorf.frentecaixa.domain.Ejitem;
import com.dieboldnixdorf.frentecaixa.domain.Ejmedia;
import com.dieboldnixdorf.frentecaixa.domain.TipoConciliacaoSvaMessage;
import com.dieboldnixdorf.frentecaixa.domain.TipoConciliacaoSvaPayload;
import com.dieboldnixdorf.frentecaixa.domain.TipoIdentificacaoTicket;
import com.dieboldnixdorf.frentecaixa.domain.TipoRecuperacaoPedido;
import com.dieboldnixdorf.frentecaixa.domain.TipoRegistroIdentificacaoItens;
import com.dieboldnixdorf.frentecaixa.domain.TipoRegistroIdentificacaoItensDetalhe;
import com.dieboldnixdorf.frentecaixa.domain.TipoRegistroMeioPagamento;
import com.dieboldnixdorf.frentecaixa.domain.TipoRegistroMeioPagamentoDetalhe;
import com.dieboldnixdorf.frentecaixa.domain.TipoStatus;

/**
 * The Class MovimentacoesTransacoesPdvServiceImpl.
 */
@Component("conciliacaoSvaService")
@Transactional
class ConciliacaoSvaServiceImpl implements ConciliacaoSvaService {

    /**
     * The repository.
     */
    private final MovimentacoesTransacoesPdvRepository repository;

    /**
     * The item repository.
     */
    private final ItemTransacoesPdvRepository itemRepository;

    /**
     * The forma pagamento repository.
     */
    private final FormaPagamentoTransacoesPdvRepository formaPagamentoRepository;

    /**
     * The rodape repository.
     */
    /**
     * Instantiates a new movimentacoes transacoes pdv service impl.
     *
     * @param repository the repository
     * @param cabecalhoRepository the cabecalho repository
     * @param itemRepository the item repository
     * @param formaPagamentoRepository the forma pagamento repository
     * @param rodapeRepository the rodape repository
     */
    public ConciliacaoSvaServiceImpl(final MovimentacoesTransacoesPdvRepository repository,
            final ItemTransacoesPdvRepository itemRepository, final FormaPagamentoTransacoesPdvRepository formaPagamentoRepository) {
        this.repository = repository;
        this.itemRepository = itemRepository;
        this.formaPagamentoRepository = formaPagamentoRepository;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TipoCabecalho getCabecalho(final MovimentacoesTransacoesPdvSearchCriteria criteria, final Pageable pageable) {
        final CodigoLojaType codigoLoja = new CodigoLojaType();
        codigoLoja.setCodigoLoja(criteria.getCodigoLoja());

        final Page<Ejheader> transacoes = this.repository.findLocalVendaByCodigoLojaAndDataExtracao(Integer.valueOf(criteria.getCodigoLoja()),
                criteria.getDataExtracao(criteria.getDataExtracao(criteria.getDataExtracao())), pageable);

        final TipoCabecalho cabecalho = new TipoCabecalho();
        cabecalho.setCodigoLoja(codigoLoja);
        cabecalho.setTotalPaginas(Long.valueOf(transacoes.getTotalPages()));
        cabecalho.setTotalRegistros(transacoes.getTotalElements());
        cabecalho.setTotalRegistrosPorPagina(Long.valueOf(pageable.getPageSize()));
        final TipoConciliacaoSvaMessage message = new TipoConciliacaoSvaMessage();
        final DataExtracaoType dataExtrtacao = new DataExtracaoType();
        final GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(criteria.getDataHoraExtracao(criteria.getDataExtracao()));
        try {
            final XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
            dataExtrtacao.setDataExtracao(xmlGregorianCalendar);
        } catch (final DatatypeConfigurationException dtcex) {
            dtcex.printStackTrace();
        }
        cabecalho.setDataExtracao(dataExtrtacao);
        return cabecalho;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<TipoConciliacaoSvaPayload> findTransacoesPDV(final MovimentacoesTransacoesPdvSearchCriteria criteria, final Pageable pageable) {

        final CodigoLojaType codigoLoja = new CodigoLojaType();;

        codigoLoja.setCodigoLoja(criteria.getCodigoLoja());

        final Page<Ejheader> transacoes = this.repository.findLocalVendaByCodigoLojaAndDataExtracao(Integer.valueOf(criteria.getCodigoLoja()),
                criteria.getDataExtracao(criteria.getDataExtracao(criteria.getDataExtracao())), pageable);

        final List<TipoConciliacaoSvaPayload> detalhes = new ArrayList<TipoConciliacaoSvaPayload>();

        transacoes.forEach(new Consumer<Ejheader>() {
            @Override
            public void accept(final Ejheader header) {
                TipoConciliacaoSvaPayload detalhe = new TipoConciliacaoSvaPayload();
                final TipoRecuperacaoPedido localVenda = new TipoRecuperacaoPedido();

                localVenda.setNsuPedido(header.getNsupedido());
                localVenda.setNumPedido(header.getNumpedido());
                localVenda.setTransacao(Integer.valueOf(header.getTranssva()));

                detalhe.setTransacaoRecuperacaoPedido(localVenda); //Pronto

                TipoIdentificacaoTicket tipoIdentificacaoTicket = new TipoIdentificacaoTicket();
                tipoIdentificacaoTicket.setCodRegistro(Integer.valueOf(header.getTiporeg()));
                tipoIdentificacaoTicket.setCupomFiscal(header.getMngrovnmbr());
                tipoIdentificacaoTicket.setTipoItem(Integer.valueOf(header.getTipoitem()));
                detalhe.setTransacaoIdentificacaoTicket(tipoIdentificacaoTicket);

                TipoRegistroIdentificacaoItens tipoRegistroIdentificacaoItens = new TipoRegistroIdentificacaoItens();
                tipoRegistroIdentificacaoItens.setCodRegistro(4);

                List<TipoRegistroIdentificacaoItensDetalhe> listaTipoRegistroIdentificacaoItensDetalhe = addTipoRegistroIdentificacaoItensDetalhe(criteria, header.getMovimentacaoPK().getTransnmbr(), header.getMovimentacaoPK().getTermnmbr(), header);
                
                tipoRegistroIdentificacaoItens.setTipoRegistroIdentificacaoItensDetalhe(listaTipoRegistroIdentificacaoItensDetalhe);
                detalhe.setRegistroIdentificacaoItens(tipoRegistroIdentificacaoItens);

                TipoRegistroMeioPagamento tipoRegistroMeioPagamento = new TipoRegistroMeioPagamento();
                tipoRegistroMeioPagamento.setCodRegistro(3);
                TipoRegistroMeioPagamentoDetalhe tipoRegistroMeioPagamentoDetalhe = new TipoRegistroMeioPagamentoDetalhe();

                List<TipoRegistroMeioPagamentoDetalhe> listatipoRegistroMeioPagamentoDetalhe = addTipoRegistroMeioPagamentoDetalhe(criteria, header.getMovimentacaoPK().getTransnmbr(), header.getMovimentacaoPK().getTermnmbr(), header);
                tipoRegistroMeioPagamento.setTipoRegistroMeioPagamentoDetalhe(listatipoRegistroMeioPagamentoDetalhe);
                detalhe.setRegistroMeioPagamento(tipoRegistroMeioPagamento);

                TipoStatus tipoStatus = new TipoStatus();
                tipoStatus.setCodLojaRMS(header.getCodloja());
                tipoStatus.setCodVendedor(header.getCodvend());
                tipoStatus.setCpfCliente(header.getCodcliente());
                tipoStatus.setIdentTerminal(String.valueOf(header.getIdterm()));
                tipoStatus.setStatus(String.valueOf(header.getStatus()));
                detalhe.setStatus(tipoStatus);

                detalhes.add(detalhe);
            }
        });

        return detalhes;
    }

    protected List<TipoRegistroIdentificacaoItensDetalhe> addTipoRegistroIdentificacaoItensDetalhe(final MovimentacoesTransacoesPdvSearchCriteria criteria, int transacao, int numeroPdv, Ejheader header) {
        final Calendar dataVenda = Calendar.getInstance();
        dataVenda.setTime(header.getMovimentacaoPK().getDatahora_sod());
        final DateTimeFormatter formatter = new DateTimeFormatterBuilder().appendPattern("dd/MM/yy").parseStrict().toFormatter();
        final LocalDateTime localDateTime = LocalDateTime.of(dataVenda.get(Calendar.YEAR),
                dataVenda.get(Calendar.MONTH) + 1, dataVenda.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        final String dataVendaConsulta = localDateTime.format(formatter);
        final List<Ejitem> items = itemRepository.findItemTransacaoByCodigoLojaAndDataExtracao(Integer.valueOf(criteria.getCodigoLoja()),
                transacao, numeroPdv, dataVendaConsulta);

        List<TipoRegistroIdentificacaoItensDetalhe> listaTipoRegistroIdentificacaoItensDetalhe = new ArrayList();

        items.forEach(new Consumer<Ejitem>() {
            @Override
            public void accept(final Ejitem item) {
                TipoRegistroIdentificacaoItensDetalhe tipoRegistroIdentificacaoItensDetalhe = new TipoRegistroIdentificacaoItensDetalhe();
                tipoRegistroIdentificacaoItensDetalhe.setCodFornecedor(item.getCodforn());
                tipoRegistroIdentificacaoItensDetalhe.setCodProdutoGarantiaRMS(item.getReg20PK().getCodprodgar());
                tipoRegistroIdentificacaoItensDetalhe.setCodProdutoPLU(item.getReg20PK().getCodprod());
                tipoRegistroIdentificacaoItensDetalhe.setQuantidade(item.getQtde());
                tipoRegistroIdentificacaoItensDetalhe.setTipoItem(Integer.valueOf(item.getTipoitem()));
                tipoRegistroIdentificacaoItensDetalhe.setTipoServico(Integer.valueOf(item.getTiposerv()));
                tipoRegistroIdentificacaoItensDetalhe.setValorDesconto(item.getVlrdesc());
                tipoRegistroIdentificacaoItensDetalhe.setValorTotal(item.getVlrtot());
                tipoRegistroIdentificacaoItensDetalhe.setValorUnitario(item.getVlrunit());
                listaTipoRegistroIdentificacaoItensDetalhe.add(tipoRegistroIdentificacaoItensDetalhe);
            }
        });
        return listaTipoRegistroIdentificacaoItensDetalhe;
    }

    protected List<TipoRegistroMeioPagamentoDetalhe> addTipoRegistroMeioPagamentoDetalhe(final MovimentacoesTransacoesPdvSearchCriteria criteria, int transacao, int numeroPdv, Ejheader header) {
        final Calendar dataVenda = Calendar.getInstance();
        dataVenda.setTime(header.getMovimentacaoPK().getDatahora_sod());
        final DateTimeFormatter formatter = new DateTimeFormatterBuilder().appendPattern("dd/MM/yy").parseStrict().toFormatter();
        final LocalDateTime localDateTime = LocalDateTime.of(dataVenda.get(Calendar.YEAR),
                dataVenda.get(Calendar.MONTH) + 1, dataVenda.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        final String dataVendaConsulta = localDateTime.format(formatter);
        final List<Ejmedia> formasPagamento = formaPagamentoRepository.findFormaPagamentoByCodigoLojaAndDataExtracao(Integer.valueOf(criteria.getCodigoLoja()),
                transacao, numeroPdv, dataVendaConsulta);

        List<TipoRegistroMeioPagamentoDetalhe> listatipoRegistroMeioPagamentoDetalhe = new ArrayList();

        formasPagamento.forEach(new Consumer<Ejmedia>() {
            @Override
            public void accept(final Ejmedia media) {
                TipoRegistroMeioPagamentoDetalhe tipoRegistroMeioPagamentoDetalhe = new TipoRegistroMeioPagamentoDetalhe();
                
                tipoRegistroMeioPagamentoDetalhe.setMeiosPagto(media.getReg40PK().getMeiopagto());
                tipoRegistroMeioPagamentoDetalhe.setNumParcelas(media.getNumparc());
                tipoRegistroMeioPagamentoDetalhe.setPlanoPagto(media.getReg40PK().getPlanopagto());
                tipoRegistroMeioPagamentoDetalhe.setValorPago(media.getReg40PK().getValor());
                listatipoRegistroMeioPagamentoDetalhe.add(tipoRegistroMeioPagamentoDetalhe);
            }
        });

        return listatipoRegistroMeioPagamentoDetalhe;
    }

}
