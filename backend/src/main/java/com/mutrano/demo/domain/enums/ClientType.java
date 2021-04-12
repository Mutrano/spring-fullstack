package com.mutrano.demo.domain.enums;

public enum ClientType {
	NATURALPERSON(1,"Natural Person"),
	LEGALPERSON(2,"Legal Person");
	private final String description;
	private final int cod;
	
	private ClientType( int cod, String description) {
		this.description = description;
		this.cod = cod;
	}
	public String getDescription() {
		return description;
	}

	public int getCod() {
		return cod;
	}
}
