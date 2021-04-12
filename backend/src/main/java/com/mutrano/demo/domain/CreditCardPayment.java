package com.mutrano.demo.domain;

import com.mutrano.demo.domain.enums.PaymentState;

public class CreditCardPayment extends Payment{
	private Integer numberOfParcels;

	public CreditCardPayment() {
		super();
		
	}

	public CreditCardPayment(Integer id, PaymentState paymentState,Integer numberOfParcels) {
		super(id, paymentState);
		this.numberOfParcels=numberOfParcels;
	}
	
}