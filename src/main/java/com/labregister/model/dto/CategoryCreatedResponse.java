package com.labregister.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryCreatedResponse {
	
	private String message;
	private Long categoryId;
	

}
