package com.eict.sms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan("com.eict.sms") //to scan packages mentioned
@EnableScheduling
public class SmsSendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmsSendApplication.class, args);
	}

}
