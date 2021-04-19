package com.mutrano.demo.dtos;

import java.util.List;

import com.mutrano.demo.domain.Category;
import com.mutrano.demo.domain.Product;

public class CategoryDTO {
	
	private Integer id; 
	
	private String name;
	public CategoryDTO() {
		
	}
	public CategoryDTO(Integer id, String name, List<Product> products) {
		this.id = id;
		this.name = name;
	}
	public CategoryDTO(Category category) {
		this.id=category.getId();
		this.name=category.getName();
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
}
