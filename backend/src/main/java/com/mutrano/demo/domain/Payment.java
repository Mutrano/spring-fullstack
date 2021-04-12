package com.mutrano.demo.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.mutrano.demo.domain.enums.PaymentState;
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="tb_payment")
public abstract class Payment {
	
	@Id
	private Integer id;
	
	private PaymentState paymentState;
	
	@OneToOne
	@JoinColumn(name="order_id")
	@MapsId
	private Order order;
	
	public Payment() {
		
	}
	public Payment(Integer id, PaymentState paymentState, Order order) {
		super();
		this.id = id;
		this.paymentState = paymentState;
		this.order=order;
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
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	
	
}
