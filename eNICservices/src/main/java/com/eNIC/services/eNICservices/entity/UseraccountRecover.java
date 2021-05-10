package com.eNIC.services.eNICservices.entity;

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
@Table(name="useraccountrecover")
public class UseraccountRecover {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="iduseraccountrecover", nullable = false)
	private int idUseraccountRecover;
	
	@Column(name="recoverquestion", nullable = false, length = 100)
	private String recoverQuestion;
	
	@Column(name="recooveranswer", nullable = false, length = 20)
	private String recoverAnswer;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="iduseraccount", nullable = false)
	private OrganizationUser idUseraccount;

	public int getIdUseraccountRecover() {
		return idUseraccountRecover;
	}

	public void setIdUseraccountRecover(int idUseraccountRecover) {
		this.idUseraccountRecover = idUseraccountRecover;
	}

	public String getRecoverQuestion() {
		return recoverQuestion;
	}

	public void setRecoverQuestion(String recoverQuestion) {
		this.recoverQuestion = recoverQuestion;
	}

	public String getRecoverAnswer() {
		return recoverAnswer;
	}

	public void setRecoverAnswer(String recoverAnswer) {
		this.recoverAnswer = recoverAnswer;
	}

	public OrganizationUser getIdUseraccount() {
		return idUseraccount;
	}

	public void setIdUseraccount(OrganizationUser idUseraccount) {
		this.idUseraccount = idUseraccount;
	}

	
	
}
