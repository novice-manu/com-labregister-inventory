package com.labregister.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.labregister.model.dto.CategoryCreatedResponse;
import com.labregister.model.dto.CategoryDTO;
import com.labregister.service.CategoryService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	@PostMapping("/add")
	public ResponseEntity<CategoryCreatedResponse> add(@Valid @RequestBody CategoryDTO category) {

		log.info("Category Added");

		return categoryService.saveCategory(category);
	}

}
