package com.mif.vu.validateapp.service;

public class Validator {
    private final String[] specialChars = { ",", ".", "~", "!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "_", "-", "+", "=" };
    private final String[] numbers = { "1" , "2", "3", "4", "5", "6", "7", "8", "9", "0" };

    public boolean validatePassword(String password) {
        final int minLength = 6;

        // Is length correct
        if (password.length() < minLength)
            return false;
        
        // Has any uppercase characters
        if (password.toLowerCase() == password)
            return false;
        
        // Contains any special characters
        for (String c : specialChars) {
            if (password.contains(c))
                return true;
        }

        for (String n : numbers) {
            if (password.contains(n))
                return true;
        }

        return false;
    }

    public boolean validatePhone(String number) {
        final int minLength = 4;

        // Is length correct
        if (number.length() < minLength)
            return false;
        
        // Does number contain non-numeric symbols
        try {
            Double.parseDouble(number);
        } catch (NumberFormatException nfe) {
            return false;
        }

        return true;
    }

    public boolean validateEmail(String email) {
        int posEta = email.indexOf("@");
        if (posEta < 0) // Contains an @?
            return false;
        
        String localPart = email.substring(0, posEta);
        if (localPart.length() == 0) // Has a local part?
            return false;
        
        String domain = email.substring(posEta + 1);
        if (domain.length() == 0) // Has a domain?
            return false;
        
        if (domain.indexOf("@") != -1) // Has more than one @?
            return false;
        
        // Contains any invalid special characters
        for (String c : specialChars) {
            if (c.equals(".")) 
                continue;

            if (domain.contains(c))
                return false;
        }

        int posTLD = domain.indexOf(".");
        if (posTLD < 0) // Contains a TLD?
            return false;
        
        String TLD = domain.substring(posTLD);
        if (TLD.length() == 0) // TLD is non-zero length?
            return false;
    
        // TLD contains numbers?
        for (String n : numbers) {
            if (TLD.contains(n))
                return false;
        }

        if (TLD.indexOf(".") != -1) // TLD contains extra .'s
            return false;

        return true;
    }


}
