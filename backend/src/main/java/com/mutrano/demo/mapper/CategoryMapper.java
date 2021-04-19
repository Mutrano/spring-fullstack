package com.mutrano.demo.mapper;

import org.mapstruct.Mapper;

import com.mutrano.demo.domain.Category;
import com.mutrano.demo.dtos.CategoryDTO;

@Mapper(componentModel = "spring")
public interface CategoryMapper {	
	Category toEntity(CategoryDTO categoryDTO);
	
	CategoryDTO toDTO(Category category);
}
