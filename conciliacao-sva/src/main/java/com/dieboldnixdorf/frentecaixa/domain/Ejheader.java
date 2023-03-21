package com.dieboldnixdorf.frentecaixa.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * The Class Ejheader.
 */
@Entity
@Table
public class Ejheader {

    /**
     * The movimentacao PK.
     */
    @EmbeddedId
    private MovimentacaoPK movimentacaoPK;

    /**
     * The storenmbr.
     */
    private Integer ostorenmbr;

    /**
     * The mngrovnmbr.
     */
    @Basic
    @Column(name = "mngrovnmbr", columnDefinition = "int8")
    private Long mngrovnmbr;
    @Basic
    @Column(name = "transsva")
    private String transsva;
    @Basic
    @Column(name = "nsupedido")
    private Long nsupedido;
    @Basic
    @Column(name = "numpedido")
    private Long numpedido;
    @Basic
    @Column(name = "tiporeg")
    private String tiporeg;

    @Basic
    @Column(name = "tipoitem")
    private String tipoitem;

    @Basic
    @Column(name = "idterm")
    private Integer idterm;
    @Basic
    @Column(name = "status")
    private Integer status;
    @Basic
    @Column(name = "codloja")
    private Integer codloja;
    @Basic
    @Column(name = "codcliente")
    private Long codcliente;

    @Basic
    @Column(name = "codvend")
    private Long codvend;

    /**
     * Instantiates a new ejheader.
     */
    public Ejheader() {
    }

    /**
     * Gets the movimentacao PK.
     *
     * @return the movimentacao PK
     */
    public MovimentacaoPK getMovimentacaoPK() {
        return movimentacaoPK;
    }

    /**
     * Sets the movimentacao PK.
     *
     * @param movimentacaoPK the new movimentacao PK
     */
    public void setMovimentacaoPK(final MovimentacaoPK movimentacaoPK) {
        this.movimentacaoPK = movimentacaoPK;
    }

    /**
     * Gets the ostorenmbr.
     *
     * @return the ostorenmbr
     */
    public Integer getOstorenmbr() {
        return ostorenmbr;
    }

    /**
     * Sets the ostorenmbr.
     *
     * @param ostorenmbr the new ostorenmbr
     */
    public void setOstorenmbr(Integer ostorenmbr) {
        this.ostorenmbr = ostorenmbr;
    }

    /**
     * Gets the mngrovnmbr.
     *
     * @return the mngrovnmbr
     */
    public Long getMngrovnmbr() {
        return mngrovnmbr;
    }

    /**
     * Sets the mngrovnmbr.
     *
     * @param mngrovnmbr the new mngrovnmbr
     */
    public void setMngrovnmbr(final Long mngrovnmbr) {
        this.mngrovnmbr = mngrovnmbr;
    }

    /**
     * @return the transsva
     */
    public String getTranssva() {
        return transsva;
    }

    /**
     * @param transsva the transsva to set
     */
    public void setTranssva(String transsva) {
        this.transsva = transsva;
    }

    /**
     * @return the nsupedido
     */
    public Long getNsupedido() {
        return nsupedido;
    }

    /**
     * @param nsupedido the nsupedido to set
     */
    public void setNsupedido(Long nsupedido) {
        this.nsupedido = nsupedido;
    }

    /**
     * @return the numpedido
     */
    public Long getNumpedido() {
        return numpedido;
    }

    /**
     * @param numpedido the numpedido to set
     */
    public void setNumpedido(Long numpedido) {
        this.numpedido = numpedido;
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
     * @return the idterm
     */
    public Integer getIdterm() {
        return idterm;
    }

    /**
     * @param idterm the idterm to set
     */
    public void setIdterm(Integer idterm) {
        this.idterm = idterm;
    }

    /**
     * @return the status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return the codloja
     */
    public Integer getCodloja() {
        return codloja;
    }

    /**
     * @param codloja the codloja to set
     */
    public void setCodloja(Integer codloja) {
        this.codloja = codloja;
    }

    /**
     * @return the codcliente
     */
    public Long getCodcliente() {
        return codcliente;
    }

    /**
     * @param codcliente the codcliente to set
     */
    public void setCodcliente(Long codcliente) {
        this.codcliente = codcliente;
    }

    /**
     * @return the codvend
     */
    public Long getCodvend() {
        return codvend;
    }

    /**
     * @param codvend the codvend to set
     */
    public void setCodvend(Long codvend) {
        this.codvend = codvend;
    }

}
