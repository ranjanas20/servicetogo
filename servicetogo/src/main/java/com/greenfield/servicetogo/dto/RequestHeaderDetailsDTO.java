package com.greenfield.servicetogo.dto;

import java.util.Date;

public class RequestHeaderDetailsDTO {
	
	private Integer reqId;
	private Integer vendorId;
	private String serviceType;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String address;
	private String preferredContactMethod;
	private String symptoms;
	private String comments;
	private Date requestDatetime;
	private String  status;
	private Integer customerId;
	private Integer assigedToEmpId;
	private String priority;
	private Date  completionDatetime;
	
	private Integer id;
	private String vehicleLocation;
	private String vehicleMake;
	private String vehicleModel;
	private String vehicleYear;
	private String VIN;
	
	public Integer getReqId() {
		return reqId;
	}
	public void setReqId(Integer reqId) {
		this.reqId = reqId;
	}
	public Integer getVendorId() {
		return vendorId;
	}
	public void setVendorId(Integer vendorId) {
		this.vendorId = vendorId;
	}
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPreferredContactMethod() {
		return preferredContactMethod;
	}
	public void setPreferredContactMethod(String preferredContactMethod) {
		this.preferredContactMethod = preferredContactMethod;
	}
	public String getSymptoms() {
		return symptoms;
	}
	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Date getRequestDatetime() {
		return requestDatetime;
	}
	public void setRequestDatetime(Date requestDatetime) {
		this.requestDatetime = requestDatetime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public Integer getAssigedToEmpId() {
		return assigedToEmpId;
	}
	public void setAssigedToEmpId(Integer assigedToEmpId) {
		this.assigedToEmpId = assigedToEmpId;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public Date getCompletionDatetime() {
		return completionDatetime;
	}
	public void setCompletionDatetime(Date completionDatetime) {
		this.completionDatetime = completionDatetime;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getVehicleLocation() {
		return vehicleLocation;
	}
	public void setVehicleLocation(String vehicleLocation) {
		this.vehicleLocation = vehicleLocation;
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
	public String getVehicleYear() {
		return vehicleYear;
	}
	public void setVehicleYear(String vehicleYear) {
		this.vehicleYear = vehicleYear;
	}
	public String getVIN() {
		return VIN;
	}
	public void setVIN(String vIN) {
		VIN = vIN;
	}
}
