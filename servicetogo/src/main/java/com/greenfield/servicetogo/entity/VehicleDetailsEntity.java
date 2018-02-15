package com.greenfield.servicetogo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "vehicle_service_details")
public class VehicleDetailsEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "vendor_id")
	private Integer vendorId;
	
	@Column(name = "vehicle_location")
	private String vehicleLocation;
	
	@Column(name = "vehicle_make")
	private String vehicleMake;
	
	@Column(name = "vehicle_model")
	private String vehicleModel;
	
	@Column(name = "vehicle_year")
	private String vehicleYear;
	
	private String VIN;
	
	/*
	@ManyToOne
	@JoinColumn(name="req_id", referencedColumnName="req_id", insertable = false, updatable = false)
	private RequestHeaderEntity requestHeader;
	*/
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="req_id", referencedColumnName="req_id")
	private RequestHeaderEntity requestHeader;
	
	public VehicleDetailsEntity() {
		super();
	}

	public VehicleDetailsEntity(String vehicleModel, String vehicleYear, String vIN) {
		super();
		this.vehicleModel = vehicleModel;
		this.vehicleYear = vehicleYear;
		this.VIN = vIN;
	}
	
	public VehicleDetailsEntity(String vehicleModel, String vehicleYear, String vIN, RequestHeaderEntity requestHeader) {
		super();
		this.vehicleModel = vehicleModel;
		this.vehicleYear = vehicleYear;
		this.VIN = vIN;
		this.requestHeader = requestHeader;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
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
	
	public RequestHeaderEntity getRequestHeader() {
		return requestHeader;
	}

	public void setRequestHeader(RequestHeaderEntity requestHeader) {
		this.requestHeader = requestHeader;
	}
}
