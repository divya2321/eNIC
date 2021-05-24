package com.eNIC.financialinstitution.API.eNICfinancialinstitutionAPI.entity;

import java.sql.Date;

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
	
	@Column(name="orghead", nullable = false, length = 150)
	private String organizationHeadName;
	
	@Column(name="orgrequesteddate", nullable = false)
	private Date organizationRequestedDate;
		
	@Column(name="orgstatus", nullable = false, length = 8)
	private String organizationStatus;
		
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="iduseraccount", nullable = true)
	private Useraccount idUseraccount;



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
	
	public String getOrganizationHeadName() {
		return organizationHeadName;
	}

	public void setOrganizationHeadName(String organizationHeadName) {
		this.organizationHeadName = organizationHeadName;
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

	public Useraccount getIdUseraccount() {
		return idUseraccount;
	}

	public void setIdUseraccount(Useraccount idUseraccount) {
		this.idUseraccount = idUseraccount;
	}
		
}
