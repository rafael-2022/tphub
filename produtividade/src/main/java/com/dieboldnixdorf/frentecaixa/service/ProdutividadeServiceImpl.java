package com.dieboldnixdorf.frentecaixa.service;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.function.Consumer;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.dieboldnixdorf.frentecaixa.domain.CabecalhoType;
import com.dieboldnixdorf.frentecaixa.domain.CodigoLojaType;
import com.dieboldnixdorf.frentecaixa.domain.DataExtracaoType;
import com.dieboldnixdorf.frentecaixa.domain.Produtividade;
import com.dieboldnixdorf.frentecaixa.domain.ProdutividadeMessageType;
import com.dieboldnixdorf.frentecaixa.domain.ProdutividadePayloadType;

/**
 * The Class ProdutividadeImpl.
 */
@Component("produtividadeService")
@Transactional (readOnly=false)
class ProdutividadeServiceImpl implements ProdutividadeService {

	/** The repository. */
	private final ProdutividadeRepository repository;
       

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
	public ProdutividadeServiceImpl(final ProdutividadeRepository repository) {
		this.repository = repository;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<ProdutividadeMessageType> findDadosDevolucao(final ProdutividadeSearchCriteria criteria, final Pageable pageable) {
		
		final List<ProdutividadeMessageType> messages = new ArrayList<ProdutividadeMessageType>();
		
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
				    
                                final Page<Produtividade> devolucoes = this.repository.findByCodigoLojaAndDataExtracao(Integer.valueOf(criteria.getCodigoLoja()), criteria.getDataExtracaoString(), pageable);
				
                                cabecalho.setTotalPaginas(Long.valueOf(devolucoes.getTotalPages()));
				cabecalho.setTotalRegistros(devolucoes.getTotalElements());
				cabecalho.setTotalRegistrosPorPagina(Long.valueOf(pageable.getPageSize()));
				final ProdutividadeMessageType message = new ProdutividadeMessageType();
				message.setCabecalho(cabecalho);
				
				devolucoes.forEach(new Consumer<Produtividade>() {
					@Override
					public void accept(final Produtividade media) {
						
						final ProdutividadePayloadType payload = new ProdutividadePayloadType();
						
						//Preenche o payload para retornar
						payload.setSigla(media.getProdutividadePK().getSigla());
						payload.setData(media.getProdutividadePK().getData());
						payload.setOperador(media.getProdutividadePK().getOperador());
						payload.setTermnmbr(media.getProdutividadePK().getTermnmbr());
						payload.setHoraini(media.getProdutividadePK().getHoraini());
						payload.setHorafim(media.getProdutividadePK().getHorafim());
						payload.setDescoper(media.getDescoper());
						payload.setTipopdv(media.getTipopdv());
						payload.setDescpdv(media.getDescpdv());
						payload.setTempologado(media.getTempologado());
						payload.setAtividade(media.getAtividade());
						payload.setInatividade(media.getInatividade());
						payload.setInatividadepausa(media.getInatividadepausa());
						payload.setClientesicms(media.getClientesicms());
						payload.setTotalicms(media.getTotalicms());
						payload.setTempoicms(media.getTempoicms());
						payload.setClienteiss(media.getClienteiss());
						payload.setTotaliss(media.getTotaliss());
						payload.setTempoiss(media.getTempoiss());
						payload.setClienterecebimento(media.getClienterecebimento());
						payload.setTotalrec(media.getTotalrec());
						payload.setTemporec(media.getTemporec());
						payload.setConsultacc(media.getConsultacc());
						payload.setTempocc(media.getTempocc());
						payload.setIdentconsum(media.getIdentconsum());
						payload.setTempoident(media.getTempoident());
						payload.setSociotorcedor(media.getSociotorcedor());
						payload.setTemposociotoredor(media.getTemposociotoredor());
						payload.setItensscan(media.getItensscan());
						payload.setItensdig(media.getItensdig());
						payload.setItenspes(media.getItenspes());
						payload.setTempoitensdig(media.getTempoitensdig());
						payload.setTempoitensscan(media.getTempoitensscan());
						payload.setRecebimento(media.getRecebimento());
						payload.setDinhfinalvenda(media.getDinhfinalvenda());
						payload.setTempodinhvenda(media.getTempodinhvenda());
						payload.setTefpromofinalvenda(media.getTefpromofinalvenda());
						payload.setTempotefpromofinalvenda(media.getTempotefpromofinalvenda());
						payload.setAutorfinalvenda(media.getAutorfinalvenda());
						payload.setTempoautorfinalvenda(media.getTempoautorfinalvenda());
						payload.setDiversosfinalvenda(media.getDiversosfinalvenda());
						payload.setTempodiversosvenda(media.getTempodiversosvenda());
						payload.setTrocafinalvenda(media.getTrocafinalvenda());
						payload.setTempotrocavenda(media.getTempotrocavenda());
						payload.setChqfinalvenda(media.getChqfinalvenda());
						payload.setTempochqvenda(media.getTempochqvenda());
						payload.setTeffinalvenda(media.getTeffinalvenda());
						payload.setTempotefvendas(media.getTempotefvendas());
						payload.setOutrasfinalvenda(media.getOutrasfinalvenda());
						payload.setTempooutrasvenda(media.getTempooutrasvenda());
						payload.setRecarga(media.getRecarga());
						payload.setTempototalrecarga(media.getTempototalrecarga());
						payload.setCoban(media.getCoban());
						payload.setTempototalcoban(media.getTempototalcoban());
						payload.setCartaopresente(media.getCartaopresente());
						payload.setTempototcartaopresente(media.getTempototcartaopresente());
						payload.setFaturacartaocarrefour(media.getFaturacartaocarrefour());
						payload.setTempototalfatura(media.getTempototalfatura());
						payload.setDinhfinalrec(media.getDinhfinalrec());
						payload.setTempodinhrec(media.getTempodinhrec());
						payload.setDiversosfinalrec(media.getDiversosfinalrec());
						payload.setTempodiversosrec(media.getTempodiversosrec());
						payload.setTeffinalrec(media.getTeffinalrec());
						payload.setTempotefrec(media.getTempotefrec());
						payload.setChqfinalrec(media.getChqfinalrec());
						payload.setTempochqrec(media.getTempochqrec());
						payload.setOutrasfinalrec(media.getOutrasfinalrec());
						payload.setTempooutrasrec(media.getTempooutrasrec());
						payload.setCancitens(media.getCancitens());
						payload.setTempocancitens(media.getTempocancitens());
						payload.setCancvendas(media.getCancvendas());
						payload.setTempocancvendas(media.getTempocancvendas());
						payload.setCpc(media.getCpc());
						payload.setTempocpc(media.getTempocpc());
						payload.setDivergencia(media.getDivergencia());
						payload.setTempodivergencia(media.getTempodivergencia());
						payload.setOpbalcao(media.getOpbalcao());
						payload.setTempoopbalcao(media.getTempoopbalcao());
						payload.setSangria(media.getSangria());
						payload.setTemposangria(media.getTemposangria());
						payload.setRel104(media.getRel104());
						payload.setTemporel104(media.getTemporel104());
						payload.setOutrosrelat(media.getOutrosrelat());
						payload.setTempooutrosrelat(media.getTempooutrosrelat());
						payload.setTempofimpgtosemtefrec(media.getTempofimpgtosemtefrec());
						payload.setTempofimpgtocomtefrec(media.getTempofimpgtocomtefrec());
						payload.setTempofimpgtosemtefcupom(media.getTempofimpgtosemtefcupom());
						payload.setTempofimpgtocomtefcupom(media.getTempofimpgtocomtefcupom());
						payload.setOutrorec(media.getOutrorec());
						payload.setTempototalrec(media.getTempototalrec());
						
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
