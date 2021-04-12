package com.mutrano.demo.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.mutrano.demo.domain.enums.PaymentState;

@Entity
@Table(name="tb_credit_card_payment")
public class CreditCardPayment extends Payment{
	private Integer numberOfParcels;

	public CreditCardPayment() {
		super();
		
	}

	public CreditCardPayment(Integer id, PaymentState paymentState,Integer numberOfParcels,Order order) {
		super(id, paymentState,order);
		this.setNumberOfParcels(numberOfParcels);
	}

	public Integer getNumberOfParcels() {
		return numberOfParcels;
	}

	public void setNumberOfParcels(Integer numberOfParcels) {
		this.numberOfParcels = numberOfParcels;
	}
	
}