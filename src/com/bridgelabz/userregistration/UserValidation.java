package com.bridgelabz.userregistration;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidation{
    public static final String FIRST_NAME_REGEX = "[A-Z][A-Za-z]{2}[A-Za-z]*";
    public static final String LAST_NAME_REGEX = "[A-Z][A-Za-z]{2}[A-Za-z]*";
    public static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9-+]*([.][A-Za-z0-9-]+)*@[A-Za-z0-9-]+([.][a-zA-Z][a-zA-Z]+)([.][a-zA-Z][a-zA-Z]+)?$";

    public static final String PHONE_NUMBER_REGEX = "(0|[+]91)?[7-9][0-9]{9}";

    public static final String PASSWORD_REGEX = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[\\W])\\S{8,}$";


    /* \\W
    @desc : function to validate whether entered first is name is valid or not
    @param : String - first name
    @return : boolean if it has match with regex pattern
     */
    public  boolean validateFirstName(String firstName) throws UserInvalidException{
            if(firstName == null){
                throw new UserInvalidException(UserInvalidError.NULL, "first name should not be null");
            }
            Pattern firstNameRegex = Pattern.compile(FIRST_NAME_REGEX);
            Matcher firstNameMatcher = firstNameRegex.matcher(firstName);
             boolean isFirstNameValidated = firstNameMatcher.matches();
             if(!isFirstNameValidated){
                 throw new UserInvalidException(UserInvalidError.FIRSTNAME, "User First Name is Invalid");
             }
        return firstNameMatcher.matches();
    }

    /*
    @desc : function to validate whether entered last  name is valid or not
    @param : String - last name
    @return : boolean if it has match with regex pattern
     */
    public  boolean validateLastName(String lastName) throws UserInvalidException{
        if(lastName == null){
            throw new UserInvalidException(UserInvalidError.NULL, "last name should not be null");
        }

        Pattern lastNameRegex = Pattern.compile(LAST_NAME_REGEX);
        Matcher lastNameMatcher = lastNameRegex.matcher(lastName);
        boolean isLastNameValidated = lastNameMatcher.matches();
        if(!isLastNameValidated){
            throw new UserInvalidException(UserInvalidError.LASTNAME, "User last Name is Invalid");
        }
        return lastNameMatcher.matches();
    }

    /*
    @desc : function to validate whether entered email is valid or not
    @param : String - email
    @return : boolean if it has match with regex pattern
     */
    public  boolean validateEmail(String email) throws UserInvalidException{
        if(email == null){
            throw new UserInvalidException(UserInvalidError.NULL, "email should not be null");
        }
        Pattern emailRegex = Pattern.compile(EMAIL_REGEX);
        Matcher emailMatcher = emailRegex.matcher(email);
        boolean isEmailValidated = emailMatcher.matches();
        if(!isEmailValidated){
            throw new UserInvalidException(UserInvalidError.EMAIL, "User email is Invalid");
        }
        return emailMatcher.matches();
    }

    /*
 @desc : function to validate whether entered phone number is valid or not
 @param : String - phone number
 @return : boolean if it has match with regex pattern
  */
    public  boolean validatePhoneNumber(String phoneNumber) throws UserInvalidException{
        if(phoneNumber == null){
            throw new UserInvalidException(UserInvalidError.NULL, "phone number should not be null");
        }

        Pattern phoneNumberRegex = Pattern.compile(PHONE_NUMBER_REGEX);
        Matcher phoneNumberMatcher = phoneNumberRegex.matcher(phoneNumber);
        boolean isPhomeNumberValidated = phoneNumberMatcher.matches();
        if(!isPhomeNumberValidated){
            throw new UserInvalidException(UserInvalidError.PHONENUMBER, "User Phone Number is Invalid");
        }
        return phoneNumberMatcher.matches();
    }

    /*
@desc : function to validate whether entered password is valid or not
@param : String - password
@return : boolean if it has match with regex pattern
*/
    public  boolean validatePassword(String password) throws UserInvalidException{
        if(password == null){
            throw new UserInvalidException(UserInvalidError.NULL, "password  should not be null");
        }
        Pattern passwordRegex = Pattern.compile(PASSWORD_REGEX);
        Matcher passwordMatcher = passwordRegex.matcher(password);

        boolean isPasswordValidated = passwordMatcher.matches();
        if(!isPasswordValidated){
            throw new UserInvalidException(UserInvalidError.PASSWORD, "User Password is Invalid");
        }
        return passwordMatcher.matches();
    }

    /*
@desc : function to validate whether entered password is valid or not
@param : String - password
@return : boolean if it has match with regex pattern
*/
    public  boolean validateUser(User newUser) throws UserInvalidException{
        if(newUser == null){
            throw new UserInvalidException(UserInvalidError.NULL, "User should not be null");
        }
        boolean isValidationPassed = false;

            isValidationPassed = validateFirstName(newUser.getFirstName())&&
                    validateLastName(newUser.getLastName())&&
                    validateEmail(newUser.getEmailId())&&
                    validatePhoneNumber(newUser.getPhoneNumber())&&validatePassword(newUser.getPassword());

        return isValidationPassed;
    }


}
