package com.greenfield.servicetogo.service;

import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.greenfield.servicetogo.dto.SearchDTO;
import com.greenfield.servicetogo.repository.SearchRepository;

@Service
public class SearchService {
	
	@Autowired
	SearchRepository repo;
			
	public List<SearchDTO> findByFirstName(String param){
		List<SearchDTO> servicelist = repo.findByFirstName(param);
		return servicelist;
	}
	
	public List<SearchDTO> findByAttributes(SearchDTO searchDTO){
		List<SearchDTO> servicelist = repo.findByAttributes(searchDTO);
		return servicelist;
	}
	
	public void setRepo(SearchRepository repo) {
		this.repo = repo;
	}

}