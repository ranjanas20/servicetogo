package com.greenfield.servicetogo.controller;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.greenfield.servicetogo.ServicetogoApplication;
import com.greenfield.servicetogo.dto.RequestHeaderDTO;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServicetogoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RequestHeaderRestControllerIntegrationTest {
    @LocalServerPort
    private int port;

    TestRestTemplate restTemplate = new TestRestTemplate();

    HttpHeaders headers = new HttpHeaders();

    private String name = "sanjay";
    private String name2 = "Arnav";
    private String serviceType = "auto";
    private String email = "sanjays30@gmail.com";

    @Test
    public void testRetrieveAllRequests() {

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/requestHeaders"), HttpMethod.GET,
                entity, String.class);

        String expected = "{id:Course1,name:Spring,description:10 Steps}";

        // JSONAssert.assertEquals(expected, response.getBody(), false);
    }

    @Test
    public void addRequest() {

        RequestHeaderDTO rhDTO = new RequestHeaderDTO(serviceType, name, new Date());

        HttpEntity<RequestHeaderDTO> entity = new HttpEntity<RequestHeaderDTO>(rhDTO, headers);

        ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/requestHeaders"), HttpMethod.POST,
                entity, String.class);

        String actual = response.getBody();
        HttpStatus status = response.getStatusCode();
        if (HttpStatus.OK != status && HttpStatus.CREATED != status) {
            System.out.println("status " + status);
        }
        System.out.println("actual " + actual);

        assertTrue(HttpStatus.OK == status || HttpStatus.CREATED == status);

    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }

}
