package com.eNIC.drp.api.eNICdrpAPI.enicentity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="icaophotodetail")
public class IcaoPhoto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idicaophoto", nullable = false)
	private int idIcaoPhoto;
	
	@Column(name="icaophoto", nullable = false,length = 1000)
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
