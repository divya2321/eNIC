package com.eNIC.financialinstitution.API.eNICfinancialinstitutionAPI.entity;

import java.io.Serializable;

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
@Table(name="contactdetail")
public class ContactDetail implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idcontactdetail", nullable = false)
	private int idContactDetail;
	
	@Column(name="residentno", nullable = true, length = 10)
	private String residentNo;
	
	@Column(name="mobileno", nullable = true, length = 10)
	private String mobileNo;
	
	@Column(name="emailaddress", nullable = true, length = 225)
	private String emailAddress;
	
	@OneToOne(cascade = CascadeType.ALL)	
	@JoinColumn(name="idgeneraldetail",  nullable = false)
	private GeneralDetail idGeneralDetail;

	public int getIdContactDetail() {
		return idContactDetail;
	}

	public void setIdContactDetail(int idContactDetail) {
		this.idContactDetail = idContactDetail;
	}

	public String getResidentNo() {
		return residentNo;
	}

	public void setResidentNo(String residentNo) {
		this.residentNo = residentNo;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public GeneralDetail getIdGeneralDetail() {
		return idGeneralDetail;
	}

	public void setIdGeneralDetail(GeneralDetail idGeneralDetail) {
		this.idGeneralDetail = idGeneralDetail;
	}
	
	
}
