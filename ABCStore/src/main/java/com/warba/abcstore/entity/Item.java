package com.warba.abcstore.entity;

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
@Table(name = "item")
@ApiModel(description = "All items on the ABCStore")
public class Item {

	public Item() {
	
	}
	
	public Item(String name, double price) {
		this.itemName = name;
		this.price = price;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(notes = "The database auto increment item ID")
	@Column(name = "item_id")
	private long id;

	@Column(name = "item_name")
	@ApiModelProperty(notes = "The database item name")
	private String itemName;

	@Column(name = "price")
	@ApiModelProperty(notes = "The database item price")
	private double price;

    @ManyToOne
	@JoinColumn(name = "category_id")
	@ApiModelProperty(notes = "The database item category FK from table Category")
	private Category category;
	


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}



//	@Override
//	public String toString() {
//		return "Item [id=" + id + ", itemName=" + itemName + ", price=" + price + ", categoryId=" + categoryId
//				+ "]";
//	}

}
