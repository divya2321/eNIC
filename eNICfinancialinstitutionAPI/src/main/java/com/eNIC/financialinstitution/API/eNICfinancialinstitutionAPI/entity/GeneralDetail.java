package com.eNIC.financialinstitution.API.eNICfinancialinstitutionAPI.entity;

import java.sql.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="generaldetail")
public class GeneralDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idgeneraldetail", nullable = false)
	private int idGeneralDetail;
	
	@Column(name="nicno", nullable = false, length = 12)
	private String nicNo;
	
	@Column(name="familyname", nullable = false, length = 150)
	private String familyName;
	
	@Column(name="name", nullable = false, length = 150)
	private String name;
	
	@Column(name="surname", nullable = false, length = 150)
	private String surName;
	
	@Column(name="dob", nullable = false)
	private Date dob;
	
	@Column(name="gender", nullable = false, length = 6)
	private String gender;
	
	@Column(name="civilstatus", nullable = false, length = 9)
	private String civilStatus;
	
	@Column(name="fingerprint", nullable = false, length = 1000)
	private String fingerprint;
	


	@Column(name="nicstatus")
	private boolean nicStatus;

	public int getIdGeneralDetail() {
		return idGeneralDetail;
	}

	public String getNicNo() {
		return nicNo;
	}

	public String getFamilyName() {
		return familyName;
	}

	public String getName() {
		return name;
	}

	public String getSurName() {
		return surName;
	}

	public Date getDob() {
		return dob;
	}

	public String getGender() {
		return gender;
	}

	public String getCivilStatus() {
		return civilStatus;
	}

	public void setCivilStatus(String civilStatus) {
		this.civilStatus = civilStatus;
	}

	public void setFingerprint(String fingerprint) {
		this.fingerprint = fingerprint;
	}
	
	public String getFingerprint() {
		return fingerprint;
	}
	
	public boolean getNicStatus() {
		return nicStatus;
	}	
	
	
}
