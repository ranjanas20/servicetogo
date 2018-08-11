package com.greenfield.servicetogo.car.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.greenfield.servicetogo.car.dto.ZipLookupDTO;
import com.greenfield.servicetogo.car.entity.ZipLookupEntity;
import com.greenfield.servicetogo.car.service.ZipLookupService;

@RestController
public class ZipLookupController {
    @Autowired
    private ZipLookupService zipLookupservice;
    
    @GetMapping("/citystate/{zipCode}")
    public ResponseDTO<ZipLookupDTO> getCityState(@PathVariable("zipCode") String zipCode){
    	
    	ZipLookupDTO zlDTO =  zipLookupservice.findCityStateById(zipCode);
    	ResponseDTO<ZipLookupDTO> resp = new ResponseDTO<ZipLookupDTO>();
        resp.setData(zlDTO);
        resp.setSuccess(true);
        resp.setRespCode("200");
        resp.setRespMessage("SUCESS");
        
    	System.out.println(zlDTO.getStateName());
        
        return resp;

    }
}
