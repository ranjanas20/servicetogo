package com.greenfield.servicetogo.car.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greenfield.servicetogo.car.dto.CustomerProfileDTO;
import com.greenfield.servicetogo.car.service.CustomerService;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService cpservice;
    
    @GetMapping(value = "/profilebyid")
    public ResponseDTO<CustomerProfileDTO> getCustomerProfile(@RequestParam("loginId") String loginId){
        CustomerProfileDTO c = cpservice.getProfileByLoginId(loginId);
        ResponseDTO<CustomerProfileDTO> dto = new ResponseDTO<>();
        dto.setSuccess(Boolean.TRUE);
        dto.setRespCode("OK");
        dto.setRespMessage("");        
        dto.setData(c);
        return dto;
    }
    
    
    @PutMapping(value = "/saveprofile")
    public ResponseDTO<CustomerProfileDTO> saveProfile(@RequestBody CustomerProfileDTO dto){
        ResponseDTO<CustomerProfileDTO> resp = new ResponseDTO<>();
        resp.setData(cpservice.saveProfile(dto));
        resp.setSuccess(true);
        resp.setRespCode("200");
        resp.setRespMessage("SUCCESS");
        return resp; 
    }
    @GetMapping("/customerprofile/{customerId}")
    public ResponseDTO<CustomerProfileDTO> getProfile(@PathVariable("customerId") Long customerId){
        ResponseDTO<CustomerProfileDTO> resp = new ResponseDTO<>();
        resp.setData(cpservice.getProfile(customerId));
        resp.setSuccess(true);
        resp.setRespCode("200");
        resp.setRespMessage("SUCESS");
        return resp;

    }
}
