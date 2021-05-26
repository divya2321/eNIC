package com.location.tracker.locationtracker.controller;


import org.apache.coyote.Response;
import org.hibernate.cfg.annotations.EntityBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.location.tracker.locationtracker.entity.CommonLocationTracker;
import com.location.tracker.locationtracker.entity.GeneralDetail;
import com.location.tracker.locationtracker.entity.LocationTracker;
import com.location.tracker.locationtracker.service.LocationTrackerService;



@Controller
@RequestMapping("/org/location")
public class LocationTrackerController {

	@Autowired
	private LocationTrackerService locationTrackerService;
	
	@GetMapping(value = "/track")
	public String locationTrack(Model model) {
		return "location_track";		
	}
	
	@GetMapping(value = "/track/find")
	public String findPerson(@RequestParam("nic")String nic, Model model) {
		
		GeneralDetail generalDetail = locationTrackerService.findPerson(nic);
		
		System.out.println(generalDetail.getName());
		
		model.addAttribute("person", generalDetail);
		
		return "location_track";		
	}
	
	@GetMapping(value = "/track/save")
	public String savelocation(@RequestParam("nic")String nic, @RequestParam("lat")float lat, @RequestParam("lon")float lon, Model model) {
		
		CommonLocationTracker locationTracker = new CommonLocationTracker();
		locationTracker.setNicNo(nic);
		locationTracker.setLatitudes(lat);
		locationTracker.setLongitudes(lon);
		LocationTracker savedlocation=	locationTrackerService.savelocation(locationTracker);
		
		if(savedlocation!=null) {
			return "redirect:/org/location/track";	
		}else {
			throw new RuntimeException("Did not save location!");
		}
			
	}
	
	@GetMapping(value = "/search")
	public String viewLocations(Model model) {
		return "view_locations";		
	}


}
