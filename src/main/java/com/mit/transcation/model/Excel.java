package com.mit.transcation.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "excelfile")
public class Excel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "syskey")
	private Long syskey;

	@Column(name = "txnid", nullable = false)
	private String txnId;

	@Column(name = "tin", nullable = false)
	private String tId;
	
	@Column(name = "todaydate", nullable = false)
	private LocalDate todaydate;

	@Column(name = "filename", nullable = false)
	private String filename;



}
