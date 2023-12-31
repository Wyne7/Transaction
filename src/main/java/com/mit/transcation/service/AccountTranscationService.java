package com.mit.transcation.service;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mit.transcation.dto.CompareDTO;
import com.mit.transcation.dto.RequestDTO;
import com.mit.transcation.dto.ResponseDTO;
import com.mit.transcation.dto.TransactionRequestDTO;
import com.mit.transcation.repository.AccountTranscationRepository;
import com.mit.transcation.repository.FirstFileRepository;
import com.mit.transcation.serviceInterface.AccountTranscatioinServiceInterface;

import jakarta.transaction.Transactional;

@Service
public class AccountTranscationService implements AccountTranscatioinServiceInterface {

	@Autowired
	private AccountTranscationRepository accountTranscationRepository;
	@Autowired
	private FirstFileRepository firstFileRepository;

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
			Double balance=accountTranscationRepository.getBalanceByAccNumber(requestDTO.getFromaccnumber());
			
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
	
	@Override
	  public Page<CompareDTO> getPaginatedResults(RequestDTO dto) {
	        Pageable pageable = PageRequest.of(dto.getPage(), dto.getSize());
	        return firstFileRepository.getTxnIdAndAccNumberJoin(pageable);
	    }
	  
	@Override
	  public List<CompareDTO> getTxnIdAndAccNumberJoin() {
	        return firstFileRepository.getTxnIdAndAccNumberJoin();
	    }

}
