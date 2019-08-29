package com.warba.abcstore.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.warba.abcstore.bean.ReceiptBodyParameter;
import com.warba.abcstore.dto.ABCStoreReceipt;
import com.warba.abcstore.entity.Item;
import com.warba.abcstore.exception.ResourceNotFoundException;
import com.warba.abcstore.repository.CustomerCategoryDiscountRepository;
import com.warba.abcstore.repository.ItemRepository;

@Service
public class ABCStoreReceiptService {

	@Autowired
	ItemRepository itemRepository;

	@Autowired
	CustomerCategoryDiscountRepository customerCategoryDiscountRepository;

	@Autowired
	ABCStoreReceipt receipt;

	public ABCStoreReceipt getTotalAmountWithDiscout(ReceiptBodyParameter receiptBodyParameter)throws ResourceNotFoundException {

		double totalAmountBeforeDiscount = 0;
		double totalAmountAfterDiscount = 0;
		double totalDiscount = 0;
		
		List<Item> purchasedCustomerItems = receiptBodyParameter.getItems();

		for (Item item : purchasedCustomerItems) {

			Item passedItem = itemRepository.findById(item.getId()).orElseThrow(() -> new ResourceNotFoundException("Item id not found for this id :: " + item.getId()));

			int discountAmont = getDiscountPercentage(passedItem.getCategory().getId(),receiptBodyParameter.getCustomer().getCustomerType().getId());
            double doubleItemPrice = passedItem.getPrice();
			double itemPriceAfterDiscount = 0 ;
            
			if(discountAmont > 0) {
				
				itemPriceAfterDiscount = (doubleItemPrice * discountAmont) / 100 ;
			
			}else {
				
				itemPriceAfterDiscount += passedItem.getPrice();
			}

			totalAmountAfterDiscount  += itemPriceAfterDiscount;
			totalAmountBeforeDiscount += passedItem.getPrice();
		
		}
		
		
		totalDiscount = totalAmountBeforeDiscount - totalAmountAfterDiscount ;
		
		 
		 receipt.setTotalAmountAfterDiscout(totalAmountAfterDiscount);
		 receipt.setTotalAmountBeforeDiscout(totalAmountBeforeDiscount);
		 receipt.setTotalAmountDisconut(totalDiscount);

		
	 return receipt;

	}

	
	
	private int getDiscountPercentage(long categoryId, long customerTypeId) {

		int discountAmountPercentage = 0;

		   discountAmountPercentage = customerCategoryDiscountRepository.getDiscountPercentage(categoryId, customerTypeId);

		return discountAmountPercentage;

	}

}
