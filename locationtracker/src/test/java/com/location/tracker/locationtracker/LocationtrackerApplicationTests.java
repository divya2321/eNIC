package com.location.tracker.locationtracker;

import java.net.URISyntaxException;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestClientException;

import com.location.tracker.locationtracker.entity.CommonLocationTracker;
import com.location.tracker.locationtracker.entity.GeneralDetail;
import com.location.tracker.locationtracker.entity.LocationTracker;
import com.location.tracker.locationtracker.service.LocationTrackerService;

@SpringBootTest
class LocationtrackerApplicationTests {

	@Autowired
	private LocationTrackerService locationTrackerService;
	
	
	@Test
	void savelocationTest() throws RestClientException, URISyntaxException {
		
		CommonLocationTracker locationTracker = new CommonLocationTracker();
		locationTracker.setNicNo("196121500001");
		locationTracker.setLatitudes((float) 6.905243879241311);
		locationTracker.setLongitudes((float) 79.8676245799448);
		
		LocationTracker  response = locationTrackerService.savelocation(locationTracker);
		Assert.assertEquals("6.905244", String.valueOf(response.getLatitudes()) );
		Assert.assertEquals("79.86762", String.valueOf(response.getLongitudes()));
	}

	@Test
	void findLocationsByNicTest() throws RestClientException, URISyntaxException {
		
		List<LocationTracker>  response = locationTrackerService.findLocationsByNic("199712000001");
		Assert.assertNotNull(response);
	}
	
	
	@Test
	void findPersonTest() throws RestClientException, URISyntaxException {
		
		GeneralDetail response=	locationTrackerService.findPerson("199712000001");
		Assert.assertEquals("199712000001", response.getNicNo());
		Assert.assertEquals("Amasha Thathsarani", response.getName());
	}
	
	
}
