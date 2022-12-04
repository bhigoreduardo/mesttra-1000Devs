package domain.models;

import java.time.LocalDateTime;

public class Log {

	private Integer id;
	private LocalDateTime data;
	private String operacao;
	private String numeroContaOrigem;
	private String numeroContaDestino;

	public Log() {
		
	}
	
	public Log(Integer id, LocalDateTime data, String operacao, String numeroContaOrigem, String numeroContaDestino) {
		this.id = id;
		this.data = data;
		this.operacao = operacao;
		this.numeroContaOrigem = numeroContaOrigem;
		this.numeroContaDestino = numeroContaDestino;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public String getOperacao() {
		return operacao;
	}

	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}

	public String getNumeroContaOrigem() {
		return numeroContaOrigem;
	}

	public void setNumeroContaOrigem(String numeroContaOrigem) {
		this.numeroContaOrigem = numeroContaOrigem;
	}

	public String getNumeroContaDestino() {
		return numeroContaDestino;
	}

	public void setNumeroContaDestino(String numeroContaDestino) {
		this.numeroContaDestino = numeroContaDestino;
	}

	@Override
	public String toString() {
		return "\t\tData Hora: " + data + " -- " + "Operacao: " + operacao + " -- " + "Conta Origem: "
				+ numeroContaOrigem + " -- " + "Conta Destino: " + numeroContaDestino;
	}

}
