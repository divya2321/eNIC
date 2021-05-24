package com.eNIC.financialinstitution.API.eNICfinancialinstitutionAPI.config;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.eNIC.financialinstitution.API.eNICfinancialinstitutionAPI.entity.OrganizationDetail;
import com.eNIC.financialinstitution.API.eNICfinancialinstitutionAPI.entity.Useraccount;
import com.eNIC.financialinstitution.API.eNICfinancialinstitutionAPI.repository.OrgRepository;
import com.eNIC.financialinstitution.API.eNICfinancialinstitutionAPI.repository.UserAccountRepository;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtil implements Serializable {
	
	@Autowired
	UserAccountRepository userAccRepository;
	
	@Autowired
	OrgRepository orgRepository;

	private static final long serialVersionUID = -2550185165626007488L;
	
	public static final long JWT_TOKEN_VALIDITY = 5*60*60*1000;

	@Value("${jwt.secret}")
	private String secret;

	public String getUsernameFromToken(String token) {
		return getClaimFromToken(token, Claims::getSubject);
	}

	public Date getIssuedAtDateFromToken(String token) {
		return getClaimFromToken(token, Claims::getIssuedAt);
	}

	public Date getExpirationDateFromToken(String token) {
		return getClaimFromToken(token, Claims::getExpiration);
	}

	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
	}

	private Claims getAllClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	}

	private Boolean isTokenExpired(String token) {
		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}

	private Boolean ignoreTokenExpiration(String token) {
		// here you specify tokens, for that the expiration is ignored
		return false;
	}

	public String generateToken(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<>();
		return doGenerateToken(claims, userDetails.getUsername());
	}

	private String doGenerateToken(Map<String, Object> claims, String subject) {

		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY*1000)).signWith(SignatureAlgorithm.HS512, secret).compact();
	}

	public Boolean canTokenBeRefreshed(String token) {
		return (!isTokenExpired(token) || ignoreTokenExpiration(token));
	}

	public Boolean validateToken(String token, UserDetails userDetails) {
		final String username = getUsernameFromToken(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}
	
	public String doGenerateRefreshToken(Map<String, Object> claims, String subject) {

		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY*1000))
				.signWith(SignatureAlgorithm.HS512, secret).compact();

	}
	
	public boolean isFinancial(String username) {
		
		Useraccount useraccount = userAccRepository.findByAccountUsername(username);
		OrganizationDetail organizationDetail = orgRepository.getOrganization(useraccount.getIdUseraccount());
		if (organizationDetail.getOrganizationType().equalsIgnoreCase("financial")) {
			return true;
		} else {
			return false;
		}
		
	}
}
