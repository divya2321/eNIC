package com.eNIC.drp.api.eNICdrpAPI.eniccontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eNIC.drp.api.eNICdrpAPI.enicentity.DRPCommonEntity;
import com.eNIC.drp.api.eNICdrpAPI.enicservices.CommonServices;
import com.eNIC.drp.api.eNICdrpAPI.exception.ResourceNotFoundException;
import com.eNIC.drp.api.eNICdrpAPI.exception.ResourceNotSavedException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "DRP Endpoints", description = "Register, Find All and Find NIC details", tags = {"DRPEndpoints"})
@RestController
@RequestMapping("/api/drp")
public class CommonController {
	
	@Autowired
	private CommonServices commonService;
	
	@ApiOperation(value = "Register Person")
	@PostMapping(value = "/registerperson",  produces = {"application/json", "application/xml"}, 
				consumes = {"application/json", "application/xml"})
	public DRPCommonEntity registerPerson(@RequestBody DRPCommonEntity drpCommonEntity)throws Exception {
		
		DRPCommonEntity commonEntity= commonService.commonCreate(drpCommonEntity);
		if (commonEntity==null) {
			throw new ResourceNotSavedException("The data are not saved properly");
		}
		return commonEntity;
	} 
	
	@ApiOperation(value = "Search All NICs details")
	@GetMapping(value = "/findall", produces = {"application/json", "application/xml"})
	public List<DRPCommonEntity> getAll()throws Exception{
		
		List<DRPCommonEntity> commonEntities = commonService.commonFindAllNicDetail();
		if (commonEntities.size() == 0) {
			throw new ResourceNotFoundException("No records for the requested data");			
		}
		return commonEntities;
	}
	
	
	@ApiOperation(value = "Search details of a NIC")
	@GetMapping(value = "/findbynic", produces = {"application/json", "application/xml"})
	public List<DRPCommonEntity> getNIC(@RequestParam("nic") String nic)throws Exception{
		
		List<DRPCommonEntity> commonEntities = commonService.commonFindNicDetail(nic);
		if (commonEntities.size()==0) {
			throw new ResourceNotFoundException("No records for the requested data");
		}
		return commonEntities;
	}

}
