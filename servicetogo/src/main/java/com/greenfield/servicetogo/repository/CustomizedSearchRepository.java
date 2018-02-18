package com.greenfield.servicetogo.repository;

import java.util.List;

import com.greenfield.servicetogo.dto.SearchDTO;

public interface CustomizedSearchRepository {

	 List<SearchDTO> findByAttributes(SearchDTO searchDTO);
}