package com.greenfield.servicetogo.car.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="user_role")
public class UserRoleEntity extends Auditable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "user_role_id", nullable = false)
    private Integer userRoleId;
    
    @OneToOne
    @JoinColumn(name="credential_id", referencedColumnName="credential_id")
    private UserCredentialEntity credentialId;
    
    @OneToOne
    @JoinColumn(name="role_name", referencedColumnName="role_name")
    private RoleEntity role_name;
    
    @Column(name="tenant_id")
    private String tenantId;

}
