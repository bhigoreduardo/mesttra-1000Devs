package topic.object;

public class Pessoa {

	private String nome;
	private int anoNascimento;
	private double altura;

	public Pessoa(String nome, int anoNascimento, double altura) {
		this.nome = nome;
		this.anoNascimento = anoNascimento;
		this.altura = altura;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getAnoNascimento() {
		return this.anoNascimento;
	}

	public double getAltura() {
		return this.altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public int calcularIdade(int anoAtual) {
		return anoAtual - this.anoNascimento;
	}

	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", anoNascimento=" + anoNascimento + ", altura=" + altura + "]";
	}

}