package com.dieboldnixdorf.frentecaixa.payloads;


import java.math.BigDecimal;

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
public class Pagamentos {

	private String contadorRegistroInterno;

	private String codigoRMSProduto;

	private String eanProduto;

	private String quantidadeFormasPgto;
	
	private String categoriaFormaPgto;

	@JsonSerialize(using = BigDecimal8Serializer.class)
	private BigDecimal valorFormaPgto;
	
	private String horaMinutoEvento;
}
