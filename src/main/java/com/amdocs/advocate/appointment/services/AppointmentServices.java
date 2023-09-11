package com.amdocs.advocate.appointment.services;

import java.util.*;

import com.amdocs.advocate.appointment.dao.AppointmentDao;
import com.amdocs.advocate.appointment.dao.impl.AppointmentDaoImpl;
import com.amdocs.advocate.appointment.entity.Appointment;


public class AppointmentServices {
	private static Scanner sc = new Scanner(System.in);
	public static void registerAppointment() 
	{
		Appointment createAppointment;
		createAppointment = createAppointment();
		AppointmentDao dao = new AppointmentDaoImpl();
		dao.add(createAppointment);
	}
	private static Appointment createAppointment() {
		// TODO Auto-generated method stub
		Appointment obj = new Appointment();
		System.out.println("Enter the Customer Id");
		int custId = Integer.parseInt(sc.nextLine());
		obj.setCustId(custId);
		System.out.println("Enter the Advocate Id");
		int advcId = Integer.parseInt(sc.nextLine());
		obj.setAdvcId(advcId);
		
		return obj;
	}
	public static int modifyAppointmentDetails()
	{
		System.out.println("Enter AppointmentId");
		int id = Integer.parseInt(sc.nextLine());
		Appointment modifyAppointment;
		AppointmentDao dao = new AppointmentDaoImpl();
		modifyAppointment = dao.findById(id);
		while(true)
		{
			System.out.println("Choose what you want to modify");
		
			System.out.println("\n 1. Customer Id");
			System.out.println("\n 2. Advocate Id ");
			System.out.println("\n 99. Exit");
			int ch = Integer.parseInt(sc.nextLine());
			switch (ch) {
			case 1:
				System.out.println("Enter the Customer Id");
				modifyAppointment.setCustId(Integer.parseInt(sc.nextLine()));
				break;
			case 2:
				System.out.println("Enter the Advocate Id");
				modifyAppointment.setAdvcId(Integer.parseInt(sc.nextLine()));
				break;
			case 99:
				dao.update(modifyAppointment);
				return 1;
			default:
				System.out.println("Try again");
				continue;
				
			}
			
		}
	}
	public static void deleteAppointmentDetails()
	{
		System.out.println("Enter Appointment Id");
		int id = Integer.parseInt(sc.nextLine());
		AppointmentDao dao = new AppointmentDaoImpl();
		dao.delete(id);
		
	}
	public static void viewSingleRecord()
	{
		System.out.println("Enter Appointment id");
		int id = Integer.parseInt(sc.nextLine());
		AppointmentDao dao = new AppointmentDaoImpl();
		Appointment appointment = dao.findById(id);
		System.out.println("Appointment details are as follows");
		System.out.println(appointment.toString());
	}
	public static void viewAllRecords()
	{
		
		AppointmentDao dao = new AppointmentDaoImpl();
		
		
		List<Appointment> allAppointment = dao.findAll();
		for (Appointment appointment : allAppointment) {
			if (appointment != null)
				System.out.println(appointment.toString());
		}
	}
	
	
}
