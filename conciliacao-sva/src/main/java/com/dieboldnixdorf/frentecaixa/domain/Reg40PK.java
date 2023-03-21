package com.dieboldnixdorf.frentecaixa.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * The Class Reg40PK.
 */
@Embeddable
public class Reg40PK implements Serializable {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 5705307029581603805L;

    /**
     * The datahora sod.
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date datahora_sod;

    /**
     * The datahora eod.
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date datahora_eod;

    /**
     * The transnmbr.
     */
    @Basic
    @Column(name = "transnmbr", columnDefinition = "int4")
    private Integer transnmbr;

    /**
     * The termnmbr.
     */
    @Basic
    @Column(name = "termnmbr", columnDefinition = "int2")
    private Short termnmbr;

    @Basic
    @Column(name = "meiopagto")
    private Integer meiopagto;
    @Basic
    @Column(name = "planopagto")
    private String planopagto;
    @Basic
    @Column(name = "valor")
    private BigDecimal valor;
    /**
     * The sequencia.
     */
    @Basic
    @Column(name = "sequencia", columnDefinition = "int4")
    private Integer sequencia;

    /**
     * Gets the datahora sod.
     *
     * @return the datahora sod
     */
    public Date getDatahora_sod() {
        return datahora_sod;
    }

    /**
     * Sets the datahora sod.
     *
     * @param datahora_sod the new datahora sod
     */
    public void setDatahora_sod(final Date datahora_sod) {
        this.datahora_sod = datahora_sod;
    }

    /**
     * Gets the datahora eod.
     *
     * @return the datahora eod
     */
    public Date getDatahora_eod() {
        return datahora_eod;
    }

    /**
     * Sets the datahora eod.
     *
     * @param datahora_eod the new datahora eod
     */
    public void setDatahora_eod(final Date datahora_eod) {
        this.datahora_eod = datahora_eod;
    }

    /**
     * Gets the transnmbr.
     *
     * @return the transnmbr
     */
    public Integer getTransnmbr() {
        return transnmbr;
    }

    /**
     * Sets the transnmbr.
     *
     * @param transnmbr the new transnmbr
     */
    public void setTransnmbr(final Integer transnmbr) {
        this.transnmbr = transnmbr;
    }

    /**
     * Gets the termnmbr.
     *
     * @return the termnmbr
     */
    public Short getTermnmbr() {
        return termnmbr;
    }

    /**
     * Sets the termnmbr.
     *
     * @param termnmbr the new termnmbr
     */
    public void setTermnmbr(final Short termnmbr) {
        this.termnmbr = termnmbr;
    }

    /**
     * @return the meiopagto
     */
    public Integer getMeiopagto() {
        return meiopagto;
    }

    /**
     * @param meiopagto the meiopagto to set
     */
    public void setMeiopagto(Integer meiopagto) {
        this.meiopagto = meiopagto;
    }

    /**
     * @return the planopagto
     */
    public String getPlanopagto() {
        return planopagto;
    }

    /**
     * @param planopagto the planopagto to set
     */
    public void setPlanopagto(String planopagto) {
        this.planopagto = planopagto;
    }

    /**
     * @return the valor
     */
    public BigDecimal getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    /**
     * Gets the sequencia.
     *
     * @return the Sequencia
     */
    public Integer getSequencia() {
        return sequencia;
    }

    /**
     * Sets the sequencia.
     *
     * @param sequencia the new sequencia
     */
    public void setSequencia(final Integer sequencia) {
        this.sequencia = sequencia;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(transnmbr)
                .append(termnmbr)
                .append(datahora_sod)
                .append(datahora_eod)
                .append(meiopagto)
                .append(planopagto)
                .append(sequencia)
                .toHashCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(final Object obj) {
        if (obj instanceof Reg40PK) {
            final Reg40PK other = (Reg40PK) obj;
            return new EqualsBuilder()
                    .append(transnmbr, other.transnmbr)
                    .append(termnmbr, other.termnmbr)
                    .append(datahora_sod, other.datahora_sod)
                    .append(datahora_eod, other.datahora_eod)
                    .append(meiopagto, other.meiopagto)
                    .append(planopagto, other.planopagto)
                    .append(sequencia, other.sequencia)
                    .isEquals();
        } else {
            return false;
        }
    }

}
