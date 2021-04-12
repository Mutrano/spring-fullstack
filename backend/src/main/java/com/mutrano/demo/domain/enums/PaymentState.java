package com.mutrano.demo.domain.enums;

public enum PaymentState {
	PENDING("Pending"),
	SETTLED("Settled"),
	CANCELLED("Canceled");
	
	private final String description;
	
	private PaymentState(String description) {
		this.description=description;
	}
	public String getDescription() {
		return description;
	}
}
