package validation;

public class PasswordChecker {

    private static char[] specialSymbols = {'>','!',' ','?','-','+','*'};

    public static boolean checkLength(String password, int minLength, int maxLength) {
        if (password == null || password.isEmpty()) return false;
        return password.length() >= minLength && password.length() <= maxLength;
    }

    public static boolean checkUppercase(String password) {
        if (password == null || password.isEmpty()) return false;
        for (int i=0; i<password.length(); i++){
           if(Character.isUpperCase(password.charAt(i))) {
               return true;
           }
        }
        return false;
    }

    public static boolean checkSpecialSymbols(String password) {
        if (password == null || password.isEmpty()) return false;
        for (int i=0; i<password.length(); i++){
            for (char specialSymbol : specialSymbols) {
                if (password.charAt(i) == specialSymbol) return true;
            }
        }
        return false;
    }

    public static boolean validate (String  password, int min, int max){
        return checkSpecialSymbols(password) && checkUppercase(password) && checkLength(password,min,max);
    }
}
