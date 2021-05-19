package com.eNIC.health.API.eNIChealthAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.eNIC.health.API.eNIChealthAPI.entity.HealthRecord;


public interface HealthRecordRepository extends JpaRepository<HealthRecord, Integer> {
	
	
	@Query("SELECT hrh FROM HealthRecord hrh INNER JOIN GeneralDetail gdh   \r\n"
			+ "	ON \r\n"
			+ "	gdh.idGeneralDetail = hrh.idGeneralDetail \r\n"
			+ " where gdh.idGeneralDetail = :idGeneralDetail")
		public List<HealthRecord> getHealthRecordById(int idGeneralDetail);
	

}
