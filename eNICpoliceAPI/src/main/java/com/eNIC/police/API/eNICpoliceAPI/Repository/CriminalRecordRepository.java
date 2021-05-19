package com.eNIC.police.API.eNICpoliceAPI.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.eNIC.police.API.eNICpoliceAPI.entity.CriminalRecord;


public interface CriminalRecordRepository extends JpaRepository<CriminalRecord, Integer> {
	
	
	@Query("SELECT crj, gdj FROM CriminalRecord crj INNER JOIN GeneralDetail gdj   \r\n"
			+ "	ON \r\n"
			+ "	gdj.idGeneralDetail = crj.idGeneralDetail \r\n"
			+ " where gdj.idGeneralDetail = :idGeneralDetail")
		public List<CriminalRecord> getCriminalRecordById(int idGeneralDetail);

}
