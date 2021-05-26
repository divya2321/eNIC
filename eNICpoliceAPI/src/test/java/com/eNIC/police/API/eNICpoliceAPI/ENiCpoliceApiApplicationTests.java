package com.eNIC.police.API.eNICpoliceAPI;

import java.util.Map;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.eNIC.police.API.eNICpoliceAPI.Controller.PoliceAPIController;
import com.eNIC.police.API.eNICpoliceAPI.entity.CommonGeneralDetail;

@SpringBootTest
class ENiCpoliceApiApplicationTests {

	
	@Autowired
	private PoliceAPIController policeAPIController;
	

	@Test
	void getPersonCrimesTest() {
		
		Map<String, Object> response=	policeAPIController.getPersonCrimes("199752300001");
		CommonGeneralDetail g =  (CommonGeneralDetail) response.get("Generals");
		Assert.assertEquals("199752300001", g.getNicNo());
	}
	


}
