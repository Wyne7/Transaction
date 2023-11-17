package com.mit.transcation.serviceInterface;

import com.mit.transcation.dto.AccountDTO;
import com.mit.transcation.dto.ResponseDTO;

public interface AccountTranscatioinServiceInterface {
	
	public ResponseDTO saveAccountTranscation(AccountDTO accountDto);

}
