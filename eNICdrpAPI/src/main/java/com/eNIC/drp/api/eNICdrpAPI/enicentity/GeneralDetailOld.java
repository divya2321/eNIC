package com.eNIC.drp.api.eNICdrpAPI.enicentity;

import java.sql.Date;

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
@Table(name="genelardetailold")
public class GeneralDetailOld {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idgeneraldetailold", nullable = false)
	private int idGeneralDetailOld;
	
	@Column(name="expireddate", nullable = false)
	private Date expiredDate;
	
	@Column(name="comment", nullable = false, length = 100)
	private String   comment;
	
	@OneToOne(cascade = CascadeType.ALL)	
	@JoinColumn(name="idgeneraldetail",  nullable = false)
	private GeneralDetail idGeneralDetail;

	public GeneralDetail getIdGeneralDetail() {
		return idGeneralDetail;
	}

	public void setIdGeneralDetail(GeneralDetail idGeneralDetail) {
		this.idGeneralDetail = idGeneralDetail;
	}

	public int getIdGeneralDetailOld() {
		return idGeneralDetailOld;
	}

	public void setIdGeneralDetailOld(int idGeneralDetailOld) {
		this.idGeneralDetailOld = idGeneralDetailOld;
	}

	public Date getExpiredDate() {
		return expiredDate;
	}

	public void setExpiredDate(Date expiredDate) {
		this.expiredDate = expiredDate;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
	
}
