package com.eNIC.judicial.API.eNICjudicialAPI.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="useraccount")
public class Useraccount implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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


}
