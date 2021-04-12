package com.labregister;

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

public class CategoryControllerTest extends TestConfig{
	@Autowired
	MockMvc mockMvc;

	@Autowired
	ObjectMapper objectMapper;
	
	@Test
	public void testCreateCategory() throws Exception {
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/category/add").contentType(MediaType.APPLICATION_JSON)
		           .content(mockJsonCategoryDTO()) 
		           .accept(MediaType.APPLICATION_JSON))
		           .andExpect(status().is(201)).andReturn();
	}

	private String mockJsonCategoryDTO() {


		String categoryJson = null;

		try {
			categoryJson = objectMapper.writeValueAsString(CategoryDTO.builder().name("Test-Category").attribute1("Test-attribute1")
					.attribute2("Test-attribute2").attribute3("Test-attribute3").build());
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return categoryJson;
		
		
	}
	
}
