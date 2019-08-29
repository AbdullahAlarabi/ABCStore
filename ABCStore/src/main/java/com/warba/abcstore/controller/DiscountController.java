package com.warba.abcstore.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.warba.abcstore.entity.CustomerCategoryDiscount;
import com.warba.abcstore.repository.CustomerCategoryDiscountRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(value = "/api/v1")
@Api(value = "ABCStore Discount Administrator", description = " ABCStore Discount List ")

public class DiscountController {
	
	
	@Autowired
	CustomerCategoryDiscountRepository customerCategoryDiscountRepository;
	
	
	@ApiOperation(value = "Add new Discount for any Customer type stored in database")
	@PostMapping("/discounts")
	public CustomerCategoryDiscount createDiscount(@ApiParam(value = "Discount object store in database table", required = true) @Valid @RequestBody CustomerCategoryDiscount customerCategoryDiscount) {
	
		return customerCategoryDiscountRepository.save(customerCategoryDiscount);
		
	}
	

}
