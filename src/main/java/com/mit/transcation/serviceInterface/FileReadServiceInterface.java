package com.mit.transcation.serviceInterface;

import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.mit.transcation.dto.ResponseDTO;

public interface FileReadServiceInterface {
	public Optional<ResponseDTO> fileRead(List<MultipartFile> file);
}
