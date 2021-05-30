package com.eNIC.drp.api.eNICdrpAPI.enicservices;


import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eNIC.drp.api.eNICdrpAPI.enicentity.AddressDetail;
import com.eNIC.drp.api.eNICdrpAPI.enicentity.Application;
import com.eNIC.drp.api.eNICdrpAPI.enicentity.ContactDetail;
import com.eNIC.drp.api.eNICdrpAPI.enicentity.DRPCommonEntity;
import com.eNIC.drp.api.eNICdrpAPI.enicentity.FamilyDetail;
import com.eNIC.drp.api.eNICdrpAPI.enicentity.GeneralDetail;
import com.eNIC.drp.api.eNICdrpAPI.enicentity.GeneralDetailOld;
import com.eNIC.drp.api.eNICdrpAPI.enicentity.IcaoPhoto;
import com.eNIC.drp.api.eNICdrpAPI.enicentity.OldNic;
import com.eNIC.drp.api.eNICdrpAPI.enicentity.PoliceReport;
import com.eNIC.drp.api.eNICdrpAPI.enicrepository.AddressDetailRepository;
import com.eNIC.drp.api.eNICdrpAPI.enicrepository.ApplicationRepository;
import com.eNIC.drp.api.eNICdrpAPI.enicrepository.ContactDetailRepository;
import com.eNIC.drp.api.eNICdrpAPI.enicrepository.FamilyDetailRepository;
import com.eNIC.drp.api.eNICdrpAPI.enicrepository.GeneralDetailOldRepository;
import com.eNIC.drp.api.eNICdrpAPI.enicrepository.GeneralDetailRepository;
import com.eNIC.drp.api.eNICdrpAPI.enicrepository.IcaoPhotoRepository;
import com.eNIC.drp.api.eNICdrpAPI.enicrepository.OldNicRepository;
import com.eNIC.drp.api.eNICdrpAPI.enicrepository.PoliceReportRepository;
import com.eNIC.drp.api.eNICdrpAPI.exception.ResourceNotFoundException;


@Transactional
@Service
public class CommonServices {


	@Autowired
	ApplicationRepository applicationRepository;

	@Autowired
	OldNicRepository oldNicRepository;

	@Autowired
	PoliceReportRepository policeReportRepository;

	@Autowired
	IcaoPhotoRepository icaoPhotoRepository;

	@Autowired
	GeneralDetailRepository generalDetailRepository;

	@Autowired
	GeneralDetailOldRepository generalDetailOldRepository;

	@Autowired
	AddressDetailRepository addressDetailRepository;

	@Autowired
	ContactDetailRepository contactDetailRepository;

	@Autowired
	FamilyDetailRepository familyDetailRepository;
	
	DRPCommonEntity drpFindAll;

	public DRPCommonEntity commonCreate(DRPCommonEntity drpCommonEntity)throws Exception {
		
		System.out.println("SAVING APPLICATION");
		
		Application application = new Application();
		application.setIdApplication(0);
		application.setApplicationNo(drpCommonEntity.getApplicationNo());
		application.setApplicationType(drpCommonEntity.getApplicationType());
		application.setScannedApplication(drpCommonEntity.getScannedApplication());
		application.setScannedGramaNiladhariCertificate(drpCommonEntity.getScannedGramaNiladhariCertificate());
		application.setRecievedDate(drpCommonEntity.getRecievedDate());
		Application savedApplication = applicationRepository.save(application);	
	
		
		String appType = drpCommonEntity.getApplicationType();
		
		String nicNo="";
		if (savedApplication!=null) {
			drpCommonEntity.setIdApplication(savedApplication.getIdApplication());
			System.out.println("APPLICATION SAVED");
			if (appType.equalsIgnoreCase("new")) {
				System.out.println("NEW APPLICATION");
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String dobtext = sdf.format(drpCommonEntity.getDob());
				
				String firsthaldNIC = NICAlgo.NICAlgoMethod(dobtext, drpCommonEntity.getGender());
				System.out.println("Test");
				nicNo = NICAlgo.generateFullNicNo(generalDetailRepository, drpCommonEntity, firsthaldNIC);
				System.out.println(nicNo);
				
				
			} else if (appType.equalsIgnoreCase("renew") || appType.equalsIgnoreCase("lost")) {
				System.out.println("RENEW or LOST APPLICATION");
				System.out.println(String.valueOf(drpCommonEntity.getOldNicNo()));
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String dobtext = sdf.format(drpCommonEntity.getDob());
				String newFirstHalf = NICAlgo.NICAlgoMethod(dobtext, drpCommonEntity.getGender());
				System.out.println("This is new first Half:"+newFirstHalf);
				
				
				GeneralDetail foundOldNic = generalDetailRepository.findByOneNicNo(drpCommonEntity.getOldNicNo().trim());
				System.out.println("Before");
				System.out.println(foundOldNic.getNicNo());
				String oldFirstHalf = foundOldNic.getNicNo().substring(0, 7);
				System.out.println("This is oldFirstHalf"+oldFirstHalf);
							
				
				GeneralDetail updateGeneralDetailRecord = foundOldNic;
				updateGeneralDetailRecord.setNicStatus(false);
				generalDetailRepository.save(updateGeneralDetailRecord);
				System.out.println("finding old record");		
				
				if (foundOldNic!=null) {
					
					if (!newFirstHalf.equalsIgnoreCase(oldFirstHalf)) {
						
						nicNo = NICAlgo.generateFullNicNo(generalDetailRepository, drpCommonEntity, newFirstHalf);
						List<GeneralDetail> dobrecord = generalDetailRepository.findByDob(drpCommonEntity.getDob());
						
						int recno = dobrecord.size(); 
						System.out.println("IMPORTANT:"+recno);
						
					
					}else {					
						nicNo = foundOldNic.getNicNo();							
						System.out.println("Found previous record");

					}
				}
			
				
				
				OldNic savedOldNic=null;
				PoliceReport savedPoliceReport=null;
				GeneralDetailOld savedOldDetail = null;
				
					if (appType.equalsIgnoreCase("renew")) {
						//	Old NIC				
						OldNic oldNic = new OldNic();
						oldNic.setIdOldNic(0);
						oldNic.setScannedOldNic(drpCommonEntity.getScannedOldNic());
						oldNic.setIdApplication(application);
						savedOldNic = oldNicRepository.save(oldNic);
						if (savedOldNic!=null) {
							drpCommonEntity.setIdOldNic(savedOldNic.getIdOldNic());							
						}
						
						
					} else {
						//Police Report
						PoliceReport policeReport = new PoliceReport();
						policeReport.setIdPoliceReport(0);
						policeReport.setScannedPoliceReport(drpCommonEntity.getScannedPoliceReport());
						policeReport.setIdApplication(application);
						savedPoliceReport = policeReportRepository.save(policeReport);	
						if (savedPoliceReport!=null) {
							drpCommonEntity.setIdPoliceReport(savedPoliceReport.getIdPoliceReport());						
						}
						
					} 
					
					//Old Detail
					if (savedOldNic != null || savedPoliceReport != null) {
						System.out.println("*********IT IS NOT A NEW");
							GeneralDetailOld generalDetailOld = new GeneralDetailOld();
							generalDetailOld.setIdGeneralDetailOld(0);
							generalDetailOld.setExpiredDate(new Date(System.currentTimeMillis()) );
							generalDetailOld.setComment(drpCommonEntity.getComment());
							generalDetailOld.setIdGeneralDetail(foundOldNic);
							savedOldDetail = generalDetailOldRepository.save(generalDetailOld);
							drpCommonEntity.setIdGeneralDetailOld(savedOldDetail.getIdGeneralDetailOld());
							drpCommonEntity.setExpiredDate(savedOldDetail.getExpiredDate());
					}else {
							throw new ResourceNotFoundException("Resource Not Found");
					}
					
			} 	
			
			
			IcaoPhoto icaoPhoto = new IcaoPhoto();
			icaoPhoto.setIdIcaoPhoto(0);
			System.out.println("aaa");
			icaoPhoto.setIcaoPhoto(drpCommonEntity.getIcaoPhoto());
			IcaoPhoto savedIcaoPhoto = icaoPhotoRepository.save(icaoPhoto);
			
			if (savedIcaoPhoto != null) {
				drpCommonEntity.setIdIcaoPhoto(savedIcaoPhoto.getIdIcaoPhoto());
				GeneralDetail generalDetail = new GeneralDetail();
				generalDetail.setIdGeneralDetail(0);
				System.out.println(nicNo);
				generalDetail.setNicNo(nicNo);
				drpCommonEntity.setNicNo(nicNo);
				generalDetail.setFamilyName(drpCommonEntity.getFamilyName());
				generalDetail.setName(drpCommonEntity.getName());
				generalDetail.setSurName(drpCommonEntity.getSurName());
				generalDetail.setDob(drpCommonEntity.getDob());
				generalDetail.setGender(drpCommonEntity.getGender());
				generalDetail.setCivilStatus(drpCommonEntity.getCivilStatus());
				generalDetail.setRegisteredDate(new Date(System.currentTimeMillis())); // drpCommonEntity.getRegisteredDate()
				generalDetail.setFingerprint(drpCommonEntity.getFingerprint());
				generalDetail.setIdIcaoPhoto(savedIcaoPhoto);
				generalDetail.setIdApplication(savedApplication);
				generalDetail.setNicStatus(true);
				GeneralDetail savedGeneralDetail = generalDetailRepository.save(generalDetail);
				
				if (savedGeneralDetail != null) {
					drpCommonEntity.setIdGeneralDetail(savedGeneralDetail.getIdGeneralDetail());
					drpCommonEntity.setNicStatus(savedGeneralDetail.getNicStatus());
					ContactDetail savedContactDetail = null;
					ContactDetail contactDetail = new ContactDetail();
					contactDetail.setIdContactDetail(0);
					contactDetail.setResidentNo(drpCommonEntity.getResidentNo());
					contactDetail.setMobileNo(drpCommonEntity.getMobileNo());
					contactDetail.setEmailAddress(drpCommonEntity.getEmailAddress());
					contactDetail.setIdGeneralDetail(savedGeneralDetail);
					savedContactDetail = contactDetailRepository.save(contactDetail);
					drpCommonEntity.setIdContactDetail(savedContactDetail.getIdContactDetail());
					
					AddressDetail addressDetail;	
					AddressDetail savedAddressDetail = null;
					AddressDetail savedResAddressDetail = null;
					if (drpCommonEntity.getAddressPermanentNo()!=null) {
						addressDetail = new AddressDetail();
						addressDetail.setIdAddressDetail(0);
						addressDetail.setAddressNo(drpCommonEntity.getAddressPermanentNo());
						addressDetail.setAddressStreet1(drpCommonEntity.getAddressPermanentStreet1());
						addressDetail.setAddressStreet2(drpCommonEntity.getAddressPermanentStreet2());
						addressDetail.setAddressCity(drpCommonEntity.getAddressPermanentCity());
						addressDetail.setAddressType("permanent");
						addressDetail.setIdGeneralDetail(savedGeneralDetail);
						savedAddressDetail = addressDetailRepository.save(addressDetail);
						drpCommonEntity.setIdAddressPermanentDetail(savedAddressDetail.getIdAddressDetail());
					}
					if (drpCommonEntity.getAddressResidentNo()!=null) {
						addressDetail = new AddressDetail();
						addressDetail.setIdAddressDetail(0);
						addressDetail.setAddressNo(drpCommonEntity.getAddressResidentNo());
						addressDetail.setAddressStreet1(drpCommonEntity.getAddressResidentStreet1());
						addressDetail.setAddressStreet2(drpCommonEntity.getAddressResidentStreet2());
						addressDetail.setAddressCity(drpCommonEntity.getAddressResidentCity());
						addressDetail.setAddressType("resident");
						addressDetail.setIdGeneralDetail(savedGeneralDetail);
						savedResAddressDetail = addressDetailRepository.save(addressDetail);
						drpCommonEntity.setIdAddressResidentDetail(savedResAddressDetail.getIdAddressDetail());
					}
					
					FamilyDetail savedFamilyDetail = null;
					FamilyDetail familyDetail = new FamilyDetail();
					familyDetail.setIdFamilyDetail(0);
					familyDetail.setMotherNic(drpCommonEntity.getMotherNic());
					familyDetail.setMotherName(drpCommonEntity.getMotherName());
					familyDetail.setFatherNic(drpCommonEntity.getFatherNic());
					familyDetail.setFatherName(drpCommonEntity.getFatherName());
					familyDetail.setIdGeneralDetail(savedGeneralDetail);
					savedFamilyDetail = familyDetailRepository.save(familyDetail);
					drpCommonEntity.setIdFamilyDetail(savedFamilyDetail.getIdFamilyDetail());
					return drpCommonEntity;
					
				} 
				
				
			} 

		} 
		
		
		return null;
	}
	
	@Autowired
	GeneralDetailRepository gdFindAll;
	@Autowired
	AddressDetailRepository adFindAll;
	@Autowired
	ContactDetailRepository cdFindAll;
	@Autowired
	FamilyDetailRepository fdFindAll;
	@Autowired
	GeneralDetailOldRepository gdoFindAll;
	@Autowired
	OldNicRepository findAllOldNic;
	@Autowired
	PoliceReportRepository findAPoliceRep;
	
	DRPCommonEntity drpCommonFindAll;

	public List<DRPCommonEntity> commonFindAllNicDetail() {
		System.out.println("Got All");
		List<GeneralDetail> gdAll = gdFindAll.findAllNicDetails();
		
		List<DRPCommonEntity> ceAll = new ArrayList<DRPCommonEntity>();
		
		for (int i = 0; i < gdAll.size(); i++) {
			drpCommonFindAll = new DRPCommonEntity();
			
			List<AddressDetail> addressList = adFindAll.findByGdId(gdAll.get(i));
			ContactDetail contactDetails = cdFindAll.findByGdId(gdAll.get(i));
			FamilyDetail familyDetails = fdFindAll.findByGdId(gdAll.get(i));
			GeneralDetailOld oldDetails = gdoFindAll.findAllGdo(gdAll.get(i));
			
			drpCommonFindAll.setIdApplication(gdAll.get(i).getIdApplication().getIdApplication());
			drpCommonFindAll.setApplicationNo(gdAll.get(i).getIdApplication().getApplicationNo());
			drpCommonFindAll.setApplicationType(gdAll.get(i).getIdApplication().getApplicationType());
			drpCommonFindAll.setScannedApplication(gdAll.get(i).getIdApplication().getScannedApplication());
			drpCommonFindAll.setScannedGramaNiladhariCertificate(gdAll.get(i).getIdApplication().getScannedGramaNiladhariCertificate());
			drpCommonFindAll.setRecievedDate(gdAll.get(i).getIdApplication().getRecievedDate());
			
			drpCommonFindAll.setIcaoPhoto(gdAll.get(i).getIdIcaoPhoto().getIcaoPhoto());
			drpCommonFindAll.setIdIcaoPhoto(gdAll.get(i).getIdIcaoPhoto().getIdIcaoPhoto());
			
			drpCommonFindAll.setIdGeneralDetail(gdAll.get(i).getIdGeneralDetail());
			drpCommonFindAll.setNicNo(gdAll.get(i).getNicNo());
			drpCommonFindAll.setFamilyName(gdAll.get(i).getFamilyName());
			drpCommonFindAll.setName(gdAll.get(i).getName());
			drpCommonFindAll.setSurName(gdAll.get(i).getSurName());
			drpCommonFindAll.setDob(gdAll.get(i).getDob());
			drpCommonFindAll.setGender(gdAll.get(i).getGender());
			drpCommonFindAll.setCivilStatus(gdAll.get(i).getCivilStatus());
			drpCommonFindAll.setFingerprint(gdAll.get(i).getFingerprint());
			drpCommonFindAll.setNicStatus(gdAll.get(i).getNicStatus());
			drpCommonFindAll.setRegisteredDate(gdAll.get(i).getRegisteredDate());
			
			if (gdAll.get(i).getIdApplication().getApplicationType().equalsIgnoreCase("renew")) {				
				OldNic oldNic = findAllOldNic.findByAppId(gdAll.get(i).getIdApplication());
				drpCommonFindAll.setIdOldNic(oldNic.getIdOldNic());
				drpCommonFindAll.setScannedOldNic(oldNic.getScannedOldNic());
				
				
				
			}
			if (gdAll.get(i).getIdApplication().getApplicationType().equalsIgnoreCase("lost")) {
				PoliceReport oldNic = findAPoliceRep.findByAppId(gdAll.get(i).getIdApplication());
				drpCommonFindAll.setIdPoliceReport(oldNic.getIdPoliceReport());
				drpCommonFindAll.setScannedPoliceReport(oldNic.getScannedPoliceReport());
				
				
			}
			
			if (oldDetails != null) {
				drpCommonFindAll.setIdGeneralDetailOld(oldDetails.getIdGeneralDetailOld());
				drpCommonFindAll.setExpiredDate(oldDetails.getExpiredDate());
				drpCommonFindAll.setComment(oldDetails.getComment());
			}
			
			
			for (int j = 0; j < addressList.size(); j++) {
				if (addressList.get(j).getAddressType().equalsIgnoreCase("permanent")) {
					drpCommonFindAll.setIdAddressPermanentDetail(addressList.get(j).getIdAddressDetail());
					drpCommonFindAll.setAddressPermanentNo(addressList.get(j).getAddressNo());
					drpCommonFindAll.setAddressPermanentStreet1(addressList.get(j).getAddressStreet1());
					drpCommonFindAll.setAddressPermanentStreet2(addressList.get(j).getAddressStreet2());
					drpCommonFindAll.setAddressPermanentCity(addressList.get(j).getAddressCity());
					drpCommonFindAll.setAddressPermanentType(addressList.get(j).getAddressType());
				}
				if (addressList.get(j).getAddressType().equalsIgnoreCase("resident")) {
					drpCommonFindAll.setIdAddressResidentDetail(addressList.get(j).getIdAddressDetail());
					drpCommonFindAll.setAddressResidentNo(addressList.get(j).getAddressNo());
					drpCommonFindAll.setAddressResidentStreet1(addressList.get(j).getAddressStreet1());
					drpCommonFindAll.setAddressResidentStreet2(addressList.get(j).getAddressStreet2());
					drpCommonFindAll.setAddressResidentCity(addressList.get(j).getAddressCity());
					drpCommonFindAll.setAddressResidentType(addressList.get(j).getAddressType());
				}
				
			}
			

			drpCommonFindAll.setIdContactDetail(contactDetails.getIdContactDetail());
			drpCommonFindAll.setResidentNo(contactDetails.getResidentNo());
			drpCommonFindAll.setMobileNo(contactDetails.getMobileNo());
			drpCommonFindAll.setEmailAddress(contactDetails.getEmailAddress());

			drpCommonFindAll.setIdFamilyDetail(familyDetails.getIdFamilyDetail());
			drpCommonFindAll.setMotherNic(familyDetails.getMotherNic());
			drpCommonFindAll.setMotherName(familyDetails.getMotherName());
			drpCommonFindAll.setFatherNic(familyDetails.getFatherNic());
			drpCommonFindAll.setFatherName(familyDetails.getFatherName());
			
			ceAll.add(drpCommonFindAll);
		}
		return ceAll;
	}
	
	
	DRPCommonEntity drpCommonEntity;

	@Autowired
	GeneralDetailRepository gdFindNic;
	@Autowired
	AddressDetailRepository adFindNic;
	@Autowired
	ContactDetailRepository cdFindNic;
	@Autowired
	FamilyDetailRepository fdFindNic;
	@Autowired
	GeneralDetailOldRepository gdoFindNic;

	public List<DRPCommonEntity> commonFindNicDetail(String nicNo) {
		System.out.println("Got NIC");
		List<GeneralDetail> gdNic = gdFindNic.findByNicNo(nicNo);

		System.out.println("/n ##########################################################");
		System.out.println(gdNic);
		System.out.println("############################################################ /n");
		
		List<DRPCommonEntity> ceNic = new ArrayList<DRPCommonEntity>();
		
		for (int i = 0; i < gdNic.size(); i++) {
			drpCommonEntity = new DRPCommonEntity();
			
			List<AddressDetail> addressList = adFindNic.findByGdId(gdNic.get(i));
			ContactDetail contactDetails = cdFindNic.findByGdId(gdNic.get(i));
			FamilyDetail familyDetails = fdFindNic.findByGdId(gdNic.get(i));
			GeneralDetailOld oldDetails = gdoFindNic.findAllGdo(gdNic.get(i));
			
			drpCommonEntity.setIdApplication(gdNic.get(i).getIdApplication().getIdApplication());
			drpCommonEntity.setApplicationNo(gdNic.get(i).getIdApplication().getApplicationNo());
			drpCommonEntity.setApplicationType(gdNic.get(i).getIdApplication().getApplicationType());
			drpCommonEntity.setScannedApplication(gdNic.get(i).getIdApplication().getScannedApplication());
			drpCommonEntity.setScannedGramaNiladhariCertificate(gdNic.get(i).getIdApplication().getScannedGramaNiladhariCertificate());
			drpCommonEntity.setRecievedDate(gdNic.get(i).getIdApplication().getRecievedDate());
			
			drpCommonEntity.setIcaoPhoto(gdNic.get(i).getIdIcaoPhoto().getIcaoPhoto());
			drpCommonEntity.setIdIcaoPhoto(gdNic.get(i).getIdIcaoPhoto().getIdIcaoPhoto());
			
			drpCommonEntity.setIdGeneralDetail(gdNic.get(i).getIdGeneralDetail());
			drpCommonEntity.setNicNo(gdNic.get(i).getNicNo());
			drpCommonEntity.setFamilyName(gdNic.get(i).getFamilyName());
			drpCommonEntity.setName(gdNic.get(i).getName());
			drpCommonEntity.setSurName(gdNic.get(i).getSurName());
			drpCommonEntity.setDob(gdNic.get(i).getDob());
			drpCommonEntity.setGender(gdNic.get(i).getGender());
			drpCommonEntity.setCivilStatus(gdNic.get(i).getCivilStatus());
			drpCommonEntity.setFingerprint(gdNic.get(i).getFingerprint());
			drpCommonEntity.setNicStatus(gdNic.get(i).getNicStatus());
			drpCommonEntity.setRegisteredDate(gdNic.get(i).getRegisteredDate());
			
			if (gdNic.get(i).getIdApplication().getApplicationType().equalsIgnoreCase("renew")) {				
				OldNic oldNic = findAllOldNic.findByAppId(gdNic.get(i).getIdApplication());
				drpCommonEntity.setIdOldNic(oldNic.getIdOldNic());
				drpCommonEntity.setScannedOldNic(oldNic.getScannedOldNic());
				
				
				
			}
			if (gdNic.get(i).getIdApplication().getApplicationType().equalsIgnoreCase("lost")) {
				PoliceReport oldNic = findAPoliceRep.findByAppId(gdNic.get(i).getIdApplication());
				drpCommonEntity.setIdPoliceReport(oldNic.getIdPoliceReport());
				drpCommonEntity.setScannedPoliceReport(oldNic.getScannedPoliceReport());
				
				
			}
			
			if (oldDetails != null) {
				drpCommonEntity.setIdGeneralDetailOld(oldDetails.getIdGeneralDetailOld());
				drpCommonEntity.setExpiredDate(oldDetails.getExpiredDate());
				drpCommonEntity.setComment(oldDetails.getComment());
			}
			
			
			for (int j = 0; j < addressList.size(); j++) {
				if (addressList.get(j).getAddressType().equalsIgnoreCase("permanent")) {
					drpCommonEntity.setIdAddressPermanentDetail(addressList.get(j).getIdAddressDetail());
					drpCommonEntity.setAddressPermanentNo(addressList.get(j).getAddressNo());
					drpCommonEntity.setAddressPermanentStreet1(addressList.get(j).getAddressStreet1());
					drpCommonEntity.setAddressPermanentStreet2(addressList.get(j).getAddressStreet2());
					drpCommonEntity.setAddressPermanentCity(addressList.get(j).getAddressCity());
					drpCommonEntity.setAddressPermanentType(addressList.get(j).getAddressType());
				}
				if (addressList.get(j).getAddressType().equalsIgnoreCase("resident")) {
					drpCommonEntity.setIdAddressResidentDetail(addressList.get(j).getIdAddressDetail());
					drpCommonEntity.setAddressResidentNo(addressList.get(j).getAddressNo());
					drpCommonEntity.setAddressResidentStreet1(addressList.get(j).getAddressStreet1());
					drpCommonEntity.setAddressResidentStreet2(addressList.get(j).getAddressStreet2());
					drpCommonEntity.setAddressResidentCity(addressList.get(j).getAddressCity());
					drpCommonEntity.setAddressResidentType(addressList.get(j).getAddressType());
				}
				
			}
			

			drpCommonEntity.setIdContactDetail(contactDetails.getIdContactDetail());
			drpCommonEntity.setResidentNo(contactDetails.getResidentNo());
			drpCommonEntity.setMobileNo(contactDetails.getMobileNo());
			drpCommonEntity.setEmailAddress(contactDetails.getEmailAddress());

			drpCommonEntity.setIdFamilyDetail(familyDetails.getIdFamilyDetail());
			drpCommonEntity.setMotherNic(familyDetails.getMotherNic());
			drpCommonEntity.setMotherName(familyDetails.getMotherName());
			drpCommonEntity.setFatherNic(familyDetails.getFatherNic());
			drpCommonEntity.setFatherName(familyDetails.getFatherName());
			
			ceNic.add(drpCommonEntity);
		}
		
		return ceNic;
	}
	
}
