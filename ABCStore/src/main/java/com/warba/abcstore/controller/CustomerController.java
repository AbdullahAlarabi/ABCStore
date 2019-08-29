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
import com.warba.abcstore.entity.Customer;
import com.warba.abcstore.exception.ResourceNotFoundException;
import com.warba.abcstore.repository.CustomerRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/api/v1")
@Api(value = "Customers", description = "CRUD operations for the Customer")
public class CustomerController {
	
	@Autowired
	CustomerRepository customerRepository;

	
	@ApiOperation(value = "View a list of available Customers", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping("/customers")
	public List<Customer> getAllCategories() {

		return customerRepository.findAll();

	}	
	
	@ApiOperation(value = "Add a Customer")
	@PostMapping("/customers")
	public Customer createCustomer(
			@ApiParam(value = "Customer object store in database table", required = true) @Valid @RequestBody Customer customer) {
	
		return customerRepository.save(customer);
	}
	
	
	@ApiOperation(value = "Update a Customer")
	@PutMapping("/customers/{id}")
	public ResponseEntity<Customer> updateCustomer(
			@ApiParam(value = "Customer Id to update Customer object", required = true) @PathVariable(value = "id") Long customerId)
			throws ResourceNotFoundException {
		
		Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + customerId));

		customer.setCustomerType(customer.getCustomerType());		
		final Customer updatedItem = customerRepository.save(customer);
		
		return ResponseEntity.ok(updatedItem);
	
	}
	
	
	@ApiOperation(value = "Delete an Customer")
	@DeleteMapping("/customers/{id}")
	public Map<String, Boolean> deleteCustomer(
			@ApiParam(value = "Customer Id from which Customer object will delete from database table", required = true) @PathVariable(value = "id") Long customerId)
			throws ResourceNotFoundException {
		
		Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + customerId));

		customerRepository.delete(customer);
		Map<String, Boolean> response = new HashMap<>();
		
		response.put("deleted", Boolean.TRUE);
		
		return response;
	}
	
	
}
