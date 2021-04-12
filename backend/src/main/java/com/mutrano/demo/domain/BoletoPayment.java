package com.mutrano.demo.domain;

import java.time.LocalDate;

import com.mutrano.demo.domain.enums.PaymentState;

public class BoletoPayment extends Payment {
	private LocalDate dueDate;
	private LocalDate paymentDate;
	
	public BoletoPayment() {
		super();
		
	}
	public BoletoPayment(Integer id, PaymentState paymentState,LocalDate dueDate,LocalDate paymentDate) {
		super(id, paymentState);
		this.dueDate=dueDate;
		this.paymentDate=paymentDate;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	public LocalDate getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	
}
