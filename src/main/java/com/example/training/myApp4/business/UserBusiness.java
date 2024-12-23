package com.example.training.myApp4.business;

import com.example.training.myApp4.entity.User;
import com.example.training.myApp4.exception.BaseException;
import com.example.training.myApp4.exception.UserException;
import com.example.training.myApp4.request.LoginRequest;
import com.example.training.myApp4.request.RegisterRequest;
import com.example.training.myApp4.request.UpdateUserRequest;
import com.example.training.myApp4.response.RegisterResponse;
import com.example.training.myApp4.response.UserLoginResponse;
import com.example.training.myApp4.service.TokenService;
import com.example.training.myApp4.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserBusiness {

    private final UserService userService;
    private final TokenService tokenService;
    private final  MessageBroker messageBroker;

    public UserBusiness(UserService userService, TokenService tokenService, MessageBroker messageBroker){
        this.userService = userService;
        this.tokenService = tokenService;

        this.messageBroker = messageBroker;
    }

    public RegisterResponse register(RegisterRequest request) throws BaseException {

        if(request.getEmail() == null){
            throw UserException.requestIsNull();
        }
        User user = userService.createUser(request.getEmail(),request.getPassword());
        RegisterResponse response = new RegisterResponse();
        response.setMessage("insert success");
        response.setEmail(user.getEmail());

        if(user.getEmail() == null){
            throw  UserException.insertFailed();
        }
        messageBroker.sendKafka(request);
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
