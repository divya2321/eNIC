package com.eNIC.financialinstitution.API.eNICfinancialinstitutionAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.eNIC.financialinstitution.API.eNICfinancialinstitutionAPI.entity.CommonGeneralDetail;
import com.eNIC.financialinstitution.API.eNICfinancialinstitutionAPI.exception.ResourceNotFoundException;
import com.eNIC.financialinstitution.API.eNICfinancialinstitutionAPI.service.FinanceService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Financial Endpoints", description = "Personal Details Find by NIC", tags = {
		"Financial Endpoints" })
@RestController
@RequestMapping("/api/finance")
public class FinanceAPIController {

	@Autowired
	private FinanceService financeService;


	@ApiOperation(value = "Search person detail by NIC number")
	@GetMapping(value = "/viewbynic", produces = { "application/json", "application/xml" })
	public CommonGeneralDetail getPersonInfoByNic(@RequestParam("nicno") String nicno) {
		
			CommonGeneralDetail searchedPerson = financeService.getGeneralDetail(nicno);
			if (searchedPerson == null) {
				throw new ResourceNotFoundException("No person found");
			}

			return searchedPerson;
	
	}

	
}
