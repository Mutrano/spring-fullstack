package com.mutrano.demo.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import com.mutrano.demo.domain.Category;
import com.mutrano.demo.dtos.CategoryDTO;

@Mapper(componentModel = "spring")
public interface CategoryMapper {	
	Category toEntity(CategoryDTO categoryDTO);
	
	CategoryDTO toDTO(Category category);
}
