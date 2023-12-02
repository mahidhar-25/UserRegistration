package com.bridgelabz.userregistration;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

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
}