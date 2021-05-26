package com.eNIC.services.eNICservices.orgRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.eNIC.services.eNICservices.entity.OrganizationDetail;

public interface OrgRepository extends JpaRepository<OrganizationDetail, Integer> {

	@Query("SELECT orgdet FROM OrganizationDetail orgdet") 
	public java.util.List<OrganizationDetail> findAllOrganization();
	
	@Query("SELECT orgdet FROM OrganizationDetail orgdet where orgdet.idOrganization = :idOrganization") 
	public OrganizationDetail findByOrgId(int idOrganization);
	
	@Query("SELECT orgdet FROM OrganizationDetail orgdet \r\n"
			+ "	INNER JOIN Useraccount uacc   \r\n"
			+ "	ON\r\n"
			+ "	uacc.idUseraccount = orgdet.idUseraccount")
	public OrganizationDetail findByUserAccId(int idUseraccount);
	
}
