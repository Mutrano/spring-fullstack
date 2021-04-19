package com.mutrano.demo.dtos;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.mutrano.demo.domain.Category;

public class CategoryDTO {
	
	private Integer id; 
	
	@NotEmpty(message="Category name must be not empty")
	@Length(min=5,max=80, message="The size must be between 5 and 80 characters")
	private String name;
	
	public CategoryDTO() {
		
	}
	public CategoryDTO(Integer id, String name) {
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
