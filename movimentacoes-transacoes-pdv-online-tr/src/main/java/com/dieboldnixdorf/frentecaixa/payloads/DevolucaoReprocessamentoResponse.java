package com.dieboldnixdorf.frentecaixa.payloads;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@ToString
public class DevolucaoReprocessamentoResponse {

	private String codigoLoja;
	
	private String CNPJEmissor;
	
	private String dataDevolucao;
	
	private String numeroDocumentoFiscal;
	
	private String serieDocumentoFiscal;
	
	private String numeroDANFE;
	
	private String transacaoLoja;
	
	private String codigoTerminalVenda;
	
	private String ClienteCPF_NF;
	
	private String ClienteCPF_MeuCARREFOUR;
	
	private String numeroPreOrder;
	
	private String codigoVendedor;
	
	private String recepcionistaDRT;
	
	private String codigoEventoDevolucao;
	
	private String tipoEvento;
	
	private String operacaoVenda;
	
	private String pdvresgate;
	
	private String transacaoresgate;
	
	private String datahoraresgate;
	
	private String operadorresgate;
	
	private String valorresgate;
	
	private Origem origem;
	
	private List<Itens> itens;
	
	private List<Pagamentos> pagamentos;
	
}
