package validation;

public class EmailValidator {

    interface Function {
        boolean isLetterOrDigit(char a);
    }

    public static boolean validateAt(String s) {
        return false;
    }

    public static boolean validateSymbols(String email) {

        Function f = (char a) -> {
            return (a >= 'a' && a <= 'z') || (a >= 'A' && a <= 'Z') || (a >= '0' && a<='9');
        };

        if (email.isEmpty()) {
            return false;
        }
        else {
            if (!f.isLetterOrDigit(email.charAt(0))) {
                return false;
            }
            if (email.indexOf('@')<0) {
                return false;
            }

            int i = email.indexOf('@');
            if (i == email.length()-1) {
                return false;
            }
            if(!f.isLetterOrDigit(email.charAt(i-1))){
                return false;
            }

            for (int ii=0; ii<email.length(); ii++){
                if (!f.isLetterOrDigit(email.charAt(ii))) {
                    if (ii ==0 || ii==email.length()-1) {
                        return false;
                    }
                    String symbols = "!#$%&'*+-/=?^_`{|}~.";
                    if (symbols.indexOf(email.charAt(ii))<0 && email.charAt(ii)!='@'){
                        return false;
                    }
                    if(!f.isLetterOrDigit(email.charAt(ii-1)) || !f.isLetterOrDigit(email.charAt(ii+1))){
                        return false;
                    }
                    if(email.charAt(ii-1) == email.charAt(ii) || email.charAt(ii+1) == email.charAt(ii)) {
                        return false;
                    }
                }
                }


        }
        return true;
    }

    public static boolean validateServer(String s) {
        return false;
    }

    public static boolean validateTLD(String email) {
        return false;
    }
}
