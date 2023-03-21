package com.dieboldnixdorf.frentecaixa.domain;

import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * The Class Ejitem.
 */
@Entity
@Table
public class Ejitem {

    /**
     * The reg20 PK.
     */
    @EmbeddedId
    private Reg20PK reg20PK;

    
    /**
     * The storenmbr.
     */
    @Basic
    @Column(name = "storenmbr", columnDefinition = "int4")
    private Integer storenmbr;

    @Basic
    @Column(name = "tiporeg")
    private String tiporeg;

    @Basic
    @Column(name = "tipoitem")
    private String tipoitem;

    @Basic
    @Column(name = "qtde")
    private Integer qtde;

    @Basic
    @Column(name = "vlrunit")
    private BigDecimal vlrunit;

    @Basic
    @Column(name = "vlrtot")
    private BigDecimal vlrtot;

    @Basic
    @Column(name = "vlrdesc")
    private BigDecimal vlrdesc;

    @Basic
    @Column(name = "tiposerv")
    private Integer tiposerv;

    @Basic
    @Column(name = "codforn")
    private Integer codforn;

    
    /**
     * Instantiates a new ejitem.
     */
    public Ejitem() {
    }

    /**
     * Gets the reg 20 PK.
     *
     * @return the reg 20 PK
     */
    public Reg20PK getReg20PK() {
        return reg20PK;
    }

    /**
     * Sets the reg 20 PK.
     *
     * @param reg20pk the new reg 20 PK
     */
    public void setReg20PK(final Reg20PK reg20pk) {
        reg20PK = reg20pk;
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
    public String getTiporeg() {
        return tiporeg;
    }

    /**
     * @param tiporeg the tiporeg to set
     */
    public void setTiporeg(String tiporeg) {
        this.tiporeg = tiporeg;
    }

    /**
     * @return the tipoitem
     */
    public String getTipoitem() {
        return tipoitem;
    }

    /**
     * @param tipoitem the tipoitem to set
     */
    public void setTipoitem(String tipoitem) {
        this.tipoitem = tipoitem;
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
     * @return the vlrunit
     */
    public BigDecimal getVlrunit() {
        return vlrunit;
    }

    /**
     * @param vlrunit the vlrunit to set
     */
    public void setVlrunit(BigDecimal vlrunit) {
        this.vlrunit = vlrunit;
    }

    /**
     * @return the vlrtot
     */
    public BigDecimal getVlrtot() {
        return vlrtot;
    }

    /**
     * @param vlrtot the vlrtot to set
     */
    public void setVlrtot(BigDecimal vlrtot) {
        this.vlrtot = vlrtot;
    }

    /**
     * @return the vlrdesc
     */
    public BigDecimal getVlrdesc() {
        return vlrdesc;
    }

    /**
     * @param vlrdesc the vlrdesc to set
     */
    public void setVlrdesc(BigDecimal vlrdesc) {
        this.vlrdesc = vlrdesc;
    }

    /**
     * @return the tiposerv
     */
    public Integer getTiposerv() {
        return tiposerv;
    }

    /**
     * @param tiposerv the tiposerv to set
     */
    public void setTiposerv(Integer tiposerv) {
        this.tiposerv = tiposerv;
    }

    /**
     * @return the codforn
     */
    public Integer getCodforn() {
        return codforn;
    }

    /**
     * @param codforn the codforn to set
     */
    public void setCodforn(Integer codforn) {
        this.codforn = codforn;
    }

}
