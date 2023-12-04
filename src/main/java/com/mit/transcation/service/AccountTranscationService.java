package com.mit.transcation.service;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mit.transcation.dto.ResponseDTO;
import com.mit.transcation.dto.TransactionRequestDTO;
import com.mit.transcation.repository.AccountTranscationRepository;
import com.mit.transcation.serviceInterface.AccountTranscatioinServiceInterface;

import jakarta.transaction.Transactional;

@Service
public class AccountTranscationService implements AccountTranscatioinServiceInterface {

	@Autowired
	private AccountTranscationRepository accountTranscationRepository;

	public static long generateSyskey() {
        final UUID uid = UUID.randomUUID();
        final ByteBuffer buffer = ByteBuffer.wrap(new byte[16]);
        buffer.putLong(uid.getLeastSignificantBits());
        buffer.putLong(uid.getMostSignificantBits());
        final BigInteger bi = new BigInteger(buffer.array());
        return Math.abs(bi.longValue());
}
	@Override
	@Transactional
	public Optional<ResponseDTO> saveAccountTranscation(TransactionRequestDTO requestDTO) {
	
		ResponseDTO res=new ResponseDTO();
		try {
			double balance=accountTranscationRepository.getBalanceByAccNumber(requestDTO.getFromaccnumber());
			
			if(balance<requestDTO.getAmount())
			{
				res.setDescription("Not Enough Amount");
				res.setStatus(322);
				return Optional.of(res);
			}
			accountTranscationRepository.updateFromAccNumber(requestDTO.getFromaccnumber(),requestDTO.getAmount());
			accountTranscationRepository.updateToAccNumber(requestDTO.getToaccnumber(),requestDTO.getAmount());
			requestDTO.setSyskey(generateSyskey());
			accountTranscationRepository.insertTransaction(requestDTO);
			res.setDescription("Success Transcation");
			res.setStatus(200);
			return Optional.of(res);
			
		} catch (Exception e) {
			   e.printStackTrace();
			    res.setDescription("Fail Transaction: " + e.getMessage());
			res.setStatus(500);
			return Optional.of(res);
		}
	
	}

}
