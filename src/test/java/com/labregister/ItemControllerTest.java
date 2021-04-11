package com.labregister;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

public class ItemControllerTest  {

	@Autowired
	private TestRestTemplate restTemplate;
	@LocalServerPort
	private int port;
	
	private  URI uri =null;
	
//	@Before
//	public void setUp() {
//		String url = "http://localhost:" + this.port;
//         uri = UriComponentsBuilder.fromHttpUrl(url).path("/item").path("/get")
//                .queryParam("categoryId", "1").build().toUri();
//	}
//
//	public void testGetItemsByCategory() {
//		 
//	        this.restTemplate.exchange(uri, HttpMethod.GET, new HttpEntity<T>(null), null)
//                    
//	}
}
