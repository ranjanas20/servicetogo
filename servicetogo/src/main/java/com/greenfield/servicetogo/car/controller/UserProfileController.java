package com.greenfield.servicetogo.car.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.greenfield.servicetogo.car.dto.CustomerProfileDTO;
import com.greenfield.servicetogo.car.dto.UserCredentialDTO;
import com.greenfield.servicetogo.car.service.CustomerService;
import com.greenfield.servicetogo.car.service.UserProfileService;

@RestController
public class UserProfileController {
    
    @Autowired
    private UserProfileService userService;
    
    
    @PostMapping(value = "/signup")
    public ResponseDTO<String> customerSignup(@RequestBody UserCredentialDTO userCredential){
        Integer id = userService.customerSignup(userCredential);
        ResponseDTO<String> dto = new ResponseDTO<>();
        dto.setSuccess(Boolean.TRUE);
        dto.setRespCode("OK");
        dto.setRespMessage("Signup successfull");        
        dto.setData(id+" created successfully");
        return dto;
    }
    @PostMapping(value = "/applogin")
    public ResponseDTO<String> applogin(@RequestBody UserCredentialDTO credential){
        boolean success = userService.login(credential.getUserType(), credential.getLoginId(),
                credential.getLoginPassword());
        ResponseDTO<String> dto = new ResponseDTO<>();
        dto.setSuccess(success);
        dto.setRespCode("OK");
        dto.setRespMessage(success?"Signin successfull":"Signin error");
        dto.setData(credential.getLoginId());
        return dto;
    }
    
}
