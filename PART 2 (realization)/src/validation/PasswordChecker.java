package validation;

public class PasswordChecker {

    private static char[] specialSymbols = {'>','!',' ','?','-','+','*'};

    public static boolean checkLength(String password, int minLength, int maxLength) {
        return password.length()>= minLength && password.length()<=maxLength && password != null;
    }

    public static boolean checkUppercase(String password) {

        for (int i=0; i<password.length(); i++){
           if(Character.isUpperCase(password.charAt(i))) {
               return true;
           }
        }
        return false;
    }

    public static boolean checkSpecialSymbols(String password) {
        for (int i=0; i<password.length(); i++){
            for (int ii =0; ii<specialSymbols.length; ii++){
                if(password.charAt(i) == specialSymbols[ii]) return true;
            }
        }
        return false;
    }
}
