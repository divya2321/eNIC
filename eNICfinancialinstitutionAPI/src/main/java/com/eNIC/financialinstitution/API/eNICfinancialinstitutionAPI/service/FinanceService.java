package com.eNIC.financialinstitution.API.eNICfinancialinstitutionAPI.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eNIC.financialinstitution.API.eNICfinancialinstitutionAPI.entity.AddressDetail;
import com.eNIC.financialinstitution.API.eNICfinancialinstitutionAPI.entity.CommonGeneralDetail;
import com.eNIC.financialinstitution.API.eNICfinancialinstitutionAPI.entity.ContactDetail;
import com.eNIC.financialinstitution.API.eNICfinancialinstitutionAPI.entity.GeneralDetail;
import com.eNIC.financialinstitution.API.eNICfinancialinstitutionAPI.exception.ResourceNotFoundException;
import com.eNIC.financialinstitution.API.eNICfinancialinstitutionAPI.repository.AddressDetailRepository;
import com.eNIC.financialinstitution.API.eNICfinancialinstitutionAPI.repository.ContactDetailRepository;
import com.eNIC.financialinstitution.API.eNICfinancialinstitutionAPI.repository.GeneralDetailRepository;
import com.eNIC.financialinstitution.API.eNICfinancialinstitutionAPI.repository.OrgRepository;
import com.eNIC.financialinstitution.API.eNICfinancialinstitutionAPI.repository.UserAccountRepository;


@Service
public class FinanceService {

	@Autowired
	GeneralDetailRepository generalDetailRepository;
	
	@Autowired
	AddressDetailRepository addressDetailRepository;
	
	@Autowired
	ContactDetailRepository contactDetailRepository;
	
	@Autowired
	UserAccountRepository userAccRepository;
	
	@Autowired
	OrgRepository orgRepository;

	@Transactional
	public CommonGeneralDetail getGeneralDetail(String nicNo) {
		
		CommonGeneralDetail commonGeneralDetail = new CommonGeneralDetail();
		GeneralDetail generalDetail =null;
	
			generalDetail = generalDetailRepository.findByNic(nicNo);
	
		
		if (generalDetail != null) {
			
			commonGeneralDetail.setNicNo(generalDetail.getNicNo());
			commonGeneralDetail.setName(generalDetail.getName());
			commonGeneralDetail.setFamilyName(generalDetail.getFamilyName());
			commonGeneralDetail.setSurName(generalDetail.getSurName());
			commonGeneralDetail.setDob(generalDetail.getDob());
			commonGeneralDetail.setGender(generalDetail.getGender());
			commonGeneralDetail.setCivilStatus(generalDetail.getCivilStatus());
			commonGeneralDetail.setFingerprint(generalDetail.getFingerprint());
			
			List<AddressDetail> addressDetails = addressDetailRepository.getAddresses(generalDetail.getIdGeneralDetail());
			ContactDetail contactDetail = contactDetailRepository.getContact(generalDetail.getIdGeneralDetail());
			
			for (int i = 0; i < addressDetails.size(); i++) {				

				AddressDetail addressDetail = addressDetails.get(i);
				
				switch (addressDetail.getAddressType().toLowerCase()) {
				case "permanent":
					commonGeneralDetail.setAddressPermanentNo(addressDetail.getAddressNo());
					commonGeneralDetail.setAddressPermanentStreet1(addressDetail.getAddressStreet1());
					commonGeneralDetail.setAddressPermanentStreet2(addressDetail.getAddressStreet2());
					commonGeneralDetail.setAddressPermanentCity(addressDetail.getAddressCity());
					break;
					
				case "resident":
					commonGeneralDetail.setAddressResidentNo(addressDetail.getAddressNo());
					commonGeneralDetail.setAddressResidentStreet1(addressDetail.getAddressStreet1());
					commonGeneralDetail.setAddressResidentStreet2(addressDetail.getAddressStreet2());
					commonGeneralDetail.setAddressResidentCity(addressDetail.getAddressCity());
					break;

				default:
					break;
				}
			
				commonGeneralDetail.setResidentNo(contactDetail.getResidentNo());
				commonGeneralDetail.setMobileNo(contactDetail.getMobileNo());
				commonGeneralDetail.setEmailAddress(contactDetail.getEmailAddress());
			}
		}else {
			throw new ResourceNotFoundException("There is no person for the requested detail");
		}
		
			return commonGeneralDetail;
	}
	
	

	
}
