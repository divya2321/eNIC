package com.eNIC.drp.api.eNICdrpAPI.enicservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.eNIC.drp.api.eNICdrpAPI.enicentity.UserAccount;
import com.eNIC.drp.api.eNICdrpAPI.enicrepository.UserAccountRepository;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	@Autowired
	private UserAccountRepository uaccRepository;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserAccount userAccount = uaccRepository.findByUsername(username);
		if (userAccount == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(userAccount.getUsername(), userAccount.getPassword(),
				new ArrayList<>());
	}

	public UserAccount save(UserAccount userAccount) {
		UserAccount newUser = new UserAccount();
		newUser.setUsername(userAccount.getUsername());
		newUser.setPassword(bcryptEncoder.encode(userAccount.getPassword()));
		return uaccRepository.save(newUser);
	}
}
