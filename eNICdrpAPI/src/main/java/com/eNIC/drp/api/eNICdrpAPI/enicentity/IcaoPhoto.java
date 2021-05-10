package com.eNIC.drp.api.eNICdrpAPI.enicentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="icaophotodetail")
public class IcaoPhoto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="idicaophoto", nullable = false)
	private int idIcaoPhoto;
	
	@Lob
	@Column(name="icaophoto", nullable = false)
	private String icaoPhoto;

	public int getIdIcaoPhoto() {
		return idIcaoPhoto;
	}

	public void setIdIcaoPhoto(int idIcaoPhoto) {
		this.idIcaoPhoto = idIcaoPhoto;
	}

	public String getIcaoPhoto() {
		return icaoPhoto;
	}

	public void setIcaoPhoto(String icaoPhoto) {
		this.icaoPhoto = icaoPhoto;
	}

}
