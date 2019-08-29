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
import com.warba.abcstore.entity.Item;
import com.warba.abcstore.exception.ResourceNotFoundException;
import com.warba.abcstore.repository.ItemRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping(value = "/api/v1")
@Api(value = "Items", description = "CRUD operations for the Items")
public class ItemController {
	
	@Autowired
    ItemRepository itemRepository;

	@ApiOperation(value = "View a list of available items", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			                @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			                @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			                @ApiResponse(code = 404, message = "The resource you were trying to reach is not found") 
	                       })
	@GetMapping("/items")
	public List<Item> getAllItems() {

		return itemRepository.findAll();

	}
	
	
	@ApiOperation(value = "Add an Item")
	@PostMapping("/items")
	public Item createItem(
			@ApiParam(value = "Item object store in database table", required = true) @Valid @RequestBody Item item) {
	
		return itemRepository.save(item);
		
	}


	@ApiOperation(value = "Update an item")
	@PutMapping("/items/{id}")
	public ResponseEntity<Item> updateItem(
			@ApiParam(value = "Item Id to update item object", required = true) @PathVariable(value = "id") Long itemId)
			throws ResourceNotFoundException {
		
		Item item = itemRepository.findById(itemId).orElseThrow(() -> new ResourceNotFoundException("Item not found for this id :: " + itemId));

		item.setItemName(item.getItemName());
		item.setPrice(item.getPrice());
		item.setCategory(item.getCategory());
		
		final Item updatedItem = itemRepository.save(item);
		
		return ResponseEntity.ok(updatedItem);
	
	}


	@ApiOperation(value = "Delete an item")
	@DeleteMapping("/items/{id}")
	public Map<String, Boolean> deleteItem(
			@ApiParam(value = "Item Id from which item object will delete from database table", required = true) @PathVariable(value = "id") Long itemId)
			throws ResourceNotFoundException {
		
		Item item = itemRepository.findById(itemId).orElseThrow(() -> new ResourceNotFoundException("Item not found for this id :: " + itemId));

		itemRepository.delete(item);
		Map<String, Boolean> response = new HashMap<>();
		
		response.put("deleted", Boolean.TRUE);
		
		return response;
	}

}
