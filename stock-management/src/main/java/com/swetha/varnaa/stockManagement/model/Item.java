package com.swetha.varnaa.stockManagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="items")
public class Item {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer item_id;

	@Column
	private String itemname;
	
	@Column
	private String item_description;
	
	@Column 
	private int current_stock;
	
	

	public Item(String item_name, String item_description, int current_stock) {
		super();
		this.itemname = item_name;
		this.item_description = item_description;
		this.current_stock = current_stock;
	}
	
	

	public Item() {
	}

	public Integer getItem_id() {
		return item_id;
	}

	public void setItem_id(Integer item_id) {
		this.item_id = item_id;
	}


	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}



	public String getItem_description() {
		return item_description;
	}

	public void setItem_description(String item_description) {
		this.item_description = item_description;
	}

	public int getCurrent_stock() {
		return current_stock;
	}

	public void setCurrent_stock(int current_stock) {
		this.current_stock = current_stock;
	}



	@Override
	public String toString() {
		return "Item [item_id=" + item_id + ", itemname=" + itemname + ", item_description=" + item_description
				+ ", current_stock=" + current_stock + "]";
	}
	
	
}
