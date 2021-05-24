package com.eNIC.health.API.eNIChealthAPI.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.eNIC.health.API.eNIChealthAPI.entity.AddressDetail;
import com.eNIC.health.API.eNIChealthAPI.entity.BloodType;


public interface BloodTypeRepository extends JpaRepository<AddressDetail, Integer> {
	
	
	@Query("SELECT btp FROM BloodType btp INNER JOIN GeneralDetail gdh \r\n"
			+ "ON btp.idBloodType = gdh.idBloodType WHERE gdh.idGeneralDetail = :idGeneralDetail") 
	public BloodType getPersonBloodType(int idGeneralDetail);
	
	
	@Query("SELECT btp FROM BloodType btp WHERE btp.bloodType = :bloodType") 
	public BloodType getBloodType(String bloodType);
	
}
