package com.greenfield.servicetogo.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;
import com.greenfield.servicetogo.dto.RequestHeaderDTO;
import com.greenfield.servicetogo.dto.SearchDTO;
import com.greenfield.servicetogo.dto.VehicleDetailsDTO;
import com.greenfield.servicetogo.entity.RequestHeaderEntity;
import com.greenfield.servicetogo.entity.VehicleDetailsEntity;
import com.greenfield.servicetogo.repository.RequestHeaderRepository;
import com.greenfield.servicetogo.repository.SearchRepository;
import com.greenfield.servicetogo.repository.VehicleDetailsRepository;



/**
 * Test Order Service, runs the test in Spring container
 * */

@RunWith(SpringRunner.class)
@SpringBootTest 
@Transactional
public class SearchServiceIntegrationTests {
	@Autowired
	private SearchService service;
	@Autowired
    private SearchRepository repo;
	
	private String firstName="sanjay";
	private String serviceType="auto";
	
	 
	@Autowired
	private RequestHeaderService service1;
	@Autowired
	private RequestHeaderRepository repo1;
	
	@Autowired
	private VehicleDetailsService service2;
	@Autowired
	private VehicleDetailsRepository repo2;
	
	@Before
	public void setup(){
		
		VehicleDetailsEntity vsdEntity = new VehicleDetailsEntity("HynDai","1998","KLP-1234");
		RequestHeaderEntity rhEntity = new RequestHeaderEntity(serviceType,firstName,new Date());
		vsdEntity.setRequestHeader(rhEntity);
		VehicleDetailsDTO vdDTO = service2.addVehicleDetails(vsdEntity);
		//System.out.println(vdDTO.getVin());
	}
	
	@Test
	public void testFindAllByName() {
		String param = "sanjay";
		
		List<SearchDTO> listrhEntity = service.findByFirstName(param);
		for(SearchDTO entry:listrhEntity){
			System.out.println(entry.getFirstName());
			System.out.println(entry.getServiceType());
			System.out.println(entry.getVin());
			System.out.println(entry.getReqId());
		}
		
//		assertTrue(listrhEntity.size()==1);
//		assertTrue(listrhEntity.get(0).getFirstName().equals(name));
//		assertTrue(listrhEntity.get(0).getServiceType().equals(serviceType));
		//assertTrue(listrhEntity.get(0).getVsdEntity().getVehicleModel().equals("HynDai"));
	}
	
	@Test
	public void testFindAllByAttribute() {
		SearchDTO searchDTO = new SearchDTO(serviceType,firstName, 
				new Date(),"HynDai","1998","KLP-1234");
		
		service.setRepo(repo);
		List<SearchDTO> listrhEntity = service.findByAttributes(searchDTO);
		for(SearchDTO entry:listrhEntity){
			System.out.println(entry.getFirstName());
			System.out.println(entry.getServiceType());
			System.out.println(entry.getVin());
			System.out.println(entry.getReqId());
		}
		
//		assertTrue(listrhEntity.size()==1);
//		assertTrue(listrhEntity.get(0).getFirstName().equals(name));
//		assertTrue(listrhEntity.get(0).getServiceType().equals(serviceType));
		//assertTrue(listrhEntity.get(0).getVsdEntity().getVehicleModel().equals("HynDai"));
	}
	
	/*	
	@Test
	public void testAddReq() {
		RequestHeaderDTO rhEntity1 = service.addRequest(rhEntity);
		assertTrue(rhEntity1.getFirstName().equals(name));
		assertTrue(rhEntity1.getServiceType().equals(serviceType));
		//assertTrue(rhEntity1.getVsdEntity().getVehicleModel().equals("HynDai"));
		//assertTrue(rhEntity1.getVsdEntity().getVIN().equals("KLP-1234"));
	}

	@Test
	public void testSetToDTO_Entity() {
		//RequestHeaderDTO rhEntity1 = service.addRequest(rhEntity);
		rhEntity.setLastName("Singh");
		rhEntity.setPhone("4256549776");
		rhEntity.setStatus("WorkInProgress");
		rhEntity.setAddress("1601 Ridge View NE");
		rhEntity.setEmail("sanjays30@gmail.com");
		rhEntity.setPriority("1");
		rhEntity.setSymptoms("issue with brake");
		//rhEntity.setAssigedToEmpId(rhEntity.getAssigedToEmpId());
		//rhEntity.setCompletionDatetime(rhEntity.getCompletionDatetime());
		rhEntity.setComments("there are few additional issues");
		rhEntity.setPreferredContactMethod("phone");
		//rhEntity.setVendorId(rhEntity.getVendorId());
		//rhEntity.setCustomerId(rhEntity.getCustomerId());
		
		RequestHeaderDTO rhEntity1 = ReflectionTestUtils.invokeMethod(service, "setToDTO", rhEntity);
		//System.out.println(ReflectionTestUtils.getField(rhEntity1, "firstName"));
		assertTrue(rhEntity1.getFirstName().equals(name));
		assertTrue(rhEntity1.getServiceType().equals(serviceType));
		//assertTrue(rhEntity1.getVsdEntity().getVehicleModel().equals("HynDai"));
		//assertTrue(rhEntity1.getVsdEntity().getVIN().equals("KLP-1234"));
	}
	
	@Test
	public void testSetToDTO_ListOfEntity() {
		List<RequestHeaderEntity> listrhEntity = repo.findAll();
		List<RequestHeaderDTO> listrhDTO = ReflectionTestUtils.invokeMethod(service, "setToDTO", listrhEntity);
		System.out.println(listrhDTO.size());
		assertTrue(listrhDTO.size()==1);
		assertTrue(listrhDTO.get(0).getFirstName().equals(name));
		assertTrue(listrhDTO.get(0).getServiceType().equals(serviceType));
		//assertTrue(listrhDTO.get(0).getVsdEntity().getVehicleModel().equals("HynDai"));
	}
*/	
}
