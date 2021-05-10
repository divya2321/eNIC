package com.eNIC.services.eNICservices.entity;

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
@Table(name="organizationcontact")
public class OrganizationContactDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idorgcontact", nullable = false)
	private int idOrgContact;
	
	@Column(name="orgAddrno", nullable = false, length = 50)
	private String orgAddressNo;
	
	@Column(name="orgAddrstreet1", nullable = false, length = 75)
	private String orgAddressStreet1;
	
	@Column(name="orgAddrstreet2", nullable = true, length = 75)
	private String orgAddressStreet2;
	
	@Column(name="orgAddrcity", nullable = false, length = 50)
	private String orgAddressCity;
	
	@Column(name="orgcontact1", nullable = true, length = 10)
	private String orgContact1;
	
	@Column(name="orgcontact2", nullable = true, length = 10)
	private String orgContact2;
	
	@Column(name="orgemailaddress", nullable = true, length = 225)
	private String orgEmailAddress;
	
	@OneToOne(cascade = CascadeType.ALL)	
	@JoinColumn(name="idorg",  nullable = false)
	private OrganizationDetail idOrg;

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

	public OrganizationDetail getIdOrg() {
		return idOrg;
	}

	public void setIdOrg(OrganizationDetail idOrg) {
		this.idOrg = idOrg;
	}
	
	
	
}
