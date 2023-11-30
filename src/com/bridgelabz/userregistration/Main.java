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

        while (isInputValidated) {
            firstName = input.next();
            if(UserValidation.validateFirstName(firstName)){
                System.out.println(firstName + " has passed validation ");
                isInputValidated = true;
            }else{
                System.out.println("Your Previous input " + firstName + " did not meet our rules");
                System.out.println("Enter First Name according to the rules : ");
                isInputValidated = false;
            }
        }




    }

}
