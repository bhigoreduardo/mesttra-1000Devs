package br.com.autopecas.api.model;

import org.springframework.beans.BeanUtils;

import br.com.autopecas.domain.model.Peca;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PecaDTOInput {

	@NotBlank(message = "Nome não pode ser nulo ou branco.")
	private String nome;

	@NotBlank(message = "Modelo do carro não pode ser nulo ou branco.")
	private String modeloCarro;

	@NotBlank(message = "Fabricante da peça não pode ser nulo ou branco.")
	private String fabricante;

	@NotNull(message = "Preço de custo não pode ser nulo.")
	private Float precoCusto;

	@NotNull(message = "Preço de venda não pode ser nulo.")
	private Float precoVenda;

	@NotNull(message = "Quantidade de estoque não pode ser nulo.")
	private Integer qtdEstoque;

	public Peca toEntity() {
		Peca peca = new Peca();
		BeanUtils.copyProperties(this, peca);

		return peca;
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

}
