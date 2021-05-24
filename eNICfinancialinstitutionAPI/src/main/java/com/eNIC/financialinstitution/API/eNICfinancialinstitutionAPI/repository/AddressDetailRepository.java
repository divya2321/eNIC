package com.eNIC.financialinstitution.API.eNICfinancialinstitutionAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.eNIC.financialinstitution.API.eNICfinancialinstitutionAPI.entity.AddressDetail;

public interface AddressDetailRepository extends JpaRepository<AddressDetail, Integer> {
	
	@Query("SELECT addr FROM AddressDetail addr INNER JOIN GeneralDetail gdp   \r\n"
			+ "	ON \r\n"
			+ "	gdp.idGeneralDetail = addr.idGeneralDetail \r\n"
			+ " where gdp.idGeneralDetail = :idGeneralDetail")
	public List<AddressDetail> getAddresses(int idGeneralDetail);

}