package com.eNIC.police.API.eNICpoliceAPI.entity;


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
@Table(name="criminalrecord")
public class CriminalRecord {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idcriminalrecord", nullable = false)
	private int idCriminalRecord;

	@Column(name="criminalrecord", nullable = false, length = 500)
	private String criminalRecord;

	@Column(name="criminalreport", nullable = false, length = 500)
	private String criminalReport;

	@Column(name="criminaldiscription", nullable = true, length = 500)
	private String criminalDiscription;
	
	@Column(name="recorddate", nullable = false)
	private Date recordDate;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idgeneraldetail", nullable = false)
	private GeneralDetail idGeneralDetail;	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="iduseraccount", nullable = false)
	private Useraccount idUseraccount;

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

	public void setCriminalDiscription(String criminalDiscription) {
		this.criminalDiscription = criminalDiscription;
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

	

	

}
