package com.mit.transcation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class TranscationApplication {

	public static void main(String[] args) {
		SpringApplication.run(TranscationApplication.class, args);
		
		
//		for (int i=0;i<=3;i++)
//		{
//			long syskey=AccountTranscationService.generateSyskey();
//			System.out.println("This Is syskey"+syskey);
//		}
		
	}

}
