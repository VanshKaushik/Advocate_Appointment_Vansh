package com.amdocs.advocate.appointment;
import java.util.*;

import com.amdocs.advocate.appointment.exceptions.InvalidAgeException;
import com.amdocs.advocate.appointment.exceptions.InvalidEmailException;
import com.amdocs.advocate.appointment.services.AppointmentServices;
import com.amdocs.advocate.appointment.services.CustomerServices;


public class App 
{
	private static Scanner sc = new Scanner(System.in);
	
    public static void main( String[] args )
    {
        
    	while(true)
        {
        	try 
        	{
				System.out.println("\n 1. Customer");
				System.out.println("\n 2. Advocate");
				System.out.println("\n 3. Appointment");
				System.out.println("\n 4. Services");
				System.out.println("\n 99. Exit");
				System.out.println("\n Enter your choice");
				int ch = Integer.parseInt(sc.nextLine());
				switch (ch) {
				case 1:
					customerMenu();
					break;
				case 2:
					advocateMenu();
					break;
				case 3:
					//displayAppointment();
					break;
				case 4:
					//displayServices();
					break;
				case 99:
					System.exit(0);
				default:
					System.out.println("Try again");
					break;
				}
				
			} 
			catch (NumberFormatException e) 
			{
				System.out.println("Try Again!! Enter a number");
				continue;
			}
			catch (Exception e)
			{
				System.out.println(e.getMessage());
				continue;
			}
				
        }
    }
    
    private static int customerMenu() 
    {
    	 
    	while(true)
        {
			try {
				System.out.println("\n 1. Register Customer");
				System.out.println("\n 2. Modify Customer Details");
				System.out.println("\n 3. Delete Customer Details");
				System.out.println("\n 4. View Single Record");
				System.out.println("\n 5. View All records");
				System.out.println("\n 99. Exit");
				System.out.println("\n Enter your choice");
				int ch = Integer.parseInt(sc.nextLine());
				switch (ch) {
				case 1:
					CustomerServices.registerCustomer();
					break;
				case 2:
					CustomerServices.modifyCustomerDetails();
					break;
				case 3:
					CustomerServices.deleteCustomerDetails();
					break;
				case 4:
					CustomerServices.viewSingleRecord();
					break;
				case 5:
					CustomerServices.viewAllRecords();
					break;
				case 99:
					return 1;
				default:
					System.out.println("Try again");
					break;
				}
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				System.out.println("Please Provide a number value\n " + e.getMessage());
				continue;
				
			}
			catch(InvalidAgeException e)
			{
				System.out.println(e);
			}
			catch(InvalidEmailException e)
			{
				System.out.println(e);
			}
			
        }	
    	
    }
    private static int advocateMenu()
    {
    	
    	while(true)
        {
			try {
				System.out.println("\n 1. Register Appointment");
				System.out.println("\n 2. Modify Appointment Details");
				System.out.println("\n 3. Delete Appointment Details");
				System.out.println("\n 4. View Single Record");
				System.out.println("\n 5. View All records");
				System.out.println("\n 99. Exit");
				System.out.println("\n Enter your choice");
				int ch = Integer.parseInt(sc.nextLine());
				switch (ch) {
				case 1:
					AppointmentServices.registerAppointment();
					break;
				case 2:
					AppointmentServices.modifyAppointmentDetails();
					break;
				case 3:
					AppointmentServices.deleteAppointmentDetails();
					break;
				case 4:
					AppointmentServices.viewSingleRecord();
					break;
				case 5:
					AppointmentServices.viewAllRecords();
					break;
				case 99:
					return 1;
				default:
					System.out.println("Try again");
					break;
					
				}
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				System.out.println("Please Provide a number value\n " + e.getMessage());
				continue;
			}
			
			
			
        }	
    	
    }
        	
    
}
