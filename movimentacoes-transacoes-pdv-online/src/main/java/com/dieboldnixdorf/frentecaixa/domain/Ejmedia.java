package com.dieboldnixdorf.frentecaixa.domain;

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

	/** The reg40 PK. */
	@EmbeddedId
	private Reg40PK reg40PK;
	
	/** The rectype. */
	@Basic
	@Column(name="rectype", columnDefinition="int2")
	private Short rectype;

	/** The omediaamnt. */
	private Long omediaamnt;

	/** The mdesc - numeroCartaoCarrefour. */
	@Basic
	@Column(name="mdesc", columnDefinition="bpchar", length=21)
	private String mdesc;

	/** The discountgrpident - nomeFormaPagamento. */
	@Basic
	@Column(name="discountgrpident", columnDefinition="bpchar", length=21)
	private String discountgrpident;

	/** The meddisclinenmbr - informacaoAdicional. */
	@Basic
	@Column(name="userlong", columnDefinition="int8")
	private Long userlong;
        
        /** The ordem - número de sequencia da forma de pagamento na venda*/
        @Basic
        @Column(name="ordem", columnDefinition="int4")
        private Integer ordem;

	@Basic
	@Column(name="bandeiracartao", columnDefinition="bpchar", length=64)
	private String bandeiraCartao;
	@Basic
	@Column(name="codigoautorizacao", columnDefinition="bpchar", length=30)
	private String codigoAutorizacao;
	
	
	@Basic
	@Column(name="doc", columnDefinition="int8")
	private Long doc;
	
	
	@Basic
	@Column(name="tipovenda", columnDefinition="bpchar", length=64)
	private String tipoVenda;
	@Basic
	@Column(name="numerocartao", columnDefinition="bpchar", length=64)
	private String numeroCartao;
	@Basic
	@Column(name="qtdeparcelas", columnDefinition="int4")
	private int qtdeParcelas;
	

	@Basic 
	@Column(name="pk",columnDefinition="int8")
	private Long pk;

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
	 * Gets the rectype.
	 *
	 * @return the rectype
	 */
	public Short getRectype() {
		return rectype;
	}

	/**
	 * Sets the rectype.
	 *
	 * @param rectype the new rectype
	 */
	public void setRectype(final Short rectype) {
		this.rectype = rectype;
	}

	/**
	 * Gets the omediaamnt.
	 *
	 * @return the omediaamnt
	 */
	public Long getOmediaamnt() {
		return omediaamnt;
	}

	/**
	 * Sets the omediaamnt.
	 *
	 * @param omediaamnt the new omediaamnt
	 */
	public void setOmediaamnt(final Long omediaamnt) {
		this.omediaamnt = omediaamnt;
	}

	/**
	 * Gets the mdesc.
	 *
	 * @return the mdesc
	 */
	public String getMdesc() {
		return mdesc;
	}

	/**
	 * Sets the mdesc.
	 *
	 * @param mdesc the new mdesc
	 */
	public void setMdesc(final String mdesc) {
		this.mdesc = mdesc;
	}

	/**
	 * Gets the discountgrpident.
	 *
	 * @return the discountgrpident
	 */
	public String getDiscountgrpident() {
		return discountgrpident;
	}

	/**
	 * Sets the discountgrpident.
	 *
	 * @param discountgrpident the new discountgrpident
	 */
	public void setDiscountgrpident(final String discountgrpident) {
		this.discountgrpident = discountgrpident;
	}

	/**
	 * Gets the userlong.
	 *
	 * @return the userlong
	 */
	public Long getUserlong() {
		return userlong;
	}

	/**
	 * Sets the userlong.
	 *
	 * @param userlong the new userlong
	 */
	public void setUserlong(final Long userlong) {
		this.userlong = userlong;
	}
        
        /**
         * Gets the ordem
         * 
         * @return the ordem
         */
        public Integer getOrdem() {
            return this.ordem;
        }
        
        /**
         * Set the ordem
         * 
         * @param Ordem the ordem
         */
         public void setOrdem (Integer Ordem) {
             this.ordem = Ordem;
         }

	/**        
	 * Gets / sets the bandeiraCartao value
	 */
	public String getBandeiraCartao() {
		return bandeiraCartao;
	}
	public void setBandeiraCartao(String value) {
		this.bandeiraCartao = value;
	}

	/**        
	 * Gets / sets the codigoAutorizacao value
	 */
	public String getCodigoAutorizacao() {
		return codigoAutorizacao;
	}
	public void setCodigoAutorizacao(String value) {
		this.codigoAutorizacao = value;
	}

	/**        
	 * Gets / sets the tipoVenda value
	 */
	public String getTipoVenda() {
		return tipoVenda;
	}
	public void setTipoVenda(String value) {
		this.tipoVenda = value;
	}

	/**        
	 * Gets / sets the numeroCartao value
	 */
	public String getNumeroCartao() {
		return numeroCartao;
	}
	public void setNumeroCartao(String value) {
		this.numeroCartao = value;
	}

	/**        
	 * Gets / sets the qtdeParcelas value
	 */
	public int getQtdeParcelas() {
		return qtdeParcelas;
	}
	public void setQtdeParcelas(int value) {
		this.qtdeParcelas = value;
	}

	/**        
	 * Gets / sets the PK value
	 */
	public Long getPk() {
		return pk;
	}
	public void setPk(Long value) {
		this.pk = value;
	}
	
	public Long getDoc() {
		return doc;
	}

	public void setDoc(Long doc) {
		this.doc = doc;
	}

}
