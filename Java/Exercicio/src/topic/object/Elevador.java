package topic.object;

public class Elevador {

	private int andarAtual;
	private int totalAndar;
	private int capacidade;
	private int quantidadePessoa;

	public Elevador(int totalAndar, int capacidade) {
		this.totalAndar = totalAndar;
		this.capacidade = capacidade;
	}

	public void entrar() {
		if (this.quantidadePessoa + 1 <= this.capacidade) {
			this.quantidadePessoa++;
		}
	}

	public void sair() {
		if (this.quantidadePessoa - 1 >= 0) {
			this.quantidadePessoa--;
		}
	}

	public void subir() {
		if (this.andarAtual + 1 <= this.totalAndar) {
			this.andarAtual++;
		}
	}

	public void descer() {
		if (this.andarAtual - 1 >= 0) {
			this.andarAtual--;
		}
	}

}
