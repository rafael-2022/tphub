package com.dieboldnixdorf.frentecaixa.service;

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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import com.dieboldnixdorf.frentecaixa.domain.CabecalhoType;
import com.dieboldnixdorf.frentecaixa.domain.CodigoLojaType;
import com.dieboldnixdorf.frentecaixa.domain.DataExtracaoType;
import com.dieboldnixdorf.frentecaixa.domain.Employee;
import com.dieboldnixdorf.frentecaixa.domain.OperadoraLojaMessageType;
import com.dieboldnixdorf.frentecaixa.domain.OperadoraLojaPayloadType;
import com.dieboldnixdorf.frentecaixa.domain.StoremapDto;
import com.dieboldnixdorf.frentecaixa.domain.TipoOperadoresLojaType;

/**
 * The Class DadosOperadoraLojaServiceImpl.
 */
@Component("dadosOperadoraLojaService")
@Transactional (readOnly=true)
class DadosOperadoraLojaServiceImpl implements DadosOperadoraLojaService {

	/** The repository. */
	private final DadosOperadoraLojaRepository repository;

	/** The work list app. */
	@Autowired
	private WorklistApp workListApp;

	/** The work list. */
	@Autowired
	private WorklistService workList;

	/**
	 * Instantiates a new dados operadora loja service impl.
	 *
	 * @param repository the repository
	 */
	public DadosOperadoraLojaServiceImpl(final DadosOperadoraLojaRepository repository) {
		this.repository = repository;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<OperadoraLojaMessageType> findDadosOperadoraLoja(final DadosOperadoraLojaSearchCriteria criteria, final Pageable pageable) {
		final List<OperadoraLojaMessageType> messages = new ArrayList<OperadoraLojaMessageType>();
		final ResponseEntity<String> response = workListApp.performAuthorized();
		if (response.getStatusCode() == HttpStatus.OK) {
			final StoremapDto dto = workList.getStoreMap(response, criteria.getCodigoLoja()).getBody();
			if (!ObjectUtils.isEmpty(dto)
					&& !StringUtils.isEmpty(dto.getStoreIpTPLinux())) {
				final Calendar dataEsquemaVendas  = Calendar.getInstance();
				dataEsquemaVendas.setTime(criteria.getDataExtracao(criteria.getDataExtracao()));
				final CodigoLojaType codigoLoja = new CodigoLojaType();
				codigoLoja.setCodigoLoja(criteria.getCodigoLoja());
				final DataExtracaoType dataExtrtacao = new DataExtracaoType();
				final GregorianCalendar gregorianCalendar = new GregorianCalendar();
				gregorianCalendar.setTime(criteria.getDataExtracao(criteria.getDataExtracao()));
				try {
					final XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
					dataExtrtacao.setDataExtracao(xmlGregorianCalendar);
				} catch (final DatatypeConfigurationException dtcex) {
					dtcex.printStackTrace();
				}		
				final CabecalhoType cabecalho = new CabecalhoType();
				cabecalho.setCodigoLoja(codigoLoja);
				cabecalho.setDataExtracao(dataExtrtacao);
				final Page<Employee> operadoras = this.repository.findByCodigoLojaAndDataExtracao(Integer.valueOf(criteria.getCodigoLoja()), pageable);
				cabecalho.setTotalPaginas(Long.valueOf(operadoras.getTotalPages()));
				cabecalho.setTotalRegistros(operadoras.getTotalElements());
				cabecalho.setTotalRegistrosPorPagina(Long.valueOf(pageable.getPageSize()));
				final OperadoraLojaMessageType message = new OperadoraLojaMessageType();
				final TipoOperadoresLojaType tipoOperadoras = new TipoOperadoresLojaType();
				message.setCabecalho(cabecalho);
				operadoras.forEach(new Consumer<Employee>() {
					@Override
					public void accept(final Employee item) {
						final OperadoraLojaPayloadType payload = new OperadoraLojaPayloadType();
						final Matcher matcher = Pattern.compile("[a-zA-Z0-9]{1,3}").matcher(dto.getCodeStoreGold().replaceAll("\\s+", ""));
						matcher.find();
						payload.setSiglaLoja(matcher.group());
						if (ObjectUtils.isEmpty(item.getEmpnmbr())) {
							payload.setNumDRT(Long.valueOf(0));
						} else {
							payload.setNumDRT(item.getEmpnmbr());
						}
						if (StringUtils.isEmpty(item.getEmpname())) {
							payload.setNomeOperador("");
						} else {
							payload.setNomeOperador(item.getEmpname());
						}
						if (ObjectUtils.isEmpty(item.getEmpprofile())) {
							payload.setPerfilOperador(0);
						} else {
							payload.setPerfilOperador(item.getEmpprofile());
						}
						tipoOperadoras.getOperador().add(payload);
					}
				});
				if (!CollectionUtils.isEmpty(tipoOperadoras.getOperador())) {
					message.getPayload().add(tipoOperadoras);
					messages.add(message);
				}
			}
		}
		return messages;
	}

}
