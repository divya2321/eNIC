package com.eNIC.judicial.API.eNICjudicialAPI.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eNIC.judicial.API.eNICjudicialAPI.Service.JudicialService;
import com.eNIC.judicial.API.eNICjudicialAPI.config.JwtTokenUtil;
import com.eNIC.judicial.API.eNICjudicialAPI.entity.CommonCriminalRecord;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.eNIC.judicial.API.eNICjudicialAPI.Exception.DFileNotFoundException;
import com.eNIC.judicial.API.eNICjudicialAPI.Exception.NotAuthorizedException;
import com.eNIC.judicial.API.eNICjudicialAPI.Exception.ResourceNotSavedException;

@Api(value = "Judicial Endpoints", description = "Criminal Records Save, Find by NIC", tags = {
		"JudicialEndpoints" })
@RestController
@RequestMapping("/api/judicial")
public class JudicialAPIController {

	@Autowired
	private JudicialService judService;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	// save criminal record
	@ApiOperation(value = "Save criminal record")
	@PostMapping(value = "/save", produces = { "application/json", "application/xml" }, consumes = { "application/json",
			"application/xml" })
	public CommonCriminalRecord saveCriminalRecord(@RequestHeader(value = "Authorization") String authorization,
			@RequestBody CommonCriminalRecord commonCriminalRecord) throws Exception {

	

		String jwtToken = authorization.substring(7);
		String username = jwtTokenUtil.getUsernameFromToken(jwtToken);
	
			commonCriminalRecord.setUsername(username);
			CommonCriminalRecord cr = judService.saveCriminalRecord(commonCriminalRecord);

			if (cr != null) {
				return cr;
			} else {
				throw new ResourceNotSavedException("The record not saved properly");
			}

	}

	// view criminal record by NIC
	@ApiOperation(value = "Search criminal record by NIC number")
	@GetMapping(value = "/viewbynic", produces = { "application/json", "application/xml" })
	public Map<String, Object> getPersonCrimes(@RequestParam("nicno") String nicno) {
		

			Map<String, Object> searchedCrimes = judService.viewCriminalRecords(nicno);

			if (searchedCrimes.isEmpty()) {
				throw new DFileNotFoundException("There are no searched person with the NIC number");
			}
			return searchedCrimes;



	}


}
