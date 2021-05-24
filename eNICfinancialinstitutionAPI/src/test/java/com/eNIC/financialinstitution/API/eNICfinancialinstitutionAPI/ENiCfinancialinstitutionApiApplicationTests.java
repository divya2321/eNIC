package com.eNIC.financialinstitution.API.eNICfinancialinstitutionAPI;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.eNIC.financialinstitution.API.eNICfinancialinstitutionAPI.entity.CommonGeneralDetail;
import com.eNIC.financialinstitution.API.eNICfinancialinstitutionAPI.service.FinanceService;


@SpringBootTest
class ENiCfinancialinstitutionApiApplicationTests {

	@Autowired
	private FinanceService financeService;
	
	
	@Test
	void getGeneralDetailTest() {
		
		CommonGeneralDetail response=	financeService.getGeneralDetail("199752300001");
		Assert.assertEquals("199752300001", response.getNicNo());
		Assert.assertEquals("Sitinamaluwa", response.getSurName());
	}


}
