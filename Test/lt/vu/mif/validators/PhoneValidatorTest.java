package lt.vu.mif.validators;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PhoneValidatorTest {
    private PhoneValidator phoneValidator;


    @BeforeEach
    public void SetUp(){
        phoneValidator = new PhoneValidator();
        passwordChecker = new PasswordChecker();
    }
    @Test
    public void TestNoSpaceBarsInPhoneNumber(){
        String number = "+370 343 00 000";
        Assertions.assertFalse(phoneValidator.isPhoneNumberValid(number));
    }
    @Test
    public void TestNoOtherSymbolsInPhoneNumber(){
        String number = "(86) 21 380 62";
        Assertions.assertFalse(phoneValidator.isPhoneNumberValid(number));
    }
    @Test
    public void TestPhoneNumberIsShorterByOne(){
        String number = "+3706213906";
        Assertions.assertFalse(phoneValidator.isPhoneNumberValid(number));
    }
    @Test
    public void TestPhoneNumberIsLongerByTwo(){
        String number = "+3706217806238";
        Assertions.assertFalse(phoneValidator.isPhoneNumberValid(number));    }
    @Test
    public void TestEmptyPhoneNumber(){
        String number = "    ";
        Assertions.assertFalse(phoneValidator.isPhoneNumberValid(number));    }
    @Test
    public void TestNullNumber(){
        Assertions.assertFalse(phoneValidator.isPhoneNumberValid(null));
    }
    @Test
    //
    public void TestPhoneNumberStartsWithLetter(){
        String number = "c62138079";
        Assertions.assertFalse(phoneValidator.isPhoneNumberValid(number));
    }
    @Test
    public void TestPhoneNumberStartsWithIncorrectSymbol(){
        String number = "-37062157469";
        Assertions.assertFalse(phoneValidator.isPhoneNumberValid(number));
    }
    @Test
    public void TestPhoneNumberReplacesPrefix(){
        String number = "869721384";
        Assertions.assertEquals("+37069721384", phoneValidator.replacePhoneNumberPrefix(number));
    }
    @ParameterizedTest
    @ValueSource(strings = {"+37062138062", "862138062","+37062891542","862891542"})
    public void TestIsNumberValidCorrect(String input){
        assertTrue(phoneValidator.isPhoneNumberValid(input));
    }

    @Test
    public void TestIsAnotherStateNumberIsValid(){
        String number = "+38760123456";
        Assertions.assertTrue(phoneValidator.isPhoneNumberValidByState(number,"+387","60",8));

    }
}
