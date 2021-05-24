package com.eNIC.health.API.eNIChealthAPI.entity;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonPropertyOrder({"idGeneralDetail", "nicNo", "familyName", "name", "surName", "dob", "gender","fingerprint", "civilStatus", "nicStatus", 
	"idContactDetail", "residentNo", "mobileNo", "emailAddress", 
	"idAddressPermanentDetail", "addressPermanentNo", "addressPermanentStreet1", "addressPermanentStreet2", "addressPermanentCity", "addressPermanentType", 
	"idAddressResidentDetail", "addressResidentNo", "addressResidentStreet1", "addressResidentStreet2", "addressResidentCity", "addressResidentType"})
@JsonInclude(Include.NON_NULL)
public class CommonGeneralDetail {


	//generaldetail
	@JsonIgnore
		private int idGeneralDetail;
		private String nicNo;
		private String familyName;
		private String name;
		private String surName;
		
		@JsonFormat(pattern="yyyy-MM-dd")
		private Date dob;
		
		private String gender;
		private String civilStatus;
		private String fingerprint;
		
		
		//contactdetail
		@JsonIgnore
		private int idContactDetail;
		private String residentNo;
		private String mobileNo;
		private String emailAddress;
		
		//permanentaddressdetail
		@JsonIgnore
		private int idAddressPermanentDetail;
		private String addressPermanentNo;
		private String addressPermanentStreet1;
		private String addressPermanentStreet2;
		private String addressPermanentCity;
		private String addressPermanentType;
		
		//residentaddressdetail
		@JsonIgnore
		private int idAddressResidentDetail;
		private String addressResidentNo;
		private String addressResidentStreet1;
		private String addressResidentStreet2;
		private String addressResidentCity;
		private String addressResidentType;

		//bloodtype
		@JsonIgnore
		private int idBloodType;
		private String bloodType;
		
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
		public int getIdBloodType() {
			return idBloodType;
		}
		public void setIdBloodType(int idBloodType) {
			this.idBloodType = idBloodType;
		}
		public String getBloodType() {
			return bloodType;
		}
		public void setBloodType(String bloodType) {
			this.bloodType = bloodType;
		}
		
		public String getFingerprint() {
			return fingerprint;
		}
		public void setFingerprint(String fingerprint) {
			this.fingerprint = fingerprint;
		}
		
	
}
