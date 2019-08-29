package com.warba.abcstore.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.warba.abcstore.bean.ReceiptBodyParameter;
import com.warba.abcstore.dto.ABCStoreReceipt;
import com.warba.abcstore.exception.ResourceNotFoundException;
import com.warba.abcstore.service.ABCStoreReceiptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping(value = "/api/v1")
@Api(value = "ABCStore Receipt", description = " Calculate the total amount of the purchased items in addition to the discount amount. ")

public class ABCStoreReceiptController {

	@Autowired
	ABCStoreReceiptService abcStoreReceiptService;
	
	@Autowired
	ABCStoreReceipt receipt;
	
	@ApiOperation(value = "Get the total amount with discount")
	@PostMapping("/getReceipt")
	public ABCStoreReceipt getTotalAmountWithDiscout(@Valid @RequestBody ReceiptBodyParameter receiptBodyParameter) throws ResourceNotFoundException {
	
		receipt = abcStoreReceiptService.getTotalAmountWithDiscout(receiptBodyParameter);
	
		return receipt;
	}
	

}
