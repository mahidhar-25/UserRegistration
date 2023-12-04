package com.bridgelabz.userregistration;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class UserValidationTest {
    private UserValidation userValidation;
/*
@desc : setting up the user validation class before every test
 */
    @Before
    public void setup(){
        userValidation = new UserValidation();
    }
/*
@desc : verifying all possible valid emails all are validating or not with the help of streams
this also satisfies for use case 10 parametrized testing
 */
    @Test
    public void allCorrectEmailsShouldPassTheTest() throws UserInvalidException {
        // Valid emails
        String[] validEmailArray = {
                "abc@yahoo.com",
                "abc-100@yahoo.com",
                "abc.100@yahoo.com",
                "abc111@abc.com",
                "abc-100@abc.net",
                "abc.100@abc.com.au",
                "abc@1.com",
                "abc@gmail.com.com",
                "abc+100@gmail.com"
        };
        int noOfCasesFailed=0;
        noOfCasesFailed = (int) Arrays.stream(validEmailArray).map(email -> {
            try {
                return userValidation.validateEmail(email);
            } catch (UserInvalidException e) {
                assertEquals(UserInvalidError.EMAIL, e.error);
                return false;
            }
        }).filter((emailOutput) -> !emailOutput).count();

        assertEquals(0 , noOfCasesFailed);
    }
    /*
    @desc : verifying all possible invalid emails all are validating to false or not with the help of streams
    this also satisfies for use case 10 parametrized testing
     */
    @Test
    public void allWrongEmailsShouldFailTheTest(){
        // inValid emails
        String[] invalidEmailArray = {
                "abc",
                "abc@.com.my",
                "abc123@gmail.a",
                "abc123@.com",
                "abc123@.com.com",
                ".abc@abc.com",
                "abc()*@gmail.com",
                "abc@%*.com",
                "abc..2002@gmail.com",
                "abc.@gmail.com",
                "abc@abc@gmail.com",
                "abc@gmail.com.1a",
                "abc@gmail.com.aa.au"
        };
        int noOfCasesPassed=0;
            noOfCasesPassed = (int) Arrays.stream(invalidEmailArray).map(email -> {
                        try {
                            return userValidation.validateEmail(email);
                        } catch (UserInvalidException e) {
                            assertEquals(UserInvalidError.EMAIL, e.error);
                            return false;
                        }
                    })
                    .filter((emailOutput) -> emailOutput).count();

        assertEquals(0 , noOfCasesPassed);
    }
    /*
    @desc : verifying all possible valid user all are validating or not with 
     */
    @Test
    public void happyTest() throws UserInvalidException {
        User user = new User("Mahidhar" , "Reddy" ,
                "9876541230" ,  "mahi@gmail.com" , "Mahidhar#25");
        boolean isValidated = true;
        try{
            isValidated =  userValidation.validateUser(user);
        }catch(UserInvalidException e) {
            assertEquals(UserInvalidError.USER, e.error);
        }
        assertTrue(isValidated);
    }
    /*
    @desc : verifying all possible invalid users all are validating to false or not sadTestFailForFirstName
     */
    @Test
    public void sadTestFailForFirstName() throws UserInvalidException {
        User user = new User("mahidhar" , "Reddy" ,
                "9876541230" ,  "mahi@gmail.com" , "Mahidhar#25");
        boolean isValidated = true;
        try{
            isValidated =  userValidation.validateUser(user);
        }catch(UserInvalidException e) {
            assertEquals(UserInvalidError.FIRSTNAME, e.error);
            isValidated = false;
        }
        assertFalse(isValidated);
    }
    /*
@desc : verifying all possible invalid users all are validating to false or not sadTestFailForLastName
 */
    @Test
    public void sadTestFailForLastName() throws UserInvalidException {
        User user = new User("Mahidhar" , "Re" ,
                "9876541230" ,  "mahi@gmail.com" , "Mahidhar#25");
        boolean isValidated = true;
        try{
            isValidated =  userValidation.validateUser(user);
        }catch(UserInvalidException e) {
            assertEquals(UserInvalidError.LASTNAME, e.error);
            isValidated = false;
        }
        assertFalse(isValidated);
    }
    /*
@desc : verifying all possible invalid users all are validating to false or not sadTestFailForEmail
 */
    @Test
    public void sadTestFailForEmail() throws UserInvalidException {
        User user = new User("Mahidhar" , "Reddy" ,
                "9876541230" ,  "mahi@gmail.com.ac.in" , "Mahidhar#25");
        boolean isValidated = true;
        try{
            isValidated =  userValidation.validateUser(user);
        }catch(UserInvalidException e) {
            assertEquals(UserInvalidError.EMAIL, e.error);
            isValidated = false;
        }
        assertFalse(isValidated);
    }
    /*
@desc : verifying all possible invalid users all are validating to false or not sadTestFailPhoneNumber
 */
    @Test
    public void sadTestFailPhoneNumber() throws UserInvalidException {
        User user = new User("Mahidhar" , "Reddy" ,
                "98765412301" ,  "mahi@gmail.com" , "Mahidhar#25");
        boolean isValidated = true;
        try{
            isValidated =  userValidation.validateUser(user);
        }catch(UserInvalidException e) {
            assertEquals(UserInvalidError.PHONENUMBER, e.error);
            isValidated = false;
        }
        assertFalse(isValidated);
    }
    /*
@desc : verifying all possible invalid users all are validating to false or not sadTestFailPassword
 */
    @Test
    public void sadTestFailPassword() throws UserInvalidException {
        User user = new User("Mahidhar" , "Reddy" ,
                "9876502301" ,  "mahi@gmail.com" , "Mahidhar25");
        boolean isValidated = true;
        try{
            isValidated =  userValidation.validateUser(user);
        }catch(UserInvalidException e) {
            assertEquals(UserInvalidError.PASSWORD, e.error);
            isValidated = false;
        }
        assertFalse(isValidated);
    }
}