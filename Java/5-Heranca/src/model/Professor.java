package model;

public class Professor extends Funcionario {
	
	private String nivelGraduacao;
	private String disciplina;
	private Integer quantidadeAluno;
	private Integer quantidadeTurma;

	public Professor(String nome, String cpf, Integer numeroRegistro, String orgaoLotacao, Double salario,
			String nivelGraduacao, String disciplina, Integer quantidadeAluno, Integer quantidadeTurma) {
		super(nome, cpf, numeroRegistro, orgaoLotacao, salario);
		this.nivelGraduacao = nivelGraduacao;
		this.disciplina = disciplina;
		this.quantidadeAluno = quantidadeAluno;
		this.quantidadeTurma = quantidadeTurma;
	}

	public String getNivelGraduacao() {
		return this.nivelGraduacao;
	}

	public String getdisciplina() {
		return this.disciplina;
	}

	public Integer getquantidadeAluno() {
		return this.quantidadeAluno;
	}

	public Integer getquantidadeTurma() {
		return this.quantidadeTurma;
	}

	public void setNivelGraduacao(String nivelGraduacao) {
		this.nivelGraduacao = nivelGraduacao;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public void setQuantidadeAluno(Integer quantidadeAluno) {
		this.quantidadeAluno = quantidadeAluno;
	}
	
}