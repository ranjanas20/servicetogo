package com.greenfield.servicetogo.car.service;

import static com.greenfield.servicetogo.car.service.DataConvertUtil.toSqlTimeStamp;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.greenfield.servicetogo.car.entity.Auditable;


public class DataConvertUtil {
    static String DEFAULT_TENANT="sys";
    static Timestamp toSqlTimeStamp(LocalDateTime dt){
        return ( dt!=null?Timestamp.valueOf(dt):null);
    }
    static Date toSqlDate(LocalDate dt){
        return ( dt!=null?Date.valueOf(dt):null);
    }
    static LocalDateTime toLocalDateTime(Timestamp dt){
        return (dt!=null?dt.toLocalDateTime():null);
    }
    static LocalDate toLocalDate(Date dt){
        return (dt!=null?dt.toLocalDate():null);
    }
    static void setAuditableNEW(Auditable entity){
        entity.setUpdatedOn(toSqlTimeStamp(LocalDateTime.now(Clock.systemUTC())));
        entity.setCreatedOn(toSqlTimeStamp(LocalDateTime.now(Clock.systemUTC())));
        entity.setUpdatedBy("admin");
        entity.setCreatedBy("admin");
    }
    static void setAuditableMODIFY(Auditable entity){
        entity.setUpdatedOn(toSqlTimeStamp(LocalDateTime.now(Clock.systemUTC())));
        entity.setUpdatedBy("admin");
    }
}
