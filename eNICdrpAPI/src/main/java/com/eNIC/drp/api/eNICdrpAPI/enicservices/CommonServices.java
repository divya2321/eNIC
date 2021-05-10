package com.eNIC.drp.api.eNICdrpAPI.enicservices;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

import ch.qos.logback.core.joran.conditional.ElseAction;

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

	public DRPCommonEntity commonCreate(DRPCommonEntity drpCommonEntity) {
		
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
			if (appType.equalsIgnoreCase("new")) {
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String dobtext = sdf.format(drpCommonEntity.getDob());
				
				String firsthaldNIC = NICAlgo.NICAlgoMethod(dobtext, drpCommonEntity.getGender());
				List<GeneralDetail> dobrecord = generalDetailRepository.findByDob(drpCommonEntity.getDob());
				
				int recno = dobrecord.size(); 
				
				
				if (recno!=0) {			
					String recnotext = String.valueOf(recno);
					
					int recnolength = String.valueOf(recno).length()+1;
					
					if (recnolength<100000) {
						switch(recnolength) {  
						case 1:
							nicNo = firsthaldNIC+"0000"+recnotext;
				            break;
				        case 2:
				        	nicNo = firsthaldNIC+"000"+recnotext;
				            break;
				        case 3:
				        	nicNo = firsthaldNIC+"00"+recnotext;
				            break;
				        case 4:
				        	nicNo = firsthaldNIC+"0"+recnotext;
				            break;
				        default:
				        	nicNo = firsthaldNIC+recnotext;
						}
					} else {
//						Exceededd nic numbers
					}			
					}else {
					nicNo = firsthaldNIC+"00001";
				}
				
			} else if (appType.equalsIgnoreCase("renew") || appType.equalsIgnoreCase("lost")) {
				System.out.println(String.valueOf(drpCommonEntity.getOldNicNo()));
				GeneralDetail foundOldNic = generalDetailRepository.findByNicNo(drpCommonEntity.getOldNicNo().trim());
				GeneralDetail updateGeneralDetailRecord = foundOldNic;
				updateGeneralDetailRecord.setNicStatus(false);
				generalDetailRepository.save(updateGeneralDetailRecord);
				System.out.println("finding old record");		
				
				if (foundOldNic!=null) {
					nicNo = foundOldNic.getNicNo();
					System.out.println("Found previous record");
				}else {
					System.out.println("No previous record");
				}
				
				OldNic savedOldNic=null;
				PoliceReport savedPoliceReport=null;
				
					if (appType.equalsIgnoreCase("renew")) {
						
						OldNic oldNic = new OldNic();
						oldNic.setIdOldNic(0);
						oldNic.setScannedOldNic(drpCommonEntity.getScannedOldNic());
						oldNic.setIdApplication(application);
						savedOldNic = oldNicRepository.save(oldNic);	
						
					} else {
						
						PoliceReport policeReport = new PoliceReport();
						policeReport.setIdPoliceReport(0);
						policeReport.setScannedPoliceReport(drpCommonEntity.getScannedPoliceReport());
						policeReport.setIdApplication(application);
						savedPoliceReport = policeReportRepository.save(policeReport);	
					} 
					
					if (savedOldNic != null || savedPoliceReport != null) {
						System.out.println("*********IT IS NOT A NEW");
							GeneralDetailOld generalDetailOld = new GeneralDetailOld();
							generalDetailOld.setIdGeneralDetailOld(0);
							generalDetailOld.setExpiredDate(drpCommonEntity.getExpiredDate());
							generalDetailOld.setComment(drpCommonEntity.getComment());
							generalDetailOld.setIdGeneralDetail(foundOldNic);
							generalDetailOldRepository.save(generalDetailOld);
						}else {
							System.out.println("No previous record");
						}
					
			} 			
			
			IcaoPhoto icaoPhoto = new IcaoPhoto();
			icaoPhoto.setIdIcaoPhoto(0);
			icaoPhoto.setIcaoPhoto(drpCommonEntity.getIcaoPhoto());
			IcaoPhoto savedIcaoPhoto = icaoPhotoRepository.save(icaoPhoto);
			
			if (savedIcaoPhoto != null) {
				
				GeneralDetail generalDetail = new GeneralDetail();
				generalDetail.setIdGeneralDetail(0);
				generalDetail.setNicNo(nicNo);
				generalDetail.setFamilyName(drpCommonEntity.getFamilyName());
				generalDetail.setName(drpCommonEntity.getName());
				generalDetail.setSurName(drpCommonEntity.getSurName());
				generalDetail.setDob(drpCommonEntity.getDob());
				generalDetail.setGender(drpCommonEntity.getGender());
				generalDetail.setCivilStatus(drpCommonEntity.getCivilStatus());
				generalDetail.setRegisteredDate(drpCommonEntity.getRegisteredDate());
				generalDetail.setFingerprint(drpCommonEntity.getFingerprint());
				generalDetail.setIdIcaoPhoto(savedIcaoPhoto);
				generalDetail.setIdApplication(savedApplication);
				generalDetail.setNicStatus(true);
				GeneralDetail savedGeneralDetail = generalDetailRepository.save(generalDetail);
				
				if (savedGeneralDetail != null) {
					
					ContactDetail contactDetail = new ContactDetail();
					contactDetail.setIdContactDetail(0);
					contactDetail.setResidentNo(drpCommonEntity.getResidentNo());
					contactDetail.setMobileNo(drpCommonEntity.getMobileNo());
					contactDetail.setEmailAddress(drpCommonEntity.getEmailAddress());
					contactDetail.setIdGeneralDetail(savedGeneralDetail);
					contactDetailRepository.save(contactDetail);
					
					AddressDetail addressDetail;					
					if (drpCommonEntity.getAddressPermanentNo()!=null) {
						addressDetail = new AddressDetail();
						addressDetail.setIdAddressDetail(0);
						addressDetail.setAddressNo(drpCommonEntity.getAddressPermanentNo());
						addressDetail.setAddressStreet1(drpCommonEntity.getAddressPermanentStreet1());
						addressDetail.setAddressStreet2(drpCommonEntity.getAddressPermanentStreet2());
						addressDetail.setAddressCity(drpCommonEntity.getAddressPermanentCity());
						addressDetail.setAddressType(drpCommonEntity.getAddressPermanentType());
						addressDetail.setIdGeneralDetail(savedGeneralDetail);
						addressDetailRepository.save(addressDetail);
					}
					if (drpCommonEntity.getAddressResidentNo()!=null) {
						addressDetail = new AddressDetail();
						addressDetail.setIdAddressDetail(0);
						addressDetail.setAddressNo(drpCommonEntity.getAddressResidentNo());
						addressDetail.setAddressStreet1(drpCommonEntity.getAddressResidentStreet1());
						addressDetail.setAddressStreet2(drpCommonEntity.getAddressResidentStreet2());
						addressDetail.setAddressCity(drpCommonEntity.getAddressResidentCity());
						addressDetail.setAddressType(drpCommonEntity.getAddressResidentType());
						addressDetail.setIdGeneralDetail(savedGeneralDetail);
						addressDetailRepository.save(addressDetail);
					}
										
					FamilyDetail familyDetail = new FamilyDetail();
					familyDetail.setIdFamilyDetail(0);
					familyDetail.setMotherNic(drpCommonEntity.getMotherNic());
					familyDetail.setMotherName(drpCommonEntity.getMotherName());
					familyDetail.setFatherNic(drpCommonEntity.getFatherNic());
					familyDetail.setFatherName(drpCommonEntity.getFatherName());
					familyDetail.setIdGeneralDetail(savedGeneralDetail);
					familyDetailRepository.save(familyDetail);
					
					return drpCommonEntity;
					
				} else {					
//				general detail
				}
				
				
			} else {
//				icao photo
			}

		} else {
			System.out.println("Error in Application");
		}
		
		
		return null;
	}
	
	@Autowired
	GeneralDetailRepository generalDetailRepositoryfind;

	public List commonFindAllNicDetail() {
		System.out.println("Got All");
		List<Object> foundAll = generalDetailRepositoryfind.findAllNicDetails();
		GeneralDetail generalDetail = (GeneralDetail) foundAll.get(0);
		Application application = (Application)foundAll.get(1);
		IcaoPhoto icaoPhoto = (IcaoPhoto)foundAll.get(2);
		AddressDetail addressDetail = (AddressDetail)foundAll.get(3);
		ContactDetail contactDetail = (ContactDetail)foundAll.get(4);
		FamilyDetail familyDetail = (FamilyDetail)foundAll.get(5);
		List<Object> returnList = new ArrayList<Object>();
		returnList.add(generalDetail);
		returnList.add(application);
		returnList.add(icaoPhoto);
		returnList.add(addressDetail);
		returnList.add(contactDetail);
		returnList.add(familyDetail);
		return returnList;
	}
	
}
