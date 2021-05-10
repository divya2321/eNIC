package com.eNIC.health.API.eNIChealthAPI.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="healthrecord")
public class AccessHealthRecord {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idhealthrecord", nullable = false)
	private int idHealthRecord;
	
	@Lob
	@Column(name="healthrecord", nullable = false)
	private String healthRecord;
	
	@Lob
	@Column(name="healthreport", nullable = false)
	private String healthReport;
	
	@Lob
	@Column(name="healthdiscription", nullable = false)
	private String healthDiscription;
	
	@Column(name="recorddate", nullable = false)
	private Date recordDate;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idgeneraldetail", nullable = true)
	private GeneralDetail idGeneralDetail;	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="iduseraccount", nullable = true)
	private Useraccount idUseraccount;
	
	@Column(name="doctor", nullable = false, length = 150)
	private String doctor;

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

	public String getHealthDiscription() {
		return healthDiscription;
	}

	public void setHealthDiscription(String healthDiscription) {
		this.healthDiscription = healthDiscription;
	}

	public Date getRecordDate() {
		return recordDate;
	}

	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
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

	public String getDoctor() {
		return doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}
	
	
	
}
