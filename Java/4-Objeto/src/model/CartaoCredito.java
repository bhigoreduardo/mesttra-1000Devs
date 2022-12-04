package model;

public class CartaoCredito {

	private double limite;
	private double saldo;
	private String nomeCliente;

	public void aumentarLimite(double limite) {
		this.limite += limite;
	}

	public void diminuirLimite(double limite) {
		this.limite -= limite;
	}

	public void realizarCompra(double valorCompra) {
		if (saldo == limite) {
			return;
		}

		this.saldo += valorCompra;
	}

	public void imprimirFatura() {
		System.out.println(this.saldo);
	}

}