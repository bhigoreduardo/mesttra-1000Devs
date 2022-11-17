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
		return	"\t\tNumero da Conta: " + numeroConta + "\n" +
				"\t\tNumero da Agencia: " + agencia + "\n" +
				"\t\tNumero do Telefone: " + telefone + "\n" +
				"\t\tTotal do Saldo: " + saldo + "\n" +
				"\t\tLimite do Cheque Especial: " + limiteChequeEspecial + "\n";
	}

}
