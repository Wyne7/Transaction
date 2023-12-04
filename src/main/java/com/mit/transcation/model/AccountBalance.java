package com.mit.transcation.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class AccountBalance implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	 @Column(name = "syskey")
    private Long syskey;

    @Column(nullable = false)
    private String accnumber;

    @Column(nullable = false)
    private BigDecimal currentbalance = BigDecimal.ZERO;

    @Column
    private Date lastupdate;

    @Column
    private Date lasttransdate;

	public Long getSyskey() {
		return syskey;
	}

	public void setSyskey(Long syskey) {
		this.syskey = syskey;
	}

	public String getAccnumber() {
		return accnumber;
	}

	public void setAccnumber(String accnumber) {
		this.accnumber = accnumber;
	}

	public BigDecimal getCurrentbalance() {
		return currentbalance;
	}

	public void setCurrentbalance(BigDecimal currentbalance) {
		this.currentbalance = currentbalance;
	}

	public Date getLastupdate() {
		return lastupdate;
	}

	public void setLastupdate(Date lastupdate) {
		this.lastupdate = lastupdate;
	}

	public Date getLasttransdate() {
		return lasttransdate;
	}

	public void setLasttransdate(Date lasttransdate) {
		this.lasttransdate = lasttransdate;
	}
    
    

}
