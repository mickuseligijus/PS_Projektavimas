package lt.vu.mif.validators;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PasswordCheckerTest {

    private PasswordChecker passwordChecker;

    @BeforeEach
    public void SetUp(){
        passwordChecker = new PasswordChecker();
    }

    @Test
    public void TestPasswordLengthIsCorrect(){
        String password = "jOnaitis519*";
        int length = 8;
        Assertions.assertTrue(passwordChecker.isPasswordLengthCorrect(password,length));
    }
    @Test
    public void TestPasswordLengthIsShorterThanRequired(){
        String password = "Mika.45";
        int length = 8;
        Assertions.assertTrue(passwordChecker.isPasswordLengthCorrect(password,length));
    }

    @Test
    public void TestThereIsNoUpperCaseInPassword(){
        String password = "nikosija45-";
        Assertions.assertFalse(passwordChecker.checkPasswordUpperCase(password));
    }

    @Test
    public void TestThereIsUpperCaseInPassword(){
        String password = "nikoSija45-";
        Assertions.assertTrue(passwordChecker.checkPasswordUpperCase(password));
    }
    @Test
    public void TestSpecialSymbol(){
        String password = "nikaRagvasijus15@12";
        char[] symbolsList= {',','@','.','!'};
        Assertions.assertTrue(passwordChecker.isThereASpecialSymbol(password,symbolsList));
    }
    @Test
    public void TestSpecialSymbolFalse(){
        String password = "nikaRagvasijus15}12";
        char[] symbolsList= {',','@','.','!'};
        Assertions.assertFalse(passwordChecker.isThereASpecialSymbol(password,symbolsList));
    }

    @Test
    public void TestIsPasswordValidTrue(){
        String password = "12345678A-";
        Assertions.assertTrue(passwordChecker.isPasswordValid(password));
    }

    @Test
    public void TestIsPasswordValidFalse(){
        String password = "antanas12";
        Assertions.assertFalse(passwordChecker.isPasswordValid(password));
    }

    @Test
    public void TestPasswordEmpty(){
        String password = "";
        Assertions.assertFalse(passwordChecker.isPasswordValid(password));
    }

    @Test
    public void TestPasswordNull() {
        Assertions.assertFalse(passwordChecker.isPasswordValid(null));
    }


}