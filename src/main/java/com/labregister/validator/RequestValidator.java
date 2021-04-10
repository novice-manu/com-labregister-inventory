package com.labregister.validator;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.labregister.exception.CategoryNotFoundException;
import com.labregister.model.dto.ItemDTO;
import com.labregister.repository.CategoryRepository;

@Component
public class RequestValidator {

	@Autowired
	CategoryRepository categoryRepository;

	public boolean validate(ItemDTO item) {

		if (!Optional.ofNullable(item.getCategory().getId()).isPresent()
				|| !categoryRepository.findById(item.getCategory().getId()).isPresent()) {
			throw new CategoryNotFoundException();

		}
		return true;

	}

}
