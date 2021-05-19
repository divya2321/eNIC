package com.eNIC.financialinstitution.API.eNICfinancialinstitutionAPI.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eNIC.financialinstitution.API.eNICfinancialinstitutionAPI.entity.AddressDetail;
import com.eNIC.financialinstitution.API.eNICfinancialinstitutionAPI.entity.CommonGeneralDetail;
import com.eNIC.financialinstitution.API.eNICfinancialinstitutionAPI.entity.ContactDetail;
import com.eNIC.financialinstitution.API.eNICfinancialinstitutionAPI.entity.GeneralDetail;
import com.eNIC.financialinstitution.API.eNICfinancialinstitutionAPI.repository.AddressDetailRepository;
import com.eNIC.financialinstitution.API.eNICfinancialinstitutionAPI.repository.ContactDetailRepository;
import com.eNIC.financialinstitution.API.eNICfinancialinstitutionAPI.repository.GeneralDetailRepository;




@Service
public class FinanceService {

	@Autowired
	GeneralDetailRepository generalDetailRepository;
	
	@Autowired
	AddressDetailRepository addressDetailRepository;
	
	@Autowired
	ContactDetailRepository contactDetailRepository;

	@Transactional
	public CommonGeneralDetail getGeneralDetail(String detail, String type) {
		
		CommonGeneralDetail commonGeneralDetail = new CommonGeneralDetail();
		GeneralDetail generalDetail =null;
		
		switch (type.toLowerCase()) {
		case "nicno":
			generalDetail = generalDetailRepository.findByNic(detail);
			break;
			
		case "fingerprint":
			generalDetail = generalDetailRepository.findByFingerprint(detail);			
			break;

		default:
			break;
		}
		
		
		if (generalDetail != null) {
			
			commonGeneralDetail.setNicNo(generalDetail.getNicNo());
			commonGeneralDetail.setFamilyName(generalDetail.getFamilyName());
			commonGeneralDetail.setSurName(generalDetail.getSurName());
			commonGeneralDetail.setDob(generalDetail.getDob());
			commonGeneralDetail.setGender(generalDetail.getGender());
			commonGeneralDetail.setCivilStatus(generalDetail.getCivilStatus());
			
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
					commonGeneralDetail.setAddressPermanentType(addressDetail.getAddressType());
					break;
					
				case "resident":
					commonGeneralDetail.setAddressResidentNo(addressDetail.getAddressNo());
					commonGeneralDetail.setAddressResidentStreet1(addressDetail.getAddressStreet1());
					commonGeneralDetail.setAddressResidentStreet2(addressDetail.getAddressStreet2());
					commonGeneralDetail.setAddressResidentCity(addressDetail.getAddressCity());
					commonGeneralDetail.setAddressResidentType(addressDetail.getAddressType());
					break;

				default:
					break;
				}
			
				commonGeneralDetail.setResidentNo(contactDetail.getResidentNo());
				commonGeneralDetail.setMobileNo(contactDetail.getMobileNo());
				commonGeneralDetail.setEmailAddress(contactDetail.getEmailAddress());
			}
		}
		
			return commonGeneralDetail;
	}
	
}
