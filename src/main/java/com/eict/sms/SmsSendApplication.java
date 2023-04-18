package com.eict.sms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SmsSendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmsSendApplication.class, args);
	}

}
