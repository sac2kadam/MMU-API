package com.iemr.mmu.data.anc;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

@Entity
@Table(name = "t_Sys_Cardiovascular")
public class SysCardiovascularExamination {
	
	@Id
	@GeneratedValue
	@Expose
	@Column(name = "ID")
	private Long ID;

	@Expose
	@Column(name = "BeneficiaryRegID")
	private Long beneficiaryRegID;

	@Expose
	@Column(name = "BenVisitID")
	private Long benVisitID;
	
	@Expose
	@Column(name = "JugularVenousPulse_JVP")
	private String jugularVenousPulse_JVP;
	
	@Expose
	@Column(name = "ApexbeatLocation")
	private String apexbeatLocation;
	
	@Expose
	@Column(name = "ApexbeatType")
	private String apexbeatType;

	@Expose
	@Column(name = "FirstHeartSound_S1")
	private String firstHeartSound_S1;

	@Expose
	@Column(name = "SecondHeartSound_S2")
	private String secondHeartSound_S2;

	@Expose
	@Column(name = "AdditionalHeartSounds")
	private String additionalHeartSounds;

	@Expose
	@Column(name = "Murmurs")
	private String murmurs;

	@Expose
	@Column(name = "PericardialRub")
	private String pericardialRub;
	
	@Expose
	@Column(name = "Deleted", insertable = false, updatable = true)
	private Boolean deleted;

	@Expose
	@Column(name = "Processed", insertable = false, updatable = true)
	private String processed;

	@Expose
	@Column(name = "CreatedBy")
	private String createdBy;

	@Expose
	@Column(name = "CreatedDate", insertable = false, updatable = false)
	private Timestamp createdDate;

	@Expose
	@Column(name = "ModifiedBy")
	private String modifiedBy;

	@Expose
	@Column(name = "LastModDate", insertable = false, updatable = false)
	private Timestamp lastModDate;
}