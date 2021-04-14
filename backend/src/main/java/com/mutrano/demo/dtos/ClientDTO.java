package com.mutrano.demo.dtos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.mutrano.demo.domain.Address;
import com.mutrano.demo.domain.Order;
import com.mutrano.demo.domain.enums.ClientType;

public class ClientDTO {
	private Integer id;
	private String name;
	private String email;
	private String cpfOrCnpj;
	private ClientType clientType;

	private List<Address> addresses = new ArrayList<>();

	private Set<String> phones = new HashSet<>();

	private List<Order> orders = new ArrayList<>();

	public ClientDTO() {
		
	}

	public ClientDTO(Integer id, String name, String email, String cpfOrCnpj, ClientType clientType) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.cpfOrCnpj = cpfOrCnpj;
		this.clientType = clientType;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpfOrCnpj() {
		return cpfOrCnpj;
	}

	public void setCpfOrCnpj(String cpfOrCnpj) {
		this.cpfOrCnpj = cpfOrCnpj;
	}

	public ClientType getClientType() {
		return clientType;
	}

	public void setClientType(ClientType clientType) {
		this.clientType = clientType;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public Set<String> getPhones() {
		return phones;
	}

	public void setPhones(Set<String> phones) {
		this.phones = phones;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
}
