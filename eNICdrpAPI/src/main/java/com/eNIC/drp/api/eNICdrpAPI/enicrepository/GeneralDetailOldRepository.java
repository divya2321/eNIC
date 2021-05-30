package com.eNIC.drp.api.eNICdrpAPI.enicrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.eNIC.drp.api.eNICdrpAPI.enicentity.GeneralDetail;
import com.eNIC.drp.api.eNICdrpAPI.enicentity.GeneralDetailOld;

public interface GeneralDetailOldRepository extends JpaRepository<GeneralDetailOld, Integer> {

	@Query("SELECT gdo FROM GeneralDetailOld gdo where gdo.idGeneralDetail = :idGeneralDetail") 
	public java.util.List<GeneralDetailOld> findByNicNo(GeneralDetail idGeneralDetail);
	
	@Query("SELECT gdo FROM GeneralDetailOld gdo where gdo.idGeneralDetail = :idGeneralDetail") 
	public GeneralDetailOld findAllGdo(GeneralDetail idGeneralDetail);
	
}
