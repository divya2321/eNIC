package com.eNIC.health.API.eNIChealthAPI;

import java.util.Map;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.eNIC.health.API.eNIChealthAPI.controller.HealthAPIController;
import com.eNIC.health.API.eNIChealthAPI.entity.CommonGeneralDetail;
import com.eNIC.health.API.eNIChealthAPI.entity.CommonHealthRecord;

@SpringBootTest
class ENiChealthApiApplicationTests {

	@Autowired
	private HealthAPIController healthAPIController;
	
	
	
	@Test
	void saveHealthRecordTest() throws Exception {
		
		CommonHealthRecord commonHealthRecord = new CommonHealthRecord();
		
		commonHealthRecord.setNicNo("197314500001");
		commonHealthRecord.setBloodType("O+");
		commonHealthRecord.setHealthRecord("Too gorgous");
		commonHealthRecord.setDiscription("Treatments continuinn.");
		commonHealthRecord.setHealthReport("http://www.filehost/healthrecord1.pdf");
		
		CommonHealthRecord response=	healthAPIController.saveHealthRecord("Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJIZWFIU0dPNEE2IiwiZXhwIjoxNjM5ODAwOTgwLCJpYXQiOjE2MjE4MDA5ODB9.WyNgGUxPL0QJ2O-ke4PideflLbJCh6iFHyyrIX1M7-krHt1QjM4_0EP2ZjQ1qwbCHbPb0lkjLLiemaARwgXdhg",commonHealthRecord);
		
		Assert.assertEquals("197314500001", response.getNicNo());
		Assert.assertEquals("Too gorgous", response.getHealthRecord());
	}
	
	@Test
	void saveBloodTypeTest() {
		
		CommonHealthRecord commonHealthRecord = new CommonHealthRecord();
		
		commonHealthRecord.setNicNo("197314500001");
		commonHealthRecord.setBloodType("O+");
		
		CommonHealthRecord response=	healthAPIController.saveBloodType(commonHealthRecord);
		Assert.assertEquals("197314500001", response.getNicNo());
		Assert.assertEquals("O+", response.getBloodType());
	}
	
	@Test
	void getPersonHealthTest() {
		
		Map<String, Object> response=	healthAPIController.getPersonHealth("199752300001");
		CommonGeneralDetail g =  (CommonGeneralDetail) response.get("Generals");
		Assert.assertEquals("199752300001", g.getNicNo());
	}

}
