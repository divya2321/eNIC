package com.eNIC.drp.eNICdrp;

import java.sql.Date;
import java.util.List;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.eNIC.drp.eNICdrp.entity.DRPCommonEntity;
import com.eNIC.drp.eNICdrp.entity.JwtResponse;
import com.eNIC.drp.eNICdrp.entity.UserAccount;
import com.eNIC.drp.eNICdrp.service.DRPService;

@SpringBootTest
class ENiCdrpApplicationTests {

	@Autowired
	private DRPService drpService;
	
	
	@Test
	void registerNewNicTest() throws Exception {
		DRPCommonEntity drpCommonEntity = new DRPCommonEntity();
		
		drpCommonEntity.setApplicationNo("APP00035");
		drpCommonEntity.setApplicationType("New");
		String receiveDate = "2021-5-2";
		drpCommonEntity.setRecievedDate(Date.valueOf(receiveDate));
		String dob = "1992-7-14";
		drpCommonEntity.setDob(Date.valueOf(dob));
		drpCommonEntity.setCivilStatus("Unmarried");
		drpCommonEntity.setName("Henarath Appuhamilage Amasha Thathsarani Jayasekara");
		drpCommonEntity.setFamilyName("Henarath Appuhamilage");
		drpCommonEntity.setSurName("Jayasekara");
		drpCommonEntity.setResidentNo("0112478569");
		drpCommonEntity.setMobileNo("0714590698");
		drpCommonEntity.setGender("Female");
		drpCommonEntity.setFingerprint("jnvsd6556ds987ewgrrg4f5465fd4bfd7987987fdbdbfdbbdbserbre684rbrber48re6bre6vd");
		drpCommonEntity.setAddressPermanentNo("61/8");
		drpCommonEntity.setAddressPermanentStreet1("Nisala Pedesa");
		drpCommonEntity.setAddressPermanentStreet2("Wathara");
		drpCommonEntity.setAddressPermanentCity("Poligasowita");
		drpCommonEntity.setFatherName("Henarath Appuhamilage Miltan Jayasekara");
		drpCommonEntity.setFatherNic("603298745V");
		drpCommonEntity.setMotherName("Sellappuramu Arachilage Chithra Irangani");
		drpCommonEntity.setMotherNic("645987462V");
		drpCommonEntity.setScannedApplication("http://fileserver/application25.pdf");
		drpCommonEntity.setScannedGramaNiladhariCertificate("http://fileserver/gramaCetifi25.pdf");
		drpCommonEntity.setIcaoPhoto("http://fileserver/icao25.pdf");
		
		 ResponseEntity<DRPCommonEntity> response=	drpService.saveNic(drpCommonEntity);
		
		Assert.assertEquals("Henarath Appuhamilage Amasha Thathsarani Jayasekara", response.getBody().getName());
	}
	
	
	@Test
	void registerRenewNicTest() throws Exception {
		
		DRPCommonEntity drpCommonEntity = new DRPCommonEntity();
		drpCommonEntity.setApplicationNo("APP00036");
		drpCommonEntity.setApplicationType("Renew");
		String receiveDate = "2021-5-10";
		drpCommonEntity.setRecievedDate(Date.valueOf(receiveDate));
		String dob = "1992-7-14";
		drpCommonEntity.setDob(Date.valueOf(dob));
		drpCommonEntity.setCivilStatus("Unmarried");
		drpCommonEntity.setName("Henarath Appuhamillage Amasha Thathsarani Jayasekara");
		drpCommonEntity.setFamilyName("Henarath Appuhamilage");
		drpCommonEntity.setSurName("Jayasekara");
		drpCommonEntity.setResidentNo("0112478569");
		drpCommonEntity.setMobileNo("0714590698");
		drpCommonEntity.setGender("Female");
		drpCommonEntity.setFingerprint("jnvsd6556ds987ewgrrg4f5465fd4bfd7987987fdbdbfdbbdbserbre684rbrber48re6bre6vd");
		drpCommonEntity.setAddressPermanentNo("61/8");
		drpCommonEntity.setAddressPermanentStreet1("Nisala Pedesa");
		drpCommonEntity.setAddressPermanentStreet2("Wathara");
		drpCommonEntity.setAddressPermanentCity("Poligasowita");
		drpCommonEntity.setFatherName("Henarath Appuhamilage Miltan Jayasekara");
		drpCommonEntity.setFatherNic("603298745V");
		drpCommonEntity.setMotherName("Sellappuramu Arachilage Chithra Irangani");
		drpCommonEntity.setMotherNic("645987462V");
		drpCommonEntity.setScannedApplication("http://fileserver/application251.pdf");
		drpCommonEntity.setScannedGramaNiladhariCertificate("http://fileserver/gramaCetifi251.pdf");
		drpCommonEntity.setIcaoPhoto("http://fileserver/icao251.pdf");
		drpCommonEntity.setScannedOldNic("http://fileserver/oldnic251.pdf");
		drpCommonEntity.setOldNicNo("199269600001");
		drpCommonEntity.setComment("Changed the name");
		ResponseEntity<DRPCommonEntity> response=	drpService.saveNic(drpCommonEntity);
			
		Assert.assertEquals("Henarath Appuhamillage Amasha Thathsarani Jayasekara", response.getBody().getName());
	}
	
	
	@Test
	void registerLostNicTest() throws Exception {
		
		DRPCommonEntity drpCommonEntity = new DRPCommonEntity();
		drpCommonEntity.setApplicationNo("APP00037");
		drpCommonEntity.setApplicationType("Lost");
		String receiveDate = "2021-5-20";
		drpCommonEntity.setRecievedDate(Date.valueOf(receiveDate));
		String dob = "1992-7-14";
		drpCommonEntity.setDob(Date.valueOf(dob));
		drpCommonEntity.setCivilStatus("Unmarried");
		drpCommonEntity.setName("Henarath Appuhamillage Amasha Thathsarani Jayasekara");
		drpCommonEntity.setFamilyName("Henarath Appuhamilage");
		drpCommonEntity.setSurName("Jayasekara");
		drpCommonEntity.setResidentNo("0112478569");
		drpCommonEntity.setMobileNo("0714590698");
		drpCommonEntity.setGender("Female");
		drpCommonEntity.setFingerprint("jnvsd6556ds987ewgrrg4f5465fd4bfd7987987fdbdbfdbbdbserbre684rbrber48re6bre6vd");
		drpCommonEntity.setAddressPermanentNo("61/8");
		drpCommonEntity.setAddressPermanentStreet1("Nisala Pedesa");
		drpCommonEntity.setAddressPermanentStreet2("Wathara");
		drpCommonEntity.setAddressPermanentCity("Poligasowita");
		drpCommonEntity.setFatherName("Henarath Appuhamilage Miltan Jayasekara");
		drpCommonEntity.setFatherNic("603298745V");
		drpCommonEntity.setMotherName("Sellappuramu Arachilage Chithra Irangani");
		drpCommonEntity.setMotherNic("645987462V");
		drpCommonEntity.setScannedApplication("http://fileserver/application521.pdf");
		drpCommonEntity.setScannedGramaNiladhariCertificate("http://fileserver/gramaCetifi521.pdf");
		drpCommonEntity.setIcaoPhoto("http://fileserver/icao521.pdf");
		drpCommonEntity.setScannedPoliceReport("http://fileserver/policereport521.pdf");
		drpCommonEntity.setOldNicNo("199269600001");
		drpCommonEntity.setComment("Lost nic");
		ResponseEntity<DRPCommonEntity> response=	drpService.saveNic(drpCommonEntity);
		
		Assert.assertEquals("Henarath Appuhamillage Amasha Thathsarani Jayasekara", response.getBody().getName());
	}

	@Test
	void findAllTest() throws Exception {
		
		List<DRPCommonEntity> response = drpService.findsAllNic();
		
		Assert.assertNotNull(response);
	}
	
	@Test
	void findByNicTest() throws Exception {
		
		List<DRPCommonEntity> response = drpService.findsAllNicByNic("199269600001");
		
		Assert.assertNotNull(response);
	}
	
	
	@Test
	void saveSystemUser() throws Exception {
		
		UserAccount userAccount = new UserAccount();
		userAccount.setUsername("ITSt56");
		userAccount.setPassword("ITstPass45");
		
		String response = drpService.createUseraccount(userAccount);
		
		Assert.assertNotNull(response);
	}
	
}
	

