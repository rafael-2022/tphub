package com.dieboldnixdorf.frentecaixa.payloads;

import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.Column;

import com.dieboldnixdorf.frentecaixa.domain.BigDecimal8Serializer;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Itens {

	private String contadorRegistroInterno;
	
	private String codigoRMSproduto;

	private String eanProduto;
	
	private String codigoSetor;
	
	private String devolucaoComCupom;
	
	@JsonSerialize(using = BigDecimal8Serializer.class)
	private BigDecimal valorTotalItemIMPOSTODEBITADO;
	
	private String numeroMatricula;
	
	@JsonSerialize(using = BigDecimal8Serializer.class)
	private BigDecimal valorTotalItemBASECALCPIS;
	
	@JsonSerialize(using = BigDecimal8Serializer.class)
	private BigDecimal valorTotalItemPIS;
	
	@JsonSerialize(using = BigDecimal8Serializer.class)
	private BigDecimal valorTotalItemBASECALCCOFINS;
	
	@JsonSerialize(using = BigDecimal8Serializer.class)
	private BigDecimal valorTotalItemCOFINS;
	
	private String TipoServico;
	
	private String codigoServico;
	
	private String codigoFornecedor;
	
	private String quantidadeItensDevolvidos;
	
	@JsonSerialize(using = BigDecimal8Serializer.class)
	private BigDecimal valorUnitarioDevolvidos;
	
	@JsonSerialize(using = BigDecimal8Serializer.class)
	private BigDecimal valorTotalDevolvido;
	
	private String horaMinutoEvento;
	
	private String status;
}
