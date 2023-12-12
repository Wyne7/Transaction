package com.mit.transcation.serviceInterface;

import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.mit.transcation.dto.ResponseDTO;

public interface FileReadServiceInterface {
	public Optional<ResponseDTO> fileRead(MultipartFile file);
}
