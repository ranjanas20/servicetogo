package com.greenfield.servicetogo.car.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.greenfield.servicetogo.car.entity.EmployeeEntity;


@Repository
public class EntityRepositoryHelper {
    @PersistenceContext
    private EntityManager em;
    
    public EmployeeEntity getEmployeeReference(Integer employee_id){
        return em.getReference(EmployeeEntity.class, employee_id);
        
    }
}
