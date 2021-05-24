package com.eNIC.judicial.API.eNICjudicialAPI.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.eNIC.judicial.API.eNICjudicialAPI.entity.GeneralDetail;

public interface GeneralDetailRepository extends JpaRepository<GeneralDetail, Integer> {

	@Query("SELECT gdp FROM GeneralDetail gdp WHERE nicStatus = true and gdp.nicNo = :nicNo") 
	public GeneralDetail findByNic(String nicNo);
	
	@Query("SELECT gdp FROM GeneralDetail gdp WHERE gdp.nicNo = :nicNo") 
	public List<GeneralDetail> findPersonAll(String nicNo);
	
	@Query("SELECT gdp FROM GeneralDetail gdp where gdp.fingerprint = :fingerprint") 
	public GeneralDetail findByFingerprint(String fingerprint);
	
	@Query("SELECT gdp FROM GeneralDetail gdp WHERE gdp.fingerprint = :fingerprint") 
	public List<GeneralDetail> findPersonFinAll(String fingerprint);
	
}
