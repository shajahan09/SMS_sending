package com.eict.sms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.eict.sms.entity.SMS_data_entity;

@Repository
public interface SMS_data_dao extends JpaRepository<SMS_data_entity, Long>{

	@Query(value = "select * from VW_SMS_PENDING_LIST "
			+ "order by N_SMS_ID asc", nativeQuery = true)
	public List<SMS_data_entity> get_sms_data();
}
