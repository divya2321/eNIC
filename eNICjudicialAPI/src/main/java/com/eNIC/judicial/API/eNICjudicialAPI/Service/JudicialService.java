package com.eNIC.judicial.API.eNICjudicialAPI.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eNIC.judicial.API.eNICjudicialAPI.Repository.AddressDetailRepository;
import com.eNIC.judicial.API.eNICjudicialAPI.Repository.ContactDetailRepository;
import com.eNIC.judicial.API.eNICjudicialAPI.Repository.CriminalRecordRepository;
import com.eNIC.judicial.API.eNICjudicialAPI.Repository.FamilyDetailRepository;
import com.eNIC.judicial.API.eNICjudicialAPI.Repository.GeneralDetailRepository;
import com.eNIC.judicial.API.eNICjudicialAPI.Repository.OrgRepository;
import com.eNIC.judicial.API.eNICjudicialAPI.Repository.UserAccRepository;
import com.eNIC.judicial.API.eNICjudicialAPI.entity.AddressDetail;
import com.eNIC.judicial.API.eNICjudicialAPI.entity.CommonCriminalRecord;
import com.eNIC.judicial.API.eNICjudicialAPI.entity.CommonGeneralDetail;
import com.eNIC.judicial.API.eNICjudicialAPI.entity.ContactDetail;
import com.eNIC.judicial.API.eNICjudicialAPI.entity.CriminalRecord;
import com.eNIC.judicial.API.eNICjudicialAPI.entity.FamilyDetail;
import com.eNIC.judicial.API.eNICjudicialAPI.entity.GeneralDetail;
import com.eNIC.judicial.API.eNICjudicialAPI.entity.OrganizationDetail;
import com.eNIC.judicial.API.eNICjudicialAPI.entity.Useraccount;
import com.eNIC.judicial.API.eNICjudicialAPI.Exception.ResourceNotFoundException;



@Service
public class JudicialService {

	@Autowired
	GeneralDetailRepository generalDetailRepository;
	
	@Autowired
	ContactDetailRepository contactDetailRepository;
	
	@Autowired
	AddressDetailRepository addressDetailRepository;
	
	@Autowired
	FamilyDetailRepository familyDetailRepository;
	
	@Autowired
	UserAccRepository userAccRepository;
	
	@Autowired
	CriminalRecordRepository criminalRecordRepository;
	
	@Autowired
	OrgRepository orgRepository;

	@Transactional
	public CommonCriminalRecord saveCriminalRecord(CommonCriminalRecord ccr) {
		
		GeneralDetail generalDetail = generalDetailRepository.findByNic(ccr.getNicNo());
		
		System.out.println(ccr.getNicNo());
		Useraccount useraccount = userAccRepository.findByUsername(ccr.getUsername());
		System.out.println(useraccount);
		
		if (!(generalDetail ==  null || useraccount == null)) {
			System.out.println("###################################################");
			CriminalRecord criminalRecord = new CriminalRecord();
			criminalRecord.setIdCriminalRecord(0);
			criminalRecord.setCriminalRecord(ccr.getCriminalRecord());
			criminalRecord.setCriminalReport(ccr.getCriminalReport());
			criminalRecord.setCriminalDiscription(ccr.getCriminalDiscription());
			criminalRecord.setRecordDate(new Date(System.currentTimeMillis()));
			
			criminalRecord.setIdGeneralDetail(generalDetail);
			criminalRecord.setIdUseraccount(useraccount);
			
			CriminalRecord savedCriminalRecord = criminalRecordRepository.save(criminalRecord);
			
			ccr.setIdCriminalRecord(savedCriminalRecord.getIdCriminalRecord());
			ccr.setIdGeneralDetail(savedCriminalRecord.getIdGeneralDetail());
			ccr.setCriminalRecord(savedCriminalRecord.getCriminalRecord());
			ccr.setRecordDate(savedCriminalRecord.getRecordDate());
			
		}else {
			throw new ResourceNotFoundException("Either the General detail or User acount you provided is incorrect");
		}
		
		
		
		return ccr;
	}
	
	@Transactional
	public Map<String, Object> viewCriminalRecords(String detail, String  type) {
		
		HashMap<String, Object> results = new HashMap<String, Object>();
		GeneralDetail activeGeneralDetail = null;
		List<CommonCriminalRecord> ccrs = new ArrayList<CommonCriminalRecord>();	
		
		List<GeneralDetail> searchedGd = null;
		int gdId = 0;
		switch (type.toLowerCase()) {
		case "nicno":
			
			System.out.println("Switched");
			searchedGd = generalDetailRepository.findPersonAll(detail);	
			activeGeneralDetail = generalDetailRepository.findByNic(detail);
			break;
			
		case "fingerprint":	
			

			searchedGd = generalDetailRepository.findPersonFinAll(detail);	
			activeGeneralDetail = generalDetailRepository.findByFingerprint(detail);
			break;
			
		default:
			break;
		}
		
		if (!searchedGd.isEmpty()) {
			
			System.out.println("Have Records");
			for (int i = 0; i < searchedGd.size(); i++) {
				GeneralDetail gd = searchedGd.get(i);
				gdId = gd.getIdGeneralDetail();
				System.out.println(gdId);
				
				List<CriminalRecord> searchedCr = criminalRecordRepository.getCriminalRecordById(gdId);
				System.out.println("Hi");
				if (!searchedCr.isEmpty()) {
					System.out.println("Have Records");
					for (int j = 0; j < searchedCr.size(); j++) {
						CommonCriminalRecord ccr = new CommonCriminalRecord();
						ccr.setIdCriminalRecord(searchedCr.get(j).getIdCriminalRecord());
						ccr.setCriminalRecord(searchedCr.get(j).getCriminalRecord());
						ccr.setCriminalReport(searchedCr.get(j).getCriminalReport());
						ccr.setCriminalDiscription(searchedCr.get(j).getCriminalDiscription());
						ccr.setRecordDate(searchedCr.get(j).getRecordDate());
						System.out.println(searchedCr.get(j).getRecordDate());
							System.out.println(ccr.getRecordDate());				
						System.out.println("Useracc ID:"+searchedCr.get(j).getIdUseraccount().getIdUseraccount());
						OrganizationDetail organizationDetail = orgRepository.getOrganization(searchedCr.get(j).getIdUseraccount().getIdUseraccount());
						ccr.setOrgName(organizationDetail.getOrganizationName());
						
						ccrs.add(ccr);
					}
				}else {
					
//					throw new DFileNotFoundException("There are no criminal history for this person");
				}
				
			}
			
			
		 
		}else {
//			throw new ResourceNotFoundException("There are no searched general details for the data you provided");
		}
		
		CommonGeneralDetail cgd = new CommonGeneralDetail();
	
		if (activeGeneralDetail != null) {
			ContactDetail contactDetail = contactDetailRepository.getContact(activeGeneralDetail.getIdGeneralDetail());
			List<AddressDetail> addressDetails = addressDetailRepository.getAddresses(activeGeneralDetail.getIdGeneralDetail());
			FamilyDetail familyDetail = familyDetailRepository.getFamily(activeGeneralDetail.getIdGeneralDetail());
		
			cgd.setIdGeneralDetail(activeGeneralDetail.getIdGeneralDetail());
			cgd.setNicNo(activeGeneralDetail.getNicNo());
			cgd.setFamilyName(activeGeneralDetail.getFamilyName());
			cgd.setName(activeGeneralDetail.getName());
			cgd.setSurName(activeGeneralDetail.getSurName());
			cgd.setDob(activeGeneralDetail.getDob());
			cgd.setGender(activeGeneralDetail.getGender());
			cgd.setCivilStatus(activeGeneralDetail.getCivilStatus());
			
			cgd.setIdContactDetail(contactDetail.getIdContactDetail());
			cgd.setResidentNo(contactDetail.getResidentNo());
			cgd.setMobileNo(contactDetail.getMobileNo());
			cgd.setEmailAddress(contactDetail.getEmailAddress());
			
			for (int i = 0; i < addressDetails.size(); i++) {
				AddressDetail addressDetail = addressDetails.get(i);
				if (addressDetail.getAddressType().equalsIgnoreCase("permanent")) {
					cgd.setIdAddressPermanentDetail(addressDetail.getIdAddressDetail());
					cgd.setAddressPermanentNo(addressDetail.getAddressNo());
					cgd.setAddressPermanentStreet1(addressDetail.getAddressStreet1());
					cgd.setAddressPermanentStreet2(addressDetail.getAddressStreet2());
					cgd.setAddressPermanentCity(addressDetail.getAddressCity());
				}
				if (addressDetail.getAddressType().equalsIgnoreCase("resident")) {
					cgd.setIdAddressResidentDetail(addressDetail.getIdAddressDetail());
					cgd.setAddressResidentNo(addressDetail.getAddressNo());
					cgd.setAddressResidentStreet1(addressDetail.getAddressStreet1());
					cgd.setAddressResidentStreet2(addressDetail.getAddressStreet2());
					cgd.setAddressResidentCity(addressDetail.getAddressCity());
				}
			}
					
			cgd.setIdFamilyDetail(familyDetail.getIdFamilyDetail());
			cgd.setMotherNic(familyDetail.getMotherNic());
			cgd.setMotherName(familyDetail.getMotherName());
			cgd.setFatherNic(familyDetail.getFatherNic());
			cgd.setFatherName(familyDetail.getFatherName());
		}
		
		results.put("Crimes", ccrs);
		results.put("Generals", cgd);
	System.out.println(ccrs.get(0).getRecordDate());
	ArrayList<CommonCriminalRecord> cast = (ArrayList<CommonCriminalRecord>) results.get("Crimes");
	System.out.println(cast.get(0).getRecordDate());
		return results;
	}
}
