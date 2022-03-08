package com.mif.vu.validateapp.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


class ValidationServiceTest {

	ValidationService validationService;
	 @BeforeEach
	 void before() {
		 validationService = new ValidationService();
	 }
	 @Test
	    void passwordChecker_passwordLengthTest(){
	        String password = "Ggg123";
	        assertTrue(validationService.validatePassword(password));
	    }
	    @Test
	    void passwordChecker_passwordContainsUppercaseTest(){
	        String password = "Ggg123";
	        assertTrue(validationService.validatePassword(password));
	    }
	    @Test
	    void passwordChecker_passwordContainsSpecialSymbolTest(){
	        String password = "Ggg123";
	        assertTrue(validationService.validatePassword(password));
	    }
	    @Test
	    void phonevalidationService_numberLengthTest(){
	        String number = "2452";
	        assertTrue(validationService.validatePhone(number));
	    }
	    @Test
	    void phonevalidationService_numberContainsCorrectSymbolsTest(){
	        String number = "5551414";
	        assertTrue(validationService.validatePhone(number));
	    }
	    @Test
	    void phonevalidationService_numberPrefixTest(){
	        String number = "8487432";
	        assertTrue(validationService.validatePhone(number));
	    }
	    @Test
	    void emailvalidationService_emailContainsEtaTest(){
	        String email = "test@gmail.com";
	        assertTrue(validationService.validateEmail(email));
	    }
	    @Test
	    void emailvalidationService_emailContainsCorrectSymbolsTest(){
	        String email = "test@gmail.com";
	        assertTrue(validationService.validateEmail(email));
	    }
	    @Test
	    void emailvalidationService_emailDomainTest(){
	        String email = "test@gmail.com";
	        assertTrue(validationService.validateEmail(email));
	    }
	    @Test
	    void emailvalidationService_emailTLDTest(){
	        String email = "test@gmail.com";
	        assertTrue(validationService.validateEmail(email));
	    }
	    @Test
	    void passwordChecker_passwordLengthTestTooShort() {
	        String password = "Ggg12";
	        assertFalse(validationService.validatePassword(password));
	    }

	    @Test
	    void passwordChecker_passwordDoesNotContainUppercase() {
	        String password = "ggg123";
	        assertFalse(validationService.validatePassword(password));
	    }

	    @Test
	    void passwordChecker_passwordDoesNotContainSpecialSymbol() {
	        String password = "Gggsad";
	        assertFalse(validationService.validatePassword(password));
	    }

	    @Test
	    void phonevalidationService_numberLengthTooShort() {
	        String number = "24";
	        assertFalse(validationService.validatePhone(number));
	    }

	    @Test
	    void phonevalidationService_numberContainsNonNumericSymbols() {
	        String number = "5551414a";
	        assertFalse(validationService.validatePhone(number));
	    }

	    @Test
	    void phonevalidationService_numberContainsNonNumericSymbols2() {
	        String number = "5551414*";
	        assertFalse(validationService.validatePhone(number));
	    }

	    @Test
	    void emailvalidationService_emailDoesNotContainEta() {
	        String email = "testgmail.com";
	        assertFalse(validationService.validateEmail(email));
	    }

	    @Test
	    void emailvalidationService_emailContainsIncorrectSymbols() {
	        String email = "test@gm#ail.com";
	        assertFalse(validationService.validateEmail(email));
	    }

	    @Test
	    void emailvalidationService_emailContainsDuplicateEta() {
	        String email = "test@gm@ail.com";
	        assertFalse(validationService.validateEmail(email));
	    }

	    @Test
	    void emailvalidationService_emailMissingDomain() {
	        String email = "test@";
	        assertFalse(validationService.validateEmail(email));
	    }

	    @Test
	    void emailvalidationService_emailMissingTLD() {
	        String email = "test@gmailcom";
	        assertFalse(validationService.validateEmail(email));
	    }

	    @Test
	    void emailvalidationService_emailMissingTLD2() {
	        String email = "test@gmailcom.";
	        assertFalse(validationService.validateEmail(email));
	    }

	    @Test
	    void emailvalidationService_emailTLDContainsNumbers() {
	        String email = "test@gmail.c1om";
	        assertFalse(validationService.validateEmail(email));
	    }

	    @Test
	    void emailvalidationService_emailTLDContainsInvalidSymbols() {
	        String email = "test@gmail.co.m";
	        assertFalse(validationService.validateEmail(email));
	    }
}
