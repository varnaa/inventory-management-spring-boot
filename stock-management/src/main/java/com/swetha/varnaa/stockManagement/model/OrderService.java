package com.swetha.varnaa.stockManagement.model;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	public void saveOrder(Order order) {
		repository.save(order);
	}
	
	
	public Optional<Order> getByID(int orderID) {
		return repository.findById(orderID);
	}
	
	public List<Order> findAll(){
		return repository.findAll();
	}
	
	
	public Order findByitemid(int id) {
		return repository.findByItemId(id);
	}
	

}
