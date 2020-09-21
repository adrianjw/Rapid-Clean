package com.uts.rapid.clean.controller;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpSession;

public class Validator implements Serializable {
    
    private String emailPattern = "([a-zA-Z0-9]+)(([._-])([a-zA-Z0-9]+))*(@)([a-z]+)(.)([a-z]{3})((([.])[a-z]{0,2})*)";
    private String passwordPattern = "[a-zA-Z0-9!@#$%^&*]{8,}";
    private String namePattern = "[A-Z][a-z]+";
    
    public Validator() {}
    
    public boolean validate(String pattern, String input) {
       Pattern regEx = Pattern.compile(pattern);
       Matcher match = regEx.matcher(input);
       return match.matches();
    }
    
    public boolean validateEmail(String value) {
       return validate(emailPattern, value) && value.length() <= 50;
    }
    
    public boolean validatePassword(String value) {
       return validate(passwordPattern, value) && value.length() <= 30;
    }
    
    public boolean validateName(String value) {
       return validate(namePattern, value) && value.length() <= 30;
    }
    
    public void clear(HttpSession session) {
        
    }
}
