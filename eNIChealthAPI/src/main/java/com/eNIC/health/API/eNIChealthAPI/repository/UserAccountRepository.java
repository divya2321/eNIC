package com.eNIC.health.API.eNIChealthAPI.repository;

import org.springframework.data.repository.CrudRepository;

import com.eNIC.health.API.eNIChealthAPI.entity.Useraccount;


public interface UserAccountRepository extends CrudRepository<Useraccount, Integer> {
	Useraccount findByAccountUsername(String accountUsername);
}