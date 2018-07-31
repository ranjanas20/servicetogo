package com.greenfield.servicetogo.car.dto;

public class UserCredentialDTO extends AuditableDTO {
    private Long credentialId;
    private String userType;
    private String tenantId;
    private String loginId;
    private String email;
    private String loginPassword;
    private String secretQuestion1CodeId;
    private String secretQuestion2CodeId;
    private String secretAnswer1;
    private String secretAnswer2;
    
   
    
    public Long getCredentialId() {
        return credentialId;
    }
    public void setCredentialId(Long credentialId) {
        this.credentialId = credentialId;
    }
    public String getUserType() {
        return userType;
    }
    public void setUserType(String userType) {
        this.userType = userType;
    }
    public String getTenantId() {
        return tenantId;
    }
    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }
    public String getLoginId() {
        return loginId;
    }
    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }
    public String getLoginPassword() {
        return loginPassword;
    }
    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }
    public String getSecretAnswer1() {
        return secretAnswer1;
    }
    public void setSecretAnswer1(String secretAnswer1) {
        this.secretAnswer1 = secretAnswer1;
    }
    public String getSecretAnswer2() {
        return secretAnswer2;
    }
    public void setSecretAnswer2(String secretAnswer2) {
        this.secretAnswer2 = secretAnswer2;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSecretQuestion1CodeId() {
        return secretQuestion1CodeId;
    }
    public void setSecretQuestion1CodeId(String secretQuestion1CodeId) {
        this.secretQuestion1CodeId = secretQuestion1CodeId;
    }
    public String getSecretQuestion2CodeId() {
        return secretQuestion2CodeId;
    }
    public void setSecretQuestion2CodeId(String secretQuestion2CodeId) {
        this.secretQuestion2CodeId = secretQuestion2CodeId;
    }
    
}
