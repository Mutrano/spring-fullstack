package com.mutrano.demo.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mutrano.demo.domain.Category;
import com.mutrano.demo.dtos.CategoryDTO;
import com.mutrano.demo.services.CategoryService;
import com.mutrano.demo.services.exceptions.DataIntegrityException;
import com.mutrano.demo.services.exceptions.ResourceNotFoundException;

@RestController
@RequestMapping(value="/categories")
public class CategoryResource {
	private CategoryService categoryService;

	public CategoryResource(CategoryService categoryService) {
		this.categoryService=categoryService;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CategoryDTO> findById(@PathVariable Integer id) throws ResourceNotFoundException{
		CategoryDTO category = categoryService.findById(id);
		return ResponseEntity.ok().body(category);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@RequestBody @Valid CategoryDTO dto,   @PathVariable Integer id) throws ResourceNotFoundException {
		CategoryDTO categoryDTO = categoryService.update(dto);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody @Valid CategoryDTO dto ){
		 CategoryDTO insertedCategoryDTO = categoryService.insert(dto);
		 URI uri = ServletUriComponentsBuilder.
				 	fromCurrentRequest().path("/{id}").buildAndExpand(insertedCategoryDTO.getId()).toUri();
		 return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) throws ResourceNotFoundException, DataIntegrityException {
		categoryService.delete(id);
		return ResponseEntity.noContent().build();
	}
	@GetMapping()
	public ResponseEntity<List<CategoryDTO>> findAll() throws ResourceNotFoundException{
		List<CategoryDTO> categories = categoryService.findAll();
		return ResponseEntity.ok().body(categories);
	}
	
	@GetMapping(value="/page")
	public ResponseEntity<Page<CategoryDTO>> findPage(
			@RequestParam(value="page",defaultValue="0") Integer page,
			@RequestParam(value="linesPerPage",defaultValue="24") Integer linesPerPage,
			@RequestParam(value="orderBy",defaultValue="name") String orderBy,
			@RequestParam(value="direction",defaultValue="ASC") String direction) throws ResourceNotFoundException{
		Page<CategoryDTO> categories = categoryService.findPage(page, linesPerPage, orderBy, direction);
		return ResponseEntity.ok().body(categories);
	}
	
	
	
}