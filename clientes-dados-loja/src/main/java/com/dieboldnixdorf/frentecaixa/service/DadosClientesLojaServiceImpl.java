package com.dieboldnixdorf.frentecaixa.service;

import java.math.BigDecimal;
import java.time.LocalDate;
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
import com.dieboldnixdorf.frentecaixa.domain.ClienteLojaMessageType;
import com.dieboldnixdorf.frentecaixa.domain.ClienteLojaPayloadType;
import com.dieboldnixdorf.frentecaixa.domain.CodigoLojaType;
import com.dieboldnixdorf.frentecaixa.domain.DataExtracaoType;
import com.dieboldnixdorf.frentecaixa.domain.EjitemD;
import com.dieboldnixdorf.frentecaixa.domain.EjitemL;
import com.dieboldnixdorf.frentecaixa.domain.EjitemS;
import com.dieboldnixdorf.frentecaixa.domain.StoremapDto;
import com.dieboldnixdorf.frentecaixa.domain.TipoDepartamentoType;
import com.dieboldnixdorf.frentecaixa.domain.TipoDepartamentosType;
import com.dieboldnixdorf.frentecaixa.domain.TipoLojaFimType;
import com.dieboldnixdorf.frentecaixa.domain.TipoSetorType;
import com.dieboldnixdorf.frentecaixa.domain.TipoSetoresLojaType;

/**
 * The Class DadosClientesLojaServiceImpl.
 */
@Component("dadosClientesLojaService")
@Transactional (readOnly=true)
class DadosClientesLojaServiceImpl implements DadosClientesLojaService {

	/** The loja repository. */
	private final DadosClientesLojaLRepository lojaRepository;

	/** The setor repository. */
	private final DadosClientesLojaSRepository setorRepository;

	/** The departamento repository. */
	private final DadosClientesLojaDRepository departamentoRepository;

	/** The work list app. */
	@Autowired
	private WorklistApp workListApp;

	/** The work list. */
	@Autowired
	private WorklistService workList;

	/**
	 * Instantiates a new dados clientes loja service impl.
	 *
	 * @param lojaRepository the loja repository
	 * @param setorRepository the setor repository
	 * @param departamentoRepository the departamento repository
	 */
	public DadosClientesLojaServiceImpl(final DadosClientesLojaLRepository lojaRepository, final DadosClientesLojaSRepository setorRepository,
			final DadosClientesLojaDRepository departamentoRepository) {
		this.lojaRepository = lojaRepository;
		this.setorRepository = setorRepository;
		this.departamentoRepository = departamentoRepository;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<ClienteLojaMessageType> findDadosClientesLoja(final DadosClientesLojaSearchCriteria criteria, final Pageable pageable) {
		final List<ClienteLojaMessageType> messages = new ArrayList<ClienteLojaMessageType>();
		final ResponseEntity<String> response = workListApp.performAuthorized();
		if (response.getStatusCode() == HttpStatus.OK) {
			final StoremapDto dto = workList.getStoreMap(response, criteria.getCodigoLoja()).getBody();
			if (!ObjectUtils.isEmpty(dto)
					&& !StringUtils.isEmpty(dto.getStoreIpTPLinux())) {
				final Calendar dataEsquemaVendas  = Calendar.getInstance();
				dataEsquemaVendas.setTime(criteria.getDataHoraExtracao(criteria.getDataExtracao()));
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
				final Page<EjitemL> clientesLoja = this.lojaRepository.findByCodigoLojaAndDataExtracao(Integer.valueOf(criteria.getCodigoLoja()), criteria.getDataExtracao(criteria.getDataExtracao(criteria.getDataExtracao())), pageable);
				cabecalho.setTotalPaginas(Long.valueOf(clientesLoja.getTotalPages()));
				cabecalho.setTotalRegistros(clientesLoja.getTotalElements());
				cabecalho.setTotalRegistrosPorPagina(Long.valueOf(pageable.getPageSize()));
				final ClienteLojaMessageType message = new ClienteLojaMessageType();
				message.setCabecalho(cabecalho);
				clientesLoja.forEach(new Consumer<EjitemL>() {
					@Override
					public void accept(final EjitemL item) {
						final ClienteLojaPayloadType payload = new ClienteLojaPayloadType();
						final TipoLojaFimType totalizacaoLoja = new TipoLojaFimType();
						final Matcher matcher = Pattern.compile("[a-zA-Z0-9]{1,3}").matcher(dto.getCodeStoreGold().replaceAll("\\s+",""));
						matcher.find();
						payload.setSiglaLoja(matcher.group());
						payload.setLoja(String.valueOf(dto.getIdStoreGold()));
						if (StringUtils.isEmpty(item.getDate())) {
							payload.setDataMovimento(null);
						} else {
							final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
							final LocalDate localDate = LocalDate.parse(item.getDate(), formatter);
							final Calendar dataMovimentacao  = Calendar.getInstance();
							dataMovimentacao.setTime(criteria.getDataExtracao(localDate));
							payload.setDataMovimento(dataMovimentacao);
						}
						if (ObjectUtils.isEmpty(item.getStorenmbr()) 
								&& StringUtils.isEmpty(item.getDate())) {
							totalizacaoLoja.setQuantidadeTotalClientesLoja(BigDecimal.ZERO);
						} else {
							totalizacaoLoja.setQuantidadeTotalClientesLoja(BigDecimal.valueOf(lojaRepository.findClienteTotalByStoreNmbrAndDate(item.getStorenmbr(), item.getDate())));
						}
						if (ObjectUtils.isEmpty(item.getStorenmbr()) 
								&& StringUtils.isEmpty(item.getDate())) {
							totalizacaoLoja.setQuantidadeClientesPerifericosLoja(BigDecimal.ZERO);
						} else {
							totalizacaoLoja.setQuantidadeClientesPerifericosLoja(BigDecimal.valueOf(lojaRepository.findClientesPerifericosByStoreNmbrAndDate(item.getStorenmbr(), item.getDate())));
						}
						payload.setTotalizacaoLoja(totalizacaoLoja);
						final List<EjitemS> setores = setorRepository.findByCodigoLojaAndDataExtracao(Integer.valueOf(criteria.getCodigoLoja()), criteria.getDataExtracao(criteria.getDataExtracao(criteria.getDataExtracao())));
						final TipoSetoresLojaType tipoSetores = new TipoSetoresLojaType();
						setores.forEach(new Consumer<EjitemS>() {
							@Override
							public void accept(final EjitemS setor) {
								final TipoSetorType tipoSetor = new TipoSetorType();
								final String descSetor = setorRepository.findNomeSetorByDeptLink(setor.getPrint1text().replaceAll("\\s+",""), Integer.valueOf(criteria.getCodigoLoja()));
								if (StringUtils.isEmpty(descSetor)) {
									tipoSetor.setSetor("");
								} else {
									tipoSetor.setSetor(descSetor);
								}
								if (StringUtils.isEmpty(setor.getPrint1text())) {
									tipoSetor.setCodigoSetor(0);
								} else {
									tipoSetor.setCodigoSetor(Integer.valueOf(setor.getPrint1text().replaceAll("\\s+","")));
								}
								if (ObjectUtils.isEmpty(setor.getAmtsold())) {
									tipoSetor.setValorVendaLiquida(BigDecimal.ZERO);
								} else {
									tipoSetor.setValorVendaLiquida(BigDecimal.valueOf(setor.getAmtsold()));
								}
								if (ObjectUtils.isEmpty(setor.getQtysold())) {
									tipoSetor.setQuantidadeUnidadesSetor(BigDecimal.ZERO);
								} else {
									tipoSetor.setQuantidadeUnidadesSetor(BigDecimal.valueOf(setor.getQtysold()));
								}
								if (ObjectUtils.isEmpty(setor.getMrpprice1())) {
									tipoSetor.setQuantidadeClientesSetor(Long.valueOf(0));
								} else {
									tipoSetor.setQuantidadeClientesSetor(setor.getMrpprice1());
								}
								if (ObjectUtils.isEmpty(setor.getMrpprice2())) {
									tipoSetor.setQuantidadeClientesPerifericosSetor(Long.valueOf(0));
								} else {
									tipoSetor.setQuantidadeClientesPerifericosSetor(setor.getMrpprice2());
								}
								tipoSetores.getSetores().add(tipoSetor);
								final List<EjitemD> departamentos = departamentoRepository.findByCodigoLojaAndDataExtracao(Integer.valueOf(criteria.getCodigoLoja()), 
										criteria.getDataExtracao(criteria.getDataExtracao(criteria.getDataExtracao())), setor.getPrint1text().trim());
								final TipoDepartamentosType tipoDepartamentos = new TipoDepartamentosType();
								departamentos.forEach(new Consumer<EjitemD>() {
									@Override
									public void accept(final EjitemD departamento) {
										final TipoDepartamentoType tipoDepartamento = new TipoDepartamentoType();
										if (StringUtils.isEmpty(departamento.getPrint1text())) {
											tipoDepartamento.setDepartamento("");
										} else {
											tipoDepartamento.setDepartamento(departamento.getPrint1text());
										}
										if (StringUtils.isEmpty(departamento.getDeptnmbr())) {
											tipoDepartamento.setCodigoDepartamento(0);
										} else {
											final Matcher matcher = Pattern.compile("\\d{1,3}").matcher(departamento.getDeptnmbr().replaceAll("\\s+",""));
											matcher.find();
											tipoDepartamento.setCodigoDepartamento(Integer.valueOf(matcher.group()));
										}
										if (ObjectUtils.isEmpty(departamento.getAmtsold())) {
											tipoDepartamento.setValorVendaLiquidaDepartamento(BigDecimal.ZERO);
										} else {
											tipoDepartamento.setValorVendaLiquidaDepartamento(BigDecimal.valueOf(departamento.getAmtsold()));
										}
										if (ObjectUtils.isEmpty(departamento.getQtysold())) {
											tipoDepartamento.setQuantidadeUnidadesDepartamento(BigDecimal.ZERO);
										} else {
											tipoDepartamento.setQuantidadeUnidadesDepartamento(BigDecimal.valueOf(departamento.getQtysold()));
										}
										if (ObjectUtils.isEmpty(departamento.getMrpprice1())) {
											tipoDepartamento.setQuantidadeClientesDepartamento(Long.valueOf(0));
										} else {
											tipoDepartamento.setQuantidadeClientesDepartamento(departamento.getMrpprice1());
										}
										if (ObjectUtils.isEmpty(departamento.getMrpprice2())) {
											tipoDepartamento.setQuantidadeClientesPerifericosDepartamento(Long.valueOf(0));
										} else {
											tipoDepartamento.setQuantidadeClientesPerifericosDepartamento(departamento.getMrpprice2());
										}
										tipoDepartamentos.getDepartamentos().add(tipoDepartamento);
									}
								});
								if (!CollectionUtils.isEmpty(tipoDepartamentos.getDepartamentos())) {
									tipoSetor.getDepartamentos().add(tipoDepartamentos);
								}
							}
						});
						if (!CollectionUtils.isEmpty(tipoSetores.getSetores())) {
							payload.setSetores(tipoSetores);
						}
						message.getPayload().add(payload);
					}
				});
				if (!CollectionUtils.isEmpty(message.getPayload())) {
					messages.add(message);
				}
			}
		}
		return messages;
	}

}
