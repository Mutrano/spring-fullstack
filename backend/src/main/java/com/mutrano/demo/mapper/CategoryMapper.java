package com.mutrano.demo.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import com.mutrano.demo.domain.Category;
import com.mutrano.demo.dtos.CategoryDTO;

@Mapper(componentModel = "spring")
public interface CategoryMapper {	
	Category toEntity(CategoryDTO categoryDTO);
	
	CategoryDTO toDTO(Category category);
	
	List<Category> toEntity(List<CategoryDTO> categoryDTOs);
	
	List<CategoryDTO> toDTO(List<Category> categories);
}
