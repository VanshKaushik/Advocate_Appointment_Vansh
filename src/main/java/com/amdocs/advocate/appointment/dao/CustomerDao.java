package com.amdocs.advocate.appointment.dao;
import java.util.List;

import com.amdocs.advocate.appointment.entity.Customer;

import java.sql.SQLException;

public interface CustomerDao {
	public boolean add(Customer customer);
	public Customer findById(int id);
	public Customer update(Customer customer);
	public void delete(int id);
	public List<Customer> findAll();
}
