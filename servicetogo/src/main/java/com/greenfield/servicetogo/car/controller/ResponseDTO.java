package com.greenfield.servicetogo.car.controller;

public class ResponseDTO<T> {
    private Boolean success = true;
    private String respCode = "";
    private String respMessage = "";
    private T data;
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
    public Boolean getSuccess() {
        return success;
    }
    public void setSuccess(Boolean success) {
        this.success = success;
    }
    public String getRespCode() {
        return respCode;
    }
    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }
    public String getRespMessage() {
        return respMessage;
    }
    public void setRespMessage(String respMessage) {
        this.respMessage = respMessage;
    }
    
}
