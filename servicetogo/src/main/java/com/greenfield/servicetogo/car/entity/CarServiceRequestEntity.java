package com.greenfield.servicetogo.car.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "car_service_request")
public class CarServiceRequestEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "request_id", nullable = false)
    private Long requestId;
    
    @Column(name = "tenant_id")
    private Integer tenantId;
    
    @Column(name = "customer_id")
    private Long customerId;
    
    @Column(name = "customer_first_name", nullable = false)
    private String customerFirstName;
    
    @Column(name = "customer_last_name")
    private String customerLastName;
    
    @Column(name = "customer_email")
    private String email;
    
    @Column(name = "customer_phone")
    private String customerPhone;
    
    @Column(name = "preferred_contact_method")
    private String preferredContactMethod;
    
    @Column(name = "vehicle_make")
    private String vehicleMake;
    
    @Column(name = "vehicle_model")
    private String vehicleModel;
    
    @Column(name = "vehicle_year")
    private Integer vehicleYear;
    
    @Column(name = "vehicle_vin")
    private String vehicleVin;
    
    
    @Column(name = "address_line1")
    private String addressLine1;
    
    @Column(name = "address_line2")
    private String addressLine2;
    
    @Column(name = "address_city")
    private String addressCity;
    
    @Column(name = "address_state")
    private String addressState;
    
    @Column(name = "address_zip")
    private String addressZip;
        
    @Column(name = "symptoms")
    private String symptoms;
    
    @Column(name = "user_comments")
    private String userComments;
    
    @Column(name = "requested_datetime")
    private Date requested_datetime;
    
    @Column(name = "vehicle_location")
    private String vehicleLocation;
    
    @Column(name = "service_status")
    private String  serviceStatus;
    
    @Column(name = "assigned_employee_id")
    private String assigedEmployee;
    
    @Column(name = "service_priority")
    private String servicePriority;
    
    @Column(name = "service_schedule_datetime")
    private Date  serviceScheduleDatetime;    
    
    @Column(name = "service_completion_datetime")
    private Date  serviceCompletionDatetime;
    
    @Column(name = "service_completed_by")
    private String  serviceCompletedBy;
    
    @Column(name = "created_on")
    private Date  createdOn;
    
    @Column(name = "created_by")
    private String  createdBy;
    
    @Column(name = "updated_on")
    private Date  updatedOn;
    
    @Column(name = "updated_by")
    private String  updatedBy;
}
