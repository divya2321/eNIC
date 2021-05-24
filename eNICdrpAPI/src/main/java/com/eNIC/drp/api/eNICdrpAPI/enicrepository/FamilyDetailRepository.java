package com.eNIC.drp.api.eNICdrpAPI.enicrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.eNIC.drp.api.eNICdrpAPI.enicentity.FamilyDetail;
import com.eNIC.drp.api.eNICdrpAPI.enicentity.GeneralDetail;

public interface FamilyDetailRepository extends JpaRepository<FamilyDetail, Integer> {

	//getting family detail and application by NIC
			@Query("SELECT fam FROM FamilyDetail fam where fam.idGeneralDetail = :idGeneralDetail") 
			public FamilyDetail findByNicNo(GeneralDetail idGeneralDetail);
			
			@Query("SELECT fam FROM FamilyDetail fam where fam.idGeneralDetail = :idGeneralDetail") 
			public FamilyDetail findByGdId(GeneralDetail idGeneralDetail);
			
}
