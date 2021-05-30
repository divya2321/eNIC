package com.eNIC.police.API.eNICpoliceAPI.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.eNIC.police.API.eNICpoliceAPI.Repository.AddressDetailRepository;
import com.eNIC.police.API.eNICpoliceAPI.Repository.ContactDetailRepository;
import com.eNIC.police.API.eNICpoliceAPI.Repository.CriminalRecordRepository;
import com.eNIC.police.API.eNICpoliceAPI.Repository.FamilyDetailRepository;
import com.eNIC.police.API.eNICpoliceAPI.Repository.GeneralDetailRepository;
import com.eNIC.police.API.eNICpoliceAPI.Repository.OrgRepository;
import com.eNIC.police.API.eNICpoliceAPI.Repository.UserAccRepository;
import com.eNIC.police.API.eNICpoliceAPI.entity.AddressDetail;
import com.eNIC.police.API.eNICpoliceAPI.entity.CommonCriminalRecord;
import com.eNIC.police.API.eNICpoliceAPI.entity.CommonGeneralDetail;
import com.eNIC.police.API.eNICpoliceAPI.entity.ContactDetail;
import com.eNIC.police.API.eNICpoliceAPI.entity.CriminalRecord;
import com.eNIC.police.API.eNICpoliceAPI.entity.FamilyDetail;
import com.eNIC.police.API.eNICpoliceAPI.entity.GeneralDetail;
import com.eNIC.police.API.eNICpoliceAPI.entity.OrganizationDetail;
import com.eNIC.police.API.eNICpoliceAPI.exception.ResourceNotFoundException;


@Service
public class PoliceService {

	@Autowired
	GeneralDetailRepository generalDetailRepository;
	
	@Autowired
	AddressDetailRepository addressDetailRepository;
	
	@Autowired
	ContactDetailRepository contactDetailRepository;
	
	@Autowired
	FamilyDetailRepository familyDetailRepository;
	
	@Autowired
	UserAccRepository userAccRepository;
	
	@Autowired
	CriminalRecordRepository criminalRecordRepository;
	
	@Autowired
	OrgRepository orgRepository;

	@Transactional
	public Map<String, Object> viewCriminalRecords(String nicNo) {
		
		HashMap<String, Object> results = new HashMap<String, Object>();
		GeneralDetail activeGeneralDetail = null;
		List<CommonCriminalRecord> ccrs = new ArrayList<CommonCriminalRecord>();	
		
		List<GeneralDetail> searchedGd = null;
		int gdId = 0;
		
			searchedGd = generalDetailRepository.findPersonAll(nicNo);	
			activeGeneralDetail = generalDetailRepository.findByNic(nicNo);

		
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
											
						System.out.println("Useracc ID:"+searchedCr.get(j).getIdUseraccount().getIdUseraccount());
						OrganizationDetail organizationDetail = orgRepository.getOrganization(searchedCr.get(j).getIdUseraccount().getIdUseraccount());
						ccr.setOrgName(organizationDetail.getOrganizationName());
						
						ccrs.add(ccr);
					}
				}
				
			}
			
			
		 
		}else {
			throw new ResourceNotFoundException("There are no searched general details for the data you provided");
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
			cgd.setFingerprint(activeGeneralDetail.getFingerprint());
			
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
		}else {
			
			throw new ResourceNotFoundException("There is no prson under the provided detail.");
			
		}
		
		results.put("Crimes", ccrs);
		results.put("Generals", cgd);
	
		return results;
	}
	
	

}
