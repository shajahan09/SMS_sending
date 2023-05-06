package com.eict.sms.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.eict.sms.entity.SMS_data_entity;
import com.eict.sms.service.SMS_data_service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


@Component
public class Background_main_controller {
	
	@Autowired
	SMS_data_service sms_data_service;
	private int count = 0;
	
	private String ending = "&msg=";
	private final String API_URL = "https://sms.prodata.com.bd/index.php?app=ws&u=uniaid&h=6a4e2030b075e64796dab7ff31f54ace&op=pv&to=88";
	private RestTemplate restTemplate = new RestTemplate();
	private String response_data = null;
	private String main_api = null;
	
	 
	// @Scheduled(fixedDelay = 300000) // 5 minutes in milliseconds
	 @Scheduled(fixedDelay = 2000)    // 2 seconds in milliseconds
	 public void myScheduledMethod() {
		 count++;
	        // your code here
		 System.out.println("--------calling every 2 seconds------- "+count);
		 get_sms_data(); // get db sms data
		 
	    }
	 	 
	 
		public List<SMS_data_entity> get_sms_data() { // every 5 mints call 
			List<SMS_data_entity> data =  sms_data_service.get_sms_Data();
			send_sms_number(data);
			return data;
		}
		
		public void send_sms_number(List<SMS_data_entity> data) {
			
			
			for(int i=0 ; i < data.size(); i++) {
				System.out.println("sms-id----"+data.get(i).getSms_id());
				main_api = API_URL+data.get(i).getRecepient_mobile()+ending +data.get(i).getContent();
				try {
					
					response_data = restTemplate.getForObject(main_api, String.class);
					
					JsonNode jsonNode = new ObjectMapper().readTree(response_data);
					String sms_response = jsonNode.get("data").get(0).get("error").asText();
					
					if(sms_response.equals("0")) {
						// call success == 1
						update_success_sms(String.valueOf(data.get(i).getSms_id()),1, main_api, response_data);
						main_api = null;
					}else {
						// call error/failed == 0
						update_success_sms(String.valueOf(data.get(i).getSms_id()), 0, main_api, response_data);
						main_api = null;
					}
					
					
					
					Thread.sleep(100);
				} catch (InterruptedException | JsonProcessingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
			
	
			
		}
		
		
		public String update_success_sms(String smsId,int sms_flag,String request_api,String response_api) {
		    sms_data_service.update_smsLog_success(smsId,sms_flag, request_api, response_api);
			return "success";
		}
	 

}
