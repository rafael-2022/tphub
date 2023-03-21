package com.dieboldnixdorf.frentecaixa.domain;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * The Class MovimentacaoPK.
 */
@Embeddable
public class MovimentacaoPK implements Serializable {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = -4659965555258085681L;

    /**
     * The plunmbr.
     */
    @Basic
    @Column(name = "plunmbr", length = 21)
    private String plunmbr;

    /**
     * The transnmbr.
     */
    @Basic
    @Column(name = "transnmbr", columnDefinition = "int4")
    private Integer transnmbr;

    /**
     * The sequencia.
     */
    @Basic
    @Column(name = "sequencia", columnDefinition = "int4")
    private Integer sequencia;

    /**
     * Gets the plunmbr.
     *
     * @return the plunmbr
     */
    public String getPlunmbr() {
        return plunmbr;
    }

    /**
     * Sets the plunmbr.
     *
     * @param plunmbr the new plunmbr
     */
    public void setPlunmbr(final String plunmbr) {
        this.plunmbr = plunmbr;
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
                .append(plunmbr)
                .append(transnmbr)
                .append(sequencia)
                .toHashCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(final Object obj) {
        if (obj instanceof MovimentacaoPK) {
            final MovimentacaoPK other = (MovimentacaoPK) obj;
            return new EqualsBuilder()
                    .append(plunmbr, other.plunmbr)
                    .append(transnmbr, other.transnmbr)
                    .append(sequencia, other.sequencia)
                    .isEquals();
        } else {
            return false;
        }
    }
}
