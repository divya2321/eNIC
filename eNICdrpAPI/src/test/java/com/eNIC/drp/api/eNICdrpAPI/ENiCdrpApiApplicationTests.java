package com.eNIC.drp.api.eNICdrpAPI;

import java.sql.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.eNIC.drp.api.eNICdrpAPI.eniccontroller.CommonController;
import com.eNIC.drp.api.eNICdrpAPI.eniccontroller.JwtAuthenticationController;
import com.eNIC.drp.api.eNICdrpAPI.enicentity.DRPCommonEntity;
import com.eNIC.drp.api.eNICdrpAPI.enicentity.JwtResponse;
import com.eNIC.drp.api.eNICdrpAPI.enicentity.UserAccount;


@SpringBootTest
class ENiCdrpApiApplicationTests {
	
	
	@Autowired
	private CommonController commonController;
	
	@Autowired
	private JwtAuthenticationController jwtAuthenticationController;
	

	@Test
	void registerNewNicTest() throws Exception {
		DRPCommonEntity drpCommonEntity = new DRPCommonEntity();
		
		drpCommonEntity.setApplicationNo("APP00032");
		drpCommonEntity.setApplicationType("New");
		String receiveDate = "2021-5-10";
		drpCommonEntity.setRecievedDate(Date.valueOf(receiveDate));
		String dob = "1994-6-21";
		drpCommonEntity.setDob(Date.valueOf(dob));
		drpCommonEntity.setCivilStatus("Unmarried");
		drpCommonEntity.setName("Siriwardhana Mudhalige Lashmann Siriwardhana");
		drpCommonEntity.setFamilyName("Siriwardhana Mudhalige");
		drpCommonEntity.setSurName("Siriwardhana");
		drpCommonEntity.setResidentNo("0112458987");
		drpCommonEntity.setMobileNo("0774856988");
		drpCommonEntity.setGender("Male");
		drpCommonEntity.setFingerprint("v5659sdv4vds465ds4bds4b9ew4fsa54sa6ge8bb46fd5df8b49r8egrerrgrgrgre8greg4r8465r4g4rdw46as4d489w");
		drpCommonEntity.setEmailAddress("lashman.siriwardhana@gmail.com");
		drpCommonEntity.setAddressPermanentNo("784/5");
		drpCommonEntity.setAddressPermanentStreet1("Old rd");
		drpCommonEntity.setAddressPermanentStreet2("Wabada");
		drpCommonEntity.setAddressPermanentCity("Udupila");
		drpCommonEntity.setFatherName("Siriwardhana Mudhalige Wikkrama Siriwardhana");
		drpCommonEntity.setFatherNic("621234895V");
		drpCommonEntity.setMotherNic("655489765V");
		drpCommonEntity.setMotherName("Padhma Chandhrakanthi");
		drpCommonEntity.setMotherNic("655489765V");
		drpCommonEntity.setScannedApplication("http://fileserver/application1.pdf");
		drpCommonEntity.setScannedGramaNiladhariCertificate("http://fileserver/gramaCetifi1.pdf");
		drpCommonEntity.setIcaoPhoto("http://fileserver/icao1.pdf");
		
		DRPCommonEntity response=	commonController.registerPerson(drpCommonEntity);
		
		Assert.assertEquals("Siriwardhana Mudhalige Lashmann Siriwardhana", response.getName());
	}
	
	
	@Test
	void registerRenewNicTest() throws Exception {
		
		DRPCommonEntity drpCommonEntity = new DRPCommonEntity();
		drpCommonEntity.setApplicationNo("APP00033");
		drpCommonEntity.setApplicationType("Renew");
		String receiveDate = "2021-5-15";
		drpCommonEntity.setRecievedDate(Date.valueOf(receiveDate));
		String dob = "1994-6-21";
		drpCommonEntity.setDob(Date.valueOf(dob));
		drpCommonEntity.setCivilStatus("Unmarried");
		drpCommonEntity.setName("Siriwardhana Mudhalige Lashman Siriwardhana");
		drpCommonEntity.setFamilyName("Siriwardhana Mudhalige");
		drpCommonEntity.setSurName("Siriwardhana");
		drpCommonEntity.setResidentNo("0112458987");
		drpCommonEntity.setMobileNo("0774856988");
		drpCommonEntity.setGender("Male");
		drpCommonEntity.setFingerprint("v5659sdv4vds465ds4bds4b9ew4fsa54sa6ge8bb46fd5df8b49r8egrerrgrgrgre8greg4r8465r4g4rdw46as4d489w");
		drpCommonEntity.setEmailAddress("lashman.siriwardhana@gmail.com");
		drpCommonEntity.setAddressPermanentNo("784/5");
		drpCommonEntity.setAddressPermanentStreet1("Old rd");
		drpCommonEntity.setAddressPermanentStreet2("Wabada");
		drpCommonEntity.setAddressPermanentCity("Udupila");
		drpCommonEntity.setFatherName("Siriwardhana Mudhalige Wikkrama Siriwardhana");
		drpCommonEntity.setFatherNic("621234895V");
		drpCommonEntity.setMotherNic("655489765V");
		drpCommonEntity.setMotherName("Padhma Chandhrakanthi");
		drpCommonEntity.setMotherNic("655489765V");
		drpCommonEntity.setScannedApplication("http://fileserver/application1.pdf");
		drpCommonEntity.setScannedGramaNiladhariCertificate("http://fileserver/gramaCetifi1.pdf");
		drpCommonEntity.setIcaoPhoto("http://fileserver/icao1.pdf");
		drpCommonEntity.setScannedOldNic("http://fileserver/oldnic1.pdf");
		drpCommonEntity.setOldNicNo("199417300002");
		drpCommonEntity.setComment("Changed the name");
		
		DRPCommonEntity response=	commonController.registerPerson(drpCommonEntity);
		
		Assert.assertEquals("Siriwardhana Mudhalige Lashman Siriwardhana", response.getName());
	}
	
	@Test
	void registerLostNicTest() throws Exception {
		
		DRPCommonEntity drpCommonEntity = new DRPCommonEntity();
		drpCommonEntity.setApplicationNo("APP00034");
		drpCommonEntity.setApplicationType("Lost");
		String receiveDate = "2021-5-18";
		drpCommonEntity.setRecievedDate(Date.valueOf(receiveDate));
		String dob = "1994-6-21";
		drpCommonEntity.setDob(Date.valueOf(dob));
		drpCommonEntity.setCivilStatus("Unmarried");
		drpCommonEntity.setName("Siriwardhana Mudhalige Lashman Siriwardhana");
		drpCommonEntity.setFamilyName("Siriwardhana Mudhalige");
		drpCommonEntity.setSurName("Siriwardhana");
		drpCommonEntity.setResidentNo("0112458987");
		drpCommonEntity.setMobileNo("0774856988");
		drpCommonEntity.setGender("Male");
		drpCommonEntity.setFingerprint("v5659sdv4vds465ds4bds4b9ew4fsa54sa6ge8bb46fd5df8b49r8egrerrgrgrgre8greg4r8465r4g4rdw46as4d489w");
		drpCommonEntity.setEmailAddress("lashman.siriwardhana@gmail.com");
		drpCommonEntity.setAddressPermanentNo("784/5");
		drpCommonEntity.setAddressPermanentStreet1("Old rd");
		drpCommonEntity.setAddressPermanentStreet2("Wabada");
		drpCommonEntity.setAddressPermanentCity("Udupila");
		drpCommonEntity.setFatherName("Siriwardhana Mudhalige Wikkrama Siriwardhana");
		drpCommonEntity.setFatherNic("621234895V");
		drpCommonEntity.setMotherNic("655489765V");
		drpCommonEntity.setMotherName("Padhma Chandhrakanthi");
		drpCommonEntity.setMotherNic("655489765V");
		drpCommonEntity.setScannedApplication("http://fileserver/application1.pdf");
		drpCommonEntity.setScannedGramaNiladhariCertificate("http://fileserver/gramaCetifi1.pdf");
		drpCommonEntity.setIcaoPhoto("http://fileserver/icao1.pdf");
		drpCommonEntity.setScannedPoliceReport("http://fileserver/policereport1.pdf");
		drpCommonEntity.setOldNicNo("199417300002");
		drpCommonEntity.setComment("Lost nic");
		
		DRPCommonEntity response=	commonController.registerPerson(drpCommonEntity);
		
		Assert.assertEquals("Siriwardhana Mudhalige Lashman Siriwardhana", response.getName());
	}
	
	@Test
	void findAllTest() throws Exception {
		
		List<DRPCommonEntity> response = commonController.getAll();
		
		Assert.assertNotNull(response);
	}
	
	@Test
	void findByNicTest() throws Exception {
		
		List<DRPCommonEntity> response = commonController.getNIC("199752300001");
		
		Assert.assertNotNull(response);
	}
	
	
	@Test
	void saveSystemUser() throws Exception {
		
		UserAccount userAccount = new UserAccount();
		userAccount.setUsername("kasunDrp");
		userAccount.setPassword("kasunDrp21");
		
		String response = jwtAuthenticationController.saveUser(userAccount);
		
		Assert.assertNotNull(response);
	}
	
}
