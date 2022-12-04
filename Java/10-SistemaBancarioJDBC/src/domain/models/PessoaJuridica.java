package domain.models;

import java.math.BigDecimal;
import java.util.Arrays;

public class PessoaJuridica extends Pessoa {

	private String cnpj;
	private String[] socios = new String[3];
	private String nomeFantasia;

	public PessoaJuridica() {
	}

	public PessoaJuridica(String numeroConta, String agencia, String telefone, BigDecimal saldo,
			BigDecimal limiteChequeEspecial, String cnpj, String[] socios, String nomeFantasia) {
		super(numeroConta, agencia, telefone, saldo, limiteChequeEspecial);
		this.cnpj = cnpj;
		this.socios = socios;
		this.nomeFantasia = nomeFantasia;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String[] getSocios() {
		return socios;
	}

	public void setSocios(String[] socios) {
		this.socios = socios;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	@Override
	public String toString() {
		return  "\t\tCliente PJ:\n" +
				"\t\tCNPJ do Cliente: " + cnpj + "\n" +
				"\t\tSocios do Cliente: " + Arrays.toString(socios) + "\n" +
				"\t\tNome Fantasia: " + nomeFantasia + "\n" +
				super.toString();
	}

}
