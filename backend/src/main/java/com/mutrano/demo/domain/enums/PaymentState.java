package com.mutrano.demo.domain.enums;

public enum PaymentState {
	PENDING(1,"Pending"),
	SETTLED(2,"Settled"),
	CANCELLED(3,"Canceled");
	
	private final String description;
	private final int cod;
	
	private PaymentState(int cod ,String description ) {
		this.description=description;
		this.cod= cod;
	}
	public String getDescription() {
		return description;
	}
	public int getCod() {
		return cod;
	}
}
