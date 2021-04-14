package com.mutrano.demo.dtos;

import java.util.ArrayList;
import java.util.List;

import com.mutrano.demo.domain.Product;

public class CategoryDTO {
	
	private Integer id; 
	private String name;
	private List<Product> products = new ArrayList<>();
	public CategoryDTO() {
		
	}
	public CategoryDTO(Integer id, String name, List<Product> products) {
		this.id = id;
		this.name = name;
		this.products = products;
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
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
}
