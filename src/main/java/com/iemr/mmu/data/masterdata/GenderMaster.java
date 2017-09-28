package com.iemr.mmu.data.masterdata;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

@Entity
@Table(name = "m_gender")
public class GenderMaster {
	@Id
	@GeneratedValue
	@Expose
	@Column(name = "GenderID")
	private Short genderID;
	@Expose
	@Column(name = "GenderName")
	private String genderName;
	@Expose
	@Column(name = "Deleted")
	private Boolean deleted;

	public GenderMaster() {
	}

	public GenderMaster(Short genderID, String genderName) {
		this.genderID = genderID;
		this.genderName = genderName;
	}

	public static ArrayList<GenderMaster> getGenderMasterData(ArrayList<Object[]> resList) {
		ArrayList<GenderMaster> resArray = new ArrayList<>();
		for (Object[] obj : resList) {
			GenderMaster cOBJ = new GenderMaster((Short) obj[0], (String) obj[1]);
			resArray.add(cOBJ);
		}
		return resArray;
	}

}
