package com.amdocs.advocate.appointment.dao;

import java.util.List;

import com.amdocs.advocate.appointment.entity.Appointment;


public interface AppointmentDao {

	
	public boolean add(Appointment appointment);
	public Appointment findById(int id);
	public boolean update(Appointment appointment);
	public void delete(int id);
	public List<Appointment> findAll();
}
