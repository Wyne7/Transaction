package com.mit.transcation.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mit.transcation.dto.ResponseDTO;
import com.mit.transcation.model.FirstFile;
import com.mit.transcation.repository.FirstFileRepository;
import com.mit.transcation.serviceInterface.FileReadServiceInterface;

import jakarta.transaction.Transactional;

@Service
public class FileRead implements FileReadServiceInterface{

	@Autowired
	private  FirstFileRepository firstFile;
	
	@Override
	@Transactional
    public Optional<ResponseDTO> fileRead(MultipartFile file) {
        ResponseDTO dto = new ResponseDTO();
        FirstFile fFile=new FirstFile();
        if (file.isEmpty()) {
            dto.setDescription("File is Empty");
            dto.setStatus(404);
            return Optional.of(dto);
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split("\\s+");

                if (fields.length >=2) {
                	fFile.setSyskey(AccountTranscationService.generateSyskey());
                	fFile.setAccNumber(fields[0]);
                	fFile.setPanId(fields[1]);
                    
                	firstFile.InsertFirstFile(fFile);
                    // TODO: Add logic to process the fields or save them to the database
                } 
                else if(fields.length>=3)
                {
                	fFile.setSyskey(AccountTranscationService.generateSyskey());
                	fFile.setAccNumber(fields[1]);
                	fFile.setPanId(fields[2]);
                    
                	firstFile.InsertFirstFile(fFile);
                }
                	else {
                    // Handle the case where the line doesn't have enough fields
                    System.out.println("Line does not have enough fields: " + line);
                }
            }

            dto.setDescription("File Read Successfully");
            dto.setStatus(200);
            return Optional.of(dto);

        } catch (IOException e) {
            dto.setDescription("Error reading the file");
            dto.setStatus(500);
            return Optional.of(dto);
        }

    }

	
}
