package com.labregister.controller;

import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.labregister.model.dto.ItemCreatedResponse;
import com.labregister.model.dto.ItemDTO;
import com.labregister.service.ItemService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/item")
public class ItemController {

	@Autowired
	ItemService itemService;

	@PostMapping("/add")
	public ResponseEntity<ItemCreatedResponse> add(@Valid @RequestBody ItemDTO item) {

		log.info("Category Added");
		return itemService.saveItem(item);

	}
	
	@PutMapping("/update")
	public ResponseEntity<Void> update(@Valid @RequestBody ItemDTO item)  {

		log.info("ItemDTO Updated");
		return itemService.updateItem(item);

	}
	@GetMapping("/get")
	public ResponseEntity<List<ItemDTO>> getItemsByCategory(@PathParam(value = "categoryId") String categoryId){

		log.info("Get Items by category >>",categoryId);
	
		return itemService.getItemsByCategoryId(categoryId);

	}
}
