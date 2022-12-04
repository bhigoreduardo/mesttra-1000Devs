package model;

public class ContaBancaria {

	private int numeroConta;
	private double saldo;
	private String nomeCorrentista;

	public void realizarSaque(double valor) {
		if (this.saldo - valor >= 0) {
			this.saldo -= valor;
		}
	}

	public void realizarDeposito(double valor) {
		if (valor > 0) {
			this.saldo += valor;
		}
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public double getSaldo() {
		return saldo;
	}

	public String getNomeCorrentista() {
		return nomeCorrentista;
	}

	@Override
	public String toString() {
		return "ContaBancaria [numeroConta=" + numeroConta + ", saldo=" + saldo + ", nomeCorrentista=" + nomeCorrentista
				+ "]";
	}

}
