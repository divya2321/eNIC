package com.eNIC.judicial.eNICjudicial;

import java.net.URISyntaxException;
import java.util.Map;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;

import com.eNIC.judicial.eNICjudicial.entity.CommonCriminalRecord;
import com.eNIC.judicial.eNICjudicial.service.JudicialService;

@SpringBootTest
class ENiCjudicialApplicationTests {

	
	@Autowired
	private JudicialService judicialService;
	
	@Test
	void saveRecordTest() {
		
		CommonCriminalRecord commonCriminalRecord = new CommonCriminalRecord();
		commonCriminalRecord.setCriminalRecord("kidnap a person");
		commonCriminalRecord.setCriminalDiscription("Kidnap a person at Mahara bus station");
		commonCriminalRecord.setCriminalReport("https://www.hosting.report2.pdf");
		commonCriminalRecord.setNicNo("200011600001");
		
		ResponseEntity<CommonCriminalRecord> response=	judicialService.saveRecord(commonCriminalRecord);
		
		Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Test
	void getPersonCrimesTest() throws RestClientException, URISyntaxException {
		
		Map<String, Object> response=	judicialService.searchCriminalRecords("199752300001");
		Assert.assertNotNull(response);
	}
}
