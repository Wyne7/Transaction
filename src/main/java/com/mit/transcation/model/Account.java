package com.mit.transcation.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Account implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	 @Column(name = "syskey")
    private Long syskey;

    @Column(nullable = false)
    private String accnumber;

    @Column
    private String currencycode = "MMK";

    @Column(nullable = false)
    private BigDecimal openingbalance = BigDecimal.ZERO;

    @Column
    private Date openingdate;

    @Column
    private Date closingdate;

    @Column
    private int status = 0;

    @Column
    private String drawingtype = "Individual";

    @Column(nullable = false)
    private String shortaccno;

    @Column
    private String remark = "";

    @Column
    private String branchcode = "001";

    @Column
    private int zonecode = 1;

    @Column
    private String productcode = "01";

    @Column
    private int accounttype = 1;

    @Column
    private String productgl = "1040100000000000";

    @Column
    private String cashinhandgl = "2010100000000000";

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

	public String getCurrencycode() {
		return currencycode;
	}

	public void setCurrencycode(String currencycode) {
		this.currencycode = currencycode;
	}

	public BigDecimal getOpeningbalance() {
		return openingbalance;
	}

	public void setOpeningbalance(BigDecimal openingbalance) {
		this.openingbalance = openingbalance;
	}

	public Date getOpeningdate() {
		return openingdate;
	}

	public void setOpeningdate(Date openingdate) {
		this.openingdate = openingdate;
	}

	public Date getClosingdate() {
		return closingdate;
	}

	public void setClosingdate(Date closingdate) {
		this.closingdate = closingdate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getDrawingtype() {
		return drawingtype;
	}

	public void setDrawingtype(String drawingtype) {
		this.drawingtype = drawingtype;
	}

	public String getShortaccno() {
		return shortaccno;
	}

	public void setShortaccno(String shortaccno) {
		this.shortaccno = shortaccno;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getBranchcode() {
		return branchcode;
	}

	public void setBranchcode(String branchcode) {
		this.branchcode = branchcode;
	}

	public int getZonecode() {
		return zonecode;
	}

	public void setZonecode(int zonecode) {
		this.zonecode = zonecode;
	}

	public String getProductcode() {
		return productcode;
	}

	public void setProductcode(String productcode) {
		this.productcode = productcode;
	}

	public int getAccounttype() {
		return accounttype;
	}

	public void setAccounttype(int accounttype) {
		this.accounttype = accounttype;
	}

	public String getProductgl() {
		return productgl;
	}

	public void setProductgl(String productgl) {
		this.productgl = productgl;
	}

	public String getCashinhandgl() {
		return cashinhandgl;
	}

	public void setCashinhandgl(String cashinhandgl) {
		this.cashinhandgl = cashinhandgl;
	}
    
    

}
