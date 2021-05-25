package com.location.tracker.locationtracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.location.tracker.locationtracker.entity.CommonLocationTracker;
import com.location.tracker.locationtracker.entity.GeneralDetail;
import com.location.tracker.locationtracker.entity.LocationTracker;
import com.location.tracker.locationtracker.repository.GeneralDetailRepository;
import com.location.tracker.locationtracker.repository.LocationTrackerRepository;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

@Service
public class LocationTrackerService {

	@Autowired
	private GeneralDetailRepository generalDetailRepository;
	
	
	@Autowired
	private LocationTrackerRepository locationTrackerRepository;
	
	public GeneralDetail findPerson(String nic) {
		return generalDetailRepository.findByNic(nic);
	}
	
    @Transactional
	public LocationTracker savelocation(CommonLocationTracker commonLocationTracker) {
		
		
		GeneralDetail generalDetail =  generalDetailRepository.findByNic(commonLocationTracker.getNicNo());
		
		LocationTracker locationTracker = new LocationTracker();
		
		locationTracker.setIdLocationTracker(0);
		locationTracker.setIdGeneralDetail(generalDetail);
		locationTracker.setLatitudes(commonLocationTracker.getLatitudes());
		locationTracker.setLongitudes(commonLocationTracker.getLongitudes());
		locationTracker.setLocationDate(LocalDateTime.now());
		
		return locationTrackerRepository.save(locationTracker);
	}
	
	public  List<LocationTracker> findLocationsByNic(String nic) {
		
	   return locationTrackerRepository.findLocationsByNic(nic);
	}
}
