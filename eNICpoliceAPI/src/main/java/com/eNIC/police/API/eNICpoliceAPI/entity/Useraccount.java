package com.eNIC.police.API.eNICpoliceAPI.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="useraccount")
public class Useraccount {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="iduseraccount", nullable = false)
	private int idUseraccount;
	
	@Column(name="accountusername", nullable = false, length = 225)
	private String accountUsername;
	
	@Column(name="accountpassword", nullable = false, length = 100)
	private String accountPassword;
	
	@Column(name="createddate", nullable = false)
	private LocalDateTime createdDate;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idorguser", nullable = true)
	private OrganizationUser idOrgUser;
	
	@Column(name="accountstatus", nullable = false)
	private boolean accountStatus;

	public int getIdUseraccount() {
		return idUseraccount;
	}

	public void setIdUseraccount(int idUseraccount) {
		this.idUseraccount = idUseraccount;
	}

	public String getAccountUsername() {
		return accountUsername;
	}

	public void setAccountUsername(String accountUsername) {
		this.accountUsername = accountUsername;
	}

	public String getAccountPassword() {
		return accountPassword;
	}

	public void setAccountPassword(String accountPassword) {
		this.accountPassword = accountPassword;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public OrganizationUser getIdOrgUser() {
		return idOrgUser;
	}

	public void setIdOrgUser(OrganizationUser idOrgUser) {
		this.idOrgUser = idOrgUser;
	}

	public boolean isAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(boolean accountStatus) {
		this.accountStatus = accountStatus;
	}
	
	

}
