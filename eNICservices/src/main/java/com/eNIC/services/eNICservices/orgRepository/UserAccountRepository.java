package com.eNIC.services.eNICservices.orgRepository;

import org.springframework.data.repository.CrudRepository;

import com.eNIC.services.eNICservices.entity.Useraccount;
public interface UserAccountRepository extends CrudRepository<Useraccount, Integer> {
	Useraccount findByAccountUsername(String accountUsername);
}