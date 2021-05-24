package com.eNIC.judicial.API.eNICjudicialAPI.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.eNIC.judicial.API.eNICjudicialAPI.entity.FamilyDetail;

public interface FamilyDetailRepository extends JpaRepository<FamilyDetail, Integer> {

	@Query("SELECT fmd FROM FamilyDetail fmd INNER JOIN GeneralDetail gdp   \r\n"
			+ "	ON \r\n"
			+ "	gdp.idGeneralDetail = fmd.idGeneralDetail \r\n"
			+ " where gdp.idGeneralDetail = :idGeneralDetail")
	public FamilyDetail getFamily(int idGeneralDetail);
}
