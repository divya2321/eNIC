package com.location.tracker.locationtracker.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.location.tracker.locationtracker.entity.LocationTracker;

public interface LocationTrackerRepository extends JpaRepository<LocationTracker, Integer> {

	@Query("SELECT lt FROM LocationTracker lt INNER JOIN GeneralDetail gdp ON lt.idGeneralDetail = gdp.idGeneralDetail WHERE gdp.nicStatus = true and gdp.nicNo = :nicNo") 
	public List<LocationTracker> findLocationsByNic(String nicNo);
	
}
