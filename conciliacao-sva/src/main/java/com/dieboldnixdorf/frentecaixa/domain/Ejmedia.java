package com.dieboldnixdorf.frentecaixa.domain;

import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * The Class Ejmedia.
 */
@Entity
@Table
public class Ejmedia {

    /**
     * The reg40 PK.
     */
    @EmbeddedId
    private Reg40PK reg40PK;

    /**
     * The storenmbr.
     */
    @Basic
    @Column(name = "storenmbr", columnDefinition = "int4")
    private Integer storenmbr;
    @Basic
    @Column(name = "tiporeg")
    private Integer tiporeg;
    
    @Basic
    @Column(name = "numparc")
    private Integer numparc;
   

    /**
     * Instantiates a new ejitem.
     */
    public Ejmedia() {
    }

    /**
     * Gets the reg 40 PK.
     *
     * @return the reg 40 PK
     */
    public Reg40PK getReg40PK() {
        return reg40PK;
    }

    /**
     * Sets the reg 40 PK.
     *
     * @param reg40pk the new reg 40 PK
     */
    public void setReg40PK(final Reg40PK reg40pk) {
        reg40PK = reg40pk;
    }

    /**
     * @return the storenmbr
     */
    public Integer getStorenmbr() {
        return storenmbr;
    }

    /**
     * @param storenmbr the storenmbr to set
     */
    public void setStorenmbr(Integer storenmbr) {
        this.storenmbr = storenmbr;
    }

    /**
     * @return the tiporeg
     */
    public Integer getTiporeg() {
        return tiporeg;
    }

    /**
     * @param tiporeg the tiporeg to set
     */
    public void setTiporeg(Integer tiporeg) {
        this.tiporeg = tiporeg;
    }

  

 

    /**
     * @return the numparc
     */
    public Integer getNumparc() {
        return numparc;
    }

    /**
     * @param numparc the numparc to set
     */
    public void setNumparc(Integer numparc) {
        this.numparc = numparc;
    }

  

}
