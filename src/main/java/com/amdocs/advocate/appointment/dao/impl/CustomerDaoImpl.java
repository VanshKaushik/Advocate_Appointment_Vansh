package com.amdocs.advocate.appointment.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.amdocs.advocate.appointment.dao.CustomerDao;
import com.amdocs.advocate.appointment.entity.Customer;
import com.amdocs.advocate.appointment.util.DBUtil;

import java.util.ArrayList;
import java.util.List;
public class CustomerDaoImpl implements CustomerDao 
{
	private static final String INSERT_CUSTOMER="insert into customers(firstName, lastName, age, email, passwords) values(?,?,?,?,?)";
	private static final String FIND_CUSTOMER = "select * from customers where id = ?";
	private static final String UPDATE_CUSTOMER = "update customers set firstName = ?, lastName = ?, age = ?, email= ?, passwords = ? where id = ?";
	private static final String DELETE_CUSTOMER = "delete from customers where id =?";
	private static final String FIND_CUSTOMERS = "select * from customers";
	private  Connection connection = DBUtil.getConnection();
	
	@Override
	public boolean add(Customer customer) 
	{
		
		try {
			PreparedStatement ps = connection.prepareStatement(INSERT_CUSTOMER);
			// Set The value
			ps.setString(1, customer.getFirstName());
			ps.setString(2, customer.getLastName());
			ps.setInt(3, customer.getAge());
			ps.setString(4, customer.getEmail());
			ps.setString(5, customer.getPasswords());
			
			//Execute Statement
			int executeUpdate = ps.executeUpdate();
			ps.close();
			if(executeUpdate>0) {
				System.out.println("Your Registration was Successful");
				//System.out.println("Your details are \n"+ customer);
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Customer findById(int id) {
		// TODO Auto-generated method stub
		Customer customer = new Customer();
		
		try {
			PreparedStatement ps = connection.prepareStatement(FIND_CUSTOMER);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			customer.setId(rs.getInt("id"));
			customer.setFirstName(rs.getString("firstName"));
			customer.setLastName(rs.getString("lastName"));
			customer.setAge(rs.getInt("age"));
			customer.setEmail(rs.getString("email"));
			customer.setPasswords(rs.getString("passwords"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
			return customer;
	}

	@Override
	public Customer update(Customer customer) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps = connection.prepareStatement(UPDATE_CUSTOMER);
			// Set The value
			ps.setString(1, customer.getFirstName());
			ps.setString(2, customer.getLastName());
			ps.setInt(3, customer.getAge());
			ps.setString(4, customer.getEmail());
			ps.setString(5, customer.getPasswords());
			ps.setInt(6,customer.getId());
			//Execute Statement
			int executeUpdate = ps.executeUpdate();
			ps.close();
			if(executeUpdate>0) {
				System.out.println("Your Update was Successful");
				return customer;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customer;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		try
		{
		PreparedStatement ps = connection.prepareStatement(DELETE_CUSTOMER);
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
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		List <Customer> customers = new ArrayList<>(); 
		try {
			PreparedStatement ps = connection.prepareStatement(FIND_CUSTOMERS);
			 ResultSet rs=ps.executeQuery();
			 
			 while(rs.next())
			 {
				 Customer customer = new Customer();
				 customer.setId(rs.getInt("id"));
				 customer.setFirstName(rs.getString("firstName"));
				 customer.setLastName(rs.getString("lastName"));
				 customer.setAge(rs.getInt("age"));
				 customer.setEmail(rs.getString("email"));
				 customer.setPasswords(rs.getString("passwords")); 
				 customers.add(customer);
			 }
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customers;
	}
	
}
