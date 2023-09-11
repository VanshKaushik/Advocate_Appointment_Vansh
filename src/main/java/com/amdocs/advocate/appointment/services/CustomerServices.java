package com.amdocs.advocate.appointment.services;
import java.util.*;
import java.util.regex.Pattern;

import com.amdocs.advocate.appointment.dao.CustomerDao;
import com.amdocs.advocate.appointment.dao.impl.CustomerDaoImpl;
import com.amdocs.advocate.appointment.entity.Customer;
import com.amdocs.advocate.appointment.exceptions.InvalidAgeException;
import com.amdocs.advocate.appointment.exceptions.InvalidEmailException;
public class CustomerServices 
{
	private static Scanner sc = new Scanner(System.in);
	public static void registerCustomer() throws InvalidEmailException, InvalidAgeException 
	{
		
		Customer createCustomer;
		createCustomer = createCustomer();
		CustomerDao dao = new CustomerDaoImpl();
		dao.add(createCustomer);
	}
	private static Customer createCustomer() throws InvalidEmailException, InvalidAgeException  
	{
		Customer obj = new Customer();
		
		
		System.out.println("Enter The First Name: ");
		String firstName = sc.nextLine();
		obj.setFirstName(firstName);
		firstName = obj.getFirstName();
		System.out.println("Enter The Last Name: ");
		String lastName = sc.nextLine();
		obj.setLastName(lastName);
		lastName = obj.getLastName();
		System.out.println("Enter The Age: ");
		int age = Integer.parseInt(sc.nextLine());
		if(age<0)
		{
			throw new InvalidAgeException("Age must be a positive number");
		}
		obj.setAge(age);
		age = obj.getAge();
		System.out.println("Enter The email: ");
		String email = sc.nextLine();
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";
                  
		Pattern pat = Pattern.compile(emailRegex);
		if(pat.matcher(email).matches()==false)
		{
			throw new InvalidEmailException("Please enter email in correct format");
		}
		obj.setEmail(email);
		email= obj.getEmail();
		System.out.println("Enter The Password: ");
		String passwords = sc.nextLine();
		obj.setPasswords(passwords);
		passwords= obj.getPasswords();
		return obj;
	}
	public static int modifyCustomerDetails() throws InvalidAgeException, InvalidEmailException 
	{
		System.out.println("Enter Customer Id");
		int id = Integer.parseInt(sc.nextLine());
		Customer modifyCustomer;
		CustomerDao dao = new CustomerDaoImpl();
		modifyCustomer = dao.findById(id);
		System.out.println(modifyCustomer);
		while(true)
		{
			System.out.println("Choose what you want to modify");
		
			System.out.println("\n 1. First Name");
			System.out.println("\n 2. Last Name ");
			System.out.println("\n 3. Age");
			System.out.println("\n 4. Email id");
			System.out.println("\n 5. Password");
			System.out.println("\n 99. Exit");
			int ch = Integer.parseInt(sc.nextLine());
			switch (ch) {
			case 1:
				System.out.println("Enter the first name");
				modifyCustomer.setFirstName(sc.nextLine());
				break;
			case 2:
				System.out.println("Enter the last name");
				modifyCustomer.setLastName(sc.nextLine());
				break;
			case 3:
				System.out.println("Enter the Age");
				int age = Integer.parseInt(sc.nextLine());
				if(age<0)
				{
					throw new InvalidAgeException("Age must be a positive number");
				}
				modifyCustomer.setAge(age);
				System.out.println(modifyCustomer.getAge());
				break;
			case 4:
				System.out.println("Enter the Email");
				String email = sc.nextLine();
				String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
		                "[a-zA-Z0-9_+&*-]+)*@" +
		                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
		                "A-Z]{2,7}$";
		                  
				Pattern pat = Pattern.compile(emailRegex);
				if(pat.matcher(email).matches()==false)
				{
					throw new InvalidEmailException("Please enter email in correct format");
				}
				modifyCustomer.setEmail(email);
				break;
			case 5:
				System.out.println("Enter the password");
				modifyCustomer.setPasswords(sc.nextLine());
				break;
			case 99:
				System.out.println("Your new details are as follows" +dao.update(modifyCustomer));
				return 1;
			default:
				System.out.println("Try again");
				continue;
			}
		
		}
		
	}
	public static void deleteCustomerDetails()
	{
		System.out.println("Enter Customer Id");
		int id = Integer.parseInt(sc.nextLine());
		CustomerDao dao = new CustomerDaoImpl();
		dao.delete(id);
		
	}
	
	public static void viewSingleRecord()
	{
		System.out.println("Enter Customer id");
		int id = Integer.parseInt(sc.nextLine());
		CustomerDao dao = new CustomerDaoImpl();
		Customer customer = dao.findById(id);
		System.out.println(customer.toString());
	}
	public static void viewAllRecords()
	{
		
		CustomerDao dao = new CustomerDaoImpl();
		
		
		List<Customer> allCustomer = dao.findAll();
		for (Customer customer : allCustomer) {
			if (customer != null)
				System.out.println(customer.toString());
		}
	}
	
}
