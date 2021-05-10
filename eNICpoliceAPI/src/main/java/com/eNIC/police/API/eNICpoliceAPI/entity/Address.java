package com.eNIC.police.API.eNICpoliceAPI.entity;


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
@Table(name="address")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idaddress", nullable = false)
	private int idAddress;
	
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

	public int getIdAddress() {
		return idAddress;
	}

	public String getAddressNo() {
		return addressNo;
	}

	public String getAddressStreet1() {
		return addressStreet1;
	}

	public String getAddressStreet2() {
		return addressStreet2;
	}

	public String getAddressCity() {
		return addressCity;
	}

	public String getAddressType() {
		return addressType;
	}

	public GeneralDetail getIdGeneralDetail() {
		return idGeneralDetail;
	}	
		
}
