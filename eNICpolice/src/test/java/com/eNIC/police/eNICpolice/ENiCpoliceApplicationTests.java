package com.eNIC.police.eNICpolice;

import java.net.URISyntaxException;
import java.util.Map;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestClientException;

import com.eNIC.police.eNICpolice.service.PoliceService;

@SpringBootTest
class ENiCpoliceApplicationTests {

	@Autowired
	private PoliceService policeService;

	@Test
	void getPersonCrimesTest() throws RestClientException, URISyntaxException {
		
		Map<String, Object> response=	policeService.searchCriminalRecords("199752300001");
		Assert.assertNotNull(response);
	}

}
