package com.labregister.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ItemCreatedResponse {

	private String message;
	private Long itemId;
}
