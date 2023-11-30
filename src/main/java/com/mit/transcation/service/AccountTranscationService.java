package com.mit.transcation.service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.mit.transcation.dto.AccountDTO;
import com.mit.transcation.dto.AccountTranscationDTO;
import com.mit.transcation.dto.RequestDTO;
import com.mit.transcation.dto.ResponseDTO;
import com.mit.transcation.kafkaService.KafkaProducer;
import com.mit.transcation.model.AccountTransactionEntity;
import com.mit.transcation.repository.AccountTranscationRepository;
import com.mit.transcation.serviceInterface.AccountTranscatioinServiceInterface;
import com.mit.transcation.util.InfoLogService;

import jakarta.transaction.Transaction;
import jakarta.transaction.Transactional;

@Service
public class AccountTranscationService implements AccountTranscatioinServiceInterface {

	@Autowired
	private AccountTranscationRepository accountTranscationRepository;

	@Autowired
	private KafkaProducer kafkaProducer;

	@Override
	@Transactional
	public ResponseDTO saveAccountTranscation(AccountDTO requestDTO) {
		Date today = new Date();
		LocalDateTime now = LocalDateTime.now();
		Integer status = 0;
		ResponseDTO res=new ResponseDTO();
		// Create a SimpleDateFormat object to specify the desired date format
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

		// Use the format method to convert the Date object to a string
		String dateString = dateFormat.format(today);
		String timeString = now.format(timeFormatter);

		AccountTransactionEntity entity = new AccountTransactionEntity();
		entity.setAccNumber(requestDTO.getAccNumber());
		entity.setAmount(requestDTO.getAmount());
		entity.setBranchCode("001");
		entity.setChequeNo("Y");
		entity.setContraDate(dateString);
		if (status != requestDTO.getStatus()) {
			entity.setTransType(820);
			entity.setDescription("Deposit transcation" + requestDTO.getAccNumber());

		} else {
			entity.setTransType(320);
			entity.setDescription("Credit transcation" + requestDTO.getAccNumber());
		}

		entity.setEffectiveDate(dateString);
		entity.setCurrencyCode("1");
		entity.setCurrencyRate(0.00f);
		entity.setPrevBalance(0.00);
		entity.setPrevUpDate(dateString);
		entity.setRemark("Test");
		entity.setStatus(0);
		entity.setAccRef("Test");
		entity.setSerialNo(0);
		entity.setSubRef("Test");
		entity.setSupervisorId("001");
		entity.setSystemCode(0);
		entity.setTellerId("001");
		entity.setTransDate(dateString);
		entity.setTransNo(100);
		entity.setTransRef(10);
		entity.setTransTime(timeString);
		entity.setWorkStation("Yangon");
		try {
		// InfoLogService.log("Save Transcation"+entity);
		
	    if (entity.getAccNumber() != null || !entity.getAccNumber().isEmpty()) {
			accountTranscationRepository.saveTransaction(entity);
			//accountTranscationRepository.save(entity);
			res.setStatus(200);
		    res.setDescription("Success");
		}else{
            res.setStatus(500);
		    res.setDescription("Fail");
		}
		
		// InfoLogService.log("After Save Transcation"+entity);
		// String statusTranscation = "Success";
		// kafkaProducer.sendAccount(statusTranscation);
		}
		catch (Exception e) {
			//InfoLogService.log("Error Save"+e);
		}

		

		return res;
	}

}
