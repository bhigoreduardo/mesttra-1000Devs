package topic.polymorphism;

public class Empregado extends Pessoa {
	
	private int codigoSetor;
	private double salarioBase;
	private double imposto;

	public Empregado(String nome, String endereco, String cpf, int codigoSetor, double salarioBase, double imposto) {
		super(nome, endereco, cpf);
		this.codigoSetor = codigoSetor;
		this.salarioBase = salarioBase;
		this.imposto = imposto;
	}

	public double calcularSalario() {
		return this.salarioBase - (this.salarioBase * this.imposto);
	}
	
}