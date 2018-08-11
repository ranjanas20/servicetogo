package com.greenfield.servicetogo.car.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greenfield.servicetogo.car.entity.ZipLookupEntity;

public interface ZipLookupRepository extends JpaRepository<ZipLookupEntity, String>  {

  

}
