package com.eNIC.drp.api.eNICdrpAPI.enicentity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;



@Entity
@Table(name="application")
public class Application {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idapplication", nullable = false)
	private int idApplication;
	
	@Column(name="applicationno", nullable = false, length = 15)
	private String applicationNo;
	
	@Column(name="applicationtype", nullable = false, length = 5)
	private String applicationType;
	
	@Lob
	@Column(name="scannedapplication", nullable = false)
	private String scannedApplication;
	
	@Lob
	@Column(name="scannedgramaniladharicertificate", nullable = false)
	private String scannedGramaNiladhariCertificate;
	
	@Column(name="recieveddate", nullable = false)
	private Date recievedDate;
	
	
	public int getIdApplication() {
		return idApplication;
	}

	public void setIdApplication(int idApplication) {
		this.idApplication = idApplication;
	}

	public String getApplicationNo() {
		return applicationNo;
	}

	public void setApplicationNo(String applicationNo) {
		this.applicationNo = applicationNo;
	}

	public String getApplicationType() {
		return applicationType;
	}

	public void setApplicationType(String applicationType) {
		this.applicationType = applicationType;
	}

	public String getScannedApplication() {
		return scannedApplication;
	}

	public void setScannedApplication(String scannedApplication) {
		this.scannedApplication = scannedApplication;
	}

	public String getScannedGramaNiladhariCertificate() {
		return scannedGramaNiladhariCertificate;
	}

	public void setScannedGramaNiladhariCertificate(String scannedGramaNiladhariCertificate) {
		this.scannedGramaNiladhariCertificate = scannedGramaNiladhariCertificate;
	}

	public Date getRecievedDate() {
		return recievedDate;
	}

	public void setRecievedDate(Date recievedDate) {
		this.recievedDate = recievedDate;
	}

	

}
