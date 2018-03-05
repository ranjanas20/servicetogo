package com.greenfield.servicetogo.controller;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.greenfield.servicetogo.ServicetogoApplication;
import com.greenfield.servicetogo.dto.RequestHeaderDTO;
import com.greenfield.servicetogo.entity.RequestHeaderEntity;
import com.greenfield.servicetogo.service.RequestHeaderService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServicetogoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RequestHeaderRestControllerIntegrationTest {
		@LocalServerPort
		private int port;

		TestRestTemplate restTemplate = new TestRestTemplate();

		HttpHeaders headers = new HttpHeaders();
		
		private String name="sanjay";
		private String name2="Arnav";
		private String serviceType="auto";
		private String email="sanjays30@gmail.com";

		@Test
		public void testRetrieveAllRequests() {

			HttpEntity<String> entity = new HttpEntity<String>(null, headers);

			ResponseEntity<String> response = restTemplate.exchange(
					createURLWithPort("/requestHeaders"),
					HttpMethod.GET, entity, String.class);

			String expected = "{id:Course1,name:Spring,description:10 Steps}";

			//JSONAssert.assertEquals(expected, response.getBody(), false);
		}

		@Test
		public void addRequest() {
			
			
			RequestHeaderDTO rhDTO = new RequestHeaderDTO(serviceType, name, new Date());

			HttpEntity<RequestHeaderDTO> entity = new HttpEntity<RequestHeaderDTO>(rhDTO, headers);

			ResponseEntity<String> response = restTemplate.exchange(
					createURLWithPort("/requestHeaders"),
					HttpMethod.POST, entity, String.class);

			String actual = response.getBody();
			System.out.println("actual "+ actual);
			//assertTrue(actual.contains("/students/Student1/courses/"));

		}

		private String createURLWithPort(String uri) {
			return "http://localhost:" + port + uri;
		}

	
}
