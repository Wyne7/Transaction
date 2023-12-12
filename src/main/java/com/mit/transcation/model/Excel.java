package com.mit.transcation.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="excelfile")
public class Excel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	 @Column(name = "syskey")
   private Long syskey;
	
	 @Column(name = "txnid",nullable = false)
	    private String txnId;

	 
	 @Column(name="tin",nullable = false)
	    private String tId;


	public Long getSyskey() {
		return syskey;
	}


	public void setSyskey(Long syskey) {
		this.syskey = syskey;
	}


	public String getTxnId() {
		return txnId;
	}


	public void setTxnId(String txnId) {
		this.txnId = txnId;
	}


	public String gettId() {
		return tId;
	}


	public void settId(String tId) {
		this.tId = tId;
	}


}
