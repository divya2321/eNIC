package com.eNIC.health.API.eNIChealthAPI.entity;

import java.io.Serializable;
import java.sql.Date;

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
@Table(name="healthrecord")
public class HealthRecord implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idhealthrecord", nullable = false)
	private int idHealthRecord;

	@Column(name="healthrecord", nullable = false, length = 500)
	private String healthRecord;

	@Column(name="healthreport", nullable = false, length = 500)
	private String healthReport;

	@Column(name="discription", nullable = false, length = 500)
	private String discription;
	
	@Column(name="recorddate", nullable = false)
	private Date recordDate;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idgeneraldetail", nullable = false)
	private GeneralDetail idGeneralDetail;	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="iduseraccount", nullable = false)
	private Useraccount idUseraccount;

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}
