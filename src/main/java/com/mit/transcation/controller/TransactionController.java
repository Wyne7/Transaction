package com.mit.transcation.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mit.transcation.dto.CompareDTO;
import com.mit.transcation.dto.RequestDTO;
import com.mit.transcation.dto.ResponseDTO;
import com.mit.transcation.dto.TransactionRequestDTO;
import com.mit.transcation.serviceInterface.AccountTranscatioinServiceInterface;
import com.mit.transcation.serviceInterface.FileReadServiceInterface;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/Transcation/add-ons")
public class TransactionController {

    @Autowired
    private AccountTranscatioinServiceInterface serviceInterface;

    @Autowired
    private FileReadServiceInterface fileRead;

    @PostMapping("/saveTransaction")
    public Optional<ResponseDTO> saveAccountTranscation(@RequestBody TransactionRequestDTO accountDTO) {

        return serviceInterface.saveAccountTranscation(accountDTO);
    }

    @PostMapping("/uploadFiles")
    public Optional<ResponseDTO> handleFileUpload(@RequestParam("file") List<MultipartFile> file) {
        return fileRead.fileRead(file);
    }

    @GetMapping("/upload")
    public List<CompareDTO> getHandleFileUpload() {

        return serviceInterface.getTxnIdAndAccNumberJoin();
    }
//    @GetMapping("/paginated")
//    public Page<CompareDTO> getPaginatedData(
//            @RequestParam(name = "page", defaultValue = "1") int page,
//            @RequestParam(name = "size", defaultValue = "10") int size) {
//
//        return serviceInterface.getPaginatedResults(page, size);
//    }

  @PostMapping("/paginated")
 public Page<CompareDTO> getPaginatedData(
		 @RequestBody RequestDTO  dto) {
      return serviceInterface.getPaginatedResults(dto);
  }
}