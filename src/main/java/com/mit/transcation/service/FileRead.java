package com.mit.transcation.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mit.transcation.dto.ResponseDTO;
import com.mit.transcation.model.Excel;
import com.mit.transcation.model.FirstFile;
import com.mit.transcation.repository.ExcelRepository;
import com.mit.transcation.repository.FirstFileRepository;
import com.mit.transcation.serviceInterface.FileReadServiceInterface;

import jakarta.transaction.Transactional;

@Service
public class FileRead implements FileReadServiceInterface {

	@Autowired
	private FirstFileRepository firstFile;
	@Autowired
	private ExcelRepository excel;

	@Transactional
	@Override
	public Optional<ResponseDTO> fileRead(List<MultipartFile> files) {
		boolean status = false;
		ResponseDTO dto = new ResponseDTO();
		for (MultipartFile file : files) {
			String originalFilename = file.getOriginalFilename();
			String filename = originalFilename;
			if (file.isEmpty()) {
				dto.setDescription("File is Empty");
				dto.setStatus(404);
				return Optional.of(dto);
			}
			if (file.getOriginalFilename().endsWith(".xlsx") || file.getOriginalFilename().endsWith(".xls")) {
				excel.deleteExcelByDate(filename);
				status = excelFile(file);
				continue;
			}
			firstFile.deleteFirstFileByDate(filename);
			status = textFile(file);
		}
		if (!status) {
			dto.setDescription("No valid files found in the list");
			dto.setStatus(400);
			return Optional.of(dto);
		}
		dto.setDescription("Success");
		dto.setStatus(200);
		return Optional.of(dto);

	}

	public boolean textFile(MultipartFile file) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
			String line;
			while ((line = br.readLine()) != null) {
				FirstFile fFile = new FirstFile();
				String[] fields = line.split("\\s+");
				if (fields.length >= 3) {
					fFile.setSyskey(AccountTranscationService.generateSyskey());
					fFile.setAccNumber(fields[2]);
					fFile.setPanId(fields[0]);
					fFile.setTodaydate(LocalDate.now());
					fFile.setFilename(file.getOriginalFilename());
					firstFile.insertFirstFile(fFile);
					// TODO: Add logic to process the fields or save them to the database
				} else if (fields.length == 2) {
					fFile.setSyskey(AccountTranscationService.generateSyskey());
					fFile.setAccNumber(fields[1]);
					fFile.setPanId(fields[0]);
					fFile.setTodaydate(LocalDate.now());
					fFile.setFilename(file.getOriginalFilename());
					firstFile.insertFirstFile(fFile);
				} else {
					// Handle the case where the line doesn't have enough fields
					System.out.println("Line does not have enough fields: " + line);
					// You may want to log this information or handle it differently
				}
			}

			return true;
		} catch (IOException e) {

			return false;
		}
	}

	public boolean excelFile(MultipartFile file) {
		
		Workbook workbook = null;
		try (InputStream inputStream = file.getInputStream()) {
			workbook = WorkbookFactory.create(inputStream);

			// Assuming you're working with the first sheet
			Sheet sheet = workbook.getSheetAt(0);
			boolean isFirstRow = true;
			for (int rowIndex = 2; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
				Row row = sheet.getRow(rowIndex);

				Excel ec = new Excel();
				// Get data from columns B and D (index 1 and 3)
				Cell cellA = row.getCell(0);
				Cell cellC = row.getCell(2);

				// Check if the cells are not null
				if (cellA != null && cellC != null) {
					String dataB = cellA.getStringCellValue();
					String dataD = cellC.getStringCellValue();

					ec.setSyskey(AccountTranscationService.generateSyskey());
					// TODO: Process or save data as needed
					ec.setTId(dataD);
					ec.setTxnId(dataB);
					ec.setTodaydate(LocalDate.now());
					ec.setFilename(file.getOriginalFilename());
					excel.insertExcel(ec);
				}
			}

			return true;
		} catch (IOException | EncryptedDocumentException e) {
			// Handle exceptions accordingly
			e.printStackTrace();

			return false;
		} finally {
			if (workbook != null) {
				try {
					workbook.close();
				} catch (IOException e) {
					e.printStackTrace();
					// Handle closing workbook exception
				}
			}
		}
	}

}
