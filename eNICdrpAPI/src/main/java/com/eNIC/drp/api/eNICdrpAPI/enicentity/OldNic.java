package com.eNIC.drp.api.eNICdrpAPI.enicentity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="oldnic")
public class OldNic {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idoldnic", nullable = false)
	private int idOldNic;
	
	@Lob
	@Column(name="scannedoldnic", nullable = false)
	private String scannedOldNic;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idapplication", nullable = false)
	private Application idApplication;

	public int getIdOldNic() {
		return idOldNic;
	}

	public void setIdOldNic(int idOldNic) {
		this.idOldNic = idOldNic;
	}

	public String getScannedOldNic() {
		return scannedOldNic;
	}

	public void setScannedOldNic(String scannedOldNic) {
		this.scannedOldNic = scannedOldNic;
	}

	public Application getIdApplication() {
		return idApplication;
	}

	public void setIdApplication(Application idApplication) {
		this.idApplication = idApplication;
	}

}
