package com.mit.transcation.dto;

import java.io.Serializable;

public class ResponseDTO implements Serializable{

    private static final long serialVersionUID = 1L;

    private Integer status;
    private String description;
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    
    
}
