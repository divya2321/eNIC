package com.eNIC.drp.api.eNICdrpAPI.enicrepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.eNIC.drp.api.eNICdrpAPI.enicentity.GeneralDetail;

public interface GeneralDetailRepository extends JpaRepository<GeneralDetail, Integer> {

	@Query("SELECT gd FROM GeneralDetail gd where nicStatus = true and gd.nicNo = :nicNo") 
	public GeneralDetail findByNicNo(String nicNo);
	

	@Query("SELECT gdb FROM GeneralDetail gdb where gdb.dob = :dob") 
	public List<GeneralDetail> findByDob(Date dob);
	
	
	@Query("SELECT gd, app, ic, ad, cd, fd FROM GeneralDetail gd \r\n"
			+ "	INNER JOIN Application app   \r\n"
			+ "	ON\r\n"
			+ "	gd.idApplication = app.idApplication \r\n"
			+ "	INNER JOIN IcaoPhoto ic \r\n"
			+ "	ON\r\n"
			+ "	gd.idIcaophoto = ic.idIcaoPhoto \r\n"
			+ "	INNER JOIN contactdetail cd \r\n"
			+ "	ON\r\n"
			+ "	gd.idGeneralDetail = ct.idGeneralDetail \r\n"
			+ "	INNER JOIN addressdetail ad \r\n"
			+ "	ON \r\n"
			+ "	gd.idGeneralDetail = ad.idGeneralDetail \r\n"
			+ "	INNER JOIN familydetail fd \r\n"
			+ "	ON \r\n"
			+ "	gd.idGeneralDetail = fd.idGeneralDetail ")
	public List<Object> findAllNicDetails();
	
	
	
	
	
}
