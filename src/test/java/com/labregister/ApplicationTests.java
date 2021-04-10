package com.labregister;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.labregister.model.dao.Category;
import com.labregister.model.dao.Item;

@SpringBootTest
class ApplicationTests {
	
	 @MockBean
	 private DataSource dataSource;

	@Test
	void contextLoads() throws JsonProcessingException {
		
		
		ObjectMapper mapper=new ObjectMapper();
		Category catObj=Category.builder().id(1l).name("Petri-dish").attribute1("round").attribute2("glass").build();
		
		Category catObjForItem=Category.builder().id(1l).build();
		
		Item item=Item.builder().category(catObjForItem).brand("XYZ").name("small-petri-dish").initialQuantity(10l).build();
		//System.out.println(mapper.writeValueAsString(catObj));
		
		System.out.println(mapper.writeValueAsString(item));
	}

}
