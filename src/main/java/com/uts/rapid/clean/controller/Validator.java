package com.uts.rapid.clean.controller;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpSession;

public class Validator implements Serializable {
    
    private String namePattern = "[A-Z][a-z]+";
    private String emailPattern = "([a-zA-Z0-9]+)(([._-])([a-zA-Z0-9]+))*(@)([a-z]+)(.)([a-z]{3})((([.])[a-z]{0,2})*)";
    private String passwordPattern = "[a-zA-Z0-9!@#$%^&*]{8,}";
    private String phoneNumberPattern = "0[23478]\\d{8}";
    private String bankNumberPattern = "\\d{6}";
    private String bankNamePattern = "([A-Z][a-z]+)( [A-Z][a-z]+)*";
    private String streetAddressPattern = "[a-zA-Z0-9- ]+";
    private String suburbPattern = "[a-zA-Z ]+";
    private String postcodePattern = "\\d{4}";
    
    public Validator() {}
    
    public boolean validate(String pattern, String input) {
       Pattern regEx = Pattern.compile(pattern);
       Matcher match = regEx.matcher(input);
       return match.matches();
    }
    
    public boolean validateName(String value) {
       return validate(namePattern, value);
    }
    
    public boolean validateEmail(String value) {
       return validate(emailPattern, value);
    }
    
    public boolean validatePassword(String value) {
       return validate(passwordPattern, value);
    }
    
    public boolean validatePhoneNumber(String value) {
        return validate(phoneNumberPattern, value);
    }
    
    public boolean validateBankNumber(String value) {
        return validate(bankNumberPattern, value);
    }
    
    public boolean validateBankName(String value) {
        return validate(bankNamePattern, value);
    }
    
    public boolean validateStreetAddress(String value) {
        return validate(streetAddressPattern, value);
    }
    
    public boolean validateSuburb(String value) {
        return validate(suburbPattern, value);
    }
    
    public boolean validatePostcode(String value) {
        return validate(postcodePattern, value);
    }
    
    public void clear(HttpSession session) {
        session.setAttribute("firstNameError", "");
        session.setAttribute("lastNameError", "");
        session.setAttribute("emailError", "");
        session.setAttribute("passwordError", "");
        session.setAttribute("confirmPasswordError", "");
        session.setAttribute("phoneNumberError", "");
        session.setAttribute("bankBsbNumberError", "");
        session.setAttribute("bankAccountNumberError", "");
        session.setAttribute("bankAccountHolderNameError", "");
        session.setAttribute("streetAddressError", "");
        session.setAttribute("suburbError", "");
        session.setAttribute("postcodeError", "");
        session.setAttribute("addressExistError", "");
        session.setAttribute("loginError", "");
        session.setAttribute("actionResult", "");
    }
}
