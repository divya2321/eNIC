package com.location.tracker.locationtracker.entity;

import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

public class CommonLocationTracker {

	private int idLocationTracker;
	
	private float longitudes;
	
	private float latitudes;
	
	private String nicNo;

	public int getIdLocationTracker() {
		return idLocationTracker;
	}

	public void setIdLocationTracker(int idLocationTracker) {
		this.idLocationTracker = idLocationTracker;
	}

	public float getLongitudes() {
		return longitudes;
	}

	public void setLongitudes(float longitudes) {
		this.longitudes = longitudes;
	}

	public float getLatitudes() {
		return latitudes;
	}

	public void setLatitudes(float latitudes) {
		this.latitudes = latitudes;
	}

	public String getNicNo() {
		return nicNo;
	}

	public void setNicNo(String nicNo) {
		this.nicNo = nicNo;
	}



	
		
}
