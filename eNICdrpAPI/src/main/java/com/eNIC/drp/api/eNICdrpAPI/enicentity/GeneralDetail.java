package com.eNIC.drp.api.eNICdrpAPI.enicentity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
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
	
	@Column(name="registereddate", nullable = false)
	private Date registeredDate;
	
	@Lob
	@Column(name="fingerprint", nullable = false)
	private String fingerprint;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idapplication", nullable = false)
	private Application idApplication;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idicaophoto", nullable = false)
	private IcaoPhoto idIcaoPhoto;
	
	@Column(name="nicstatus")
	private boolean nicStatus;

	public int getIdGeneralDetail() {
		return idGeneralDetail;
	}

	public void setIdGeneralDetail(int idGeneralDetail) {
		this.idGeneralDetail = idGeneralDetail;
	}

	public String getNicNo() {
		return nicNo;
	}

	public void setNicNo(String nicNo) {
		this.nicNo = nicNo;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCivilStatus() {
		return civilStatus;
	}

	public void setCivilStatus(String civilStatus) {
		this.civilStatus = civilStatus;
	}

	public Date getRegisteredDate() {
		return registeredDate;
	}

	public void setRegisteredDate(Date registeredDate) {
		this.registeredDate = registeredDate;
	}

	public String getFingerprint() {
		return fingerprint;
	}

	public void setFingerprint(String fingerprint) {
		this.fingerprint = fingerprint;
	}

	public Application getIdApplication() {
		return idApplication;
	}

	public void setIdApplication(Application idApplication) {
		this.idApplication = idApplication;
	}

	public IcaoPhoto getIdIcaoPhoto() {
		return idIcaoPhoto;
	}

	public void setIdIcaoPhoto(IcaoPhoto idIcaoPhoto) {
		this.idIcaoPhoto = idIcaoPhoto;
	}
	
	public boolean getNicStatus() {
		return nicStatus;
	}

	public void setNicStatus(boolean nicStatus) {
		this.nicStatus = nicStatus;
	}
	
	
	
	
}
