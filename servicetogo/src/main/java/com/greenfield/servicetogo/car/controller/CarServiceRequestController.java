package com.greenfield.servicetogo.car.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.greenfield.servicetogo.car.dto.CarServiceRequestFormDTO;
import com.greenfield.servicetogo.car.dto.CarServiceRequestTrackerDTO;
import com.greenfield.servicetogo.car.service.CarServiceRequestService;

@RestController
public class CarServiceRequestController {
    
    @Autowired
    private CarServiceRequestService rhService;

    //@GetMapping is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.GET).
    @GetMapping("/requests")
    public ResponseDTO<List<CarServiceRequestTrackerDTO>>  getRequests(Integer pageNo, Integer pageSize) {
        ResponseDTO<List<CarServiceRequestTrackerDTO>> resp = new ResponseDTO<List<CarServiceRequestTrackerDTO>>();
        resp.setData( rhService.findAllRequest(pageNo,pageSize));
        resp.setSuccess(true);
        return resp;
    }

    @GetMapping("/request/{reqId}")
    public ResponseDTO<CarServiceRequestTrackerDTO> getRequest(@PathVariable("reqId") Long reqId) {
        ResponseDTO<CarServiceRequestTrackerDTO> dto = new ResponseDTO<CarServiceRequestTrackerDTO>();
        try{
            dto.setData(rhService.findRequestById(reqId));
        }catch(javax.persistence.EntityNotFoundException e){
            dto.setSuccess(false);
            dto.setRespCode("NotFound");
            dto.setRespMessage("No Service Request found for ReqId: "+reqId);
        }
        return dto;
    }

    @PostMapping(value = "/request")
    public ResponseDTO<CarServiceRequestFormDTO> createRequest(@RequestBody CarServiceRequestFormDTO rhDTO) {
        ResponseDTO<CarServiceRequestFormDTO> dto = new ResponseDTO<CarServiceRequestFormDTO>();
        dto.setData(rhService.addRequest(rhDTO));
        return dto;
    }

    @DeleteMapping("/request/{reqId}")
    public ResponseEntity<String> deleteRequestHeader(@PathVariable Long reqId) {

        rhService.deleteRequestById(reqId);

        return new ResponseEntity<String>(reqId.toString(), HttpStatus.OK);

    }

    @PutMapping("/request/{reqId}")
    public void updateRequest(@PathVariable Long reqId, @RequestBody CarServiceRequestFormDTO rhDTO) {

        rhService.updateRequest(reqId, rhDTO);
    }

}
