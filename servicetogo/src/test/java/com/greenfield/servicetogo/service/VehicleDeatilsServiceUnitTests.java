package com.greenfield.servicetogo.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import com.greenfield.servicetogo.dto.VehicleDetailsDTO;
import com.greenfield.servicetogo.entity.RequestHeaderEntity;
import com.greenfield.servicetogo.entity.VehicleDetailsEntity;
import com.greenfield.servicetogo.repository.VehicleDetailsRepository;



/**
 * Test Order Service, runs the test in Spring container
 * */

//@RunWith(SpringRunner.class)
//@ContextConfiguration("ServicetogoApplication.class") 
//@Transactional
public class VehicleDeatilsServiceUnitTests {

	private VehicleDetailsService service;
	
    private VehicleDetailsRepository repo = mock(VehicleDetailsRepository.class);
	
	private String model="HynDai";
	private String year="1998";
	private String vin="KLP-1234";
	private VehicleDetailsEntity vsdEntity=null; 
	
	private String name="sanjay";
	private String serviceType="auto";
	private RequestHeaderEntity rhEntity=null; 
	
	@Before
	public void setup(){
		service = new VehicleDetailsService();
		service.setRepo(repo);
		
		vsdEntity = new VehicleDetailsEntity(model,year,vin);
		rhEntity = new RequestHeaderEntity(serviceType,name,new Date());
		vsdEntity.setRequestHeader(rhEntity);
		
		
		Mockito.when(repo.findAll())
	      .thenReturn(Arrays.asList(vsdEntity));
		
		Mockito.when(repo.saveAndFlush(vsdEntity))
	      .thenReturn(vsdEntity);
		 
		
	}
	
	@Test
	public void testFindAll() {
		List<VehicleDetailsDTO> listVehicles = service.findAllVehicleDeatils();
		assertTrue(listVehicles.size()==1);
		assertTrue(listVehicles.get(0).getVehicleModel().equals(model));
		assertTrue(listVehicles.get(0).getVehicleYear().equals(year));
		assertTrue(listVehicles.get(0).getVin().equals(vin));
	}
	
	@Test
	public void testAddDetails() {
		VehicleDetailsDTO vdEntity1 = service.addVehicleDetails(vsdEntity);
		assertTrue(vdEntity1.getVehicleModel().equals(model));
		assertTrue(vdEntity1.getVehicleYear().equals(year));
		assertTrue(vdEntity1.getVin().equals(vin));
	}


}
