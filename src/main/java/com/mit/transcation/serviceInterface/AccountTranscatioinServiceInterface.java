package com.mit.transcation.serviceInterface;

import java.util.Optional;

import com.mit.transcation.dto.ResponseDTO;
import com.mit.transcation.dto.TransactionRequestDTO;

public interface AccountTranscatioinServiceInterface {
	
	public Optional<ResponseDTO> saveAccountTranscation(TransactionRequestDTO accountDto);
	
	

}
