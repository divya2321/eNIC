package com.eNIC.health.API.eNIChealthAPI.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bloodtypedetail")
public class BloodType {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="idbloodtype", nullable = false)
	private int idBloodType;
	
	@Column(name="bloodtype", nullable = false, length = 2)
	private String bloodType;

	public int getIdBloodType() {
		return idBloodType;
	}

	public void setIdBloodType(int idBloodType) {
		this.idBloodType = idBloodType;
	}

	public String getBloodType() {
		return bloodType;
	}

	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}
	
}
