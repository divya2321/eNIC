package com.eNIC.health.API.eNIChealthAPI.entity;

import java.io.Serializable;
import java.sql.Date;

public class CommonHealthRecord implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int idHealthRecord;
	private String healthRecord;
	private String healthReport;
	private String discription;
	private Date recordDate;
	private String nicNo;
	private Useraccount idUseraccount;
	private String username;
	private String orgName;
	private GeneralDetail idGeneralDetail;
	private BloodType idBloodType;
	
 
	public BloodType getIdBloodType() {
		return idBloodType;
	}
	public void setIdBloodType(BloodType idBloodType) {
		this.idBloodType = idBloodType;
	}
	public int getIdHealthRecord() {
		return idHealthRecord;
	}
	public void setIdHealthRecord(int idHealthRecord) {
		this.idHealthRecord = idHealthRecord;
	}
	public String getHealthRecord() {
		return healthRecord;
	}
	public void setHealthRecord(String healthRecord) {
		this.healthRecord = healthRecord;
	}
	public String getHealthReport() {
		return healthReport;
	}
	public void setHealthReport(String healthReport) {
		this.healthReport = healthReport;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public Date getRecordDate() {
		return recordDate;
	}
	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}
	public String getNicNo() {
		return nicNo;
	}
	public void setNicNo(String nicNo) {
		this.nicNo = nicNo;
	}
	public Useraccount getIdUseraccount() {
		return idUseraccount;
	}
	public void setIdUseraccount(Useraccount idUseraccount) {
		this.idUseraccount = idUseraccount;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public GeneralDetail getIdGeneralDetail() {
		return idGeneralDetail;
	}
	public void setIdGeneralDetail(GeneralDetail idGeneralDetail) {
		this.idGeneralDetail = idGeneralDetail;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
