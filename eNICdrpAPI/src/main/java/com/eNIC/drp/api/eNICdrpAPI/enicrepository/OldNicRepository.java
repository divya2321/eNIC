package com.eNIC.drp.api.eNICdrpAPI.enicrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.eNIC.drp.api.eNICdrpAPI.enicentity.AddressDetail;
import com.eNIC.drp.api.eNICdrpAPI.enicentity.Application;
import com.eNIC.drp.api.eNICdrpAPI.enicentity.GeneralDetail;
import com.eNIC.drp.api.eNICdrpAPI.enicentity.OldNic;

public interface OldNicRepository extends JpaRepository<OldNic, Integer> {

	@Query("SELECT onic FROM OldNic onic where onic.idApplication = :idApplication") 
	public OldNic findByAppId(Application idApplication);
	
}
