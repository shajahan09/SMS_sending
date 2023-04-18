package com.eict.sms.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "VW_SMS_PENDING_LIST")
public class SMS_data_entity {
	
	@Id
	@Column(name = "N_SMS_ID")
    private Long sms_id;
		
	@Column(name = "V_PROCESS_NAME")
    private String process_name;
		
	@Column(name = "V_RECIPIENT_INFO")
    private String recepient_info;
	
	@Column(name = "V_RECEPIENT_MOBILE_NO")
    private String recepient_mobile;
	
	@Column(name = "V_CONTENT")
    private String content;
	
	@Column(name = "N_SIZE")
    private String size;
	
	@Column(name = "N_SMS_COUNT")
    private String sms_count;
	
	@Column(name = "N_COST_PER_SMS")
    private String cost_per_sms;
	
	@Column(name = "N_NET_COST")
    private String net_const;

	public Long getSms_id() {
		return sms_id;
	}

	public void setSms_id(Long sms_id) {
		this.sms_id = sms_id;
	}

	public String getProcess_name() {
		return process_name;
	}

	public void setProcess_name(String process_name) {
		this.process_name = process_name;
	}

	public String getRecepient_info() {
		return recepient_info;
	}

	public void setRecepient_info(String recepient_info) {
		this.recepient_info = recepient_info;
	}

	public String getRecepient_mobile() {
		return recepient_mobile;
	}

	public void setRecepient_mobile(String recepient_mobile) {
		this.recepient_mobile = recepient_mobile;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getSms_count() {
		return sms_count;
	}

	public void setSms_count(String sms_count) {
		this.sms_count = sms_count;
	}

	public String getCost_per_sms() {
		return cost_per_sms;
	}

	public void setCost_per_sms(String cost_per_sms) {
		this.cost_per_sms = cost_per_sms;
	}

	public String getNet_const() {
		return net_const;
	}

	public void setNet_const(String net_const) {
		this.net_const = net_const;
	}

	@Override
	public String toString() {
		return "SMS_data_entity [sms_id=" + sms_id + ", process_name=" + process_name + ", recepient_info="
				+ recepient_info + ", recepient_mobile=" + recepient_mobile + ", content=" + content + ", size=" + size
				+ ", sms_count=" + sms_count + ", cost_per_sms=" + cost_per_sms + ", net_const=" + net_const + "]";
	}
	
	

}
