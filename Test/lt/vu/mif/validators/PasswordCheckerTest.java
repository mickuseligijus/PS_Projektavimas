package lt.vu.mif.validators;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class PasswordCheckerTest {

    private PasswordChecker passwordChecker;

    @BeforeEach
    public void SetUp(){
        passwordChecker = new PasswordChecker();
    }

}