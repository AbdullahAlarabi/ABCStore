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
import com.warba.abcstore.entity.CustomerType;
import com.warba.abcstore.exception.ResourceNotFoundException;
import com.warba.abcstore.repository.CustomerTypeRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/api/v1")
@Api(value = "CustomerType", description = "CRUD operations for the CustomerType")
public class CustomerTypeController {
	
	
	@Autowired
	CustomerTypeRepository customerTypeRepository;

	
	@ApiOperation(value = "View a list of available CustomerType", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping("/customerTypes")
	public List<CustomerType> getAllCategories() {

		return customerTypeRepository.findAll();

	}	
	
	
	@ApiOperation(value = "Add a CustomerType")
	@PostMapping("/customerTypes")
	public CustomerType createCustomer(
			@ApiParam(value = "CustomerType object store in database table", required = true) @Valid @RequestBody CustomerType customerType) {
	
		return customerTypeRepository.save(customerType);
	}
	
	
	@ApiOperation(value = "Update an CustomerType")
	@PutMapping("/customerTypes/{id}")
	public ResponseEntity<CustomerType> updateCustomerType(
			@ApiParam(value = "CustomerType Id to update CustomerType object", required = true) @PathVariable(value = "id") Long customerTypeId)
			throws ResourceNotFoundException {
		
		CustomerType customerType = customerTypeRepository.findById(customerTypeId).orElseThrow(() -> new ResourceNotFoundException("CustomerType not found for this id :: " + customerTypeId));

		customerType.setCustomerType(customerType.getCustomerType());
		final CustomerType updatedItem = customerTypeRepository.save(customerType);
		
		return ResponseEntity.ok(updatedItem);
	
	}
	
	
	@ApiOperation(value = "Delete an CustomerType")
	@DeleteMapping("/customerTypes/{id}")
	public Map<String, Boolean> deleteItem(
			@ApiParam(value = "CustomerType Id from which CustomerType object will delete from database table", required = true) @PathVariable(value = "id") Long customerTypeId)
			throws ResourceNotFoundException {
		
		CustomerType customerType = customerTypeRepository.findById(customerTypeId).orElseThrow(() -> new ResourceNotFoundException("CustomerType not found for this id :: " + customerTypeId));

		customerTypeRepository.delete(customerType);
		Map<String, Boolean> response = new HashMap<>();
		
		response.put("deleted", Boolean.TRUE);
		
		return response;
	}
	

}
