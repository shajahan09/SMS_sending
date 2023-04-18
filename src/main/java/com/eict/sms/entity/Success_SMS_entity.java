//package com.eict.sms.entity;
//
//import java.io.Serializable;
//import java.util.Date;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
//
//@Entity
//@Table(name = "BAS_SMS_LOG")
//public class Success_SMS_entity implements Serializable{
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//
//	
//		@Id
//	    @GeneratedValue(strategy = GenerationType.IDENTITY)
//	    @Column(name = "N_SMS_ID")
//	    private Long smsId;
//
//	    @Column(name = "N_SUCCESS_FLAG")
//	    private Integer successFlag;
//
//	    @Column(name = "D_SEND_DATETIME")
//	    private Date sendDatetime;
//
//	    @Column(name = "V_REQUEST")
//	    private String request;
//
//	    @Column(name = "V_RESPONSE")
//	    private String response;
//
//		public Long getSmsId() {
//			return smsId;
//		}
//
//		public void setSmsId(Long smsId) {
//			this.smsId = smsId;
//		}
//
//		public Integer getSuccessFlag() {
//			return successFlag;
//		}
//
//		public void setSuccessFlag(Integer successFlag) {
//			this.successFlag = successFlag;
//		}
//
//		public Date getSendDatetime() {
//			return sendDatetime;
//		}
//
//		public void setSendDatetime(Date sendDatetime) {
//			this.sendDatetime = sendDatetime;
//		}
//
//		public String getRequest() {
//			return request;
//		}
//
//		public void setRequest(String request) {
//			this.request = request;
//		}
//
//		public String getResponse() {
//			return response;
//		}
//
//		public void setResponse(String response) {
//			this.response = response;
//		}
//	    
//	    
//
//}
