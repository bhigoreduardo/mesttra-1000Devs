package pojo;

public class Cidade {

	private Integer ddd;
	private String nome;
	private Integer numeroHabitantes;
	private Double rendaPerCapita;
	private Boolean capital = Boolean.FALSE;
	private String estado;
	private String prefeito;

	public Cidade() {

	}

	public Cidade(Integer ddd, String nome, Integer numeroHabitantes, Double rendaPerCapita, String estado,
			String prefeito) {
		this.ddd = ddd;
		this.nome = nome;
		this.numeroHabitantes = numeroHabitantes;
		this.rendaPerCapita = rendaPerCapita;
		this.estado = estado;
		this.prefeito = prefeito;
	}

	public Integer getDdd() {
		return ddd;
	}

	public void setDdd(Integer ddd) {
		this.ddd = ddd;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getNumeroHabitantes() {
		return numeroHabitantes;
	}

	public void setNumeroHabitantes(Integer numeroHabitantes) {
		this.numeroHabitantes = numeroHabitantes;
	}

	public Double getRendaPerCapita() {
		return rendaPerCapita;
	}

	public void setRendaPerCapita(Double rendaPerCapita) {
		this.rendaPerCapita = rendaPerCapita;
	}

	public Boolean getCapital() {
		return capital;
	}

	public void setCapital(Boolean capital) {
		this.capital = capital;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPrefeito() {
		return prefeito;
	}

	public void setPrefeito(String prefeito) {
		this.prefeito = prefeito;
	}

	@Override
	public String toString() {
		return "\t\t" + ddd + " \t\t" + nome + " \t\t" + numeroHabitantes + " \t\t" + rendaPerCapita + " \t\t" + capital
				+ " \t\t" + estado + " \t\t" + prefeito;
	}

}
