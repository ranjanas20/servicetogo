package com.greenfield.servicetogo.car.entity;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "car_service_request")
public class CarServiceRequestEntity extends Auditable {
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
    
    @Column(name = "requested_date")
    private Date requestedDate;
    
    @Column(name = "vehicle_location")
    private String vehicleLocation;
    
    @Column(name = "service_status")
    private String  serviceStatus;
    
    @OneToOne
    @JoinColumn(name="assigned_employee_id", referencedColumnName="employee_id")    
    private EmployeeEntity assigedEmployee;
    
    @Column(name = "assigned_priority")
    private String servicePriority;
    
    @Column(name = "service_schedule_datetime")
    private Timestamp  serviceScheduleDatetime;    
    
    @Column(name = "service_completion_datetime")
    private Timestamp  serviceCompletionDatetime;
    
    @OneToOne
    @JoinColumn(name="service_completed_by", referencedColumnName="employee_id")
    private EmployeeEntity  serviceCompletedBy;
    
    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }

    public Integer getTenantId() {
        return tenantId;
    }

    public void setTenantId(Integer tenantId) {
        this.tenantId = tenantId;
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

    public String getPreferredContactMethod() {
        return preferredContactMethod;
    }

    public void setPreferredContactMethod(String preferredContactMethod) {
        this.preferredContactMethod = preferredContactMethod;
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

    public Date getRequestedDate() {
        return requestedDate;
    }

    public void setRequestedDate(Date requestedDate) {
        this.requestedDate = requestedDate;
    }

    public String getVehicleLocation() {
        return vehicleLocation;
    }

    public void setVehicleLocation(String vehicleLocation) {
        this.vehicleLocation = vehicleLocation;
    }

    public String getServiceStatus() {
        return serviceStatus;
    }

    public void setServiceStatus(String serviceStatus) {
        this.serviceStatus = serviceStatus;
    }

    public EmployeeEntity getAssigedEmployee() {
        return assigedEmployee;
    }

    public void setAssigedEmployee(EmployeeEntity assigedEmployee) {
        this.assigedEmployee = assigedEmployee;
    }

    public String getServicePriority() {
        return servicePriority;
    }

    public void setServicePriority(String servicePriority) {
        this.servicePriority = servicePriority;
    }

    public Timestamp getServiceScheduleDatetime() {
        return serviceScheduleDatetime;
    }

    public void setServiceScheduleDatetime(Timestamp serviceScheduleDatetime) {
        this.serviceScheduleDatetime = serviceScheduleDatetime;
    }

    public Timestamp getServiceCompletionDatetime() {
        return serviceCompletionDatetime;
    }

    public void setServiceCompletionDatetime(Timestamp serviceCompletionDatetime) {
        this.serviceCompletionDatetime = serviceCompletionDatetime;
    }

    public EmployeeEntity getServiceCompletedBy() {
        return serviceCompletedBy;
    }

    public void setServiceCompletedBy(EmployeeEntity serviceCompletedBy) {
        this.serviceCompletedBy = serviceCompletedBy;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((customerFirstName == null) ? 0 : customerFirstName.hashCode());
        result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
        result = prime * result + ((customerLastName == null) ? 0 : customerLastName.hashCode());
        result = prime * result + ((customerPhone == null) ? 0 : customerPhone.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((requestedDate == null) ? 0 : requestedDate.hashCode());
        result = prime * result + ((tenantId == null) ? 0 : tenantId.hashCode());
        result = prime * result + ((vehicleMake == null) ? 0 : vehicleMake.hashCode());
        result = prime * result + ((vehicleModel == null) ? 0 : vehicleModel.hashCode());
        result = prime * result + ((vehicleVin == null) ? 0 : vehicleVin.hashCode());
        result = prime * result + ((vehicleYear == null) ? 0 : vehicleYear.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CarServiceRequestEntity other = (CarServiceRequestEntity) obj;
        if (customerFirstName == null) {
            if (other.customerFirstName != null)
                return false;
        } else if (!customerFirstName.equals(other.customerFirstName))
            return false;
        if (customerId == null) {
            if (other.customerId != null)
                return false;
        } else if (!customerId.equals(other.customerId))
            return false;
        if (customerLastName == null) {
            if (other.customerLastName != null)
                return false;
        } else if (!customerLastName.equals(other.customerLastName))
            return false;
        if (customerPhone == null) {
            if (other.customerPhone != null)
                return false;
        } else if (!customerPhone.equals(other.customerPhone))
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (requestedDate == null) {
            if (other.requestedDate != null)
                return false;
        } else if (!requestedDate.equals(other.requestedDate))
            return false;
        if (tenantId == null) {
            if (other.tenantId != null)
                return false;
        } else if (!tenantId.equals(other.tenantId))
            return false;
        if (vehicleMake == null) {
            if (other.vehicleMake != null)
                return false;
        } else if (!vehicleMake.equals(other.vehicleMake))
            return false;
        if (vehicleModel == null) {
            if (other.vehicleModel != null)
                return false;
        } else if (!vehicleModel.equals(other.vehicleModel))
            return false;
        if (vehicleVin == null) {
            if (other.vehicleVin != null)
                return false;
        } else if (!vehicleVin.equals(other.vehicleVin))
            return false;
        if (vehicleYear == null) {
            if (other.vehicleYear != null)
                return false;
        } else if (!vehicleYear.equals(other.vehicleYear))
            return false;
        return true;
    }
    
}
