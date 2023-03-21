package com.dieboldnixdorf.frentecaixa.service;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.util.Assert;

/**
 * The Class MovimentacoesTransacoesPdvSearchCriteria.
 */
public class MovimentacoesTransacoesPdvSearchCriteria implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The codigo loja. */
	private String codigoLoja;
	
	/** The data extracao. */
	private LocalDate dataExtracao;
	
	/** The data hora inicial. */
	private LocalDateTime dataHoraInicial;

	/** The data hora final. */
	private LocalDateTime dataHoraFinal;
	
	private Integer pdv;
	
	private Integer transacao;
	
	private String danfe;
	
	private Integer tipo;

	/**
	 * Instantiates a new movimentacoes transacoes pdv search criteria.
	 */
	public MovimentacoesTransacoesPdvSearchCriteria() {
	}

	/**
	 * Instantiates a new movimentacoes transacoes pdv search criteria.
	 *
	 * @param codigoLoja the codigo loja
	 * @param dataHoraInicial the data hora inicial
	 * @param dataHoraFinal the data hora final
	 * @param paginaInicial the pagina inicial
	 * @param paginaFinal the pagina final
	 */
	public MovimentacoesTransacoesPdvSearchCriteria(final String codigoLoja, final LocalDateTime dataHoraInicial, final LocalDateTime dataHoraFinal,
			final Integer paginaInicial, final Integer paginaFinal) {
		Assert.notNull(codigoLoja, "Código da Loja não deve ser nulo");
		Assert.notNull(dataHoraInicial, "Parâmetro 'dataHoraInicial' não deve ser nulo");
		Assert.notNull(dataHoraFinal, "Parâmetro 'dataHoraFinal' não deve ser nulo");
		Assert.notNull(paginaInicial, "Parâmetro 'paginaInicial' não deve ser nulo");
		Assert.notNull(paginaFinal, "Parâmetro 'paginaFinal' não deve ser nulo");
		final Pattern pPaginaFinal = Pattern.compile("^[\\.\\-\\+]\\d*$|[\\.\\-\\+]\\d*$|\\d*[\\.\\-\\+]\\d*$");
		final Matcher mPaginaFinal = pPaginaFinal.matcher(String.valueOf(paginaFinal));
		Assert.isTrue(!mPaginaFinal.find(), "Page index must not be less than zero!");
		this.codigoLoja = codigoLoja;
		this.dataHoraInicial = dataHoraInicial;
		this.dataHoraFinal = dataHoraFinal;
	}
	
	public MovimentacoesTransacoesPdvSearchCriteria(final String codigoLoja, 
													final LocalDateTime dataHoraInicial, 
													final LocalDateTime dataHoraFinal,
													final Integer pdv,
													final Integer transacao,
													final String danfe,
													final Integer tipo,
													final Integer paginaInicial, 
													final Integer paginaFinal) {
		Assert.notNull(codigoLoja, "Código da Loja não deve ser nulo");
		Assert.notNull(dataHoraInicial, "Parâmetro 'dataHoraInicial' não deve ser nulo");
		Assert.notNull(dataHoraFinal, "Parâmetro 'dataHoraFinal' não deve ser nulo");
		Assert.notNull(paginaInicial, "Parâmetro 'paginaInicial' não deve ser nulo");
		Assert.notNull(paginaFinal, "Parâmetro 'paginaFinal' não deve ser nulo");
		final Pattern pPaginaFinal = Pattern.compile("^[\\.\\-\\+]\\d*$|[\\.\\-\\+]\\d*$|\\d*[\\.\\-\\+]\\d*$");
		final Matcher mPaginaFinal = pPaginaFinal.matcher(String.valueOf(paginaFinal));
		Assert.isTrue(!mPaginaFinal.find(), "Page index must not be less than zero!");
		this.codigoLoja = codigoLoja;
		this.dataHoraInicial = dataHoraInicial;
		this.dataHoraFinal = dataHoraFinal;
		this.pdv = pdv;
		this.transacao = transacao;
		this.danfe = danfe;
		this.tipo = tipo;
	}

	

	public Integer getPdv() {
		return pdv;
	}

	public void setPdv(Integer pdv) {
		this.pdv = pdv;
	}

	public Integer getTransacao() {
		return transacao;
	}

	public void setTransacao(Integer transacao) {
		this.transacao = transacao;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public String getDanfe() {
		return danfe;
	}

	public void setDanfe(String danfe) {
		this.danfe = danfe;
	}

	
	/**
	 * Gets the codigo loja.
	 *
	 * @return the codigo loja
	 */
	public String getCodigoLoja() {
		return codigoLoja;
	}

	/**
	 * Sets the codigo loja.
	 *
	 * @param codigoLoja the new codigo loja
	 */
	public void setCodigoLoja(final String codigoLoja) {
		this.codigoLoja = codigoLoja;
	}

	/**
	 * Gets the data extracao.
	 *
	 * @return the data extracao
	 */
	public LocalDate getDataExtracao() {
		return dataExtracao;
	}

	/**
	 * Gets the data extracao.
	 *
	 * @param pDdataExtracao the ddata extracao
	 * @return the data extracao
	 */
	public Date getDataExtracao(final LocalDate pDdataExtracao) {
		final LocalDate localDate = LocalDate.of(pDdataExtracao.getYear(), pDdataExtracao.getMonth(), pDdataExtracao.getDayOfMonth());
		final DateTimeFormatter formatter = new DateTimeFormatterBuilder().appendPattern("dd/MM/yy").parseStrict().toFormatter();
		final String text = localDate.format(formatter);
		final LocalDate newLocalDate = LocalDate.parse(text, formatter);
		return Date.from(newLocalDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
	}

	/**
	 * Gets the data hora extracao.
	 *
	 * @param pDataExtracao the data extracao
	 * @return the data hora extracao
	 */
	public Date getDataHoraExtracao(final LocalDate pDataExtracao) {
		final LocalTime time = LocalTime.now();
		final LocalDateTime newLocalDateTime = LocalDateTime.of(pDataExtracao, time);
		return Date.from(newLocalDateTime.atZone(ZoneId.systemDefault()).toInstant());
	}

	/**
	 * Gets the data extracao.
	 *
	 * @param pDataExtracao the data extracao
	 * @return the data extracao
	 */
	public String getDataExtracao(final Date pDataExtracao) {
		final Calendar dataEsquema  = Calendar.getInstance();
		dataEsquema.setTime(pDataExtracao);
		final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
		final LocalDateTime localDateTime = LocalDateTime.of(dataEsquema.get(Calendar.YEAR),dataEsquema.get(Calendar.MONTH) + 1, dataEsquema.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
		return localDateTime.format(formatter);
	}
	
	/**
	 * Gets the timestamp.
	 *
	 * @param localDateTime the local date time
	 * @return the timestamp
	 */
	public Timestamp getTimestamp(final LocalDateTime localDateTime) {
		return Timestamp.valueOf(localDateTime);
	}
	
	/**
	 * Sets the data extracao.
	 *
	 * @param dataExtracao the new data extracao
	 */
	public void setDataExtracao(final LocalDate dataExtracao) {
		this.dataExtracao = dataExtracao;
	}

	/**
	 * Gets the data hora inicial.
	 *
	 * @return the data hora inicial
	 */
	public LocalDateTime getDataHoraInicial() {
		return dataHoraInicial;
	}

	/**
	 * Sets the data hora inicial.
	 *
	 * @param dataHoraInicial the new data hora inicial
	 */
	public void setDataHoraInicial(final LocalDateTime dataHoraInicial) {
		this.dataHoraInicial = dataHoraInicial;
	}

	/**
	 * Gets the data hora final.
	 *
	 * @return the data hora final
	 */
	public LocalDateTime getDataHoraFinal() {
		return dataHoraFinal;
	}

	/**
	 * Sets the data hora final.
	 *
	 * @param dataHoraFinal the new data hora final
	 */
	public void setDataHoraFinal(final LocalDateTime dataHoraFinal) {
		this.dataHoraFinal = dataHoraFinal;
	}

	
}