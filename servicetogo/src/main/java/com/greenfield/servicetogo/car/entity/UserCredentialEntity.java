package com.greenfield.servicetogo.car.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user_credentials")
public class UserCredentialEntity extends Auditable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="credential_id")
    private Long credentialId;
    
    @Column(name="user_type")
    private String userType;
    
    @Column(name="tenant_id")
    private String tenantId;
    
    @Column(name="login_id")
    private String loginId;
    
    @Column(name="login_password")    
    private String loginPassword;
    
    @Column(name="secretquestion1_code_id") 
    private String secretQuestion1CodeId;
    
    @Column(name="secretquestion2_code_id") 
    private String secretQuestion2CodeId;
    
    @Column(name="secretanswer1") 
    private String secretAnswer1;
    
    @Column(name="secretanswer2") 
    private String secretAnswer2;
   
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(
                    name = "credential_id",
                    referencedColumnName = "credential_id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "role_name",
                    referencedColumnName = "role_name"
            )
    )
    @OneToMany
    private Set<RoleEntity> roles;

    public Long getCredentialId() {
        return credentialId;
    }

    public void setCredentialId(Long credentialId) {
        this.credentialId = credentialId;
    }

    public Set<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleEntity> roles) {
        this.roles = roles;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((loginId == null) ? 0 : loginId.hashCode());
        result = prime * result + ((tenantId == null) ? 0 : tenantId.hashCode());
        result = prime * result + ((userType == null) ? 0 : userType.hashCode());
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
        UserCredentialEntity other = (UserCredentialEntity) obj;
        if (loginId == null) {
            if (other.loginId != null)
                return false;
        } else if (!loginId.equals(other.loginId))
            return false;
        if (tenantId == null) {
            if (other.tenantId != null)
                return false;
        } else if (!tenantId.equals(other.tenantId))
            return false;
        if (userType == null) {
            if (other.userType != null)
                return false;
        } else if (!userType.equals(other.userType))
            return false;
        return true;
    }
    

}
