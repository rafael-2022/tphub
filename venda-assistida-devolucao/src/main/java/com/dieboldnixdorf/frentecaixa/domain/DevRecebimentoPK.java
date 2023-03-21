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
public class DevRecebimentoPK implements Serializable {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 5703490229581603805L;
    /**
     * The numDocto (Numero do documento).
     */

    @Column(name = "numdocto", columnDefinition = "int8")
    private Long numDocto;
    /**
     * The numPreOrder (Numero da Pré Order).
     */
    @Basic
    @Column(name = "numpreorder", columnDefinition = "bigint")
    private Long numPreOrder;

    /**
     * The sequencia.
     */
    @Basic
    @Column(name = "sequencia", columnDefinition = "int4")
    private Integer sequencia;

    /**
     * The tipoDev (Tipo de devolucao).
     */
    @Column(name = "tipodev", length = 5)
    private String tipoDev;

    /**
     * @return the tipoDev
     */
    public String getTipoDev() {
        return tipoDev;
    }

    /**
     * @param tipoDev the tipoDev to set
     */
    public void setTipoDev(String tipoDev) {
        this.tipoDev = tipoDev;
    }

    /**
     * @return the numDocto
     */
    public Long getNumDocto() {
        return numDocto;
    }

    /**
     * @param numDocto the numDocto to set
     */
    public void setNumDocto(Long numDocto) {
        this.numDocto = numDocto;
    }

    /**
     * @return the numPreOrder
     */
    public Long getNumPreOrder() {
        return numPreOrder;
    }

    /**
     * @param numPreOrder the numPreOrder to set
     */
    public void setNumPreOrder(Long numPreOrder) {
        this.numPreOrder = numPreOrder;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(numDocto)
                .append(numPreOrder)
                .append(tipoDev)
                .append(sequencia)
                .toHashCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(final Object obj) {
        if (obj instanceof DevRecebimentoPK) {
            final DevRecebimentoPK other = (DevRecebimentoPK) obj;
            return new EqualsBuilder()
                    .append(numDocto, other.numDocto)
                    .append(numPreOrder, other.numPreOrder)
                    .append(tipoDev, other.tipoDev)
                    .append(sequencia, other.sequencia)
                    .isEquals();
        } else {
            return false;
        }
    }
}
