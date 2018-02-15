package com.greenfield.servicetogo.dto;


public class VehicleDetailsDTO {
	
	private Integer id;
	private Integer reqId;
	private Integer vendorId;
	private String vehicleLocation;
	private String vehicleMake;
	private String vehicleModel;
	private String vehicleYear;
	private String VIN;
	
	public VehicleDetailsDTO(){
		super();
	}
	
	public VehicleDetailsDTO(String vehicleModel, String vehicleYear, String vIN) {
		super();
		this.vehicleModel = vehicleModel;
		this.vehicleYear = vehicleYear;
		VIN = vIN;
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
	public String getVIN() {
		return VIN;
	}
	public void setVIN(String vIN) {
		VIN = vIN;
	}
	
}
