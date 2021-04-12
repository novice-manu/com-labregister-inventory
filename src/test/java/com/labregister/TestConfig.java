package com.labregister;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = LabRegisterApplication.class)
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class TestConfig {

	@Autowired
	MockMvc mockMvc;

	@Test
	void contextLoads() throws Exception {
		String expected = "200";
		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders.get("/item/get").queryParam("categoryId", "1")
				).andReturn();
		assertEquals(expected, String.valueOf(result.getResponse().getStatus()));
	}

}
