package com.greenfield.servicetogo.car.service;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.greenfield.servicetogo.car.dto.UserCredentialDTO;
import com.greenfield.servicetogo.car.entity.CustomerEntity;
import com.greenfield.servicetogo.car.entity.RoleEntity;
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
    public Long customerSignup(UserCredentialDTO userCredential) {
        UserCredentialEntity userentity = UserDTOtoEntityMap.toNewUserCredentialEntity(userCredential);
        credentialRepository.save(userentity);
        CustomerEntity customerEntity = UserDTOtoEntityMap.toNewCustomerEntity(userCredential);
        customerRepository.save(customerEntity);
        return userentity.getCredentialId();
    }
    @Transactional
    public Long updateCrdentials(UserCredentialDTO dto) {
        Optional<UserCredentialEntity> entityO = credentialRepository.findById(dto.getCredentialId());
        UserDTOtoEntityMap.setToCredentialEntity(entityO.get(), dto);
        UserCredentialEntity savedUserentity = credentialRepository.save(entityO.get());
        return savedUserentity.getCredentialId();
    }
    public boolean login(String userType, String loginId, String loginPassword) {
        if (userType == null) {
            userType="customer";
        }
        if (loginId == null) {
            throw new IllegalArgumentException("loginid is not valid");
        }
        if (loginPassword == null) {
            throw new IllegalArgumentException("loginPassword is not valid");
        }
        ExampleMatcher matcher = ExampleMatcher.matching();
        UserCredentialEntity probe = new UserCredentialEntity();

        probe.setLoginId(loginId);
        probe.setUserType(userType);
        Example<UserCredentialEntity> example = Example.of(probe, matcher);
        Optional<UserCredentialEntity> user = credentialRepository.findOne(example);
        if (user.isPresent()) {
            if (user.get().getLoginPassword().equals(loginPassword)) {
                return true;
            }
        }
        return false;
    }

    public Set<RoleEntity> getRolesForUser(String loginId){
    	Set<RoleEntity> roleEntity = Collections.emptySet();
    	if (loginId == null) {
             throw new IllegalArgumentException("loginid is not valid");
        }
        Optional<UserCredentialEntity> user = credentialRepository.findByLoginId(loginId);
        
        //if present then do return it else throw exception
        user.orElseThrow(() -> new UsernameNotFoundException("Username not found"));
        
        if (user.isPresent()) {
        	 roleEntity = user.get().getRoles();
        	 System.out.println("Size of Roles:" + roleEntity.size());
             return roleEntity;
        }
    	return roleEntity;
    }
    
}
