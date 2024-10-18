package com.example.training.myApp4.service;

import com.example.training.myApp4.entity.User;
import com.example.training.myApp4.exception.BaseException;
import com.example.training.myApp4.exception.UserException;
import com.example.training.myApp4.mapper.UserMapper;
import com.example.training.myApp4.repository.UserRepository;
import com.example.training.myApp4.request.LoginRequest;
import com.example.training.myApp4.request.RegisterRequest;
import com.example.training.myApp4.request.UpdateUserRequest;
import com.example.training.myApp4.response.UpdateUserResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Log4j2
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Cacheable(value = "user", key = "#username", unless = "#result == null")
    public User  createUser(String username, String password){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        return userRepository.save(user);
    }

    public User login(LoginRequest request) throws BaseException {
        Optional<User> byUserName = userRepository.findByUsername(request.getEmail());

        if(byUserName.isEmpty()){
            throw UserException.passwordInvalid();
        }

        User user = byUserName.get();
        if(user.getUsername().isEmpty()){
            throw UserException.passwordInvalid();
        }
        return user;
    }


    public User findByUserName(RegisterRequest request){
        Optional<User> opt = userRepository.findByUsername(request.getUsername());
        if(opt.isPresent()){
            return opt.get();
        }else{
            return null;
        }
    }

    @CachePut(value = "user", key = "#username")
    public User updateUser(String username, String password) throws BaseException{

        Optional<User> opt = userRepository.findByUsername(username);
        if(opt.isEmpty()){
            throw UserException.emailIsnull();
        }
        User user = opt.get();
        user.setPassword(password);
        log.info("call updateUser");
        return userRepository.save(user);

    }
}
