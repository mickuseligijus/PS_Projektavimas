package validation;

public class PasswordChecker {
    public static boolean checkLength(String password, int minLength, int maxLength) {

        return password.length()>= minLength && password.length()<=maxLength && password != null;
    }

    public static boolean checkUppercase(String password) {
        return false;
    }

    public static boolean checkSpecialSymbols(String pw) {
        return false;
    }
}
