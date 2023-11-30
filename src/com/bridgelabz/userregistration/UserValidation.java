package com.bridgelabz.userregistration;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidation {
    public static final String FIRST_NAME_REGEX = "[A-Z][A-Za-z]{2}[A-Za-z]*";
    public static final String LAST_NAME_REGEX = "[A-Z][A-Za-z]{2}[A-Za-z]*";
    public static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9-+]*([.][A-Za-z0-9-]+)*@[A-Za-z0-9-]+([.][a-zA-Z][a-zA-Z]+)([.][a-zA-Z][a-zA-Z]+)?$";

    public static final String PHONE_NUMBER_REGEX = "(0|[+]91)?[7-9][0-9]{9}";
    /*
    @desc : function to validate whether entered first is name is valid or not
    @param : String - first name
    @return : boolean if it has match with regex pattern
     */
    public static boolean validateFirstName(String firstName){
        Pattern firstNameRegex = Pattern.compile(FIRST_NAME_REGEX);
        Matcher firstNameMatcher = firstNameRegex.matcher(firstName);
        return firstNameMatcher.matches();
    }

    /*
    @desc : function to validate whether entered last  name is valid or not
    @param : String - last name
    @return : boolean if it has match with regex pattern
     */
    public static boolean validateLastName(String lastName){
        Pattern lastNameRegex = Pattern.compile(LAST_NAME_REGEX);
        Matcher lastNameMatcher = lastNameRegex.matcher(lastName);
        return lastNameMatcher.matches();
    }

    /*
    @desc : function to validate whether entered email is valid or not
    @param : String - email
    @return : boolean if it has match with regex pattern
     */
    public static boolean validaEmail(String email){
        Pattern emailRegex = Pattern.compile(EMAIL_REGEX);
        Matcher emailMatcher = emailRegex.matcher(email);
        return emailMatcher.matches();
    }

    /*
 @desc : function to validate whether entered phone number is valid or not
 @param : String - phone number
 @return : boolean if it has match with regex pattern
  */
    public static boolean validaPhoneNumber(String phoneNumber){
        Pattern phoneNumberRegex = Pattern.compile(PHONE_NUMBER_REGEX);
        Matcher phoneNumberMatcher = phoneNumberRegex.matcher(phoneNumber);
        return phoneNumberMatcher.matches();
    }
}
