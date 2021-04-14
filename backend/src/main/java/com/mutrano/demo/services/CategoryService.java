package com.mutrano.demo.services;

import org.springframework.stereotype.Service;

import com.mutrano.demo.domain.Category;
import com.mutrano.demo.dtos.CategoryDTO;
import com.mutrano.demo.mapper.CategoryMapper;
import com.mutrano.demo.repositories.CategoryRepository;
import com.mutrano.demo.services.exceptions.ResourceNotFoundException;

@Service
public class CategoryService {

	private CategoryRepository categoryRepository;
	

	private CategoryMapper categoryMapper;
	
	public CategoryService(CategoryRepository categoryRepository,CategoryMapper categoryMapper) {
		this.categoryRepository=categoryRepository;
		this.categoryMapper=categoryMapper;
	}
	
	public CategoryDTO findById(Integer id) throws ResourceNotFoundException {
		Category foundCategory = categoryRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("category with id was not found"));
		
		return categoryMapper.toDTO(foundCategory);
	}
	
	public CategoryDTO insert(CategoryDTO dto) {
		Category category = categoryMapper.toEntity(dto);
		Category insertedCategory =categoryRepository.save(category);
		return categoryMapper.toDTO(insertedCategory);
	}

}
