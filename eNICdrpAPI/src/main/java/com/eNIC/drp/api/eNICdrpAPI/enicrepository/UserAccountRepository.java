package com.eNIC.drp.api.eNICdrpAPI.enicrepository;

import org.springframework.data.repository.CrudRepository;

import com.eNIC.drp.api.eNICdrpAPI.enicentity.UserAccount;
public interface UserAccountRepository extends CrudRepository<UserAccount, Integer> {
	UserAccount findByUsername(String username);
}