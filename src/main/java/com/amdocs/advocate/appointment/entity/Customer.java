package com.amdocs.advocate.appointment.entity;

public class Customer {
	
	private int id;
	private String firstName;
	private String lastName;
	private int age;
	private String email;
	private String passwords;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPasswords() {
		return passwords;
	}
	public void setPasswords(String passwords) {
		this.passwords = passwords;
	}
	@Override
	public String toString() {
		return "Customer details [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
				+ ", email=" + email + ", passwords=" + passwords + "]";
	}
	
	

}
