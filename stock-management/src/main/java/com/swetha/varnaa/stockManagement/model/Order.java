package com.swetha.varnaa.stockManagement.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Order {
	
	@Column
	private int item_id;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int orderID;
	
	@Column
	private int quantity;

	@Column 
	private Date orderCreatedOn;
	
	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getOrderCreatedOn() {
		return orderCreatedOn;
	}

	public void setOrderCreatedOn(Date orderCreatedOn) {
		this.orderCreatedOn = orderCreatedOn;
	}

	public Order(int item_id, int quantity) {
		super();
		this.item_id = item_id;
		this.quantity = quantity;
	}

	public Order() {
	}

	@Override
	public String toString() {
		return "Order [item_id=" + item_id + ", orderID=" + orderID + ", quantity=" + quantity + "]";
	}

	
	
	

}
