package com.eict.sms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.eict.sms.dao.SMS_data_dao;
import com.eict.sms.entity.SMS_data_entity;

@Service
public class SMS_data_service {
	@Autowired
	SMS_data_dao sms_data_dao;
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	
	public List<SMS_data_entity> get_sms_Data(){
		
		return sms_data_dao.get_sms_data();
	}
	
	
	public void update_smsLog_success(String smsId,int smsflag ,String request, String response) {
	    String sql = "UPDATE BAS_SMS_LOG " +
	                 "SET N_SUCCESS_FLAG = ?, " +
	                 "    D_SEND_DATETIME = sysdate, " +
	                 "    V_REQUEST = ?, " +
	                 "    V_RESPONSE = ? " +
	                 "WHERE N_SMS_ID = ?";

	    jdbcTemplate.update(sql,smsflag, request, response, smsId);
	}

}
