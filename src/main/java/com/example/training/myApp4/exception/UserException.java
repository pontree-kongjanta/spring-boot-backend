package com.example.training.myApp4.exception;

public class UserException extends BaseException{
    public UserException(String code) {
        super(code);
    }

    public static UserException requestIsNull(){
        return new UserException("register.request.null");
    }

    public static UserException passwordInvalid(){
        return new UserException("login.password.invalid");
    }

    public static UserException emailIsnull(){
        return new UserException("updateUser.email.null");
    }

    public static UserException insertFailed(){
        return new UserException("register.insert.failed");
    }
}
