package com.dieboldnixdorf.frentecaixa.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.function.Consumer;

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
import com.dieboldnixdorf.frentecaixa.domain.DevRecebimento;
import com.dieboldnixdorf.frentecaixa.domain.StoremapDto;
import com.dieboldnixdorf.frentecaixa.domain.VendaAssistidaDevolucaoMessageType;
import com.dieboldnixdorf.frentecaixa.domain.VendaAssistidaDevolucaoPayloadType;

/**
 * The Class VendaAssitidaDevolucaoImpl.
 */
@Component("dadosDevolucaoService")
@Transactional (readOnly=true)
class VendaAssistidaDevolucaoServiceImpl implements VendaAssistidaDevolucaoService {

	/** The repository. */
	private final VendaAssistidaDevolucaoRepository repository;

	/** The work list app. */
	@Autowired
	private WorklistApp workListApp;

	/** The work list. */
	@Autowired
	private WorklistService workList;
	
	/**
	 * Instantiates a new dados devolucao service impl.
	 *
	 * @param repository the repository
	 */
	public VendaAssistidaDevolucaoServiceImpl(final VendaAssistidaDevolucaoRepository repository) {
		this.repository = repository;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<VendaAssistidaDevolucaoMessageType> findDadosDevolucao(final VendaAssistidaDevolucaoSearchCriteria criteria, final Pageable pageable) {
		
		final List<VendaAssistidaDevolucaoMessageType> messages = new ArrayList<VendaAssistidaDevolucaoMessageType>();
		
		//final ResponseEntity<String> response = workListApp.performAuthorized();
		//if (response.getStatusCode() == HttpStatus.OK) {
			
			//final StoremapDto dto = workList.getStoreMap(response, criteria.getCodigoLoja()).getBody();
			
			/*if (!ObjectUtils.isEmpty(dto)
					&& !StringUtils.isEmpty(dto.getStoreIpTPLinux())) {
			*/	

				final CodigoLojaType codigoLoja = new CodigoLojaType();
				codigoLoja.setCodigoLoja(criteria.getCodigoLoja());
				
				final GregorianCalendar gregorianCalendar = new GregorianCalendar();
				gregorianCalendar.setTime(criteria.getDataExtracao());
				final DataExtracaoType dataExtrtacao = new DataExtracaoType();
				try {
					final XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
					dataExtrtacao.setDataExtracao(xmlGregorianCalendar);
				} catch (final DatatypeConfigurationException dtcex) {
					dtcex.printStackTrace();
				}		
				
				final CabecalhoType cabecalho = new CabecalhoType();
				cabecalho.setCodigoLoja(codigoLoja);
				cabecalho.setDataExtracao(dataExtrtacao);
				
				//
				final Page<DevRecebimento> devolucoes = this.repository.findByCodigoLojaAndDataExtracao(Integer.valueOf(criteria.getCodigoLoja()), criteria.getDataExtracaoString(), pageable);
				cabecalho.setTotalPaginas(Long.valueOf(devolucoes.getTotalPages()));
				cabecalho.setTotalRegistros(devolucoes.getTotalElements());
				cabecalho.setTotalRegistrosPorPagina(Long.valueOf(pageable.getPageSize()));
				final VendaAssistidaDevolucaoMessageType message = new VendaAssistidaDevolucaoMessageType();
				message.setCabecalho(cabecalho);
				
				devolucoes.forEach(new Consumer<DevRecebimento>() {
					@Override
					public void accept(final DevRecebimento media) {
						
						final VendaAssistidaDevolucaoPayloadType payload = new VendaAssistidaDevolucaoPayloadType();
						
						//Preenche o payload para retornar
						payload.setCatFormPagto(media.getCatFormPagto());
						payload.setCodFornc(media.getCodFornc());
						payload.setCodOper(media.getCodOper());
						payload.setCodProd(media.getCodProd());
						payload.setCodServ(media.getCodServ());
						payload.setCodVend(media.getCodVend());
						payload.setFormPagto(media.getFormPagto());
						payload.setNumDocto(media.getDevRecebimentoPK().getNumDocto());
						payload.setNumPDV(media.getNumPDV());
						payload.setNumPreOrder(media.getDevRecebimentoPK().getNumPreOrder());
						payload.setQtde(media.getQtde());
						payload.setQtdeFormPagto(media.getQtdeFormPagto());
						payload.setTipoDev(media.getDevRecebimentoPK().getTipoDev());
						payload.setTipoServ(media.getTipoServ());
						payload.setVlrFormPagto(media.getVlrFormPagto());
						payload.setVlrTot(media.getVlrTot());
						payload.setVlrUnit(media.getVlrUnit());
						
						//Adiciona Pauload no retorno
						message.getPayload().add(payload);
					}
				});
				if (!CollectionUtils.isEmpty(message.getPayload())) {
					messages.add(message);
				}
			//}
		//}
		return messages;
	}
}
