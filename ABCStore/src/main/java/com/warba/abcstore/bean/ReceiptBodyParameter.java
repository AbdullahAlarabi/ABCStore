package com.warba.abcstore.bean;

import java.util.List;
import com.warba.abcstore.entity.Customer;
import com.warba.abcstore.entity.Item;

public class ReceiptBodyParameter {
	
	
	private List<Item> items; 
	private Customer customer;
	
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	

}
