package com.labregister;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.labregister.model.dto.CategoryDTO;
import com.labregister.model.dto.ItemDTO;

public class ItemControllerTest extends TestConfig {
	@Autowired
	MockMvc mockMvc;

	@Autowired
	ObjectMapper objectMapper;

	@Test
	public void testGetItemsByCategoryId() throws Exception {
		String expectedCategoryName = "Petri-dish";
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/item/get").queryParam("categoryId", "1")).andExpect(status().is(200))
				.andReturn();
		assertTrue(result.getResponse().getContentAsString().contains(expectedCategoryName));
	}

	@Test
	public void testCreateItemHappyPath() throws Exception {
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/item/add") .contentType(MediaType.APPLICATION_JSON)
		           .content(mockJsonItemDTO()) 
		           .accept(MediaType.APPLICATION_JSON))
		           .andExpect(status().is(201)).andReturn();
	}
	
	@Test
	public void testUpdateItemHappyPath() throws Exception {
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.put("/item/update") .contentType(MediaType.APPLICATION_JSON)
		           .content(mockJsonItemDTOUpdate()) 
		           .accept(MediaType.APPLICATION_JSON))
		           .andExpect(status().is(204)).andReturn();
	}

	private String mockJsonItemDTOUpdate() {

		String itemJson = null;

		try {
			itemJson = objectMapper.writeValueAsString(ItemDTO.builder().id(2l).name("Test-Name").brand("Test-Brand")
					.category(CategoryDTO.builder().id(1l).build()).initialQuantity(5l).build());
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return itemJson;
	}
	private String mockJsonItemDTO() {

		String itemJson = null;

		try {
			itemJson = objectMapper.writeValueAsString(ItemDTO.builder().name("Test-Name").brand("Test-Brand")
					.category(CategoryDTO.builder().id(1l).build()).initialQuantity(5l).build());
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return itemJson;
	}

}
