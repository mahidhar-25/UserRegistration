package com.bridgelabz.userregistration;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidation {
    public static final String FIRST_NAME_REGEX = "[A-Z][A-Za-z]{2}[A-Za-z]*";
    public static final String LAST_NAME_REGEX = "[A-Z][A-Za-z]{2}[A-Za-z]*";

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
}
