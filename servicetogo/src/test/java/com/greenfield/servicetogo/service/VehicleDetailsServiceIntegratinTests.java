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
import com.greenfield.servicetogo.dto.VehicleDetailsDTO;
import com.greenfield.servicetogo.entity.RequestHeaderEntity;
import com.greenfield.servicetogo.entity.VehicleDetailsEntity;
import com.greenfield.servicetogo.repository.VehicleDetailsRepository;



/**
 * Test Order Service, runs the test in Spring container
 * */

@RunWith(SpringRunner.class)
@SpringBootTest 
@Transactional
public class VehicleDetailsServiceIntegratinTests {

	@Autowired
	VehicleDetailsService rhService;
	
	@Autowired
	VehicleDetailsRepository repo;
		
	private String model="HynDai";
	private String year="1998";
	private String vin="KLP-1234";
	
	private String model1="Honda";
	private String year1="2001";
	private String vin1="XZB-1234";
	
	private String make="Honda";
	private String location="Issaquah";
	
	private String name="sanjay";
	private String serviceType="auto";
	
	@Before
	public void setUp() throws Exception {
		
		VehicleDetailsEntity vsdEntity = new VehicleDetailsEntity(model,year,vin);
		RequestHeaderEntity rhEntity = new RequestHeaderEntity(serviceType,name,new Date());
		vsdEntity.setRequestHeader(rhEntity);
		
		rhService.addVehicleDetails(vsdEntity);
	}

	@After
	public void tearDown() throws Exception {
	}

	
	
	@Test
	public void testListRequests() {
		List<VehicleDetailsDTO> listVehicles = rhService.findAllVehicleDeatils();
		assertTrue(listVehicles.size()==1);
		assertTrue(listVehicles.get(0).getVehicleModel().equals(model));
		assertTrue(listVehicles.get(0).getVehicleYear().equals(year));
		assertTrue(listVehicles.get(0).getVin().equals(vin));
	}
	
	@Test
	public void testAddRequest_WithSameParent() {
		
		
		VehicleDetailsEntity vsdEntity = new VehicleDetailsEntity(model1,year1,vin1);
		RequestHeaderEntity rhEntity = new RequestHeaderEntity(serviceType,name,new Date());
		vsdEntity.setRequestHeader(rhEntity);
		
		VehicleDetailsDTO vdDTO = rhService.addVehicleDetails(vsdEntity);
			
		assertTrue(vdDTO.getVehicleModel().equals(model1));
		assertTrue(vdDTO.getVehicleYear().equals(year1));
		assertTrue(vdDTO.getVin().equals(vin1));
	}
	
	@Test
	public void testAddRequest_WithDiffParent() {
		
		
		VehicleDetailsEntity vsdEntity = new VehicleDetailsEntity(model1,year1,vin1);
		RequestHeaderEntity rhEntity = new RequestHeaderEntity("Home","Ranjana",new Date());
		vsdEntity.setRequestHeader(rhEntity);
		
		VehicleDetailsDTO vdDTO = rhService.addVehicleDetails(vsdEntity);
			
		assertTrue(vdDTO.getVehicleModel().equals(model1));
		assertTrue(vdDTO.getVehicleYear().equals(year1));
		assertTrue(vdDTO.getVin().equals(vin1));
	}
	
	@Test
	public void testUpdateRequest() {
		List<VehicleDetailsEntity> listVehicles;
		listVehicles = repo.findAll();
		VehicleDetailsEntity vdEntity = listVehicles.get(0);
		
		assertTrue(vdEntity.getVehicleModel().equals(model));
		assertTrue(vdEntity.getVehicleYear().equals(year));
		assertTrue(vdEntity.getVin().equals(vin));
		
		vdEntity.setVehicleMake(make);
		vdEntity.setVehicleLocation(location);
		vdEntity.setVehicleModel(model1);
		VehicleDetailsDTO entityUpdated = rhService.updateVehicleDeatils(vdEntity);
		
		assertTrue(entityUpdated.getVehicleModel().equals(model1));
		assertTrue(entityUpdated.getVehicleMake().equals(make));
		assertTrue(entityUpdated.getVehicleLocation().equals(location));
		assertTrue(entityUpdated.getVin().equals(vin));
	}
	
	@Test
	public void testDeleteRequest() {
		List<VehicleDetailsDTO> listVehicles;
		listVehicles = rhService.findAllVehicleDeatils();
		
		VehicleDetailsDTO rhEntity = listVehicles.get(0);
		rhService.deleteVehicleDeatilsById(rhEntity.getId());
		
		listVehicles = rhService.findAllVehicleDeatils();
		assertTrue(listVehicles.size()==0);
	}

}
