package com.palash.investment.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class MasterModel {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "created_by")
	private int createdBy;
	@Column(name = "creation_date")
	private String creationDate;
	@Column(name = "current_status")
	private String currentStatus;
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCreatedBy() {
		return this.createdBy;
	}
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}
	public String getCreationDate() {
		return this.creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	public String getCurrentStatus() {
		return this.currentStatus;
	}
	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}
	@Override
	public String toString() {
		return "MasterModel [id=" + this.id + ", createdBy=" + this.createdBy + ", creationDate=" + this.creationDate
				+ ", currentStatus=" + this.currentStatus + "]";
	}
	
}
