package com.greenfield.servicetogo.car.controller;

import java.util.List;

public class SearchResponseDTO<T> {
    private Boolean success = true;
    private String respCode = "";
    private String respMessage = "";
    private Integer pageNumber;
    private Long totalPapges;
    private List<T> data;
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
    public Integer getPageNumber() {
        return pageNumber;
    }
    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }
    public Long getTotalPapges() {
        return totalPapges;
    }
    public void setTotalPapges(Long totalPapges) {
        this.totalPapges = totalPapges;
    }
    public List<T> getData() {
        return data;
    }
    public void setData(List<T> data) {
        this.data = data;
    }
    
}
