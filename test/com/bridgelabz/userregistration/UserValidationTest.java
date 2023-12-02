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
    public void allCorrectEmailsShouldPassTheTest(){
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
        int noOfCasesFailed = (int) Arrays.stream(validEmailArray).map(userValidation::validateEmail).filter((emailOutput) -> !emailOutput).count();
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
        int noOfCasesPassed = (int) Arrays.stream(invalidEmailArray).map(userValidation::validateEmail).filter((emailOutput) -> emailOutput).count();
        assertEquals(0 , noOfCasesPassed);
    }
    /*
    @desc : verifying all possible valid user all are validating or not with 
     */
    @Test
    public void happyTest(){
        User user = new User("Mahidhar" , "Reddy" ,
                "9876541230" ,  "mahi@gmail.com" , "Mahidhar#25");
        assertTrue(userValidation.validateUser(user));
    }
    /*
    @desc : verifying all possible invalid users all are validating to false or not sadTestFailForFirstName
     */
    @Test
    public void sadTestFailForFirstName(){
        User user = new User("mahidhar" , "Reddy" ,
                "9876541230" ,  "mahi@gmail.com" , "Mahidhar#25");
        assertFalse(userValidation.validateUser(user));
    }
    /*
@desc : verifying all possible invalid users all are validating to false or not sadTestFailForLastName
 */
    @Test
    public void sadTestFailForLastName(){
        User user = new User("Mahidhar" , "Re" ,
                "9876541230" ,  "mahi@gmail.com" , "Mahidhar#25");
        assertFalse(userValidation.validateUser(user));
    }
    /*
@desc : verifying all possible invalid users all are validating to false or not sadTestFailForEmail
 */
    @Test
    public void sadTestFailForEmail(){
        User user = new User("Mahidhar" , "Re" ,
                "9876541230" ,  "mahi@gmail.com.ac.in" , "Mahidhar#25");
        assertFalse(userValidation.validateUser(user));
    }
    /*
@desc : verifying all possible invalid users all are validating to false or not sadTestFailPhoneNumber
 */
    @Test
    public void sadTestFailPhoneNumber(){
        User user = new User("Mahidhar" , "Re" ,
                "98765412301" ,  "mahi@gmail.com" , "Mahidhar#25");
        assertFalse(userValidation.validateUser(user));
    }
    /*
@desc : verifying all possible invalid users all are validating to false or not sadTestFailPassword
 */
    @Test
    public void sadTestFailPassword(){
        User user = new User("Mahidhar" , "Re" ,
                "98765412301" ,  "mahi@gmail.com" , "Mahidhar25");
        assertFalse(userValidation.validateUser(user));
    }
}