package com.greenfield.servicetogo.car.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greenfield.servicetogo.car.entity.CustomerEntity;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long>{

    CustomerEntity findByLoginId(String loginId);

}
