package com.eNIC.drp.api.eNICdrpAPI.enicrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.eNIC.drp.api.eNICdrpAPI.enicentity.AddressDetail;
import com.eNIC.drp.api.eNICdrpAPI.enicentity.GeneralDetail;



public interface AddressDetailRepository extends JpaRepository<AddressDetail, Integer> {
	
	//getting address detail and application by NIC
		@Query("SELECT addr FROM AddressDetail addr where addr.idGeneralDetail = :idGeneralDetail") 
		public java.util.List<AddressDetail> findByNicNo(GeneralDetail idGeneralDetail);
		
		@Query("SELECT addr FROM AddressDetail addr where addr.idGeneralDetail = :idGeneralDetail") 
		public java.util.List<AddressDetail> findByGdId(GeneralDetail idGeneralDetail);

}
