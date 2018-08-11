package com.greenfield.servicetogo.car.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greenfield.servicetogo.car.dto.ZipLookupDTO;
import com.greenfield.servicetogo.car.entity.ZipLookupEntity;
import com.greenfield.servicetogo.car.repository.ZipLookupRepository;

@Service
public class ZipLookupService {
    
   @Autowired
   private ZipLookupRepository zipLookupRepository;
    
   public ZipLookupDTO findCityStateById(String zipCode) {
	   System.out.println(zipCode);
	   ZipLookupEntity entity = zipLookupRepository.getOne(zipCode);
       return UserDTOtoEntityMap.toZipLookupDTO(entity);
    }
 
}
