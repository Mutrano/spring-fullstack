package com.mutrano.demo.dtos;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mutrano.demo.domain.Address;
import com.mutrano.demo.domain.Client;
import com.mutrano.demo.domain.OrderItem;
import com.mutrano.demo.domain.Payment;

public class OrderDTO {
	private Integer id;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Instant instant;

	private Address deliveryAddress;

	private Client client;

	private Payment payment;

	private Set<OrderItem> items = new HashSet<>();
	
	public OrderDTO() {
		
	}

	public OrderDTO(Integer id, Instant instant, Address deliveryAddress, Client client, Payment payment) {
		this.id = id;
		this.instant = instant;
		this.deliveryAddress = deliveryAddress;
		this.client = client;
		this.payment = payment;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Instant getInstant() {
		return instant;
	}

	public void setInstant(Instant instant) {
		this.instant = instant;
	}

	public Address getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(Address deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Set<OrderItem> getItems() {
		return items;
	}

	public void setItems(Set<OrderItem> items) {
		this.items = items;
	}
}
