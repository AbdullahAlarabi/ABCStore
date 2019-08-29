package com.warba.abcstore.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class CustomerCategoryId implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1174950927410991183L;

	@ManyToOne
	private CustomerType customerType;
	
	@ManyToOne
	private Category category; 
	
	
	public CustomerType getCustomerType() {
		return customerType;
	}

	public void setCustomerType(CustomerType customerType) {
		this.customerType = customerType;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerCategoryId that = (CustomerCategoryId) o;

        if (customerType != null ? !customerType.equals(that.customerType) : that.customerType != null) return false;
        if (category != null ? !category.equals(that.category) : that.category != null)
            return false;

        return true;
    }

    public int hashCode() {
        int result;
        result = (customerType != null ? customerType.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        return result;
    }

}
