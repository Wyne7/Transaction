package com.mit.transcation.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="firstfile")
public class FirstFile implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	 @Column(name = "syskey")
    private Long syskey;
	
	 @Column(name = "panid",nullable = false)
	    private String panId;

	 
	 @Column(name="accnumber",nullable = false)
	    private String accNumber;


	public Long getSyskey() {
		return syskey;
	}


	public void setSyskey(Long syskey) {
		this.syskey = syskey;
	}


	public String getPanId() {
		return panId;
	}


	public void setPanId(String panId) {
		this.panId = panId;
	}


	public String getAccNumber() {
		return accNumber;
	}


	public void setAccNumber(String accNumber) {
		this.accNumber = accNumber;
	}
	 
	 


	
}
