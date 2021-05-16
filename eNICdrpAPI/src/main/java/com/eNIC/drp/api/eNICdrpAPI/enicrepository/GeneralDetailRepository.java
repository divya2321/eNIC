package com.eNIC.drp.api.eNICdrpAPI.enicrepository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.eNIC.drp.api.eNICdrpAPI.enicentity.GeneralDetail;

public interface GeneralDetailRepository extends JpaRepository<GeneralDetail, Integer> {

	//checking same bday
	@Query("SELECT gdb FROM GeneralDetail gdb where gdb.dob = :dob") 
	public List<GeneralDetail> findByDob(Date dob);
	
	//getting general detail and application of all
	@Query("SELECT gd, app FROM GeneralDetail gd \r\n"
			+ "	INNER JOIN Application app   \r\n"
			+ "	ON\r\n"
			+ "	gd.idApplication = app.idApplication")
	public List<GeneralDetail> findAllNicDetails();
	
	//getting general detail and application of all by NIC
	@Query("SELECT gd, app FROM GeneralDetail gd \r\n"
			+ "	INNER JOIN Application app   \r\n"
			+ "	ON\r\n"
			+ "	gd.idApplication = app.idApplication \r\n"
			+ " where gd.nicNo = :nicNo")
	public List<GeneralDetail> findByNicNo(String nicNo);
	

	//getting general detail and application of all by NIC
		@Query("SELECT gd, app FROM GeneralDetail gd \r\n"
				+ "	INNER JOIN Application app   \r\n"
				+ "	ON\r\n"
				+ "	gd.idApplication = app.idApplication \r\n"
				+ " WHERE nicStatus = true and gd.nicNo = :nicNo")
		public GeneralDetail findByOneNicNo(String nicNo);
		

	
	
	
	
}
