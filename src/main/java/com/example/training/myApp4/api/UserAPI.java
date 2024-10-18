package com.example.training.myApp4.api;

import com.example.training.myApp4.business.UserBusiness;
import com.example.training.myApp4.entity.User;
import com.example.training.myApp4.exception.BaseException;
import com.example.training.myApp4.request.LoginRequest;
import com.example.training.myApp4.request.RegisterRequest;
import com.example.training.myApp4.request.UpdateUserRequest;
import com.example.training.myApp4.response.RegisterResponse;
import com.example.training.myApp4.response.UserLoginResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/myApp")
public class UserAPI {

    private final UserBusiness userBusiness;

    public UserAPI(UserBusiness userBusiness){
        this.userBusiness = userBusiness;
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest request) throws BaseException {
        RegisterResponse response = userBusiness.register(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<UserLoginResponse> login(@RequestBody LoginRequest request) throws BaseException{
        UserLoginResponse token = userBusiness.login(request);
        return new ResponseEntity<>(token,HttpStatus.OK);
    }

    @PostMapping("/updateUser")
    public ResponseEntity<User> updateUser(@RequestBody UpdateUserRequest request) throws BaseException{
        User response = userBusiness.updateUser(request);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

}
