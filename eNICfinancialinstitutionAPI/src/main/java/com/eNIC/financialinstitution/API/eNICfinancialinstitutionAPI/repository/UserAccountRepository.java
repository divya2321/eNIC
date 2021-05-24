package com.eNIC.financialinstitution.API.eNICfinancialinstitutionAPI.repository;

import org.springframework.data.repository.CrudRepository;

import com.eNIC.financialinstitution.API.eNICfinancialinstitutionAPI.entity.Useraccount;


public interface UserAccountRepository extends CrudRepository<Useraccount, Integer> {
	Useraccount findByAccountUsername(String accountUsername);
}