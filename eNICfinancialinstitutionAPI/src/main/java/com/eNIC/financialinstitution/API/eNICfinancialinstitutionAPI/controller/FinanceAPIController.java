package com.eNIC.financialinstitution.API.eNICfinancialinstitutionAPI.controller;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eNIC.financialinstitution.API.eNICfinancialinstitutionAPI.entity.CommonGeneralDetail;
import com.eNIC.financialinstitution.API.eNICfinancialinstitutionAPI.service.FinanceService;


@RestController
@RequestMapping("/api/finance")
public class FinanceAPIController {

	@Autowired
	FinanceService financeService;
	
	
	@GetMapping(value = "/viewbynic")
	public CommonGeneralDetail getPersonCrimes1(){
		System.out.println("Call");
		CommonGeneralDetail searchedCrimes = financeService.getGeneralDetail("199712000001", "nicno");
		return searchedCrimes;
	}
	
	
	@GetMapping(value = "/viewbyfingerprint2")
	public CommonGeneralDetail getPersonFCrimes(){
		System.out.println("Call");
		CommonGeneralDetail searchedCrimes = financeService.getGeneralDetail("199712000001", "fingerprint");
		return searchedCrimes;
	}
}
