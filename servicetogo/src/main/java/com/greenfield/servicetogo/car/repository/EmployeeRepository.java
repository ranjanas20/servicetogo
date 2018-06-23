package com.greenfield.servicetogo.car.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greenfield.servicetogo.car.entity.EmployeeEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, String>  {

  

}
