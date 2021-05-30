package com.eNIC.drp.api.eNICdrpAPI.enicrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.eNIC.drp.api.eNICdrpAPI.enicentity.Application;
import com.eNIC.drp.api.eNICdrpAPI.enicentity.PoliceReport;

public interface PoliceReportRepository extends JpaRepository<PoliceReport, Integer> {

	@Query("SELECT polrep FROM PoliceReport polrep where polrep.idApplication = :idApplication") 
	public PoliceReport findByAppId(Application idApplication);
}
