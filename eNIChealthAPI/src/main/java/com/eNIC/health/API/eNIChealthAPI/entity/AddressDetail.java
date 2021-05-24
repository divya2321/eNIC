package com.eNIC.health.API.eNIChealthAPI.entity;


import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="addressdetail")
public class AddressDetail implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idaddressdetail", nullable = false)
	private int idAddressDetail;
	
	@Column(name="addressno", nullable = false, length = 50)
	private String addressNo;
	
	@Column(name="addressstreet1", nullable = false, length = 75)
	private String addressStreet1;
	
	@Column(name="addressstreet2", nullable = true, length = 75)
	private String addressStreet2;
	
	@Column(name="addresscity", nullable = false, length = 50)
	private String addressCity;

	@Column(name="addresstype", nullable = false, length = 9)
	private String addressType;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idgeneraldetail",  nullable = false)
	private GeneralDetail idGeneralDetail;

	public int getIdAddressDetail() {
		return idAddressDetail;
	}

	public void setIdAddressDetail(int idAddressDetail) {
		this.idAddressDetail = idAddressDetail;
	}

	public String getAddressNo() {
		return addressNo;
	}

	public void setAddressNo(String addressNo) {
		this.addressNo = addressNo;
	}

	public String getAddressStreet1() {
		return addressStreet1;
	}

	public void setAddressStreet1(String addressStreet1) {
		this.addressStreet1 = addressStreet1;
	}

	public String getAddressStreet2() {
		return addressStreet2;
	}

	public void setAddressStreet2(String addressStreet2) {
		this.addressStreet2 = addressStreet2;
	}

	public String getAddressCity() {
		return addressCity;
	}

	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public GeneralDetail getIdGeneralDetail() {
		return idGeneralDetail;
	}

	public void setIdGeneralDetail(GeneralDetail idGeneralDetail) {
		this.idGeneralDetail = idGeneralDetail;
	}
	
		
}
