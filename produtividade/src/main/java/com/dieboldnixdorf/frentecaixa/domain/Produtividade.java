package com.dieboldnixdorf.frentecaixa.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Class DevRecebimento.
 */
@Entity
@Table
public class Produtividade {

    @EmbeddedId
    private ProdutividadePK produtividadePK;
    /*@Id
	@Column(name="cshrnmbr", columnDefinition="int8")
	private Long cshrnmbr;*/

    
    @Basic
    @Column(name = "descoper", columnDefinition = "string")
    private String descoper;

    @Basic
    @Column(name = "tipopdv", columnDefinition = "int4")
    private Integer tipopdv;

    @Basic
    @Column(name = "descpdv", columnDefinition = "string")
    private String descpdv;

    @Basic
    @Column(name = "tempologado", columnDefinition = "int4")
    private Integer tempologado;

    @Basic
    @Column(name = "atividade", columnDefinition = "int4")
    private Integer atividade;

    @Basic
    @Column(name = "inatividade", columnDefinition = "int4")
    private Integer inatividade;

    @Basic
    @Column(name = "inatividadepausa", columnDefinition = "int4")
    private Integer inatividadepausa;

    @Basic
    @Column(name = "clientesicms", columnDefinition = "int4")
    private Integer clientesicms;

    @Basic
    @Column(name = "totalicms", columnDefinition = "int4")
    private Integer totalicms;

    @Basic
    @Column(name = "tempoicms", columnDefinition = "int4")
    private Integer tempoicms;

    @Basic
    @Column(name = "clienteiss", columnDefinition = "int4")
    private Integer clienteiss;

    @Basic
    @Column(name = "totaliss", columnDefinition = "int4")
    private Integer totaliss;

    @Basic
    @Column(name = "tempoiss", columnDefinition = "int4")
    private Integer tempoiss;

    @Basic
    @Column(name = "clienterecebimento", columnDefinition = "int4")
    private Integer clienterecebimento;

    @Basic
    @Column(name = "totalrec", columnDefinition = "int4")
    private Integer totalrec;

    @Basic
    @Column(name = "temporec", columnDefinition = "int4")
    private Integer temporec;

    @Basic
    @Column(name = "consultacc", columnDefinition = "int4")
    private Integer consultacc;

    @Basic
    @Column(name = "tempocc", columnDefinition = "int4")
    private Integer tempocc;

    @Basic
    @Column(name = "identconsum", columnDefinition = "int4")
    private Integer identconsum;

    @Basic
    @Column(name = "tempoident", columnDefinition = "int4")
    private Integer tempoident;

    @Basic
    @Column(name = "sociotorcedor", columnDefinition = "int4")
    private Integer sociotorcedor;

    @Basic
    @Column(name = "temposociotoredor", columnDefinition = "int4")
    private Integer temposociotoredor;

    @Basic
    @Column(name = "itensscan", columnDefinition = "int4")
    private Integer itensscan;

    @Basic
    @Column(name = "itensdig", columnDefinition = "int4")
    private Integer itensdig;

    @Basic
    @Column(name = "itenspes", columnDefinition = "int4")
    private Integer itenspes;

    @Basic
    @Column(name = "tempoitensdig", columnDefinition = "int4")
    private Integer tempoitensdig;

    @Basic
    @Column(name = "tempoitensscan", columnDefinition = "int4")
    private Integer tempoitensscan;

    @Basic
    @Column(name = "recebimento", columnDefinition = "int4")
    private Integer recebimento;

    @Basic
    @Column(name = "dinhfinalvenda", columnDefinition = "int4")
    private Integer dinhfinalvenda;

    @Basic
    @Column(name = "tempodinhvenda", columnDefinition = "int4")
    private Integer tempodinhvenda;

    @Basic
    @Column(name = "tefpromofinalvenda", columnDefinition = "int4")
    private Integer tefpromofinalvenda;

    @Basic
    @Column(name = "tempotefpromofinalvenda", columnDefinition = "int4")
    private Integer tempotefpromofinalvenda;

    @Basic
    @Column(name = "autorfinalvenda", columnDefinition = "int4")
    private Integer autorfinalvenda;

    @Basic
    @Column(name = "tempoautorfinalvenda", columnDefinition = "int4")
    private Integer tempoautorfinalvenda;

    @Basic
    @Column(name = "diversosfinalvenda", columnDefinition = "int4")
    private Integer diversosfinalvenda;

    @Basic
    @Column(name = "tempodiversosvenda", columnDefinition = "int4")
    private Integer tempodiversosvenda;

    @Basic
    @Column(name = "trocafinalvenda", columnDefinition = "int4")
    private Integer trocafinalvenda;

    @Basic
    @Column(name = "tempotrocavenda", columnDefinition = "int4")
    private Integer tempotrocavenda;

    @Basic
    @Column(name = "chqfinalvenda", columnDefinition = "int4")
    private Integer chqfinalvenda;

    @Basic
    @Column(name = "tempochqvenda", columnDefinition = "int4")
    private Integer tempochqvenda;

    @Basic
    @Column(name = "teffinalvenda", columnDefinition = "int4")
    private Integer teffinalvenda;

    @Basic
    @Column(name = "tempotefvendas", columnDefinition = "int4")
    private Integer tempotefvendas;

    @Basic
    @Column(name = "outrasfinalvenda", columnDefinition = "int4")
    private Integer outrasfinalvenda;

    @Basic
    @Column(name = "tempooutrasvenda", columnDefinition = "int4")
    private Integer tempooutrasvenda;

    @Basic
    @Column(name = "recarga", columnDefinition = "int4")
    private Integer recarga;

    @Basic
    @Column(name = "tempototalrecarga", columnDefinition = "int4")
    private Integer tempototalrecarga;

    @Basic
    @Column(name = "coban", columnDefinition = "int4")
    private Integer coban;

    @Basic
    @Column(name = "tempototalcoban", columnDefinition = "int4")
    private Integer tempototalcoban;

    @Basic
    @Column(name = "cartaopresente", columnDefinition = "int4")
    private Integer cartaopresente;

    @Basic
    @Column(name = "tempototcartaopresente", columnDefinition = "int4")
    private Integer tempototcartaopresente;

    @Basic
    @Column(name = "faturacartaocarrefour", columnDefinition = "int4")
    private Integer faturacartaocarrefour;

    @Basic
    @Column(name = "tempototalfatura", columnDefinition = "int4")
    private Integer tempototalfatura;

    @Basic
    @Column(name = "dinhfinalrec", columnDefinition = "int4")
    private Integer dinhfinalrec;

    @Basic
    @Column(name = "tempodinhrec", columnDefinition = "int4")
    private Integer tempodinhrec;

    @Basic
    @Column(name = "diversosfinalrec", columnDefinition = "int4")
    private Integer diversosfinalrec;

    @Basic
    @Column(name = "tempodiversosrec", columnDefinition = "int4")
    private Integer tempodiversosrec;

    @Basic
    @Column(name = "teffinalrec", columnDefinition = "int4")
    private Integer teffinalrec;

    @Basic
    @Column(name = "tempotefrec", columnDefinition = "int4")
    private Integer tempotefrec;

    @Basic
    @Column(name = "chqfinalrec", columnDefinition = "int4")
    private Integer chqfinalrec;

    @Basic
    @Column(name = "tempochqrec", columnDefinition = "int4")
    private Integer tempochqrec;

    @Basic
    @Column(name = "outrasfinalrec", columnDefinition = "int4")
    private Integer outrasfinalrec;

    @Basic
    @Column(name = "tempooutrasrec", columnDefinition = "int4")
    private Integer tempooutrasrec;

    @Basic
    @Column(name = "cancitens", columnDefinition = "int4")
    private Integer cancitens;

    @Basic
    @Column(name = "tempocancitens", columnDefinition = "int4")
    private Integer tempocancitens;

    @Basic
    @Column(name = "cancvendas", columnDefinition = "int4")
    private Integer cancvendas;

    @Basic
    @Column(name = "tempocancvendas", columnDefinition = "int4")
    private Integer tempocancvendas;

    @Basic
    @Column(name = "cpc", columnDefinition = "int4")
    private Integer cpc;

    @Basic
    @Column(name = "tempocpc", columnDefinition = "int4")
    private Integer tempocpc;

    @Basic
    @Column(name = "divergencia", columnDefinition = "int4")
    private Integer divergencia;

    @Basic
    @Column(name = "tempodivergencia", columnDefinition = "int4")
    private Integer tempodivergencia;

    @Basic
    @Column(name = "opbalcao", columnDefinition = "int4")
    private Integer opbalcao;

    @Basic
    @Column(name = "tempoopbalcao", columnDefinition = "int4")
    private Integer tempoopbalcao;

    @Basic
    @Column(name = "sangria", columnDefinition = "int4")
    private Integer sangria;

    @Basic
    @Column(name = "temposangria", columnDefinition = "int4")
    private Integer temposangria;

    @Basic
    @Column(name = "rel104", columnDefinition = "int4")
    private Integer rel104;

    @Basic
    @Column(name = "temporel104", columnDefinition = "int4")
    private Integer temporel104;

    @Basic
    @Column(name = "outrosrelat", columnDefinition = "int4")
    private Integer outrosrelat;

    @Basic
    @Column(name = "tempooutrosrelat", columnDefinition = "int4")
    private Integer tempooutrosrelat;

    @Basic
    @Column(name = "tempofimpgtosemtefrec", columnDefinition = "int4")
    private Integer tempofimpgtosemtefrec;

    @Basic
    @Column(name = "tempofimpgtocomtefrec", columnDefinition = "int4")
    private Integer tempofimpgtocomtefrec;

    @Basic
    @Column(name = "tempofimpgtosemtefcupom", columnDefinition = "int4")
    private Integer tempofimpgtosemtefcupom;

    @Basic
    @Column(name = "tempofimpgtocomtefcupom", columnDefinition = "int4")
    private Integer tempofimpgtocomtefcupom;

    @Basic
    @Column(name = "outrorec", columnDefinition = "int4")
    private Integer outrorec;

    @Basic
    @Column(name = "tempototalrec", columnDefinition = "int4")
    private Integer tempototalrec;

    /**
     * Instantiates a new produtividade.
     */
    public Produtividade() {
    }

    public ProdutividadePK getProdutividadePK() {
        return produtividadePK;
    }

    /**
     * Sets the produtividadePK.
     *
     * @param produtividadePK the new produtividadePK
     */
    public void setProdutividadePK(final ProdutividadePK produtividadePK) {
        this.produtividadePK = produtividadePK;
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
