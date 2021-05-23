package com.eNIC.judicial.API.eNICjudicialAPI.Repository;

import org.springframework.data.repository.CrudRepository;

import com.eNIC.judicial.API.eNICjudicialAPI.entity.Useraccount;
public interface UserAccountRepository extends CrudRepository<Useraccount, Integer> {
	Useraccount findByAccountUsername(String accountUsername);
}