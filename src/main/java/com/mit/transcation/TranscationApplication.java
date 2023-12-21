package com.mit.transcation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.boot.builder.SpringApplicationBuilder;
@SpringBootApplication
public class TranscationApplication extends SpringBootServletInitializer{

	 @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(TranscationApplication.class);
	    }
	public static void main(String[] args) {
		SpringApplication.run(TranscationApplication.class, args);
		
		
//		for (int i=0;i<=3;i++)
//		{
//			long syskey=AccountTranscationService.generateSyskey();
//			System.out.println("This Is syskey"+syskey);
//		}
		
	}

}
