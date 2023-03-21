package com.dieboldnixdorf.frentecaixa.service;

import java.math.BigDecimal;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import com.dieboldnixdorf.frentecaixa.domain.CabecalhoType;
import com.dieboldnixdorf.frentecaixa.domain.CodigoLojaType;
import com.dieboldnixdorf.frentecaixa.domain.DataExtracaoType;
import com.dieboldnixdorf.frentecaixa.domain.Ejitem;
import com.dieboldnixdorf.frentecaixa.domain.TipoRodapeLojaType;
import com.dieboldnixdorf.frentecaixa.domain.VendaSetorHoraMessageType;
import com.dieboldnixdorf.frentecaixa.domain.VendaSetorHoraPayloadType;

@Component("vendasSetorHoraService")
@Transactional (readOnly=true)
class VendasSetorHoraServiceImpl implements VendasSetorHoraService {

	/** The repository. */
	private final VendasSetorHoraRepository repository;

	/**
	 * Instantiates a new vendas setor hora service impl.
	 *
	 * @param repository the repository
	 */
	public VendasSetorHoraServiceImpl(final VendasSetorHoraRepository repository) {
		this.repository = repository;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<VendaSetorHoraMessageType> findVendasSetorHora(final VendasSetorHoraSearchCriteria criteria, final Pageable pageable) {
		final List<VendaSetorHoraMessageType> messages = new ArrayList<VendaSetorHoraMessageType>();
		final CodigoLojaType codigoLoja = new CodigoLojaType();
		codigoLoja.setCodigoLoja(criteria.getCodigoLoja());
		final DataExtracaoType dataExtrtacao = new DataExtracaoType();
		final GregorianCalendar gregorianCalendar = new GregorianCalendar();
		gregorianCalendar.setTime(criteria.getDataHoraExtracao(criteria.getDataExtracao().toLocalDate()));
		try {
			final XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
			dataExtrtacao.setDataExtracao(xmlGregorianCalendar);
		} catch (final DatatypeConfigurationException dtcex) {
			dtcex.printStackTrace();
		}		
		final CabecalhoType cabecalho = new CabecalhoType();
		cabecalho.setCodigoLoja(codigoLoja);
		cabecalho.setDataExtracao(dataExtrtacao);
		final Page<Ejitem> vendas = this.repository.findByCodigoLojaAndDataExtracao(Integer.valueOf(criteria.getCodigoLoja()), criteria.getDataExtracao(criteria.getDataExtracao(criteria.getDataExtracao().toLocalDate())), criteria.getLeftPaddingWithZeros(criteria.getDataExtracao()), pageable);
		cabecalho.setTotalPaginas(Long.valueOf(vendas.getTotalPages()));
		cabecalho.setTotalRegistros(vendas.getTotalElements());
		cabecalho.setTotalRegistrosPorPagina(Long.valueOf(pageable.getPageSize()));
		final VendaSetorHoraMessageType message = new VendaSetorHoraMessageType();
		message.setCabecalho(cabecalho);
		final TipoRodapeLojaType tipoRodapeLojaType = new TipoRodapeLojaType();
		final Long quantidadeClienteLoja = repository.findQuantidadeClienteByStoreNmbrAndDate(Integer.valueOf(criteria.getCodigoLoja()), criteria.getDataExtracao(criteria.getDataExtracao(criteria.getDataExtracao().toLocalDate())), criteria.getLeftPaddingWithZeros(criteria.getDataExtracao()));
		if (ObjectUtils.isEmpty(quantidadeClienteLoja)) {
			tipoRodapeLojaType.setQuantidadeTotalClientesLoja(BigDecimal.ZERO);
		} else {
			tipoRodapeLojaType.setQuantidadeTotalClientesLoja(BigDecimal.valueOf(quantidadeClienteLoja));
		}
		final Long quantidadeClientesPerifericosLoja = repository.findQuantidadeClientePerifericosByStoreNmbrAndDate(Integer.valueOf(criteria.getCodigoLoja()), criteria.getDataExtracao(criteria.getDataExtracao(criteria.getDataExtracao().toLocalDate())), criteria.getLeftPaddingWithZeros(criteria.getDataExtracao()));
		if (ObjectUtils.isEmpty(quantidadeClientesPerifericosLoja)) {
			tipoRodapeLojaType.setQuantidadeClientesPerifericosLoja(BigDecimal.ZERO);
		} else {
			tipoRodapeLojaType.setQuantidadeClientesPerifericosLoja(BigDecimal.valueOf(quantidadeClientesPerifericosLoja));
		}
		final Calendar dataMovimentacao  = Calendar.getInstance();
		dataMovimentacao.setTime(Date.from(criteria.getDataExtracao().atZone(ZoneId.systemDefault()).toInstant()));
		tipoRodapeLojaType.setDataMovimento(dataMovimentacao);
		message.setRodapeTotalizacao(tipoRodapeLojaType);
		vendas.forEach(new Consumer<Ejitem>() {
			@Override
			public void accept(final Ejitem item) {
				final VendaSetorHoraPayloadType payload = new VendaSetorHoraPayloadType();
				if (StringUtils.isEmpty(item.getVendaPK().getDeptnmbr())) {
					payload.setNumeroSetor(0);
				} else {
					final String deptnmbr = item.getVendaPK().getDeptnmbr().trim().replaceAll("\\W", "");
					payload.setNumeroSetor(Integer.valueOf(deptnmbr));
				}
				if (ObjectUtils.isEmpty(item.getVendaPK().getStorenmbr()) 
						&& StringUtils.isEmpty(item.getVendaPK().getDeptnmbr())
						&& StringUtils.isEmpty(item.getVendaPK().getDate())) {
					payload.setQuantidadeClienteSetor(Long.valueOf(0));
				} else {
					final String deptnmbr = item.getVendaPK().getDeptnmbr().replaceAll("\\W", "");
					final Long quantidadeClienteSetor = repository.findQuantidadeClienteBySetorNmbrAndDateAndDeptNmbr(item.getVendaPK().getStorenmbr(), item.getVendaPK().getDate(), deptnmbr, criteria.getLeftPaddingWithZeros(criteria.getDataExtracao()));
					if (ObjectUtils.isEmpty(quantidadeClienteSetor)) {
						payload.setQuantidadeClienteSetor(Long.valueOf(0));
					} else {
						payload.setQuantidadeClienteSetor(quantidadeClienteSetor);
					}
				}
				if (ObjectUtils.isEmpty(item.getVendaPK().getStorenmbr()) 
						&& StringUtils.isEmpty(item.getVendaPK().getDeptnmbr())
						&& StringUtils.isEmpty(item.getVendaPK().getDate())) {
					payload.setQuantidadeClientesPerifericosSetor(Long.valueOf(0));
				} else {
					final String deptnmbr = item.getVendaPK().getDeptnmbr().trim().replaceAll("\\W", "");
					final Long quantidadeClientesPerifericosSetor = repository.findQuantidadeClientesPerifericosBySetorNmbrAndDateAndDeptNmbr(item.getVendaPK().getStorenmbr(), item.getVendaPK().getDate(), deptnmbr, criteria.getLeftPaddingWithZeros(criteria.getDataExtracao()));
					if (ObjectUtils.isEmpty(quantidadeClientesPerifericosSetor)) {
						payload.setQuantidadeClientesPerifericosSetor(Long.valueOf(0));
					} else {
						payload.setQuantidadeClientesPerifericosSetor(quantidadeClientesPerifericosSetor);
					}
				}
				if (ObjectUtils.isEmpty(item.getQtysold())) {
					payload.setQuantidadeItensVendidos(BigDecimal.ZERO);
				} else {
					payload.setQuantidadeItensVendidos(BigDecimal.valueOf(item.getQtysold()));
				}
				if (ObjectUtils.isEmpty(item.getAmtsold())) {
					payload.setValorTotalVendaSetor(BigDecimal.ZERO);
				} else {
					payload.setValorTotalVendaSetor(BigDecimal.valueOf(item.getAmtsold()));
				}
				message.getPayload().add(payload);
			}
		});
		if (!CollectionUtils.isEmpty(message.getPayload())) {
			messages.add(message);
		}
		return messages;
	}
}
