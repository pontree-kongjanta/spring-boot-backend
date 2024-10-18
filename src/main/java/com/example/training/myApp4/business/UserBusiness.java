package com.example.training.myApp4.business;

import com.example.training.myApp4.entity.User;
import com.example.training.myApp4.exception.BaseException;
import com.example.training.myApp4.exception.UserException;
import com.example.training.myApp4.request.LoginRequest;
import com.example.training.myApp4.request.RegisterRequest;
import com.example.training.myApp4.request.UpdateUserRequest;
import com.example.training.myApp4.response.RegisterResponse;
import com.example.training.myApp4.response.UpdateUserResponse;
import com.example.training.myApp4.response.UserLoginResponse;
import com.example.training.myApp4.service.TokenService;
import com.example.training.myApp4.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserBusiness {

    private final UserService userService;
    private final TokenService tokenService;

    public UserBusiness(UserService userService, TokenService tokenService){
        this.userService = userService;
        this.tokenService = tokenService;
    }

    public RegisterResponse register(RegisterRequest request) throws BaseException {

        if(request.getUsername() == null){
            throw UserException.requestIsNull();
        }
        User user = userService.createUser(request.getUsername(),request.getPassword());
        RegisterResponse response = new RegisterResponse();
        response.setMessage("insert success");
        response.setUserName(user.getUsername());
        return response;
    }

    public UserLoginResponse login(LoginRequest request) throws BaseException{
        User user = userService.login(request);
        String token = tokenService.tokenize(user);

        UserLoginResponse response = new UserLoginResponse();
        response.setToken(token);

        return response;
    }

    public User updateUser(UpdateUserRequest request) throws BaseException{
        return userService.updateUser(request.getUsername(),request.getPassword());
    }

}
