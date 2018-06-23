package com.greenfield.servicetogo.car.service;

import static com.greenfield.servicetogo.car.dto.DTOtoEntityDataMapper.toNewRequestEntity;
import static com.greenfield.servicetogo.car.dto.DTOtoEntityDataMapper.toRequestTrackerDTO;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.greenfield.servicetogo.car.dto.CarServiceRequestFormDTO;
import com.greenfield.servicetogo.car.dto.CarServiceRequestTrackerDTO;
import com.greenfield.servicetogo.car.dto.DTOtoEntityDataMapper;
import com.greenfield.servicetogo.car.entity.CarServiceRequestEntity;
import com.greenfield.servicetogo.car.repository.CarServiceRequestRepository;

@Service
public class CarServiceRequestService {
    @Autowired
    private CarServiceRequestRepository carServiceRequestRepository;
    public CarServiceRequestTrackerDTO addRequest(CarServiceRequestFormDTO rhDTO) {
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

    public void updateRequest(Long reqId, CarServiceRequestFormDTO rhDTO) {
        CarServiceRequestEntity entity = carServiceRequestRepository.getOne(reqId) ;  
        DTOtoEntityDataMapper.updateEntityFromDTO(entity,rhDTO);
        carServiceRequestRepository.save(entity);
    }

}
