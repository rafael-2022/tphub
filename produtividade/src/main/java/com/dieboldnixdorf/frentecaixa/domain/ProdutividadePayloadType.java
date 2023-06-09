//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.02.11 at 03:35:05 PM BRST 
//


package com.dieboldnixdorf.frentecaixa.domain;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProdutividadePayloadType", propOrder = {
		"sigla",
		"data",
		"operador",
		"termnmbr",
		"horaini",
		"horafim",
		"descoper",
		"tipopdv",
		"descpdv",
		"tempologado",
		"atividade",
		"inatividade",
		"inatividadepausa",
		"clientesicms",
		"totalicms",
		"tempoicms",
		"clienteiss",
		"totaliss",
		"tempoiss",
		"clienterecebimento",
		"totalrec",
		"temporec",
		"consultacc",
		"tempocc",
		"identconsum",
		"tempoident",
		"sociotorcedor",
		"temposociotoredor",
		"itensscan",
		"itensdig",
		"itenspes",
		"tempoitensdig",
		"tempoitensscan",
		"recebimento",
		"dinhfinalvenda",
		"tempodinhvenda",
		"tefpromofinalvenda",
		"tempotefpromofinalvenda",
		"autorfinalvenda",
		"tempoautorfinalvenda",
		"diversosfinalvenda",
		"tempodiversosvenda",
		"trocafinalvenda",
		"tempotrocavenda",
		"chqfinalvenda",
		"tempochqvenda",
		"teffinalvenda",
		"tempotefvendas",
		"outrasfinalvenda",
		"tempooutrasvenda",
		"recarga",
		"tempototalrecarga",
		"coban",
		"tempototalcoban",
		"cartaopresente",
		"tempototcartaopresente",
		"faturacartaocarrefour",
		"tempototalfatura",
		"dinhfinalrec",
		"tempodinhrec",
		"diversosfinalrec",
		"tempodiversosrec",
		"teffinalrec",
		"tempotefrec",
		"chqfinalrec",
		"tempochqrec",
		"outrasfinalrec",
		"tempooutrasrec",
		"cancitens",
		"tempocancitens",
		"cancvendas",
		"tempocancvendas",
		"cpc",
		"tempocpc",
		"divergencia",
		"tempodivergencia",
		"opbalcao",
		"tempoopbalcao",
		"sangria",
		"temposangria",
		"rel104",
		"temporel104",
		"outrosrelat",
		"tempooutrosrelat",
		"tempofimpgtosemtefrec",
		"tempofimpgtocomtefrec",
		"tempofimpgtosemtefcupom",
		"tempofimpgtocomtefcupom",
		"outrorec",
		"tempototalrec"
})
@JsonPropertyOrder({ 
	"sigla",
	"data",
	"operador",
	"termnmbr",
	"horaini",
	"horafim",
	"descoper",
	"tipopdv",
	"descpdv",
	"tempologado",
	"atividade",
	"inatividade",
	"inatividadepausa",
	"clientesicms",
	"totalicms",
	"tempoicms",
	"clienteiss",
	"totaliss",
	"tempoiss",
	"clienterecebimento",
	"totalrec",
	"temporec",
	"consultacc",
	"tempocc",
	"identconsum",
	"tempoident",
	"sociotorcedor",
	"temposociotoredor",
	"itensscan",
	"itensdig",
	"itenspes",
	"tempoitensdig",
	"tempoitensscan",
	"recebimento",
	"dinhfinalvenda",
	"tempodinhvenda",
	"tefpromofinalvenda",
	"tempotefpromofinalvenda",
	"autorfinalvenda",
	"tempoautorfinalvenda",
	"diversosfinalvenda",
	"tempodiversosvenda",
	"trocafinalvenda",
	"tempotrocavenda",
	"chqfinalvenda",
	"tempochqvenda",
	"teffinalvenda",
	"tempotefvendas",
	"outrasfinalvenda",
	"tempooutrasvenda",
	"recarga",
	"tempototalrecarga",
	"coban",
	"tempototalcoban",
	"cartaopresente",
	"tempototcartaopresente",
	"faturacartaocarrefour",
	"tempototalfatura",
	"dinhfinalrec",
	"tempodinhrec",
	"diversosfinalrec",
	"tempodiversosrec",
	"teffinalrec",
	"tempotefrec",
	"chqfinalrec",
	"tempochqrec",
	"outrasfinalrec",
	"tempooutrasrec",
	"cancitens",
	"tempocancitens",
	"cancvendas",
	"tempocancvendas",
	"cpc",
	"tempocpc",
	"divergencia",
	"tempodivergencia",
	"opbalcao",
	"tempoopbalcao",
	"sangria",
	"temposangria",
	"rel104",
	"temporel104",
	"outrosrelat",
	"tempooutrosrelat",
	"tempofimpgtosemtefrec",
	"tempofimpgtocomtefrec",
	"tempofimpgtosemtefcupom",
	"tempofimpgtocomtefcupom",
	"outrorec",
	"tempototalrec"
})


public class ProdutividadePayloadType
    implements Serializable
{

    private final static long serialVersionUID = 1L;
   
    private String sigla;
    private Integer	data;
    private Integer	operador;
    private Integer	termnmbr;
    private Long	horaini;
    private Long	horafim;
    private String	descoper;
    private Integer	tipopdv;
    private String	descpdv;
    private Integer	tempologado;
    private Integer	atividade;
    private Integer	inatividade;
    private Integer	inatividadepausa;
    private Integer	clientesicms;
    private Integer	totalicms;
    private Integer	tempoicms;
    private Integer	clienteiss;
    private Integer	totaliss;
    private Integer	tempoiss;
    private Integer	clienterecebimento;
    private Integer	totalrec;
    private Integer	temporec;
    private Integer	consultacc;
    private Integer	tempocc;
    private Integer	identconsum;
    private Integer	tempoident;
    private Integer	sociotorcedor;
    private Integer	temposociotoredor;
    private Integer	itensscan;
    private Integer	itensdig;
    private Integer	itenspes;
    private Integer	tempoitensdig;
    private Integer	tempoitensscan;
    private Integer	recebimento;
    private Integer	dinhfinalvenda;
    private Integer	tempodinhvenda;
    private Integer	tefpromofinalvenda;
    private Integer	tempotefpromofinalvenda;
    private Integer	autorfinalvenda;
    private Integer	tempoautorfinalvenda;
    private Integer	diversosfinalvenda;
    private Integer	tempodiversosvenda;
    private Integer	trocafinalvenda;
    private Integer	tempotrocavenda;
    private Integer	chqfinalvenda;
    private Integer	tempochqvenda;
    private Integer	teffinalvenda;
    private Integer	tempotefvendas;
    private Integer	outrasfinalvenda;
    private Integer	tempooutrasvenda;
    private Integer	recarga;
    private Integer	tempototalrecarga;
    private Integer	coban;
    private Integer	tempototalcoban;
    private Integer	cartaopresente;
    private Integer	tempototcartaopresente;
    private Integer	faturacartaocarrefour;
    private Integer	tempototalfatura;
    private Integer	dinhfinalrec;
    private Integer	tempodinhrec;
    private Integer	diversosfinalrec;
    private Integer	tempodiversosrec;
    private Integer	teffinalrec;
    private Integer	tempotefrec;
    private Integer	chqfinalrec;
    private Integer	tempochqrec;
    private Integer	outrasfinalrec;
    private Integer	tempooutrasrec;
    private Integer	cancitens;
    private Integer	tempocancitens;
    private Integer	cancvendas;
    private Integer	tempocancvendas;
    private Integer	cpc;
    private Integer	tempocpc;
    private Integer	divergencia;
    private Integer	tempodivergencia;
    private Integer	opbalcao;
    private Integer	tempoopbalcao;
    private Integer	sangria;
    private Integer	temposangria;
    private Integer	rel104;
    private Integer	temporel104;
    private Integer	outrosrelat;
    private Integer	tempooutrosrelat;
    private Integer	tempofimpgtosemtefrec;
    private Integer	tempofimpgtocomtefrec;
    private Integer	tempofimpgtosemtefcupom;
    private Integer	tempofimpgtocomtefcupom;
    private Integer	outrorec;
    private Integer	tempototalrec;
	/**
	 * @return the sigla
	 */
	public String getSigla() {
		return sigla;
	}
	/**
	 * @param sigla the sigla to set
	 */
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	/**
	 * @return the data
	 */
	public Integer getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(Integer data) {
		this.data = data;
	}
	/**
	 * @return the operador
	 */
	public Integer getOperador() {
		return operador;
	}
	/**
	 * @param operador the operador to set
	 */
	public void setOperador(Integer operador) {
		this.operador = operador;
	}
	/**
	 * @return the termnmbr
	 */
	public Integer getTermnmbr() {
		return termnmbr;
	}
	/**
	 * @param termnmbr the termnmbr to set
	 */
	public void setTermnmbr(Integer termnmbr) {
		this.termnmbr = termnmbr;
	}
	/**
	 * @return the horaini
	 */
	public Long getHoraini() {
		return horaini;
	}
	/**
	 * @param horini the horini to set
	 */
	public void setHoraini(Long horaini) {
		this.horaini = horaini;
	}
	/**
	 * @return the horafim
	 */
	public Long getHorafim() {
		return horafim;
	}
	/**
	 * @param horafim the horafim to set
	 */
	public void setHorafim(Long horafim) {
		this.horafim = horafim;
	}
	/**
	 * @return the descoper
	 */
	public String getDescoper() {
		return descoper;
	}
	/**
	 * @param descoper the descoper to set
	 */
	public void setDescoper(String descoper) {
		this.descoper = descoper;
	}
	/**
	 * @return the tipopdv
	 */
	public Integer getTipopdv() {
		return tipopdv;
	}
	/**
	 * @param tipopdv the tipopdv to set
	 */
	public void setTipopdv(Integer tipopdv) {
		this.tipopdv = tipopdv;
	}
	/**
	 * @return the descpdv
	 */
	public String getDescpdv() {
		return descpdv;
	}
	/**
	 * @param descpdv the descpdv to set
	 */
	public void setDescpdv(String descpdv) {
		this.descpdv = descpdv;
	}
	/**
	 * @return the tempologado
	 */
	public Integer getTempologado() {
		return tempologado;
	}
	/**
	 * @param tempologado the tempologado to set
	 */
	public void setTempologado(Integer tempologado) {
		this.tempologado = tempologado;
	}
	/**
	 * @return the atividade
	 */
	public Integer getAtividade() {
		return atividade;
	}
	/**
	 * @param atividade the atividade to set
	 */
	public void setAtividade(Integer atividade) {
		this.atividade = atividade;
	}
	/**
	 * @return the inatividade
	 */
	public Integer getInatividade() {
		return inatividade;
	}
	/**
	 * @param inatividade the inatividade to set
	 */
	public void setInatividade(Integer inatividade) {
		this.inatividade = inatividade;
	}
	/**
	 * @return the inatividadepausa
	 */
	public Integer getInatividadepausa() {
		return inatividadepausa;
	}
	/**
	 * @param inatividadepausa the inatividadepausa to set
	 */
	public void setInatividadepausa(Integer inatividadepausa) {
		this.inatividadepausa = inatividadepausa;
	}
	/**
	 * @return the clientesicms
	 */
	public Integer getClientesicms() {
		return clientesicms;
	}
	/**
	 * @param clientesicms the clientesicms to set
	 */
	public void setClientesicms(Integer clientesicms) {
		this.clientesicms = clientesicms;
	}
	/**
	 * @return the totalicms
	 */
	public Integer getTotalicms() {
		return totalicms;
	}
	/**
	 * @param totalicms the totalicms to set
	 */
	public void setTotalicms(Integer totalicms) {
		this.totalicms = totalicms;
	}
	/**
	 * @return the tempoicms
	 */
	public Integer getTempoicms() {
		return tempoicms;
	}
	/**
	 * @param tempoicms the tempoicms to set
	 */
	public void setTempoicms(Integer tempoicms) {
		this.tempoicms = tempoicms;
	}
	/**
	 * @return the clienteiss
	 */
	public Integer getClienteiss() {
		return clienteiss;
	}
	/**
	 * @param clienteiss the clienteiss to set
	 */
	public void setClienteiss(Integer clienteiss) {
		this.clienteiss = clienteiss;
	}
	/**
	 * @return the totaliss
	 */
	public Integer getTotaliss() {
		return totaliss;
	}
	/**
	 * @param totaliss the totaliss to set
	 */
	public void setTotaliss(Integer totaliss) {
		this.totaliss = totaliss;
	}
	/**
	 * @return the tempoiss
	 */
	public Integer getTempoiss() {
		return tempoiss;
	}
	/**
	 * @param tempoiss the tempoiss to set
	 */
	public void setTempoiss(Integer tempoiss) {
		this.tempoiss = tempoiss;
	}
	/**
	 * @return the clienterecebimento
	 */
	public Integer getClienterecebimento() {
		return clienterecebimento;
	}
	/**
	 * @param clienterecebimento the clienterecebimento to set
	 */
	public void setClienterecebimento(Integer clienterecebimento) {
		this.clienterecebimento = clienterecebimento;
	}
	/**
	 * @return the totalrec
	 */
	public Integer getTotalrec() {
		return totalrec;
	}
	/**
	 * @param totalrec the totalrec to set
	 */
	public void setTotalrec(Integer totalrec) {
		this.totalrec = totalrec;
	}
	/**
	 * @return the temporec
	 */
	public Integer getTemporec() {
		return temporec;
	}
	/**
	 * @param temporec the temporec to set
	 */
	public void setTemporec(Integer temporec) {
		this.temporec = temporec;
	}
	/**
	 * @return the consultacc
	 */
	public Integer getConsultacc() {
		return consultacc;
	}
	/**
	 * @param consultacc the consultacc to set
	 */
	public void setConsultacc(Integer consultacc) {
		this.consultacc = consultacc;
	}
	/**
	 * @return the tempocc
	 */
	public Integer getTempocc() {
		return tempocc;
	}
	/**
	 * @param tempocc the tempocc to set
	 */
	public void setTempocc(Integer tempocc) {
		this.tempocc = tempocc;
	}
	/**
	 * @return the identconsum
	 */
	public Integer getIdentconsum() {
		return identconsum;
	}
	/**
	 * @param identconsum the identconsum to set
	 */
	public void setIdentconsum(Integer identconsum) {
		this.identconsum = identconsum;
	}
	/**
	 * @return the tempoident
	 */
	public Integer getTempoident() {
		return tempoident;
	}
	/**
	 * @param tempoident the tempoident to set
	 */
	public void setTempoident(Integer tempoident) {
		this.tempoident = tempoident;
	}
	/**
	 * @return the sociotorcedor
	 */
	public Integer getSociotorcedor() {
		return sociotorcedor;
	}
	/**
	 * @param sociotorcedor the sociotorcedor to set
	 */
	public void setSociotorcedor(Integer sociotorcedor) {
		this.sociotorcedor = sociotorcedor;
	}
	/**
	 * @return the temposociotoredor
	 */
	public Integer getTemposociotoredor() {
		return temposociotoredor;
	}
	/**
	 * @param temposociotoredor the temposociotoredor to set
	 */
	public void setTemposociotoredor(Integer temposociotoredor) {
		this.temposociotoredor = temposociotoredor;
	}
	/**
	 * @return the itensscan
	 */
	public Integer getItensscan() {
		return itensscan;
	}
	/**
	 * @param itensscan the itensscan to set
	 */
	public void setItensscan(Integer itensscan) {
		this.itensscan = itensscan;
	}
	/**
	 * @return the itensdig
	 */
	public Integer getItensdig() {
		return itensdig;
	}
	/**
	 * @param itensdig the itensdig to set
	 */
	public void setItensdig(Integer itensdig) {
		this.itensdig = itensdig;
	}
	/**
	 * @return the itenspes
	 */
	public Integer getItenspes() {
		return itenspes;
	}
	/**
	 * @param itenspes the itenspes to set
	 */
	public void setItenspes(Integer itenspes) {
		this.itenspes = itenspes;
	}
	/**
	 * @return the tempoitensdig
	 */
	public Integer getTempoitensdig() {
		return tempoitensdig;
	}
	/**
	 * @param tempoitensdig the tempoitensdig to set
	 */
	public void setTempoitensdig(Integer tempoitensdig) {
		this.tempoitensdig = tempoitensdig;
	}
	/**
	 * @return the tempoitensscan
	 */
	public Integer getTempoitensscan() {
		return tempoitensscan;
	}
	/**
	 * @param tempoitensscan the tempoitensscan to set
	 */
	public void setTempoitensscan(Integer tempoitensscan) {
		this.tempoitensscan = tempoitensscan;
	}
	/**
	 * @return the recebimento
	 */
	public Integer getRecebimento() {
		return recebimento;
	}
	/**
	 * @param recebimento the recebimento to set
	 */
	public void setRecebimento(Integer recebimento) {
		this.recebimento = recebimento;
	}
	/**
	 * @return the dinhfinalvenda
	 */
	public Integer getDinhfinalvenda() {
		return dinhfinalvenda;
	}
	/**
	 * @param dinhfinalvenda the dinhfinalvenda to set
	 */
	public void setDinhfinalvenda(Integer dinhfinalvenda) {
		this.dinhfinalvenda = dinhfinalvenda;
	}
	/**
	 * @return the tempodinhvenda
	 */
	public Integer getTempodinhvenda() {
		return tempodinhvenda;
	}
	/**
	 * @param tempodinhvenda the tempodinhvenda to set
	 */
	public void setTempodinhvenda(Integer tempodinhvenda) {
		this.tempodinhvenda = tempodinhvenda;
	}
	/**
	 * @return the tefpromofinalvenda
	 */
	public Integer getTefpromofinalvenda() {
		return tefpromofinalvenda;
	}
	/**
	 * @param tefpromofinalvenda the tefpromofinalvenda to set
	 */
	public void setTefpromofinalvenda(Integer tefpromofinalvenda) {
		this.tefpromofinalvenda = tefpromofinalvenda;
	}
	/**
	 * @return the tempotefpromofinalvenda
	 */
	public Integer getTempotefpromofinalvenda() {
		return tempotefpromofinalvenda;
	}
	/**
	 * @param tempotefpromofinalvenda the tempotefpromofinalvenda to set
	 */
	public void setTempotefpromofinalvenda(Integer tempotefpromofinalvenda) {
		this.tempotefpromofinalvenda = tempotefpromofinalvenda;
	}
	/**
	 * @return the autorfinalvenda
	 */
	public Integer getAutorfinalvenda() {
		return autorfinalvenda;
	}
	/**
	 * @param autorfinalvenda the autorfinalvenda to set
	 */
	public void setAutorfinalvenda(Integer autorfinalvenda) {
		this.autorfinalvenda = autorfinalvenda;
	}
	/**
	 * @return the tempoautorfinalvenda
	 */
	public Integer getTempoautorfinalvenda() {
		return tempoautorfinalvenda;
	}
	/**
	 * @param tempoautorfinalvenda the tempoautorfinalvenda to set
	 */
	public void setTempoautorfinalvenda(Integer tempoautorfinalvenda) {
		this.tempoautorfinalvenda = tempoautorfinalvenda;
	}
	/**
	 * @return the diversosfinalvenda
	 */
	public Integer getDiversosfinalvenda() {
		return diversosfinalvenda;
	}
	/**
	 * @param diversosfinalvenda the diversosfinalvenda to set
	 */
	public void setDiversosfinalvenda(Integer diversosfinalvenda) {
		this.diversosfinalvenda = diversosfinalvenda;
	}
	/**
	 * @return the tempodiversosvenda
	 */
	public Integer getTempodiversosvenda() {
		return tempodiversosvenda;
	}
	/**
	 * @param tempodiversosvenda the tempodiversosvenda to set
	 */
	public void setTempodiversosvenda(Integer tempodiversosvenda) {
		this.tempodiversosvenda = tempodiversosvenda;
	}
	/**
	 * @return the trocafinalvenda
	 */
	public Integer getTrocafinalvenda() {
		return trocafinalvenda;
	}
	/**
	 * @param trocafinalvenda the trocafinalvenda to set
	 */
	public void setTrocafinalvenda(Integer trocafinalvenda) {
		this.trocafinalvenda = trocafinalvenda;
	}
	/**
	 * @return the tempotrocavenda
	 */
	public Integer getTempotrocavenda() {
		return tempotrocavenda;
	}
	/**
	 * @param tempotrocavenda the tempotrocavenda to set
	 */
	public void setTempotrocavenda(Integer tempotrocavenda) {
		this.tempotrocavenda = tempotrocavenda;
	}
	/**
	 * @return the chqfinalvenda
	 */
	public Integer getChqfinalvenda() {
		return chqfinalvenda;
	}
	/**
	 * @param chqfinalvenda the chqfinalvenda to set
	 */
	public void setChqfinalvenda(Integer chqfinalvenda) {
		this.chqfinalvenda = chqfinalvenda;
	}
	/**
	 * @return the tempochqvenda
	 */
	public Integer getTempochqvenda() {
		return tempochqvenda;
	}
	/**
	 * @param tempochqvenda the tempochqvenda to set
	 */
	public void setTempochqvenda(Integer tempochqvenda) {
		this.tempochqvenda = tempochqvenda;
	}
	/**
	 * @return the teffinalvenda
	 */
	public Integer getTeffinalvenda() {
		return teffinalvenda;
	}
	/**
	 * @param teffinalvenda the teffinalvenda to set
	 */
	public void setTeffinalvenda(Integer teffinalvenda) {
		this.teffinalvenda = teffinalvenda;
	}
	/**
	 * @return the tempotefvendas
	 */
	public Integer getTempotefvendas() {
		return tempotefvendas;
	}
	/**
	 * @param tempotefvendas the tempotefvendas to set
	 */
	public void setTempotefvendas(Integer tempotefvendas) {
		this.tempotefvendas = tempotefvendas;
	}
	/**
	 * @return the outrasfinalvenda
	 */
	public Integer getOutrasfinalvenda() {
		return outrasfinalvenda;
	}
	/**
	 * @param outrasfinalvenda the outrasfinalvenda to set
	 */
	public void setOutrasfinalvenda(Integer outrasfinalvenda) {
		this.outrasfinalvenda = outrasfinalvenda;
	}
	/**
	 * @return the tempooutrasvenda
	 */
	public Integer getTempooutrasvenda() {
		return tempooutrasvenda;
	}
	/**
	 * @param tempooutrasvenda the tempooutrasvenda to set
	 */
	public void setTempooutrasvenda(Integer tempooutrasvenda) {
		this.tempooutrasvenda = tempooutrasvenda;
	}
	/**
	 * @return the recarga
	 */
	public Integer getRecarga() {
		return recarga;
	}
	/**
	 * @param recarga the recarga to set
	 */
	public void setRecarga(Integer recarga) {
		this.recarga = recarga;
	}
	/**
	 * @return the tempototalrecarga
	 */
	public Integer getTempototalrecarga() {
		return tempototalrecarga;
	}
	/**
	 * @param tempototalrecarga the tempototalrecarga to set
	 */
	public void setTempototalrecarga(Integer tempototalrecarga) {
		this.tempototalrecarga = tempototalrecarga;
	}
	/**
	 * @return the coban
	 */
	public Integer getCoban() {
		return coban;
	}
	/**
	 * @param coban the coban to set
	 */
	public void setCoban(Integer coban) {
		this.coban = coban;
	}
	/**
	 * @return the tempototalcoban
	 */
	public Integer getTempototalcoban() {
		return tempototalcoban;
	}
	/**
	 * @param tempototalcoban the tempototalcoban to set
	 */
	public void setTempototalcoban(Integer tempototalcoban) {
		this.tempototalcoban = tempototalcoban;
	}
	/**
	 * @return the cartaopresente
	 */
	public Integer getCartaopresente() {
		return cartaopresente;
	}
	/**
	 * @param cartaopresente the cartaopresente to set
	 */
	public void setCartaopresente(Integer cartaopresente) {
		this.cartaopresente = cartaopresente;
	}
	/**
	 * @return the tempototcartaopresente
	 */
	public Integer getTempototcartaopresente() {
		return tempototcartaopresente;
	}
	/**
	 * @param tempototcartaopresente the tempototcartaopresente to set
	 */
	public void setTempototcartaopresente(Integer tempototcartaopresente) {
		this.tempototcartaopresente = tempototcartaopresente;
	}
	/**
	 * @return the faturacartaocarrefour
	 */
	public Integer getFaturacartaocarrefour() {
		return faturacartaocarrefour;
	}
	/**
	 * @param faturacartaocarrefour the faturacartaocarrefour to set
	 */
	public void setFaturacartaocarrefour(Integer faturacartaocarrefour) {
		this.faturacartaocarrefour = faturacartaocarrefour;
	}
	/**
	 * @return the tempototalfatura
	 */
	public Integer getTempototalfatura() {
		return tempototalfatura;
	}
	/**
	 * @param tempototalfatura the tempototalfatura to set
	 */
	public void setTempototalfatura(Integer tempototalfatura) {
		this.tempototalfatura = tempototalfatura;
	}
	/**
	 * @return the dinhfinalrec
	 */
	public Integer getDinhfinalrec() {
		return dinhfinalrec;
	}
	/**
	 * @param dinhfinalrec the dinhfinalrec to set
	 */
	public void setDinhfinalrec(Integer dinhfinalrec) {
		this.dinhfinalrec = dinhfinalrec;
	}
	/**
	 * @return the tempodinhrec
	 */
	public Integer getTempodinhrec() {
		return tempodinhrec;
	}
	/**
	 * @param tempodinhrec the tempodinhrec to set
	 */
	public void setTempodinhrec(Integer tempodinhrec) {
		this.tempodinhrec = tempodinhrec;
	}
	/**
	 * @return the diversosfinalrec
	 */
	public Integer getDiversosfinalrec() {
		return diversosfinalrec;
	}
	/**
	 * @param diversosfinalrec the diversosfinalrec to set
	 */
	public void setDiversosfinalrec(Integer diversosfinalrec) {
		this.diversosfinalrec = diversosfinalrec;
	}
	/**
	 * @return the tempodiversosrec
	 */
	public Integer getTempodiversosrec() {
		return tempodiversosrec;
	}
	/**
	 * @param tempodiversosrec the tempodiversosrec to set
	 */
	public void setTempodiversosrec(Integer tempodiversosrec) {
		this.tempodiversosrec = tempodiversosrec;
	}
	/**
	 * @return the teffinalrec
	 */
	public Integer getTeffinalrec() {
		return teffinalrec;
	}
	/**
	 * @param teffinalrec the teffinalrec to set
	 */
	public void setTeffinalrec(Integer teffinalrec) {
		this.teffinalrec = teffinalrec;
	}
	/**
	 * @return the tempotefrec
	 */
	public Integer getTempotefrec() {
		return tempotefrec;
	}
	/**
	 * @param tempotefrec the tempotefrec to set
	 */
	public void setTempotefrec(Integer tempotefrec) {
		this.tempotefrec = tempotefrec;
	}
	/**
	 * @return the chqfinalrec
	 */
	public Integer getChqfinalrec() {
		return chqfinalrec;
	}
	/**
	 * @param chqfinalrec the chqfinalrec to set
	 */
	public void setChqfinalrec(Integer chqfinalrec) {
		this.chqfinalrec = chqfinalrec;
	}
	/**
	 * @return the tempochqrec
	 */
	public Integer getTempochqrec() {
		return tempochqrec;
	}
	/**
	 * @param tempochqrec the tempochqrec to set
	 */
	public void setTempochqrec(Integer tempochqrec) {
		this.tempochqrec = tempochqrec;
	}
	/**
	 * @return the outrasfinalrec
	 */
	public Integer getOutrasfinalrec() {
		return outrasfinalrec;
	}
	/**
	 * @param outrasfinalrec the outrasfinalrec to set
	 */
	public void setOutrasfinalrec(Integer outrasfinalrec) {
		this.outrasfinalrec = outrasfinalrec;
	}
	/**
	 * @return the tempooutrasrec
	 */
	public Integer getTempooutrasrec() {
		return tempooutrasrec;
	}
	/**
	 * @param tempooutrasrec the tempooutrasrec to set
	 */
	public void setTempooutrasrec(Integer tempooutrasrec) {
		this.tempooutrasrec = tempooutrasrec;
	}
	/**
	 * @return the cancitens
	 */
	public Integer getCancitens() {
		return cancitens;
	}
	/**
	 * @param cancitens the cancitens to set
	 */
	public void setCancitens(Integer cancitens) {
		this.cancitens = cancitens;
	}
	/**
	 * @return the tempocancitens
	 */
	public Integer getTempocancitens() {
		return tempocancitens;
	}
	/**
	 * @param tempocancitens the tempocancitens to set
	 */
	public void setTempocancitens(Integer tempocancitens) {
		this.tempocancitens = tempocancitens;
	}
	/**
	 * @return the cancvendas
	 */
	public Integer getCancvendas() {
		return cancvendas;
	}
	/**
	 * @param cancvendas the cancvendas to set
	 */
	public void setCancvendas(Integer cancvendas) {
		this.cancvendas = cancvendas;
	}
	/**
	 * @return the tempocancvendas
	 */
	public Integer getTempocancvendas() {
		return tempocancvendas;
	}
	/**
	 * @param tempocancvendas the tempocancvendas to set
	 */
	public void setTempocancvendas(Integer tempocancvendas) {
		this.tempocancvendas = tempocancvendas;
	}
	/**
	 * @return the cpc
	 */
	public Integer getCpc() {
		return cpc;
	}
	/**
	 * @param cpc the cpc to set
	 */
	public void setCpc(Integer cpc) {
		this.cpc = cpc;
	}
	/**
	 * @return the tempocpc
	 */
	public Integer getTempocpc() {
		return tempocpc;
	}
	/**
	 * @param tempocpc the tempocpc to set
	 */
	public void setTempocpc(Integer tempocpc) {
		this.tempocpc = tempocpc;
	}
	/**
	 * @return the divergencia
	 */
	public Integer getDivergencia() {
		return divergencia;
	}
	/**
	 * @param divergencia the divergencia to set
	 */
	public void setDivergencia(Integer divergencia) {
		this.divergencia = divergencia;
	}
	/**
	 * @return the tempodivergencia
	 */
	public Integer getTempodivergencia() {
		return tempodivergencia;
	}
	/**
	 * @param tempodivergencia the tempodivergencia to set
	 */
	public void setTempodivergencia(Integer tempodivergencia) {
		this.tempodivergencia = tempodivergencia;
	}
	/**
	 * @return the opbalcao
	 */
	public Integer getOpbalcao() {
		return opbalcao;
	}
	/**
	 * @param opbalcao the opbalcao to set
	 */
	public void setOpbalcao(Integer opbalcao) {
		this.opbalcao = opbalcao;
	}
	/**
	 * @return the tempoopbalcao
	 */
	public Integer getTempoopbalcao() {
		return tempoopbalcao;
	}
	/**
	 * @param tempoopbalcao the tempoopbalcao to set
	 */
	public void setTempoopbalcao(Integer tempoopbalcao) {
		this.tempoopbalcao = tempoopbalcao;
	}
	/**
	 * @return the sangria
	 */
	public Integer getSangria() {
		return sangria;
	}
	/**
	 * @param sangria the sangria to set
	 */
	public void setSangria(Integer sangria) {
		this.sangria = sangria;
	}
	/**
	 * @return the temposangria
	 */
	public Integer getTemposangria() {
		return temposangria;
	}
	/**
	 * @param temposangria the temposangria to set
	 */
	public void setTemposangria(Integer temposangria) {
		this.temposangria = temposangria;
	}
	/**
	 * @return the rel104
	 */
	public Integer getRel104() {
		return rel104;
	}
	/**
	 * @param rel104 the rel104 to set
	 */
	public void setRel104(Integer rel104) {
		this.rel104 = rel104;
	}
	/**
	 * @return the temporel104
	 */
	public Integer getTemporel104() {
		return temporel104;
	}
	/**
	 * @param temporel104 the temporel104 to set
	 */
	public void setTemporel104(Integer temporel104) {
		this.temporel104 = temporel104;
	}
	/**
	 * @return the outrosrelat
	 */
	public Integer getOutrosrelat() {
		return outrosrelat;
	}
	/**
	 * @param outrosrelat the outrosrelat to set
	 */
	public void setOutrosrelat(Integer outrosrelat) {
		this.outrosrelat = outrosrelat;
	}
	/**
	 * @return the tempooutrosrelat
	 */
	public Integer getTempooutrosrelat() {
		return tempooutrosrelat;
	}
	/**
	 * @param tempooutrosrelat the tempooutrosrelat to set
	 */
	public void setTempooutrosrelat(Integer tempooutrosrelat) {
		this.tempooutrosrelat = tempooutrosrelat;
	}
	/**
	 * @return the tempofimpgtosemtefrec
	 */
	public Integer getTempofimpgtosemtefrec() {
		return tempofimpgtosemtefrec;
	}
	/**
	 * @param tempofimpgtosemtefrec the tempofimpgtosemtefrec to set
	 */
	public void setTempofimpgtosemtefrec(Integer tempofimpgtosemtefrec) {
		this.tempofimpgtosemtefrec = tempofimpgtosemtefrec;
	}
	/**
	 * @return the tempofimpgtocomtefrec
	 */
	public Integer getTempofimpgtocomtefrec() {
		return tempofimpgtocomtefrec;
	}
	/**
	 * @param tempofimpgtocomtefrec the tempofimpgtocomtefrec to set
	 */
	public void setTempofimpgtocomtefrec(Integer tempofimpgtocomtefrec) {
		this.tempofimpgtocomtefrec = tempofimpgtocomtefrec;
	}
	/**
	 * @return the tempofimpgtosemtefcupom
	 */
	public Integer getTempofimpgtosemtefcupom() {
		return tempofimpgtosemtefcupom;
	}
	/**
	 * @param tempofimpgtosemtefcupom the tempofimpgtosemtefcupom to set
	 */
	public void setTempofimpgtosemtefcupom(Integer tempofimpgtosemtefcupom) {
		this.tempofimpgtosemtefcupom = tempofimpgtosemtefcupom;
	}
	/**
	 * @return the tempofimpgtocomtefcupom
	 */
	public Integer getTempofimpgtocomtefcupom() {
		return tempofimpgtocomtefcupom;
	}
	/**
	 * @param tempofimpgtocomtefcupom the tempofimpgtocomtefcupom to set
	 */
	public void setTempofimpgtocomtefcupom(Integer tempofimpgtocomtefcupom) {
		this.tempofimpgtocomtefcupom = tempofimpgtocomtefcupom;
	}
	/**
	 * @return the outrorec
	 */
	public Integer getOutrorec() {
		return outrorec;
	}
	/**
	 * @param outrorec the outrorec to set
	 */
	public void setOutrorec(Integer outrorec) {
		this.outrorec = outrorec;
	}
	/**
	 * @return the tempototalrec
	 */
	public Integer getTempototalrec() {
		return tempototalrec;
	}
	/**
	 * @param tempototalrec the tempototalrec to set
	 */
	public void setTempototalrec(Integer tempototalrec) {
		this.tempototalrec = tempototalrec;
	}
    
    
    
}
