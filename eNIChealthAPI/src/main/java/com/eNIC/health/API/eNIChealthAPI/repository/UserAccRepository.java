package com.eNIC.health.API.eNIChealthAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.eNIC.health.API.eNIChealthAPI.entity.Useraccount;

public interface UserAccRepository extends JpaRepository<Useraccount, Integer> {

	@Query("SELECT uacc FROM Useraccount uacc where uacc.accountUsername = :accountUsername") 
	public Useraccount findByUsername(String accountUsername);
	
	
}