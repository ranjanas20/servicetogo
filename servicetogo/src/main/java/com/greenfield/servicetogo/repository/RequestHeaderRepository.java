package com.greenfield.servicetogo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greenfield.servicetogo.entity.RequestHeaderEntity;

public interface RequestHeaderRepository extends JpaRepository<RequestHeaderEntity, Integer> {

}
