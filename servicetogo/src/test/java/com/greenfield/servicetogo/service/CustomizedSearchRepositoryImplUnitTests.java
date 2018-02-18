package com.greenfield.servicetogo.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;
import com.greenfield.servicetogo.dto.RequestHeaderDTO;
import com.greenfield.servicetogo.dto.SearchDTO;
import com.greenfield.servicetogo.entity.RequestHeaderEntity;
import com.greenfield.servicetogo.repository.CustomizedSearchRepositoryImpl;
import com.greenfield.servicetogo.repository.RequestHeaderRepository;
import com.greenfield.servicetogo.repository.SearchRepository;



/**
 * Test Order Service, runs the test in Spring container
 * */

//@RunWith(SpringRunner.class)
//@ContextConfiguration("ServicetogoApplication.class") 
//@Transactional
public class CustomizedSearchRepositoryImplUnitTests {

	private SearchService service;
	
    private SearchRepository repo = mock(SearchRepository.class);
    
    CustomizedSearchRepositoryImpl customImpl; 
    
	private String firstName="sanjay";
	private String serviceType="auto";
	
	@Before
	public void setup(){
		service = new SearchService();
		service.setRepo(repo);
		
	}
	
		
	@Test
	public void testGetWhereClause() {
		String where1 = " ae.serviceType = 'auto'";
		SearchDTO searchDTO = new SearchDTO(serviceType,firstName, 
				new Date(),"HynDai","1998","KLP-1234");
		customImpl = new CustomizedSearchRepositoryImpl();
		
		String whereClause = ReflectionTestUtils.invokeMethod(customImpl, "getWhereClause", searchDTO);
		System.out.println(where1);
		System.out.println(whereClause);
		assertTrue(whereClause.equals(where1));
	}
	
}
