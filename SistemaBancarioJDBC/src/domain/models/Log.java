package domain.models;

import java.time.LocalDateTime;

public class Log {

	private LocalDateTime data;
	private String operacao;

	public Log(LocalDateTime data, String operacao) {
		this.data = data;
		this.operacao = operacao;
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

	@Override
	public String toString() {
		return "\t\tData Hora: " + data + " -- " + "Operacao: " + operacao;
	}

}
