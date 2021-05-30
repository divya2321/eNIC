package com.eNIC.police.API.eNICpoliceAPI.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.eNIC.police.API.eNICpoliceAPI.exception.ResourceNotFoundException;
import com.eNIC.police.API.eNICpoliceAPI.service.PoliceService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Police Endpoints", description = "Criminal Records Find by NIC", tags = {
		"Police Endpoints" })
@RestController
@RequestMapping("/api/police")
public class PoliceAPIController {

	@Autowired
	PoliceService policeService;


	@ApiOperation(value = "Search criminal record by NIC number")
	@GetMapping(value = "/viewbynic", produces = { "application/json", "application/xml" })
	public Map<String, Object> getPersonCrimes(@RequestParam("nicno") String nicno) {

			Map<String, Object> searchedCrimes = policeService.viewCriminalRecords(nicno);
			if (searchedCrimes.isEmpty()) {
				throw new ResourceNotFoundException("There is no person under the detail.");
			}
			return searchedCrimes;
	
	}


}
