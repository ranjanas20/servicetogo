package com.greenfield.servicetogo.car.service;

import static com.greenfield.servicetogo.car.service.DataConvertUtil.DEFAULT_TENANT;
import static com.greenfield.servicetogo.car.service.DataConvertUtil.setAuditableMODIFY;
import static com.greenfield.servicetogo.car.service.DataConvertUtil.setAuditableNEW;
import static com.greenfield.servicetogo.car.service.DataConvertUtil.toLocalDateTime;

import java.util.Set;

import com.greenfield.servicetogo.car.dto.CustomerProfileDTO;
import com.greenfield.servicetogo.car.dto.RoleDTO;
import com.greenfield.servicetogo.car.dto.UserCredentialDTO;
import com.greenfield.servicetogo.car.dto.ZipLookupDTO;
import com.greenfield.servicetogo.car.entity.CustomerEntity;
import com.greenfield.servicetogo.car.entity.RoleEntity;
import com.greenfield.servicetogo.car.entity.UserCredentialEntity;
import com.greenfield.servicetogo.car.entity.ZipLookupEntity;

public class UserDTOtoEntityMap {
    public static UserCredentialEntity toNewUserCredentialEntity(UserCredentialDTO dto){
        UserCredentialEntity entity = new UserCredentialEntity();
        entity.setTenantId(DEFAULT_TENANT);
        entity.setLoginId(dto.getLoginId());
        entity.setLoginPassword(dto.getLoginPassword());
        entity.setUserType("customer");
        entity.setSecretQuestion1CodeId(dto.getSecretQuestion1CodeId());
        entity.setSecretQuestion2CodeId(dto.getSecretQuestion2CodeId());
        entity.setSecretAnswer1(dto.getSecretAnswer1());
        entity.setSecretAnswer2(dto.getSecretAnswer2());
        setAuditableNEW(entity);
        return entity;        
    }
    public static void setToCredentialEntity(UserCredentialEntity entity,UserCredentialDTO dto){
        entity.setTenantId(DEFAULT_TENANT);
        entity.setLoginId(dto.getLoginId());
        entity.setLoginPassword(dto.getLoginPassword());
        entity.setUserType("customer");
        entity.setSecretQuestion1CodeId(dto.getSecretQuestion1CodeId());
        entity.setSecretQuestion2CodeId(dto.getSecretQuestion2CodeId());
        entity.setSecretAnswer1(dto.getSecretAnswer1());
        entity.setSecretAnswer2(dto.getSecretAnswer2());
        setAuditableMODIFY(entity);
    }
    public static CustomerEntity toNewCustomerEntity(UserCredentialDTO dto){
        CustomerEntity entity = new CustomerEntity();
        entity.setTenantId(DEFAULT_TENANT);
        entity.setLoginId(dto.getLoginId());
        entity.setEmail(dto.getEmail());
        setAuditableNEW(entity);
        return entity;
        
    }
    public static CustomerEntity updateCustomerEntity(CustomerEntity entity, CustomerProfileDTO dto){
        entity.setEmail(dto.getEmail());
        entity.setCustomerFirstName(dto.getCustomerFirstName());
        entity.setCustomerMiddleName(dto.getCustomerMiddleName());
        entity.setCustomerLastName(dto.getCustomerLastName());
        entity.setCustomerPhone(dto.getCustomerPhone());
        entity.setAddressLine1(dto.getAddressLine1());
        entity.setAddressLine2(dto.getAddressLine2());
        entity.setAddressCity(dto.getAddressCity());
        entity.setAddressState(dto.getAddressState());
        entity.setAddressZip(dto.getAddressZip());
        setAuditableMODIFY(entity);
        return entity;
        
    }
    public static CustomerProfileDTO toCustomerProfileDTO(CustomerEntity entity){
        CustomerProfileDTO dto = new CustomerProfileDTO();
        dto.setCustomerId(entity.getCustomerId());
        dto.setEmail(entity.getEmail());
        dto.setLoginId(entity.getLoginId());
        dto.setCustomerFirstName(entity.getCustomerFirstName());
        dto.setCustomerMiddleName(entity.getCustomerMiddleName());
        dto.setCustomerLastName(entity.getCustomerLastName());
        dto.setCustomerPhone(entity.getCustomerPhone());
        dto.setAddressLine1(entity.getAddressLine1());
        dto.setAddressLine2(entity.getAddressLine2());
        dto.setAddressCity(entity.getAddressCity());
        dto.setAddressState(entity.getAddressState());
        dto.setAddressZip(entity.getAddressZip());
        dto.setUpdatedOn(toLocalDateTime(entity.getUpdatedOn()));
        dto.setCreatedOn(toLocalDateTime(entity.getCreatedOn()));
        dto.setUpdatedBy("admin");
        dto.setCreatedBy("admin");
        return dto;
    }
    
    public static ZipLookupDTO toZipLookupDTO(ZipLookupEntity entity){
    	ZipLookupDTO dto = new ZipLookupDTO();
        dto.setCity(entity.getCity());
        dto.setStateName(entity.getStatesEntity().getStateName());
        dto.setStateCode(entity.getStatesEntity().getStateCode());
        return dto;
    }
    
    public static RoleDTO toRoleDTO(RoleEntity roleEntity){
    	RoleDTO dto = new RoleDTO();
        dto.setRoleName(roleEntity.getRoleName());
        dto.setRoleDescription(roleEntity.getRoleDescription());
        return dto;
    }
}
