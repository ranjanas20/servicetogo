package com.greenfield.servicetogo.dto;

import java.util.Date;

import com.greenfield.servicetogo.entity.VehicleDetailsEntity;

public class RequestHeaderDTO {

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
	private VehicleDetailsEntity vsdEntity;
	
	
	public RequestHeaderDTO(){
		super();
	}
	
	public RequestHeaderDTO(String serviceType, 
			String firstName, Date requestDatetime,
			VehicleDetailsEntity vsdEntity) {
		super();
		this.serviceType = serviceType;
		this.firstName = firstName;
		this.requestDatetime = requestDatetime;
		this.vsdEntity = vsdEntity;
	}
	
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
	public VehicleDetailsEntity getVsdEntity() {
		return vsdEntity;
	}
	public void setVsdEntity(VehicleDetailsEntity vsdEntity) {
		this.vsdEntity = vsdEntity;
	}
	
}
