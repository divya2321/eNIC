package com.eNIC.police.API.eNICpoliceAPI.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="organization")
public class OrganizationDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idorg", nullable = false)
	private int idOrganization;
	
	@Column(name="orgtype", nullable = false, length = 30)
	private String organizationType;
	
	@Column(name="orgname", nullable = false, length = 150)
	private String organizationName;
	
	@Column(name="orgcode", nullable = false, length = 20)
	private String organizationCode;
	
	@Column(name="orgusername", nullable = false, length = 150)
	private String organizationUsername;
	
	@Column(name="orgpassword", nullable = false, length = 100)
	private String organizationPassword;
	
	@Column(name="orgrequesteddate", nullable = false)
	private Date organizationRequestedDate;
		
	@Column(name="orgstatus", nullable = false, length = 8)
	private String organizationStatus;

	public int getIdOrganization() {
		return idOrganization;
	}

	public void setIdOrganization(int idOrganization) {
		this.idOrganization = idOrganization;
	}

	public String getOrganizationType() {
		return organizationType;
	}

	public void setOrganizationType(String organizationType) {
		this.organizationType = organizationType;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getOrganizationCode() {
		return organizationCode;
	}

	public void setOrganizationCode(String organizationCode) {
		this.organizationCode = organizationCode;
	}

	public String getOrganizationUsername() {
		return organizationUsername;
	}

	public void setOrganizationUsername(String organizationUsername) {
		this.organizationUsername = organizationUsername;
	}

	public String getOrganizationPassword() {
		return organizationPassword;
	}

	public void setOrganizationPassword(String organizationPassword) {
		this.organizationPassword = organizationPassword;
	}

	public Date getOrganizationRequestedDate() {
		return organizationRequestedDate;
	}

	public void setOrganizationRequestedDate(Date organizationRequestedDate) {
		this.organizationRequestedDate = organizationRequestedDate;
	}

	public String getOrganizationStatus() {
		return organizationStatus;
	}

	public void setOrganizationStatus(String organizationStatus) {
		this.organizationStatus = organizationStatus;
	}

	
		
}
