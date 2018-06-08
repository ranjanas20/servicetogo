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
import com.greenfield.servicetogo.entity.RequestHeaderEntity;
import com.greenfield.servicetogo.repository.RequestHeaderRepository;



/**
 * Test Order Service, runs the test in Spring container
 * */

//@RunWith(SpringRunner.class)
//@ContextConfiguration("ServicetogoApplication.class") 
//@Transactional
public class RequestHeaderServiceUnitTests {

	private RequestHeaderService service;
	
    private RequestHeaderRepository repo = mock(RequestHeaderRepository.class);
	
	private String name="sanjay";
	private String serviceType="auto";
	private RequestHeaderEntity rhEntity=null; 
	private RequestHeaderDTO rhDTO=null;
	
	@Before
	public void setup(){
		service = new RequestHeaderService();
		service.setRepo(repo);
		
		//VehicleDetailsEntity vsdEntity = new VehicleDetailsEntity("HynDai","1998","KLP-1234");
		//VehicleServiceDetailsEntity vsdEntity1 = new VehicleServiceDetailsEntity("Honda","2008","MNL-4567");
		//rhEntity = new RequestHeaderEntity(serviceType,name,new Date(),Arrays.asList(vsdEntity,vsdEntity1));
		rhEntity = new RequestHeaderEntity(serviceType,name,new Date());
		rhEntity.setReqId(100);
		rhDTO = new RequestHeaderDTO(serviceType,name,new Date());
		rhDTO.setReqId(100);
		
		Mockito.when(repo.findAll())
	      .thenReturn(Arrays.asList(rhEntity));
		
		Mockito.when(repo.saveAndFlush(rhEntity))
	      .thenReturn(rhEntity);
		 
		
	}
	
	@Test
	public void testFindAll() {
		List<RequestHeaderDTO> listrhEntity = service.findAllRequest();
		System.out.println(listrhEntity.size());
		assertTrue(listrhEntity.size()==1);
		assertTrue(listrhEntity.get(0).getFirstName().equals(name));
		assertTrue(listrhEntity.get(0).getServiceType().equals(serviceType));
		//assertTrue(listrhEntity.get(0).getVsdEntity().getVehicleModel().equals("HynDai"));
	}
	
	@Test
	public void testAddReq() {
		RequestHeaderDTO rhEntity1 = service.addRequest(rhDTO);
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
	
}
