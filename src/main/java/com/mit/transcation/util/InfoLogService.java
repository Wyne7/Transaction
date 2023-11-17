package com.mit.transcation.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class InfoLogService {
	private static final Logger logger = LoggerFactory.getLogger(InfoLogService.class);
	
	public static void log(String logText) {
		logger.info(logText);
	}
}
