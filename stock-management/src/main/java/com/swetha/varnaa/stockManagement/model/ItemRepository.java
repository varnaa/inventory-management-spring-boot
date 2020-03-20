package com.swetha.varnaa.stockManagement.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface ItemRepository extends JpaRepository <Item,Integer>  {

	Item findByItemname(String name);
	
	@Query(value="select * from items i where i.item_id = ?1",nativeQuery=true)
	Item findByItemID(int id);

	
	
}
