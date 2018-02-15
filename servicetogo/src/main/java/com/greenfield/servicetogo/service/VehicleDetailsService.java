package com.greenfield.servicetogo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greenfield.servicetogo.dto.RequestHeaderDTO;
import com.greenfield.servicetogo.dto.VehicleDetailsDTO;
import com.greenfield.servicetogo.entity.RequestHeaderEntity;
import com.greenfield.servicetogo.entity.VehicleDetailsEntity;
import com.greenfield.servicetogo.repository.RequestHeaderRepository;
import com.greenfield.servicetogo.repository.VehicleDetailsRepository;

@Service
public class VehicleDetailsService {

	@Autowired
	VehicleDetailsRepository repo;

	public List<VehicleDetailsDTO> findAllVehicleDeatils() {
		List<VehicleDetailsEntity> rhList = repo.findAll();
		return setToDTO(rhList);
	}

	public VehicleDetailsDTO findVehicleDeatilsById(Integer id) {
		Optional<VehicleDetailsEntity> vdEntity = repo.findById(id);
		VehicleDetailsDTO vdDTO= new VehicleDetailsDTO();
		if(vdEntity.isPresent()){
			vdDTO = setToDTO(vdEntity.get());
		}
		return vdDTO;
	}

	public VehicleDetailsDTO addVehicleDetails(VehicleDetailsEntity vsd) {
		VehicleDetailsEntity vdEntity = repo.saveAndFlush(vsd);
		VehicleDetailsDTO vdDTO = setToDTO(vdEntity);
		return vdDTO;
	}

	public VehicleDetailsDTO updateVehicleDeatils(VehicleDetailsEntity vsd) {
		VehicleDetailsEntity vdEntity = repo.saveAndFlush(vsd);
		VehicleDetailsDTO vdDTO = setToDTO(vdEntity);
		return vdDTO;
	}

	public void deleteVehicleDeatilsById(Integer id) {
		repo.deleteById(id);
	}
	
	public void setRepo(VehicleDetailsRepository repo) {
		this.repo = repo;
	}
	
	private VehicleDetailsDTO setToDTO(VehicleDetailsEntity vsdEntity){
		VehicleDetailsDTO vsdDTO = new VehicleDetailsDTO();
		
		vsdDTO.setId(vsdEntity.getId());
		vsdDTO.setReqId(vsdEntity.getRequestHeader().getReqId());
		vsdDTO.setVehicleLocation(vsdEntity.getVehicleLocation());
		vsdDTO.setVehicleMake(vsdEntity.getVehicleMake());
		vsdDTO.setVehicleModel(vsdEntity.getVehicleModel());
		vsdDTO.setVehicleYear(vsdEntity.getVehicleYear());
		vsdDTO.setVendorId(vsdEntity.getVendorId());
		vsdDTO.setVIN(vsdEntity.getVIN());
		return vsdDTO;
	}
	
	private List<VehicleDetailsDTO> setToDTO(List<VehicleDetailsEntity> vsdEntityList){
		
		 List<VehicleDetailsDTO> vsdDTOList =  new ArrayList<VehicleDetailsDTO>(); //Collections.<RequestHeaderDTO>emptyList();
		
		for (VehicleDetailsEntity entry : vsdEntityList) {
			VehicleDetailsDTO vsdDTO = new VehicleDetailsDTO();
			vsdDTO = setToDTO(entry);
			vsdDTOList.add(vsdDTO);
		}
		return vsdDTOList;
	}
}