package com.mit.transcation.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class CompareDTO implements Serializable{

	private static final long serialVersionUID = 1L;
    // Fields from FirstFile
    private Long firstFileSyskey;
    private String firstFilePanId;
    private String firstFileAccNumber;

    // Fields from Excel
    private Long excelSyskey;
    private String excelTxnId;
    private String excelTId;

    public CompareDTO() {
        // Default constructor
    }

    public CompareDTO(Long firstFileSyskey, String firstFilePanId, String firstFileAccNumber, Long excelSyskey, String excelTxnId, String excelTId) {
        this.firstFileSyskey = firstFileSyskey;
        this.firstFilePanId = firstFilePanId;
        this.firstFileAccNumber = firstFileAccNumber;
        this.excelSyskey = excelSyskey;
        this.excelTxnId = excelTxnId;
        this.excelTId = excelTId;
    }


    
	 
}
