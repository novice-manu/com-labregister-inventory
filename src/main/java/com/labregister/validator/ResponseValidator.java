package com.labregister.validator;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.labregister.model.dao.Category;
import com.labregister.model.dao.Item;
import com.labregister.model.dto.CategoryCreatedResponse;
import com.labregister.model.dto.ItemCreatedResponse;
import com.labregister.util.ApplicationConstants;

@Component
public class ResponseValidator {

	public CategoryCreatedResponse validateAndCreateCategoryCreateResponse(Category category) {
		if (Optional.ofNullable(category).isPresent()) {
			return CategoryCreatedResponse.builder().categoryId(category.getId())
					.message(ApplicationConstants.CATEGORY_CREATED_MSG).build();
		}
		return null;
	}

	public ItemCreatedResponse validateAndCreateItemCreateResponse(Item savedItem) {


		if (Optional.ofNullable(savedItem).isPresent()) {
			return ItemCreatedResponse.builder().itemId(savedItem.getId())
					.message(ApplicationConstants.ITEM_CREATED_MSG).build();
		}
		
		
		return null;
	}

}
