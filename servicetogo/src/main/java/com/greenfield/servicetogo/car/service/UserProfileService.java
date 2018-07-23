package com.greenfield.servicetogo.car.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greenfield.servicetogo.car.dto.UserCredentialDTO;
import com.greenfield.servicetogo.car.entity.CustomerEntity;
import com.greenfield.servicetogo.car.entity.UserCredentialEntity;
import com.greenfield.servicetogo.car.repository.CustomerRepository;
import com.greenfield.servicetogo.car.repository.UserCredentialRepository;

@Service
public class UserProfileService {
    @Autowired
    private UserCredentialRepository credentialRepository;
    @Autowired
    private CustomerRepository customerRepository;
    
    @Transactional
    public void customerSignup(UserCredentialDTO userCredential) {
        UserCredentialEntity userentity = UserDTOtoEntityMap.toNewUserCredentialEntity(userCredential);
        credentialRepository.save(userentity);
        CustomerEntity customerEntity = UserDTOtoEntityMap.toNewCustomerEntity(userCredential);
        customerRepository.save(customerEntity);
    }

}
