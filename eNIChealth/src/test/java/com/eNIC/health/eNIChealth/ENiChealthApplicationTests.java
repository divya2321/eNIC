package com.eNIC.health.eNIChealth;

import java.net.URISyntaxException;
import java.util.Map;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;

import com.eNIC.health.eNIChealth.entity.CommonHealthRecord;
import com.eNIC.health.eNIChealth.service.HealthService;


@SpringBootTest
class ENiChealthApplicationTests {

	@Autowired
	private HealthService healthService;
	
	@Test
	void saveRecordTest() {
		
		CommonHealthRecord commonHealthRecord = new CommonHealthRecord();
		commonHealthRecord.setHealthRecord("Psychistis");
		commonHealthRecord.setDiscription("Treatments continuing.b It is critical.");
		commonHealthRecord.setHealthReport("https://www.hosting.report2.pdf");
		commonHealthRecord.setNicNo("200011600001");
		
		ResponseEntity<CommonHealthRecord> response=	healthService.saveRecord(commonHealthRecord);
		
		Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	
	@Test
	void saveBloodTypeTest() {
		
		CommonHealthRecord commonHealthRecord = new CommonHealthRecord();
		commonHealthRecord.setBloodType("B+");
		commonHealthRecord.setNicNo("200011600001");
		
		ResponseEntity<CommonHealthRecord> response=	healthService.saveBloodType(commonHealthRecord);
		
		Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	

	@Test
	void searchHealthRecordsTest() throws RestClientException, URISyntaxException {
		
		Map<String, Object> response=	healthService.searchHealthRecords("200011600001");
		Assert.assertNotNull(response);
	}
}
