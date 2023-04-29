package com.eict.sms.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import com.eict.sms.entity.SMS_data_entity;
import com.eict.sms.entity.View_Dataget_entity;
import com.eict.sms.service.SMS_data_service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class View_main_controller {
	@Autowired
	SMS_data_service sms_service;
	@Autowired
	SMS_data_service sms_data_service;

	@RequestMapping("/")
	public String smspage() {

		return "SMSpage";
	}

	String mobile_number = null;
	private final String ending = "&msg=";
	private final String API_URL = "https://sms.prodata.com.bd/index.php?app=ws&u=uniaid&h=b5571641cc2fe72ab41de589fd02e8c5&op=pv&to=88";
	private String response = null;
	private String main_api = null;
	private RestTemplate restTemplate = new RestTemplate();

	@RequestMapping("/sendsms")
	public String sendSMS(@ModelAttribute View_Dataget_entity data,Model model) {
		main_api =API_URL + data.getMobile_number() + ending + data.getSms_text();
		response = restTemplate.getForObject(main_api, String.class);
		
		JsonNode jsonNode;
		try {
			jsonNode = new ObjectMapper().readTree(response);
			String sms_response = jsonNode.get("data").get(0).get("error").asText();
			System.out.println("------------++++ sms api+++------------"+main_api);
			
			if(sms_response.equals("0")) { // success =0; and error =1 but db send reverse.
				update_success_sms(data.getSms_id(),1,main_api,response);	
			}else {
				update_success_sms(data.getSms_id(), 0, main_api, response);	
			}
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		 return "redirect:/showLog";
	}
	
	@GetMapping("/showLog")
	public String sendSMSForm(Model model) {
		java.util.List<SMS_data_entity> all_data = sms_service.get_sms_Data();
		model.addAttribute("message", all_data);  
	    model.addAttribute("msg", response);
	    return "Message";
	}
	
	
	@GetMapping("/allsmsdata")
	public String getData(Model model) {
		java.util.List<SMS_data_entity> data = sms_service.get_sms_Data();

		model.addAttribute("message", data);
		
		return "SMSpage";
	}
	
	
	public void update_success_sms(String smsId,int sms_flag,String request_api,String response_api) {
	    sms_data_service.update_smsLog_success(smsId,sms_flag, request_api, response_api);
	
	}

}
