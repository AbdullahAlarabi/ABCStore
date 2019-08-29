package com.warba.abcstore.entity;

import java.io.Serializable;
import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;

@Entity
@ApiModel(description = "All Discounts on the ABCStore")
@Table(name = "customer_category_discount")
@AssociationOverrides({
@AssociationOverride(name = "pk.customerType", joinColumns = @JoinColumn(name = "customer_type_id")),
@AssociationOverride(name = "pk.category", joinColumns = @JoinColumn(name = "category_id")) })
public class CustomerCategoryDiscount implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4134392869564171871L;

	@JsonIgnore
	@EmbeddedId
	private CustomerCategoryId pk = new CustomerCategoryId();
	
	@Column(name = "discount", nullable = false, length = 10)
	private int discount;
	
	
	@Transient
	public CustomerType getCustomerType() {
		return getPk().getCustomerType();
	}

	public void setCustomerType(CustomerType customerType) {
		getPk().setCustomerType(customerType);;
	}

	@Transient
	public Category getCategory() {
		return getPk().getCategory();
	}
	
	public void setCategory(Category category) {
		getPk().setCategory(category);
	}
	
	
	public CustomerCategoryId getPk() {
		return pk;
	}

	public void setPk(CustomerCategoryId pk) {
		this.pk = pk;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		CustomerCategoryDiscount that = (CustomerCategoryDiscount) o;

		if (getPk() != null ? !getPk().equals(that.getPk())
				: that.getPk() != null)
			return false;

		return true;
	}

	public int hashCode() {
		return (getPk() != null ? getPk().hashCode() : 0);
	}

}
