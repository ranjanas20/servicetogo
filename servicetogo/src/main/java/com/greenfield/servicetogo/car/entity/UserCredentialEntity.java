package com.greenfield.servicetogo.car.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_credential")
public class UserCredentialEntity extends Auditable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="credential_id")
    private Integer credentialId;
    
    @Column(name="user_type")
    private String userType;
    
    @Column(name="tenant_id")
    private String tenantId;
    
    @Column(name="login_id")
    private String loginId;
    
    @Column(name="login_password")    
    private String loginPassword;

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
