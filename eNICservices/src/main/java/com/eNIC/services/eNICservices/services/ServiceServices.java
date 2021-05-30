package com.eNIC.services.eNICservices.services;

import java.sql.Date;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.eNIC.services.eNICservices.PasswordEncript.Encrypt;
import com.eNIC.services.eNICservices.config.JwtTokenUtil;
import com.eNIC.services.eNICservices.entity.CommonService;
import com.eNIC.services.eNICservices.entity.OrganizationContactDetail;
import com.eNIC.services.eNICservices.entity.OrganizationDetail;
import com.eNIC.services.eNICservices.entity.Useraccount;
import com.eNIC.services.eNICservices.orgRepository.OrgContactRepository;
import com.eNIC.services.eNICservices.orgRepository.OrgRepository;
import com.eNIC.services.eNICservices.orgRepository.UserAccRepository;

@Service
public class ServiceServices {

	@Autowired
	private OrgRepository orgRepository;
	
	@Autowired
	private OrgContactRepository orgContactRepository;
	
	@Autowired
	private UserAccRepository userAccRepository;
		
	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Autowired
	private EmailService emailService;
	
	
	@Transactional
	public CommonService registerService(CommonService recOrgDetail) {
					


				OrganizationContactDetail orgContactDetail = new OrganizationContactDetail();
				orgContactDetail.setOrgAddressNo(recOrgDetail.getOrgAddressNo());
				orgContactDetail.setOrgAddressStreet1(recOrgDetail.getOrgAddressStreet1());
				orgContactDetail.setOrgAddressStreet2(recOrgDetail.getOrgAddressStreet2());
				orgContactDetail.setOrgAddressCity(recOrgDetail.getOrgAddressCity());
				orgContactDetail.setOrgContact1(recOrgDetail.getOrgContact1());
				orgContactDetail.setOrgContact2(recOrgDetail.getOrgContact2());
				orgContactDetail.setOrgEmailAddress(recOrgDetail.getOrgEmailAddress());
				
				OrganizationContactDetail savedCtDet = orgContactRepository.save(orgContactDetail);
				
				if (savedCtDet!=null) {
					System.out.print("");
					recOrgDetail.setIdOrgContact(savedCtDet.getIdOrgContact());
					OrganizationDetail orgDetail = new OrganizationDetail();
					orgDetail.setIdOrganization(0);
					orgDetail.setOrganizationType(recOrgDetail.getOrganizationType());
					orgDetail.setOrganizationName(recOrgDetail.getOrganizationName());
					orgDetail.setOrganizationCode(recOrgDetail.getOrganizationCode());
					orgDetail.setOrganizationHeadName(recOrgDetail.getOrganizationHead());
					orgDetail.setOrganizationRequestedDate(new Date(System.currentTimeMillis()));
					orgDetail.setOrganizationStatus("Pending");
					orgDetail.setIdOrgContact(savedCtDet);
					
					OrganizationDetail savedOrgDetail = orgRepository.save(orgDetail);
					recOrgDetail.setIdOrganization(savedOrgDetail.getIdOrganization());
					return recOrgDetail;
				}
	
		
		return null;
	}
	
	
	
	
	public List<OrganizationDetail> getAllServices(){
		
		List<OrganizationDetail> orgs = orgRepository.findAllOrganization();	
		
		return orgs;
		
	}
	
	
	@Transactional
	public OrganizationDetail updateStatus(int oid, String status) throws Exception {
	
	
		OrganizationDetail organizationDetail = orgRepository.findByOrgId(oid);
		organizationDetail.setOrganizationStatus(status);
		
		OrganizationDetail updatedOrgDetail;
		
			if (status.equalsIgnoreCase("Approved")){
			
				Useraccount userAccount = new Useraccount();
				
				String username=organizationDetail.getOrganizationType().substring(0, 3)+organizationDetail.getOrganizationCode();
				String password=Encrypt.encript(organizationDetail.getOrganizationCode());
				
				userAccount.setIdUseraccount(0);
				userAccount.setAccountUsername(username);
				userAccount.setAccountPassword(bcryptEncoder.encode(password));
				userAccount.setCreatedDate(new Date(System.currentTimeMillis()));
				
				Useraccount savedUserAcc =  userAccRepository.save(userAccount);
				
				organizationDetail.setIdUseraccount(savedUserAcc);
				updatedOrgDetail = orgRepository.save(organizationDetail);
				
				if (updatedOrgDetail!=null) {

					
					authenticate(username, password);
					
					final UserDetails userDetails = userDetailsService.loadUserByUsername(updatedOrgDetail.getIdUseraccount().getAccountUsername());
					final String token = jwtTokenUtil.generateToken(userDetails);
					
					
					String msg = updatedOrgDetail.getOrganizationName()+"\n \n Your request to register as a service provider with the DRP has been approved. Below have sent you the username, password and the token."
							+ "\n Username: " + username
							+ "\n Pasword: "+ password
							+ "\n Token: Bearer "+ token;
					
					emailService.sendSimpleMessage(updatedOrgDetail.getIdOrgContact().getOrgEmailAddress(), "Approved request.", msg);
					
				}
				
			}else {
				 updatedOrgDetail = orgRepository.save(organizationDetail);
				 
				 String msg = updatedOrgDetail.getOrganizationName()+"\n \n Your request to register as a service provider with the DRP has been rejected. Please contact DRP for more info.";
				 
				emailService.sendSimpleMessage(updatedOrgDetail.getIdOrgContact().getOrgEmailAddress(), "Rejected request.", msg);
				
				
			}
			
		
		return updatedOrgDetail;
		
	}
	
	
	private void authenticate(String username, String password) throws Exception {
		try {
			System.out.println(username);
			System.out.println(password);
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		
		}
	}


	
}
