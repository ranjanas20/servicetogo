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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greenfield.servicetogo.car.dto.CarServiceRequestTrackerDTO;
import com.greenfield.servicetogo.car.service.CarServiceRequestService;

@RestController
public class CarServiceRequestController {
    
    @Autowired
    private CarServiceRequestService rhService;

    //@GetMapping is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.GET).
    @GetMapping("/requests")
    public ResponseDTO<List<CarServiceRequestTrackerDTO>>  getRequests(@RequestParam(required = false, defaultValue = "1", value="pageNo") Integer pageNo, 
            @RequestParam(required = false, defaultValue = "20", value="pageSize") Integer pageSize) {
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

    @PostMapping(value = "/requestForm")
    public ResponseDTO<CarServiceRequestTrackerDTO> createRequestForm(@RequestBody CarServiceRequestTrackerDTO rhDTO) {
        ResponseDTO<CarServiceRequestTrackerDTO> dto = new ResponseDTO<CarServiceRequestTrackerDTO>();
        dto.setData(rhService.addRequest(rhDTO));
        return dto;
    }
    @PostMapping(value = "/search")
    public SearchResponseDTO<CarServiceRequestTrackerDTO> search(@RequestBody CarServiceRequestTrackerDTO searchDTO, 
            @RequestParam(required = false, defaultValue = "1", value="pn") Integer pageNo, 
            @RequestParam(required = false, defaultValue = "20", value="ps") Integer pageSize) {
        SearchResponseDTO<CarServiceRequestTrackerDTO> dto = new SearchResponseDTO<CarServiceRequestTrackerDTO>();
        dto.setSuccess(Boolean.TRUE);
        dto.setPageNumber(pageNo);
        dto.setRespCode("OK");
        dto.setTotalPapges((long)Math.ceil(rhService.getRowCount(searchDTO)*1.0/pageSize));
        dto.setRespMessage("ALL SET");
        dto.setData(rhService.searchRequests(searchDTO, pageNo,pageSize));
        return dto;
    }
    @DeleteMapping("/request/{reqId}")
    public ResponseEntity<String> deleteRequest(@PathVariable Long reqId) {

        rhService.deleteRequestById(reqId);

        return new ResponseEntity<String>(reqId.toString(), HttpStatus.OK);

    }

    @PutMapping("/requestForm/{reqId}")
    public void updateRequestForm(@PathVariable Long reqId, @RequestBody CarServiceRequestTrackerDTO rhDTO) {
        rhService.updateRequestForm(reqId, rhDTO);
        //put check on only specific fields can be updated by user vs admin
    }
    @PutMapping("/request/{reqId}")
    public void updateRequest(@PathVariable Long reqId, @RequestBody CarServiceRequestTrackerDTO rhDTO) {
        rhService.updateRequest(reqId, rhDTO);
    }
}
