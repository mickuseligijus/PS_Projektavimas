package model;

public class Country {
    public String getCode() {
        return code;
    }

    public int getNumberLength() {
        return numberLength;
    }


    public String getPhoneCode() {
        return phoneCode;
    }

    public String getLocalPhoneCode() {
        return localPhoneCode;
    }

    public Country(String code, int numberLength, String phoneCode, String localPhoneCode){
        this.code = code;
        this.numberLength = numberLength;
        this.phoneCode = phoneCode;
        this.localPhoneCode = localPhoneCode;
    }

    private String code;
    private int numberLength;
    private String phoneCode;
    private String localPhoneCode;


}
