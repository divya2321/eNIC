package com.eNIC.drp.api.eNICdrpAPI.eniccontroller;


import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

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

import io.jsonwebtoken.impl.DefaultClaims;

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
	public String saveUser(@RequestBody UserAccount userAccount) throws Exception {
		userDetailsService.save(userAccount);
		authenticate(userAccount.getUsername(), userAccount.getPassword());
		
		final UserDetails userDetails = userDetailsService.loadUserByUsername(userAccount.getUsername());
		final String token = jwtTokenUtil.generateToken(userDetails);
		
		return token;
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
	
	
	@RequestMapping(value = "/refreshtoken", method = RequestMethod.GET)
	public ResponseEntity<?> refreshtoken(HttpServletRequest request) throws Exception {
		// From the HttpRequest get the claims
		DefaultClaims claims = (io.jsonwebtoken.impl.DefaultClaims) request.getAttribute("claims");

		Map<String, Object> expectedMap = getMapFromIoJsonwebtokenClaims(claims);
		String token = jwtTokenUtil.doGenerateRefreshToken(expectedMap, expectedMap.get("sub").toString());
		return ResponseEntity.ok(token);
	}

	public Map<String, Object> getMapFromIoJsonwebtokenClaims(DefaultClaims claims) {
		Map<String, Object> expectedMap = new HashMap<String, Object>();
		for (Entry<String, Object> entry : claims.entrySet()) {
			expectedMap.put(entry.getKey(), entry.getValue());
		}
		return expectedMap;
	}
}
