package com.eNIC.drp.eNICdrp.controller;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestClientException;

import com.eNIC.drp.eNICdrp.entity.DRPCommonEntity;
import com.eNIC.drp.eNICdrp.entity.UserAccount;
import com.eNIC.drp.eNICdrp.service.DRPService;
@Controller
@RequestMapping("/drp")
public class DRPController {

	@Autowired
	DRPService drpService;
	
	@GetMapping("/register/person")
	public String viewRegisterNic(Model model) {
		DRPCommonEntity commonEntity = new DRPCommonEntity();
		model.addAttribute("drpEntity",commonEntity);
		return "approve_nic";
	}
	
	@PostMapping(value = "/register/process")
	public String processRegisterNic(@ModelAttribute("drpEntity") DRPCommonEntity drpCommonEntity, Model model)throws Exception {
		
		 ResponseEntity<DRPCommonEntity> theResponseEntity =  drpService.saveNic(drpCommonEntity);
			DRPCommonEntity commonEntity = new DRPCommonEntity();
			model.addAttribute("drpEntity",commonEntity);
			return "redirect:/drp/register/person";
	
	
	} 
	
	@GetMapping("/view/all/nic")
	public String viewAllNic(Model model) {
		List<DRPCommonEntity> drpEntities = drpService.findsAllNic();
		
		model.addAttribute("drpEntities", drpEntities);
		return "view_nic";
	}
	
	@GetMapping("/view/nic")
	public String viewAllNicByNic(@RequestParam("nic")String nic, Model model) throws RestClientException, URISyntaxException {
		
		List<DRPCommonEntity> drpEntities = drpService.findsAllNicByNic(nic);
		
		model.addAttribute("drpEntities", drpEntities);
		
		return "view_nic";
	}
	
	@GetMapping("/create/useraccount")
	public String viewCreateUserAccount(Model model) {
		
		UserAccount useraccountEntity = new UserAccount();
		
		model.addAttribute("useraccountEntity",useraccountEntity);
		
		return "create_useraccount";
	}
	
	@PostMapping(value = "/create/useraccount/process")
	public String processCreateUserAccount(@ModelAttribute("userAccountEntity") UserAccount userAccount, Model model)throws Exception {
		
		 	String theResponse =  drpService.createUseraccount(userAccount);
		 	
		 	UserAccount useraccountEntity = new UserAccount();
			model.addAttribute("useraccountEntity",useraccountEntity);
			
			model.addAttribute("token", theResponse);
			
			return "create_useraccount";
	
	
	} 
	
}
