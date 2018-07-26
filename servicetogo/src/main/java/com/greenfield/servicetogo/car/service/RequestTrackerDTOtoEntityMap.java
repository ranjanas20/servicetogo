package com.greenfield.servicetogo.car.service;

import java.time.Clock;
import java.time.LocalDateTime;

import com.greenfield.servicetogo.car.dto.CarServiceRequestTrackerDTO;
import com.greenfield.servicetogo.car.entity.CarServiceRequestEntity;
import com.greenfield.servicetogo.car.repository.EntityRepositoryHelper;
import static com.greenfield.servicetogo.car.service.DataConvertUtil.*;
public class RequestTrackerDTOtoEntityMap {
    public static CarServiceRequestEntity toNewRequestEntity(CarServiceRequestTrackerDTO dto){
        CarServiceRequestEntity entity = new CarServiceRequestEntity();
        entity.setCustomerId(dto.getCustomerId());
        entity.setCustomerFirstName(dto.getCustomerFirstName());
        entity.setCustomerLastName(dto.getCustomerLastName());
        entity.setEmail(dto.getEmail());
        entity.setCustomerPhone(dto.getCustomerPhone());
        entity.setVehicleMake(dto.getVehicleMake());
        entity.setVehicleModel(dto.getVehicleModel());
        entity.setVehicleYear(dto.getVehicleYear());
        entity.setVehicleVin(dto.getVehicleVin());
        entity.setAddressCity(dto.getAddressCity());
        entity.setAddressState(dto.getAddressState());
        entity.setAddressZip(dto.getAddressZip());
        entity.setVehicleLocation(dto.getVehicleLocation());
        entity.setRequestedDate(toSqlDate(dto.getRequestedDate()));
        entity.setPreferredContactMethod(dto.getPreferredContactMethod());
        entity.setServiceStatus("NEW");
        entity.setSymptoms(dto.getSymptoms());
        entity.setUserComments(dto.getUserComments());
        
        setAuditableNEW(entity);
        entity.setTenantId(DEFAULT_TENANT);
        return entity;
    }
    public static CarServiceRequestTrackerDTO toRequestTrackerDTO(CarServiceRequestEntity entity){
        CarServiceRequestTrackerDTO dto = new CarServiceRequestTrackerDTO();
        dto.setRequestId(entity.getRequestId());
        dto.setCustomerId(entity.getCustomerId());
        dto.setCustomerFirstName(entity.getCustomerFirstName());
        dto.setCustomerMiddleName(entity.getCustomerMiddleName());
        dto.setCustomerLastName(entity.getCustomerLastName());
        dto.setEmail(entity.getEmail());
        dto.setPreferredContactMethod(entity.getPreferredContactMethod());
        dto.setCustomerPhone(entity.getCustomerPhone());
        dto.setVehicleMake(entity.getVehicleMake());
        dto.setVehicleModel(entity.getVehicleModel());
        dto.setVehicleYear(entity.getVehicleYear());
        dto.setVehicleVin(entity.getVehicleVin());
        dto.setAddressCity(entity.getAddressCity());
        dto.setAddressLine1(entity.getAddressLine1());
        dto.setAddressLine2(entity.getAddressLine2());
        dto.setAddressState(entity.getAddressState());
        dto.setAddressZip(entity.getAddressZip());
        dto.setRequestedDate(toLocalDate(entity.getRequestedDate()));
        dto.setSymptoms(entity.getSymptoms());
        dto.setUserComments(entity.getUserComments());
        dto.setVehicleLocation(entity.getVehicleLocation());
        dto.setServiceStatus(entity.getServiceStatus());
        
        if(entity.getAssigedEmployee()!=null){
            dto.setAssigedEmployeeId(entity.getAssigedEmployee().getEmployeeId());
            dto.setAssigedEmployeeFirstName(entity.getAssigedEmployee().getEmployeeFirstName());
            dto.setAssigedEmployeeLastName(entity.getAssigedEmployee().getEmployeeLastName());
        }
        dto.setServicePriority(entity.getServicePriority());
        dto.setServiceScheduleDatetime(toLocalDateTime(entity.getServiceScheduleDatetime()));    
        dto.setServiceCompletionDatetime(toLocalDateTime(entity.getServiceCompletionDatetime()));
        if(entity.getServiceCompletedBy()!=null){
            dto.setServiceCompletedById(entity.getServiceCompletedBy().getEmployeeId());
            dto.setServiceCompletedByFirstName(entity.getServiceCompletedBy().getEmployeeFirstName());
            dto.setServiceCompletedByLastName(entity.getServiceCompletedBy().getEmployeeLastName());
        }
        dto.setUpdatedOn(toLocalDateTime(entity.getUpdatedOn()));
        dto.setUpdatedBy(entity.getUpdatedBy());
        dto.setCreatedOn(toLocalDateTime(entity.getCreatedOn()));
        dto.setCreatedBy(entity.getCreatedBy());
        return dto;
    }
    public static void updateEntityWithFromDTO(CarServiceRequestEntity entity, CarServiceRequestTrackerDTO dto){
        entity.setCustomerId(dto.getCustomerId());
        entity.setCustomerFirstName(dto.getCustomerFirstName());
        entity.setCustomerLastName(dto.getCustomerLastName());
        entity.setCustomerMiddleName(dto.getCustomerMiddleName());
        entity.setEmail(dto.getEmail());
        entity.setPreferredContactMethod(dto.getPreferredContactMethod());
        entity.setCustomerPhone(dto.getCustomerPhone());
        entity.setVehicleMake(dto.getVehicleMake());
        entity.setVehicleModel(dto.getVehicleModel());
        entity.setVehicleYear(dto.getVehicleYear());
        entity.setVehicleVin(dto.getVehicleVin());
        entity.setAddressCity(dto.getAddressCity());
        entity.setAddressState(dto.getAddressState());
        entity.setAddressZip(dto.getAddressZip());
        entity.setRequestedDate(toSqlDate(dto.getRequestedDate()));
        entity.setVehicleLocation(dto.getVehicleLocation());
        entity.setSymptoms(dto.getSymptoms());
        entity.setUserComments(dto.getUserComments());
        entity.setAddressLine1(dto.getAddressLine1());
        entity.setAddressLine2(dto.getAddressLine2());
        setAuditableMODIFY(entity);
        entity.setTenantId(DEFAULT_TENANT);
       
    }
    public static void updateEntityWithRequestTrackerDTO(CarServiceRequestEntity entity, CarServiceRequestTrackerDTO dto, EntityRepositoryHelper erh){
        updateEntityWithFromDTO(entity, dto);

        entity.setServiceStatus(dto.getServiceStatus());
        if(dto.getAssigedEmployeeId()!=null){
            entity.setAssigedEmployee(erh.getEmployeeReference(dto.getAssigedEmployeeId()));
        }else{
            entity.setAssigedEmployee(null);
        }
        entity.setServicePriority(dto.getServicePriority());
        entity.setServiceScheduleDatetime(toSqlTimeStamp(dto.getServiceScheduleDatetime()));    
        entity.setServiceCompletionDatetime(toSqlTimeStamp(dto.getServiceCompletionDatetime()));
        if(dto.getServiceCompletedById()!=null){
            entity.setServiceCompletedBy(erh.getEmployeeReference(dto.getServiceCompletedById()));
        }else{
            entity.setServiceCompletedBy(null);
        }
    }

}
