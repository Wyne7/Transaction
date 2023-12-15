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
@Table(name = "firstfile")
public class FirstFile implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "syskey")
	private Long syskey;

	@Column(name = "panid", nullable = false)
	private String panId;

	@Column(name = "accnumber", nullable = false)
	private String accNumber;

	@Column(name = "todaydate", nullable = false)
	private LocalDate todaydate;

	@Column(name = "filename", nullable = false)
	private String filename;

}
