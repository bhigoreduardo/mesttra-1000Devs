package topic.polymorphism;

public class Fornecedor extends Pessoa {

	private double valorCredito;
	private double valorDivida;

	public Fornecedor(String nome, String endereco, String cpf, double valorCredito, double valorDivida) {
		super(nome, endereco, cpf);
		this.valorCredito = valorCredito;
		this.valorDivida = valorDivida;
	}

	public double obterSaldo() {
		return this.valorCredito - this.valorDivida;
	}

	public double getValorCredito() {
		return this.valorCredito;
	}

	public double getValorDivida() {
		return this.valorDivida;
	}

	public void setValorCredito(double valorCredito) {
		this.valorCredito = valorCredito;
	}

	public void setValorDivida(double valorDivida) {
		this.valorDivida = valorDivida;
	}

}