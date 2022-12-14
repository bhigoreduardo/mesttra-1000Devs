package br.com.autopecas.domain.model;

import br.com.autopecas.domain.exception.NegocioException;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Peca {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codBarras;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private String modeloCarro;

	@Column(nullable = false)
	private String fabricante;

	@Column(nullable = false)
	private Float precoCusto;

	@Column(nullable = false)
	private Float precoVenda;

	@Column(nullable = false)
	private Integer qtdEstoque;

	@Enumerated(EnumType.STRING)
	private Categoria categoria;

	public Peca() {

	}

	public Peca(Long codBarras, String nome, String modeloCarro, String fabricante, Float precoCusto, Float precoVenda,
			Integer qtdEstoque, Categoria categoria) {
		this.codBarras = codBarras;
		this.nome = nome;
		this.modeloCarro = modeloCarro;
		this.fabricante = fabricante;
		this.precoCusto = precoCusto;
		this.precoVenda = precoVenda;
		this.qtdEstoque = qtdEstoque;
		this.categoria = categoria;
	}

	public Long getCodBarras() {
		return codBarras;
	}

	public void setCodBarras(Long codBarras) {
		this.codBarras = codBarras;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getModeloCarro() {
		return modeloCarro;
	}

	public void setModeloCarro(String modeloCarro) {
		this.modeloCarro = modeloCarro;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public Float getPrecoCusto() {
		return precoCusto;
	}

	public void setPrecoCusto(Float precoCusto) {
		this.precoCusto = precoCusto;
	}

	public Float getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(Float precoVenda) {
		this.precoVenda = precoVenda;
	}

	public Integer getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(Integer qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {

		switch (categoria) {
		case "funilaria": {
			this.categoria = Categoria.FUNILARIA;
			break;
		}
		case "motor": {
			this.categoria = Categoria.MOTOR;
			break;
		}
		case "performance": {
			this.categoria = Categoria.PERFORMANCE;
			break;
		}
		case "som": {
			this.categoria = Categoria.SOM;
			break;
		}
		default:
			throw new NegocioException(String.format("Categoria %s inválida.", categoria));
		}
		
	}

}
