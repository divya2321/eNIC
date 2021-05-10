package com.eNIC.drp.api.eNICdrpAPI.enicentity;

import java.sql.Date;


public class DRPCommonEntity {

	//application
	private int idApplication;
	private String applicationNo;
	private String applicationType;
	private String scannedApplication;
	private String scannedGramaNiladhariCertificate;
	private Date recievedDate;
	
	//oldnic
	private int idOldNic;
	private String scannedOldNic;
	private String oldNicNo;
	
	//policereport
	private int idPoliceReport;
	private String scannedPoliceReport;
	
	//generaldetail
	private int idGeneralDetail;
	private String nicNo;
	private String familyName;
	private String name;
	private String surName;
	private Date dob;
	private String gender;
	private String civilStatus;
	private Date registeredDate;
	private String fingerprint;
	private boolean nicStatus;
	
	//generaldetailold
	private int idGeneralDetailOld;
	private Date expiredDate;
	private String   comment;
	
	//icaophoto
	private int idIcaoPhoto;
	private String icaoPhoto;
	
	//contactdetail
	private int idContactDetail;
	private String residentNo;
	private String mobileNo;
	private String emailAddress;
	
	//permanentaddressdetail
	private int idAddressPermanentDetail;
	private String addressPermanentNo;
	private String addressPermanentStreet1;
	private String addressPermanentStreet2;
	private String addressPermanentCity;
	private String addressPermanentType;
	
	//residentaddressdetail
	private int idAddressResidentDetail;
	private String addressResidentNo;
	private String addressResidentStreet1;
	private String addressResidentStreet2;
	private String addressResidentCity;
	private String addressResidentType;
	
	//familydetail
	private int idFamilyDetail;
	private String motherName;
	private String motherNic;
	private String fatherName;
	private String fatherNic;
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
	public int getIdOldNic() {
		return idOldNic;
	}
	public void setIdOldNic(int idOldNic) {
		this.idOldNic = idOldNic;
	}
	public String getOldNicNo() {
		return oldNicNo;
	}
	public void setOldNicNo(String oldNicNo) {
		this.oldNicNo = oldNicNo;
	}
	public String getScannedOldNic() {
		return scannedOldNic;
	}
	public void setScannedOldNic(String scannedOldNic) {
		this.scannedOldNic = scannedOldNic;
	}
	public int getIdPoliceReport() {
		return idPoliceReport;
	}
	public void setIdPoliceReport(int idPoliceReport) {
		this.idPoliceReport = idPoliceReport;
	}
	public String getScannedPoliceReport() {
		return scannedPoliceReport;
	}
	public void setScannedPoliceReport(String scannedPoliceReport) {
		this.scannedPoliceReport = scannedPoliceReport;
	}
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
	public boolean isNicStatus() {
		return nicStatus;
	}
	public void setNicStatus(boolean nicStatus) {
		this.nicStatus = nicStatus;
	}
	public int getIdGeneralDetailOld() {
		return idGeneralDetailOld;
	}
	public void setIdGeneralDetailOld(int idGeneralDetailOld) {
		this.idGeneralDetailOld = idGeneralDetailOld;
	}
	public Date getExpiredDate() {
		return expiredDate;
	}
	public void setExpiredDate(Date expiredDate) {
		this.expiredDate = expiredDate;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getIdIcaoPhoto() {
		return idIcaoPhoto;
	}
	public void setIdIcaoPhoto(int idIcaoPhoto) {
		this.idIcaoPhoto = idIcaoPhoto;
	}
	public String getIcaoPhoto() {
		return icaoPhoto;
	}
	public void setIcaoPhoto(String icaoPhoto) {
		this.icaoPhoto = icaoPhoto;
	}
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
	public int getIdAddressPermanentDetail() {
		return idAddressPermanentDetail;
	}
	public void setIdAddressPermanentDetail(int idAddressPermanentDetail) {
		this.idAddressPermanentDetail = idAddressPermanentDetail;
	}
	public String getAddressPermanentNo() {
		return addressPermanentNo;
	}
	public void setAddressPermanentNo(String addressPermanentNo) {
		this.addressPermanentNo = addressPermanentNo;
	}
	public String getAddressPermanentStreet1() {
		return addressPermanentStreet1;
	}
	public void setAddressPermanentStreet1(String addressPermanentStreet1) {
		this.addressPermanentStreet1 = addressPermanentStreet1;
	}
	public String getAddressPermanentStreet2() {
		return addressPermanentStreet2;
	}
	public void setAddressPermanentStreet2(String addressPermanentStreet2) {
		this.addressPermanentStreet2 = addressPermanentStreet2;
	}
	public String getAddressPermanentCity() {
		return addressPermanentCity;
	}
	public void setAddressPermanentCity(String addressPermanentCity) {
		this.addressPermanentCity = addressPermanentCity;
	}
	public String getAddressPermanentType() {
		return addressPermanentType;
	}
	public void setAddressPermanentType(String addressPermanentType) {
		this.addressPermanentType = addressPermanentType;
	}
	public int getIdAddressResidentDetail() {
		return idAddressResidentDetail;
	}
	public void setIdAddressResidentDetail(int idAddressResidentDetail) {
		this.idAddressResidentDetail = idAddressResidentDetail;
	}
	public String getAddressResidentNo() {
		return addressResidentNo;
	}
	public void setAddressResidentNo(String addressResidentNo) {
		this.addressResidentNo = addressResidentNo;
	}
	public String getAddressResidentStreet1() {
		return addressResidentStreet1;
	}
	public void setAddressResidentStreet1(String addressResidentStreet1) {
		this.addressResidentStreet1 = addressResidentStreet1;
	}
	public String getAddressResidentStreet2() {
		return addressResidentStreet2;
	}
	public void setAddressResidentStreet2(String addressResidentStreet2) {
		this.addressResidentStreet2 = addressResidentStreet2;
	}
	public String getAddressResidentCity() {
		return addressResidentCity;
	}
	public void setAddressResidentCity(String addressResidentCity) {
		this.addressResidentCity = addressResidentCity;
	}
	public String getAddressResidentType() {
		return addressResidentType;
	}
	public void setAddressResidentType(String addressResidentType) {
		this.addressResidentType = addressResidentType;
	}
	public int getIdFamilyDetail() {
		return idFamilyDetail;
	}
	public void setIdFamilyDetail(int idFamilyDetail) {
		this.idFamilyDetail = idFamilyDetail;
	}
	public String getMotherName() {
		return motherName;
	}
	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}
	public String getMotherNic() {
		return motherNic;
	}
	public void setMotherNic(String motherNic) {
		this.motherNic = motherNic;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getFatherNic() {
		return fatherNic;
	}
	public void setFatherNic(String fatherNic) {
		this.fatherNic = fatherNic;
	}
	
	
	
	
}
