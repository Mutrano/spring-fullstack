package com.mutrano.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_address")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String  publicPlace;
	private String number;
	private String complement;
	private String residentialArea;
	private String zipCode;
	
	@ManyToOne
	@JoinColumn(name="city_id")
	private City city;
	
	@ManyToOne()
	@JoinColumn(name="client_id")
	private Client client;
	
	public Address() {
	}
	public Address(Integer id, String publicPlace, String number, String complement, String residentialArea,
			String zipCode) {
		this.id = id;
		this.publicPlace = publicPlace;
		this.number = number;
		this.complement = complement;
		this.residentialArea = residentialArea;
		this.zipCode = zipCode;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPublicPlace() {
		return publicPlace;
	}
	public void setPublicPlace(String publicPlace) {
		this.publicPlace = publicPlace;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getComplement() {
		return complement;
	}
	public void setComplement(String complement) {
		this.complement = complement;
	}
	public String getResidentialArea() {
		return residentialArea;
	}
	public void setResidentialArea(String residentialArea) {
		this.residentialArea = residentialArea;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
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
		Address other = (Address) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
}
