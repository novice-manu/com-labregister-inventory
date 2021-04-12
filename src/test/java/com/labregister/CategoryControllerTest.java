package com.labregister;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CategoryControllerTest extends TestConfig{
	@Autowired
	MockMvc mockMvc;

	@Autowired
	ObjectMapper objectMapper;
}
