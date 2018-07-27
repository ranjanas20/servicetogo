package com.greenfield.servicetogo.car.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greenfield.servicetogo.car.dto.CustomerProfileDTO;
import com.greenfield.servicetogo.car.entity.CustomerEntity;
import com.greenfield.servicetogo.car.repository.CustomerRepository;

@Service
public class CustomerService {
    
    @Autowired
    private CustomerRepository customerRepository;
    
    @Transactional
    public CustomerProfileDTO saveProfile(CustomerProfileDTO dto){
        CustomerEntity entity = customerRepository.getOne(dto.getCustomerId());
        CustomerEntity savedEntity = UserDTOtoEntityMap.updateCustomerEntity(entity, dto);
        return UserDTOtoEntityMap.toCustomerProfileDTO(savedEntity);
    }

    public CustomerProfileDTO getProfile(Long customerId) {
        CustomerEntity entity = customerRepository.getOne(customerId);
        return UserDTOtoEntityMap.toCustomerProfileDTO(entity);
    }
    public CustomerProfileDTO getProfileByLoginId(String loginId) {
        CustomerEntity entity = customerRepository.findByLoginId(loginId);
        return UserDTOtoEntityMap.toCustomerProfileDTO(entity);
    }
}
