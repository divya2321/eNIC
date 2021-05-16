package com.eNIC.drp.api.eNICdrpAPI.eniccontroller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import com.eNIC.drp.api.eNICdrpAPI.config.JwtTokenUtil;
import com.eNIC.drp.api.eNICdrpAPI.enicentity.JwtResponse;
import com.eNIC.drp.api.eNICdrpAPI.enicentity.UserAccount;
import com.eNIC.drp.api.eNICdrpAPI.enicservices.JwtUserDetailsService;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;



	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody UserAccount userAccount) throws Exception {
		userDetailsService.save(userAccount);
		authenticate(userAccount.getUsername(), userAccount.getPassword());
		
		final UserDetails userDetails = userDetailsService.loadUserByUsername(userAccount.getUsername());
		final String token = jwtTokenUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(new JwtResponse(token));
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}
