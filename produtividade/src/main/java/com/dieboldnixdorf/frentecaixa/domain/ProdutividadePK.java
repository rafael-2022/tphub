/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dieboldnixdorf.frentecaixa.domain;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 *
 * @author modesc
 */
public class ProdutividadePK implements Serializable {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 5703457029581603805L;

    @Basic
    @Column(name = "operador", columnDefinition = "int4")
    private Integer operador;
    @Basic
    @Column(name = "sigla", columnDefinition = "string")
    private String sigla;
    @Basic
    @Column(name = "termnmbr", columnDefinition = "int4")
    private Integer termnmbr;

    @Basic
    @Column(name = "data", columnDefinition = "int4")
    private Integer data;
    @Basic
    @Column(name = "horaini", columnDefinition = "bigint")
    private Long horaini;

    @Basic
    @Column(name = "horafim", columnDefinition = "bigint")
    private Long horafim;

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
     * @param horaini the horaini to set
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
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {

        return new HashCodeBuilder()
                .append(operador)
                .append(sigla)
                .append(termnmbr)
                .append(data)
                .append(horaini)
                .append(horafim)
                .toHashCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(final Object obj) {
        if (obj instanceof ProdutividadePK) {
            final ProdutividadePK other = (ProdutividadePK) obj;
            return new EqualsBuilder()
                    .append(operador, other.operador)
                    .append(sigla, other.sigla)
                    .append(termnmbr, other.termnmbr)
                    .append(data, other.data)
                    .append(horaini, other.horaini)
                    .append(horafim, other.horafim)
                    .isEquals();
        } else {
            return false;
        }
    }

}
