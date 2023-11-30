package com.bridgelabz.userregistration;

public class User {
    String firstName;
    String lastName;
    String phoneNumber;
    String emailId;
    /*

     @desc :  Gets the first name of the user.
     @params : no params
     @return The first name of the user.
     */

    public String getFirstName() {
        return firstName;
    }
    /*
     @desc :  Sets the first name of the user.
     @param firstName The new first name to set.
     @return : void
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    /*
    @desc :  Gets the last name of the user.
    @params : no params
    @return The last name of the user.
     */
    public String getLastName() {
        return lastName;
    }
    /*
    @desc :  Sets the last name of the user.
    @param lastName The new last name to set.
     @return : void
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    /*
     @desc :  Gets the phone number of the user.
      @params : no params
     @return The phone number of the user.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }
    /*
     @desc :  Sets the phone number of the user.
      @param phoneNumber The new phone number to set.
       @return : void
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    /*
     @desc :  Gets the email ID of the user.
      @params : no params
     @return The email ID of the user.
     */
    public String getEmailId() {
        return emailId;
    }
    /*
     @desc :  Sets the email ID of the user.
     @param emailId The new email ID to set.
      @return : void
     */
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}
