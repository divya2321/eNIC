package com.eNIC.drp.api.eNICdrpAPI.enicrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.eNIC.drp.api.eNICdrpAPI.enicentity.ContactDetail;
import com.eNIC.drp.api.eNICdrpAPI.enicentity.GeneralDetail;

public interface ContactDetailRepository extends JpaRepository<ContactDetail, Integer> {

	//getting contact detail and application by NIC
			@Query("SELECT cnt FROM ContactDetail cnt where cnt.idGeneralDetail = :idGeneralDetail") 
			public ContactDetail findByNicNo(GeneralDetail idGeneralDetail);
	
			@Query("SELECT cnt FROM ContactDetail cnt where cnt.idGeneralDetail = :idGeneralDetail") 
			public ContactDetail findByGdId(GeneralDetail idGeneralDetail);
}
