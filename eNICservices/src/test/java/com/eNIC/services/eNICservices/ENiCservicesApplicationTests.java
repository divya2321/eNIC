package com.eNIC.services.eNICservices;

import java.net.URISyntaxException;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestClientException;

import com.eNIC.services.eNICservices.entity.CommonService;
import com.eNIC.services.eNICservices.entity.OrganizationDetail;
import com.eNIC.services.eNICservices.services.ServiceServices;


@SpringBootTest
class ENiCservicesApplicationTests {

	@Autowired
	private ServiceServices serviceServices;
	
	
	@Test
	void registerServiceTest() throws RestClientException, URISyntaxException {
		
		CommonService commonService = new CommonService();
		commonService.setOrganizationName("Hemas Hospital");
		commonService.setOrganizationCode("FDE326264");
		commonService.setOrganizationHead("Herath Gunathilaka");
		commonService.setOrganizationType("Healthcare");
		commonService.setOrgContact1("0112478549");
		commonService.setOrgContact2("0112498632");
		commonService.setOrgEmailAddress("hemas@gmail.com");
		commonService.setOrgAddressNo("568/4");
		commonService.setOrgAddressStreet1("2nd street rd");
		commonService.setOrgAddressStreet2("Kollupitiya");
		commonService.setOrgAddressCity("Colombo");
		CommonService  response = serviceServices.registerService(commonService);
		Assert.assertEquals("Hemas Hospital", response.getOrganizationName());
		Assert.assertEquals("FDE326264", response.getOrganizationCode());
	}
	@Test
	void findLocationsByNicTest() throws RestClientException, URISyntaxException {
		
		List<OrganizationDetail>  response = serviceServices.getAllServices();
		Assert.assertNotNull(response);
	}
	@Test
	void approveTest() throws Exception {
		
		OrganizationDetail  response = serviceServices.updateStatus(51,"Approved");
		Assert.assertEquals("CS45848464", response.getOrganizationCode());
		Assert.assertEquals("Approved", response.getOrganizationStatus());
	}
	@Test
	void rejectTest() throws Exception {
		
		OrganizationDetail  response = serviceServices.updateStatus(52,"Rejected");
		Assert.assertEquals("BDF6629562", response.getOrganizationCode());
		Assert.assertEquals("Rejected", response.getOrganizationStatus());
	}
}
