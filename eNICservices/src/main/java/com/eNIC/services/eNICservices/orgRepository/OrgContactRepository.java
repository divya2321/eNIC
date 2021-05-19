package com.eNIC.services.eNICservices.orgRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.eNIC.services.eNICservices.entity.OrganizationContactDetail;

public interface OrgContactRepository extends JpaRepository<OrganizationContactDetail, Integer> {

	@Query("SELECT orgct FROM OrganizationContactDetail orgct where orgct.idOrgContact = :idOrgContact") 
	public java.util.List<OrganizationContactDetail> findByOrgId(OrganizationContactDetail idOrgContact);
	
}
