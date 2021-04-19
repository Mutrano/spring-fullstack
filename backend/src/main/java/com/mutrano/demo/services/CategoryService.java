package com.mutrano.demo.services;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.mutrano.demo.domain.Category;
import com.mutrano.demo.dtos.CategoryDTO;
import com.mutrano.demo.mapper.CategoryMapper;
import com.mutrano.demo.repositories.CategoryRepository;
import com.mutrano.demo.services.exceptions.DataIntegrityException;
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
				.orElseThrow(()-> new ResourceNotFoundException("category with id "+id+" was not found"));
		
		return categoryMapper.toDTO(foundCategory);
	}
	
	public CategoryDTO insert(CategoryDTO dto) {
		Category category = categoryMapper.toEntity(dto);
		Category insertedCategory =categoryRepository.save(category);
		return categoryMapper.toDTO(insertedCategory);
	}
	
	public CategoryDTO update(CategoryDTO dto) throws ResourceNotFoundException {
		CategoryDTO foundCategoryDTO = findById(dto.getId());
		foundCategoryDTO.setName(dto.getName());
		Category foundCategory = categoryMapper.toEntity(foundCategoryDTO);
		foundCategory = categoryRepository.save(foundCategory);
		return categoryMapper.toDTO(foundCategory);
	}
	
	public void delete(Integer id) throws ResourceNotFoundException, DataIntegrityException {
		findById(id);
		try {
			categoryRepository.deleteById(id);
		}
		catch(DataIntegrityViolationException expn) {
			throw new DataIntegrityException("It's not possible to delete a category with products");
		}
	}
	
	public List<CategoryDTO> findAll(){
		List<Category> foundCategories = categoryRepository.findAll();
		return categoryMapper.toDTO(foundCategories);
	}
	public Page<CategoryDTO> findPage(Integer page,Integer linesPerPage,String orderBy,String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage,Direction.valueOf(direction),orderBy);
		Page<Category> categoryPage= categoryRepository.findAll(pageRequest);
		return categoryPage.map(obj -> new CategoryDTO(obj));
	}

}
