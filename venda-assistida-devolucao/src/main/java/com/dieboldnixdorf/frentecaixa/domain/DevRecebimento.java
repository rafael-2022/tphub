package com.dieboldnixdorf.frentecaixa.domain;

import java.math.BigDecimal;

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
public class DevRecebimento {

    /*@Id
	@Column(name="cshrnmbr", columnDefinition="int8")
	private Long cshrnmbr;*/
    @EmbeddedId
    private DevRecebimentoPK devRecebimentoPK;

    /**
     * The numPDV (Número do ECF - Número do PDV que a transação foi
     * finalizada.).
     */
    @Basic
    @Column(name = "numpdv", columnDefinition = "int8")
    private Integer numPDV;

    /**
     * The codOper (Código da Operadora - Número do DRT da Operadora).
     */
    @Basic
    @Column(name = "codoper", columnDefinition = "int8")
    private Long codOper;

    /**
     * The codVend (Código do Vendedor - Numérico (Preencher em caso de
     * transação Manual ou off-line)).
     */
    @Basic
    @Column(name = "codvend", columnDefinition = "bigint")
    private Long codVend;

    /**
     * The tipoServ (	Tipo de Serviço - (a definir entre SVA/CVA/PDV. Premissa:
     * valor entre 0 e 255)).
     */
    @Basic
    @Column(name = "tiposerv", columnDefinition = "int4")
    private Integer tipoServ;

    /**
     * The codProd (Código do Produto - Código do produto associado ao Serviço).
     */
    @Basic
    @Column(name = "codprod", columnDefinition = "bigint")
    private Long codProd;

    /**
     * The codServ (Código do Serviço - Código RMS do Serviço).
     */
    @Basic
    @Column(name = "codserv", columnDefinition = "bigint")
    private Long codServ;

    /**
     * The codForn (Código Fornecedor - (a definir entre SVA/CVA/PDV. Premissa:
     * valor entre 0 e 999)).
     */
    @Basic
    @Column(name = "codforn", columnDefinition = "int4")
    private Long codFornc;

    /**
     * The qtde (Quantidade - Quantidade vendida do Recebimento).
     */
    @Basic
    @Column(name = "qtde", columnDefinition = "int4")
    private Integer qtde;

    /**
     * The vlrUnit (Valor Unitário - Preço Unitário do Recebimento).
     */
    @Basic
    @Column(name = "vlrunit", columnDefinition = "numeric", scale = 2)
    private BigDecimal vlrUnit;

    /**
     * The vlrTot (Valor Total - Valor Total do Recebimento. (Quantidade * Valor
     * unitário)).
     */
    @Basic
    @Column(name = "vlrtot", columnDefinition = "numeric", scale = 2)
    private BigDecimal vlrTot;

    /**
     * The qtdeFormPagto (Quantidade de Formas de Pagamento - Número de Formas
     * de Pagamento utilizada para finalização da transação no PDV).
     */
    @Basic
    @Column(name = "qtdeformpagto", columnDefinition = "int4")
    private Integer qtdeFormPagto;

    /**
     * The catFormPagto (Categora da Forma de Pagamento - Categoria da forma de
     * pagamento. Preenchimento de acordo com a tabela “Classificação de
     * Recebimento”.).
     */
    @Basic
    @Column(name = "catformpagto", length = 2)
    private String catFormPagto;

    /**
     * The formPagto (Forma de Pagamento - Descrição da Forma de Pagamento).
     */
    @Basic
    @Column(name = "formpagto", length = 20)
    private String formPagto;

    /**
     * The vlrFormPagto (Valor Total por forma de pagamento - Valor total do
     * rateio por forma de pagamento).
     */
    @Basic
    @Column(name = "vlrformpagto", columnDefinition = "decimal", scale = 2)
    private BigDecimal vlrFormPagto;

    /**
     * Instantiates a new ejmedia.
     */
    public DevRecebimento() {
    }

    public DevRecebimentoPK getDevRecebimentoPK() {
        return devRecebimentoPK;
    }

    /**
     * Sets the DevRecebimentoPK.
     *
     * @param DevRecebimentoPK the new DevRecebimentoPK
     */
    public void setDevRecebimentoPK(final DevRecebimentoPK devRecebimentoPK) {
        this.devRecebimentoPK = devRecebimentoPK;
    }

    /**
     * @return the numPDV
     */
    public Integer getNumPDV() {
        return numPDV;
    }

    /**
     * @param numPDV the numPDV to set
     */
    public void setNumPDV(Integer numPDV) {
        this.numPDV = numPDV;
    }

    /**
     * @return the codOper
     */
    public Long getCodOper() {
        return codOper;
    }

    /**
     * @param codOper the codOper to set
     */
    public void setCodOper(Long codOper) {
        this.codOper = codOper;
    }

    /**
     * @return the codVend
     */
    public Long getCodVend() {
        return codVend;
    }

    /**
     * @param codVend the codVend to set
     */
    public void setCodVend(Long codVend) {
        this.codVend = codVend;
    }

    /**
     * @return the tipoServ
     */
    public Integer getTipoServ() {
        return tipoServ;
    }

    /**
     * @param tipoServ the tipoServ to set
     */
    public void setTipoServ(Integer tipoServ) {
        this.tipoServ = tipoServ;
    }

    /**
     * @return the codProd
     */
    public Long getCodProd() {
        return codProd;
    }

    /**
     * @param codProd the codProd to set
     */
    public void setCodProd(Long codProd) {
        this.codProd = codProd;
    }

    /**
     * @return the codServ
     */
    public Long getCodServ() {
        return codServ;
    }

    /**
     * @param codServ the codServ to set
     */
    public void setCodServ(Long codServ) {
        this.codServ = codServ;
    }

    /**
     * @return the codFornc
     */
    public Long getCodFornc() {
        return codFornc;
    }

    /**
     * @param codFornc the codFornc to set
     */
    public void setCodFornc(Long codFornc) {
        this.codFornc = codFornc;
    }

    /**
     * @return the qtde
     */
    public Integer getQtde() {
        return qtde;
    }

    /**
     * @param qtde the qtde to set
     */
    public void setQtde(Integer qtde) {
        this.qtde = qtde;
    }

    /**
     * @return the vlrUnit
     */
    public BigDecimal getVlrUnit() {
        return vlrUnit;
    }

    /**
     * @param vlrUnit the vlrUnit to set
     */
    public void setVlrUnit(BigDecimal vlrUnit) {
        this.vlrUnit = vlrUnit;
    }

    /**
     * @return the vlrTot
     */
    public BigDecimal getVlrTot() {
        return vlrTot;
    }

    /**
     * @param vlrTot the vlrTot to set
     */
    public void setVlrTot(BigDecimal vlrTot) {
        this.vlrTot = vlrTot;
    }

    /**
     * @return the qtdeFormPagto
     */
    public Integer getQtdeFormPagto() {
        return qtdeFormPagto;
    }

    /**
     * @param qtdeFormPagto the qtdeFormPagto to set
     */
    public void setQtdeFormPagto(Integer qtdeFormPagto) {
        this.qtdeFormPagto = qtdeFormPagto;
    }

    /**
     * @return the catFormPagto
     */
    public String getCatFormPagto() {
        return catFormPagto;
    }

    /**
     * @param catFormPagto the catFormPagto to set
     */
    public void setCatFormPagto(String catFormPagto) {
        this.catFormPagto = catFormPagto;
    }

    /**
     * @return the formPagto
     */
    public String getFormPagto() {
        return formPagto;
    }

    /**
     * @param formPagto the formPagto to set
     */
    public void setFormPagto(String formPagto) {
        this.formPagto = formPagto;
    }

    /**
     * @return the vlrFormPagto
     */
    public BigDecimal getVlrFormPagto() {
        return vlrFormPagto;
    }

    /**
     * @param vlrFormPagto the vlrFormPagto to set
     */
    public void setVlrFormPagto(BigDecimal vlrFormPagto) {
        this.vlrFormPagto = vlrFormPagto;
    }

}
