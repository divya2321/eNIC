package com.eNIC.services.eNICservices.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="orgctpeople")
public class OrganizationContactPeople {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idorgctpeople", nullable = false)
	private int idOrgCtPeople;
	
	@Column(name="orgctfname", nullable = false, length = 150)
	private String orgCtFname;
	
	@Column(name="orgctlname", nullable = false, length = 150)
	private String orgCtLname;
	
	@Column(name="orgcttype", nullable = false, length = 20)
	private String orgCtType;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idorg", nullable = false)
	private OrganizationDetail idOrgDetail;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idorgcontact", nullable = false)
	private OrganizationContactDetail idOrgContact;

	public int getIdOrgCtPeople() {
		return idOrgCtPeople;
	}

	public void setIdOrgCtPeople(int idOrgCtPeople) {
		this.idOrgCtPeople = idOrgCtPeople;
	}

	public String getOrgCtFname() {
		return orgCtFname;
	}

	public void setOrgCtFname(String orgCtFname) {
		this.orgCtFname = orgCtFname;
	}

	public String getOrgCtLname() {
		return orgCtLname;
	}

	public void setOrgCtLname(String orgCtLname) {
		this.orgCtLname = orgCtLname;
	}

	public String getOrgCtType() {
		return orgCtType;
	}

	public void setOrgCtType(String orgCtType) {
		this.orgCtType = orgCtType;
	}

	public OrganizationDetail getIdOrgDetail() {
		return idOrgDetail;
	}

	public void setIdOrgDetail(OrganizationDetail idOrgDetail) {
		this.idOrgDetail = idOrgDetail;
	}

	public OrganizationContactDetail getIdOrgContact() {
		return idOrgContact;
	}

	public void setIdOrgContact(OrganizationContactDetail idOrgContact) {
		this.idOrgContact = idOrgContact;
	}
	
	
	
}
