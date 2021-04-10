package com.labregister.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.labregister.model.dao.Item;
@Repository
public interface ItemRepository extends CrudRepository<Item, Long>{
	
	public List<Item> findByCategoryId(Long categoryId);

}
