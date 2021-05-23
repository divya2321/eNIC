package com.eNIC.judicial.eNICjudicial.entity;

import java.io.Serializable;
import java.sql.Date;
import org.springframework.http.codec.multipart.Part;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class CommonCriminalRecord implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String criminalRecord;
	private String criminalReport;
	private String criminalDiscription;
	private String nicNo;
	
	
	public CommonCriminalRecord() {
	
	}


	public CommonCriminalRecord(String criminalRecord, String criminalReport, String criminalDiscription,
			String nicNo) {
		this.criminalRecord = criminalRecord;
		this.criminalReport = criminalReport;
		this.criminalDiscription = criminalDiscription;
		this.nicNo = nicNo;
	}


	public String getCriminalRecord() {
		return criminalRecord;
	}


	public void setCriminalRecord(String criminalRecord) {
		this.criminalRecord = criminalRecord;
	}


	public String getCriminalDiscription() {
		return criminalDiscription;
	}


	public void setCriminalDiscription(String criminalDiscription) {
		this.criminalDiscription = criminalDiscription;
	}


	public String getNicNo() {
		return nicNo;
	}


	public void setNicNo(String nicNo) {
		this.nicNo = nicNo;
	}

	public String getCriminalReport() {
		return criminalReport;
	}


	public void setCriminalReport(String criminalReport) {
		this.criminalReport = criminalReport;
	}


	@Override
	public String toString() {
		return "CommonCriminalRecord [criminalRecord=" + criminalRecord + ", criminalReport=" + criminalReport
				+ ", criminalDiscription=" + criminalDiscription + ", nicNo=" + nicNo + "]";
	}
	
	
}
