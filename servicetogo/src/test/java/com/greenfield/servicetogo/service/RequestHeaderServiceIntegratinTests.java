package com.greenfield.servicetogo.service;

import static org.junit.Assert.*;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.greenfield.servicetogo.dto.RequestHeaderDTO;
import com.greenfield.servicetogo.entity.RequestHeaderEntity;
import com.greenfield.servicetogo.repository.RequestHeaderRepository;



/**
 * Test Order Service, runs the test in Spring container
 * */

@RunWith(SpringRunner.class)
@SpringBootTest 
@Transactional
public class RequestHeaderServiceIntegratinTests {

	@Autowired
	RequestHeaderService rhService;
	
	@Autowired
	RequestHeaderRepository repo;
		
	private String name="sanjay";
	private String name2="Arnav";
	private String serviceType="auto";
	private String email="sanjays30@gmail.com";
	
	@Before
	public void setUp() throws Exception {
		
		//VehicleDetailsEntity vsdEntity = new VehicleDetailsEntity("HynDai","1998","KLP-1234");
		//VehicleServiceDetailsEntity vsdEntity1 = new VehicleServiceDetailsEntity("Honda","2008","MNL-4567");
		//RequestHeaderEntity rhEntity = new RequestHeaderEntity(serviceType, name, new Date(), Arrays.asList(vsdEntity,vsdEntity1));
		RequestHeaderEntity rhEntity = new RequestHeaderEntity(serviceType, name, new Date());
		rhService.addRequest(rhEntity);
	}

	@After
	public void tearDown() throws Exception {
	}

	
	
	@Test
	public void testListRequests() {
		List<RequestHeaderDTO> listOfRequests;
		listOfRequests = rhService.findAllRequest();
		assertTrue(listOfRequests.size()==1);
		assertTrue(listOfRequests.get(0).getFirstName().equals(name));
		assertTrue(listOfRequests.get(0).getServiceType().equals(serviceType));
		//assertTrue(listOfRequests.get(0).getVsdEntity().getVehicleModel().equals("HynDai"));
	}
	
	@Test
	public void testAddRequest() {
		
		
		//VehicleDetailsEntity vsdEntity = new VehicleDetailsEntity("Ford","2018","ABC-1234");
		//VehicleServiceDetailsEntity vsdEntity1 = new VehicleServiceDetailsEntity("Maruti","2008","MNL-9876");
		//VehicleServiceDetailsEntity vsdEntity2 = new VehicleServiceDetailsEntity("Maruti 800","2019","ASD-9876");
		//RequestHeaderEntity rhEntity = new RequestHeaderEntity(serviceType,name2 , new Date(), Arrays.asList(vsdEntity,vsdEntity1,vsdEntity2));
		RequestHeaderEntity rhEntity = new RequestHeaderEntity(serviceType,name2 , new Date());
		RequestHeaderDTO rhe = rhService.addRequest(rhEntity);
			
		assertTrue(rhe.getFirstName().equals(name2));
		assertTrue(rhe.getServiceType().equals(serviceType));
		//assertTrue(rhe.getVsdEntity().getVehicleYear().equals("2018"));
		//assertTrue(rhe.getVsdEntity().getVehicleModel().equals("Ford"));
		//assertTrue(rhe.getVsdEntity().getVIN().equals("ABC-1234"));
	}
	
	@Test
	public void testUpdateRequest() {
		List<RequestHeaderEntity> listOfRequests;
		listOfRequests = repo.findAll();
		RequestHeaderEntity rhEntity = listOfRequests.get(0);
		
		assertTrue(rhEntity.getFirstName().equals(name));
		assertTrue(rhEntity.getServiceType().equals(serviceType));
		//assertTrue(rhEntity.getVsdEntity().getVIN().equals("KLP-1234"));
		
		rhEntity.setEmail(email);
		rhEntity.setFirstName(name2);
		
		RequestHeaderDTO entityUpdated = rhService.updateRequest(rhEntity);
		
		assertTrue(entityUpdated.getEmail().equals(email));
		assertTrue(entityUpdated.getFirstName().equals(name2));
		assertTrue(entityUpdated.getServiceType().equals(serviceType));
		//assertTrue(entityUpdated.getVsdEntity().getVIN().equals("KLP-1234"));
	}
	
	@Test
	public void testDeleteRequest() {
		List<RequestHeaderDTO> listOfRequests;
		listOfRequests = rhService.findAllRequest();
		
		RequestHeaderDTO rhEntity = listOfRequests.get(0);
		rhService.deleteRequestById(rhEntity.getReqId());
		
		listOfRequests = rhService.findAllRequest();
		assertTrue(listOfRequests.size()==0);
	}

}
