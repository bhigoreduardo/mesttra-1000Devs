package escola.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Sala {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int nroSala;

	@Column(nullable = false)
	private double largura;

	@Column(nullable = false)
	private double comprimento;

	@Column(nullable = false)
	private double altura;

	@OneToOne(mappedBy = "sala")
	private Turma turma;

	public Sala() {

	}

	public int getNroSala() {
		return nroSala;
	}

	public void setNroSala(int nroSala) {
		this.nroSala = nroSala;
	}

	public double getLargura() {
		return largura;
	}

	public void setLargura(double largura) {
		this.largura = largura;
	}

	public double getComprimento() {
		return comprimento;
	}

	public void setComprimento(double comprimento) {
		this.comprimento = comprimento;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

}
