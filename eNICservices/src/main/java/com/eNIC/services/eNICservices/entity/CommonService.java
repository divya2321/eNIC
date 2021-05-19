package com.eNIC.services.eNICservices.entity;

import java.sql.Date;


public class CommonService {
	
	//OrganizationDetail
	private int idOrganization;
	private String organizationType;
	private String organizationName;
	private String organizationCode;
	private String organizationHead;
	private Date organizationRequestedDate;
	private String organizationStatus;
	
	//OrganizationContactDetail
	private int idOrgContact;
	private String orgAddressNo;
	private String orgAddressStreet1;
	private String orgAddressStreet2;
	private String orgAddressCity;
	private String orgContact1;
	private String orgContact2;
	private String orgEmailAddress;
	
	
	
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
	public String getOrganizationHead() {
		return organizationHead;
	}
	public void setOrganizationHead(String organizationHead) {
		this.organizationHead = organizationHead;
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
	public int getIdOrgContact() {
		return idOrgContact;
	}
	public void setIdOrgContact(int idOrgContact) {
		this.idOrgContact = idOrgContact;
	}
	public String getOrgAddressNo() {
		return orgAddressNo;
	}
	public void setOrgAddressNo(String orgAddressNo) {
		this.orgAddressNo = orgAddressNo;
	}
	public String getOrgAddressStreet1() {
		return orgAddressStreet1;
	}
	public void setOrgAddressStreet1(String orgAddressStreet1) {
		this.orgAddressStreet1 = orgAddressStreet1;
	}
	public String getOrgAddressStreet2() {
		return orgAddressStreet2;
	}
	public void setOrgAddressStreet2(String orgAddressStreet2) {
		this.orgAddressStreet2 = orgAddressStreet2;
	}
	public String getOrgAddressCity() {
		return orgAddressCity;
	}
	public void setOrgAddressCity(String orgAddressCity) {
		this.orgAddressCity = orgAddressCity;
	}
	public String getOrgContact1() {
		return orgContact1;
	}
	public void setOrgContact1(String orgContact1) {
		this.orgContact1 = orgContact1;
	}
	public String getOrgContact2() {
		return orgContact2;
	}
	public void setOrgContact2(String orgContact2) {
		this.orgContact2 = orgContact2;
	}
	public String getOrgEmailAddress() {
		return orgEmailAddress;
	}
	public void setOrgEmailAddress(String orgEmailAddress) {
		this.orgEmailAddress = orgEmailAddress;
	}	
	

}
