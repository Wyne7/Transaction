package com.mit.transcation.dto;

import java.io.Serializable;

public class TransactionRequestDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String fromaccnumber;
	private String toaccnumber;
	private double amount=0.0;
	private String branchcode;
	private long syskey;
	public String getFromaccnumber() {
		return fromaccnumber;
	}

	public void setFromaccnumber(String fromaccnumber) {
		this.fromaccnumber = fromaccnumber;
	}

	

	public String getToaccnumber() {
		return toaccnumber;
	}

	public void setToaccnumber(String toaccnumber) {
		this.toaccnumber = toaccnumber;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getBranchcode() {
		return branchcode;
	}

	public void setBranchcode(String branchcode) {
		this.branchcode = branchcode;
	}

	public long getSyskey() {
		return syskey;
	}

	public void setSyskey(long syskey) {
		this.syskey = syskey;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
}
