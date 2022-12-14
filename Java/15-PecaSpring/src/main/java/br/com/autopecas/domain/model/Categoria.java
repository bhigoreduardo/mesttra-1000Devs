package br.com.autopecas.domain.model;

public enum Categoria {
	
	FUNILARIA("Funilaria"),
	MOTOR("Motor"),
	PERFORMANCE("Motor"),
	SOM("Som");
	
	private String type;
	
	private Categoria(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}

}
