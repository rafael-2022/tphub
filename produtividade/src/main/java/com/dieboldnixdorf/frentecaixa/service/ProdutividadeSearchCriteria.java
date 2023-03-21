package com.dieboldnixdorf.frentecaixa.service;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.util.Assert;

/**
 * The Class DadosDevolucaoSearchCriteria.
 */
public class ProdutividadeSearchCriteria implements Serializable {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The codigo loja.
     */
    private String codigoLoja;

    /**
     * The data extracao.
     */
    private LocalDate dataExtracao;

    /**
     * Instantiates a new dados devolucao search criteria.
     */
    public ProdutividadeSearchCriteria() {
    }

    /**
     * Instantiates a new dados devolucao search criteria.
     *
     * @param codigoLoja the codigo loja
     * @param dataExtracao the data extracao
     */
    public ProdutividadeSearchCriteria(final String codigoLoja, final LocalDate dataExtracao, final Integer paginaInicial, final Integer paginaFinal) {
        Assert.notNull(codigoLoja, "Código da Loja não deve ser nulo");
        Assert.notNull(dataExtracao, "Data da Extracao não deve ser nulo");
        Assert.notNull(paginaInicial, "Parâmetro 'paginaInicial' não deve ser nulo");
        Assert.notNull(paginaFinal, "Parâmetro 'paginaFinal' não deve ser nulo");
        final Pattern pPaginaFinal = Pattern.compile("^[\\.\\-\\+]\\d*$|[\\.\\-\\+]\\d*$|\\d*[\\.\\-\\+]\\d*$");
        final Matcher mPaginaFinal = pPaginaFinal.matcher(String.valueOf(paginaFinal));
        Assert.isTrue(!mPaginaFinal.find(), "Page index must not be less than zero!");
        this.codigoLoja = codigoLoja;
        this.dataExtracao = dataExtracao;
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
    public Date getDataExtracao() {
        final LocalDate localDate = LocalDate.of(dataExtracao.getYear(), dataExtracao.getMonth(), dataExtracao.getDayOfMonth());
        final DateTimeFormatter formatter = new DateTimeFormatterBuilder().appendPattern("dd/MM/yy").parseStrict().toFormatter();
        final String text = localDate.format(formatter);
        final LocalDate newLocalDate = LocalDate.parse(text, formatter);
        Date date = Date.from(newLocalDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        return date;
    }

    /**
     * Gets the data extracao.
     *
     * @return the data extracao
     */
    public String getDataExtracaoString() {
        final LocalDate localDate = LocalDate.of(dataExtracao.getYear(), dataExtracao.getMonth(), dataExtracao.getDayOfMonth());
        final DateTimeFormatter formatter = new DateTimeFormatterBuilder().appendPattern("dd/MM/yy").parseStrict().toFormatter();
        final String text = localDate.format(formatter);
        return text;
    }

    /**
     * Gets the data extracao.
     *
     * @return the data extracao
     */
    public String getDataExtracaoCbdString() {
        final LocalDate localDate = LocalDate.of(dataExtracao.getYear(), dataExtracao.getMonth(), dataExtracao.getDayOfMonth());
        final DateTimeFormatter formatter = new DateTimeFormatterBuilder().appendPattern("yyyyMMdd").parseStrict().toFormatter();
        final String text = localDate.format(formatter);
        return  "cbd_"+text;
    }

    /**
     * Sets the data extracao.
     *
     * @param dataExtracao the new data extracao
     */
    public void setDataExtracao(final LocalDate dataExtracao) {
        this.dataExtracao = dataExtracao;
    }

}
