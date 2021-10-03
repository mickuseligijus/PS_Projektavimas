package validation;

import model.Country;

import java.util.*;

public class PhoneValidator {

    private static List<Country> countriesList;

    static {
        countriesList = new ArrayList<Country>() {
        };
        countriesList.add(new Country("LT",8,"+370","8"));
    }

    interface Function {
        boolean isDigit(char a);
    }

    public static boolean validateNumbers(String number) {
        if (number == null || number.isEmpty()) return false;
        Function f = (char a) -> a >= '0' && a<='9';
            for (int i=0; i<number.length(); i++){
                if (!f.isDigit(number.charAt(i))){
                    if (i==0 && number.charAt(0)=='+') continue;
                    return false;
                }
            }
            return true;
    }

    public static boolean validatePrefix(String countryCode, String number) {
        if(number!=null && !number.isEmpty() && validateLength(countryCode,number)){
            for (Country country : countriesList) {
              if (countryCode == country.getCode()){
                  if(number.startsWith(country.getLocalPhoneCode()) || number.startsWith(country.getPhoneCode())){
                      return true;
                  }
              }
            }

        }
        return false;
    }

    public static boolean validateLength(String countryCode, String number) {

        if (number!=null && !number.isEmpty() && validateNumbers(number) ) {
            for (Country country : countriesList) {
                if (country.getCode() == countryCode) {

                    if (number.startsWith(country.getPhoneCode())) {
                        if (country.getNumberLength() == number.substring(country.getPhoneCode().length()).length()) {
                            return true;
                        }

                    } else if (number.startsWith(country.getLocalPhoneCode())) {
                        if (country.getNumberLength() == number.substring(country.getLocalPhoneCode().length()).length()) {
                            return true;
                        }
                    }
                }
            }

        }
        return false;
    }

    public static String replaceLocalCode (String countryCode, String number){
        if (number == null || number.isEmpty()) return "";
        if (validatePrefix(countryCode,number)){
            if (number.startsWith("8")) {
                return "+370" + number.substring(1);
            }
        }
        return number;
    }
}
