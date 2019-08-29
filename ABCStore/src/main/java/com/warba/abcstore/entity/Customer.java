package com.warba.abcstore.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "customer")
@ApiModel(description = "All Customer on the Store")
public class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2613059045401892174L;


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(notes = "The database auto inceremnt Customer ID")
	@Column(name = "customer_id")
	private long id;

	@Column(name = "customer_name")
	@ApiModelProperty(notes = "The database Customer name")
	private String customerName;

	@ManyToOne
	@JoinColumn(name = "customer_type_id")
	@ApiModelProperty(notes = "Relation between Customer and CustomerType")
	private CustomerType customerType;

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public CustomerType getCustomerType() {
		return customerType;
	}

	public void setCustomerType(CustomerType customerType) {
		this.customerType = customerType;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}



}
