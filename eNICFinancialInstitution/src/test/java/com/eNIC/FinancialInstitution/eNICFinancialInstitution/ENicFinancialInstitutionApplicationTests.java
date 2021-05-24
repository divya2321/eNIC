package com.eNIC.FinancialInstitution.eNICFinancialInstitution;

import java.net.URISyntaxException;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestClientException;

import com.eNIC.FinancialInstitution.eNICFinancialInstitution.entity.CommonGeneralDetail;
import com.eNIC.FinancialInstitution.eNICFinancialInstitution.service.FinancialService;

@SpringBootTest
class ENicFinancialInstitutionApplicationTests {

	@Autowired
	private FinancialService financialService;

	@Test
	void searchGeneralDetialsTest() throws RestClientException, URISyntaxException {
		
		CommonGeneralDetail response=	financialService.searchGeneralDetials("199752300001");
		Assert.assertEquals("199752300001", response.getNicNo());
		Assert.assertEquals("Sitinamaluwa", response.getSurName());
	}

}
