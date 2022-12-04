package model;

import java.math.BigDecimal;

public class Carro {

	private String nome;
	private Double peso;
	private String fabricante;
	private String cor;
	private BigDecimal valor;

	public Carro(String nome, Double peso, String fabricante, String cor, BigDecimal valor) {
		this.nome = nome;
		this.peso = peso;
		this.fabricante = fabricante;
		this.cor = cor;
		this.valor = valor;
	}

	public void realizarDesconto(BigDecimal desconto) {
		if (desconto.compareTo(this.valor) == 1) {
			this.valor.subtract(desconto);
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

}
