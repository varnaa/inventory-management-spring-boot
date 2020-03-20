package com.swetha.varnaa.stockManagement.model;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ItemService {

	@Autowired
	private ItemRepository repository;
	
	public void saveItem(Item item) {
		repository.save(item);
	}
	
	public List<Item> findAll(){
		return repository.findAll();
	}
	
	public Item findOne(int ID) {
		return repository.findByItemID(ID);
	}
	
	public Item findByName(String name){
		return repository.findByItemname(name);
	}
	
	
}
