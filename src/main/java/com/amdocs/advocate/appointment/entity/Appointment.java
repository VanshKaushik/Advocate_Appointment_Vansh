package com.amdocs.advocate.appointment.entity;

public class Appointment {

	private int id;
	private int advcId;
	private int custId;
	private String advocateFirstName;
	private String advocateLastName;
	private String specialization;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAdvcId() {
		return advcId;
	}
	public void setAdvcId(int advcId) {
		this.advcId = advcId;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getAdvocateFirstName() {
		return advocateFirstName;
	}
	public void setAdvocateFirstName(String advocateFirstName) {
		this.advocateFirstName = advocateFirstName;
	}
	public String getAdvocateLastName() {
		return advocateLastName;
	}
	public void setAdvocateLastName(String advocateLastName) {
		this.advocateLastName = advocateLastName;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	@Override
	public String toString() {
		return "Appointment [id=" + id + ", advcId=" + advcId + ", custId=" + custId + ", advocateFirstName="
				+ advocateFirstName + ", advocateLastName=" + advocateLastName + ", specialization=" + specialization
				+ "]";
	}

	
	
}
