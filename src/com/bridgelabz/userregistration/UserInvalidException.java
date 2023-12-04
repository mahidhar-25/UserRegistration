package com.bridgelabz.userregistration;

/*
@desc : it is an userinvalid exception class , all the user validation exception are handled here
 */

public class UserInvalidException extends Exception {
    UserInvalidError error;
/*
@desc : creating a customized exception , to throw erros and handle them accordingly
@params : UserInvalidError - error
          String - message;
 @return : no return
 */
    public UserInvalidException(UserInvalidError error, String message) {
        super(message);
        this.error = error;
    }

}
