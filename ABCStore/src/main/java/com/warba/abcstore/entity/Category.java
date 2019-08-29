package com.warba.abcstore.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
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
@Table(name = "category")
@ApiModel(description = "All Categories on the Store")
public class Category implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(notes = "The database auto incerement Category ID")
	@Column(name = "category_id")
	private long id;

	@Column(name = "category")
	@ApiModelProperty(notes = "The database category on ABCstore")
	private String category;
	
	@JsonIgnore
	@OneToMany(mappedBy = "category",cascade=CascadeType.ALL)
	@ApiModelProperty(notes =  "Relation between Category and Item")
	private List<Item> items;	
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.category", cascade=CascadeType.ALL)
	private Set<CustomerCategoryDiscount> customerCategoryDiscounts = new HashSet<CustomerCategoryDiscount>(0);
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public Set<CustomerCategoryDiscount> getCustomerCategoryDiscounts() {
		return customerCategoryDiscounts;
	}

	public void setCustomerCategoryDiscounts(Set<CustomerCategoryDiscount> customerCategoryDiscounts) {
		this.customerCategoryDiscounts = customerCategoryDiscounts;
	}


	@Override
	public String toString() {
		return "Category [id=" + id + ", category=" + category + "]";
	}

}
