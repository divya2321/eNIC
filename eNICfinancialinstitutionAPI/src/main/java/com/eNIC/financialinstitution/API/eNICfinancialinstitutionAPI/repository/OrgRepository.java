package com.eNIC.financialinstitution.API.eNICfinancialinstitutionAPI.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.eNIC.financialinstitution.API.eNICfinancialinstitutionAPI.entity.OrganizationDetail;


public interface OrgRepository extends JpaRepository<OrganizationDetail, Integer> {

	@Query("SELECT org, uacc FROM OrganizationDetail org INNER JOIN Useraccount uacc \r\n"
			+ "ON org.idUseraccount = uacc.idUseraccount WHERE uacc.idUseraccount = :idUseraccount") 
	public OrganizationDetail getOrganization(int idUseraccount);
	
}
