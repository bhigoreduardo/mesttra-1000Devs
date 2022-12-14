package br.com.escola.domain.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long matricula;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false, name = "data_nascimento")
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private LocalDate dataNascimento;

	@Column(unique = true)
	private String cpf;

	@Column(nullable = false, name = "valor_mensalidade")
	private Float valorMensalidade;

	public Aluno() {

	}

	public Aluno(Long matricula, String nome, LocalDate dataNascimento, String cpf, Float valorMensalidade) {
		this.matricula = matricula;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		this.valorMensalidade = valorMensalidade;
	}

	public Long getMatricula() {
		return matricula;
	}

	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Float getValorMensalidade() {
		return valorMensalidade;
	}

	public void setValorMensalidade(Float valorMensalidade) {
		this.valorMensalidade = valorMensalidade;
	}

	@Override
	public String toString() {
		return "Aluno [matricula=" + matricula + ", nome=" + nome + ", dataNascimento=" + dataNascimento + ", cpf="
				+ cpf + ", valorMensalidade=" + valorMensalidade + "]";
	}

}
