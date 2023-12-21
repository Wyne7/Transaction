package com.mit.transcation.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class RequestDTO implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	private int page;
	private int size;	
	}
