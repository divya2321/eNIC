package com.location.tracker.locationtracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.location.tracker.locationtracker.entity.GeneralDetail;

public interface GeneralDetailRepository extends JpaRepository<GeneralDetail, Integer> {

	@Query("SELECT gdp FROM GeneralDetail gdp WHERE nicStatus = true and gdp.nicNo = :nicNo") 
	public GeneralDetail findByNic(String nicNo);
	
}
