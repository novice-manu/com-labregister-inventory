package com.labregister.service;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.labregister.model.dao.Category;
import com.labregister.model.dto.CategoryCreatedResponse;
import com.labregister.model.dto.CategoryDTO;
import com.labregister.repository.CategoryRepository;
import com.labregister.validator.ResponseValidator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class CategoryService {

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	ResponseValidator responseValidator;

	public ResponseEntity<CategoryCreatedResponse> saveCategory(CategoryDTO category) {

		Category categoryDao = Category.builder().build();
		BeanUtils.copyProperties(category, categoryDao);

		CategoryCreatedResponse savedCategory = responseValidator
				.validateAndCreateCategoryCreateResponse(categoryRepository.save(categoryDao));
		return new ResponseEntity<CategoryCreatedResponse>(savedCategory, HttpStatus.CREATED);

	}

}
