package com.greenfield.servicetogo.car.controller;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greenfield.servicetogo.car.dto.RoleDTO;
import com.greenfield.servicetogo.car.dto.UserCredentialDTO;
import com.greenfield.servicetogo.car.entity.RoleEntity;
import com.greenfield.servicetogo.car.service.UserDTOtoEntityMap;
import com.greenfield.servicetogo.car.service.UserProfileService;

@RestController
public class UserProfileController {
    
    @Autowired
    private UserProfileService userService;
    
    
    @PostMapping(value = "/signup")
    public ResponseDTO<String> customerSignup(@RequestBody UserCredentialDTO userCredential){
        Long id = userService.customerSignup(userCredential);
        ResponseDTO<String> dto = new ResponseDTO<>();
        dto.setSuccess(Boolean.TRUE);
        dto.setRespCode("OK");
        dto.setRespMessage("Signup successfull");        
        dto.setData(id+" created successfully");
        return dto;
    }
    
    @GetMapping(value = "/dummylogin")
    public void dummylogin(){
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
    @PostMapping(value = "/credupdate")
    public ResponseDTO<String> credentialUpdate(@RequestBody UserCredentialDTO userCredential){
        Long id = userService.customerSignup(userCredential);
        ResponseDTO<String> dto = new ResponseDTO<>();
        dto.setSuccess(Boolean.TRUE);
        dto.setRespCode("OK");
        dto.setRespMessage("Signup successfull");        
        dto.setData(id+" created successfully");
        return dto;
    }
    @GetMapping(value = "/getroles")
    public ResponseDTO<Set<RoleDTO>> getRoles(@RequestParam("loginId") String loginId){
        Set<RoleEntity>	roleEntity	= userService.getRolesForUser(loginId);
        // Create a HashSet
        Set<RoleDTO> roleDTO = new HashSet<RoleDTO>();
        //iterate entity to convert it to DTO
        Iterator<RoleEntity> it = roleEntity.iterator();
        while(it.hasNext()){
        	RoleDTO roledto = new RoleDTO();
        	roledto = UserDTOtoEntityMap.toRoleDTO(it.next());
        	roleDTO.add(roledto);
        }
     
        ResponseDTO<Set<RoleDTO>> resp = new ResponseDTO<>();
        resp.setData(roleDTO);
        resp.setSuccess(true);
        resp.setRespCode("200");
        resp.setRespMessage("SUCESS");
        return resp;
    }
}
