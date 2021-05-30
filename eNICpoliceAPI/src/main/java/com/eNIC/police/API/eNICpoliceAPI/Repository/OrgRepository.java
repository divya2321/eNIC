package com.eNIC.police.API.eNICpoliceAPI.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.eNIC.police.API.eNICpoliceAPI.entity.OrganizationDetail;


public interface OrgRepository extends JpaRepository<OrganizationDetail, Integer> {

	@Query("SELECT org, uacc FROM OrganizationDetail org INNER JOIN Useraccount uacc \r\n"
			+ "ON org.idUseraccount = uacc.idUseraccount WHERE uacc.idUseraccount = :idUseraccount") 
	public OrganizationDetail getOrganization(int idUseraccount);
	
}
