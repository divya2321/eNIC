package com.eNIC.health.API.eNIChealthAPI.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="orguser")
public class OrganizationUser {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="idorguser", nullable = false)
	private int idGeneralDetail;
	
	@Column(name="orgusernic", nullable = false, length = 12)
	private String nicNo;
	
	@Column(name="orguserfname", nullable = false, length = 150)
	private String familyName;
	
	@Column(name="orguserlname", nullable = false, length = 150)
	private String name;
	
	@Column(name="orgusergender", nullable = false, length = 6)
	private String surName;
	
	@Column(name="orguserbranch", nullable = false, length = 50)
	private String gender;
	
	@Column(name="orguserdesignation", nullable = false, length = 50)
	private String civilStatus;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idorg", nullable = false)
	private OrganizationDetail idOrgDetail;

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

	public OrganizationDetail getIdOrgDetail() {
		return idOrgDetail;
	}

	public void setIdOrgDetail(OrganizationDetail idOrgDetail) {
		this.idOrgDetail = idOrgDetail;
	}
	
}
