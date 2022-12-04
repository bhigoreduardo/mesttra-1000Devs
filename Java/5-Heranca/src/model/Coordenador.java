package model;

public class Coordenador extends Funcionario {

	private Professor[] professoresSupervisionados;

	public Coordenador(String nome, String cpf, Integer numeroRegistro, String orgaoLotacao, Double salario) {
		super(nome, cpf, numeroRegistro, orgaoLotacao, salario);
		this.professoresSupervisionados = new Professor[10];
	}

	public Professor[] getProfessoresSupervisionados() {
		return this.professoresSupervisionados;
	}

	@Override
	public void aumentarSalario() {
		super.setSalario(super.getSalario() * 1.05);
	}

}