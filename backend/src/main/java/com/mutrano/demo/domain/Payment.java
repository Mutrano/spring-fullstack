package com.mutrano.demo.domain;

import com.mutrano.demo.domain.enums.PaymentState;

public abstract class Payment {
	private Integer id;
	private PaymentState paymentState;
	
	public Payment() {
		
	}
	public Payment(Integer id, PaymentState paymentState) {
		super();
		this.id = id;
		this.paymentState = paymentState;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public PaymentState getPaymentType() {
		return paymentState;
	}
	public void setPaymentType(PaymentState paymentState) {
		this.paymentState = paymentState;
	}
	
	
}
