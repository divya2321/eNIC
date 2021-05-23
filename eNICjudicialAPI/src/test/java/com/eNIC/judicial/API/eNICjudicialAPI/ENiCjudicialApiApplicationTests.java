package com.eNIC.judicial.API.eNICjudicialAPI;

import java.util.Map;

import org.aspectj.lang.annotation.Before;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.eNIC.judicial.API.eNICjudicialAPI.Controller.JudicialAPIController;
import com.eNIC.judicial.API.eNICjudicialAPI.entity.CommonCriminalRecord;
import com.eNIC.judicial.API.eNICjudicialAPI.entity.CommonGeneralDetail;

@SpringBootTest
class ENiCjudicialApiApplicationTests {


	@Autowired
	private JudicialAPIController judicialAPIController;
	
	
	@Test
	void saveCriminalRecordTest() throws Exception {
		
		CommonCriminalRecord commonCriminalRecord = new CommonCriminalRecord();
		commonCriminalRecord.setCriminalRecord("Try to kill a person");
		commonCriminalRecord.setCriminalDiscription("Try to kill a person at piliyandala bus station");
		commonCriminalRecord.setCriminalReport("https://www.hosting.report1.pdf");
		commonCriminalRecord.setNicNo("199752300001");
		
		CommonCriminalRecord response=	judicialAPIController.saveCriminalRecord("Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJKdWRHT1Z0eTZUeSIsImV4cCI6MTYzOTc2MTM0MywiaWF0IjoxNjIxNzYxMzQzfQ.CXumezce9RivyJO4OGq5hZc0utFs78UmGt3flyrUjLlH8mcn5Hx7bZIs7wN1iNeSSwCbHfsQNLB_Ifyu1hQ9iA",commonCriminalRecord);
		
		Assert.assertEquals("Try to kill a person", response.getCriminalRecord());

	}
	
	
	@Test
	void getPersonCrimesTest() {
		
		Map<String, Object> response=	judicialAPIController.getPersonCrimes("Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJKdWRHT1Z0eTZUeSIsImV4cCI6MTYzOTc2MTM0MywiaWF0IjoxNjIxNzYxMzQzfQ.CXumezce9RivyJO4OGq5hZc0utFs78UmGt3flyrUjLlH8mcn5Hx7bZIs7wN1iNeSSwCbHfsQNLB_Ifyu1hQ9iA","199752300001");
		CommonGeneralDetail g =  (CommonGeneralDetail) response.get("Generals");
		Assert.assertEquals("199752300001", g.getNicNo());
	}
	

}
