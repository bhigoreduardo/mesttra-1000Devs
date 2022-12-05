package multa.entity;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Condutor {

	@Id
	@Column(name = "nro_cnh")
	private String nroCnh;

	@Column(name = "data_emissao", nullable = false)
	private LocalDate dataEmissao;

	@Column(name = "orgao_emissor", nullable = false)
	private String orgaoEmissor;

	private int pontuacao = 0;

	@OneToOne(mappedBy = "condutor", cascade = CascadeType.ALL)
	private Veiculo veiculo;

	public String getNroCnh() {
		return nroCnh;
	}

	public void setNroCnh(String nroCnh) {
		this.nroCnh = nroCnh;
	}

	public LocalDate getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(LocalDate dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public String getOrgaoEmissor() {
		return orgaoEmissor;
	}

	public void setOrgaoEmissor(String orgaoEmissor) {
		this.orgaoEmissor = orgaoEmissor;
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
		return "Condutor [nroCnh=" + nroCnh + ", dataEmissao=" + dataEmissao + ", orgaoEmissor=" + orgaoEmissor
				+ ", pontuacao=" + pontuacao + ", veiculo=" + veiculo + "]";
	}

}
