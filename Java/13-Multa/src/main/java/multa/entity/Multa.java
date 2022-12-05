package multa.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Multa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo_multa")
	private int codigoMulta;

	@Column(nullable = false)
	private double valor;

	@Column(nullable = false)
	private int pontuacao;

	@ManyToOne(cascade = CascadeType.PERSIST, optional = false)
	@JoinColumn(name = "placa_veiculo_fk", referencedColumnName = "placa")
	private Veiculo veiculo;

	public int getCodigoMulta() {
		return codigoMulta;
	}

	public void setCodigoMulta(int codigoMulta) {
		this.codigoMulta = codigoMulta;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	@Override
	public String toString() {
		return "Multa [codigoMulta=" + codigoMulta + ", valor=" + valor + ", pontuacao=" + pontuacao + ", veiculo="
				+ veiculo + "]";
	}

}
