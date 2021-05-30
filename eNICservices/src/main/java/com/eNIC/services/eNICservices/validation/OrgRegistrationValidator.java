package com.eNIC.services.eNICservices.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Validator;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import com.eNIC.services.eNICservices.entity.CommonService;
import com.eNIC.services.eNICservices.orgRepository.OrgRepository;

@Component
public class OrgRegistrationValidator implements Validator {

	@Autowired
	OrgRepository orgRepository;
	
    @Override
    public boolean supports(Class<?> aClass) {
        return CommonService.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
    	CommonService service = (CommonService) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "organizationName", "NotEmpty");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "organizationCode", "NotEmpty");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "organizationHead", "NotEmpty");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "orgAddressNo", "NotEmpty");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "orgAddressStreet1", "NotEmpty");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "orgAddressCity", "NotEmpty");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "orgContact1", "NotEmpty");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "orgContact2", "NotEmpty");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "orgEmailAddress", "NotEmpty");
        
        if(!service.getOrganizationName().isEmpty()) {
        	if(orgRepository.findByOrgName(service.getOrganizationName()) != null) {
        		 errors.rejectValue("organizationName", "Duplicate.Org.service");
        	}
        }
        
        if(!service.getOrganizationCode().isEmpty()) {
        	if(orgRepository.findByOrgCode(service.getOrganizationCode()) != null) {
       		 errors.rejectValue("organizationCode", "Duplicate.Org.service");
        	}
        }
        
        if(!service.getOrgContact1().isEmpty()) {
        if (service.getOrgContact1().length() != 10) {
            errors.rejectValue("orgContact1", "Size.Org.tel");
        }
        }
        
        
        if(!service.getOrgContact2().isEmpty()) {
            if (service.getOrgContact2().length() != 10) {
                errors.rejectValue("orgContact2", "Size.Org.tel");
        }
        }
        
        
        
       
    }
}