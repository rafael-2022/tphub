package com.dieboldnixdorf.frentecaixa.payloads;

import com.fasterxml.jackson.annotation.JsonInclude;

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
public class Origem {

	private String codigoLoja;
	
	private String CNPJEmissor;
	
	private String dataVenda;
	
	private String numeroDocumentoFiscal;
	
	private String serieDocumentoFiscal;
	
	private String codigoTerminalVenda;
	
	private String transacaoLoja;
	
	private String numeroDANFE;
	
	private String ClienteCPF_NF;
	
	private String ClienteCPF_MeuCARREFOUR;
	
	private String numeroPreOrder;
	
	private String codigoVendedor;
	
}
