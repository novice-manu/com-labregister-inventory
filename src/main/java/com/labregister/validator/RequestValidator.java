package com.labregister.validator;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.labregister.exception.CategoryNotFoundException;
import com.labregister.exception.ItemNotFoundException;
import com.labregister.model.dao.Category;
import com.labregister.model.dao.Item;
import com.labregister.model.dto.ItemDTO;
import com.labregister.repository.CategoryRepository;

@Component
public class RequestValidator {

	@Autowired
	CategoryRepository categoryRepository;

	public boolean validate(ItemDTO item) {

		if (!Optional.ofNullable(item.getCategory().getId()).isPresent()
				|| !categoryRepository.findById(item.getCategory().getId()).isPresent()) {
			throw new CategoryNotFoundException("Not Found",404,"Incorrect Category ID","Category Not Found",null);

		}
		return true;

	}

	public boolean validateItem(Optional<Long> optional) {
		if (!optional.isPresent()){
			throw new ItemNotFoundException("Not Found",404,"Incorrect Item ID","Item Not Found",null);

		}
		return true;
	}
	
	public boolean validateCategory(Optional<Long> optional) {
		if (!optional.isPresent()){
			throw new CategoryNotFoundException("Not Found",404,"Incorrect Category ID","Category Not Found",null);

		}
		return true;
	}

}
