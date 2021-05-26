package com.location.tracker.locationtracker.controller;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.location.tracker.locationtracker.entity.LocationTracker;
import com.location.tracker.locationtracker.service.LocationTrackerService;

@RestController
@RequestMapping("/org/location")
public class LocationtrackerRestController {

	
	@Autowired
	private LocationTrackerService locationTrackerService;
	
	
	@GetMapping(value = "/find")
	public  List<Object[]> viewLocations(@RequestParam("nic")String nic, Model model) {
		
		
		ArrayList<LocationTracker> locationList =  (ArrayList<LocationTracker>) locationTrackerService.findLocationsByNic(nic);
		
		ArrayList<Object[]> response = new ArrayList<Object[]>();
		
		for (int i = 0; i < locationList.size(); i++) {
			Object[] location = {String.valueOf(locationList.get(i).getLocationDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))) , locationList.get(i).getLatitudes() , locationList.get(i).getLongitudes(), i};
			
			response.add(location);
		}
		
	 return response;
	}

}
