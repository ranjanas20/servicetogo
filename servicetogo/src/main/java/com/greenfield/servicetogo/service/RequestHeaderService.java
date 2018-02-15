package com.greenfield.servicetogo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greenfield.servicetogo.dto.RequestHeaderDTO;
import com.greenfield.servicetogo.entity.RequestHeaderEntity;
import com.greenfield.servicetogo.repository.RequestHeaderRepository;

@Service
public class RequestHeaderService {

	@Autowired
	RequestHeaderRepository repo;

	public List<RequestHeaderDTO> findAllRequest() {
		List<RequestHeaderEntity> rhList = repo.findAll();
		return setToDTO(rhList);
	}

	public RequestHeaderDTO findRequestById(Integer id) {
		Optional<RequestHeaderEntity> rhEntity = repo.findById(id);
		RequestHeaderDTO rhDTO= new RequestHeaderDTO();
		if(rhEntity.isPresent()){
			rhDTO = setToDTO(rhEntity.get());
		}
		return rhDTO;
	}

	public RequestHeaderDTO addRequest(RequestHeaderEntity servRequest) {
		RequestHeaderEntity rhEntity = repo.saveAndFlush(servRequest);
		RequestHeaderDTO rhDTO = setToDTO(rhEntity);
		return rhDTO;
	}

	public RequestHeaderDTO updateRequest(RequestHeaderEntity servRequest) {
		RequestHeaderEntity rhEntity = repo.saveAndFlush(servRequest);
		RequestHeaderDTO rhDTO = setToDTO(rhEntity);
		return rhDTO;
	}

	public void deleteRequestById(Integer id) {
		repo.deleteById(id);
	}
	
	public void setRepo(RequestHeaderRepository repo) {
		this.repo = repo;
	}
	
	private RequestHeaderDTO setToDTO(RequestHeaderEntity rhEntity){
		RequestHeaderDTO rhDTO = new RequestHeaderDTO();
		
		rhDTO.setReqId(rhEntity.getReqId());
		rhDTO.setFirstName(rhEntity.getFirstName());
		rhDTO.setLastName(rhEntity.getLastName());
		rhDTO.setPhone(rhEntity.getPhone());
		rhDTO.setServiceType(rhEntity.getServiceType());
		rhDTO.setStatus(rhEntity.getStatus());
		rhDTO.setAddress(rhEntity.getAddress());
		rhDTO.setEmail(rhEntity.getEmail());
		rhDTO.setPriority(rhEntity.getPriority());
		rhDTO.setSymptoms(rhEntity.getSymptoms());
		rhDTO.setAssigedToEmpId(rhEntity.getAssigedToEmpId());
		rhDTO.setCompletionDatetime(rhEntity.getCompletionDatetime());
		rhDTO.setComments(rhEntity.getComments());
		rhDTO.setPreferredContactMethod(rhEntity.getPreferredContactMethod());
		rhDTO.setVendorId(rhEntity.getVendorId());
		rhDTO.setRequestDatetime(rhEntity.getRequestDatetime());
		rhDTO.setCustomerId(rhEntity.getCustomerId());
		rhDTO.setVsdEntity(rhEntity.getVsdEntity());
		return rhDTO;
	}
	
	private List<RequestHeaderDTO> setToDTO(List<RequestHeaderEntity> rhEntityList){
		
		 List<RequestHeaderDTO> rhDTOList =  new ArrayList<RequestHeaderDTO>(); //Collections.<RequestHeaderDTO>emptyList();
		
		for (RequestHeaderEntity entry : rhEntityList) {
			RequestHeaderDTO rhDTO = new RequestHeaderDTO();
			rhDTO = setToDTO(entry);
			rhDTOList.add(rhDTO);
		}
		return rhDTOList;
	}
}