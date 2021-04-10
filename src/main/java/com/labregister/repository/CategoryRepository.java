package com.labregister.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.labregister.model.dao.Category;
@Repository
public interface CategoryRepository extends CrudRepository<Category, Long>{

}
