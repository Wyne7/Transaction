package com.mit.transcation.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mit.transcation.dto.ResponseDTO;
import com.mit.transcation.dto.TransactionRequestDTO;
import com.mit.transcation.serviceInterface.AccountTranscatioinServiceInterface;

@RestController
@RequestMapping("/api/v1")
public class TransactionController {

    @Autowired
    private AccountTranscatioinServiceInterface serviceInterface;

    @PostMapping("/saveTransaction")
    public  Optional<ResponseDTO>saveAccountTranscation(@RequestBody TransactionRequestDTO accountDTO){
         
        return serviceInterface.saveAccountTranscation(accountDTO);
    }
    
    
    
    
}