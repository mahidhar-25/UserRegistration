package com.bridgelabz.userregistration;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("!!! welcome to user registration validation problem !!!");
        Scanner input = new Scanner(System.in);
        boolean isInputValidated = false;

        UserValidation userValidation = new UserValidation();

        //Usecase 1
        String firstName="" ;

        while (!isInputValidated) {
            System.out.println("enter your first name : \n " +
                    "1. First letter should be caps \n" +
                    " 2. firstName should be min of 3 char  ");
            firstName = input.next();
            try {
                if(userValidation.validateFirstName(firstName)){
                    System.out.println(firstName + " has passed firstname validation ");
                    isInputValidated = true;
                }
            } catch (UserInvalidException e) {
                System.out.println("Exception: " + e.getMessage() + ", Error: " + e.error);
            }
        }
        //Usecase 2
        String lastName="" ;
        isInputValidated = false;
        while (!isInputValidated) {
            System.out.println("enter your last name : \n 1. First letter should be caps \n 2. lastName should be min of 3 char  ");

            lastName = input.next();
            try {
                if (userValidation.validateLastName(lastName)) {
                    System.out.println(lastName + " has passed lastname validation ");
                    isInputValidated = true;
                }
            }catch (UserInvalidException e) {
                System.out.println("Exception: " + e.getMessage() + ", Error: " + e.error);
            }
        }
        //Usecase 3
        String email="" ;
        isInputValidated = false;
        while (!isInputValidated) {
            System.out.println("enter your email : \n 1. First letter should not be special char \n " +
                    "2. email should have TDL at most 2 domains(.com , .in) \n " +
                    "3. It should not  have and alphanumeric , + , . , -  only these characters are allowed");

            email = input.next();
            try {
                if (userValidation.validateEmail(email)) {
                    System.out.println(email + " has passed email validation ");
                    isInputValidated = true;
                }
            }catch (UserInvalidException e) {
                System.out.println("Exception: " + e.getMessage() + ", Error: " + e.error);
            }
        }

        //Usecase 4
        String phoneNumber="" ;
        isInputValidated = false;
        while (!isInputValidated) {
            System.out.println("enter your phone number : \n 1. Country code should be 91 / 0 (if landline) \n " +
                    "2. phone number should start with 7 , 8 , 9 \n " +
                    "3. Phone number should have exactly 10 digits");

            phoneNumber = input.next();
            try {
                if (userValidation.validatePhoneNumber(phoneNumber)) {
                    System.out.println(phoneNumber + " has passed phoneNumber validation ");
                    isInputValidated = true;
                }
            }catch (UserInvalidException e) {
                System.out.println("Exception: " + e.getMessage() + ", Error: " + e.error);
            }
        }


     //   Usecase 5 , 6 , 7 , 8
        String password="" ;
        isInputValidated = false;
        while (!isInputValidated) {
            System.out.print(
                    " 1. Password should contain at least 8 characters \n" +
                            " 2. Should have at least 1 Uppercase letter \n" +
                            " 3. Should have at least 1 numeric digit \n" +
                            " 4. Should have at least 1 special character \n" +
                            "\"enter your password : ");
            password = input.next();
            try {
                if (userValidation.validatePassword(password)) {
                    System.out.println(password + " has passed password validation ");
                    isInputValidated = true;
                }
            }catch (UserInvalidException e) {
                System.out.println("Exception: " + e.getMessage() + ", Error: " + e.error);
            }
        }


    }

}
