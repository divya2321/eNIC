package com.eNIC.services.eNICservices.orgRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.eNIC.services.eNICservices.entity.Useraccount;

public interface UserAccRepository extends JpaRepository<Useraccount, Integer> {

	@Query("SELECT uacc FROM Useraccount uacc where uacc.idUseraccount = :idUseraccount") 
	public java.util.List<Useraccount> createUserAcc(Useraccount idUseraccount);
	
	@Query("SELECT uacc FROM Useraccount uacc where uacc.idUseraccount = :idUseraccount") 
	public java.util.List<Useraccount> findByOrgId(Useraccount idUseraccount);

	@Query("SELECT uacc FROM Useraccount uacc where uacc.accountUsername = :accountUsername") 
	public Useraccount findByUsername(String accountUsername);
}