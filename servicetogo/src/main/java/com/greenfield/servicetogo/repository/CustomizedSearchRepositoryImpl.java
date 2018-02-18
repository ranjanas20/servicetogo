package com.greenfield.servicetogo.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import com.greenfield.servicetogo.dto.SearchDTO;

public class CustomizedSearchRepositoryImpl implements CustomizedSearchRepository {
	
	@Autowired
	EntityManager entityManager;
	
	public List<SearchDTO> findByAttributes(SearchDTO searchDTO){
		
		StringBuilder query = new StringBuilder();
		query.append("SELECT NEW com.greenfield.servicetogo.dto.SearchDTO "
				+ "( ae.reqId, ae.serviceType, ae.firstName, be.vin ) "
				+ "FROM RequestHeaderEntity ae, VehicleDetailsEntity be "
				+ "where ");
		String whereClause = getWhereClause(searchDTO );
		query.append(whereClause);
		List<SearchDTO> servicelist = entityManager.createQuery(query.toString() , SearchDTO.class).getResultList();
			 
		return servicelist;
	}
	
	private String getWhereClause(SearchDTO searchDTO ){
		StringBuilder whereClause = new StringBuilder();
		if(searchDTO.getServiceType() != null){
			if(!searchDTO.getServiceType().equals("")){
				whereClause.append(" ae.serviceType = '" + searchDTO.getServiceType() + "'");
			}
		}
			return whereClause.toString();
			
	}
	
}