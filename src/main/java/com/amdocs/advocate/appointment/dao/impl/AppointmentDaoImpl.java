package com.amdocs.advocate.appointment.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.amdocs.advocate.appointment.dao.AppointmentDao;
import com.amdocs.advocate.appointment.entity.Appointment;
import com.amdocs.advocate.appointment.util.DBUtil;

import java.util.ArrayList;
import java.util.List;


public class AppointmentDaoImpl implements AppointmentDao
{
	private static final String INSERT_APPOINTMENT = "insert into appointments(advcId, custId) values(?,?)";
	private static final String FIND_APPOINTMENT = "SELECT Appointments.id, appointments.advcId, appointments.custId, advocates.firstName, advocates.lastName, advocates.specialization FROM ((appointments INNER JOIN Customers ON Appointments.custId = Customers.id) INNER JOIN Advocates ON Appointments.advcId = Advocates.id) where appointments.id=?;";
	private static final String UPDATE_APPOINTMENT = "update appointments set advcId = ?, custId = ? where id = ?";
	private static final String DELETE_APPOINTMENT = "delete from appointments where id =?";
	private static final String FIND_APPOINTMENTS = "SELECT Appointments.id, appointments.advcId, appointments.custId, advocates.firstName, advocates.lastName, advocates.specialization FROM ((appointments INNER JOIN Customers ON Appointments.custId = Customers.id) INNER JOIN Advocates ON Appointments.advcId = Advocates.id);";
	private  Connection connection = DBUtil.getConnection();
	@Override
	public boolean add(Appointment appointment) 
	{
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps = connection.prepareStatement(INSERT_APPOINTMENT);
			// Set The value
			ps.setInt(1, appointment.getAdvcId());
			ps.setInt(2, appointment.getCustId());
			//Execute Statement
			int executeUpdate = ps.executeUpdate();
			ps.close();
			if(executeUpdate>0) {
				System.out.println("Your Registration was Successful");
				//System.out.println("Your details are \n"+ appointment);
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public Appointment findById(int id) {
		// TODO Auto-generated method stub
		Appointment appointment = new Appointment();
		
		try {
			PreparedStatement ps = connection.prepareStatement(FIND_APPOINTMENT);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			appointment.setId(rs.getInt("id"));
			appointment.setAdvcId(rs.getInt("advcId"));
			appointment.setCustId(rs.getInt("custId"));
			appointment.setAdvocateFirstName(rs.getString("advocates.firstName"));
			appointment.setAdvocateLastName(rs.getString("advocates.lastName"));
			appointment.setSpecialization(rs.getString("advocates.specialization"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
			return appointment;
		
	}
	@Override
	public boolean update(Appointment appointment) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps = connection.prepareStatement(UPDATE_APPOINTMENT);
			// Set The value
			ps.setInt(1, appointment.getAdvcId());
			ps.setInt(2, appointment.getCustId());
			ps.setInt(3,appointment.getId());
			//Execute Statement
			int executeUpdate = ps.executeUpdate();
			ps.close();
			if(executeUpdate>0) {
				
				System.out.println("Your Update was Successful");
				return true;
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		try
		{
		PreparedStatement ps = connection.prepareStatement(DELETE_APPOINTMENT);
		ps.setInt(1, id);
		
		int executeUpdate = ps.executeUpdate();
		ps.close();
		if(executeUpdate>0) {
			System.out.println("Your Delete was Successful");
		}
		else
		{
			System.out.println("Your Delete was unuccessful");
		} 
		}
		catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
		}
	}
	@Override
	public List<Appointment> findAll() {
		// TODO Auto-generated method stub
		
		List <Appointment> appointments = new ArrayList<>(); 
		try {
			PreparedStatement ps = connection.prepareStatement(FIND_APPOINTMENTS);
			 ResultSet rs=ps.executeQuery();
			 
			 while(rs.next())
			 {
				 Appointment appointment = new Appointment();
				 appointment.setId(rs.getInt("id"));
					appointment.setAdvcId(rs.getInt("advcId"));
					appointment.setCustId(rs.getInt("custId"));
					appointment.setAdvocateFirstName(rs.getString("advocates.firstName"));
					appointment.setAdvocateLastName(rs.getString("advocates.lastName"));
					appointment.setSpecialization(rs.getString("advocates.specialization"));
				 appointments.add(appointment);
			 }
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return appointments;
	}
	
	
	
}
