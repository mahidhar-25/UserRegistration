package com.bridgelabz.userregistration;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("!!! welcome to user registration validation problem !!!");
        Scanner input = new Scanner(System.in);
        int wrongInputCounter = 0;
        boolean isInputValidated = false;

        //Usecase 1
        String firstName="" ;
        System.out.println("enter your first name : \n 1. First letter should be caps \n 2. firstName should be min of 3 char  ");

        while (!isInputValidated) {
            firstName = input.next();
            if(UserValidation.validateFirstName(firstName)){
                System.out.println(firstName + " has passed firstname validation ");
                isInputValidated = true;
            }else{
                System.out.println("Your Previous input " + firstName + " did not meet our rules");
                System.out.println("Enter First Name according to the rules : ");
            }
        }
        //Usecase 2
        String lastName="" ;
        System.out.println("enter your last name : \n 1. First letter should be caps \n 2. lastName should be min of 3 char  ");
       isInputValidated = false;
        while (!isInputValidated) {
            lastName = input.next();
            if(UserValidation.validateLastName(lastName)){
                System.out.println(lastName + " has passed lastname validation ");
                isInputValidated = true;
            }else{
                System.out.println("Your Previous input " + lastName + " did not meet our rules");
                System.out.println("Enter Last Name according to the rules : ");
            }
        }
        //Usecase 3
        String email="" ;
        System.out.println("enter your email : \n 1. First letter should not be special char \n " +
                "2. email should have TDL at most 2 domains(.com , .in) \n " +
                "3. It should not  have and alphanumeric , + , . , -  only these characters are allowed");
        isInputValidated = false;
        while (!isInputValidated) {
            email = input.next();
            if(UserValidation.validaEmail(email)){
                System.out.println(email + " has passed email validation ");
                isInputValidated = true;
            }else{
                System.out.println("Your Previous input " + email + " did not meet our rules");
                System.out.println("Enter email according to the rules : ");
            }
        }



    }

}
