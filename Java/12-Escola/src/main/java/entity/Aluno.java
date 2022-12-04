package entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int matricula;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private String serie;

	@Column(name = "data_nascimento", nullable = false)
	private LocalDate dataNascimento;

	@ManyToMany
	@JoinTable(name = "turma_aluno",
				joinColumns = @JoinColumn(name = "aluno_fk", referencedColumnName = "matricula"),
				inverseJoinColumns = @JoinColumn(name = "turma_fk", referencedColumnName = "cod_turma"))
	private List<Turma> turmas;

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

	@Override
	public String toString() {
		return "Aluno [matricula=" + matricula + ", nome=" + nome + ", serie=" + serie + ", dataNascimento="
				+ dataNascimento + ", turmas=" + turmas + "]";
	}

}
