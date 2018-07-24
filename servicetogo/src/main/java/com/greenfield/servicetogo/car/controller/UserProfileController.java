package com.greenfield.servicetogo.car.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.greenfield.servicetogo.car.dto.UserCredentialDTO;
import com.greenfield.servicetogo.car.service.UserProfileService;

@RestController
public class UserProfileController {
    
    @Autowired
    private UserProfileService userService;
    
    @PostMapping(value = "/signup")
    public ResponseDTO<String> customerSignup(@RequestBody UserCredentialDTO userCredential){
        userService.customerSignup(userCredential);
        ResponseDTO<String> dto = new ResponseDTO<>();
        dto.setSuccess(Boolean.TRUE);
        dto.setRespCode("OK");
        dto.setRespMessage("Signup successfull");
        dto.setData("");
        return dto;
    }
    @PostMapping(value = "/applogin")
    public ResponseDTO<String> applogin(UserCredentialDTO credential){
        ResponseDTO<String> dto = new ResponseDTO<>();
        dto.setSuccess(Boolean.TRUE);
        dto.setRespCode("OK");
        dto.setRespMessage("Signup successfull");
        dto.setData("");
        return dto;
    }
    
}
