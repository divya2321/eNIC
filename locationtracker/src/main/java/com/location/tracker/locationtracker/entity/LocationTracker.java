package com.location.tracker.locationtracker.entity;

import java.io.Serializable;
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


@Entity
@Table(name="locationtracker")
public class LocationTracker implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idlocationtracker", nullable = false)
	private int idLocationTracker;
	
	@Column(name="longitudes", nullable = false)
	private float longitudes;
	
	@Column(name="latitudes", nullable = false)
	private float latitudes;
	
	@Column(name="locationdate", nullable = false, length = 20)
	private LocalDateTime locationDate;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idgeneraldetail", nullable = false)
	private GeneralDetail idGeneralDetail;	
	
	
	
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

	public LocalDateTime getLocationDate() {
		return locationDate;
	}

	public void setLocationDate(LocalDateTime locationDate) {
		this.locationDate = locationDate;
	}

	public GeneralDetail getIdGeneralDetail() {
		return idGeneralDetail;
	}

	public void setIdGeneralDetail(GeneralDetail idGeneralDetail) {
		this.idGeneralDetail = idGeneralDetail;
	}





	
		
}
