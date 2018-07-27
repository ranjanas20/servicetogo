package com.greenfield.servicetogo.car.dto;

public class CustomerProfileDTO  extends AuditableDTO{
    private Long customerId;
    private String loginId;
    private String customerFirstName;
    private String customerLastName;
    private String customerMiddleName;
    private String email;
    private String customerPhone;
    
    private String addressLine1;
    private String addressLine2;
    private String addressCity;
    private String addressState;
    private String addressZip;
    
    public String getLoginId() {
        return loginId;
    }
    public void setLoginId(String loginId) {
        this.loginId = loginId;
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
    public String getCustomerMiddleName() {
        return customerMiddleName;
    }
    public void setCustomerMiddleName(String customerMiddleName) {
        this.customerMiddleName = customerMiddleName;
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
    
}
