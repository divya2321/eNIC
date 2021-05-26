package com.eNIC.police.API.eNICpoliceAPI.entity;

import java.io.Serializable;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonPropertyOrder({"idCriminalRecord", "criminalRecord", "criminalReport", "criminalDiscription", "recordDate", 
	"idGeneralDetail", "nicNo", "idUseraccount", "username","orgName"})
@JsonInclude(Include.NON_NULL)
public class CommonCriminalRecord implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	private int idCriminalRecord;
	private String criminalRecord;
	private String criminalReport;
	private String criminalDiscription;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date recordDate;
	
	private GeneralDetail idGeneralDetail;
	private String nicNo;
	private Useraccount idUseraccount;
	private String username;
	private String orgName;

	public CommonCriminalRecord() {

	}

	public CommonCriminalRecord(int idCriminalRecord, String criminalRecord, String criminalReport,
			String criminalDiscription, Date recordDate, GeneralDetail idGeneralDetail, String nicNo,
			Useraccount idUseraccount, String username) {

		this.idCriminalRecord = idCriminalRecord;
		this.criminalRecord = criminalRecord;
		this.criminalReport = criminalReport;
		this.criminalDiscription = criminalDiscription;
		this.recordDate = recordDate;
		this.idGeneralDetail = idGeneralDetail;
		this.nicNo = nicNo;
		this.idUseraccount = idUseraccount;
		this.username = username;
	}

	public String getNicNo() {
		return nicNo;
	}

	public void setNicNo(String nicNo) {
		this.nicNo = nicNo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getIdCriminalRecord() {
		return idCriminalRecord;
	}

	public void setIdCriminalRecord(int idCriminalRecord) {
		this.idCriminalRecord = idCriminalRecord;
	}

	public String getCriminalRecord() {
		return criminalRecord;
	}

	public void setCriminalRecord(String criminalRecord) {
		this.criminalRecord = criminalRecord;
	}

	public String getCriminalReport() {
		return criminalReport;
	}

	public void setCriminalReport(String criminalReport) {
		this.criminalReport = criminalReport;
	}

	public String getCriminalDiscription() {
		return criminalDiscription;
	}

	public GeneralDetail getIdGeneralDetail() {
		return idGeneralDetail;
	}

	public void setIdGeneralDetail(GeneralDetail idGeneralDetail) {
		this.idGeneralDetail = idGeneralDetail;
	}

	public Useraccount getIdUseraccount() {
		return idUseraccount;
	}

	public void setIdUseraccount(Useraccount idUseraccount) {
		this.idUseraccount = idUseraccount;
	}

	public void setCriminalDiscription(String criminalDiscription) {
		this.criminalDiscription = criminalDiscription;
	}

	public Date getRecordDate() {
		return recordDate;
	}

	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	@Override
	public String toString() {
		return "CommonCriminalRecord [idCriminalRecord=" + idCriminalRecord + ", criminalRecord=" + criminalRecord
				+ ", criminalReport=" + criminalReport + ", criminalDiscription=" + criminalDiscription
				+ ", recordDate=" + recordDate + ", idGeneralDetail=" + idGeneralDetail + ", nicNo=" + nicNo
				+ ", idUseraccount=" + idUseraccount + ", username=" + username + "]";
	}

}