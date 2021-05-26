package com.eNIC.drp.eNICdrp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "drpuseraccount")
public class UserAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="iddrpuseraccount", nullable = false)
	private int idUserAccount;
	
	@Column(name="drpusername", nullable = false, length = 50)
	private String username;
	
//	@JsonIgnore
	@Column(name="drppassword", nullable = false, length = 500)
	private String password;

	public int getIdUserAccount() {
		return idUserAccount;
	}

	public void setIdUserAccount(int idUserAccount) {
		this.idUserAccount = idUserAccount;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}
