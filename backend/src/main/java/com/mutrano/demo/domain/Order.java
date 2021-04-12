package com.mutrano.demo.domain;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "tb_order")
public class Order {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Instant instant;
	
	@ManyToOne
	@JoinColumn(name="delivery_address_id")
	private Address deliveryAddress;
	
	@ManyToOne
	@JoinColumn(name="client_id")
	private Client client;
	
	@OneToOne(cascade= CascadeType.ALL,mappedBy="order" )
	private Payment payment;
	
	@OneToMany(mappedBy="id.order")
	private Set<OrderItem> items= new HashSet<>();
	
	public Order() {
	}


	public Order(Integer id, Instant instant, Address deliveryAddress, Client client, Payment payment) {
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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	


}