
package com.mit.transcation.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "account_transaction")
public class AccountTransaction implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "syskey")
	private Long syskey;

	@Column(nullable = false)
	private String transref;

	@Column(name = "transno")
	private Long transno;

	@Column
	private String branchcode = "";

	@Column
	private String workstation = "Mobile";

	@Column(nullable = false)
	private String tellerid;

	@Column(nullable = false)
	private String supervisorid;

	@Column
	private Date transtime;

	@Column
	private Date transdate;

	@Column
	private Date effectivedate;

	@Column(nullable = false)
	private String dr_accnumber;

	@Column(nullable = false)
	private String cr_accnumber;

	@Column(nullable = false)
	private BigDecimal dr_amount = BigDecimal.ZERO;

	@Column(nullable = false)
	private BigDecimal cr_amount = BigDecimal.ZERO;

	@Column(name = "dr_transtype")
	private int dr_transtype = 0;

	@Column(name = "cr_transtype")
	private int cr_transtype = 0;

	@Column
	private String dr_description = "";

	@Column
	private String cr_description = "";

	@Column
	private String chequeno = "";

	@Column
	private String basecurcode = "MMK";

	@Column
	private String trcurcode = "MMK";

	@Column(name = "basecurrate")
	private int basecurrate = 1;

	@Column(name = "trcurrate")
	private int trcurrate = 1;

	@Column(name = "dr_prevbalance")
	private BigDecimal dr_prevbalance = BigDecimal.ZERO;

	@Column(name = "cr_prevbalance")
	private BigDecimal cr_prevbalance = BigDecimal.ZERO;

	@Column
	private Date dr_prevupdate;

	@Column
	private Date cr_prevupdate;

	@Column
	private int status = 1;

	@Column
	private String remark = "";

	@Column
	private int systemcode = 0;

	@Column
	private String accref = "";

	@Column
	private String subref = "";

	@Column
	private Date createdate;
	@Column
	private Date updatedate;
	// Constructors, getters, and setters
}
