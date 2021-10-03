package validation;

public class EmailValidator {

    interface Function {
        boolean isLetterOrDigit(char a);
    }

    public static boolean validateAt(String email) {
        return validateSymbols(email) && validateServer(email) && validateTLD(email);
    }

    public static boolean validateSymbols(String email) {
        if (email==null || email.isEmpty()) return false;
        Function f = (char a) -> {
            return (a >= 'a' && a <= 'z') || (a >= 'A' && a <= 'Z') || (a >= '0' && a<='9');
        };

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
                }
                }
        return true;
    }

    public static boolean validateServer(String email) {
        if (email==null || email.isEmpty()) return false;
        Function f = (char a) -> {
            return (a >= 'a' && a <= 'z') || (a >= 'A' && a <= 'Z') || (a >= '0' && a<='9');
        };

        if (email.lastIndexOf('.')<0 || email.indexOf('@')<0) {
            return false;
        }
        else {
            if (email.lastIndexOf('.') > email.indexOf('@') ) {
                String domain = email.substring(email.indexOf('@') + 1, email.lastIndexOf('.'));
                if (domain.length()>253 || domain.length()==0) {
                    return false;
                }

                for (int i = 0; i < domain.length(); i++) {
                    if (!f.isLetterOrDigit(domain.charAt(i))) {
                        if (domain.charAt(i) == '.' || domain.charAt(i) == '-') {
                            if (i != 0 && i != domain.length() - 1) {
                                if (!f.isLetterOrDigit(domain.charAt(i - 1)) || !f.isLetterOrDigit(domain.charAt(i + 1))) {
                                    return false;
                                }
                            }
                        }
                        if (domain.charAt(i) != '.' || domain.charAt(i) != '-') {
                            return false;
                        }

                    }
                }

            }
            else return false;
        }

        return true;
    }

    public static boolean validateTLD(String email) {
        if (email==null || email.isEmpty()) return false;
        Function f = (char a) -> {
            return (a >= 'a' && a <= 'z') || (a >= 'A' && a <= 'Z') || (a >= '0' && a<='9');
        };

        if (email.lastIndexOf('.')<0 || email.indexOf('@')<0) {
            return false;
        }
        else {
            if (email.lastIndexOf('.') < email.indexOf('@')){
                return false;
            }
            if (email.lastIndexOf('.') > email.indexOf('@')) {
                String tld = email.substring(email.lastIndexOf('.') + 1);
                if (tld.length() < 2) {
                    return false;
                }
                if (tld.charAt(0) >= '0' && tld.charAt(0) <= '9') {
                    return false;
                }
                for (int i = 0; i < tld.length(); i++) {
                    if (!f.isLetterOrDigit(tld.charAt(i))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
