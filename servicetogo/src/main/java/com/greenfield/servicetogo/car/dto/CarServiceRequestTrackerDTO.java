package com.greenfield.servicetogo.car.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class CarServiceRequestTrackerDTO extends CarServiceRequestFormDTO {
    
    private String addressLine1;
    private String addressLine2;
    private String  serviceStatus;
    private Integer assigedEmployeeId;
    private String assigedEmployeeFirstName;
    private String assigedEmployeeLastName;
    private String servicePriority;
    private LocalDateTime  serviceScheduleDatetime;    
    private LocalDateTime  serviceCompletionDatetime;
    private Integer  serviceCompletedById;
    private String  serviceCompletedByFirstName;
    private String  serviceCompletedByLastName;
    
    
    private LocalDateTime  createdOn;
    private String  createdBy;
    private LocalDateTime  updatedOn;
    private String  updatedBy;
    
    
    public String getServiceStatus() {
        return serviceStatus;
    }
    public void setServiceStatus(String serviceStatus) {
        this.serviceStatus = serviceStatus;
    }
    public Integer getAssigedEmployeeId() {
        return assigedEmployeeId;
    }
    public void setAssigedEmployeeId(Integer assigedEmployeeId) {
        this.assigedEmployeeId = assigedEmployeeId;
    }
    public String getAssigedEmployeeFirstName() {
        return assigedEmployeeFirstName;
    }
    public void setAssigedEmployeeFirstName(String assigedEmployeeFirstName) {
        this.assigedEmployeeFirstName = assigedEmployeeFirstName;
    }
    public String getAssigedEmployeeLastName() {
        return assigedEmployeeLastName;
    }
    public void setAssigedEmployeeLastName(String assigedEmployeeLastName) {
        this.assigedEmployeeLastName = assigedEmployeeLastName;
    }
    public String getServicePriority() {
        return servicePriority;
    }
    public void setServicePriority(String servicePriority) {
        this.servicePriority = servicePriority;
    }
    public LocalDateTime getServiceScheduleDatetime() {
        return serviceScheduleDatetime;
    }
    public void setServiceScheduleDatetime(LocalDateTime serviceScheduleDatetime) {
        this.serviceScheduleDatetime = serviceScheduleDatetime;
    }
    public LocalDateTime getServiceCompletionDatetime() {
        return serviceCompletionDatetime;
    }
    public void setServiceCompletionDatetime(LocalDateTime serviceCompletionDatetime) {
        this.serviceCompletionDatetime = serviceCompletionDatetime;
    }
    public Integer getServiceCompletedById() {
        return serviceCompletedById;
    }
    public void setServiceCompletedById(Integer serviceCompletedById) {
        this.serviceCompletedById = serviceCompletedById;
    }
    public String getServiceCompletedByFirstName() {
        return serviceCompletedByFirstName;
    }
    public void setServiceCompletedByFirstName(String serviceCompletedByFirstName) {
        this.serviceCompletedByFirstName = serviceCompletedByFirstName;
    }
    public String getServiceCompletedByLastName() {
        return serviceCompletedByLastName;
    }
    public void setServiceCompletedByLastName(String serviceCompletedByLastName) {
        this.serviceCompletedByLastName = serviceCompletedByLastName;
    }
    public String getAddressLine1() {
        return addressLine1;
    }
    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }
    public String getAddressLine2() {
        return addressLine2;
    }
    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }
    public LocalDateTime getCreatedOn() {
        return createdOn;
    }
    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }
    public String getCreatedBy() {
        return createdBy;
    }
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }
    public void setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
    }
    public String getUpdatedBy() {
        return updatedBy;
    }
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
    
}
