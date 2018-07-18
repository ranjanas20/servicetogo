package com.greenfield.servicetogo.car.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class CarServiceRequestTrackerDTO {


    private String symptoms;
    private String userComments;
    private String preferredContactMethod;

    private String vehicleLocation;
    
    private Long requestId;
    private Long customerId;
    private String customerFirstName;
    private String customerLastName;
    private String email;
    private String customerPhone;
    private String vehicleMake;
    private String vehicleModel;
    private Integer vehicleYear;
    private String vehicleVin;
    private String addressCity;
    private String addressState;
    private String addressZip;
    private LocalDate requestedDate;
    
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
    
    private String addressLine1;
    private String addressLine2;
    
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
    public String getSymptoms() {
        return symptoms;
    }
    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }
    public String getUserComments() {
        return userComments;
    }
    public void setUserComments(String userComments) {
        this.userComments = userComments;
    }
    public String getVehicleLocation() {
        return vehicleLocation;
    }
    public void setVehicleLocation(String vehicleLocation) {
        this.vehicleLocation = vehicleLocation;
    }
    public Long getRequestId() {
        return requestId;
    }
    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }
    public Long getCustomerId() {
        return customerId;
    }
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
    public String getCustomerFirstName() {
        return customerFirstName;
    }
    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }
    public String getCustomerLastName() {
        return customerLastName;
    }
    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getCustomerPhone() {
        return customerPhone;
    }
    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }
    public String getVehicleMake() {
        return vehicleMake;
    }
    public void setVehicleMake(String vehicleMake) {
        this.vehicleMake = vehicleMake;
    }
    public String getVehicleModel() {
        return vehicleModel;
    }
    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }
    public Integer getVehicleYear() {
        return vehicleYear;
    }
    public void setVehicleYear(Integer vehicleYear) {
        this.vehicleYear = vehicleYear;
    }
    public String getVehicleVin() {
        return vehicleVin;
    }
    public void setVehicleVin(String vehicleVin) {
        this.vehicleVin = vehicleVin;
    }
    public String getAddressCity() {
        return addressCity;
    }
    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }
    public String getAddressState() {
        return addressState;
    }
    public void setAddressState(String addressState) {
        this.addressState = addressState;
    }
    public String getAddressZip() {
        return addressZip;
    }
    public void setAddressZip(String addressZip) {
        this.addressZip = addressZip;
    }
    public LocalDate getRequestedDate() {
        return requestedDate;
    }
    public void setRequestedDate(LocalDate requestedDate) {
        this.requestedDate = requestedDate;
    }
    public String getPreferredContactMethod() {
        return preferredContactMethod;
    }
    public void setPreferredContactMethod(String preferredContactMethod) {
        this.preferredContactMethod = preferredContactMethod;
    }
    @Override
    public String toString() {
        return "CarServiceRequestTrackerDTO [symptoms=" + symptoms + ", userComments=" + userComments
                + ", preferredContactMethod=" + preferredContactMethod + ", vehicleLocation=" + vehicleLocation
                + ", requestId=" + requestId + ", customerId=" + customerId + ", customerFirstName=" + customerFirstName
                + ", customerLastName=" + customerLastName + ", email=" + email + ", customerPhone=" + customerPhone
                + ", vehicleMake=" + vehicleMake + ", vehicleModel=" + vehicleModel + ", vehicleYear=" + vehicleYear
                + ", vehicleVin=" + vehicleVin + ", addressCity=" + addressCity + ", addressState=" + addressState
                + ", addressZip=" + addressZip + ", requestedDate=" + requestedDate + ", serviceStatus=" + serviceStatus
                + ", assigedEmployeeId=" + assigedEmployeeId + ", assigedEmployeeFirstName=" + assigedEmployeeFirstName
                + ", assigedEmployeeLastName=" + assigedEmployeeLastName + ", servicePriority=" + servicePriority
                + ", serviceScheduleDatetime=" + serviceScheduleDatetime + ", serviceCompletionDatetime="
                + serviceCompletionDatetime + ", serviceCompletedById=" + serviceCompletedById
                + ", serviceCompletedByFirstName=" + serviceCompletedByFirstName + ", serviceCompletedByLastName="
                + serviceCompletedByLastName + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2
                + ", createdOn=" + createdOn + ", createdBy=" + createdBy + ", updatedOn=" + updatedOn + ", updatedBy="
                + updatedBy + "]";
    }
    
}
