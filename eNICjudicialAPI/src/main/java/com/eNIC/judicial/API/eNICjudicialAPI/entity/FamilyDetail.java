package com.eNIC.judicial.API.eNICjudicialAPI.entity;

import java.io.Serializable;

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
@Table(name="familydetail")
public class FamilyDetail implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idfamilydetail", nullable = false)
	private int idFamilyDetail;

	@Column(name="mothername", nullable = true, length = 450)
	private String motherName;
	
	@Column(name="motherNic", nullable = true, length = 12)
	private String motherNic;
	
	@Column(name="fathername", nullable = true, length = 450)
	private String fatherName;
	
	@Column(name="fatherNic", nullable = true, length = 12)
	private String fatherNic;
	
	@OneToOne(cascade = CascadeType.ALL)	
	@JoinColumn(name="idgeneraldetail",  nullable = false)
	private GeneralDetail idGeneralDetail;

	public int getIdFamilyDetail() {
		return idFamilyDetail;
	}

	public void setIdFamilyDetail(int idFamilyDetail) {
		this.idFamilyDetail = idFamilyDetail;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getMotherNic() {
		return motherNic;
	}

	public void setMotherNic(String motherNic) {
		this.motherNic = motherNic;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getFatherNic() {
		return fatherNic;
	}

	public void setFatherNic(String fatherNic) {
		this.fatherNic = fatherNic;
	}

	public GeneralDetail getIdGeneralDetail() {
		return idGeneralDetail;
	}

	public void setIdGeneralDetail(GeneralDetail idGeneralDetail) {
		this.idGeneralDetail = idGeneralDetail;
	}

	
}
