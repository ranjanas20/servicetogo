package com.greenfield.servicetogo.dto;


public class VehicleDetailsDTO {
	
	private Integer id;
	private Integer reqId;
	private Integer vendorId;
	private String vehicleLocation;
	private String vehicleMake;
	private String vehicleModel;
	private String vehicleYear;
	private String vin;
	
	public VehicleDetailsDTO(){
		super();
	}
	
	public VehicleDetailsDTO(String vehicleModel, String vehicleYear, String vin) {
		super();
		this.vehicleModel = vehicleModel;
		this.vehicleYear = vehicleYear;
		this.vin = vin;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
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
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	
}
