package com.eNIC.drp.api.eNICdrpAPI.eniccontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eNIC.drp.api.eNICdrpAPI.enicentity.DRPCommonEntity;
import com.eNIC.drp.api.eNICdrpAPI.enicservices.CommonServices;

@RestController
@RequestMapping("/registerperson")
public class CommonController {
	
	@Autowired
	private CommonServices commonService;
	
	@PostMapping
	public DRPCommonEntity registerPerson(@RequestBody DRPCommonEntity drpCommonEntity) {
		return commonService.commonCreate(drpCommonEntity);
	} 
	
	@GetMapping("/alldetail")
	public List getAll(){
		return commonService.commonFindAllNicDetail();
	}

}
