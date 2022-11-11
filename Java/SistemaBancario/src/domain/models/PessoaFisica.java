package domain.models;

import java.math.BigDecimal;

public class PessoaFisica extends Pessoa {

	private String nome;
	private String cpf;
	private Integer idade;
	
	public PessoaFisica() {
		
	}

	public PessoaFisica(String numeroConta, String agencia, String telefone, BigDecimal saldo,
			BigDecimal limiteChequeEspecial, String nome, String cpf, Integer idade) {
		super(numeroConta, agencia, telefone, saldo, limiteChequeEspecial);
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	@Override
	public String toString() {
		return "PessoaFisica [nome=" + nome + ", cpf=" + cpf + ", idade=" + idade + ", toString()=" + super.toString()
				+ "]";
	}

}
