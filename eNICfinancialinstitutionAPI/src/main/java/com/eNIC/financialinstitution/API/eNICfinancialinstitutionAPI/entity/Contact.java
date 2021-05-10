package com.eNIC.financialinstitution.API.eNICfinancialinstitutionAPI.entity;

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
@Table(name="contact")
public class Contact {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idcontact", nullable = false)
	private int idContact;
	
	@Column(name="residentno", nullable = true, length = 10)
	private String residentNo;
	
	@Column(name="mobileno", nullable = true, length = 10)
	private String mobileNo;
	
	@Column(name="emailaddress", nullable = true, length = 225)
	private String emailAddress;
	
	@OneToOne(cascade = CascadeType.ALL)	
	@JoinColumn(name="idgeneraldetail",  nullable = false)
	private GeneralDetail idGeneralDetail;

	public int getIdContact() {
		return idContact;
	}

	public String getResidentNo() {
		return residentNo;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public GeneralDetail getIdGeneralDetail() {
		return idGeneralDetail;
	}
	
}
