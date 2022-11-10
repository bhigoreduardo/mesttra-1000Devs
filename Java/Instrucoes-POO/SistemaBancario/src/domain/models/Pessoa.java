package domain.models;

import java.math.BigDecimal;

public abstract class Pessoa {

	private String numeroConta;
	private String agencia;
	private String telefone;
	private BigDecimal saldo;
	private BigDecimal limiteChequeEspecial;
	
	public Pessoa() {}

	public Pessoa(String numeroConta, String agencia, String telefone, BigDecimal saldo,
			BigDecimal limiteChequeEspecial) {
		this.numeroConta = numeroConta;
		this.agencia = agencia;
		this.telefone = telefone;
		this.saldo = saldo;
		this.limiteChequeEspecial = limiteChequeEspecial;
	}

	public String getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public BigDecimal getLimiteChequeEspecial() {
		return limiteChequeEspecial;
	}

	public void setLimiteChequeEspecial(BigDecimal limiteChequeEspecial) {
		this.limiteChequeEspecial = limiteChequeEspecial;
	}

	@Override
	public String toString() {
		return "Pessoa [numeroConta=" + numeroConta + ", agencia=" + agencia + ", telefone=" + telefone + ", saldo="
				+ saldo + ", limiteChequeEspecial=" + limiteChequeEspecial + "]";
	}

}
