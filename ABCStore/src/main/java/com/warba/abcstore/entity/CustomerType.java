package com.warba.abcstore.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "customer_type")
@ApiModel(description = "All CustomerType on the ABCStore")
public class CustomerType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7080081738887139397L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(notes = "The database auto increment Customer type ID")
	@Column(name = "customer_type_id")
	private long id;

	@Column(name = "customer_type")
	@ApiModelProperty(notes = "The database Customer type name")
	private String customerType;
	
	@JsonIgnore
	@OneToMany(mappedBy = "customerType" , fetch = FetchType.EAGER)
	@ApiModelProperty(notes = "Relation between CustomerType and Customer")
	private Set<Customer> customer;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.customerType", cascade=CascadeType.ALL)
	private Set<CustomerCategoryDiscount> customerCategoryDiscounts = new HashSet<CustomerCategoryDiscount>(0);
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public Set<Customer> getCustomer() {
		return customer;
	}

	public void setCustomer(Set<Customer> customer) {
		this.customer = customer;
	}

	public Set<CustomerCategoryDiscount> getCustomerCategoryDiscounts() {
		return customerCategoryDiscounts;
	}

	public void setCustomerCategoryDiscounts(Set<CustomerCategoryDiscount> customerCategoryDiscounts) {
		this.customerCategoryDiscounts = customerCategoryDiscounts;
	}

	

}
