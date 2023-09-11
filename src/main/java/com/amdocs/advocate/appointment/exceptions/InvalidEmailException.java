package com.amdocs.advocate.appointment.exceptions;
@SuppressWarnings("serial")
public class InvalidEmailException extends Exception {
	public InvalidEmailException(String message) {
		super(message);
	}
}
