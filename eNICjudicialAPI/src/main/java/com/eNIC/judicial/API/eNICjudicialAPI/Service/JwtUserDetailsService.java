package com.eNIC.judicial.API.eNICjudicialAPI.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.eNIC.judicial.API.eNICjudicialAPI.Repository.UserAccountRepository;
import com.eNIC.judicial.API.eNICjudicialAPI.entity.Useraccount;
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
