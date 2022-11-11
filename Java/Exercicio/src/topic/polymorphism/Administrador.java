package topic.polymorphism;

public class Administrador extends Empregado {

	private double ajudaCusto;

	public Administrador(String nome, String endereco, String cpf, int codigoSetor, double salarioBase, double imposto,
			double ajudaCusto) {
		super(nome, endereco, cpf, codigoSetor, salarioBase, imposto);
		this.ajudaCusto = ajudaCusto;
	}

	@Override
	public double calcularSalario() {
		return super.calcularSalario() + this.ajudaCusto;
	}
	
}