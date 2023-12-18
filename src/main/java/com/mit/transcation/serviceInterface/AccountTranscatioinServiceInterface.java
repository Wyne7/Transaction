package com.mit.transcation.serviceInterface;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.mit.transcation.dto.CompareDTO;
import com.mit.transcation.dto.ResponseDTO;
import com.mit.transcation.dto.TransactionRequestDTO;

public interface AccountTranscatioinServiceInterface {
	
	public Optional<ResponseDTO> saveAccountTranscation(TransactionRequestDTO accountDto);

	public List<CompareDTO> getTxnIdAndAccNumberJoin();

	Page<CompareDTO> getPaginatedResults(int page, int size);
	
	

}
