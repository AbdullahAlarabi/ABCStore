package com.warba.abcstore.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.warba.abcstore.entity.Category;
import com.warba.abcstore.exception.ResourceNotFoundException;
import com.warba.abcstore.repository.CategoryRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/api/v1")
@Api(value = "Categories", description = "CRUD operations for Category")
public class CategoryController {

	
	@Autowired
	CategoryRepository categoryRepository;
	
	@ApiOperation(value = "View a list of available Category", response = List.class)
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping("/categories")
	public List<Category> getAllCategories() {

		return categoryRepository.findAll();

	}
	
	
	@ApiOperation(value = "Add a Category")
	@PostMapping("/categories")
	public Category createCategory(
			@ApiParam(value = "Category object store in database table", required = true) @Valid @RequestBody Category category) {
	
		return categoryRepository.save(category);
		
	}

	
	@ApiOperation(value = "Update a Category")
	@PutMapping("/categories/{id}")
	public ResponseEntity<Category> updateCategory(
			@ApiParam(value = "Category id to update Category object", required = true) @PathVariable(value = "id") Long categoryId)
			throws ResourceNotFoundException {
		
		Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category not found for this id :: " + categoryId));

		category.setCategory(category.getCategory());
		
		final Category updatedItem = categoryRepository.save(category);
		
		return ResponseEntity.ok(updatedItem);
	
	}


	@ApiOperation(value = "Delete a Category")
	@DeleteMapping("/categories/{id}")
	public Map<String, Boolean> deleteCategory(
			@ApiParam(value = "Category Id from which Category object will delete from database table", required = true) @PathVariable(value = "id") Long categoryId)
			throws ResourceNotFoundException {
		
		Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Item not found for this id :: " + categoryId));

		categoryRepository.delete(category);
		Map<String, Boolean> response = new HashMap<>();
		
		response.put("deleted", Boolean.TRUE);
		
		return response;
	}

	
	
}
