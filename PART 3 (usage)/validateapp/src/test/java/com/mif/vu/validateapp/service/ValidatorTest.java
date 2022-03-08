package com.mif.vu.validateapp.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mif.vu.validateapp.library.Validator;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    Validator validator;

    @BeforeEach
    void setUp() {
        validator =  new Validator();
    }
    @Test
    void passwordChecker_passwordLengthTest(){
        String password = "Ggg123";
        assertTrue(validator.validatePassword(password));
    }
    @Test
    void passwordChecker_passwordContainsUppercaseTest(){
        String password = "Ggg123";
        assertTrue(validator.validatePassword(password));
    }
    @Test
    void passwordChecker_passwordContainsSpecialSymbolTest(){
        String password = "Ggg123";
        assertTrue(validator.validatePassword(password));
    }
    @Test
    void phoneValidator_numberLengthTest(){
        String number = "2452";
        assertTrue(validator.validatePhone(number));
    }
    @Test
    void phoneValidator_numberContainsCorrectSymbolsTest(){
        String number = "5551414";
        assertTrue(validator.validatePhone(number));
    }
    @Test
    void phoneValidator_numberPrefixTest(){
        String number = "8487432";
        assertTrue(validator.validatePhone(number));
    }
    @Test
    void emailValidator_emailContainsEtaTest(){
        String email = "test@gmail.com";
        assertTrue(validator.validateEmail(email));
    }
    @Test
    void emailValidator_emailContainsCorrectSymbolsTest(){
        String email = "test@gmail.com";
        assertTrue(validator.validateEmail(email));
    }
    @Test
    void emailValidator_emailDomainTest(){
        String email = "test@gmail.com";
        assertTrue(validator.validateEmail(email));
    }
    @Test
    void emailValidator_emailTLDTest(){
        String email = "test@gmail.com";
        assertTrue(validator.validateEmail(email));
    }
    @Test
    void passwordChecker_passwordLengthTestTooShort() {
        String password = "Ggg12";
        assertFalse(validator.validatePassword(password));
    }

    @Test
    void passwordChecker_passwordDoesNotContainUppercase() {
        String password = "ggg123";
        assertFalse(validator.validatePassword(password));
    }

    @Test
    void passwordChecker_passwordDoesNotContainSpecialSymbol() {
        String password = "Gggsad";
        assertFalse(validator.validatePassword(password));
    }

    @Test
    void phoneValidator_numberLengthTooShort() {
        String number = "24";
        assertFalse(validator.validatePhone(number));
    }

    @Test
    void phoneValidator_numberContainsNonNumericSymbols() {
        String number = "5551414a";
        assertFalse(validator.validatePhone(number));
    }

    @Test
    void phoneValidator_numberContainsNonNumericSymbols2() {
        String number = "5551414*";
        assertFalse(validator.validatePhone(number));
    }

    @Test
    void emailValidator_emailDoesNotContainEta() {
        String email = "testgmail.com";
        assertFalse(validator.validateEmail(email));
    }

    @Test
    void emailValidator_emailContainsIncorrectSymbols() {
        String email = "test@gm#ail.com";
        assertFalse(validator.validateEmail(email));
    }

    @Test
    void emailValidator_emailContainsDuplicateEta() {
        String email = "test@gm@ail.com";
        assertFalse(validator.validateEmail(email));
    }

    @Test
    void emailValidator_emailMissingDomain() {
        String email = "test@";
        assertFalse(validator.validateEmail(email));
    }

    @Test
    void emailValidator_emailMissingTLD() {
        String email = "test@gmailcom";
        assertFalse(validator.validateEmail(email));
    }

    @Test
    void emailValidator_emailMissingTLD2() {
        String email = "test@gmailcom.";
        assertFalse(validator.validateEmail(email));
    }

    @Test
    void emailValidator_emailTLDContainsNumbers() {
        String email = "test@gmail.c1om";
        assertFalse(validator.validateEmail(email));
    }

    @Test
    void emailValidator_emailTLDContainsInvalidSymbols() {
        String email = "test@gmail.co.m";
        assertFalse(validator.validateEmail(email));
    }
    @AfterEach
    void tearDown() {
    }
}