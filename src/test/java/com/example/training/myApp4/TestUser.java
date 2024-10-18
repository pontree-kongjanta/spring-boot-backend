package com.example.training.myApp4;

import com.example.training.myApp4.entity.User;
import com.example.training.myApp4.request.RegisterRequest;
import com.example.training.myApp4.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Log4j2
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TestUser {

    @Autowired
    UserService userService;


    @Order(1)
    @Test
    void testSave() {

        RegisterRequest request = new RegisterRequest();
        request.setUsername(testData.name);
        request.setPassword(testData.passWord);
        User user = userService.createUser(testData.name,testData.passWord);

        Assertions.assertNotNull(user);

    }

    @Test
    @Order(2)
    public void testFindByName(){
        RegisterRequest request = new RegisterRequest();
        request.setUsername(testData.name);
        User user = userService.findByUserName(request);
        log.info("xxxx user:"+user);
        Assertions.assertNotNull(user);
    }

    interface testData{
        String name="gg";
        String passWord = "1234gg";
    }
}
