package com.eNIC.financialinstitution.API.eNICfinancialinstitutionAPI.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.eNIC.financialinstitution.API.eNICfinancialinstitutionAPI.entity.ContactDetail;

public interface ContactDetailRepository extends JpaRepository<ContactDetail, Integer> {

	@Query("SELECT ctd FROM ContactDetail ctd INNER JOIN GeneralDetail gdp   \r\n"
			+ "	ON \r\n"
			+ "	gdp.idGeneralDetail = ctd.idGeneralDetail \r\n"
			+ " where gdp.idGeneralDetail = :idGeneralDetail")
	public ContactDetail getContact(int idGeneralDetail);
	
}
