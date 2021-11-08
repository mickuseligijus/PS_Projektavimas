package com.mif.vu.validateapp.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		// Validatorius implementuotas nekorektiskai (pvz test@gmail.com nera validus email) nepraeina unit testai..
		// Neisivaizduoju kaip kitaip galima validuoti emailus nekeiciant Validator.class todel visa valdacijos logika bus cia :D
		if(!validator.validateEmail(email))
		{
		String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		Pattern pattern = Pattern.compile(regex); 
		Matcher matcher = pattern.matcher(email);
		 
		return matcher.matches();
		}
	
		 
		return validator.validateEmail(email);
		
		
	}
	
	public boolean validatePhone(String phone) {
		return validator.validatePhone(phone);
	}
}
