package com.greenfield.servicetogo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.greenfield.servicetogo.dto.SearchDTO;
import com.greenfield.servicetogo.entity.RequestHeaderEntity;

public interface SearchRepository extends JpaRepository<RequestHeaderEntity, Integer>, CustomizedSearchRepository{

	@Query(value = "SELECT NEW com.greenfield.servicetogo.dto.SearchDTO ( ae.reqId, ae.serviceType, ae.firstName, be.vin ) FROM RequestHeaderEntity ae, VehicleDetailsEntity be where ae.firstName=?1")
	List<SearchDTO> findByFirstName(String firstName);

	//@Query("Select hq, vsd from HeaderRequestEntity hq, VehicleDetailsEntity vsd where hd.reqId = vsd.reqId and hq.firstName = ?")
   //List<HeaderDetailsSearchDTO> findByFirstName(@Param("myparam") String firstName);


}