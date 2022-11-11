package topic.herance;

public class FuncionarioAdministrativo extends Funcionario {

	private String funcaoAdministrativa;
	private String senioriodade;

	public FuncionarioAdministrativo(String nome, String cpf, Integer numeroRegistro, String orgaoLotacao,
			Double salario, String funcaoAdministrativa, String senioriodade) {
		super(nome, cpf, numeroRegistro, orgaoLotacao, salario);
		this.funcaoAdministrativa = funcaoAdministrativa;
		this.senioriodade = senioriodade;
	}

	public void setFuncaoAdministrativa(String funcaoAdministrativa) {
		this.funcaoAdministrativa = funcaoAdministrativa;
	}

	public void setSenioridade(String senioriodade) {
		this.senioriodade = senioriodade;
	}

	public String getFuncaoAdministrativa() {
		return this.funcaoAdministrativa;
	}

	public String getSenioridade() {
		return this.senioriodade;
	}
	
}