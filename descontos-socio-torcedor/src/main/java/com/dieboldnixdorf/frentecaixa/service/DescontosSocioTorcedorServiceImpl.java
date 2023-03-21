package com.dieboldnixdorf.frentecaixa.service;

import java.math.BigDecimal;
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
import com.dieboldnixdorf.frentecaixa.domain.SocioTorcedorMessageType;
import com.dieboldnixdorf.frentecaixa.domain.SocioTorcedorPayloadType;
import com.dieboldnixdorf.frentecaixa.domain.TipoProdutoType;
import com.dieboldnixdorf.frentecaixa.domain.TipoProdutosDescontosType;

/**
 * The Class DescontosSocioTorcedorServiceImpl.
 */
@Component("descontosSocioTorcedorService")
@Transactional (readOnly=true)
class DescontosSocioTorcedorServiceImpl implements DescontosSocioTorcedorService {

	/** The repository. */
	private final DescontosSocioTorcedorRepository repository;

	/**
	 * Instantiates a new descontos socio torcedor service impl.
	 *
	 * @param repository the repository
	 */
	public DescontosSocioTorcedorServiceImpl(final DescontosSocioTorcedorRepository repository) {
		this.repository = repository;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<SocioTorcedorMessageType> findDescontosSocioTorcedor(final DescontosSocioTorcedorSearchCriteria criteria, final Pageable pageable) {
		final List<SocioTorcedorMessageType> messages = new ArrayList<SocioTorcedorMessageType>();
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
		final Page<Ejitem> descontos = this.repository.findByCodigoLojaAndDataExtracao(Integer.valueOf(criteria.getCodigoLoja()), criteria.getDataExtracao(criteria.getDataExtracao()), pageable);
		cabecalho.setTotalPaginas(Long.valueOf(descontos.getTotalPages()));
		cabecalho.setTotalRegistros(descontos.getTotalElements());
		cabecalho.setTotalRegistrosPorPagina(Long.valueOf(pageable.getPageSize()));
		final SocioTorcedorMessageType message = new SocioTorcedorMessageType();
		message.setCabecalho(cabecalho);
		descontos.forEach(new Consumer<Ejitem>() {
			@Override
			public void accept(final Ejitem item) {
				final SocioTorcedorPayloadType payload = new SocioTorcedorPayloadType();
				final TipoProdutosDescontosType produtosAmbevDescontos = new TipoProdutosDescontosType();
				final TipoProdutoType produtoAmbev = new TipoProdutoType();
				if (StringUtils.isEmpty(item.getContabilPK().getPrint1text())) {
					produtoAmbev.setEAN(Long.valueOf(0));
				} else {
					final Matcher matcher = Pattern.compile("\\d{1,13}").matcher(item.getContabilPK().getPrint1text().replaceAll("\\s+",""));
					matcher.find();
					produtoAmbev.setEAN(Long.valueOf(matcher.group()));
				}
				if (ObjectUtils.isEmpty(item.getQtysold())) {
					produtoAmbev.setQuantidade(BigDecimal.ZERO);
				} else {
					produtoAmbev.setQuantidade(BigDecimal.valueOf(item.getQtysold()));
				}
				if (ObjectUtils.isEmpty(item.getAmtsold())) {
					produtoAmbev.setValorDesconto(BigDecimal.ZERO);
				} else {
					produtoAmbev.setValorDesconto(BigDecimal.valueOf(item.getAmtsold()));
				}
				produtosAmbevDescontos.setProdutoAmbev(produtoAmbev);
				payload.getProdutosAmbevDescontos().add(produtosAmbevDescontos);
				if (ObjectUtils.isEmpty(item.getContabilPK().getTransnmbr())) {
					payload.setNumeroTransacao(Long.valueOf(0));
				} else {
					final Matcher matcher = Pattern.compile("\\d{1,10}").matcher(String.valueOf(item.getContabilPK().getTransnmbr()));
					matcher.find();
					payload.setNumeroTransacao(Long.valueOf(matcher.group()));
				}
				if (ObjectUtils.isEmpty(item.getCshrnmbr())) {
					payload.setDrtOperador(Long.valueOf(0));
				} else {
					final Matcher matcher = Pattern.compile("\\d{1,11}").matcher(String.valueOf(item.getCshrnmbr()));
					matcher.find();
					payload.setDrtOperador(Long.valueOf(matcher.group()));
				}
				if (StringUtils.isEmpty(item.getPrint2text())) {
					payload.setCpfSocioTorcedor("");
				} else {
					final String cpfSocioTorcedor = item.getPrint2text().trim().replaceAll("\\D+","").replaceAll("\\s+","");
					final Matcher matcher = Pattern.compile("\\d{1,11}").matcher(cpfSocioTorcedor);
					matcher.find();
					payload.setCpfSocioTorcedor(matcher.group());
				}
				final Calendar dataMovimentacao  = Calendar.getInstance();
				dataMovimentacao.setTime(item.getDatahora());
				payload.setDataMovimentacao(dataMovimentacao);
				if (ObjectUtils.isEmpty(item.getContabilPK().getTermnmbr())) {
					payload.setNumeroPDV(0);
				} else {
					final Matcher matcher = Pattern.compile("\\d{1,3}").matcher(String.valueOf(item.getContabilPK().getTermnmbr()));
					matcher.find();
					payload.setNumeroPDV(Integer.valueOf(matcher.group()));
				}
				if (ObjectUtils.isEmpty(item.getStorenmbr())) {
					payload.setSiglaLoja("");
				} else {
					final Matcher matcher = Pattern.compile("[a-zA-Z0-9]{1,3}").matcher(String.valueOf(item.getStorenmbr()));
					matcher.find();
					payload.setSiglaLoja(matcher.group());
				}
				message.getTransacaoSocioTorcedor().add(payload);
			}
		});
		if (!CollectionUtils.isEmpty(message.getTransacaoSocioTorcedor())) {
			messages.add(message);
		}
		return messages;
	}

}
