package com.greenfield.servicetogo.car.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class CarServiceSearchFormDTO {
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
    private String assigedEmployeeId;
    private String assigedEmployeeFirstName;
    private String assigedEmployeeLastName;
    private String servicePriority;
    private LocalDateTime  serviceScheduleDatetime;    
    private LocalDateTime  serviceCompletionDatetime;
    private String  serviceCompletedById;
    private String  serviceCompletedByFirstName;
    private String  serviceCompletedByLastName;
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
    public void setRequestedDatetime(LocalDate requestedDate) {
        this.requestedDate = requestedDate;
    }
    public String getServiceStatus() {
        return serviceStatus;
    }
    public void setServiceStatus(String serviceStatus) {
        this.serviceStatus = serviceStatus;
    }
    public String getAssigedEmployeeId() {
        return assigedEmployeeId;
    }
    public void setAssigedEmployeeId(String assigedEmployeeId) {
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
    public String getServiceCompletedById() {
        return serviceCompletedById;
    }
    public void setServiceCompletedById(String serviceCompletedById) {
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
    
    
}
