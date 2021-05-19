package com.eNIC.financialinstitution.API.eNICfinancialinstitutionAPI.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.eNIC.financialinstitution.API.eNICfinancialinstitutionAPI.entity.GeneralDetail;

public interface GeneralDetailRepository extends JpaRepository<GeneralDetail, Integer> {

	@Query("SELECT gdp FROM GeneralDetail gdp WHERE nicStatus = true and gdp.nicNo = :nicNo") 
	public GeneralDetail findByNic(String nicNo);
	
	@Query("SELECT gdp FROM GeneralDetail gdp where nicStatus = true and gdp.fingerprint = :fingerprint") 
	public GeneralDetail findByFingerprint(String fingerprint);
	
}
