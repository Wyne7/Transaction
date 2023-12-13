package com.mit.transcation.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class CompareDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private String txnId;
	 private String accNumber;
	    public CompareDTO() {
	        // Default constructor
	    }

	    public CompareDTO(String txnId, String accNumber) {
	        this.txnId = txnId;
	        this.accNumber = accNumber;
	    }
	public String getTxnId() {
		return txnId;
	}
	public void setTxnId(String txnId) {
		this.txnId = txnId;
	}
	public String getAccNumber() {
		return accNumber;
	}
	public void setAccNumber(String accNumber) {
		this.accNumber = accNumber;
	}
	 
	 
}
