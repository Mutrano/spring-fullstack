package com.mutrano.demo.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mutrano.demo.domain.enums.PaymentState;
@Entity
@Table(name="tb_boleto_payment")
public class BoletoPayment extends Payment {
	@JsonFormat(pattern="dd/MM/yyyy")
	private LocalDate dueDate;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private LocalDate paymentDate;
	
	public BoletoPayment() {
		super();
	}
	public BoletoPayment(Integer id, PaymentState paymentState,Order order,LocalDate dueDate,LocalDate paymentDate) {
		super(id, paymentState,order);
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
