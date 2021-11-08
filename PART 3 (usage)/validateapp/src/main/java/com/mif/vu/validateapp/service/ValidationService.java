package com.mif.vu.validateapp.service;

import org.springframework.stereotype.Service;

import com.mif.vu.validateapp.library.Validator;

@Service
public class ValidationService {

	private Validator validator;
	public ValidationService() {
		validator = new Validator();
	}
	
	public boolean validatePassword(String passowrd) {
		return validator.validatePassword(passowrd);
	}
	
	public boolean validateEmail(String email) {
		return validator.validateEmail(email);
	}
	
	public boolean validatePhone(String phone) {
		return validator.validatePhone(phone);
	}
}
