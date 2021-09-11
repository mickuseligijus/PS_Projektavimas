package lt.vu.mif.validators;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestValidators {
    private PhoneValidator phoneValidator;
    private EmailValidator emailValidator;
    private PasswordChecker passwordChecker;

    @BeforeEach
    public void SetUp(){
        phoneValidator = new PhoneValidator();
        emailValidator = new EmailValidator();
        passwordChecker = new PasswordChecker();
    }
    @Test
    public void TestEmptyPhoneNumber(){
        String number = "    ";
        assertFalse(phoneValidator.isPhoneNumberValid(number));
    }
    @Test
    public void TestPhoneNumberStartsWithLetter(){
        
    }
}
