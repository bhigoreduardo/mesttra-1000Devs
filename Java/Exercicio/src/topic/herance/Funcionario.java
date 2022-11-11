package topic.herance;

public class Funcionario {

	private String nome;
	private String cpf;
	private Integer numeroRegistro;
	private String orgaoLotacao;
	private Double salario;

	public Funcionario(String nome, String cpf, Integer numeroRegistro, String orgaoLotacao, Double salario) {
		this.nome = nome;
		this.cpf = cpf;
		this.numeroRegistro = numeroRegistro;
		this.orgaoLotacao = orgaoLotacao;
		this.salario = salario;
	}

	public String getNome() {
		return this.nome;
	}

	public String getCpf() {
		return this.cpf;
	}

	public Integer getNumeroRegistro() {
		return this.numeroRegistro;
	}

	public String getOrgaoLotacao() {
		return this.orgaoLotacao;
	}

	public Double getSalario() {
		return this.salario;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setOrgaoLotacao(String orgaoLotacao) {
		this.orgaoLotacao = orgaoLotacao;
	}

	protected void setSalario(Double salario) {
		this.salario = salario;
	}

	public void aumentarSalario() {
		this.salario = this.salario * 1.1;
	}

}