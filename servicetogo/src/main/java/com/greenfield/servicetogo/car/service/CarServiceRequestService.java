package com.greenfield.servicetogo.car.service;

import static com.greenfield.servicetogo.car.dto.DTOtoEntityDataMapper.toNewRequestEntity;
import static com.greenfield.servicetogo.car.dto.DTOtoEntityDataMapper.toRequestTrackerDTO;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.greenfield.servicetogo.car.controller.SearchResponseDTO;
import com.greenfield.servicetogo.car.dto.CarServiceRequestTrackerDTO;
import com.greenfield.servicetogo.car.dto.DTOtoEntityDataMapper;
import com.greenfield.servicetogo.car.entity.CarServiceRequestEntity;
import com.greenfield.servicetogo.car.repository.CarServiceRequestRepository;

@Service
public class CarServiceRequestService {
    @Autowired
    private CarServiceRequestRepository carServiceRequestRepository;
    
    public CarServiceRequestTrackerDTO addRequest(CarServiceRequestTrackerDTO rhDTO) {
        CarServiceRequestEntity savedEntity = carServiceRequestRepository.save(toNewRequestEntity(rhDTO));
        return toRequestTrackerDTO(savedEntity);
    }

    public CarServiceRequestTrackerDTO findRequestById(Long reqId) {
        CarServiceRequestEntity foundEntity = carServiceRequestRepository.getOne(reqId);
        return toRequestTrackerDTO(foundEntity);
    }

    public List<CarServiceRequestTrackerDTO> findAllRequest(Integer pageNo, Integer pageSize) {
        Pageable page = PageRequest.of(pageNo, pageSize, Sort.Direction.ASC, "requestId");
        Page<CarServiceRequestEntity> pages= carServiceRequestRepository.findAll(page);
        
        return pages.getContent().stream().map(r-> { return toRequestTrackerDTO(r);})
                .collect(Collectors.toList());
    }

    public void deleteRequestById(Long reqId) {
        carServiceRequestRepository.deleteById(reqId);        
    }

    public CarServiceRequestTrackerDTO updateRequestForm(Long reqId, CarServiceRequestTrackerDTO rhDTO) {
        CarServiceRequestEntity entity = carServiceRequestRepository.getOne(reqId) ;  
        DTOtoEntityDataMapper.updateEntityWithFromDTO(entity,rhDTO);
        CarServiceRequestEntity savedEntity = carServiceRequestRepository.save(entity);
        return toRequestTrackerDTO(savedEntity);
    }

    public SearchResponseDTO<CarServiceRequestTrackerDTO>  searchRequests(CarServiceRequestTrackerDTO rhDTO, Integer pageNo, Integer pageSize) {
        SearchResponseDTO<CarServiceRequestTrackerDTO>  dto = new SearchResponseDTO<>();
        Pageable pageable = PageRequest.of((pageNo-1), pageSize, Sort.Direction.ASC, "requestId");
        CarServiceRequestEntity probe = new CarServiceRequestEntity();
        ExampleMatcher matcher = ExampleMatcher.matching() ;
        if(rhDTO.getCustomerFirstName()!=null && rhDTO.getCustomerFirstName().length()>0){
            probe.setCustomerFirstName(rhDTO.getCustomerFirstName());
            matcher.withMatcher("customerFirstName", match -> match.startsWith());
        }
        if(rhDTO.getCustomerLastName()!=null && rhDTO.getCustomerLastName().length()>0){
            probe.setCustomerLastName(rhDTO.getCustomerLastName());
            matcher.withMatcher("customerLastName", match -> match.startsWith());
        }
        if(rhDTO.getServiceStatus()!=null && rhDTO.getServiceStatus().length()>0){
            if(!"COMPLETED".equalsIgnoreCase(rhDTO.getServiceStatus())){
                probe.setServiceStatus("NEW");
            }else{
                probe.setServiceStatus(rhDTO.getServiceStatus());
            }
            
        }
        
        Example<CarServiceRequestEntity> example = Example.of(probe,matcher);
        Page<CarServiceRequestEntity> page= carServiceRequestRepository.findAll(example, pageable);
        List<CarServiceRequestTrackerDTO> ret = new LinkedList<>();
        for ( CarServiceRequestEntity r: page){
            ret.add(toRequestTrackerDTO(r));
        }
        dto.setTotalPapges(Math.round(((carServiceRequestRepository.count(example)*1.0)/pageSize)+.5));
        dto.setData(ret);
        return dto;
    }
    public Long getRowCount(CarServiceRequestTrackerDTO rhDTO) {
        CarServiceRequestEntity probe = new CarServiceRequestEntity();
        ExampleMatcher matcher = ExampleMatcher.matching() ;
        if(rhDTO.getCustomerFirstName()!=null && rhDTO.getCustomerFirstName().length()>0){
            probe.setCustomerFirstName(rhDTO.getCustomerFirstName());
            matcher.withMatcher("customerFirstName", match -> match.startsWith());
        }
        if(rhDTO.getCustomerLastName()!=null && rhDTO.getCustomerLastName().length()>0){
            probe.setCustomerLastName(rhDTO.getCustomerLastName());
            matcher.withMatcher("customerLastName", match -> match.startsWith());
        }
        if(rhDTO.getServiceStatus()!=null && rhDTO.getServiceStatus().length()>0){
            if(!"COMPLETED".equalsIgnoreCase(rhDTO.getServiceStatus())){
                probe.setServiceStatus("NEW");
            }else{
                probe.setServiceStatus(rhDTO.getServiceStatus());
            }
            
        }
        
        Example<CarServiceRequestEntity> example = Example.of(probe,matcher);
        return carServiceRequestRepository.count(example);
    }
}
