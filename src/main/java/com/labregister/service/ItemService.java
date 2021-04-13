package com.labregister.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.labregister.exception.CategoryNotFoundException;
import com.labregister.exception.ItemNotFoundException;
import com.labregister.model.dao.Category;
import com.labregister.model.dao.Item;
import com.labregister.model.dto.CategoryDTO;
import com.labregister.model.dto.ItemCreatedResponse;
import com.labregister.model.dto.ItemDTO;
import com.labregister.repository.CategoryRepository;
import com.labregister.repository.ItemRepository;
import com.labregister.validator.RequestValidator;
import com.labregister.validator.ResponseValidator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ItemService {

	@Autowired
	ItemRepository itemRepository;

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	RequestValidator requestValidator;

	@Autowired
	ResponseValidator responseValidator;

	public ResponseEntity<ItemCreatedResponse> saveItem(ItemDTO item) {

		Item itemDao = Item.builder().build();
		Optional<Category> categoryDao = null;

		if (requestValidator.validate(item)) {
			categoryDao = categoryRepository.findById(item.getCategory().getId());
		}
		itemDao.setCategory(categoryDao.get());
		BeanUtils.copyProperties(item, itemDao);
		Item savedItem = itemRepository.save(itemDao);

		ItemCreatedResponse itemCreatedResponse = responseValidator.validateAndCreateItemCreateResponse(savedItem);

		return new ResponseEntity<ItemCreatedResponse>(itemCreatedResponse, HttpStatus.CREATED);
	}

	public ResponseEntity<Void> updateItem(ItemDTO item) {

		if (requestValidator.validateItem(Optional.ofNullable(item.getId()))
				&& requestValidator.validateCategory(Optional.ofNullable(item.getCategory().getId()))) {
			
			Optional<Item> itemOptional = itemRepository.findById(item.getId());
			Optional<Category> categoryOptional = categoryRepository.findById(item.getCategory().getId());
			Item daoItem = null;

			if (itemOptional.isPresent() && categoryOptional.isPresent()) {
				daoItem = itemOptional.get();
				daoItem.setCategory(categoryOptional.get());
				BeanUtils.copyProperties(item, daoItem);
				if (Optional.ofNullable(itemRepository.save(daoItem)).isPresent()) {

					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}
			}else if (!itemOptional.isPresent()) {
				throw new ItemNotFoundException("Not Found",404,"Incorrect Item ID","Item Not Found",null);
				
			}else if (!categoryOptional.isPresent()) {
				throw new CategoryNotFoundException("Not Found",404,"Incorrect Category ID","Category Not Found",null);
			}
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

	}

	public ResponseEntity<List<ItemDTO>> getItemsByCategoryId(String categoryId) {
		List<Item> itemLs = itemRepository.findByCategoryId(Long.valueOf(categoryId));

		List<ItemDTO> itemDTOLs = itemLs.stream()
				.map(item -> ItemDTO.builder().category(mapToCategoryDTO(item.getCategory())).brand(item.getBrand())
						.initialQuantity(item.getInitialQuantity()).name(item.getName()).build())
				.collect(Collectors.toList());
		log.info("Item List size is >> {}", itemLs.size());
		return new ResponseEntity<List<ItemDTO>>(itemDTOLs, HttpStatus.OK);
	}

	private CategoryDTO mapToCategoryDTO(Category daoCategory) {
		CategoryDTO categoryDTO = CategoryDTO.builder().build();
		BeanUtils.copyProperties(daoCategory, categoryDTO);

		return categoryDTO;
	}

}
