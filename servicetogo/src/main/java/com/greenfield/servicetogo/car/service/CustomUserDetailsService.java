package com.greenfield.servicetogo.car.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.greenfield.servicetogo.car.entity.CustomUserDetails;
import com.greenfield.servicetogo.car.entity.UserCredentialEntity;
import com.greenfield.servicetogo.car.repository.UserCredentialRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserCredentialRepository usersRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserCredentialEntity> optionalUsers = usersRepository.findByLoginId(username);

        //if present then do return it else throw exception
       optionalUsers.orElseThrow(() -> new UsernameNotFoundException("Username not found"));
        
       CustomUserDetails customUserDetails = optionalUsers.map(users -> {
       											return new CustomUserDetails(users);
       										}).get();

       System.out.println("username:"+customUserDetails.getUsername());
       System.out.println("passwd:"+customUserDetails.getPassword());
       System.out.println("Role Size:"+customUserDetails.getRoles().size()+customUserDetails.getRoles().iterator().next().getRoleName());
       System.out.println("Authorities Size:"+customUserDetails.getAuthorities().size());
       
       //return customUserDetails; 

       return optionalUsers.map(CustomUserDetails::new).get();
    }
}
