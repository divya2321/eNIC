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
public class AccessCriminalRecord {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idcriminalrecord", nullable = false)
	private int idCriminalRecord;
	
	@Lob
	@Column(name="criminalrecord", nullable = false)
	private String criminalRecord;
	
	@Lob
	@Column(name="criminalreport", nullable = false)
	private String criminalReport;
	
	@Lob
	@Column(name="criminaldiscription", nullable = false)
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

	public String getCriminalRecord() {
		return criminalRecord;
	}

	public String getCriminalReport() {
		return criminalReport;
	}

	public String getCriminalDiscription() {
		return criminalDiscription;
	}

	public Date getRecordDate() {
		return recordDate;
	}

	public GeneralDetail getIdGeneralDetail() {
		return idGeneralDetail;
	}

	public Useraccount getIdUseraccount() {
		return idUseraccount;
	}

	

}
