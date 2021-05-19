package com.eNIC.services.eNICservices.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.eNIC.services.eNICservices.entity.Useraccount;
import com.eNIC.services.eNICservices.orgRepository.UserAccRepository;
import com.eNIC.services.eNICservices.orgRepository.UserAccountRepository;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	@Autowired
	private UserAccountRepository uaccRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Useraccount userAccount = uaccRepository.findByAccountUsername(username);
		if (userAccount == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(userAccount.getAccountUsername(), userAccount.getAccountPassword(),
				new ArrayList<>());
	}

	
}
