package com.eNIC.police.API.eNICpoliceAPI.Repository;

import org.springframework.data.repository.CrudRepository;

import com.eNIC.police.API.eNICpoliceAPI.entity.Useraccount;


public interface UserAccountRepository extends CrudRepository<Useraccount, Integer> {
	Useraccount findByAccountUsername(String accountUsername);
}