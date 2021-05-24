package com.eNIC.drp.api.eNICdrpAPI.enicentity;


import java.io.Serializable;

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
@Table(name="policereport")
public class PoliceReport implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idpolicereport", nullable = false)
	private int idPoliceReport;
	
	@Column(name="scannedpolicereport", nullable = false, length = 1000)
	private String scannedPoliceReport;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idapplication", nullable = false)
	private Application idApplication;
	
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

	public Application getIdApplication() {
		return idApplication;
	}

	public void setIdApplication(Application idApplication) {
		this.idApplication = idApplication;
	}

	

}
