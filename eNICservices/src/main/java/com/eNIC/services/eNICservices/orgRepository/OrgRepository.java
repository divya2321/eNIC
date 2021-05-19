package com.eNIC.services.eNICservices.orgRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.eNIC.services.eNICservices.entity.OrganizationDetail;

public interface OrgRepository extends JpaRepository<OrganizationDetail, Integer> {

	@Query("SELECT orgdet FROM OrganizationDetail orgdet") 
	public java.util.List<OrganizationDetail> findAllOrganization();
	
	@Query("SELECT orgdet FROM OrganizationDetail orgdet where orgdet.idOrganization = :idOrganization") 
	public OrganizationDetail findByOrgId(int idOrganization);
	
}
