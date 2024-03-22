package com.scw.sports.carnival.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

public class RegistrationView {
	
	@NotEmpty(message = "The Phone Number can not be empty")
	@Pattern(regexp = "^\\d{10}$", message="Mobile Number format is invalid")
	private String phoneNumber;

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
